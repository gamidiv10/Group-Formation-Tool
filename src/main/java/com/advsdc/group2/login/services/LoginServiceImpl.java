package com.advsdc.group2.login.services;

import com.advsdc.group2.login.dao.LoginDaoImpl;
import com.advsdc.group2.login.models.UserCredentials;
import com.advsdc.group2.security.PasswordEncryption;
import com.advsdc.group2.utility.JwtUtility;

public class LoginServiceImpl {
    private String passwordFromDb, jsonWebToken;
    public boolean validateUser(UserCredentials userCred){
        LoginDaoImpl loginDao = new LoginDaoImpl();

        passwordFromDb = loginDao.getUserCredentials(userCred.getUserId());
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordEncryption.matches(userCred.getPassword(), passwordFromDb);
    }

    public String generateJsonWebToken(String userId)
    {
        JwtUtility jwtUtility = new JwtUtility();
        jsonWebToken = jwtUtility.generateToken(userId);
        return jsonWebToken;
    }
}
