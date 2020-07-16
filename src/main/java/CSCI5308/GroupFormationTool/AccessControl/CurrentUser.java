package CSCI5308.GroupFormationTool.AccessControl;

import CSCI5308.GroupFormationTool.Question.QuestionDao;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import CSCI5308.GroupFormationTool.SystemConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentUser {
    private Logger log = Logger.getLogger(CurrentUser.class.getName());
    private static CurrentUser uniqueInstance = null;

    private CurrentUser() {

    }

    public static CurrentUser instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CurrentUser();
        }
        return uniqueInstance;
    }

    public User getCurrentAuthenticatedUser() {
        IUserPersistence userDB = SystemConfig.instance().getUserDB();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            String bannerID = authentication.getPrincipal().toString();
            User u = new User();
            userDB.loadUserByBannerID(bannerID, u);
            if (u.isValidUser()) {
                log.log(Level.INFO, "Current User " + u.getBannerID() + " retrieved");
                return u;
            }
        }
        return null;
    }
}
