package com.advsdc.group2.admin.dao;

import com.advsdc.group2.model.Course;
import com.advsdc.group2.model.CourseMessageModel;

import java.util.ArrayList;

public interface ICourseDao {
        void getCourseList(CourseMessageModel crsm);
        void addCourse(CourseMessageModel crsm, Course course);
        void deleteCourse(CourseMessageModel crsm, String courseId);
}
