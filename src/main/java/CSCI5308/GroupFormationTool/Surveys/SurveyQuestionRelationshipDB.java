package CSCI5308.GroupFormationTool.Surveys;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Question.Questions;

public class SurveyQuestionRelationshipDB implements ISurveyQuestionRelationshipPersistence {
	private Logger log = Logger.getLogger(SurveyQuestionRelationshipDB.class.getName());
	@Override
	public List<Questions> loadQuestionByID(long surveyID) {
		CallStoredProcedure proc = null;
		List<Questions> questionList = new ArrayList<Questions>();
		try {
			proc = new CallStoredProcedure("spLoadQuestionById(?)");
			proc.setParameter(1, surveyID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					String title = results.getString("title");
					String questionText = results.getString("questionText");
					Integer questionId = results.getInt("questionID");
					int typeID = results.getInt("typeID");
					Questions q = new Questions();
					q.setQuestionText(questionText);
					q.setTitle(title);
					q.setQuestionId(questionId);
					q.setTypeID(typeID);
					questionList.add(q);
				}
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Encountered SQL Exception while loading the questions with survey ID: " + surveyID);
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		log.log(Level.INFO, "Loading questions with survey " + surveyID);
		return questionList;
	}

}
