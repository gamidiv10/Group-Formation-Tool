package CSCI5308.GroupFormationTool.Student;

public interface ISubmitSurveyDB {
    boolean submitSurvey(int questionID, String answer, long courseID);

}
