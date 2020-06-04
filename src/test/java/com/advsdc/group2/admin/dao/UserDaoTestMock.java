package com.advsdc.group2.admin.dao;
import com.advsdc.group2.model.*;

import java.util.ArrayList;

class UserDaoTestMock implements IUserDao {

    @Override
    public void fetchUsers() {
        UserData user = new UserData();
        IUserList usrLst = new UserList();

        ArrayList<UserData> user_list = new ArrayList<>();

        String first_name = "Akash";
        String last_name = "Maniar";
        String userId = "B00841446";

        user.setUserName(first_name + " " +last_name);
        user.setInstructor(true);
        user.setUserId(userId);

        user_list.add(user);
        usrLst.setUserList(user_list);
    }

    @Override
    public boolean makeInstructor(String userId, String crsId) {

        return false;
    }


}
