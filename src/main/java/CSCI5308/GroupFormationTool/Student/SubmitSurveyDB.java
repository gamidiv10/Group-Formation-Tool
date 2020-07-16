package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubmitSurveyDB implements ISubmitSurveyDB{
    private Logger log = Logger.getLogger(SubmitSurveyDB.class.getName());
    @Override
    public boolean submitSurvey(int questionID, String answer, long courseID) {
        CallStoredProcedure proc = null;
        User user = CurrentUser.instance().getCurrentAuthenticatedUser();
        try {
            proc = new CallStoredProcedure("spSaveAnswer(?, ?, ?, ?)");
            proc.setParameter(1, questionID);
            proc.setParameter(2, answer);
            proc.setParameter(3, user.getBannerID());
            proc.setParameter(4, courseID);
            proc.execute();
        } catch (SQLException e) {
            log.log(Level.SEVERE,
                    "Encountered SQL Exception while saving the response for question id " + questionID);
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return true;
    }
}
