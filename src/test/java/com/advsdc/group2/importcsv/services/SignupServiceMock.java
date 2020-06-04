package com.advsdc.group2.importcsv.services;

import com.advsdc.group2.signup.models.User;

public class SignupServiceMock {
    public User createUser(){
        User user = new User();
        user.setEmail("vamsi.gamidi01@gmail.com");
        user.setUserId("vamsig10");
        user.setPassword("Pass@1");
        user.setMatchingPassword("Pass@1");
        user.setLastName("Gamidi");
        user.setFirstName("Vamsi");
        return user;
    }
}
