package com.advsdc.group2.admin.dao;

import com.advsdc.group2.model.Course;
import com.advsdc.group2.model.CourseMessageModel;
import com.advsdc.group2.model.ICourse;
import com.advsdc.group2.model.ICourseMessageModel;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("deprecation")
class CourseDaoTest {

    @BeforeTestClass
    void getCourseList() {
        ICourseDao courseDao = new CourseDaoTestMock();
        CourseMessageModel cmm = new CourseMessageModel();
        assertNull(cmm.getCourseLst());
        assertNull(cmm.getMessage());
        assertFalse(cmm.isOk());

        courseDao.getCourseList(cmm);

        Assert.isTrue(cmm.getCourseLst().size() == 1);
        Course crs = new Course();
        crs = cmm.getCourseLst().get(0);
        assertTrue(crs.getCourseName() == "Advance Topics in Software development");
        assertTrue(crs.getCourseId() == "CSCI5308");
        assertTrue(crs.getCourseDescription() == "This course will make you work very hard");
    }

    @Test
    void addCourse() {
        ICourseDao courseDao = new CourseDaoTestMock();
        CourseMessageModel cmm = new CourseMessageModel();
        assertNull(cmm.getCourseLst());
        Course course = new Course();
        course.setCourseId("CSCI5308");
        course.setCourseName("Adv Web");
        course.setCourseDescription("Hey this is web");
        courseDao.addCourse(cmm, course);

        assertNotNull(cmm.getCourseLst());
    }

    @Test
    void deleteCourse() {
        ICourseDao courseDao = new CourseDaoTestMock();
        CourseMessageModel cmm = new CourseMessageModel();

        Course crs = new Course();
        crs.setCourseId("CSCI9999");
        crs.setCourseName("Adv SDC");
        crs.setCourseDescription("Taught by Rob");
        courseDao.addCourse(cmm, crs);

        assertNotNull(cmm.getCourseLst());

        courseDao.deleteCourse(cmm, "CSCI9999");
        boolean isExist = false;
        for (int i = 0; i< cmm.getCourseLst().size(); i++) {
            if (cmm.getCourseLst().get(i).getCourseId().equals("CSCI9999")) {
                isExist = true;
            }
        }
        assertFalse(isExist);

    }
}