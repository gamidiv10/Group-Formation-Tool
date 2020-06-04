package com.advsdc.group2.ta.services;

import java.util.List;

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.model.User;

public interface ITaEnrollmentService {

	public List<User> getTAList(String courseID,IUserDetailsDao userDao);
	public User showUsers(String courseID,IUserDetailsDao userDao,String bannerID);
	public int addTA(String courseID,IUserDetailsDao userDao,String bannerID);
}
