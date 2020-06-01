package com.advsdc.group2.model;

import java.sql.Timestamp;

import com.advsdc.group2.forgotpassword.dao.IUserAuth;

public class UserAuthInfo implements IUserAuthInfo {

	int oneTimePassword;
	Timestamp otpTime;
	String password;
	String user_id;

	public UserAuthInfo() {
		super();
	}

	public UserAuthInfo(String bannerID, IUserAuth userAuth) {
		userAuth.getUserAuthDetails(bannerID, this);

	}

	public int getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(int oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public Timestamp getOtpTime() {
		return otpTime;
	}

	public void setOtpTime(Timestamp otpTime) {
		this.otpTime = otpTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public void setOtpTime(String string) {
		// TODO Auto-generated method stub

	}

}
