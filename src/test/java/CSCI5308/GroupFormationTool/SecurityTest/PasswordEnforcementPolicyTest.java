package CSCI5308.GroupFormationTool.SecurityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.IPasswordEnforcementPolicy;
import CSCI5308.GroupFormationTool.Security.PasswordEnforcementPolicy;

public class PasswordEnforcementPolicyTest {

	@Test
	public void ConstructorTests() {

		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);

		assertEquals(8, pwdPolicy.getMaxLength());
		assertEquals(1, pwdPolicy.getMinLength());
		assertEquals(3, pwdPolicy.getMinLowerCase());
		assertEquals(1, pwdPolicy.getMinUpperCase());
		assertEquals(1, pwdPolicy.getMinSpecialChar());
		assertEquals("%", pwdPolicy.getNotAllowedChar());
		assertEquals(1, pwdPolicy.getHistoryConstraint());

	}

	@Test
	public void getMinLength() {

		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinLength(1);
		assertEquals(1, pwdPolicy.getMinLength());

	}

	@Test
	public void setMinLength() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinLength(1);
		assertEquals(1, pwdPolicy.getMinLength());

	}

	@Test
	public void getMaxLength() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMaxLength(8);
		assertEquals(8, pwdPolicy.getMaxLength());

	}

	@Test
	public void setMaxLength() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMaxLength(8);
		assertEquals(8, pwdPolicy.getMaxLength());

	}

	@Test
	public void getMinUpperCase() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinUpperCase(1);
		assertEquals(1, pwdPolicy.getMinUpperCase());

	}

	@Test
	public void setMinUpperCase() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinUpperCase(1);
		assertEquals(1, pwdPolicy.getMinUpperCase());

	}

	@Test
	public void getMinLowerCase() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinLowerCase(3);
		assertEquals(3, pwdPolicy.getMinLowerCase());

	}

	@Test
	public void setMinLowerCase() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinLowerCase(3);
		assertEquals(3, pwdPolicy.getMinLowerCase());

	}

	@Test
	public void getMinSpecialChar() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinSpecialChar(1);
		assertEquals(1, pwdPolicy.getMinSpecialChar());

	}

	@Test
	public void setMinSpecialChar() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setMinSpecialChar(1);
		assertEquals(1, pwdPolicy.getMinSpecialChar());

	}

	@Test
	public void getNotAllowedChar() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setNotAllowedChar("%");
		assertEquals("%", pwdPolicy.getNotAllowedChar());

	}

	@Test
	public void setNotAllowedChar() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setNotAllowedChar("%");
		assertEquals("%", pwdPolicy.getNotAllowedChar());

	}

	@Test
	public void getHistoryConstraint() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setHistoryConstraint(1);
		assertEquals(1, pwdPolicy.getHistoryConstraint());

	}

	@Test
	public void setHistoryConstraint() {
		IPasswordEnforcementPolicy mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
		pwdPolicy.setHistoryConstraint(1);
		assertEquals(1, pwdPolicy.getHistoryConstraint());

	}

	@Test
	public void isPasswordValid() {

		IPasswordEnforcementPolicy PolicyPersistence = new PasswordEnforcementPolicyDBMock();
		PasswordEnforcementPolicy.getInstance(PolicyPersistence);

		String pwd = "test@12";
		assertTrue(PasswordEnforcementPolicy.isPasswordValid(pwd));
		
		pwd = "test%12677";
		assertFalse(PasswordEnforcementPolicy.isPasswordValid(pwd));

	}

}
