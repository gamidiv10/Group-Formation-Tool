package com.advsdc.group2.forgotpassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.advsdc.group2.model.IUserInfo;
import com.advsdc.group2.model.User;
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

	@Override
	public List<User> getTAList(String courseID) {
		// TODO Auto-generated method stub

		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;
		List<User> taList = new ArrayList<User>();

		try {

			String sql = "SELECT user_role_map.user_id,user.first_name,user.last_name,user.email FROM user_role_map inner join user on user_role_map.user_id = user.user_id WHERE user_role_map.role_id = 3 and user_role_map.course_id =?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, courseID);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				User user = new User();

				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("first_name"));
				System.out.println(rs.getString("last_name"));
				System.out.println(rs.getString("user_id"));
				user.setEmail(rs.getString("email"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_id(rs.getString("user_id"));

				taList.add(user);
				System.out.println("Inside Try list : " + taList);

			}

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

		finally {
			dbConnection.closeConnection();
		}
		System.out.println("TA user list " + taList);

		return taList;
	}

	@Override
	public User showUsers(String courseID, String bannerID) {
		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;
		User showUser = new User();

		try {

			String sql = "SELECT u.user_id,u.email,u.first_name,u.last_name,u.email from  user u WHERE u.user_id not in ( select user_id from user_role_map WHERE (user_role_map.role_id= 2 or user_role_map.role_id= 3 or user_role_map.role_id= 4) and user_role_map.course_id =? and u.user_id =? ) and u.user_id  =? ;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, courseID);
			pst.setString(2, bannerID);
			pst.setString(3, bannerID);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("first_name"));
				System.out.println(rs.getString("last_name"));
				System.out.println(rs.getString("user_id"));

				showUser.setEmail(rs.getString("email"));
				showUser.setFirst_name(rs.getString("first_name"));
				showUser.setLast_name(rs.getString("last_name"));
				showUser.setUser_id(rs.getString("user_id"));

			}

		} catch (Exception e) {
			System.out.println(e);
			return showUser;
		}

		finally {
			dbConnection.closeConnection();
		}
		System.out.println("Inside Try list bannerID in object : " + showUser.getUser_id());
		System.out.println("User in Email " + showUser.getEmail());

		return showUser;
	}

	@Override
	public int add(String courseID, String bannerID) {

		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;
		System.out.println("BannerID from Controller" + bannerID);
		System.out.println("courseID from controller " + courseID);
		int records = 0;
		try {

			String sql = "INSERT INTO user_role_map (user_id,course_id,role_id) VALUES (?,?,3)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, bannerID);
			pst.setString(2, courseID);
			records = pst.executeUpdate();
			System.out.println("number of records inserted " + records);

		} catch (Exception e) {
			System.out.println(e);
			records = 0;
		}

		finally {
			dbConnection.closeConnection();
		}

		return records;

	}

}
