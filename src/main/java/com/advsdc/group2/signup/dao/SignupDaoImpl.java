package com.advsdc.group2.signup.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.advsdc.group2.signup.dbutility.DbUtility;
import com.advsdc.group2.signup.models.User;
import com.advsdc.group2.signup.security.PasswordEncryption;

public class SignupDaoImpl implements SignupDao{

	private DbUtility dbUtility;
    PasswordEncryption passwordEncryption = new PasswordEncryption();

	
	@Override
	public String getUserCredentials(String userId){
        this.dbUtility = new DbUtility();
        try{

            PreparedStatement statement = dbUtility.connection.prepareStatement("select password from user_auth where user_id = ?");
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("password");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            dbUtility.closeConnection();
        }
        
        return null;
    }
	
	@Override
	public String setUserDetails(User user){
        this.dbUtility = new DbUtility();
        try{

            PreparedStatement statementForUserAuthTable = dbUtility.connection.prepareStatement("INSERT INTO user_auth(user_id,password) VALUES(?,?)");
            statementForUserAuthTable.setString(1, user.getUserId());
            String encryptedPassword = passwordEncryption.encode(user.getPassword());
            statementForUserAuthTable.setString(2, encryptedPassword);
            boolean statusForUserAuthTableInsert = statementForUserAuthTable.execute();
            System.out.println("Insert into user_auth status: "+statusForUserAuthTableInsert);

        	
        	PreparedStatement statementForUserTable = dbUtility.connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
            statementForUserTable.setString(1, user.getUserId());
            statementForUserTable.setString(2, user.getFirstName());
            statementForUserTable.setString(3, user.getLastName());
            statementForUserTable.setString(4, user.getEmail());
            boolean statusForUserTableInsert = statementForUserTable.execute();
            System.out.println("Insert into user status: "+statusForUserTableInsert);
            
            
            PreparedStatement statementForUserRoleMapTable = dbUtility.connection.prepareStatement("INSERT INTO user_role_map(user_id,role_id) VALUES(?,?)");
            statementForUserRoleMapTable.setString(1, user.getUserId());
            statementForUserRoleMapTable.setString(2, "1");
            boolean statusForUserRoleMapTableInsert = statementForUserRoleMapTable.execute();
            System.out.println("Insert into user_role_map status: "+statusForUserRoleMapTableInsert);            

        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            dbUtility.closeConnection();
        }
        return null;
    }

	@Override
	public ResultSet getUsers() {
        this.dbUtility = new DbUtility();
        try {
            Statement statementForGetUsersFromUserAuthTable= dbUtility.connection.createStatement();
            ResultSet rs = statementForGetUsersFromUserAuthTable.executeQuery("select * from user_auth");
            return rs;
        }        
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        dbUtility.closeConnection();
        return null;
	}
}
