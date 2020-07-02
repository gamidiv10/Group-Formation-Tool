package CSCI5308.GroupFormationTool.Question;

public interface IQuestionDB {
    public int saveQuestion(Question question, String instructorId, int typeId);

    public boolean saveMcq(Option option, int questionId);
}
