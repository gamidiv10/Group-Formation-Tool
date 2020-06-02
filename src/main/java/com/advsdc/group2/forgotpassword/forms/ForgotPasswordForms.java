package com.advsdc.group2.forgotpassword.forms;

public class ForgotPasswordForms {
	
	private String bannerID;
	private String checkEmail;
	private String newPassword;
	private String oneTimepassword;
	private String reEnterPassword;
	private boolean otpExpiry = false;
	private boolean passWordMatch = false;
	private boolean otpMatch = false;
	
	public boolean isOtpExpiry() {
		return otpExpiry;
	}

	public void setOtpExpiry(boolean otpExpiry) {
		this.otpExpiry = otpExpiry;
	}

	public boolean isPassWordMatch() {
		return passWordMatch;
	}

	public void setPassWordMatch(boolean passWordMatch) {
		this.passWordMatch = passWordMatch;
	}

	public boolean isOtpMatch() {
		return otpMatch;
	}

	public void setOtpMatch(boolean otpMatch) {
		this.otpMatch = otpMatch;
	}

	public String getReEnterPassword() {
		return reEnterPassword;
	}

	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}

	public String getOneTimepassword() {
		return oneTimepassword;
	}

	public void setOneTimepassword(String oneTimepassword) {
		this.oneTimepassword = oneTimepassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(String checkEmail) {
		this.checkEmail = checkEmail;
	}

	public String getBannerID() {
		return bannerID;
	}

	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
	}


}
