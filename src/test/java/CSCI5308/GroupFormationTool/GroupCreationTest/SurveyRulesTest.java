package CSCI5308.GroupFormationTool.GroupCreationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.GroupCreation.ISurveyRules;
import CSCI5308.GroupFormationTool.GroupCreation.SurveyRules;

public class SurveyRulesTest {

	@Test
	public void getSurveyId() {
		ISurveyRules rules = new SurveyRules();
		rules.setSurveyId(1);
		assertEquals(1, rules.getSurveyId());

	}

	@Test
	public void setSurveyId() {
		ISurveyRules rules = new SurveyRules();
		rules.setSurveyId(2);
		assertEquals(2, rules.getSurveyId());

	}

	@Test
	public void getQuestionId() {
		ISurveyRules rules = new SurveyRules();
		rules.setQuestionId(48);
		assertEquals(48, rules.getQuestionId());

	}

	@Test
	public void setQuestionId() {
		ISurveyRules rules = new SurveyRules();
		rules.setQuestionId(48);
		assertEquals(48, rules.getQuestionId());

	}

	@Test
	public void getRuleType() {
		ISurveyRules rules = new SurveyRules();
		rules.setRuleType("dissimilar");
		assertEquals("dissimilar", rules.getRuleType());
	}

	@Test
	public void setRuleType() {
		ISurveyRules rules = new SurveyRules();
		rules.setRuleType("dissimilar");
		assertEquals("dissimilar", rules.getRuleType());
	}

	@Test
	public void getNumericValue() {
		ISurveyRules rules = new SurveyRules();
		rules.setNumericValue(1);
		assertEquals(1, rules.getNumericValue());

	}

	@Test
	public void setNumericValue() {
		ISurveyRules rules = new SurveyRules();
		rules.setNumericValue(1);
		assertEquals(1, rules.getNumericValue());
	}

	@Test
	public void getGroupSizeCount() {
		ISurveyRules rules = new SurveyRules();
		rules.setGroupSizeCount(4);
		assertEquals(4, rules.getGroupSizeCount());

	}

	@Test
	public void setGroupSizeCount() {
		ISurveyRules rules = new SurveyRules();
		rules.setGroupSizeCount(4);
		assertEquals(4, rules.getGroupSizeCount());

	}

}
