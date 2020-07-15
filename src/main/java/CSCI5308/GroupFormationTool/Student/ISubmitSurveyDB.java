package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import java.util.HashMap;
import java.util.List;

public interface ISubmitSurveyDB {
    public boolean submitSurvey(int questionID, String answer, long courseID);

}
