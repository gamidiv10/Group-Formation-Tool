package CSCI5308.GroupFormationTool.Student;

public class NumericResponse implements IResponseHandler{

    @Override
    public void addAnswer(int questionID, String response) {
        Answer answer = Answer.getInstance();
        answer.addNumericAnswer(questionID, response);
    }
}
