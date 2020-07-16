package CSCI5308.GroupFormationTool.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(optionList, handleInputOptions.handleOptions(httpServletRequest));
    }
}