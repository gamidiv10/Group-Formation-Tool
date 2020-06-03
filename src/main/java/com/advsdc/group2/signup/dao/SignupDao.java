package com.advsdc.group2.signup.dao;

import java.util.List;

import com.advsdc.group2.signup.models.User;

public interface SignupDao {
    public boolean setUserDetails(User user);
    public String getUserCredentials(String userId);
    public List<String> getUsers();
}
