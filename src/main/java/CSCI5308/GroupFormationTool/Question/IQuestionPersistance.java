package CSCI5308.GroupFormationTool.Question;

import java.util.List;

public interface IQuestionPersistance {
	
	public List<Questions> loadAllQuestionTitlesByInstructorID(long instructorID);

}
