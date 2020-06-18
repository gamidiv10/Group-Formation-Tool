package CSCI5308.GroupFormationTool.SecurityTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Security.IUserHistroyRelationshipPersistence;
import CSCI5308.GroupFormationTool.Security.UserHistoryRelationship;
import CSCI5308.GroupFormationTool.Security.UserHistoryRelationshipDB;

public class UserHistoryRelationshipTest {

	@Test
	public void insertPasswordtoHistory() {
		User u = new User();
		u.setBannerID("B-008321");
		IUserHistroyRelationshipPersistence userHistoryDB = new UserHistoryRelationshipDBMock();
		assertTrue(new UserHistoryRelationship().insertPasswordtoHistory(u, userHistoryDB));

	}

	@Test
	public void getPreviousPasswords() {

		User u = new User();
		u.setID(1);
		int historyConstraint = 1;
		IUserHistroyRelationshipPersistence userHistoryDB = new UserHistoryRelationshipDBMock();
		assertNotNull(new UserHistoryRelationship().getPreviousPasswords(u, historyConstraint, userHistoryDB));
	}

}
