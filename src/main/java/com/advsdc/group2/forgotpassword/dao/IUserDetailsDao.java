package com.advsdc.group2.forgotpassword.dao;

import java.util.List;

import com.advsdc.group2.model.IUserInfo;
import com.advsdc.group2.model.User;

public interface IUserDetailsDao {

	public void getUserInfo(String bannerID, IUserInfo user);

	public List<User> getTAList(String courseID);

	public User showUsers(String course, String bannerID);
	
	public int add(String courseID,String bannerID);

}
