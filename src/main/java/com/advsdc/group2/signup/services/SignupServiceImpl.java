package com.advsdc.group2.signup.services;

import java.util.List;

import com.advsdc.group2.signup.dao.SignupDao;
import com.advsdc.group2.signup.dao.SignupDaoImpl;
import com.advsdc.group2.signup.models.User;

public class SignupServiceImpl implements SignupService {
	
	private SignupDao signupDaoImpl;;
	
	@Override
	public void createUser(User user) {
		this.signupDaoImpl = new SignupDaoImpl();
		signupDaoImpl.setUserDetails(user);		
	}
	
	@Override
	public boolean isUserInDb(String userId) {
		
		this.signupDaoImpl = new SignupDaoImpl();
		List<String> userList = signupDaoImpl.getUsers();
		System.out.println("Obtained list: "+userList);
        System.out.println("given userId : "+userId);
        boolean userExists = userList.contains(userId);
        System.out.println("userExists value : "+userExists);
        if(userExists) {
        	System.out.println("User already exists in DB user_auth : "+userId);
        	return true;
        }
//		try {
//			while(userRs.next()) {
//                String databaseUserId = userRs.getString("user_id");
//                System.out.println("DB userid Output: " + databaseUserId);
//                if(userId.equals(databaseUserId)){
//                	System.out.println("User already exists in DB user_auth : "+userId);
//                	return true;
//                }
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println(e);
//		}
		return false;
	}

	@Override
	public boolean isPasswordMatched(String password, String matchingPassword) {
		if(password.equals(matchingPassword))
			return true;
		else
			return false;
	}

}
