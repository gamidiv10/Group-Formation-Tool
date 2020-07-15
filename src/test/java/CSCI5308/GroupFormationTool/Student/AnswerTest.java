package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTest {
    private HashMap<Questions, List<Option>> questions = new HashMap<>();
    private HashMap<Integer, String> numericAnswers = new HashMap<>();
    private HashMap<Integer, String> freeTextAnswers = new HashMap<>();
    private HashMap<Integer, String> mcOneAnswers = new HashMap<>();
    private HashMap<Integer, List<String>> mcMultipleAnswers = new HashMap<>();

    Answer answer = Answer.getInstance();
    @Test
    public void getNumericAnswers() {
        Answer answer = Answer.getInstance();
        numericAnswers.put(1, "2");
        answer.setNumericAnswers(numericAnswers);
        assertEquals(numericAnswers, answer.getNumericAnswers());
    }
    @Test
    public void setNumericAnswers() {
        Answer answer = Answer.getInstance();
        numericAnswers.put(1, "2");
        answer.setNumericAnswers(numericAnswers);
        assertEquals(numericAnswers, answer.getNumericAnswers());
    }
    @Test
    public void getFreeTextAnswers() {
        Answer answer = Answer.getInstance();
        freeTextAnswers.put(1, "2");
        answer.setFreeTextAnswers(freeTextAnswers);
        assertEquals(freeTextAnswers, answer.getFreeTextAnswers());
    }
    @Test
    public void setFreeTextAnswers() {
        Answer answer = Answer.getInstance();
        freeTextAnswers.put(1, "2");
        answer.setFreeTextAnswers(freeTextAnswers);
        assertEquals(freeTextAnswers, answer.getFreeTextAnswers());
    }
    @Test
    public void getMcOneAnswers() {
        Answer answer = Answer.getInstance();
        mcOneAnswers.put(1, "2");
        answer.setMcOneAnswers(mcOneAnswers);
        assertEquals(mcOneAnswers, answer.getMcOneAnswers());
    }
    @Test
    public void setMcOneAnswers() {
        Answer answer = Answer.getInstance();
        mcOneAnswers.put(1, "2");
        answer.setMcOneAnswers(mcOneAnswers);
        assertEquals(mcOneAnswers, answer.getMcOneAnswers());
    }
    @Test
    public void getMcMultipleAnswers() {
        Answer answer = Answer.getInstance();
        List<String> options = new ArrayList<>();
        options.add("Op1");
        options.add("Op2");
        mcMultipleAnswers.put(1, options);
        answer.setMcMultipleAnswers(mcMultipleAnswers);
        assertEquals(mcMultipleAnswers, answer.getMcMultipleAnswers());
    }
    @Test
    public void setMcMultipleAnswers() {
        Answer answer = Answer.getInstance();
        List<String> options = new ArrayList<>();
        options.add("Op1");
        options.add("Op2");
        mcMultipleAnswers.put(1, options);
        answer.setMcMultipleAnswers(mcMultipleAnswers);
        assertEquals(mcMultipleAnswers, answer.getMcMultipleAnswers());
    }
    @Test
    public void getQuestions() {
        Answer answer = Answer.getInstance();
        List<Option> optionList = new ArrayList<>();
        Option option = new Option();
        option.setOptionID(1);
        option.setStoredAs(1);
        option.setDisplayText("Test");
        optionList.add(option);
        Questions question = new Questions();
        question.setQuestionId(1);
        question.setQuestionType(1);
        questions.put(question, optionList);
        answer.setQuestions(questions);
        assertEquals(questions, answer.getQuestions());
    }
    @Test
    public void setQuestions() {
        Answer answer = Answer.getInstance();
        List<Option> optionList = new ArrayList<>();
        Option option = new Option();
        option.setOptionID(1);
        option.setStoredAs(1);
        option.setDisplayText("Test");
        optionList.add(option);
        Questions question = new Questions();
        question.setQuestionId(1);
        question.setQuestionType(1);
        questions.put(question, optionList);
        answer.setQuestions(questions);
        assertEquals(questions, answer.getQuestions());
    }
    @Test
    public void addNumericAnswer(){

    }
    @Test
    public void addFreeTextAnswer(){

    }
    @Test
    public void addMcOneAnswer(){

    }
    @Test
    public void addMcMultipleAnswer(){

    }

}
