package com.advsdc.group2.login.dao;

import com.advsdc.group2.utility.DbUtility;

public class LoginDaoImpl implements LoginDao{

    public String getUserCredentials(String userId){
        DbUtility dbUtility = new DbUtility();
        return dbUtility.getUserCredentials(userId);
    }

}
