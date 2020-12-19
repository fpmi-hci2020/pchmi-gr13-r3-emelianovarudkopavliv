package org.phci.controller;

import org.phci.core.model.book.Book;
import org.phci.core.model.book.RestTemplateBookDao;
import org.phci.core.model.cart.AddToCartItem;
import org.phci.core.model.cart.CartItem;
import org.phci.core.model.cart.RestTemplateCartDao;
import org.phci.core.model.favorite.Favorite;
import org.phci.core.model.favorite.RestTemplateFavoriteDao;
import org.phci.dto.AddToCartForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/productDetails")
@SessionAttributes("email")
public class ProductDetailsPageController {
    private static final String BOOK = "book";
    private static final String ADD_TO_CART_FORM = "addToCartForm";
    private static final String BOOK_COVER = "bookCover";
    private static final Integer DEFAULT_QUANTITY = 1;

    @Resource
    RestTemplateCartDao cartDao;

    @Resource
    RestTemplateBookDao bookDao;

    @Resource
    RestTemplateFavoriteDao favoriteDao;

    @ModelAttribute
    public void phoneToCart(Model model) {
        model.addAttribute(ADD_TO_CART_FORM, new AddToCartForm());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{key}")
    public String showProductDetails(@ModelAttribute("email") String email, @PathVariable Integer key, Model model) throws IOException {
        model.addAttribute(BOOK, bookDao.get(key));
        model.addAttribute(BOOK_COVER, bookDao.getBookCover(key));
        return "productDetails";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{key}/toCart")
    public String addToCart(@ModelAttribute("email") String email, @PathVariable Integer key) {
        AddToCartItem addToCartItem = new AddToCartItem(email, key, DEFAULT_QUANTITY);
        List<CartItem> cartItems = cartDao.get(email);
        List<Book> books = cartItems.stream().map(CartItem::getBook).collect(Collectors.toList());
        if (books.stream().anyMatch(b -> b.getId().equals(key))) {
            cartDao.updateCart(addToCartItem);
        } else {
            cartDao.addToCart(addToCartItem);
        }
        return "redirect:/productDetails/{key}";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{key}/toFavorites")
    public String addToFavorites(@ModelAttribute("email") String email, @PathVariable Integer key) {
        Favorite favorite = new Favorite(email, key);
        favoriteDao.addFavorite(favorite);
        return "redirect:/productDetails/{key}";
    }
}
