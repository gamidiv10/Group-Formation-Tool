package com.advsdc.group2.admin.services;

import com.advsdc.group2.admin.dao.CourseDao;
import com.advsdc.group2.admin.dao.ICourseDao;
import com.advsdc.group2.model.Course;
import com.advsdc.group2.model.CourseMessageModel;
import org.springframework.ui.Model;

public class CourseService implements ICourseService {
        private ICourseDao courseDao = new CourseDao();
        private CourseMessageModel crsm =  new CourseMessageModel();

        @Override
        public String courseLists(Model model) {
                model.addAttribute("course_List_title", "List of courses given as");
                courseDao.getCourseList(crsm);
                model.addAttribute("course_list", crsm.getCourseLst());
                return null;
        }

        @Override
        public String addCoursePage(Model model) {
             model.addAttribute("course_obj", new Course());
             return null;
        }

        @Override
        public String addCourse(Model model, Course course_obj) {
                courseDao.addCourse(crsm, course_obj);
                model.addAttribute("course_list", crsm.getCourseLst());
                model.addAttribute("crs_message", crsm.getMessage());
                return null;
        }

        @Override
        public String deleteCourse(Model model, String courseId) {
                courseDao.deleteCourse(crsm, courseId);
                model.addAttribute("course_list", crsm.getCourseLst());
                model.addAttribute("crs_message", crsm.getMessage());
                return null;
        }
}
