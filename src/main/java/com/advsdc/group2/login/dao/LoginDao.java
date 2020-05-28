package com.advsdc.group2.login.dao;

import com.advsdc.group2.login.models.UserCredentials;

public interface LoginDao {
    public UserCredentials getUserCredentials(String userId);

}
