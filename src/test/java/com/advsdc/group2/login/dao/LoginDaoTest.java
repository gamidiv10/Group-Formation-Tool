package com.advsdc.group2.login.dao;

import com.advsdc.group2.login.model.UserCredentialsMock;
import com.advsdc.group2.login.models.UserCredentials;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginDaoTest {
    @Test
    public void getUserCredentialsTest(){
        LoginDaoMock loginDaoMock = new LoginDaoMock();
        assertNotNull(loginDaoMock.getUserCredentials("B00834696"));
    }
}
