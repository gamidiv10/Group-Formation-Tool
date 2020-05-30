package com.advsdc.group2.login.controller;

import com.advsdc.group2.login.models.UserCredentials;
import com.advsdc.group2.login.services.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

//    @RequestMapping("/login.html")
//    public String loginForm(Model model)
//    {
//        return "login.html";
//    }
//
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }
    @GetMapping("/login")
    public String loginForm(Model model)
    {
        model.addAttribute("userCred", new UserCredentials());
        model.addAttribute("loginError", false);
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute UserCredentials userCredentials, Model model)
    {
        LoginServiceImpl loginService = new LoginServiceImpl();
        boolean success = loginService.validateUser(userCredentials);
        String jsonWebToken;
        if(success) {
            jsonWebToken = loginService.generateJsonWebToken(userCredentials.getUserId());
            return "result";
        }
        model.addAttribute("userCred", new UserCredentials());
        model.addAttribute("loginError", true);
        return "login";
    }

}
