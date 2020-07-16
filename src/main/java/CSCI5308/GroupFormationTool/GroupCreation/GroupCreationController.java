package CSCI5308.GroupFormationTool.GroupCreation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Question.Questions;
import CSCI5308.GroupFormationTool.Surveys.ISurveyQuestionRelationshipPersistence;
import CSCI5308.GroupFormationTool.Surveys.Survey;

@Controller
public class GroupCreationController {

	@GetMapping("/survey/createSurveyRules")
	public String createGroup(Model model, @RequestParam(name = "id") long courseId) {
		Survey survey = new Survey();
		ISurveyQuestionRelationshipPersistence surveyQuestionDB = SystemConfig.instance()
				.getSurveyQuestionRelationshipDB();

		List<Questions> questionList = surveyQuestionDB.loadQuestionByID(1);
		FormRules showFormList = new FormRules();
		showFormList.setAllSurveyQuestions(questionList);
		model.addAttribute("formRules", showFormList);
		model.addAttribute("crseId", courseId);

		for (Questions qlist : questionList) {
			System.out.println("question id" + qlist.getQuestionId());
			System.out.println("Question elements " + qlist.getQuestionText());

		}

		return "survey/group_formation";
	}

	@PostMapping("/survey/groupFormation")
	public String setSurveyRules(Model model, @ModelAttribute("formRules") FormRules showSurveyQuestion,
			@RequestParam(name = "crseId") long courseId) {

		List<SurveyRules> surveyListRules = new ArrayList<SurveyRules>();
		ISurveyRulesPersistence surveyPersistence = SurveyRulesPersistenceSystemConfig.instance()
				.getSurveyRulesPolicyDB();

		for (Questions q : showSurveyQuestion.getAllSurveyQuestions()) {

			SurveyRules rules = new SurveyRules(courseId, showSurveyQuestion.getGroupSizeCount(), q);
			surveyListRules.add(rules);

		}
		surveyPersistence.createSurveyRules(surveyListRules);
		IGroupCreationService createGrp = SurveyRulesPersistenceSystemConfig.instance().getCreateGroup();
		Map<Integer, Map<User, List<String>>> groupformed = createGrp.createTeams(surveyListRules,
				SystemConfig.instance().getUserDB(), SurveyRulesPersistenceSystemConfig.instance().getAnswersDB());
		model.addAttribute("groupformed", groupformed);

		return "survey/survey_rules";

	}

}
