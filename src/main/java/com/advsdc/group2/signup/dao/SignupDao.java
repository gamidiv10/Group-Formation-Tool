package com.advsdc.group2.signup.dao;

import java.sql.*;

import com.advsdc.group2.signup.models.User;

public interface SignupDao {
    public String setUserDetails(User user);
    public String getUserCredentials(String userId);
    public ResultSet getUsers();
}
