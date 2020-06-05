package com.advsdc.group2.admin.controller;

import com.advsdc.group2.admin.services.ICourseService;
import com.advsdc.group2.admin.services.CourseService;
import com.advsdc.group2.model.Course;
import com.advsdc.group2.utility.JwtUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    JwtUtility jwtUtility = new JwtUtility();

    private ICourseService courseService = new CourseService();

    @RequestMapping(value = "/admin/courses/{token}", method = RequestMethod.GET)
    public String courseLists(Model model, @PathVariable("token") String token) {
        if(jwtUtility.isTokenExpired(token)){
            return "login";
        }
        model.addAttribute("token", token);
        courseService.courseLists(model);
        return "admin/courses";
    }

    @RequestMapping(value = "/admin/courses/delete/{courseId}/{token}", method = RequestMethod.POST)
    public String deleteCourse(@PathVariable("courseId") String courseId, @PathVariable("token") String token, Model model) {
        System.out.println("Course ID"+courseId);
        System.out.println("TOken"+token);
        if(jwtUtility.isTokenExpired(token)){
            return "login";
        }
        courseService.deleteCourse(model, courseId);
        return "redirect:/admin/courses/{token}";
    }


    @RequestMapping(value = "/admin/courses/addCourse/{token}", method = RequestMethod.GET)
    public String addCoursePage(Model model, @PathVariable("token") String token) {
        if(jwtUtility.isTokenExpired(token)){
            return "login";
        }
        model.addAttribute("token", token);
        courseService.addCoursePage(model); 
        return "admin/add-course";
    }

    @RequestMapping(value = "/admin/courses/addCourse/{token}", method = RequestMethod.POST)
    public String addCourse(Model model, @ModelAttribute Course course_obj, @PathVariable("token") String token) {
        if(jwtUtility.isTokenExpired(token)){
            return "login";
        }
        courseService.addCourse(model, course_obj);
        return "redirect:/admin/courses/{token}";
    }


}