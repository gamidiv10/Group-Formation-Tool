package CSCI5308.GroupFormationTool.Student;

public interface IAddAnswerFactory {
    IResponseHandler getObject(int questionType);
}
