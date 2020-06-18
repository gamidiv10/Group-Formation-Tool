package CSCI5308.GroupFormationTool.Security;

import CSCI5308.GroupFormationTool.SystemConfig;

public class PasswordEnforcementPolicy {

	private int minLength;
	private int maxLength;
	private int minUpperCase;
	private int minLowerCase;
	private int minSpecialChar;
	private String notAllowedChar;
	private int historyConstraint;
	private static String toDisplayPolicies;

	private static PasswordEnforcementPolicy uniqueInstance = null;

	private PasswordEnforcementPolicy(IPasswordEnforcementPolicyPersistence policy) {
		policy.loadPasswordEnforcementPolicy(this);
		toDisplayPolicies();

	}

	public static PasswordEnforcementPolicy getInstance(IPasswordEnforcementPolicyPersistence policy) {

		if (null == uniqueInstance) {
			uniqueInstance = new PasswordEnforcementPolicy(policy);
		}
		return uniqueInstance;
	}

	public static String getToDisplayPolicies() {
		return toDisplayPolicies;
	}

	public static void setToDisplayPolicies(String toDisplayPolicies) {
		PasswordEnforcementPolicy.toDisplayPolicies = toDisplayPolicies;
	}

	public void toDisplayPolicies() {
		toDisplayPolicies = "";
		if (this.minLength != -1) {
			toDisplayPolicies = toDisplayPolicies + "The Minimum length of password should be "
					+ String.valueOf(this.minLength) + "\n";

		}
		if (this.maxLength != -1) {
			toDisplayPolicies = toDisplayPolicies + "The Maximum length of password should be "
					+ String.valueOf(this.minLength) + "\n";

		}
		if (this.minUpperCase != -1) {

			toDisplayPolicies = toDisplayPolicies + "The password should contain atleast"
					+ String.valueOf(this.minUpperCase) + " upper case character(s) " + "\n";

		}

		if (this.minLowerCase != -1) {

			toDisplayPolicies = toDisplayPolicies + "The password should contain atleast"
					+ String.valueOf(this.minLowerCase) + " upper lower character(s) " + "\n";

		}

		if (this.minSpecialChar != -1) {
			toDisplayPolicies = toDisplayPolicies + "The password should contain atleast"
					+ String.valueOf(this.minSpecialChar) + " special character (s) " + "\n";
		}

		if ((this.notAllowedChar) != null) {
			toDisplayPolicies = toDisplayPolicies + "The password should not contain " + this.notAllowedChar
					+ " special character (s) " + "\n";
		}

	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMinUpperCase() {
		return minUpperCase;
	}

	public void setMinUpperCase(int minUpperCase) {
		this.minUpperCase = minUpperCase;
	}

	public int getMinLowerCase() {
		return minLowerCase;
	}

	public void setMinLowerCase(int minLowerCase) {
		this.minLowerCase = minLowerCase;
	}

	public int getMinSpecialChar() {
		return minSpecialChar;
	}

	public void setMinSpecialChar(int minSpecialChar) {
		this.minSpecialChar = minSpecialChar;
	}

	public String getNotAllowedChar() {
		return notAllowedChar;
	}

	public void setNotAllowedChar(String notAllowedChar) {
		this.notAllowedChar = notAllowedChar;
	}

	public int getHistoryConstraint() {
		return historyConstraint;
	}

	public void setHistoryConstraint(int historyConstraint) {
		this.historyConstraint = historyConstraint;
	}

}
