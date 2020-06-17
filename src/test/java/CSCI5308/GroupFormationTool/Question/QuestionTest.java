package CSCI5308.GroupFormationTool.Question;

import CSCI5308.GroupFormationTool.Question.Question;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    public String questionTitle = "title";
    public String questionText = "text";
    public String questionType = "type";
    private Question question;
    @BeforeEach
    public void getObject(){
        question = Question.getInstance();
    }

    @Test
    public void getQuestionTitleTest() {
        question.setQuestionTitle(questionTitle);
        assertEquals(questionTitle, question.getQuestionTitle());
    }
    @Test
    public void getQuestionTextTest() {
        question.setQuestionText(questionText);
        assertEquals(questionText, question.getQuestionText());
    }
    @Test
    public void getQuestionTypeTest() {
        question.setQuestionType(questionType);
        assertEquals(questionType, question.getQuestionType());
    }
    @Test
    public void setQuestionTitleTest() {
        question.setQuestionTitle(questionTitle);
        assertEquals(questionTitle, question.getQuestionTitle());
    }

    @Test
    public void setQuestionTextTest() {
        question.setQuestionText(questionText);
        assertEquals(questionText, question.getQuestionText());
    }

    @Test
    public void setQuestionTypeTest() {
        question.setQuestionType(questionType);
        assertEquals(questionType, question.getQuestionType());
    }
    @AfterEach
    public void reset(){
        question = null;
    }
}
