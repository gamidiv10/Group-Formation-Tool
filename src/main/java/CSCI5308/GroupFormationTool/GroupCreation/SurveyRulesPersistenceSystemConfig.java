package CSCI5308.GroupFormationTool.GroupCreation;

public class SurveyRulesPersistenceSystemConfig {

	private static SurveyRulesPersistenceSystemConfig singleInstance = null;
	private ISurveyRulesPersistence surveyRulesPolicyDB;
	private IGroupCreationAnswersPersistence answersDB;
	private IGroupCreationService createGroup;

	private SurveyRulesPersistenceSystemConfig() {
		surveyRulesPolicyDB = new SurveyRulesDB();
		answersDB = new AnswersDB();
		createGroup = new GroupCreationService();

	}

	public static SurveyRulesPersistenceSystemConfig instance() {

		if (null == singleInstance) {
			singleInstance = new SurveyRulesPersistenceSystemConfig();
		}
		return singleInstance;
	}

	public ISurveyRulesPersistence getSurveyRulesPolicyDB() {
		return surveyRulesPolicyDB;
	}

	public void setSurveyRulesPolicyDB(ISurveyRulesPersistence surveyRulesPolicyDB) {
		this.surveyRulesPolicyDB = surveyRulesPolicyDB;
	}

	public IGroupCreationAnswersPersistence getAnswersDB() {
		return answersDB;
	}

	public void setAnswersDB(IGroupCreationAnswersPersistence answersDB) {
		this.answersDB = answersDB;
	}

	public IGroupCreationService getCreateGroup() {
		return createGroup;
	}

	public void setCreateGroup(IGroupCreationService createGroup) {
		this.createGroup = createGroup;
	}

}
