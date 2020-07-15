package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.SQLException;


public class SubmitSurveyDB implements ISubmitSurveyDB{

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
            System.out.println(e);
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return true;
    }
}
