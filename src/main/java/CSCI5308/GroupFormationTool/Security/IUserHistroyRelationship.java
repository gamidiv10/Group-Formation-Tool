package CSCI5308.GroupFormationTool.Security;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface IUserHistroyRelationship {
    public boolean insertPasswordtoHistory(User user, IUserHistroyRelationshipPersistence userHistoryRelationshipDb);

    public List<String> getPreviousPasswords(User user, int historyConstraint, IUserHistroyRelationshipPersistence userHistoryRelationshipDb);
}
