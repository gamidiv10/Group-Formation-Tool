package CSCI5308.GroupFormationTool.Student;

public class FreeTextResponse implements IResponseHandler{

    @Override
    public void addAnswer(int questionID, String response) {
        Answer answer = Answer.getInstance();
        answer.addFreeTextAnswer(questionID, response);
    }
}