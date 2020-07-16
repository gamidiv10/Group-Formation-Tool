package CSCI5308.GroupFormationTool.GroupCreation;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class SurveyRulesDB implements ISurveyRulesPersistence {
	private Logger log = Logger.getLogger(SurveyRulesDB.class.getName());
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
			log.log(Level.SEVERE, "Encountered SQL Exception creating survey rules " + rulesList);
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		log.log(Level.INFO, "Successfully survey saved rules to DB");
		return true;
	}
}
