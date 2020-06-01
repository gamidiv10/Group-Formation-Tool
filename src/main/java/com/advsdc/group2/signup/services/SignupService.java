package com.advsdc.group2.signup.services;

import com.advsdc.group2.signup.models.User;

public interface SignupService {
	
	public boolean isUserInDb(String userId);
	public void createUser(User user);
	public boolean isPasswordMatched(String password, String matchingPassword);

}
