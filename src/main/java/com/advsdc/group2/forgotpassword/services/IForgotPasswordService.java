package com.advsdc.group2.forgotpassword.services;

import com.advsdc.group2.forgotpassword.dao.IUserAuth;
import com.advsdc.group2.model.User;
import com.advsdc.group2.model.UserAuthInfo;

public interface IForgotPasswordService {

	public User getUserInfo(String bannerID);
	
	public UserAuthInfo getAuthUserInfo(String bannerID,IUserAuth userAuthDao);
	
	public String otpEmailGeneration(String email);
	
	public int oneTimePwdInsertion(String code, UserAuthInfo userAuth,IUserAuth userAuthDao);
	
	public void OTPValidation(String code, UserAuthInfo userAuth,IUserAuth userAuthDao);
	
	public int setNewPassword(UserAuthInfo userAuth,IUserAuth userAuthDao);
}
