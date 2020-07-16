package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentSurveyDB implements IStudentSurveyDB {
    private Logger log = Logger.getLogger(StudentSurveyDB.class.getName());
    @Override
    public List<Questions> retrieveQuestions(long courseID) {
        List<Questions> questions = new ArrayList<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spGetQuestions(?)");
            proc.setParameter(1, courseID);
            ResultSet resultSet = proc.executeWithResults();
            while (resultSet.next()) {
                Questions question = new Questions();
                question.setQuestionText(resultSet.getString("questionText"));
                question.setQuestionType(resultSet.getInt("typeID"));
                question.setQuestionId(resultSet.getInt("questionID"));
                questions.add(question);
                System.out.println(question);
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE,
                    "Encountered SQL Exception while retrieving the questions for course " + courseID);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return questions;
    }

    @Override
    public List<Option> getOptions(int questionID) {
        List<Option> optionList = new ArrayList<>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spGetOptions(?)");
            proc.setParameter(1, questionID);
            ResultSet resultSet = proc.executeWithResults();
            while (resultSet.next()) {
                Option option = new Option();
                option.setDisplayText(resultSet.getString("displayText"));
                option.setOptionID(resultSet.getInt("optionID"));
                option.setStoredAs(resultSet.getInt("storedAs"));
                optionList.add(option);
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE,
                    "Encountered SQL Exception while retrieving options for question id " + questionID);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return optionList;
    }
}
