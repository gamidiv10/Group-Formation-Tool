package com.advsdc.group2.admin.controller;

import com.advsdc.group2.admin.services.ICourseService;
import com.advsdc.group2.admin.services.CourseService;
import com.advsdc.group2.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    private ICourseService courseService = new CourseService();

    @RequestMapping(value = "/admin/courses", method = RequestMethod.GET)
    public String courseLists(Model model) {
        courseService.courseLists(model);
        return "admin/courses";
    }

    @RequestMapping(value = "/admin/courses/delete/", method = RequestMethod.POST)
    public String deleteCourse(@RequestParam("id") String courseId, Model model) {
        courseService.deleteCourse(model, courseId);
        return "redirect:/admin/courses";
    }


    @RequestMapping(value = "/admin/courses/addCourse", method = RequestMethod.GET)
    public String addCoursePage(Model model) {
        courseService.addCoursePage(model);
        return "admin/add-course";
    }

    @RequestMapping(value = "/admin/courses/addCourse", method = RequestMethod.POST)
    public String addCourse(Model model, @ModelAttribute Course course_obj) {
        courseService.addCourse(model, course_obj);
        return "redirect:/admin/courses";
    }


}