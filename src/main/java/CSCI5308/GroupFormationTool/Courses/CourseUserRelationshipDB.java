package CSCI5308.GroupFormationTool.Courses;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class CourseUserRelationshipDB implements ICourseUserRelationshipPersistence {
    private Logger log = Logger.getLogger(CourseUserRelationshipDB.class.getName());
    public List<User> findAllUsersWithoutCourseRole(Role role, long courseID) {
        List<User> users = new ArrayList<User>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindUsersWithoutCourseRole(?, ?)");
            proc.setParameter(1, role.toString());
            proc.setParameter(2, courseID);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    long userID = results.getLong(1);
                    String bannerID = results.getString(2);
                    String firstName = results.getString(3);
                    String lastName = results.getString(4);
                    User u = new User();
                    u.setID(userID);
                    u.setBannerID(bannerID);
                    u.setFirstName(firstName);
                    u.setLastName(lastName);
                    users.add(u);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while loading user without course role for course " + courseID);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return users;
    }

    public List<User> findAllUsersWithCourseRole(Role role, long courseID) {
        List<User> users = new ArrayList<User>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spFindUsersWithCourseRole(?, ?)");
            proc.setParameter(1, role.toString());
            proc.setParameter(2, courseID);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    long userID = results.getLong(1);
                    User u = new User();
                    u.setID(userID);
                    users.add(u);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while loading users with a course role for course " + courseID);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return users;
    }

    public boolean enrollUser(Course course, User user, Role role) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spEnrollUser(?, ?, ?)");
            proc.setParameter(1, course.getId());
            proc.setParameter(2, user.getID());
            proc.setParameter(3, role.toString());
            proc.execute();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while enrolling user " + user.getID() + " for course " + course.getId() + " with role " + role.toString());
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return true;
    }

    public List<Role> loadUserRolesForCourse(Course course, User user) {
        List<Role> roles = new ArrayList<Role>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spLoadUserRolesForCourse(?, ?)");
            proc.setParameter(1, course.getId());
            proc.setParameter(2, user.getID());
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    Role role = Role.valueOf(results.getString(1).toUpperCase());
                    roles.add(role);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while loading roles of user " + user.getID() + " for course " + course.getId()) ;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return roles;
    }
}
