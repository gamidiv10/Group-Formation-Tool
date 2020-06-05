package com.advsdc.group2.admin.controller;

import com.advsdc.group2.admin.services.IUserService;
import com.advsdc.group2.admin.services.UserService;
import com.advsdc.group2.model.CourseUserMap;
import com.advsdc.group2.utility.JwtUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private IUserService userService = new UserService();
    ModelAndView mv = new ModelAndView();
    JwtUtility jwtUtility = new JwtUtility();

    @RequestMapping(value = "/admin/users/{token}", method = RequestMethod.GET)
    public String showUsers(Model model, @PathVariable("token") String token) {
        if(jwtUtility.isTokenExpired(token)){
            return "login";
        }
        model.addAttribute("token", token);
        model.addAttribute("crs_map", new CourseUserMap());
        userService.getUsers(model);
        return "admin/users";
    }

    @RequestMapping(value = "/admin/assignInstructor/{userId}/{token}", method = RequestMethod.POST)
    public String assingInstructor(@PathVariable("userId") String userId, @PathVariable("token") String token, @ModelAttribute CourseUserMap crs_map, Model model) {


        if(jwtUtility.isTokenExpired(token)){
            return "login";
        }
        userService.assingInstructor(model, userId, crs_map.getCourseId());
        showUsers(model, token);
        return "redirect:/admin/users/{token}";
    }
}
