package CSCI5308.GroupFormationTool.Security;

import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.User;

public class UserHistoryRelationship implements IUserHistroyRelationship {

	@Override
	public boolean insertPasswordtoHistory(User user, IUserHistroyRelationshipPersistence userHistoryRelationShipDb) {

		return userHistoryRelationShipDb.insertPasswordtoHistory(user);
	}

	@Override
	public List<String> getPreviousPasswords(User user, int historyConstraint,
			IUserHistroyRelationshipPersistence userHistoryRelationShipDb) {


		return userHistoryRelationShipDb.getPreviousPasswords(user, historyConstraint);
	}

}
