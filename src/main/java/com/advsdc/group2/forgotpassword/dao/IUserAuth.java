package com.advsdc.group2.forgotpassword.dao;

import com.advsdc.group2.model.IUserAuthInfo;
import com.advsdc.group2.model.UserAuthInfo;

public interface IUserAuth {
	public void getUserAuthDetails(String bannerID, IUserAuthInfo userAuth);
	public void oneOTPInsertion(int code, UserAuthInfo userAuthInfo);
	public void OTPValidation(String code, UserAuthInfo userAuth,IUserAuth userAuthDao);
	public void setNewPassword(UserAuthInfo userAuth,IUserAuth userAuthDao);
}
