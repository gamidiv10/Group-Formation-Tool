package CSCI5308.GroupFormationTool.Student;

public class McqOneResponse implements IResponseHandler{

    @Override
    public void addAnswer(int questionID, String response) {
        Answer answer = Answer.getInstance();
        answer.addMcOneAnswer(questionID, response);
    }
}
