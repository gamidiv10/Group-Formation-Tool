package com.advsdc.group2.forgotpassword.dao;

import com.advsdc.group2.model.IUserInfo;

public interface IUserDetailsDao {
	
	public void getUserInfo(String bannerID, IUserInfo user);

}
