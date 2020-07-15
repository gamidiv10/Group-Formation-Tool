package CSCI5308.GroupFormationTool.Surveys;

import java.util.List;

import CSCI5308.GroupFormationTool.Question.Questions;

public interface ISurveyPersistence {
	public long createSurvey(Survey survey);
	public boolean addQuestionsToSurvey(long surveyID, int questionId, String questionText);
	public List<Questions> getAllSurveyQuestions(long surveyID);
	public List<Questions> getQuestionsForSurvey(long instructorID);
	public boolean deleteQuestionFromSurvey(int questionID, long surveyID);
	public long getSurveyIdByCourseId(long courseId);
	public int getSurveyStatus(long surveyId);
}
