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

	private PasswordEnforcementPolicy(IPasswordEnforcementPolicy policy) {
		policy.loadPasswordEnforcementPolicy(this);

	}

	public static PasswordEnforcementPolicy getInstance(IPasswordEnforcementPolicy policy) {

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

	public static boolean isPasswordValid(String password) {
		String compare = password;
		int passwordCount = 0;
		int minUpperCaseCount = 0;
		int minLowerCaseCount = 0;
		int minSpecialCharCount = 0;
		passwordCount = password.length();
		System.out.println("password length " + passwordCount);

		minLowerCaseCount = passwordCount - compare.replaceAll("[a-z]", "").length();

		minUpperCaseCount = passwordCount - compare.replaceAll("[A-Z]", "").length();

		minSpecialCharCount = passwordCount - compare.replaceAll("[^A-Z|a-z||d]", "").length();

		System.out.println("Min Lower Case count " + minLowerCaseCount);

		System.out.println("Min Upper Case count " + minUpperCaseCount);

		if ((uniqueInstance.minLength != -1) && (password.length() < uniqueInstance.minLength)) {

			System.out.println("minlength " + password.length());
			return false;

		}
		if ((uniqueInstance.maxLength != -1) && (password.length() > uniqueInstance.maxLength)) {
			System.out.println("max length " + password.length());
			return false;
		}
		if ((uniqueInstance.minUpperCase != -1) && (minUpperCaseCount > uniqueInstance.minUpperCase)) {

			System.out.println("upper case " + minUpperCaseCount);
			return false;
		}

		if ((uniqueInstance.minLowerCase != -1) && (minLowerCaseCount < uniqueInstance.minLowerCase)) {
			System.out.println("lower case " + minUpperCaseCount);
			return false;
		}

		if ((uniqueInstance.minSpecialChar != -1) && (minSpecialCharCount < uniqueInstance.minSpecialChar)) {
			System.out.println("special char " + minSpecialCharCount);
			return false;
		}
		for (int i = 0; i < passwordCount; i++) {
			char[] cmp = compare.toCharArray();
			char[] specialChar = uniqueInstance.notAllowedChar.toCharArray();

			if (cmp == specialChar) {

				System.out.println("not allowed char " + specialChar.toString());
				return false;
			}

		}

		return true;
	}

	public void toDisplayPolicies() {
		toDisplayPolicies = "";
		if (uniqueInstance.minLength != -1) {
			toDisplayPolicies = toDisplayPolicies + "The Minimum length of password should be "
					+ String.valueOf(uniqueInstance.minLength) + "\n";

		}
		if (uniqueInstance.maxLength != -1) {
			toDisplayPolicies = toDisplayPolicies + "The Maximum length of password should be "
					+ String.valueOf(uniqueInstance.minLength) + "\n";

		}
		if (uniqueInstance.minUpperCase != -1) {

			toDisplayPolicies = toDisplayPolicies + "The password should contain atleast"
					+ String.valueOf(uniqueInstance.minUpperCase) + " upper case character(s) " + "\n";

		}

		if (uniqueInstance.minLowerCase != -1) {

			toDisplayPolicies = toDisplayPolicies + "The password should contain atleast"
					+ String.valueOf(uniqueInstance.minLowerCase) + " upper lower character(s) " + "\n";

		}

		if (uniqueInstance.minSpecialChar != -1) {
			toDisplayPolicies = toDisplayPolicies + "The password should contain atleast"
					+ String.valueOf(uniqueInstance.minSpecialChar) + " special character (s) " + "\n";
		}

		if ((uniqueInstance.notAllowedChar) != null) {
			toDisplayPolicies = toDisplayPolicies + "The password should not contain " + uniqueInstance.notAllowedChar
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
