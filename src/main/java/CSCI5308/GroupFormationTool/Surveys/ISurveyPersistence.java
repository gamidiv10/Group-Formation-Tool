package CSCI5308.GroupFormationTool.Surveys;

public interface ISurveyPersistence {
	public boolean createSurvey(Survey survey);
	public Survey loadSurveyId(long surveyId);
}
