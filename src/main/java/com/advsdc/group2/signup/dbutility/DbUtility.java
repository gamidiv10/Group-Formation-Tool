package com.advsdc.group2.signup.dbutility;

import java.sql.*;

public class DbUtility {
    private final String USER_NAME;
    private final String PASSWORD;
    public Connection connection;


    private static final String CONNECTION_STRING = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_2_DEVINT?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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

    public void closeConnection(){
        try {
            if(this.connection!=null)
            	this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
