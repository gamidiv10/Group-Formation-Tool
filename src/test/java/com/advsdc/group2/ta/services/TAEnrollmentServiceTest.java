package com.advsdc.group2.ta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.forgotpassword.doa.UserDetailsDoaMock;
import com.advsdc.group2.model.User;

public class TAEnrollmentServiceTest {

	@Test
	public void getTAList() {

		String courseID = "CSCI3901";
		IUserDetailsDao userDetailsDoa = new UserDetailsDoaMock();
		List<User> taList = new ITaEnrollmentServiceImpl().getTAList(courseID, userDetailsDoa);		
	    assertEquals(1, taList.size());

	}

	@Test
	public void showUsers() {
		String courseID = "CSCI3901";
		String bannerID = "B00840031";
		IUserDetailsDao userDetailsDoa = new UserDetailsDoaMock();
		User u = new ITaEnrollmentServiceImpl().showUsers(courseID, userDetailsDoa, bannerID);
		assertNotNull(u);
		

	}

	@Test
	public void addTA() {
		String courseID = "CSCI3901";
		String bannerID = "B00840031";
		IUserDetailsDao userDetailsDoa = new UserDetailsDoaMock();
		int records = new ITaEnrollmentServiceImpl().addTA(courseID, userDetailsDoa, bannerID);
		assertEquals(1,records);

	}

}
