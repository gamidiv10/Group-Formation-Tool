package CSCI5308.GroupFormationTool.Question;

public interface IQuestionDataHandler {
    public Question setQuestionData(String qTitle, String qType, String qText);

    public void reset();
}
