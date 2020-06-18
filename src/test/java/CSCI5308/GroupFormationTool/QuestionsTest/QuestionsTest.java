package CSCI5308.GroupFormationTool.QuestionsTest;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Question.IQuestionPersistance;
import CSCI5308.GroupFormationTool.Question.Questions;

@SpringBootTest
@SuppressWarnings("deprecation")
public class QuestionsTest
{
	@Test
	public void ConstructorTests()
	{
		Questions questions = new Questions();
		Assert.isTrue(questions.getTitle() == "");
		Assert.isNull(questions.getDateCreated());
		questions = new Questions(20, "test", "This is demo text", new Date(System.currentTimeMillis()));
		Assert.isTrue(questions.getQuestionId() == 20);
		Assert.isTrue(questions.getTitle() == "test");
		Assert.isTrue(questions.getQuestionText() == "This is demo text");
		Assert.isTrue(questions.getDateCreated() != null);

	}

	@Test
	public void setTitleTest()
	{
		Questions questions = new Questions();
		questions.setTitle("test");
		Assert.isTrue(questions.getTitle().equals("test"));
	}

	@Test
	public void getTitleTest()
	{
		Questions questions = new Questions();
		questions.getTitle();
		Assert.isTrue(questions.getTitle().equals(""));
	}

	@Test
	public void setDateCreatedTest()
	{
		Questions questions = new Questions();
		questions.setDateCreated(new Date(System.currentTimeMillis()));
		Assert.isTrue(questions.getDateCreated() != null);
	}

	@Test
	public void getDateCreatedTest()
	{
		Questions questions = new Questions();
		questions.getDateCreated();
		Assert.isTrue(questions.getDateCreated() == null);
	}

	@Test
	void getQuestionId() {
		Questions questions = new Questions();
		Assert.isTrue(questions.getQuestionId() == -1);
		questions.setQuestionId(20);
		Assert.isTrue(questions.getQuestionId() != -1);
		Assert.notNull(questions.getQuestionId());

	}

	@Test
	void setQuestionId() {
		Questions questions = new Questions();
		questions.setQuestionId(20);
		Assert.isTrue(questions.getQuestionId() == 20);
	}

	@Test
	void getQuestionText() {
		Questions questions = new Questions();
		Assert.isTrue(questions.getQuestionText() == "");
		questions.setQuestionText("This is a demo question");
		Assert.isTrue(questions.getQuestionText() != "");
	}

	@Test
	void setQuestionText() {
		Questions questions = new Questions();
		questions.setQuestionText("This is a important question, please answer");
		Assert.isTrue(questions.getQuestionText() == "This is a important question, please answer");
	}

	@Test
	void deleteQuestion() {
		IQuestionPersistance questionDB = new QuestionDBMock();
		boolean status = questionDB.deleteQuestion(1);
		Assert.isTrue(status);
	}

	@Test
	void loadQuestionById() {
		IQuestionPersistance questionDB = new QuestionDBMock();
		Questions question = new Questions();
		Assert.isTrue(question.getQuestionId() == -1);
		Assert.isTrue(question.getTitle() == "");
		Assert.isTrue(question.getQuestionText() == "");
		Assert.isTrue(question.getDateCreated() == null);
		questionDB.loadQuestionById(10, question);

		Assert.isTrue(question.getQuestionId() == 10);
		Assert.isTrue(question.getTitle() != null);
		Assert.isTrue(question.getQuestionText() != null);
		Assert.isTrue(question.getDateCreated() != null);
	}

	@Test
	public void sortByTitleTest()
	{
		IQuestionPersistance questionDB = new QuestionDBMock();
		User u = new User();
		u.setID(0);
		Questions questions = new Questions();
		List<Questions> list = questions.sortByTile(questionDB, u);
		for(Questions q:list)
		{
			Assert.isTrue(q.getTitle().equals("test"));
			Assert.isTrue(q.getDateCreated() != null);
		}
	}

	@Test
	public void sortByDateTest()
	{
		IQuestionPersistance questionDB = new QuestionDBMock();
		User u = new User();
		u.setID(0);
		Questions questions = new Questions();
		List<Questions> list = questions.sortByTile(questionDB, u);
		for(Questions q:list)
		{
			Assert.isTrue(q.getTitle().equals("test"));
			Assert.isTrue(q.getDateCreated() != null);
		}
	}

	@Test
	public void getAllQuestionTitlesByInstructorIDTest()
	{
		Questions questions = new Questions();
		IQuestionPersistance questionDB = new QuestionDBMock();
		long instructorID = 10;
		List<Questions> list = questions.getAllQuestionTitlesByInstructorID(questionDB, instructorID);
		for(Questions q:list)
		{
			Assert.isTrue(q.getTitle().equals("test"));
			Assert.isTrue(q.getDateCreated() != null);
		}

	}
}
