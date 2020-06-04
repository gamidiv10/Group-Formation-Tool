package com.advsdc.group2.model;

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;

public class User implements IUserInfo {
	public String first_name;
	public String last_name;
	public String email;
	public String user_id;

	public User() {
		super();
	}

	public User(String bannerID, IUserDetailsDao user) {
		user.getUserInfo(bannerID, this);

	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

}
