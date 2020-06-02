package com.advsdc.group2.signup.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
	
	@Test
	public void getUserIdTest() {
		User user = new User();
		assertNull(user.getUserId());
	}

	@Test
	public void setUserIdTest() {
		User user = new User();
		user.setUserId("test");
		assertEquals("test",user.getUserId());
	}
	
	@Test
	public void getPasswordTest() {
		User user = new User();
		assertNull(user.getPassword());
	}
	
	@Test
	public void setPasswordTest() {
		User user = new User();
		user.setPassword("test");
		assertEquals("test",user.getPassword());
	}

	@Test
	public void getFirstNameTest() {
		User user = new User();
		assertNull(user.getFirstName());
	}
	
	@Test
	public void setFirstNameTest() {
		User user = new User();
		user.setFirstName("test");
		assertEquals("test",user.getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		User user = new User();
		assertNull(user.getLastName());
	}
	
	@Test
	public void setLastNameTest() {
		User user = new User();
		user.setLastName("test");
		assertEquals("test",user.getLastName());
	}
	
	@Test
	public void getEmailTest() {
		User user = new User();
		assertNull(user.getEmail());
	}
	
	@Test
	public void setEmailTest() {
		User user = new User();
		user.setEmail("test");
		assertEquals("test",user.getEmail());
	}
	
	@Test
	public void getMatchingPasswordTest() {
		User user = new User();
		assertNull(user.getMatchingPassword());
	}
	
	@Test
	public void setMatchingPasswordTest() {
		User user = new User();
		user.setMatchingPassword("test");
		assertEquals("test",user.getMatchingPassword());
	}
}
