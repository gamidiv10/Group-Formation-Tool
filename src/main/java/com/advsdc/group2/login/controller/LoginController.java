package com.advsdc.group2.login.controller;

import com.advsdc.group2.course.controller.HomePageController;
import com.advsdc.group2.login.models.UserCredentials;
import com.advsdc.group2.login.services.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model)
    {
        model.addAttribute("userCred", new UserCredentials());
        model.addAttribute("loginError", false);
        return "login";
    }

    @PostMapping("/home")
    public String loginSubmit(@ModelAttribute UserCredentials userCredentials, Model model)
    {
        LoginServiceImpl loginService = new LoginServiceImpl();
        boolean success = loginService.validateUser(userCredentials);
        String jsonWebToken;
        if(success) {
            jsonWebToken = loginService.generateJsonWebToken(userCredentials.getUserId());
            model.addAttribute("token", jsonWebToken);
            return new HomePageController().courseHome(jsonWebToken, model);
        }
        model.addAttribute("userCred", new UserCredentials());
        model.addAttribute("loginError", true);
        return "login";
    }

}
