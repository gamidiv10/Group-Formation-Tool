package com.advsdc.group2.forgotpassword.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advsdc.group2.forgotpassword.dao.IUserAuth;
import com.advsdc.group2.forgotpassword.dao.IUserDetailsDao;
import com.advsdc.group2.forgotpassword.dao.UserAuthDaoImpl;
import com.advsdc.group2.forgotpassword.dao.UserDetailsDaoImpl;
import com.advsdc.group2.forgotpassword.forms.ForgotPasswordForms;
import com.advsdc.group2.forgotpassword.services.IForgotPasswordService;
import com.advsdc.group2.forgotpassword.services.IForgotPasswordServiceImpl;
import com.advsdc.group2.model.User;
import com.advsdc.group2.model.UserAuthInfo;

@Controller
public class ForgotPasswordController {

	IUserAuth userAuthDao = new UserAuthDaoImpl();
	IUserDetailsDao userInfo = new UserDetailsDaoImpl();

	@GetMapping("/resetPassword")
	public String intitalLanding(Model model) {

		model.addAttribute("resetPassword", new ForgotPasswordForms());

		return "forgot_password";
	}

	@PostMapping("/OTPgenerate")
	public String resetPwd(@ModelAttribute ForgotPasswordForms formModel, Model model) {
		IForgotPasswordService fpsw = new IForgotPasswordServiceImpl();
		User u = fpsw.getUserInfo(formModel.getBannerID());
		UserAuthInfo userAuth = fpsw.getAuthUserInfo(formModel.getBannerID(), userAuthDao);

		if (u.getEmail() != null) {
			System.out.println("Banner ID " + u.getUser_id());
			System.out.println(" Email " + u.getEmail());
			String code = fpsw.otpEmailGeneration(u.getEmail());
			System.out.println("OTP in Controller " + code);
			model.addAttribute("resetPassword", formModel);

			model.addAttribute("validatingPwd", formModel);
			fpsw.oneTimePwdInsertion(code, userAuth, userAuthDao);

			return "change_password";
		}

		else {
			formModel.setCheckEmail("notExist");
			model.addAttribute("resetPassword", formModel);
			return "forgot_password";
		}

	}

	@PostMapping("/pwdChange")
	public String passwordChange(@ModelAttribute ForgotPasswordForms formModel, Model model) {

		IForgotPasswordService fpsw = new IForgotPasswordServiceImpl();
		User u = fpsw.getUserInfo(formModel.getOneTimepassword());

		UserAuthInfo userAuth = fpsw.getAuthUserInfo(formModel.getBannerID(), userAuthDao);

		String code = formModel.getOneTimepassword();

		fpsw.OTPValidation(code, userAuth, userAuthDao);

		Timestamp otpValidation = userAuth.getOtpTime();
		model.addAttribute("validatingPwd", formModel);

		System.out.println("OTP Time value from DB :" + otpValidation);

		Instant time = Instant.now();
		System.out.println("Instant time value :" + time);
		Duration timeDiff = Duration.between(time, otpValidation.toInstant());
		
		
		System.out.println("newPassword Model :"+formModel.getNewPassword());
		System.out.println("reenter pwd Model :" +formModel.getReEnterPassword());
		
		
		
		if (!(formModel.getNewPassword()).equals(formModel.getReEnterPassword())) {

			System.out.println("Passwords don't match: ");
			formModel.setPassWordMatch(true);
			formModel.setOtpMatch(false);
			formModel.setOtpExpiry(false);

			return "change_password";
		} else if (userAuth.getOneTimePassword() != Integer.parseInt(formModel.getOneTimepassword())) {

			System.out.println("OTP don't match: ");
			formModel.setPassWordMatch(false);
			formModel.setOtpMatch(true);
			formModel.setOtpExpiry(false);

			return "change_password";

		} else if ((timeDiff.toMillis()) > 30000000)

		{
			System.out.println("OTP expired : " + timeDiff.toMillis());

			formModel.setPassWordMatch(false);
			formModel.setOtpMatch(false);
			formModel.setOtpExpiry(true);
			return "change_password";

		}

		else {
			System.out.println("All correct");
			userAuth.setPassword(formModel.getReEnterPassword());
			fpsw.setNewPassword(userAuth, userAuthDao);
			System.out.println("Password Changed");

			return "index";

		}

	}

}
