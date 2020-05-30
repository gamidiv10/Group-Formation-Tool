package com.advsdc.group2.login.services;

import com.advsdc.group2.login.dao.LoginDaoImpl;
import com.advsdc.group2.login.models.UserCredentials;

public class LoginServiceImpl {
    private String passwordFromDb;
    public boolean validateUser(UserCredentials userCred){
        LoginDaoImpl loginDao = new LoginDaoImpl();
        passwordFromDb = loginDao.getUserCredentials(userCred.getUserId());
        if(passwordFromDb != null) {
            return passwordFromDb.equals(userCred.getPassword());
        }
        else{
            return false;
        }
    }
}
