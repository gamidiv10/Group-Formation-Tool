package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import java.util.HashMap;
import java.util.List;

public interface IStudentSurveyHandler {
    public HashMap<Questions, List<Option>> retrieveQuestions(long courseID);
}
