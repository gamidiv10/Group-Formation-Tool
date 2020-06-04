package com.advsdc.group2.forgotpassword.doa;

import java.util.ArrayList;
import java.util.List;

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.model.IUserInfo;
import com.advsdc.group2.model.User;

public class UserDetailsDoaMock implements IUserDetailsDao {
	public String first_name;
	public String last_name;
	public String email;
	public String user_id;
	List<User> taList = new ArrayList<User>();

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
		User user = new User();

		courseID = "CSCI3901";

		user.setEmail("94sreyas@gmail.com");
		user.setFirst_name("Sriram");
		user.setLast_name(("Krish"));
		user.setUser_id("B00840035");
		taList.add(user);

		return taList;
	}

	@Override
	public User showUsers(String course, String bannerID) {

		User showUser = new User();
		course = "CSCI3901";
		bannerID = "B00840031";
		showUser.setEmail("94sreyas@gmail.com");
		showUser.setFirst_name("Sriram");
		showUser.setLast_name(("Krish"));
		showUser.setUser_id("B00840035");

		return showUser;
	}

	@Override
	public int add(String courseID, String bannerID) {

		return 1;
	}

}
