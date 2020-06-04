package com.advsdc.group2.model;

public class UserRoleMap implements IUserRoleMap {
	public String role_map_id;
	public String user_id;
	public String course_id;
	public String role_id;
	public String getRole_map_id() {
		return role_map_id;
	}
	public void setRole_map_id(String role_map_id) {
		this.role_map_id = role_map_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

}
