package CSCI5308.GroupFormationTool.Formula;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.GroupCreation.ISurveyRules;
import CSCI5308.GroupFormationTool.GroupCreation.SurveyRules;

public class GroupFormationFormula implements IGroupFormationFormula {

	List<SurveyRules> surveyRules;
	Map<Long, Map<Long, Integer>> numericAnswers;
	Map<Long, Map<Long, String>> mcoAnswers;
	Map<Long, Map<Long, List<String>>> mcmAnswers;
	Map<Long, Map<Long, String>> freetextAnswers;
	List<List<Long>> teams;

	GroupFormationFormula(List<SurveyRules> surveyRules, Map<Long, Map<Long, Integer>> numericAnswers,
			Map<Long, Map<Long, String>> mcoAnswers, Map<Long, Map<Long, List<String>>> mcmAnswers,
			Map<Long, Map<Long, String>> freetextAnswers) {

		this.surveyRules = surveyRules;
		this.numericAnswers = new HashMap<Long, Map<Long, Integer>>(numericAnswers);
		this.mcoAnswers = new HashMap<Long, Map<Long, String>>(mcoAnswers);
		this.mcmAnswers = new HashMap<Long, Map<Long, List<String>>>(mcmAnswers);
		this.freetextAnswers = new HashMap<Long, Map<Long, String>>(freetextAnswers);

	}

	@Override
	public List<List<Long>> createGroups() {

		teams = new LinkedList<>();

		int sizeOfGroup = this.surveyRules.get(0).getGroupSizeCount();
		int sizeOfAllAnswerTypes = numericAnswers.size() + mcoAnswers.size() + mcmAnswers.size()
				+ freetextAnswers.size();
		while (sizeOfAllAnswerTypes != 0) {

			formTeam(sizeOfGroup);
			sizeOfAllAnswerTypes = numericAnswers.size() + mcoAnswers.size() + mcmAnswers.size()
					+ freetextAnswers.size();
		}

		return teams;
	}

	private void formTeam(int sizeOfGroup) {

		Map<Long, Double> memberWeightage = new HashMap<Long, Double>();

		Long user;

		if ((mcoAnswers.size()) > 0) {
			user = mcoAnswers.keySet().stream().findFirst().get();

		} else if ((mcmAnswers.size()) > 0) {

			user = mcmAnswers.keySet().stream().findFirst().get();

		} else if ((freetextAnswers.size()) > 0) {
			user = freetextAnswers.keySet().stream().findFirst().get();

		} else {
			user = numericAnswers.keySet().stream().findFirst().get();

		}

		Map<Long, Integer> numAnswers = numericAnswers.get(user);
		Map<Long, String> mconeAnswers = mcoAnswers.get(user);
		Map<Long, List<String>> mcmultipleAnswers = mcmAnswers.get(user);
		Map<Long, String> textAnswers = freetextAnswers.get(user);

		for (SurveyRules rules : surveyRules) {

			for (Long userId : mcoAnswers.keySet()) {

				if (userId != user) {

					String otherMemberAnswers = mcoAnswers.get(userId).get(rules.getQuestionId());
					String memberAnswers = mconeAnswers.get(rules.getQuestionId());

					if (null == memberAnswers) {
						break;
					}
					Double weightage = 0.0;
					if (rules.getRuleType().equalsIgnoreCase("similar")) {
						if (otherMemberAnswers.equalsIgnoreCase(memberAnswers)) {
							weightage = 1.0;
						}
					} else if (rules.getRuleType().equalsIgnoreCase("disimilar")) {
						if (!otherMemberAnswers.equalsIgnoreCase(memberAnswers)) {
							weightage = 1.0;
						}
					}

					Double userMCOWeightage = memberWeightage.getOrDefault(userId, 0.0);
					userMCOWeightage = userMCOWeightage + weightage;
					memberWeightage.put(userId, userMCOWeightage);
				}

			}

			for (Long userId : freetextAnswers.keySet()) {

				if (userId != user) {

					String otherMemberAnswers = freetextAnswers.get(userId).get(rules.getQuestionId());
					String memberAnswers = textAnswers.get(rules.getQuestionId());

					if (null == memberAnswers) {
						break;
					}
					Double weightage = 0.0;
					if (rules.getRuleType().equalsIgnoreCase("similar")) {
						if (otherMemberAnswers.equalsIgnoreCase(memberAnswers)) {
							weightage = 1.0;
						}
					} else if (rules.getRuleType().equalsIgnoreCase("disimilar")) {
						if (!otherMemberAnswers.equalsIgnoreCase(memberAnswers)) {
							weightage = 1.0;
						}
					}

					Double userTextWeightage = memberWeightage.getOrDefault(userId, 0.0);
					userTextWeightage = userTextWeightage + weightage;
					memberWeightage.put(userId, userTextWeightage);

				}

			}

			for (Long userId : numericAnswers.keySet()) {

				if (userId != user) {

					Integer otherMemberAnswers = numericAnswers.get(userId).get(rules.getQuestionId());
					Integer memberAnswers = numAnswers.get(rules.getQuestionId());

					if (null == memberAnswers) {
						break;
					}
					Double weightage = 0.0;
					if (rules.getRuleType().equalsIgnoreCase("similar")) {
						if (otherMemberAnswers == (memberAnswers)) {
							weightage = 1.0;
						}
					} else if (rules.getRuleType().equalsIgnoreCase("disimilar")) {
						if (otherMemberAnswers != memberAnswers) {
							weightage = 1.0;
						}
					}

					Double userNumericWeightage = memberWeightage.getOrDefault(userId, 0.0);
					userNumericWeightage = userNumericWeightage + weightage;
					memberWeightage.put(userId, userNumericWeightage);

				}

			}
			for (Long userId : mcmAnswers.keySet()) {

				if (userId != user) {

					List<String> otherMemberAnswers = mcmAnswers.get(userId).get(rules.getQuestionId());
					List<String> memberAnswers = mcmultipleAnswers.get(rules.getQuestionId());

					if (null == memberAnswers) {
						break;
					}
					Double mcmWeightage = 1.0 / memberAnswers.size();
					Double weightage = 0.0;
					for (String opt : memberAnswers) {

						if (rules.getRuleType().equalsIgnoreCase("similar")) {
							if (otherMemberAnswers.contains(opt)) {
								weightage = weightage + mcmWeightage;
							}
						} else if (rules.getRuleType().equalsIgnoreCase("disimilar")) {
							if (!otherMemberAnswers.contains(opt)) {
								weightage = weightage + mcmWeightage;
							}
						}

					}
					Double userMcmWeightage = memberWeightage.getOrDefault(userId, 0.0);
					userMcmWeightage = userMcmWeightage + weightage;
					memberWeightage.put(userId, userMcmWeightage);

				}
			}

		}

		List<Long> team = new LinkedList<>();
		team.add(user);
		if (memberWeightage.size() > 0) {

			listByVal(memberWeightage, team, sizeOfGroup);
		}
		this.teams.add(team);

		for (Long userId : team) {

			numericAnswers.remove(userId);
			mcoAnswers.remove(userId);
			mcmAnswers.remove(userId);
			freetextAnswers.remove(userId);

		}

	}

	private void listByVal(Map<Long, Double> mweight, List<Long> team, int sizeOfGroup) {

		List<Map.Entry<Long, Double>> newLists = new LinkedList<Map.Entry<Long, Double>>(mweight.entrySet());

		Collections.sort(newLists, (o2, o1) -> o2.getValue().compareTo(o1.getValue()));

		int itr;
		if (sizeOfGroup - 1 <= newLists.size()) {
			itr = sizeOfGroup - 1;
		} else {
			itr = newLists.size();

		}

		for (int k = 0; k < itr; k++) {

			if (null != newLists.get(k)) {
				team.add(newLists.get(k).getKey());
			}
		}

	}

}
