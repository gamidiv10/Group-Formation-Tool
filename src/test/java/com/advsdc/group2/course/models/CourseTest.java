package com.advsdc.group2.course.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    @Test
    public void setCourseIdTest(){
        CourseMock courseMock = new CourseMock();
        courseMock.setCourseId("NewCourseId");
        assertEquals("NewCourseId", courseMock.getCourseId());
    }

    @Test
    public void getCourseIdTest(){
        CourseMock courseMock = new CourseMock();
        assertEquals("1", courseMock.getCourseId());
    }   @Test
    public void setCourseNameTest(){
        CourseMock courseMock = new CourseMock();
        courseMock.setCourseName("NewCourseName");
        assertEquals("NewCourseName", courseMock.getCourseName());
    }   @Test
    public void getCourseNameTest(){
        CourseMock courseMock = new CourseMock();
        assertEquals("C", courseMock.getCourseName());
    }   @Test
    public void setCourseDescTest(){
        CourseMock courseMock = new CourseMock();
        courseMock.setCourseDesc("NewCourseDesc");
        assertEquals("NewCourseDesc", courseMock.getCourseDesc());
    }   @Test
    public void getCourseDescTest(){
        CourseMock courseMock = new CourseMock();
        assertEquals("C-Language", courseMock.getCourseDesc());
    }
}
