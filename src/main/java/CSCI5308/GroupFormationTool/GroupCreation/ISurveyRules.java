package CSCI5308.GroupFormationTool.GroupCreation;

public interface ISurveyRules {

	public long getSurveyId();

	public void setSurveyId(int surveyId);

	public long getQuestionId();

	public void setQuestionId(long questionId);

	public String getRuleType();

	public void setRuleType(String ruleType);

	public int getNumericValue();

	public void setNumericValue(int numericValue);

	public int getGroupSizeCount();

	public void setGroupSizeCount(int groupSizeCount);

}
