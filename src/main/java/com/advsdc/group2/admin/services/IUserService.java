package com.advsdc.group2.admin.services;

import org.springframework.ui.Model;

public interface IUserService {
    void getUsers(Model model);
    void assingInstructor(Model model, String userId, String courseId);
}
