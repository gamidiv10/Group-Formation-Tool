package com.advsdc.group2.model;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    IUser user = new User();

    @Test
    void getUserId() {
        assertNull(user.getUserId());
        user.setUserId("B00841446");
        assertNotNull(user.getUserId());
    }

    @Test
    void setUserId() {
        user.setUserId("B00841446");
        assertEquals("B00841446", user.getUserId());
    }

    @Test
    void getUserName() {
        assertNull(user.getUserName());
        user.setUserName("Akash Maniar");
        assertNotNull(user.getUserName());
    }

    @Test
    void setUserName() {
        user.setUserName("Akash Maniar");
        assertEquals("Akash Maniar", user.getUserName());
    }

    @Test
    void isInstructor() {
        user.setInstructor(true);
        assertTrue(user.isInstructor());
    }

    @Test
    void setInstructor() {
        user.setInstructor(false);
        assertEquals(false, user.isInstructor());
    }
}