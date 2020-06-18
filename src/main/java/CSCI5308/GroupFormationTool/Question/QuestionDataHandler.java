package CSCI5308.GroupFormationTool.Question;

public class QuestionDataHandler implements IQuestionDataHandler{
    Question question;
    public QuestionDataHandler(Question question){
        this.question = question;

    }
    @Override
    public Question setQuestionData(String qTitle, String qType, String qText) {
        question.setQuestionTitle(qTitle);
        question.setQuestionType(qType);
        question.setQuestionText(qText);
        return question;
    }

    @Override
    public void reset() {
        question.reset();
    }
}
