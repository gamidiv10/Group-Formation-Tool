package CSCI5308.GroupFormationTool.Question;

public class Question {
    private String questionTitle;
    private String questionText;
    private String questionType;

    private static Question question;

    private Question() {

    }

    public static Question getInstance() {
        if (question == null) {
            question = new Question();
        }
        return question;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void reset() {
        question.setQuestionTitle(null);
        question.setQuestionText(null);
        question.setQuestionType(null);
    }

}
