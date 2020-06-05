package com.advsdc.group2.course.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.advsdc.group2.model.User;
import com.advsdc.group2.utility.DbUtility;

public class ImportCsvDao implements IImportCsvDao {

    @Override
    public void enrollInCourse(String userId, String courseId) {
        DbUtility dbUtility = new DbUtility();
        try{
            PreparedStatement statement = dbUtility.connection.prepareStatement("INSERT INTO user_role_map(user_id,course_id,role_id) VALUES(?,?,?)");
            statement.setString(1, userId);
            statement.setString(2, courseId);
            statement.setInt(3, 4);
            boolean statusForUserRoleMapTableInsert = statement.execute();
            System.out.println("Insert into user_role_map status: "+statusForUserRoleMapTableInsert);
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            dbUtility.closeConnection();
        }
    }

    @Override
    public int getRoleForCourse(String userId, String courseId) {
        DbUtility dbUtility = new DbUtility();
        try{
            PreparedStatement statement = dbUtility.connection.prepareStatement("select role_id from user_role_map where user_id = ? and course_id = ?");
            statement.setString(1, userId);
            statement.setString(2, courseId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("role_id");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            dbUtility.closeConnection();
        }
        return 6;
    }
    
}