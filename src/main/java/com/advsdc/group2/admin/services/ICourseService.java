package com.advsdc.group2.admin.services;

import com.advsdc.group2.model.Course;
import com.advsdc.group2.model.CourseMessageModel;
import org.springframework.ui.Model;

public interface ICourseService {
    String courseLists(Model model);
    String addCoursePage(Model model);
    String addCourse(Model model, Course course);
    String deleteCourse(Model model, String courseId);
}
