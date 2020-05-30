package com.advsdc.group2.login.services;

import com.advsdc.group2.login.dao.LoginDaoImpl;
import com.advsdc.group2.login.models.UserCredentials;
import com.advsdc.group2.security.PasswordEncryption;

public class LoginServiceImpl {
    private String passwordFromDb;
    public boolean validateUser(UserCredentials userCred){
        LoginDaoImpl loginDao = new LoginDaoImpl();

        passwordFromDb = loginDao.getUserCredentials(userCred.getUserId());
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordEncryption.matches(userCred.getPassword(), passwordFromDb);


    }
}
