package com.advsdc.group2.course.models;

public class Course implements ICourse{
    public String courseId;
    public String courseName;
    public String courseDesc;
    public String getCourseId(){
        return this.courseId;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public String getCourseDesc(){
        return this.courseDesc;
    }
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }public void setCourseDesc(String courseDesc){
        this.courseDesc = courseDesc;
    }

}
