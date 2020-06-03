package com.advsdc.group2.login.dao;
import com.advsdc.group2.utility.DbUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements ILoginDao {

    public String getUserCredentials(String userId){
        DbUtility dbUtility = new DbUtility();
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

}
