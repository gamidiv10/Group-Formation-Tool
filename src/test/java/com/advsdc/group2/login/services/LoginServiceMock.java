package com.advsdc.group2.login.services;

import com.advsdc.group2.login.dao.LoginDaoImpl;
import com.advsdc.group2.login.dao.LoginDaoMock;
import com.advsdc.group2.login.models.UserCredentials;

public class LoginServiceMock implements ILoginService{
    private String passwordFromDb, jsonWebToken;
    @Override
    public boolean validateUser(UserCredentials userCred) {
        LoginDaoMock loginDao = new LoginDaoMock();
        loginDao.getUserCredentials(userCred.getUserId());
        return userCred.getPassword().matches(loginDao.getUserCredentials(userCred.getUserId()));
    }

    @Override
    public String generateJsonWebToken(String userId) {
        return null;
    }
}
