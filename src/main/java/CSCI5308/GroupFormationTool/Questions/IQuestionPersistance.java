package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionPersistance {
	
	public List<Questions> loadAllQuestionTitlesByInstructorID(long instructorID);

}
