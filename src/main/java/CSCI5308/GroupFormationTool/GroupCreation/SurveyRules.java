package CSCI5308.GroupFormationTool.GroupCreation;

import CSCI5308.GroupFormationTool.Question.Questions;

public class SurveyRules implements ISurveyRules {

	private long surveyId;
	private long questionId;
	private String ruleType;
	private int numericValue;
	private int groupSizeCount;

	public SurveyRules() {
	}
	public SurveyRules(long surveyId, int groupSizeCount, Questions q) {
		this.surveyId = surveyId;
		this.questionId = q.getQuestionId();
		this.ruleType = q.getRule();
		this.numericValue = q.getNumericValue();
		this.groupSizeCount = groupSizeCount;

	}

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public int getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(int numericValue) {
		this.numericValue = numericValue;
	}

	public int getGroupSizeCount() {
		return groupSizeCount;
	}

	public void setGroupSizeCount(int groupSizeCount) {
		this.groupSizeCount = groupSizeCount;
	}

}
