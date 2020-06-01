package com.advsdc.group2.forgotpassword.doa;

import java.sql.Timestamp;
import java.time.Instant;

import com.advsdc.group2.forgotpassword.dao.IUserAuth;
import com.advsdc.group2.model.IUserAuthInfo;
import com.advsdc.group2.model.UserAuthInfo;

public class UserAuthDetailsDoaMock implements IUserAuth {
	
	int oneTimePassword;
	Timestamp otpTime;
	String password;
	String user_id;
	@Override
	public void getUserAuthDetails(String bannerID, IUserAuthInfo userAuth) {
		
		//userAuth.setOneTimePassword(oneTimePassword);
		//userAuth.setOtpTime(otpTime.toString());
		//userAuth.setPassword(password);
		userAuth.setUser_id(bannerID);
		
		// TODO Auto-generated method stub
		
	}
	
	public void setDefaultVal() {
		
		oneTimePassword = 36569;
		password = "test123";
		otpTime = Timestamp.from(Instant.now());


	}

	@Override
	public void oneOTPInsertion(int code, UserAuthInfo userAuthInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OTPValidation(String code, UserAuthInfo userAuth, IUserAuth userAuthDao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNewPassword(UserAuthInfo userAuth, IUserAuth userAuthDao) {
		// TODO Auto-generated method stub
		
	}

}
