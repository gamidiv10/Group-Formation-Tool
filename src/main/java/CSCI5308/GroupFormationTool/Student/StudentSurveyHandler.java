package CSCI5308.GroupFormationTool.Student;
import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;
import java.util.HashMap;
import java.util.List;

public class StudentSurveyHandler implements IStudentSurveyHandler{
    IStudentSurveyDB studentSurveyDB;
    public StudentSurveyHandler(IStudentSurveyDB studentSurveyDB){
        this.studentSurveyDB = studentSurveyDB;
    }
    @Override
    public HashMap<Questions, List<Option>> retrieveQuestions(long courseID){
        List<Questions> questions;
        HashMap<Questions, List<Option>> allQuestions = new HashMap<>();
        questions = studentSurveyDB.retrieveQuestions(courseID);
        for(int i = 0; i < questions.size(); i++){
            int type = questions.get(i).getQuestionType();
            if(type == 2 || type == 3){
                allQuestions.put(questions.get(i), studentSurveyDB.getOptions(questions.get(i).getQuestionId()));
            }
            else{
                allQuestions.put(questions.get(i), null);
            }
        }
        return allQuestions;
    }
}
