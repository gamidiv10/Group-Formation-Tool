package CSCI5308.GroupFormationTool.GroupCreation;

import java.util.List;
import java.util.Map;

public interface IGroupCreationAnswersPersistence {

	public Map<Long, Map<Long, Integer>> loadAnwersNumericQn(long courseid);

	public Map<Long, Map<Long, String>> loadAnwersMco(long courseId);

	public Map<Long, Map<Long, List<String>>> loadAnwersMcm(long courseId);

	public Map<Long, Map<Long, String>> loadAnwersFreetextAnswers(long courseId);

}
