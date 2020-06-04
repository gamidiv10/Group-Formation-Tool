package com.advsdc.group2.admin.dao;

import com.advsdc.group2.model.IUser;
import com.advsdc.group2.model.User;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("deprecation")
class UserDaoTest {

    @BeforeTestClass
    void fetchUsers() {
        IUserDao userDao = new UserDaoTestMock();
        IUser user = new User();
        assertNull(user.getUserId());
        assertNull(user.getUserName());
        assertNull(user.isInstructor());
        userDao.fetchUsers();

        Assert.isTrue(user.getUserId().equals("B00841446"));
        Assert.isTrue(user.getUserName().equals("Akash Manair"));
        Assert.isTrue(user.isInstructor());
    }
}