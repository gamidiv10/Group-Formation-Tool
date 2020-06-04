package com.advsdc.group2.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserListTest {
    IUserList uList = new UserList();

    @BeforeTestClass
    public void getUserList() {
        assertNull(uList.getUserList());
        User user = new User();
        ArrayList<User> usrList = new ArrayList<>();
        user.setUserId("B00841446");
        user.setUserName("Akash Maniar");
        usrList.add(user);
        uList.setUserList(usrList);
        assertNotNull(uList.getUserList());
    }


    @Test
    void setUserList() {
        User user = new User();
        ArrayList<User> usr = new ArrayList<>();
        user.setInstructor(true);
        user.setUserName("Akash Maniar");
        user.setUserId("B00841466");
        usr.add(user);
        uList.setUserList(usr);
        assertEquals(usr, uList.getUserList());
    }
}