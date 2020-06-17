package CSCI5308.GroupFormationTool.Question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QuestionDataHandlerTest {
    @Test
    public void setQuestionDataTest(){
        Question question = Question.getInstance();
        question.setQuestionType("Numeric");
        question.setQuestionText("Text");
        question.setQuestionTitle("Title");
        QuestionDataHandler questionDataHandler = new QuestionDataHandler(question);
        questionDataHandler.setQuestionData("ChangedTitle", "ChangedType", "ChangedText");
        assertEquals(question.getQuestionTitle(), "ChangedTitle");
        assertEquals(question.getQuestionType(), "ChangedType");
        assertEquals(question.getQuestionText(), "ChangedText");

    }
    @Test
    public void reset(){
        Question question = Question.getInstance();
        question.setQuestionType("Numeric");
        question.setQuestionText("Text");
        question.setQuestionTitle("Title");
        QuestionDataHandler questionDataHandler = new QuestionDataHandler(question);
        questionDataHandler.reset();
        assertNull(question.getQuestionText());
        assertNull(question.getQuestionType());
        assertNull(question.getQuestionTitle());

    }
}
