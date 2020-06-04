package com.advsdc.group2.forgotpassword.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.advsdc.group2.forgotpassword.doa.UserDetailsDoaMock;
import com.advsdc.group2.model.User;

public class UserTest {

	private User defaultUserCreation() {
		UserDetailsDoaMock m = new UserDetailsDoaMock();
		User u = new User("B00840031", m);
		return u;
	}

	@Test
	public void getUser_idTest() {

		User u = defaultUserCreation();
		assertEquals("B00840031", u.getUser_id());

	}

	@Test
	public void setUser_idTest() {
		User u = new User();
		u.setUser_id("B00840031");
		assertEquals("B00840031", u.getUser_id());

	}

	@Test
	public void getFirst_nameTest() {

		User u = defaultUserCreation();
		assertEquals("Sreyas", u.getFirst_name());

	}

	@Test
	public void setFirst_nameTest() {
		User u = new User();
		u.setFirst_name("Sreyas");
		assertEquals("Sreyas", u.getFirst_name());
	}

	@Test
	public void getLast_nameTest() {
		User u = defaultUserCreation();
		assertEquals("Ram", u.getLast_name());
	}

	@Test
	public void setLast_nameTest() {
		User u = new User();
		u.setLast_name("Ram");
		assertEquals("Ram", u.getLast_name());

	}

	@Test
	public void getEmail() {
		User u = defaultUserCreation();
		assertEquals("srey94@dal.ca", u.getEmail());

	}

	@Test
	public void setEmailTest() {

		User u = new User();
		u.setEmail("srey94@dal.ca");
		assertEquals("srey94@dal.ca", u.getEmail());
	}

}
