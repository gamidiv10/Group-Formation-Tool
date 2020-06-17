package CSCI5308.GroupFormationTool.Questions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class QuestionDB implements IQuestionPersistance {

	@Override
	public List<Questions> loadAllQuestionTitlesByInstructorID(long instructorID) {
		
		List<Questions> questions= new ArrayList<>();
		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spLoadAllQuestionTitlesByInstructorID(?)");
			proc.setParameter(1, instructorID);
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					questions.add(new Questions(results.getString(1), results.getDate(2)));
				}
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return questions;
	}

}
