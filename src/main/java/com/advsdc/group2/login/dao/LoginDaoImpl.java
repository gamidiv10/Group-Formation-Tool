package com.advsdc.group2.login.dao;
import com.advsdc.group2.course.models.Course;
import com.advsdc.group2.utility.DbUtility;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class LoginDaoImpl implements ILoginDao {

    @Override
    public String getUserCredentials(String userId){
        DbUtility dbUtility = new DbUtility();
        try{
            PreparedStatement statement = dbUtility.connection.prepareStatement("select password from user_auth where user_id = ?");
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("password");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            dbUtility.closeConnection();
        }
        return null;
    }

    @Override
    public int getRole(String userId) {
        DbUtility dbUtility = new DbUtility();
        try{
            PreparedStatement statement = dbUtility.connection.prepareStatement("select max(role_id) from user_role_map where user_id = ?");
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("max(role_id)");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            dbUtility.closeConnection();
        }
        return 6;
    }

    @Override
    public ArrayList<Course> getCourses(String userId) {
        DbUtility dbUtility = new DbUtility();
        try{
            PreparedStatement statement = dbUtility.connection.prepareStatement("select * from user_course_enrollment inner join courses on courses.course_id = user_course_enrollment.course_id and user_course_enrollment.user_id= ?");
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Course> courseList = new ArrayList<>();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getString("course_id"));
                course.setCourseName(resultSet.getString("course_name"));
                course.setCourseDesc(resultSet.getString("course_description"));
                courseList.add(course);
            }
            return courseList;
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            dbUtility.closeConnection();
        }
        return null;
    }
}
