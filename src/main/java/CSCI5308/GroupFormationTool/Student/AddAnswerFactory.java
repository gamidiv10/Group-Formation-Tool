package CSCI5308.GroupFormationTool.Student;

public class AddAnswerFactory implements IAddAnswerFactory{
    @Override
    public IResponseHandler getObject(int questionType){
        if(questionType == 1){
            return new NumericResponse();
        }
        else if(questionType == 2){
            return new McqOneResponse();
        }
        else if(questionType == 4){
            return new FreeTextResponse();
        }
        return null;
    }
}
