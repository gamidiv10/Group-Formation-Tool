package CSCI5308.GroupFormationTool.Security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class UserHistoryRelationshipDB implements IUserHistroyRelationshipPersistence {

    @Override
    public boolean insertPasswordtoHistory(User user) {

        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spInsertPasswordToHistory(?)");
            proc.setParameter(1, user.getBannerID());

            proc.execute();
        } catch (SQLException e) {

            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return true;

    }

    @Override
    public List<String> getPreviousPasswords(User user, int historyConstraint) {

        CallStoredProcedure proc = null;

        List<String> prevPwd = new ArrayList<String>();

        try {
            proc = new CallStoredProcedure("spGetPreviousPasswords(?,?)");
            proc.setParameter(1, user.getID());
            proc.setParameter(2, historyConstraint);

            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    String pwd = results.getString("password");
                    prevPwd.add(pwd);

                }
            }
            proc.execute();
        } catch (SQLException e) {

        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }

        return prevPwd;
    }

}
