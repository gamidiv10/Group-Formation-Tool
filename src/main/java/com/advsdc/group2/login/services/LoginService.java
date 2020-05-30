package com.advsdc.group2.login.services;

import com.advsdc.group2.login.models.UserCredentials;

public interface LoginService {

    public boolean validateUser(UserCredentials userCred);
}
