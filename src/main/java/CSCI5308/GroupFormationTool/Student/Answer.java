package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import java.util.HashMap;
import java.util.List;

public class Answer {
    private static Answer answer;

    private Answer() {
    }

    public static Answer getInstance() {
        if (answer == null) {
            answer = new Answer();
        }
        return answer;
    }

    public HashMap<Integer, String> getNumericAnswers() {
        return numericAnswers;
    }

    public void setNumericAnswers(HashMap<Integer, String> numericAnswers) {
        this.numericAnswers = numericAnswers;
    }

    public HashMap<Integer, String> getFreeTextAnswers() {
        return freeTextAnswers;
    }

    public void setFreeTextAnswers(HashMap<Integer, String> freeTextAnswers) {
        this.freeTextAnswers = freeTextAnswers;
    }

    public HashMap<Integer, String> getMcOneAnswers() {
        return mcOneAnswers;
    }

    public void setMcOneAnswers(HashMap<Integer, String> mcOneAnswers) {
        this.mcOneAnswers = mcOneAnswers;
    }

    public HashMap<Integer, List<String>> getMcMultipleAnswers() {
        return mcMultipleAnswers;
    }

    public void setMcMultipleAnswers(HashMap<Integer, List<String>> mcMultipleAnswers) {
        this.mcMultipleAnswers = mcMultipleAnswers;
    }

    public HashMap<Questions, List<Option>> getQuestions() {
        return questions;
    }

    public void setQuestions(HashMap<Questions, List<Option>> questions) {
        this.questions = questions;
    }

    public void addNumericAnswer(int questionId, String response){
        numericAnswers.put(questionId, response);
    }

    public void addFreeTextAnswer(int questionId, String answer){
        freeTextAnswers.put(questionId, answer);
    }

    public void addMcOneAnswer(int questionId, String answer){
        mcOneAnswers.put(questionId, answer);
    }

    public void addMcMultipleAnswer(int questionId, List<String> answer){
        mcMultipleAnswers.put(questionId, answer);
    }
    private HashMap<Questions, List<Option>> questions = new HashMap<>();
    private HashMap<Integer, String> numericAnswers = new HashMap<>();
    private HashMap<Integer, String> freeTextAnswers = new HashMap<>();
    private HashMap<Integer, String> mcOneAnswers = new HashMap<>();
    private HashMap<Integer, List<String>> mcMultipleAnswers = new HashMap<>();
}
