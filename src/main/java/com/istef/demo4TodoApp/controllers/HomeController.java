package com.istef.demo4TodoApp.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user")
public class HomeController {


    @GetMapping("/")
    public String homePage(ModelMap model) {
        model.addAttribute("user", getCurrentUser());
        return "home-page";
    }

    private String getCurrentUser() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }


}
