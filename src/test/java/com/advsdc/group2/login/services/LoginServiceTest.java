package com.advsdc.group2.login.services;

import com.advsdc.group2.login.models.UserCredentials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServiceTest {
    @Test
    public void validateUserTest() {
        LoginServiceImpl loginService = new LoginServiceImpl();
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUserId("B00834696");
        userCredentials.setPassword("Pass@1");
        assertTrue(loginService.validateUser(userCredentials));
    }

    @Test
    public void generateJsonWebTokenTest(){
        LoginServiceImpl loginService = new LoginServiceImpl();
        assertNotNull(loginService.generateJsonWebToken("B00834696"));
    }
}
