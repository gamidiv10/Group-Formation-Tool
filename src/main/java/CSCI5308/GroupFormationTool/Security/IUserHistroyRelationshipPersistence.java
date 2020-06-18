package CSCI5308.GroupFormationTool.Security;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IUserHistroyRelationshipPersistence {

	public boolean insertPasswordtoHistory(User user);

	public List<String> getPreviousPasswords(User user, int historyConstraint);

}
