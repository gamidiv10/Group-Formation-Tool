package com.advsdc.group2.signup.dao;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignupDaoImplTest {
    
	@Test
    public void getUserCredentialsTest(){
        SignupDaoImpl signupDao = new SignupDaoImpl();
        assertNull(signupDao.getUserCredentials("testing"));
    }
	
	@Test
    public void getUsersTest(){
        SignupDaoImpl signupDao = new SignupDaoImpl();
        assertNotNull(signupDao.getUsers());
    }
}
