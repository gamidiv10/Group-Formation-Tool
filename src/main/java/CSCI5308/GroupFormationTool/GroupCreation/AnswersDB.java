package CSCI5308.GroupFormationTool.GroupCreation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class AnswersDB implements IGroupCreationAnswersPersistence {
	private Logger log = Logger.getLogger(AnswersDB.class.getName());
	@Override
	public Map<Long, Map<Long, Integer>> loadAnwersNumericQn(long courseid) {
		Map<Long, Map<Long, Integer>> userAnswers = new HashMap<Long, Map<Long, Integer>>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadAnswersNumericQn(?)");
			proc.setParameter(1, courseid);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userId = results.getLong("studentID");
					long questionID = results.getLong("questionID");
					int answer = 0;
					if (null != results.getString("answer")) {
						answer = Integer.parseInt(results.getString("answer"));

					} else {
						answer = 0;
					}
					if (null != userAnswers.get(userId)) {
						userAnswers.get(userId).put(questionID, answer);
					} else {
						Map<Long, Integer> numericQuestion = new HashMap<>();
						numericQuestion.put(questionID, answer);
						userAnswers.put(userId, numericQuestion);
					}
				}
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Encountered SQL Exception while loading answers for course " + courseid);
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		log.log(Level.INFO, "Loaded answers for course " + courseid);
		return userAnswers;
	}

	@Override
	public Map<Long, Map<Long, String>> loadAnwersMco(long courseId) {

		Map<Long, Map<Long, String>> userAnswers = new HashMap<Long, Map<Long, String>>();
		CallStoredProcedure proc = null;

		try {
			proc = new CallStoredProcedure("spLoadAnswersMco(?)");
			proc.setParameter(1, courseId);

			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userId = results.getLong("studentID");
					long questionID = results.getLong("questionID");
					String answer = results.getString("answer");
					if (null != userAnswers.get(userId)) {
						userAnswers.get(userId).put(questionID, answer);
					} else {
						Map<Long, String> mcoQuestion = new HashMap<>();
						mcoQuestion.put(questionID, answer);
						userAnswers.put(userId, mcoQuestion);
					}
				}
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Encountered SQL Exception while loading answers for course " + courseId);
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		log.log(Level.INFO, "Loaded answers for course " + courseId);
		return userAnswers;
	}

	@Override
	public Map<Long, Map<Long, List<String>>> loadAnwersMcm(long courseId) {
		Map<Long, Map<Long, List<String>>> userAnswers = new HashMap<Long, Map<Long, List<String>>>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadAnswersMcm(?)");
			proc.setParameter(1, courseId);

			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long userId = results.getLong("studentID");
					long questionID = results.getLong("questionID");
					String answer = results.getString("answer");
					if (null != userAnswers.get(userId)) {

						if (null != userAnswers.get(userId).get(questionID)) {
							userAnswers.get(userId).get(questionID).add(answer);
						} else {
							List<String> mcmAnswers = new ArrayList<>();
							mcmAnswers.add(answer);
							userAnswers.get(userId).put(questionID, mcmAnswers);
						}

					} else {
						List<String> mcmAnswers = new ArrayList<>();
						mcmAnswers.add(answer);
						Map<Long, List<String>> mcmQuestions = new HashMap<>();
						mcmQuestions.put(questionID, mcmAnswers);
						userAnswers.put(userId, mcmQuestions);
					}
				}
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Encountered SQL Exception while loading answers for course " + courseId);
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		log.log(Level.INFO, "Loaded answers for course " + courseId);
		return userAnswers;
	}

	@Override
	public Map<Long, Map<Long, String>> loadAnwersFreetextAnswers(long courseId) {

		Map<Long, Map<Long, String>> userAnswers = new HashMap<Long, Map<Long, String>>();
		CallStoredProcedure proc = null;

		try {
			proc = new CallStoredProcedure("spLoadAnswersFreetext(?)");
			proc.setParameter(1, courseId);

			ResultSet results = proc.executeWithResults();

			if (null != results) {
				while (results.next()) {
					long userId = results.getLong("studentID");
					long questionID = results.getLong("questionID");
					String answer = results.getString("answer");
					if (null != userAnswers.get(userId)) {
						userAnswers.get(userId).put(questionID, answer);
					} else {
						Map<Long, String> freeTextQuestion = new HashMap<>();
						freeTextQuestion.put(questionID, answer);
						userAnswers.put(userId, freeTextQuestion);
					}
				}
			}

		} catch (SQLException e) {
			log.log(Level.SEVERE, "Encountered SQL Exception while loading answers for course " + courseId);
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		log.log(Level.INFO, "Loaded answers for course " + courseId);
		return userAnswers;
	}

}
