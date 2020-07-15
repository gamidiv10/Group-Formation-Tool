package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import java.util.List;

public interface IStudentSurveyDB {
    public List<Questions> retrieveQuestions(long courseID);

    public List<Option> getOptions(int questionID);

}
