package org.phci.controller;

import org.phci.core.model.news.News;
import org.phci.core.model.news.RestTemplateNewsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping (value = "/news")
@SessionAttributes("email")
public class NewsPageController {

    private static final String NEWS = "news";

    @Resource
    RestTemplateNewsDao newsDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showNews(@ModelAttribute("email") String email, Model model) {
        List<News> news = newsDao.get(email);
        model.addAttribute(NEWS, news);
        return "news";
    }
}
