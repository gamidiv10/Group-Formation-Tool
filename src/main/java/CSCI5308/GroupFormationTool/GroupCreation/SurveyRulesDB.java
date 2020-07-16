package CSCI5308.GroupFormationTool.GroupCreation;

import java.sql.SQLException;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class SurveyRulesDB implements ISurveyRulesPersistence {

	@Override
	public boolean createSurveyRules(List<SurveyRules> rulesList) {
		CallStoredProcedure proc = null;

		try {
			proc = new CallStoredProcedure("spInsertSurveyRules(?,?,?,?,?)");

			for (SurveyRules itr : rulesList) {

				proc.setParameter(1, itr.getSurveyId());
				proc.setParameter(2, itr.getQuestionId());
				proc.setParameter(3, itr.getRuleType());
				proc.setParameter(4, itr.getNumericValue());
				proc.setParameter(5, itr.getGroupSizeCount());
				proc.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

}
