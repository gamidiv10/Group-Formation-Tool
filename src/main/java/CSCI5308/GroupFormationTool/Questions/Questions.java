package CSCI5308.GroupFormationTool.Questions;

import java.util.Collections;
import java.sql.Date;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public class Questions {

	private String title;
	private Date dateCreated;
	
	public Questions()
	{
		setDefaults();
	}

	public Questions(String string, Date date) {
		title = string;
		dateCreated = date;
	}

	public void setDefaults() 
	{
		title = "";
		setDateCreated(null);
		
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}

	public Date getDateCreated() 
	{
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) 
	{
		this.dateCreated = dateCreated;
	}
	
	public List<Questions> getAllQuestionTitlesByInstructorID(IQuestionPersistance questionDB, long instructorID)
	{
		return questionDB.loadAllQuestionTitlesByInstructorID(instructorID);
	}
	
	public List<Questions> sortByTile( IQuestionPersistance questionDB, User u) 
	{
		List<Questions> questions = questionDB.loadAllQuestionTitlesByInstructorID(u.getID());
		Collections.sort(questions, (Questions o1, Questions o2) -> 
        o1.getTitle().compareTo( o2.getTitle() ));
		return questions;
	}

	public List<Questions> sortByDate(IQuestionPersistance questionDB, User u) 
	{
		List<Questions> questions = questionDB.loadAllQuestionTitlesByInstructorID(u.getID());
		Collections.sort(questions, (Questions o1, Questions o2) -> 
        o1.getDateCreated().compareTo( o2.getDateCreated() ));
		return questions;
	}
}
