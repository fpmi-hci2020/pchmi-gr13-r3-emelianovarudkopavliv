package org.phci.controller;

import org.phci.core.model.Account;
import org.phci.core.model.RestTemplateAccountDao;
import org.phci.dto.SignInForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping (value = "/signIn")
@SessionAttributes("email")
public class SignInPageController {

    private static final String SIGN_IN_FORM = "signInForm";
    private static final String EMAIL = "email";
    private static final String MESSAGE = "message";
    private static final String ERROR_MESSAGE = "Email or Password is wrong!";

    @Resource
    RestTemplateAccountDao accountDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showSignInForm() {
        ModelAndView mav = new ModelAndView("signIn");
        mav.addObject(SIGN_IN_FORM, new SignInForm());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView signIn(@ModelAttribute @Valid SignInForm signInForm, BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

        Account account = accountDao.get(signInForm.getLogin());
        if (account != null) {
            attributes.addFlashAttribute(EMAIL, account.getEmail());
        } else {
            attributes.addFlashAttribute(MESSAGE, ERROR_MESSAGE);
            return new RedirectView( request.getContextPath() + "/signIn");
        }
        return new RedirectView( request.getContextPath() + "/productList");
    }
}
