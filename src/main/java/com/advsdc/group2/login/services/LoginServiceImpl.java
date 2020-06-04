package com.advsdc.group2.login.services;

import com.advsdc.group2.course.models.Course;
import com.advsdc.group2.login.dao.LoginDaoImpl;
import com.advsdc.group2.login.models.UserCredentials;
import com.advsdc.group2.security.PasswordEncryption;
import com.advsdc.group2.utility.JwtUtility;
import java.util.ArrayList;
import java.util.List;

public class LoginServiceImpl implements ILoginService{
    private String passwordFromDb, jsonWebToken;

    @Override
    public boolean validateUser(UserCredentials userCred){
        LoginDaoImpl loginDao = new LoginDaoImpl();

        passwordFromDb = loginDao.getUserCredentials(userCred.getUserId());
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordFromDb != null && passwordEncryption.matches(userCred.getPassword(), passwordFromDb);
    }

    @Override
    public String generateJsonWebToken(String userId)
    {
        JwtUtility jwtUtility = new JwtUtility();
        jsonWebToken = jwtUtility.generateToken(userId);
        return jsonWebToken;
    }

    @Override
    public int getRole(String userId) {
        LoginDaoImpl loginDao = new LoginDaoImpl();
        return loginDao.getRole(userId);
    }

    @Override
    public ArrayList<Course> getCourses(String userId) {
        LoginDaoImpl loginDao = new LoginDaoImpl();
        return loginDao.getCourses(userId);
    }
}
