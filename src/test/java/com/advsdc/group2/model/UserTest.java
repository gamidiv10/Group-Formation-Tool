package com.advsdc.group2.model;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void getUserId() {
        UserData user = new UserData();
        assertNull(user.getUserId());
        user.setUserId("B00841446");
        assertNotNull(user.getUserId());
    }

    @Test
    void setUserId() {
        UserData user = new UserData();
        user.setUserId("B00841446");
        assertEquals("B00841446", user.getUserId());
    }

    @Test
    void getUserName() {
        UserData user = new UserData();
        assertNull(user.getUserName());
        user.setUserName("Akash Maniar");
        assertNotNull(user.getUserName());
    }

    @Test
    void setUserName() {
        UserData user = new UserData();
        user.setUserName("Akash Maniar");
        assertEquals("Akash Maniar", user.getUserName());
    }

    @Test
    void isInstructor() {
        UserData user = new UserData();
        user.setInstructor(true);
        assertTrue(user.isInstructor());
    }

    @Test
    void setInstructor() {
        UserData user = new UserData();
        user.setInstructor(false);
        assertEquals(false, user.isInstructor());
    }
}