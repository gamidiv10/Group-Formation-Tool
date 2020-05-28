package com.advsdc.group2.login.controller;

import com.advsdc.group2.login.models.UserCredentials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginControllerTest {
    @Test
    public void loginSubmit(){
        UserCredentials userCred = new UserCredentials();

        userCred.setUserId("B00834696");

        assertTrue(userCred.getUserId().equals("B00834696"));

    }

}
