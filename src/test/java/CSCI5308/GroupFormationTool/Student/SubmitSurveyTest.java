package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class SubmitSurveyTest {

    @Test
    public void submitSurvey(){
        ISubmitSurveyDB submitSurveyDB = mock(SubmitSurveyDB.class);
        ISubmitSurvey submitSurvey = new SubmitSurvey(submitSurveyDB);
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HashMap<Questions, List<Option>> questions = new HashMap<>();
        List<Option> optionList = new ArrayList<>();
        Option option = new Option();
        option.setOptionID(1);
        option.setStoredAs(2);
        option.setDisplayText("Test");
        optionList.add(option);
        Questions question = new Questions();
        question.setQuestionType(1);
        question.setQuestionId(1);
        questions.put(question, optionList);
        when(httpServletRequest.getParameter("result1")).thenReturn("1");
        when(submitSurveyDB.submitSurvey(1, "a", 1)).thenReturn(true);
        assertDoesNotThrow(() -> submitSurvey.submitSurvey(httpServletRequest, questions, 1));

        Questions question2 = new Questions();
        question2.setQuestionType(2);
        question2.setQuestionId(1);
        questions.put(question2, optionList);
        when(httpServletRequest.getParameter("mcqOne")).thenReturn("1");
        when(submitSurveyDB.submitSurvey(1, "a", 1)).thenReturn(true);
        assertDoesNotThrow(() -> submitSurvey.submitSurvey(httpServletRequest, questions, 1));


        Questions question3 = new Questions();
        question3.setQuestionType(3);
        question3.setQuestionId(1);
        questions.put(question3, optionList);
        when(httpServletRequest.getParameter("result3option2")).thenReturn("1");
        when(submitSurveyDB.submitSurvey(1, "a", 1)).thenReturn(true);
        assertDoesNotThrow(() -> submitSurvey.submitSurvey(httpServletRequest, questions, 1));

        Questions question4 = new Questions();
        question4.setQuestionType(4);
        question4.setQuestionId(1);
        questions.put(question4, optionList);
        when(httpServletRequest.getParameter("result1")).thenReturn("1");
        when(submitSurveyDB.submitSurvey(1, "a", 1)).thenReturn(true);
        assertDoesNotThrow(() -> submitSurvey.submitSurvey(httpServletRequest, questions, 1));
    }
}
