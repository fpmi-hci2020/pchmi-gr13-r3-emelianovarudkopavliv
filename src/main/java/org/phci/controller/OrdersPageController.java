package org.phci.controller;

import org.phci.core.model.book.Book;
import org.phci.core.model.book.RestTemplateBookDao;
import org.phci.core.model.cart.CartItem;
import org.phci.core.model.order.Order;
import org.phci.core.model.order.RestTemplateOrderDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping (value = "/orders")
@SessionAttributes("email")
public class OrdersPageController {

    private static final String ORDER = "order";
    private static final String BOOK_COVER_LIST = "bookCoverList";

    @Resource
    RestTemplateBookDao bookDao;

    @Resource
    RestTemplateOrderDao orderDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showOrders(@ModelAttribute("email") String email, Model model) {
        List<Order> order = orderDao.get(email);
        if (order != null) {
            //List<Book> books = order.getBooks().stream().map(CartItem::getBook).collect(Collectors.toList());
            List<Book> books = order.get(0).getBooks().stream().map(CartItem::getBook).collect(Collectors.toList());
            List<Integer> ids = books.stream().map(Book::getId).collect(Collectors.toList());
            List<String> covers = new ArrayList<>();
            for (Integer key : ids) {
                try {
                    covers.add(bookDao.getBookCover(key));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            model.addAttribute(BOOK_COVER_LIST, covers);
            model.addAttribute(ORDER, order);
        }
        return "orders";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{key}")
    public String cancel(@ModelAttribute("email") String email, @PathVariable Integer key) {
        orderDao.cancel(key);
        return "orders";
    }
}
