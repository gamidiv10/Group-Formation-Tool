package com.advsdc.group2.forgotpassword.doa;

import java.sql.Timestamp;

import com.advsdc.group2.forgotpassword.dao.IUserAuth;
import com.advsdc.group2.model.IUserAuthInfo;
import com.advsdc.group2.model.UserAuthInfo;

public class UserAuthDetailsDoaMock implements IUserAuth {
	int oneTimePassword;
	Timestamp otpTime;
	String password;
	String user_id;

	public UserAuthDetailsDoaMock() {
		setDefaultVal();

	}

	@Override
	public void getUserAuthDetails(String bannerID, IUserAuthInfo userAuth) {

		userAuth.setOneTimePassword(oneTimePassword);
		userAuth.setOtpTime(otpTime);
		userAuth.setPassword(password);
		userAuth.setUser_id(user_id);

		// TODO Auto-generated method stub

	}

	public void setDefaultVal() {

		this.oneTimePassword = 36569;
		this.password = "test123";
		this.otpTime = Timestamp.valueOf("2020-06-01 03:13:52");
		this.user_id = "B00840031";

	}

	@Override
	public int oneOTPInsertion(int code, UserAuthInfo userAuthInfo) {
		userAuthInfo.setUser_id(user_id);
		userAuthInfo.setOneTimePassword(code);
		return 1;
		// TODO Auto-generated method stub

	}

	@Override
	public void OTPValidation(String code, UserAuthInfo userAuth, IUserAuth userAuthDao) {
		userAuth.setOneTimePassword(Integer.parseInt(code));
		userAuth.setOtpTime(otpTime);

		// TODO Auto-generated method stub

	}

	@Override
	public int setNewPassword(UserAuthInfo userAuth, IUserAuth userAuthDao) {
		// TODO Auto-generated method stub

		userAuth.setPassword(password);
		userAuth.setUser_id(user_id);
		return 1;

	}

}
