package com.advsdc.group2.signup.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.advsdc.group2.signup.dbutility.DbUtility;
import com.advsdc.group2.signup.models.User;
import com.advsdc.group2.signup.security.PasswordEncryption;

public class SignupDaoImpl implements SignupDao{

	private DbUtility dbUtility;
    PasswordEncryption passwordEncryption;

	
	@Override
	public String getUserCredentials(String userId){
        this.dbUtility = new DbUtility();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{

            statement = dbUtility.connection.prepareStatement("select password from user_auth where user_id = ?");
            statement.setString(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("password");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
        	try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
        	try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
            dbUtility.closeConnection();
        }
        
        return null;
    }
	
	@Override
	public String setUserDetails(User user){
        this.dbUtility = new DbUtility();
        PreparedStatement statementForUserAuthTable = null;
        PreparedStatement statementForUserTable = null;
        PreparedStatement statementForUserRoleMapTable = null;
        this.passwordEncryption = new PasswordEncryption();
        String encryptedPassword = passwordEncryption.encode(user.getPassword());

        try{

            statementForUserAuthTable = dbUtility.connection.prepareStatement("INSERT INTO user_auth(user_id,password) VALUES(?,?)");
            statementForUserAuthTable.setString(1, user.getUserId());
            statementForUserAuthTable.setString(2, encryptedPassword);
            boolean statusForUserAuthTableInsert = statementForUserAuthTable.execute();
            System.out.println("Insert into user_auth status: "+statusForUserAuthTableInsert);

        	
        	statementForUserTable = dbUtility.connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
            statementForUserTable.setString(1, user.getUserId());
            statementForUserTable.setString(2, user.getFirstName());
            statementForUserTable.setString(3, user.getLastName());
            statementForUserTable.setString(4, user.getEmail());
            boolean statusForUserTableInsert = statementForUserTable.execute();
            System.out.println("Insert into user status: "+statusForUserTableInsert);
            
            
            statementForUserRoleMapTable = dbUtility.connection.prepareStatement("INSERT INTO user_role_map(user_id,role_id) VALUES(?,?)");
            statementForUserRoleMapTable.setString(1, user.getUserId());
            statementForUserRoleMapTable.setString(2, "1");
            boolean statusForUserRoleMapTableInsert = statementForUserRoleMapTable.execute();
            System.out.println("Insert into user_role_map status: "+statusForUserRoleMapTableInsert);            

        }catch(Exception e){
            System.out.println(e);
        }
        finally {
        	try {
				statementForUserAuthTable.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
        	try {
				statementForUserTable.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
        	try {
				statementForUserRoleMapTable.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
            dbUtility.closeConnection();
        }
        return null;
    }

	@Override
	public List<String> getUsers() {
        this.dbUtility = new DbUtility();
        Statement statementForGetUsersFromUserAuthTable = null;
        ResultSet rs = null;
        
        try {
            statementForGetUsersFromUserAuthTable= dbUtility.connection.createStatement();
            rs = statementForGetUsersFromUserAuthTable.executeQuery("select * from user_auth");
            List<String> userNamesList = new ArrayList<String>();
            while(rs.next()) {
				userNamesList.add(rs.getString("user_id"));
                }
            System.out.println(userNamesList);
            return userNamesList;
        }        
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        finally {
        	try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
        	try {
				statementForGetUsersFromUserAuthTable.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
            dbUtility.closeConnection();
        }
        return null;
	}
}
