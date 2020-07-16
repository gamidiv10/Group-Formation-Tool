package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import java.util.List;

public interface IStudentSurveyDB {
    List<Questions> retrieveQuestions(long courseID);

    List<Option> getOptions(int questionID);

}
