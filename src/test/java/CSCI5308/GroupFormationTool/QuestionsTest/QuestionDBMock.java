package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestionPersistance;
import CSCI5308.GroupFormationTool.Questions.Questions;

@SuppressWarnings("deprecation")
public class QuestionDBMock implements IQuestionPersistance
{

	@Override
	public List<Questions> loadAllQuestionTitlesByInstructorID(long instructorID) 
	{
		List<Questions> questions= new ArrayList<>();
		Questions q = new Questions("test", new Date(2020,06,17));
		questions.add(q);
		return questions;
	}
	
}
