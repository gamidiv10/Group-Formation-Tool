package CSCI5308.GroupFormationTool.Question;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Student.SubmitSurveyDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDao implements IQuestionDB {
    private Logger log = Logger.getLogger(QuestionDao.class.getName());
    @Override
    public int saveQuestion(Question question, String instructorId, int typeId) {

        int questionIdFromDB = -1;
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spCreateQuestion(?, ?, ?, ?)");
            proc.setParameter(1, question.getQuestionTitle());
            proc.setParameter(2, typeId);
            proc.setParameter(3, question.getQuestionText());
            proc.setParameter(4, instructorId);
            ResultSet resultSet = proc.executeWithResults();
            while (resultSet.next()) {
                questionIdFromDB = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while saving the question " + question.getQuestionTitle());
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        log.log(Level.INFO, "Question saved to the DB");
        return questionIdFromDB;
    }

    @Override
    public boolean saveMcq(Option option, int questionId) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spInsertOptions(?, ?, ?)");
            proc.setParameter(1, questionId);
            proc.setParameter(2, option.getDisplayText());
            proc.setParameter(3, option.getStoredAs());
            proc.execute();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while saving the option for question " + questionId);
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        log.log(Level.INFO, "Option is saved for Question " + questionId);
        return true;
    }
}
