package CSCI5308.GroupFormationTool.GroupCreationTest;

import java.util.List;

import CSCI5308.GroupFormationTool.GroupCreation.ISurveyRulesPersistence;
import CSCI5308.GroupFormationTool.GroupCreation.SurveyRules;

public class SurveyRulesDBMock implements ISurveyRulesPersistence {

	@Override
	public boolean createSurveyRules(List<SurveyRules> rulesList) {

		return true;
	}

}
