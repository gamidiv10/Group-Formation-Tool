package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public interface ISubmitSurvey {
    public void submitSurvey(HttpServletRequest httpServletRequest, HashMap<Questions, List<Option>> questions, long courseID);
}
