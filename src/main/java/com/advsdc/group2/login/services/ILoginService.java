package com.advsdc.group2.login.services;

import com.advsdc.group2.course.models.Course;
import com.advsdc.group2.login.models.UserCredentials;

import java.util.ArrayList;
import java.util.List;

public interface ILoginService {

    public boolean validateUser(UserCredentials userCred);

    public String generateJsonWebToken(String userId);

    public int getRole(String userId);

    public ArrayList<Course> getCourses(String userId);
}
