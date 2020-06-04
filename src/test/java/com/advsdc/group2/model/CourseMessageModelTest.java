package com.advsdc.group2.model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMessageModelTest {
    ICourseMessageModel cmm = new CourseMessageModel();

    @Test
    void getCourseLst() {
        Course crs = new Course();
        assertNull(cmm.getCourseLst());
        ArrayList<Course> crsList = new ArrayList<Course>();

        crs.setCourseId("CSCI3901");
        crs.setCourseName("Software Development Concepts");
        crs.setCourseDescription("Taught by Mike MacAllister");
        crsList.add(crs);
        cmm.setCourseLst(crsList);
        assertNotNull(cmm.getCourseLst());
    }

    @Test
    void setCourseLst() {
        Course crs = new Course();
        ArrayList<Course> crsList = new ArrayList<Course>();

        crs.setCourseId("CSCI3901");
        crs.setCourseName("Software Development Concepts");
        crs.setCourseDescription("Taught by Mike MacAllister");
        crsList.add(crs);
        cmm.setCourseLst(crsList);
        assertEquals(crsList, cmm.getCourseLst());
    }

    @Test
    void getMessage() {
        assertNull(cmm.getMessage());
        cmm.setMessage("Successfully inserted data");
        assertNotNull(cmm.getMessage());
    }

    @Test
    void setMessage() {
        cmm.setMessage("Successfully inserted data");
        assertEquals("Successfully inserted data", cmm.getMessage());
    }
}