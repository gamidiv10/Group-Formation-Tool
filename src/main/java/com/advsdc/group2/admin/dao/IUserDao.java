package com.advsdc.group2.admin.dao;

import com.advsdc.group2.model.CourseUserMap;

public interface IUserDao {
    void fetchUsers();
    boolean makeInstructor(String userId, String crsId);
}
