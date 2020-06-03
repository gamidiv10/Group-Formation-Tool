package com.advsdc.group2.utility;

import java.sql.*;

public class DbUtility {
    private final String USER_NAME;
    private final String PASSWORD;
    private Statement statement;
    public Connection connection;

    private static final String CONNECTION_STRING = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_2_DEVINT";
    public DbUtility() {
        this.USER_NAME = "CSCI5308_2_DEVINT_USER";
        this.PASSWORD = "CSCI5308_2_DEVINT_2009";
        try {
            this.connection = DriverManager.getConnection(
                    CONNECTION_STRING, this.USER_NAME, this.PASSWORD);

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }


    //Sample Retrieval Method
    public ResultSet getUsers(){
        try {
            this.statement = this.connection.createStatement();
            ResultSet rs = this.statement.executeQuery("select * from user_auth");
            while(rs.next()){
                System.out.println("DB Output: " + rs.getString("UserId"));
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        finally {
            closeConnection();
        }
        return null;
    }


    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
