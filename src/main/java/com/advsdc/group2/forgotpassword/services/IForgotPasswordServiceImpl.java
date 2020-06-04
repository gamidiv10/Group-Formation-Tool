package com.advsdc.group2.forgotpassword.services;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import com.advsdc.group2.forgotpassword.dao.IUserAuth;
import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.forgotpassword.dao.UserAuthDaoImpl;
import com.advsdc.group2.forgotpassword.dao.UserDetailsDaoImpl;
import com.advsdc.group2.model.User;
import com.advsdc.group2.model.UserAuthInfo;
import com.advsdc.group2.security.*;

@Service
public class IForgotPasswordServiceImpl implements IForgotPasswordService {

	IUserDetailsDao userDet = new UserDetailsDaoImpl();
	IUserAuth userAuth = new UserAuthDaoImpl();

	@Override
	public User getUserInfo(String bannerID) {
		User u = new User(bannerID, userDet);
		return u;

	}

	@Override
	public UserAuthInfo getAuthUserInfo(String bannerID, IUserAuth userAuthDao) {
		UserAuthInfo userAuthentication = new UserAuthInfo(bannerID, userAuth);
		return userAuthentication;
	}

	@Override
	public String otpEmailGeneration(String email) {
		int oneTimepwd = generateOneTimePassword();
		System.out.println("otp method called " + oneTimepwd);
		sendOTPMail(email, oneTimepwd);
		String OTP = Integer.toString(oneTimepwd);
		System.out.println("OTP String is : " + OTP);
		return OTP;
	}

	private int generateOneTimePassword() {
		int oneTimePwd = 10000 + new Random().nextInt(90000);
		System.out.println(" otp is " + oneTimePwd);
		return oneTimePwd;
	}

	private void sendOTPMail(String email, int oneTimepwd) {
		String toAddress = email;
		String fromAddress = "advsdcgrp2.catme@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromAddress, "msdcpkaidutytdxs");
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAddress));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			message.setContent(
					"The one-time-password(OTP) is <b>" + oneTimepwd
							+ "</b>. This is valid for five minutes. <br> Please use this to reset your password.",
					"text/html; charset=utf-8");

			message.setSubject("One-time-password (OTP) for resetting your password ");
			Transport.send(message);
			System.out.println("Email sent successfully..");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public int oneTimePwdInsertion(String code, UserAuthInfo userAuth, IUserAuth userAuthDao) {
		int rows = userAuthDao.oneOTPInsertion(Integer.parseInt(code), userAuth);
		return rows;
	}

	@Override
	public void OTPValidation(String code, UserAuthInfo userAuth, IUserAuth userAuthDao) {
		userAuthDao.OTPValidation(code, userAuth, userAuthDao);
	}

	@Override
	public int setNewPassword(UserAuthInfo userAuth, IUserAuth userAuthDao) {

		String pwdFromController = userAuth.getPassword();
		PasswordEncryption enc = new PasswordEncryption();
		String encryptedPassword = enc.encode(pwdFromController);
		System.out.println("Encrypted Password output " + encryptedPassword);
		userAuth.setPassword(encryptedPassword);

		int insertedRecord = userAuthDao.setNewPassword(userAuth, userAuthDao);
		return insertedRecord;
	}

}
