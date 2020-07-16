package CSCI5308.GroupFormationTool.FormulaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Formula.GroupFormationFormulaBuilder;
import CSCI5308.GroupFormationTool.GroupCreation.SurveyRules;

public class GroupFormationFormulaBuilderTest {

	@Test
	public void getSurveyRules() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setSurveyRules(new ArrayList<SurveyRules>());
		assertNotNull(formula.getSurveyRules());

	}

	@Test
	public void setSurveyRules() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setSurveyRules(new ArrayList<SurveyRules>());
		assertNotNull(formula.getSurveyRules());

	}

	@Test
	public void getNumericAnswers() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setNumericAnswers(new HashMap<Long, Map<Long, Integer>>());
		assertNotNull(formula.getNumericAnswers());

	}

	@Test
	public void setNumericAnswers() {

		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setNumericAnswers(new HashMap<Long, Map<Long, Integer>>());
		assertNotNull(formula.getNumericAnswers());

	}

	@Test
	public void getMcoAnswers() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setFreetextAnswers(new HashMap<Long, Map<Long, String>>());
		assertNotNull(formula.getFreetextAnswers());

	}

	@Test
	public void setMcoAnswers() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setFreetextAnswers(new HashMap<Long, Map<Long, String>>());
		assertNotNull(formula.getFreetextAnswers());

	}

	@Test
	public void getMcmAnswers() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setMcmAnswers(new HashMap<Long, Map<Long, List<String>>>());
		assertNotNull(formula.getMcmAnswers());
	}

	@Test
	public void setMcmAnswers() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setMcmAnswers(new HashMap<Long, Map<Long, List<String>>>());
		assertNotNull(formula.getMcmAnswers());
	}

	@Test
	public void getFreetextAnswers() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setFreetextAnswers(new HashMap<Long, Map<Long, String>>());
		assertNotNull(formula.getFreetextAnswers());

	}

	@Test
	public void setFreetextAnswers() {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setFreetextAnswers(new HashMap<Long, Map<Long, String>>());
		assertNotNull(formula.getFreetextAnswers());

	}
}
