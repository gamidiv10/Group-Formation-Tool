package CSCI5308.GroupFormationTool.Surveys;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Question.Questions;

public class SurveyDBMock implements ISurveyPersistence {

	@Override
	public long createSurvey(Survey survey) {
		survey.setSurveyId(0);
		return survey.getSurveyId();
	}

	@Override
	public boolean addQuestionsToSurvey(long surveyID, int questionId, String questionText) {
		return true;
	}

	@Override
	public List<Questions> getAllSurveyQuestions(long surveyID) {
		List<Questions> questions = new ArrayList<>();
		Questions question = new Questions();
		question.setQuestionId(99);
        question.setTitle("title");
        question.setQuestionText("questionText");
        question.setDateCreated(new Date(System.currentTimeMillis()));
        questions.add(question);
        return questions;
	}

	@Override
	public List<Questions> getQuestionsForSurvey(long instructorID) {
		List<Questions> questions = new ArrayList<>();
		Questions question = new Questions();
		question.setQuestionId(99);
        question.setTitle("title");
        question.setQuestionText("questionText");
        question.setDateCreated(new Date(System.currentTimeMillis()));
        questions.add(question);
        return questions;
	}

	@Override
	public boolean deleteQuestionFromSurvey(int questionID, long surveyID) {
		return true;
	}

	@Override
	public long getSurveyIdByCourseId(long courseId) {
		return 0;
	}

	@Override
	public int getSurveyStatus(long surveyId) {
		return 0;
	}

}
