package com.advsdc.group2.forgotpassword.services;
//Service Test Class

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.forgotpassword.doa.UserDetailsDoaMock;
import org.junit.jupiter.api.Test;

import com.advsdc.group2.forgotpassword.dao.IUserAuth;
import com.advsdc.group2.forgotpassword.doa.UserAuthDetailsDoaMock;
import com.advsdc.group2.model.User;
import com.advsdc.group2.model.UserAuthInfo;

import static org.junit.jupiter.api.Assertions.*;

public class ForgotPasswordServiceTest {

	@Test
	public void getUserInfoTest() {
		String userId = "B00840031";
		assertDoesNotThrow(() -> new UserDetailsDoaMock());
//		User u = new IForgotPasswordServiceImpl().getUserInfo(userId);
//		assertEquals("B00840031", u.getUser_id());

	}

	@Test
	public void getAuthUserInfoTest() {
		String bannerID = "B00840031";
		assertDoesNotThrow(() -> new UserAuthDetailsDoaMock());
//		UserAuthInfo u = new IForgotPasswordServiceImpl().getAuthUserInfo(bannerID, userAuthDao);
//		assertEquals("B00840031", u.getUser_id());

	}

	@Test
	public void otpEmailGenerationTest() {

		String email = "srey94@dal.ca";
		String u = new IForgotPasswordServiceImpl().otpEmailGeneration(email);
		assertNotNull(u);

	}

	@Test
	public void oneTimePwdInsertionTest() {
		int otp = 36569;
		IUserAuth userAuthDao = new UserAuthDetailsDoaMock();
		UserAuthInfo userAuth = new UserAuthInfo();
		int u = new IForgotPasswordServiceImpl().oneTimePwdInsertion(Integer.toString(otp), userAuth, userAuthDao);
		assertEquals(1, u);

	}

	@Test
	public void OTPValidationTest() {

		String code = "3659";
		IUserAuth userAuthDao = new UserAuthDetailsDoaMock();
		UserAuthInfo userAuth = new UserAuthInfo();
		IForgotPasswordService fpserv = new IForgotPasswordServiceImpl();
		fpserv.OTPValidation(code, userAuth, userAuthDao);

	}

	@Test
	public void setNewPasswordTest() {

		UserAuthInfo userAuth = new UserAuthInfo();
		userAuth.setPassword("test123");
		IUserAuth userAuthDao = new UserAuthDetailsDoaMock();
		int num = new IForgotPasswordServiceImpl().setNewPassword(userAuth, userAuthDao);
		assertEquals(1, num);

	}
}
