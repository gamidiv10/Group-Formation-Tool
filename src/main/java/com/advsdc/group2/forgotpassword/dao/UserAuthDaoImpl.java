package com.advsdc.group2.forgotpassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.advsdc.group2.model.IUserAuthInfo;
import com.advsdc.group2.model.UserAuthInfo;
import com.advsdc.group2.utility.DbUtility;

public class UserAuthDaoImpl implements IUserAuth {

	@Override
	public void getUserAuthDetails(String bannerID, IUserAuthInfo userAuth) {
		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;

		try {

			String sql = "SELECT * FROM user_auth WHERE user_id = ?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, bannerID);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				// userAuth.setOneTimePassword(rs.getInt("oneTimePassword"));
				// userAuth.setOtpTime(rs.getString("otpTime"));
				// userAuth.setPassword(rs.getString("password"));
				userAuth.setUser_id(rs.getString("user_id"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			dbConnection.closeConnection();
		}

	}

	public int oneOTPInsertion(int code, UserAuthInfo userAuthInfo) {
		// TODO Auto-generated method stub

		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;
		try {

			String sql = "UPDATE user_auth SET otp=?,otp_time=current_timestamp() WHERE user_id = ?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, code);
			pst.setString(2, userAuthInfo.getUser_id());
			int records = pst.executeUpdate();
			System.out.println("number of records inserted " + records);

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			dbConnection.closeConnection();
		}
		
		return 1;

	}

	public void OTPValidation(String code, UserAuthInfo userAuthInfo, IUserAuth userAuthDao) {
		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;
		String oneTimePassword = null;
		Timestamp otpTime = null;

		try {
			System.out.println("OTPValidation DB call ");
			System.out.println("BannerID is : " + userAuthInfo.getUser_id());
			String sql = "SELECT otp,otp_time FROM user_auth WHERE user_id = ?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, userAuthInfo.getUser_id());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				oneTimePassword = rs.getString("otp");
				otpTime = rs.getTimestamp("otp_time");
				System.out.println("DB CAll : " + oneTimePassword);
				System.out.println("DB CAll  : " + otpTime);

				userAuthInfo.setOneTimePassword(Integer.parseInt(oneTimePassword));
				userAuthInfo.setOtpTime(otpTime);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			dbConnection.closeConnection();
		}
	}

	@Override
	public int setNewPassword(UserAuthInfo userAuth, IUserAuth userAuthDao) {

		DbUtility dbConnection = new DbUtility();
		Connection con = dbConnection.connection;
		int records =0;

		try {

			String sql = "UPDATE user_auth SET password=?,otp='' WHERE user_id = ?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, userAuth.getPassword());
			
			pst.setString(2, userAuth.getUser_id());
			records = pst.executeUpdate();
			System.out.println("number of records inserted " + records);

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			dbConnection.closeConnection();
		}
		
		return records;

	}

}
