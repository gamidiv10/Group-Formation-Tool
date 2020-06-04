package com.advsdc.group2.forgotpassword.doa;

import java.util.List;

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.model.IUserInfo;
import com.advsdc.group2.model.User;

public class UserDetailsDoaMock implements IUserDetailsDao {
	public String first_name;
	public String last_name;
	public String email;
	public String user_id;

	public UserDetailsDoaMock() {

		setDefaultVal();

	}

	@Override
	public void getUserInfo(String bannerID, IUserInfo user) {

		user.setUser_id(bannerID);
		user.setLast_name(last_name);
		user.setFirst_name(first_name);
		user.setEmail(email);
	}

	public void setDefaultVal() {

		first_name = "Sreyas";
		last_name = "Ram";
		email = "srey94@dal.ca";
		user_id = "B00840031";

	}

	@Override
	public List<User> getTAList(String courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUsers(String course, String bannerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(String courseID, String bannerID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
