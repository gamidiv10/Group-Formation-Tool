package CSCI5308.GroupFormationTool.Surveys;

import java.util.List;

import CSCI5308.GroupFormationTool.Question.Questions;

public class SurveyQuestionRelationship implements ISurveyQuestionRelationship {

	@Override
	public List<Questions> loadQuestionByID(long surveyID, ISurveyQuestionRelationshipPersistence persistence) {
		List<Questions> surveyQuestions = persistence.loadQuestionByID(surveyID);
		return surveyQuestions;
	}

}
