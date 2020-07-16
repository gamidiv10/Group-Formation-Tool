package CSCI5308.GroupFormationTool.Question;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionControllerTest {
    @Test
    public void createQuestionTest(){
        QuestionController questionController = new QuestionController();
        ModelAndView modelAndView = mock(ModelAndView.class);
        when(modelAndView.addObject("isInitialPage", true)).thenReturn(modelAndView);
        when(modelAndView.addObject("save", false)).thenReturn(modelAndView);
        assertDoesNotThrow((ThrowingSupplier<ModelAndView>) questionController::createQuestion);
    }

    @Test
    public void saveQuestionTest(){
        QuestionController questionController = new QuestionController();
        IHandleInputOptions handleInputOptions = mock(HandleInputOptions.class);
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        List<Option> optionList = new ArrayList<>();
        Option option = new Option();
        option.setOptionID(1);
        option.setDisplayText("Test");
        option.setStoredAs(1);
        optionList.add(option);
        when(handleInputOptions.handleOptions(httpServletRequest)).thenReturn(optionList);
        ISaveQuestion saveQuestion = mock(SaveQuestion.class);
        Question question = Question.getInstance();
        question.setQuestionTitle("1");
        question.setQuestionText("Test");
        question.setQuestionType("1");
        when(Question.getInstance()).thenReturn(question);
        when(saveQuestion.saveQuestionModel(question)).thenReturn(1);
        User u = CurrentUser.instance().getCurrentAuthenticatedUser();
        User user = new User();
        user.setBannerID("B00834696");
        CurrentUser currentUser = mock(CurrentUser.class);
        when(currentUser.getCurrentAuthenticatedUser()).thenReturn(user);

    }
}