package CSCI5308.GroupFormationTool.GroupCreationTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.GroupCreation.IGroupCreationAnswersPersistence;

public class AnswersDBMock implements IGroupCreationAnswersPersistence {

	@Override
	public Map<Long, Map<Long, Integer>> loadAnwersNumericQn(long courseid) {
		Map<Long, Map<Long, Integer>> allNumAnswers = new HashMap<Long, Map<Long, Integer>>();
		Map<Long, Integer> numAnswers = new HashMap<>();
		numAnswers.put(1L, 1);
		allNumAnswers.put(1L, numAnswers);

		return allNumAnswers;
	}

	@Override
	public Map<Long, Map<Long, String>> loadAnwersMco(long courseId) {
		Map<Long, Map<Long, String>> allMcoAnswers = new HashMap<Long, Map<Long, String>>();
		Map<Long, String> mcoAnswers = new HashMap<>();
		mcoAnswers.put(2L, "good");
		allMcoAnswers.put(2L, mcoAnswers);
		return allMcoAnswers;
	}

	@Override
	public Map<Long, Map<Long, List<String>>> loadAnwersMcm(long courseId) {
		Map<Long, Map<Long, List<String>>> allMcmAnswers = new HashMap<Long, Map<Long, List<String>>>();
		Map<Long, List<String>> mcmAnswersMap = new HashMap<Long, List<String>>();
		List<String> mcmList = new ArrayList<>();
		mcmList.add("bad");
		mcmAnswersMap.put(2L, mcmList);
		allMcmAnswers.put(1L, mcmAnswersMap);

		return allMcmAnswers;
	}

	@Override
	public Map<Long, Map<Long, String>> loadAnwersFreetextAnswers(long courseId) {
		Map<Long, Map<Long, String>> allFreeTextAnswers = new HashMap<Long, Map<Long, String>>();
		Map<Long, String> freeTextAnswers = new HashMap<>();
		freeTextAnswers.put(1L, "seven");
		allFreeTextAnswers.put(1L, freeTextAnswers);
		return allFreeTextAnswers;
	}

}
