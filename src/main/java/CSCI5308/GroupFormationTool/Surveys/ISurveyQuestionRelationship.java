package CSCI5308.GroupFormationTool.Surveys;

import java.util.List;

import CSCI5308.GroupFormationTool.Question.Question;
import CSCI5308.GroupFormationTool.Question.Questions;

public interface ISurveyQuestionRelationship {
	
	public List<Questions> loadQuestionByID(long surveyID,ISurveyQuestionRelationshipPersistence persistence);

}
