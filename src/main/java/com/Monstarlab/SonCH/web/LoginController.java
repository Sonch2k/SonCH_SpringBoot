package com.Monstarlab.SonCH.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/admin/login/form")
    public String loginForm(Model model) {
        return "login";
    }
    @RequestMapping("/admin/login/error")
    public String loginError(Model model) {
        model.addAttribute("message", "Error");
        return "index";
    }
    @RequestMapping("/admin/login/sucess")
    public String loginSuccessfull(Model model) {
        return "body";
    }
}
