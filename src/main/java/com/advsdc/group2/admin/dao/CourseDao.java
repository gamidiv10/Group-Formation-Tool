package com.advsdc.group2.admin.dao;

import com.advsdc.group2.model.Course;
import com.advsdc.group2.model.CourseMessageModel;
import com.advsdc.group2.utility.DbUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDao implements ICourseDao {
    private String course_id;
    private String course_name;
    private String course_desc;

    @Override
    public void getCourseList(CourseMessageModel crsm) {
        ArrayList<Course> courses = new ArrayList<>();

        DbUtility dbConnection = new DbUtility();
        Connection con = dbConnection.connection;
        try {
            String queryCourses = "select * from courses";
            PreparedStatement statement = con.prepareStatement(queryCourses);
            ResultSet res = statement.executeQuery();
            while(res.next()) {
                course_id = res.getString("course_id");
                course_name = res.getString("course_name");
                course_desc = res.getString("course_description");

                Course courseObj = new Course();
                courseObj.setCourseId(course_id);
                courseObj.setCourseName(course_name);
                courseObj.setCourseDescription(course_desc);

                courses.add(courseObj);
                crsm.setCourseLst(courses);
                crsm.setOk(true);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbConnection.closeConnection();
        }
    }
    private boolean isCourseExists(ArrayList<Course> crsLst, String courseId) {
        for(int i=0; i<crsLst.size(); i++) {
            if (crsLst.get(i).getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }
    private ArrayList<Course> deleteCourseFromList(ArrayList<Course> crsLst, String courseId) {
        ArrayList<Course> listCrs = new ArrayList<>();
        listCrs = crsLst;
        for (int i=0; i < crsLst.size(); i++) {
            if(crsLst.get(i).getCourseId().equals(courseId)) {
                listCrs.remove(i);
            }
        }
        return listCrs;
    }

    @Override
    public void addCourse(CourseMessageModel crsm, Course course) {
        boolean isExistingCourse = isCourseExists(crsm.getCourseLst(), course.getCourseId());
        if (isExistingCourse) {
            crsm.setOk(false);
            crsm.setMessage("Already Existing course");
        } else {

            DbUtility dbConnection = new DbUtility();
            Connection con = dbConnection.connection;
            try {
                course_id = course.getCourseId();
                course_name = course.getCourseName();
                course_desc = course.getCourseDescription();

                String queryString = "insert into courses values(" + "'"+course_id+"'" + "," + "'"+course_name+"'" + "," + "'"+course_desc+"'" + ")";
                PreparedStatement statement = con.prepareStatement(queryString);
                Integer isQueryOk = statement.executeUpdate();

                if (isQueryOk == 1) {
                    ArrayList<Course> courseList;
                    courseList = crsm.getCourseLst();
                    courseList.add(course);
                    crsm.setCourseLst(courseList);
                    crsm.setOk(true);
                    crsm.setMessage("Added course successfully");
                } else {
                    crsm.setOk(true);
                    crsm.setMessage("No row affected");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                dbConnection.closeConnection();
            }
        }
    }

    @Override
    public void deleteCourse(CourseMessageModel crsm, String courseId) {

            DbUtility dbConnection = new DbUtility();
            Connection con = dbConnection.connection;
            try {
                String delUserEnrolment = "delete from user_course_enrollment where course_id="+ "'" + courseId + "'";
                String delRoleMap = "delete from user_role_map where course_id="+ "'" + courseId + "'";
                String delCourse = "delete from courses where course_id="+ "'" + courseId + "'";

//              Doing Cascade delete
                PreparedStatement statement = con.prepareStatement(delUserEnrolment);
                statement.executeUpdate();

                statement = con.prepareStatement(delRoleMap);
                statement.executeUpdate();

                statement = con.prepareStatement(delCourse);
                Integer isQueryOk = statement.executeUpdate();

                if(isQueryOk == 1) {
                    ArrayList<Course> courseList = crsm.getCourseLst();

                    courseList = deleteCourseFromList(courseList, courseId);
                    crsm.setCourseLst(courseList);
                    crsm.setOk(true);
                    crsm.setMessage("Deleted course successfully");

                        } else {
                            crsm.setOk(true);
                            crsm.setMessage("Can't delete the course");
                        }

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                dbConnection.closeConnection();
            }
        }
}
