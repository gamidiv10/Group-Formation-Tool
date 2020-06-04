package com.advsdc.group2.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseUserMapTest {
    ICourseUserMap crsUMap = new CourseUserMap();

    @Test
    void getMessage() {
        crsUMap.setMessage("This is a course Map Test");
        assertNotNull(crsUMap.getMessage());
    }

    @Test
    void setMessage() {
        crsUMap.setMessage("Successfully inserted data");
        assertEquals("Successfully inserted data", crsUMap.getMessage());
    }
}