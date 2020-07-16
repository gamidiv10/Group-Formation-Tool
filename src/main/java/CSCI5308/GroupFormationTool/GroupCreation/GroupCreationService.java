package CSCI5308.GroupFormationTool.GroupCreation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Formula.GroupFormationFormulaBuilder;
import CSCI5308.GroupFormationTool.Formula.IGroupFormationFormula;

public class GroupCreationService implements IGroupCreationService {

	@Override
	public Map<Integer, Map<User, List<String>>> createTeams(List<SurveyRules> surveyRules, IUserPersistence user,
			IGroupCreationAnswersPersistence answers) {
		GroupFormationFormulaBuilder formula = new GroupFormationFormulaBuilder();
		formula.setSurveyRules(surveyRules);
		IGroupCreationAnswersPersistence answersPersistence = new AnswersDB();

		Map<Long, Map<Long, Integer>> numericAnswer = new HashMap<Long, Map<Long, Integer>>();
		numericAnswer = answersPersistence.loadAnwersNumericQn(1);

		Map<Long, Map<Long, String>> mcoAnswers = new HashMap<Long, Map<Long, String>>();
		mcoAnswers = answersPersistence.loadAnwersMco(1);

		Map<Long, Map<Long, List<String>>> mcmAnswers = new HashMap<Long, Map<Long, List<String>>>();
		mcmAnswers = answersPersistence.loadAnwersMcm(1);

		Map<Long, Map<Long, String>> freeTextAnswers = new HashMap<Long, Map<Long, String>>();
		freeTextAnswers = answersPersistence.loadAnwersFreetextAnswers(1);

		System.out.println("Size of numerical answers " + numericAnswer.size());

		System.out.println("Size of mco answers " + mcoAnswers.size());

		System.out.println("Size of mcm answers " + mcmAnswers.size());
		System.out.println("Size of freetext answers " + freeTextAnswers.size());

		formula.setSurveyRules(surveyRules);
		formula.setNumericAnswers(numericAnswer);
		formula.setFreetextAnswers(freeTextAnswers);
		formula.setMcmAnswers(mcmAnswers);
		formula.setMcoAnswers(mcoAnswers);

		IGroupFormationFormula groupFormula = formula.build();
		List<List<Long>> teams = groupFormula.createGroups();

		System.out.println("printing lists of teams");

		for (List<Long> i : teams) {

			System.out.println("number " + i);
			for (Long j : i) {
				System.out.println("groups " + j);
			}

		}

		Map<Integer, Map<User, List<String>>> teamMap = new LinkedHashMap<>();
		for (int k = 0; k < teams.size(); k++) {
			List<Long> indvTeams = teams.get(k);
			Map<User, List<String>> indvTeamMap = new HashMap<User, List<String>>();
			for (Long individual : indvTeams) {
				User u = new User(individual, user);
				List<String> iAnswers = new ArrayList<String>();
				if (null != numericAnswer.get(individual)) {
					Map<Long, Integer> numericQuestion = numericAnswer.get(individual);
					for (Integer ans : numericQuestion.values()) {
						iAnswers.add(ans.toString());
					}

				}
				if (null != mcoAnswers.get(individual)) {
					Map<Long, String> mcoQuestion = mcoAnswers.get(individual);
					for (String ans : mcoQuestion.values()) {
						iAnswers.add(ans);

					}
				}
				if (null != freeTextAnswers.get(individual)) {

					Map<Long, String> freeTextQuestion = freeTextAnswers.get(individual);
					for (String ans : freeTextQuestion.values()) {
						iAnswers.add(ans);

					}
				}
				if (null != mcmAnswers.get(individual)) {
					Map<Long, List<String>> mcmQuestion = mcmAnswers.get(individual);
					for (List<String> ansList : mcmQuestion.values()) {
						for (String ans : ansList) {
							iAnswers.add(ans);
						}
					}
				}

				indvTeamMap.put(u, iAnswers);
			}
			teamMap.put(k, indvTeamMap);
		}

		System.out.println("-------------------User Responses------------");

		System.out.println("Size of MAP responses " + teamMap.size());

		for (Integer r : teamMap.keySet()) {
			System.out.println("integer r value " + r);
			for (User v : teamMap.get(r).keySet()) {
				System.out.println("user " + v.getBannerID());
				for (String res : teamMap.get(r).get(v)) {
					System.out.println("Responses are : " + res);
				}
			}

		}
		return teamMap;
	}

}
