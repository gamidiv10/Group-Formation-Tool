package com.advsdc.group2.login.dao;

public class LoginDaoMock implements ILoginDao{

    @Override
    public String getUserCredentials(String userId) {
        return "Pass@1";
    }
}
