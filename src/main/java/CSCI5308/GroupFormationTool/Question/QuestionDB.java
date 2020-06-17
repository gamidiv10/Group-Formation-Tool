package CSCI5308.GroupFormationTool.Question;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDB implements IQuestionDB{
    @Override
    public int saveQuestion(Question question, String instructorId, int typeId) {

        int questionIdFromDB = -1;
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spCreateQuestion(?, ?, ?, ?)");
            proc.setParameter(1, question.getQuestionTitle());
            proc.setParameter(2, typeId);
            proc.setParameter(3, question.getQuestionText());
            proc.setParameter(4, "B00851825");
            ResultSet resultSet = proc.executeWithResults();
            while (resultSet.next())
            {
                questionIdFromDB = resultSet.getInt(1);
                System.out.println("Question ID from DB: " + questionIdFromDB);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }
        return questionIdFromDB;
    }

    @Override
    public boolean saveMcq(Option option, int questionId) {

        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spInsertOptions(?, ?, ?)");
            proc.setParameter(1, questionId);
            proc.setParameter(2, option.getDisplayText());
            proc.setParameter(3, option.getStoredAs());
            proc.execute();
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }
        return true;
    }
}
