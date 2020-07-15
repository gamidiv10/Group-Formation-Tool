package CSCI5308.GroupFormationTool.CoursesTest;


import CSCI5308.GroupFormationTool.Courses.CourseController;
import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;
import CSCI5308.GroupFormationTool.Student.*;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CourseControllerTest {

    @Test
    public void submitSurveyTest(){
        CourseController courseController = new CourseController();
        ISubmitSurveyDB submitSurveyDB = mock(SubmitSurveyDB.class);
        ISubmitSurvey submitSurveyHandler = mock(SubmitSurvey.class);
        Answer answer = mock(Answer.class);
        HashMap<Questions, List<Option>> questions = new HashMap<>();
        Questions question = new Questions();
        List<Option> optionList = new ArrayList<>();
        Option option = new Option();
        optionList.add(option);
        questions.put(question, optionList);
        when(answer.getQuestions()).thenReturn(questions);
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(submitSurveyHandler.submitSurvey(httpServletRequest, questions, 1)).thenReturn(true);
        assertDoesNotThrow(() -> courseController.submitSurvey(httpServletRequest));
    }
}
