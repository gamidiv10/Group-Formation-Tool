package com.advsdc.group2.admin.controller;

import com.advsdc.group2.admin.services.IUserService;
import com.advsdc.group2.admin.services.UserService;
import com.advsdc.group2.model.CourseUserMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private IUserService userService = new UserService();
    ModelAndView mv = new ModelAndView();

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        model.addAttribute("crs_map", new CourseUserMap());
        userService.getUsers(model);
        return "admin/users";
    }

    @RequestMapping(value = "/admin/assignInstructor/", method = RequestMethod.POST)
    public String assingInstructor(@RequestParam("id") String userId, @ModelAttribute CourseUserMap crs_map, Model model) {
        userService.assingInstructor(model, userId, crs_map.getCourseId());
        return "redirect:/admin/users";
    }
}
