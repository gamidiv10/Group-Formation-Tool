package CSCI5308.GroupFormationTool.Surveys;
import java.util.List;
import CSCI5308.GroupFormationTool.Question.Questions;

public class Survey {
	private long surveyId;
	
	private String survey_name;
	private long courseid;
	private long createdById;
	private int publised;
	
	public long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurvey_name() {
		return survey_name;
	}
	public void setSurvey_name(String survey_name) {
		this.survey_name = survey_name;
	}
	public long getCourseid() {
		return courseid;
	}
	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	public long getCreatedById() {
		return createdById;
	}
	public void setCreatedById(long createdById) {
		this.createdById = createdById;
	}
	public int getPublised() {
		return publised;
	}
	public void setPublised(int publised) {
		this.publised = publised;
	}
	public List<Questions> getQuestionsForSurvey(ISurveyPersistence surveyDB, long instructorID) {
		return surveyDB.getQuestionsForSurvey(instructorID);
	}
	public boolean deleteQuestionFromSurvey(ISurveyPersistence surveyDB, int questionID, long surveyID) {
		return surveyDB.deleteQuestionFromSurvey(questionID, surveyID);
	}
	public List<Questions> getAllSurveyQuestions(ISurveyPersistence surveyDB, long surveyID) {
		return surveyDB.getAllSurveyQuestions(surveyID);
	}
	public long createSurvey(ISurveyPersistence surveyDB, Survey survey) {
		return surveyDB.createSurvey(survey);
	}
	public boolean addQuestionsToSurvey(ISurveyPersistence surveyDB, long surveyID, int questionId, String questionText) {
		return surveyDB.addQuestionsToSurvey(surveyID, questionId, questionText);
	}
	public long getSurveyIdByCourseId(ISurveyPersistence surveyDB, long courseId) {
		return surveyDB.getSurveyIdByCourseId(courseId);
	}
	public int getSurveyStatus(ISurveyPersistence surveyDB, long courseId) {
		long surveyId = this.getSurveyIdByCourseId(surveyDB,courseId);
		return surveyDB.getSurveyStatus(surveyId);
	}

	public boolean publishSurvey(ISurveyPersistence surveyDB, long surveyId) {
		return surveyDB.publishSurvey(surveyId);
	}

}
