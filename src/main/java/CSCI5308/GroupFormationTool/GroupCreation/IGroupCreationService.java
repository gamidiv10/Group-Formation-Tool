package CSCI5308.GroupFormationTool.GroupCreation;

import java.util.List;
import java.util.Map;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IGroupCreationService {

	// Map<Integer, Map<User, List<String>>>
	
	public Map<Integer, Map<User, List<String>>> createTeams(List<SurveyRules> surveyRules, IUserPersistence user,
			IGroupCreationAnswersPersistence answers);

}
