package com.advsdc.group2.course.dao;

import java.util.ArrayList;

import com.advsdc.group2.model.User;

public interface IImportCsvDao {
    public void enrollInCourse(String userId, String courseId);
    public int getRoleForCourse(String userId, String courseId);
}