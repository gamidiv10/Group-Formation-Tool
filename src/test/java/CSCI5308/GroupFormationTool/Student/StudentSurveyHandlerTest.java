package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Questions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentSurveyHandlerTest {

    @Test
    public void retrieveQuestions(){
        IStudentSurveyDB studentSurveyDB = mock(StudentSurveyDB.class);
        IStudentSurveyHandler studentSurveyHandler = new StudentSurveyHandler(studentSurveyDB);
        List<Questions> questions = new ArrayList<>();
        Questions question = new Questions();
        question.setQuestionId(1);
        question.setQuestionType(2);
        question.setQuestionText("Test");
        questions.add(question);
        when(studentSurveyDB.retrieveQuestions(1)).thenReturn(questions);
        assertNotNull(studentSurveyHandler.retrieveQuestions(1));
    }

}
