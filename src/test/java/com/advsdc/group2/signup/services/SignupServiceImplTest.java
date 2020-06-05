package com.advsdc.group2.signup.services;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.advsdc.group2.signup.dao.SignupDao;
import com.advsdc.group2.signup.dbutility.DbUtility;
import com.advsdc.group2.signup.models.User;

public class SignupServiceImplTest extends BaseTestCase {
	
	@BeforeEach
	void init_mocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock SignupDao signupDaoImpl;
	
	@Mock DbUtility dbUtility;
	
	@InjectMocks SignupService signupServiceImpl = new SignupServiceImpl();
	
	@Test
	void isUserInDbTest() {
		

		List<String> list = new ArrayList<String>();
		list.add("B00123");
		list.add("B00456");
		when(signupDaoImpl.getUsers()).thenReturn(list);
		assertFalse(signupServiceImpl.isUserInDb("B00123"));
//	    verify(signupServiceImpl).isUserInDb(eq("B00123"));

		
		
	}
	
	@Test
	void isPasswordMatchedTest() {
		

		boolean result = signupServiceImpl.isPasswordMatched("password", "password");
		assertTrue(result);
		
	}
	
	@Test
	void createUserTest() {
		
		when(signupDaoImpl.setUserDetails(any(User.class))).thenReturn(true);
		assertTrue(signupServiceImpl.createUser(new User()));

		
	}
}
