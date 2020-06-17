package CSCI5308.GroupFormationTool.QuestionsTest;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistance;
import CSCI5308.GroupFormationTool.Questions.Questions;

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
		
		questions = new Questions("title",new Date(System.currentTimeMillis()));
		Assert.isTrue(questions.getTitle() == "title");
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
