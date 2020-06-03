package com.advsdc.group2.login.services;

import com.advsdc.group2.login.models.UserCredentials;

public interface ILoginService {

    public boolean validateUser(UserCredentials userCred);

    public String generateJsonWebToken(String userId);
}
