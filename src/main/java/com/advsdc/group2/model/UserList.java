package com.advsdc.group2.model;

import java.util.ArrayList;

public class UserList implements IUserList {

    static ArrayList<UserData> userList;

    public ArrayList<UserData> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserData> uL) {
        this.userList = uL;
    }
}
