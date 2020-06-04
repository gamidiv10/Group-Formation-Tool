package com.advsdc.group2.model;

import java.util.ArrayList;

public class CourseMessageModel implements ICourseMessageModel {
    private ArrayList<Course> courseLst;
    private boolean isOk;
    private String message;

    public ArrayList<Course> getCourseLst() {
        return courseLst;
    }

    public void setCourseLst(ArrayList<Course> courseLst) {
        this.courseLst = courseLst;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
