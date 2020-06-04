package com.advsdc.group2.model;

public interface IUser {
    String getUserId();
    void setUserId(String userId);
    String getUserName();
    void setUserName(String userName);
    boolean isInstructor();
    void setInstructor(boolean instructor);
}
