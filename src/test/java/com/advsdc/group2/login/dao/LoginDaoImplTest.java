package com.advsdc.group2.login.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginDaoImplTest {
    @Test
    public void getUserCredentialsTest(){
        LoginDaoImpl loginDao = new LoginDaoImpl();
        assertNotNull(loginDao.getUserCredentials("B00834696").getUserId());
    }
}
