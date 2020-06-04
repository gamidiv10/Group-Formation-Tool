package com.advsdc.group2.ta.services;

import java.util.List;

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.forgotpassword.dao.UserDetailsDaoImpl;
import com.advsdc.group2.model.User;

public class ITaEnrollmentServiceImpl implements ITaEnrollmentService {

	// IUserDetailsDao userDet = new UserDetailsDaoImpl();

	@Override
	public List<User> getTAList(String courseID, IUserDetailsDao userDet) {

		List<User> taList = userDet.getTAList(courseID);
		// TODO Auto-generated method stub
		return taList;
	}

	@Override
	public User showUsers(String courseID, IUserDetailsDao userDao, String bannerID) {

		User searchUserList = userDao.showUsers(courseID, bannerID);
		// TODO Auto-generated method stub
		return searchUserList;
	}

	@Override
	public int addTA(String courseID, IUserDetailsDao userDao, String bannerID) {
		// TODO Auto-generated method stub
		int numberRowsInserted = userDao.add(courseID, bannerID);
		return numberRowsInserted;
	}

}
