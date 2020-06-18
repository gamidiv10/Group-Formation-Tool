package CSCI5308.GroupFormationTool.SecurityTest;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Security.IUserHistroyRelationshipPersistence;

public class UserHistoryRelationshipDBMock implements IUserHistroyRelationshipPersistence
{

	@Override
	public boolean insertPasswordtoHistory(User user) {
		
		return true;
	}

	@Override
	public List<String> getPreviousPasswords(User user, int historyConstraint) {
		List<String> pwd = new ArrayList<>();
		pwd.add("encrypted");
		return pwd;
	}

}
