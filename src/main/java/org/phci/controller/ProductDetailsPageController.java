package org.phci.controller;

import org.phci.core.model.RestTemplateBookDao;
import org.phci.dto.AddToCartForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping(value = "/productDetails")
@SessionAttributes("email")
public class ProductDetailsPageController {
    private static final String BOOK = "book";
    private static final String ADD_TO_CART_FORM = "addToCartForm";
    private static final String BOOK_COVER = "bookCover";

    @Resource
    RestTemplateBookDao bookDao;

    @ModelAttribute
    public void phoneToCart(Model model) {
        model.addAttribute(ADD_TO_CART_FORM, new AddToCartForm());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{key}")
    public String showProductDetails(@PathVariable Long key, Model model) throws IOException {
        model.addAttribute(BOOK, bookDao.get(key));
        model.addAttribute(BOOK_COVER, bookDao.getBookCover(key));
        return "productDetails";
    }
}
