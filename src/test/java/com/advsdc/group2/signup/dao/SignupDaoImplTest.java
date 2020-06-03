package com.advsdc.group2.signup.dao;


import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

//import java.util.ArrayList;
import java.util.List;

public class SignupDaoImplTest {
    
	@Test
    public void getUserCredentialsTest(){
        SignupDaoImpl signupDao = new SignupDaoImpl();
        if(signupDao.getUserCredentials("testing")!=null)
        	assertTrue(signupDao.getUserCredentials("testing") instanceof String);
        else
        	assertTrue(signupDao.getUserCredentials(null)==null);
    }
	
	@Test
    public void getUsersTest(){
        SignupDaoImpl signupDao = new SignupDaoImpl();
        if(signupDao.getUsers()!=null)
        	assertTrue(signupDao.getUsers() instanceof List);
        else
        	assertTrue(signupDao.getUsers()==null);
    }
	
}
