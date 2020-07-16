package CSCI5308.GroupFormationTool.AccessControl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Question.QuestionDB;

public class UserDB implements IUserPersistence {
    private Logger log = Logger.getLogger(UserDB.class.getName());
    public void loadUserByID(long id, User user) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spLoadUser(?)");
            proc.setParameter(1, id);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    long userID = results.getLong(1);
                    String bannerID = results.getString(2);
                    String password = results.getString(3);
                    String firstName = results.getString(4);
                    String lastName = results.getString(5);
                    String email = results.getString(6);
                    user.setID(userID);
                    user.setBannerID(bannerID);
                    user.setPassword(password);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while loading the user " + id);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
    }

    public void loadUserByBannerID(String bannerID, User user) {
        CallStoredProcedure proc = null;
        long userID = -1;
        try {
            proc = new CallStoredProcedure("spFindUserByBannerID(?)");
            proc.setParameter(1, bannerID);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    userID = results.getLong(1);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while loading user by banner ID " + bannerID);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        if (userID > -1) {
            loadUserByID(userID, user);
        }
    }

    public boolean createUser(User user) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spCreateUser(?, ?, ?, ?, ?, ?)");
            proc.setParameter(1, user.getBannerID());
            proc.setParameter(2, user.getPassword());
            proc.setParameter(3, user.getFirstName());
            proc.setParameter(4, user.getLastName());
            proc.setParameter(5, user.getEmail());
            proc.registerOutputParameterLong(6);
            proc.execute();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while creating the user " + user.getBannerID());
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        log.log(Level.INFO, "User " + user.getBannerID() + " created");
        return true;
    }

    public boolean updateUser(User user) {
        return false;
    }
}
