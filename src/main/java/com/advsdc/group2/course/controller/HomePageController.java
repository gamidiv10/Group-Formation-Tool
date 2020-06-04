package com.advsdc.group2.course.controller;

import com.advsdc.group2.course.models.Course;
import com.advsdc.group2.login.services.LoginServiceImpl;
import com.advsdc.group2.utility.JwtUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomePageController {
    @GetMapping("/loggedin")
    public String courseHome(String token, Model model){

        JwtUtility jwtUtility = new JwtUtility();
        System.out.println(jwtUtility.getUsernameFromToken(token));
        if(!jwtUtility.isTokenExpired(token)){
            LoginServiceImpl loginService = new LoginServiceImpl();
            ArrayList<Course> courseList = loginService.getCourses(jwtUtility.getUsernameFromToken(token));
            model.addAttribute("token", token);
            model.addAttribute("courseList", courseList);
            return "logged_in";
        }
        return "login";
    }
}
