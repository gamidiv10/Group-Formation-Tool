package com.advsdc.group2.login.services;

import com.advsdc.group2.course.models.Course;
import com.advsdc.group2.login.dao.LoginDaoMock;
import com.advsdc.group2.login.models.UserCredentials;

import java.util.ArrayList;

public class LoginServiceMock implements ILoginService{
    private String passwordFromDb, jsonWebToken;
    @Override
    public boolean validateUser(UserCredentials userCred) {
        LoginDaoMock loginDao = new LoginDaoMock();
        loginDao.getUserCredentials(userCred.getUserId());
        return userCred.getPassword().matches(loginDao.getUserCredentials(userCred.getUserId()));
    }

    @Override
    public String generateJsonWebToken(String userId) {
        return null;
    }

    @Override
    public int getRole(String userId) {
        if(userId == "B00834696"){
            return 4;
        }
        return 0;
    }

    @Override
    public ArrayList<Course> getCourses(String userId) {
        if(userId == "B00834696") {
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
