package CSCI5308.GroupFormationTool.Question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionControllerTest {
    @Test
    public void createQuestion(){
        QuestionController questionController = new QuestionController();
        ModelAndView modelAndView = mock(ModelAndView.class);
        when(modelAndView.addObject("isInitialPage", true)).thenReturn(modelAndView);
        when(modelAndView.addObject("save", false)).thenReturn(modelAndView);
        assertDoesNotThrow((ThrowingSupplier<ModelAndView>) questionController::createQuestion);
    }
}
