package org.phci.controller;

import org.phci.core.model.Book;
import org.phci.core.model.RestTemplateBookDao;
import org.phci.dto.AddToCartForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping (value = "/productList")
@SessionAttributes("email")
public class ProductListPageController {

    private static final String BOOKS = "books";
    private static final String ADD_TO_CART_FORM = "addToCartForm";
    private static final String QUERY_PRODUCT = "queryProduct";
    private static final String SEARCH_FIELD = "searchField";
    private static final String DEFAULT_QUERY_PRODUCT = "";
    private static final String DEFAULT_SEARCH_FIELD = "title";
    private static final String BOOK_COVER_LIST = "bookCoverList";

    @Resource
    RestTemplateBookDao bookDao;

    @ModelAttribute
    public void attachAddToCartForm(Model model) {
        model.addAttribute(ADD_TO_CART_FORM, new AddToCartForm());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showProductList(@RequestParam(required = false) Map<String, String> params, Model model) {
        List<Book> books = bookDao.findAll(
                Objects.toString(params.get(QUERY_PRODUCT), DEFAULT_QUERY_PRODUCT),
                Objects.toString(params.get(SEARCH_FIELD), DEFAULT_SEARCH_FIELD));
        model.addAttribute(BOOKS, books);
        List<Long> ids = books.stream().map(Book::getId).collect(Collectors.toList());
        List<String> covers = new ArrayList<>();
        for (Long key: ids) {
            try {
                covers.add(bookDao.getBookCover(key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute(BOOK_COVER_LIST, covers);
        return "productList";
    }
}
