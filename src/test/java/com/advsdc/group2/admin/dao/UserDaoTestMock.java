package com.advsdc.group2.admin.dao;
import com.advsdc.group2.model.IUser;
import com.advsdc.group2.model.IUserList;
import com.advsdc.group2.model.User;
import com.advsdc.group2.model.UserList;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTestMock implements IUserDao {

    @Override
    public void fetchUsers() {
        User user = new User();
        IUserList usrLst = new UserList();

        ArrayList<User> user_list = new ArrayList<>();

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
