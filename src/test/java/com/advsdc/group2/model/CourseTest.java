package com.advsdc.group2.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SuppressWarnings("deprecation")
class CourseTest {
    ICourse crs = new Course();

    @Test
    void getCourseId() {
        assertNull(crs.getCourseId());
        crs.setCourseId("CSCI5308");
        assertNotNull(crs.getCourseId());
    }

    @Test
    void setCourseId() {
        crs.setCourseId("CSCI5308");
        Assert.isTrue("CSCI5308" == crs.getCourseId());

    }

    @Test
    void getCourseName() {
        assertNull(crs.getCourseName());
        crs.setCourseName("Adv Topics in Software Development");
        assertNotNull(crs.getCourseName());
    }

    @Test
    void setCourseName() {
        crs.setCourseName("Adv Topics in Software Development");
        Assert.isTrue("Adv Topics in Software Development" == crs.getCourseName());
    }

    @Test
    void getCourseDescription() {
        assertNull(crs.getCourseDescription());
        crs.setCourseDescription("Adv topics in Software development is taught by Rob!");
        assertNotNull(crs.getCourseDescription());
    }

    @Test
    void setCourseDescription() {
        crs.setCourseDescription("Adv topics in Software development is taught by Rob!");
        Assert.isTrue("Adv topics in Software development is taught by Rob!" == crs.getCourseDescription());
    }
}