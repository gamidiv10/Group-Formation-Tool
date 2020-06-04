package com.advsdc.group2.model;

import java.util.ArrayList;

public interface ICourseMessageModel {
    ArrayList<Course> getCourseLst();

    void setCourseLst(ArrayList<Course> courseLst);

    boolean isOk();

    void setOk(boolean ok);

    String getMessage();

    void setMessage(String message);
}
