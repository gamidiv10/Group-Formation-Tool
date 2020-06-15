package CSCI5308.GroupFormationTool.SecurityTest;

import CSCI5308.GroupFormationTool.Security.IPasswordEnforcementPolicy;
import CSCI5308.GroupFormationTool.Security.PasswordEnforcementPolicy;

public class PasswordEnforcementPolicyDBMock implements IPasswordEnforcementPolicy {

	@Override
	public void loadPasswordEnforcementPolicy(PasswordEnforcementPolicy policy) {
		policy.setMaxLength(8);
		policy.setMinLength(1);
		policy.setMinLowerCase(3);
		policy.setMinUpperCase(1);
		policy.setMinSpecialChar(1);
		policy.setNotAllowedChar("%");
		policy.setHistoryConstraint(1);

	}

}
