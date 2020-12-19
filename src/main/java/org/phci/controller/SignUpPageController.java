package org.phci.controller;

import org.phci.core.model.account.Account;
import org.phci.core.model.account.RestTemplateAccountDao;
import org.phci.dto.SignUpForm;
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
@RequestMapping (value = "/signUp")
@SessionAttributes("email")
public class SignUpPageController {

    private static final String SIGN_UP_FORM = "signUpForm";
    private static final String EMAIL = "email";

    @Resource
    RestTemplateAccountDao accountDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showSignUpForm() {
        ModelAndView mav = new ModelAndView("signUp");
        mav.addObject(SIGN_UP_FORM, new SignUpForm());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView signUp(@ModelAttribute @Valid SignUpForm signUpForm, BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

        Account account = new Account();
        account.setEmail(signUpForm.getLogin());
        account.setPassword(signUpForm.getPassword());
        Account addedAccount = accountDao.addAccount(account);

        attributes.addFlashAttribute(EMAIL, account.getEmail());

        return new RedirectView( request.getContextPath() + "/productList");
    }
}
