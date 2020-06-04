package com.advsdc.group2.ta.taforms;

public class TAEnrollmentForms {

	public String bId;
	public boolean isTAExist = false;
	public boolean isSearchUser = false;
	public String bannerID;
	public String first_name;
	public String last_name;
	public String email;
	public String courseID;
	public boolean isaddedTA =false;

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public boolean isTAExist() {
		return isTAExist;
	}

	public void setTAExist(boolean isTAExist) {
		this.isTAExist = isTAExist;
	}

	public boolean isSearchUser() {
		return isSearchUser;
	}

	public void setSearchUser(boolean isSearchUser) {
		this.isSearchUser = isSearchUser;
	}

	public String getBannerID() {
		return bannerID;
	}

	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public boolean isIsaddedTA() {
		return isaddedTA;
	}

	public void setIsaddedTA(boolean isaddedTA) {
		this.isaddedTA = isaddedTA;
	}

}
