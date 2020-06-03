package com.advsdc.group2.login.dao;

import com.advsdc.group2.course.models.Course;

import java.util.ArrayList;
import java.util.List;

public interface ILoginDao {
    public String getUserCredentials(String userId);

    public int getRole(String userId);

    public ArrayList<Course> getCourses(String userId);

}
