package CSCI5308.GroupFormationTool.Security;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import CSCI5308.GroupFormationTool.Courses.CourseDB;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class PasswordEnforcementPolicyDB implements IPasswordEnforcementPolicyPersistence {
    private Logger log = Logger.getLogger(PasswordEnforcementPolicyDB.class.getName());
    @Override
    public void loadPasswordEnforcementPolicy(PasswordEnforcementPolicy policy) {
        CallStoredProcedure proc = null;

        try {
            proc = new CallStoredProcedure("spPasswordEnforcementPolicy()");
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    int minLength = results.getInt("minLength");
                    int maxLength = results.getInt("maxLength");
                    int minUpperCase = results.getInt("minUpperCase");
                    int minLowerCase = results.getInt("minLowerCase");
                    int minSpecialChar = results.getInt("minSpecialChar");
                    String notAllowedChar = results.getString("notAllowedChar");
                    int historyConstraint = results.getInt("historyConstraint");
                    System.out.println("MinLength value " + minLength);
                    System.out.println("MaxLength value " + maxLength);
                    System.out.println("upper value " + minUpperCase);
                    System.out.println("lowecase value " + minLowerCase);
                    System.out.println("special char value " + minSpecialChar);
                    System.out.println("not alllowed char value " + notAllowedChar);

                    policy.setMinLength(minLength);
                    policy.setMaxLength(maxLength);
                    policy.setMinUpperCase(minUpperCase);
                    policy.setMinLowerCase(minLowerCase);
                    policy.setMinSpecialChar(minSpecialChar);
                    policy.setNotAllowedChar(notAllowedChar);
                    policy.setHistoryConstraint(historyConstraint);
                }
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while saving password policy to DB");
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }

    }

}
