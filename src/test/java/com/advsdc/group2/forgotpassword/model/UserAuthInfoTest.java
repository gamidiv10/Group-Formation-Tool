package com.advsdc.group2.forgotpassword.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.advsdc.group2.forgotpassword.dao.UserAuthDaoImpl;
import com.advsdc.group2.forgotpassword.dao.UserDetailsDaoImpl;
import com.advsdc.group2.forgotpassword.doa.UserAuthDetailsDoaMock;
import com.advsdc.group2.model.UserAuthInfo;

public class UserAuthInfoTest {

	private UserAuthInfo defaultUserCreation() {
		
		UserAuthDetailsDoaMock m = new UserAuthDetailsDoaMock();
	//	UserAuthDaoImpl m = new UserAuthDaoImpl();
		UserAuthInfo u = new UserAuthInfo("B00840031", m);
		return u;
	}

	@Test
	public void getOneTimePasswordTest() {
		UserAuthInfo u = defaultUserCreation();
		assertEquals(36569, u.getOneTimePassword());

	}

	@Test
	public void setOneTimePasswordTest() {
		UserAuthInfo u = new UserAuthInfo();
		u.setOneTimePassword(36569);
		assertEquals(36569, u.getOneTimePassword());

	}

	@Test
	public void getPasswordTest() {
		UserAuthInfo u = defaultUserCreation();
		assertEquals("test123", u.getPassword());

	}

	@Test
	public void setPasswordTest() {
		UserAuthInfo u = new UserAuthInfo();
		u.setPassword("test123");
		assertEquals("test123", u.getPassword());

	}

	@Test
	public void getUser_idTest() {

		UserAuthInfo u = defaultUserCreation();
		assertEquals("B00840031", u.getUser_id());
	}

	@Test
	public void setUser_idTest() {
		UserAuthInfo u = new UserAuthInfo();
		u.setUser_id("B00840031");
		assertEquals("B00840031", u.getUser_id());

	}

	@Test
	public void getOtpTimeTest() {

		UserAuthInfo u = defaultUserCreation();
		assertEquals(Timestamp.valueOf("2020-06-01 03:13:52"), u.getOtpTime());
	}

	@Test
	public void setOtpTimeTest() {

		UserAuthInfo u = new UserAuthInfo();
		u.setOtpTime(Timestamp.valueOf("2020-06-01 03:13:52"));
		assertEquals(Timestamp.valueOf("2020-06-01 03:13:52"), u.getOtpTime());

	}

}
