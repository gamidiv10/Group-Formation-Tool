package CSCI5308.GroupFormationTool.QuestionsTest;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import CSCI5308.GroupFormationTool.Question.IQuestionPersistance;
import CSCI5308.GroupFormationTool.Question.Questions;

@SuppressWarnings("deprecation")
public class QuestionDBMock implements IQuestionPersistance
{

	@Override
	public List<Questions> loadAllQuestionTitlesByInstructorID(long instructorID)
	{
		List<Questions> questions= new ArrayList<>();
		Questions q = new Questions(20, "test", "This is demo text", new Date(2020,06,17));
		questions.add(q);
		return questions;
	}

	@Override
	public void loadQuestionById(Integer questionId, Questions question) {
		question.setQuestionId(questionId);
		question.setDateCreated(new Date(System.currentTimeMillis()));
		question.setQuestionText("Hi, How was your day going today?");
		question.setTitle("Say hello");
	}

	@Override
	public boolean deleteQuestion(Integer questionId) {
		Questions question = new Questions();
		question.setQuestionId(questionId);
		question.setTitle("Demo title");
		question.setQuestionText("This a demo question description");
		question.setDateCreated(new Date(System.currentTimeMillis()));
		question.setDefaults();
		return true;
	}
}
