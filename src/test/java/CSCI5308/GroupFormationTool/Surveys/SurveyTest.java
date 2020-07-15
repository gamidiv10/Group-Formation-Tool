package CSCI5308.GroupFormationTool.Surveys;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Question.Questions;

@SuppressWarnings("deprecation")
public class SurveyTest {
	
	@Test
	public void getSurveyIdTest() {
		Survey survey = new Survey();
		Assert.isTrue(survey.getSurveyId()==0);
	}
	
	@Test
	public void setSurveyIdTest() {
		Survey survey = new Survey();
		survey.setSurveyId(99);
		Assert.isTrue(survey.getSurveyId()==99);
	}
	
	@Test
	public void getSurvey_nameTest() {
		Survey survey = new Survey();
		Assert.isNull(survey.getSurvey_name());
	}
	
	@Test
	public void setSurvey_nameTest() {
		Survey survey = new Survey();
		survey.setSurvey_name("test");
		Assert.isTrue(survey.getSurvey_name().equals("test"));
	}
	
	@Test
	public void getCourseidTest() {
		Survey survey = new Survey();
		Assert.isTrue(survey.getCourseid()==0);
	}
	
	@Test
	public void setCourseidTest() {
		Survey survey = new Survey();
		survey.setCourseid(99);
		Assert.isTrue(survey.getCourseid()==99);
	}
	
	@Test
	public void getCreatedByIdTest() {
		Survey survey = new Survey();
		Assert.isTrue(survey.getCreatedById()==0);
	}
	
	@Test
	public void setCreatedByIdTest() {
		Survey survey = new Survey();
		survey.setCreatedById(99);
		Assert.isTrue(survey.getCreatedById()==99);
	}
	
	@Test
	public void getPublisedTest() {
		Survey survey = new Survey();
		Assert.isTrue(survey.getPublised()==0);
	}
	
	@Test
	public void setPublisedTest() {
		Survey survey = new Survey();
		survey.setPublised(99);
		Assert.isTrue(survey.getPublised()==99);
	}
	
	@Test
	public void getQuestionsForSurveyTest() {
		ISurveyPersistence surveyDB = new SurveyDBMock();
		long instructorID = 99;
		List<Questions> questions = new ArrayList<>();
		questions = surveyDB.getQuestionsForSurvey(instructorID);
		Assert.notNull(questions);
		for (Questions q : questions) {
            Assert.isTrue(q.getTitle().equals("title"));
            Assert.isTrue(q.getDateCreated() != null);
            Assert.isTrue(q.getQuestionText().equals("questionText"));
            Assert.isTrue(q.getQuestionId()==99);
        }
	}
	
	@Test
	public void deleteQuestionFromSurveyTest() {
		ISurveyPersistence surveyDB = new SurveyDBMock();
		int questionID = 99;
		long surveyID = 99;
		Assert.isTrue(surveyDB.deleteQuestionFromSurvey(questionID, surveyID));
	}
	
	@Test
	public void getAllSurveyQuestionsTest() {
		ISurveyPersistence surveyDB = new SurveyDBMock();
		long surveyID = 99;
		List<Questions> questions = new ArrayList<>();
		questions = surveyDB.getAllSurveyQuestions(surveyID);
		Assert.notNull(questions);
		for (Questions q : questions) {
            Assert.isTrue(q.getTitle().equals("title"));
            Assert.isTrue(q.getDateCreated() != null);
            Assert.isTrue(q.getQuestionText().equals("questionText"));
            Assert.isTrue(q.getQuestionId()==99);
        }
	}
	
	@Test
	public void createSurveyTest() {
		ISurveyPersistence surveyDB = new SurveyDBMock();
		Survey survey = new Survey();
		Assert.isTrue(surveyDB.createSurvey(survey)==0);
	}
	
	@Test
	public void addQuestionsToSurveyTest() {
		ISurveyPersistence surveyDB = new SurveyDBMock();
		long surveyID = 99;
		int questionId = 99;
		String questionText = "questionText";
		Assert.isTrue(surveyDB.addQuestionsToSurvey(surveyID, questionId, questionText));
	}
	
	@Test
	public void getSurveyIdByCourseIdTest() {
		ISurveyPersistence surveyDB = new SurveyDBMock();
		long courseId = 99;
		Assert.isTrue(surveyDB.getSurveyIdByCourseId(courseId)==0);
	}
	
	@Test
	public void getSurveyStatusTest() {
		ISurveyPersistence surveyDB = new SurveyDBMock();
		long courseId = 99;
		Survey survey = new Survey();
		long surveyId = survey.getSurveyIdByCourseId(surveyDB,courseId);
		Assert.isTrue(surveyDB.getSurveyStatus(surveyId)==0);
	}

	@Test
	public void publishSurvey() {
		boolean isSurveyPublished = false;
		long surveyId = 1;
		Assert.isTrue(isSurveyPublished == false);
		ISurveyPersistence surveyDB = new SurveyDBMock();
		isSurveyPublished = surveyDB.publishSurvey(surveyId);
		Assert.isTrue(isSurveyPublished);
	}
}
