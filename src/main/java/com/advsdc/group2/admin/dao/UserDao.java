package com.advsdc.group2.admin.dao;

import com.advsdc.group2.model.CourseUserMap;
import com.advsdc.group2.model.User;
import com.advsdc.group2.model.UserList;
import com.advsdc.group2.utility.DbUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao implements IUserDao {

    UserList userLst = new UserList();
    CourseUserMap crs_usr_map = new CourseUserMap();

    @Override
    public void fetchUsers() {
        String userId = "";
        String first_name = "";
        String last_name = "";
        ArrayList<User> uList = new ArrayList<>();

        DbUtility dbConnection = new DbUtility();
        Connection con = dbConnection.connection;

        try {


            boolean isInstructor;

            String queryString = "select * from user";
            PreparedStatement statement = con.prepareStatement(queryString, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet res1 = statement.executeQuery();
            res1.first();

            while(res1.next()) {
                isInstructor = false;
                userId = res1.getString("user_id");
                first_name = res1.getString("first_name");
                last_name = res1.getString("last_name");

                String q = "select count(role_map_id) as count from user_role_map where user_id="+"'"+ userId +"'"+"and role_id='2'";
                PreparedStatement st = con.prepareStatement(q, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet res2 = st.executeQuery();
                if (res2.first()) {
                    if(res2.getString("count").equals("1")) {
                        isInstructor = true;
                    }
                }

                User user = new User();
                user.setUserId(userId);
                user.setUserName(first_name +" "+ last_name);
                user.setInstructor(isInstructor);
                uList.add(user);

            }

            userLst.setUserList(uList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConnection.closeConnection();
        }
    }

    @Override
    public boolean makeInstructor(String usrId, String crsId) {
        DbUtility dbConnection = new DbUtility();
        Connection con = dbConnection.connection;
        try {
            System.out.println("Course id"+crsId);
            System.out.println("User id"+usrId);

            String existingIns = "select count(role_map_id) as count from user_role_map where course_id="+ "'" + crsId + "'" + " and user_id="+"'" + usrId + "'"+ " and role_id='2'";
            PreparedStatement statement = con.prepareStatement(existingIns, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet res = statement.executeQuery();
            res.first();

            if(Integer.valueOf(res.getString("count")) > 0) {
                crs_usr_map.setMessage("Already a  existing Instructor");
            } else {
                String assingIns = "insert into user_role_map (user_id, course_id, role_id) values ('"+ usrId+ "'," + "'" +crsId +"'," + "'2')";
                System.out.println(assingIns);
                PreparedStatement ps = con.prepareStatement(assingIns);
                int rowAffected = ps.executeUpdate();

                if(rowAffected > 0) {
                    crs_usr_map.setMessage("Assigned instructor successfully");
                } else {
                    crs_usr_map.setMessage("There is some problem in updating data, make sure Course ID is correct");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConnection.closeConnection();
        }
        return false;
    }
}
