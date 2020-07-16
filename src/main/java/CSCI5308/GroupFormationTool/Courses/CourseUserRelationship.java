package CSCI5308.GroupFormationTool.Courses;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.SystemConfig;

public class CourseUserRelationship implements ICourseUserRelationship {
    private Logger log = Logger.getLogger(CourseUserRelationship.class.getName());
    public boolean userHasRoleInCourse(User user, Role role, Course course) {
        if (null == user || !user.isValidUser()) {
            return false;
        }
        if (null == role) {
            return false;
        }
        if (null == course) {
            return false;
        }
        ICourseUserRelationshipPersistence userCourseRelationshipDB = SystemConfig.instance().getCourseUserRelationshipDB();
        List<Role> roles = userCourseRelationshipDB.loadUserRolesForCourse(course, user);
        if (null != roles && roles.contains(role)) {
            return true;
        }
        return false;
    }

    public List<Role> loadAllRoluesForUserInCourse(User user, Course course) {
        ICourseUserRelationshipPersistence userCourseRelationshipDB = SystemConfig.instance().getCourseUserRelationshipDB();
        List<Role> roles = userCourseRelationshipDB.loadUserRolesForCourse(course, user);
        log.log(Level.INFO, "Sending role of user " + user.getBannerID() + " for course " + course.getTitle() + " to the view");
        return roles;
    }

    public boolean enrollUserInCourse(User user, Course course, Role role) {
        ICourseUserRelationshipPersistence userCourseRelationshipDB = SystemConfig.instance().getCourseUserRelationshipDB();
        return userCourseRelationshipDB.enrollUser(course, user, role);
    }
}
