package org.phci.controller;

import org.phci.core.model.book.Book;
import org.phci.core.model.book.RestTemplateBookDao;
import org.phci.core.model.cart.CartItem;
import org.phci.core.model.favorite.Favorite;
import org.phci.core.model.favorite.RestTemplateFavoriteDao;
import org.phci.core.model.order.Order;
import org.phci.core.model.order.RestTemplateOrderDao;
import org.phci.dto.AddToCartForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping (value = "/favorites")
@SessionAttributes("email")
public class FavoritesPageController {

    private static final String FAVORITES = "favorites";
    private static final String BOOK_COVER_LIST = "bookCoverList";

    @Resource
    RestTemplateBookDao bookDao;

    @Resource
    RestTemplateFavoriteDao favoriteDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showFavs(@ModelAttribute("email") String email, Model model) {
        //List<Favorite> favorites = favoriteDao.get(email);
        List<Book> favorites = Arrays.asList(new Book(2, "Pride and Prejudice", "Jane Austen", "romance", "Set in a small English village during 1812, this classic novel is one of the greatest love stories ever told! A poor country squire is trying to find husbands for his five daughters. When one of them, Elizabeth, meets rich Mr. Darcy at a dance, they don't find much in common. But during the next few months, they overcome their differences and fall in love.", new BigDecimal("16.99"), "Harper Collins", true));
        //List<Integer> ids = favorites.stream().map(Favorite::getBook).collect(Collectors.toList());
        List<Integer> ids = favorites.stream().map(Book::getId).collect(Collectors.toList());
        //List<Book> books = new ArrayList<>();
        List<String> covers = new ArrayList<>();
        for (Integer key: ids) {
            try {
                covers.add(bookDao.getBookCover(key));
                //books.add(bookDao.get(key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute(BOOK_COVER_LIST, covers);
        model.addAttribute(FAVORITES, favorites);
        return "favorites";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{key}")
    public String cancel(@ModelAttribute("email") String email, @PathVariable Integer key) {
        favoriteDao.remove(email, key);
        return "favorites";
    }
}
