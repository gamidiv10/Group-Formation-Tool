package com.advsdc.group2.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtility {
    private String userName;
    private String password;
    private String database;
    private Statement statement;
    private String connectionString;
    private String environment;
    public Connection connection;

    private static final String CONNECTION_STRING = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_2_DEVINT?serverTimezone=AST";
    public DbUtility() {
        try {
            Properties properties = new Properties();
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            InputStream propertiesStream = contextClassLoader.getResourceAsStream("application.properties");
            if (propertiesStream != null) {
                properties.load(propertiesStream);
                this.environment = System.getenv("db.environment");
                this.connectionString = properties.getProperty("db.connection");
                switch (this.environment) {
                    case "TEST":
                        this.database = properties.getProperty("db.test.database");
                        this.userName = properties.getProperty("db.test.user");
                        this.password = properties.getProperty("db.test.password");
                        break;

                    case "PRODUCTION":
                        this.database = properties.getProperty("db.prod.database");
                        this.userName = properties.getProperty("db.prod.user");
                        this.password = properties.getProperty("db.prod.password");
                        break;

                    default:
                        this.database = properties.getProperty("db.dev.database");
                        this.userName = properties.getProperty("db.dev.user");
                        this.password = properties.getProperty("db.dev.password");
                }
                this.connection = DriverManager.getConnection(
                        this.connectionString + this.database + "?serverTimezone=AST", this.userName, this.password);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        //Sample Retrieval Method
	/*
	 * public ResultSet getUsers(){ try { this.statement =
	 * this.connection.createStatement(); ResultSet rs =
	 * this.statement.executeQuery("select * from auth"); while(rs.next()){
	 * System.out.println("DB Output: " + rs.getString("UserId")); } return rs; }
	 * catch (SQLException e) { e.printStackTrace(); System.out.println(e); }
	 * finally { closeConnection(); } return null; }
	 */


    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
