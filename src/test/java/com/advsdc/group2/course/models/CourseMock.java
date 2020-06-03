package com.advsdc.group2.course.models;

public class CourseMock {
    private String courseId;
    private String courseName;
    private String courseDesc;

    public CourseMock()
    {
        setToDefault();
    }
    public void setToDefault()
    {
        courseDesc = "C-Language";
        courseId = "1";
        courseName = "C";
    }

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
