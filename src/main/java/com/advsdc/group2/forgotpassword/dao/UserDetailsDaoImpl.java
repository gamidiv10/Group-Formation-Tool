package com.advsdc.group2.forgotpassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.advsdc.group2.model.IUserInfo;
import com.advsdc.group2.utility.DbUtility;

public class UserDetailsDaoImpl implements IUserDetailsDao {

	@Override
	public void getUserInfo(String bannerID, IUserInfo user) {
		// TODO Auto-generated method stub
		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;

		try {

			String sql = "SELECT * FROM user WHERE user_id = ?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, bannerID);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("first_name"));
				System.out.println(rs.getString("last_name"));

				user.setEmail(rs.getString("email"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_id(rs.getString("user_id"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			dbConnection.closeConnection();
		}

		// TODO Auto-generated method stub

	}

}
