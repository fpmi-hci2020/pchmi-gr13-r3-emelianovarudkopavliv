package org.phci.controller;

import org.phci.core.model.book.Book;
import org.phci.core.model.book.RestTemplateBookDao;
import org.phci.core.model.cart.AddToCartItem;
import org.phci.core.model.cart.CartItem;
import org.phci.core.model.cart.RestTemplateCartDao;
import org.phci.core.model.order.Order;
import org.phci.core.model.order.RestTemplateOrderDao;
import org.phci.dto.AddToCartForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping (value = "/cart")
@SessionAttributes("email")
public class CartPageController {

    private static final String CARTITEMS = "cartItems";
    private static final String PAYMENTMETHODS = "paymentMethods";
    private static final String SHIPPINGMETHODS = "shippingMethods";
    private static final String ADD_TO_CART_FORM = "addToCartForm";
    private static final String BOOK_COVER_LIST = "bookCoverList";

    @Resource
    RestTemplateCartDao cartDao;

    @Resource
    RestTemplateBookDao bookDao;

    @Resource
    RestTemplateOrderDao orderDao;

    @ModelAttribute
    public void attachAddToCartForm(Model model) {
        model.addAttribute(ADD_TO_CART_FORM, new AddToCartForm());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCart(@ModelAttribute("email") String email, Model model) {
        List<CartItem> cartItems = cartDao.get(email);
        List<Book> books = cartItems.stream().map(CartItem::getBook).collect(Collectors.toList());
        List<Integer> ids = books.stream().map(Book::getId).collect(Collectors.toList());
        List<String> covers = new ArrayList<>();
        for (Integer key: ids) {
            try {
                covers.add(bookDao.getBookCover(key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute(BOOK_COVER_LIST, covers);
        model.addAttribute(CARTITEMS, cartItems);
        model.addAttribute(PAYMENTMETHODS, Arrays.asList("card", "cash"));
        model.addAttribute(SHIPPINGMETHODS, Arrays.asList("delivery", "collect"));
        model.addAttribute("totalCost", recalculateCart(cartItems));
        return "cart";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToCart(@ModelAttribute("email") String email, Model model, @ModelAttribute AddToCartForm addToCartForm ) {
        AddToCartItem addToCartItem = new AddToCartItem(email, addToCartForm.getBookId(), Integer.parseInt(addToCartForm.getQuantity()));
        cartDao.updateCart(addToCartItem);
        return "redirect:/cart";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/placeOrder")
    public String placeOrder(@ModelAttribute("email") String email,
                             @RequestParam("payment") String payment,
                             @RequestParam("shipping") String shipping) {
        List<CartItem> cartItems = cartDao.get(email);
        Order order = new Order();
        order.setId(1);
        order.setAccount(email);
        order.setPayment_method(payment);
        order.setShipping_method(shipping);
        order.setPrice(recalculateCart(cartItems));
        order.setBooks(cartItems);
        order.setDate_placed(new Date());
        order.setDate_delivered(new Date());
        orderDao.placeOrder(order);
        return "redirect:/orders";
    }

    private BigDecimal recalculateCart(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(cartItem -> new BigDecimal(cartItem.getQuantity()).multiply(cartItem.getBook().getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
