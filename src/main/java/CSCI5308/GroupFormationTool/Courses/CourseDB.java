package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Question.QuestionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDB implements ICoursePersistence {
    private Logger log = Logger.getLogger(CourseDB.class.getName());
    public List<Course> loadAllCourses() {
        List<Course> courses = new ArrayList<Course>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spLoadAllCourses()");
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    long id = results.getLong(1);
                    String title = results.getString(2);
                    Course c = new Course();
                    c.setId(id);
                    c.setTitle(title);
                    courses.add(c);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while loading courses");
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return courses;
    }

    public void loadCourseByID(long id, Course course) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindCourseByID(?)");
            proc.setParameter(1, id);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    String title = results.getString(2);
                    course.setId(id);
                    course.setTitle(title);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while loading course with ID " + id);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
    }

    public boolean createCourse(Course course) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spCreateCourse(?, ?)");
            proc.setParameter(1, course.getTitle());
            proc.registerOutputParameterLong(2);
            proc.execute();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while creating course " + course.getTitle());
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return true;
    }

    public boolean deleteCourse(long id) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spDeleteCourse(?)");
            proc.setParameter(1, id);
            proc.execute();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while deleting course " + id);
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return true;
    }
}
