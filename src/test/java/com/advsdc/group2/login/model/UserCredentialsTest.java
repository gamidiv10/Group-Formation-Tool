package com.advsdc.group2.login.model;

import com.advsdc.group2.login.models.UserCredentials;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCredentialsTest {
    @Test
    public void setUserIdTest(){
        UserCredentialsMock userCredentialsMock = new UserCredentialsMock();
        userCredentialsMock.setUserId("NewUserId");
        assertEquals("NewUserId", userCredentialsMock.getUserId());
    }

    @Test
    public void setPasswordTest(){
        UserCredentialsMock userCredentialsMock = new UserCredentialsMock();
        userCredentialsMock.setPassword("NewPass");
        assertEquals("NewPass", userCredentialsMock.getPassword());
    }
    @Test
    public void getUserIdTest(){
        UserCredentialsMock userCredentialsMock = new UserCredentialsMock();
        assertEquals("B00834696", userCredentialsMock.getUserId());
    }
    @Test
    public void getPasswordTest(){
        UserCredentialsMock userCredentialsMock = new UserCredentialsMock();
        assertEquals("Pass@1", userCredentialsMock.getPassword());
    }
}