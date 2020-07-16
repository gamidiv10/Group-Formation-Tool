package CSCI5308.GroupFormationTool.Formula;

import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.GroupCreation.SurveyRules;

public class GroupFormationFormulaBuilder {

	List<SurveyRules> surveyRules;
	Map<Long, Map<Long, Integer>> numericAnswers;
	Map<Long, Map<Long, String>> mcoAnswers;
	Map<Long, Map<Long, List<String>>> mcmAnswers;
	Map<Long, Map<Long, String>> freetextAnswers;

	public IGroupFormationFormula build() {

		return new GroupFormationFormula(this.surveyRules, this.numericAnswers, this.mcoAnswers, this.mcmAnswers,
				this.freetextAnswers);
	}

	public List<SurveyRules> getSurveyRules() {
		return surveyRules;
	}

	public void setSurveyRules(List<SurveyRules> surveyRules) {
		this.surveyRules = surveyRules;
	}

	public Map<Long, Map<Long, Integer>> getNumericAnswers() {
		return numericAnswers;
	}

	public void setNumericAnswers(Map<Long, Map<Long, Integer>> numericAnswers) {
		this.numericAnswers = numericAnswers;
	}

	public Map<Long, Map<Long, String>> getMcoAnswers() {
		return mcoAnswers;
	}

	public void setMcoAnswers(Map<Long, Map<Long, String>> mcoAnswers) {
		this.mcoAnswers = mcoAnswers;
	}

	public Map<Long, Map<Long, List<String>>> getMcmAnswers() {
		return mcmAnswers;
	}

	public void setMcmAnswers(Map<Long, Map<Long, List<String>>> mcmAnswers) {
		this.mcmAnswers = mcmAnswers;
	}

	public Map<Long, Map<Long, String>> getFreetextAnswers() {
		return freetextAnswers;
	}

	public void setFreetextAnswers(Map<Long, Map<Long, String>> freetextAnswers) {
		this.freetextAnswers = freetextAnswers;
	}

}
