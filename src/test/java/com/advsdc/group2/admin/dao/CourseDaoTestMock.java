package com.advsdc.group2.admin.dao;

import com.advsdc.group2.model.Course;
import com.advsdc.group2.model.CourseMessageModel;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class CourseDaoTestMock implements ICourseDao {

    @Override
    public void getCourseList(CourseMessageModel crsm) {
        Course course = new Course();
        ArrayList<Course> crsList = new ArrayList<>();
        course.setCourseName("Advance Topics in Software development");
        course.setCourseId("CSCI5308");
        course.setCourseDescription("This course will make you work very hard");
        crsList.add(course);
        crsm.setCourseLst(crsList);
    }

    @Override
    public void addCourse(CourseMessageModel crsm, Course course) {
        ArrayList<Course> crsLst = new ArrayList<>();
        crsLst.add(course);
        crsm.setCourseLst(crsLst);
    }

    @Override
    public void deleteCourse(CourseMessageModel crsm, String courseId) {
        for (int i = 0; i< crsm.getCourseLst().size(); i++) {
            if (crsm.getCourseLst().get(i).getCourseId().equals(courseId)) {
                crsm.getCourseLst().remove(i);
            }
        }
    }
}
