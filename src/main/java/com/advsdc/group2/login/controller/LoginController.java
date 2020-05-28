package com.advsdc.group2.login.controller;

import com.advsdc.group2.login.dao.LoginDao;
import com.advsdc.group2.login.dao.LoginDaoImpl;
import com.advsdc.group2.login.models.UserCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model)
    {
        model.addAttribute("userCred", new UserCredentials());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute UserCredentials userCred)
    {
        UserCredentials userCredFromDb = new UserCredentials();
        LoginDaoImpl ld = new LoginDaoImpl();
        userCredFromDb = ld.getUserCredentials(userCred.getUserId());
        if(userCredFromDb.getUserId() != null) {
            return "result";
        }
        return null;
    }
}
