package com.advsdc.group2.login.dao;

import com.advsdc.group2.login.models.UserCredentials;

import java.sql.*;

public class LoginDaoImpl implements LoginDao{
    public UserCredentials getUserCredentials(String userId){

        UserCredentials uc = new UserCredentials();

        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_2_DEVINT","CSCI5308_2_DEVINT_USER","CSCI5308_2_DEVINT_2009");

            PreparedStatement statement = con.prepareStatement("select * from auth where UserId = ?");
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("UserId"));

            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return uc;
    }

}
