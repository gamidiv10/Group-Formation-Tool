package com.advsdc.group2.admin.services;

import com.advsdc.group2.admin.dao.IUserDao;
import com.advsdc.group2.admin.dao.UserDao;
import com.advsdc.group2.model.Course;
import com.advsdc.group2.model.CourseUserMap;
import com.advsdc.group2.model.UserList;
import org.springframework.ui.Model;

public class UserService implements IUserService {

    private IUserDao userDao = new UserDao();
    private UserList userList = new UserList();

    @Override
    public void getUsers(Model model) {
        userDao.fetchUsers();
        model.addAttribute("user_list", userList.getUserList());
    }

    @Override
    public void assingInstructor(Model model, String userId, String courseId) {
        userDao.makeInstructor(userId, courseId);
    }
}
