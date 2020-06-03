package com.advsdc.group2.login.model;

import com.advsdc.group2.login.models.IUserCredentials;

public class UserCredentialsMock implements IUserCredentials {
    private String userId;
    private String password;

    public UserCredentialsMock()
    {
        setToDefault();
    }
    public void setToDefault()
    {
        userId = "B00834696";
        password = "Pass@1";
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;

    }
}
