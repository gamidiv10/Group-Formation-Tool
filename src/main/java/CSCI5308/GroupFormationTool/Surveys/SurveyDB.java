package CSCI5308.GroupFormationTool.Surveys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Question.Questions;

public class SurveyDB implements ISurveyPersistence{

	@Override
	public long createSurvey(Survey survey) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spCreateSurvey(?,?,?,?)");
			proc.setParameter(1, survey.getSurvey_name());
			proc.setParameter(2, survey.getCourseid());
			proc.setParameter(3, survey.getCreatedById());
			proc.setParameter(4, survey.getPublised());

			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					int surveyId = results.getInt("surveyId");
					survey.setSurveyId(surveyId);
				}
			}
						
		} catch (SQLException e) {
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return survey.getSurveyId();
	}
	
	@Override
	public boolean addQuestionsToSurvey(long surveyID, int questionId, String questionText) {
		CallStoredProcedure proc = null;
		boolean status = true;
		try {
			proc = new CallStoredProcedure("spAddQuestionToSurvey(?,?)");
			proc.setParameter(1,surveyID);
			proc.setParameter(2, questionId);
			proc.execute();
			
		} catch (SQLException e) {
			status = false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return status;
	}
	
	@Override
	public List<Questions> getAllSurveyQuestions(long surveyID) {
		CallStoredProcedure proc = null;
		List<Questions> questions = new ArrayList<>();
		try {
			proc = new CallStoredProcedure("spGetAllSurveyQuestions(?)");
			proc.setParameter(1, surveyID);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					Questions question = new Questions();
                    question.setQuestionId(results.getInt("questionID"));
                    question.setTitle(results.getString("title"));
                    question.setQuestionText(results.getString("questionText"));
                    question.setDateCreated(results.getDate("dateCreated"));
                    questions.add(question);				
				}
			}
		}catch (SQLException e) {
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questions;
	}
	
	@Override
	public List<Questions> getQuestionsForSurvey(long instructorID) {
		CallStoredProcedure proc = null;
		List<Questions> questions = new ArrayList<>();
		try {
			proc = new CallStoredProcedure("spGetQuestionsForSurvey(?)");
			proc.setParameter(1, instructorID);
			ResultSet results = proc.executeWithResults();
			if (null == results) {
				System.out.println("null value");
			}
			if (null != results) {
				while (results.next()) {
							Questions question = new Questions();
		                    question.setQuestionId(results.getInt("questionID"));
		                    question.setTitle(results.getString("title"));
		                    question.setQuestionText(results.getString("questionText"));
		                    question.setDateCreated(results.getDate("dateCreated"));
		                    questions.add(question);				
				}
			}
		}catch (SQLException e) {
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	return questions;
	}
	
	@Override
	public boolean deleteQuestionFromSurvey(int questionID, long surveyID) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDeleteQuestionsFromSurvey(?,?)");
			proc.setParameter(1, questionID);
			proc.setParameter(2, surveyID);
			proc.execute();
		}catch (SQLException e) {
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return true;
	}

	@Override
	public long getSurveyIdByCourseId(long courseId) {
		CallStoredProcedure proc = null;
		long surveyId = -1;
		try {
			proc = new CallStoredProcedure("spGetSurveyIdByCourseId(?)");
			proc.setParameter(1, courseId);
			ResultSet results = proc.executeWithResults();
			if (null == results) {
				System.out.println("null value");
			}
			if (null != results) {
				while (results.next()) {
					surveyId = results.getLong("surveyId");
				}
			}
		}catch (SQLException e) {
			System.out.println("Exception");
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return surveyId;
	}

	@Override
	public int getSurveyStatus(long surveyId) {
		CallStoredProcedure proc = null;
		int surveyStatus = -1;
		try {
			proc = new CallStoredProcedure("spGetSurveyStatus(?)");
			proc.setParameter(1, surveyId);
			ResultSet results = proc.executeWithResults();
			if (null == results) {
				System.out.println("null value");
			}
			if (null != results) {
				while (results.next()) {
					surveyStatus= results.getInt("published");
				}
			}
		}catch (SQLException e) {
			System.out.println("Exception");
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return surveyStatus;
	}

}
