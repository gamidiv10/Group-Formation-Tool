package com.advsdc.group2.login.dao;

import com.advsdc.group2.course.models.Course;

import java.util.ArrayList;

public class LoginDaoMock implements ILoginDao {

    @Override
    public String getUserCredentials(String userId) {
        return "Pass@1";
    }

    @Override
    public int getRole(String userId) {
        return 4;
    }

    @Override
    public ArrayList<Course> getCourses(String userId) {
        if (userId == "B00834696") {
            Course course = new Course();
            course.setCourseId("1");
            course.setCourseName("C++");
            course.setCourseDesc("CPP");
            ArrayList<Course> courseArrayList = new ArrayList<>();
            courseArrayList.add(course);
            return courseArrayList;
        }
        return null;
    }
}
