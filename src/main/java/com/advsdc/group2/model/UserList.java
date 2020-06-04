package com.advsdc.group2.model;

import java.util.ArrayList;

public class UserList implements IUserList {

    static ArrayList<User> userList;

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> uL) {
        this.userList = uL;
    }
}
