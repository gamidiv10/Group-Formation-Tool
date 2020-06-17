package CSCI5308.GroupFormationTool.Question;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaveQuestionTest {
    @Test
    public void saveQuestionModelTest(){
        IQuestionDB questionDB = mock(QuestionDB.class);
        Question question = Question.getInstance();
        question.setQuestionType("Numeric");
        question.setQuestionText("Text");
        question.setQuestionTitle("Title");
        when(questionDB.saveQuestion(question, "B00851825", 1)).thenReturn(1);
        SaveQuestion saveQuestion = new SaveQuestion(questionDB);
        assertEquals(questionDB.saveQuestion(question, "B00851825", 1), 1);
    }
    @Test
    public void saveMcqOptionsTest(){
        IQuestionDB questionDB = mock(QuestionDB.class);
        List<Option> optionList = new ArrayList<>();
        optionList.add(new Option("a", 1));
        Option opt = new Option("a", 1);
        when(questionDB.saveMcq(opt, 1)).thenReturn(true);
        SaveQuestion saveQuestion = new SaveQuestion(questionDB);
        assertTrue(saveQuestion.saveMcqOptions(optionList, 1));

        }

}
