package CSCI5308.GroupFormationTool.SecurityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.IPasswordEnforcementPolicyPersistence;
import CSCI5308.GroupFormationTool.Security.PasswordEnforcementPolicy;

public class PasswordEnforcementPolicyTest {

    @Test
    public void ConstructorTests() {

        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
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

        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinLength(1);
        assertEquals(1, pwdPolicy.getMinLength());

    }

    @Test
    public void setMinLength() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinLength(1);
        assertEquals(1, pwdPolicy.getMinLength());

    }

    @Test
    public void getMaxLength() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMaxLength(8);
        assertEquals(8, pwdPolicy.getMaxLength());

    }

    @Test
    public void setMaxLength() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMaxLength(8);
        assertEquals(8, pwdPolicy.getMaxLength());

    }

    @Test
    public void getMinUpperCase() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinUpperCase(1);
        assertEquals(1, pwdPolicy.getMinUpperCase());

    }

    @Test
    public void setMinUpperCase() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinUpperCase(1);
        assertEquals(1, pwdPolicy.getMinUpperCase());

    }

    @Test
    public void getMinLowerCase() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinLowerCase(3);
        assertEquals(3, pwdPolicy.getMinLowerCase());

    }

    @Test
    public void setMinLowerCase() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinLowerCase(3);
        assertEquals(3, pwdPolicy.getMinLowerCase());

    }

    @Test
    public void getMinSpecialChar() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinSpecialChar(1);
        assertEquals(1, pwdPolicy.getMinSpecialChar());

    }

    @Test
    public void setMinSpecialChar() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setMinSpecialChar(1);
        assertEquals(1, pwdPolicy.getMinSpecialChar());

    }

    @Test
    public void getNotAllowedChar() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setNotAllowedChar("%");
        assertEquals("%", pwdPolicy.getNotAllowedChar());

    }

    @Test
    public void setNotAllowedChar() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setNotAllowedChar("%");
        assertEquals("%", pwdPolicy.getNotAllowedChar());

    }

    @Test
    public void getHistoryConstraint() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setHistoryConstraint(1);
        assertEquals(1, pwdPolicy.getHistoryConstraint());

    }

    @Test
    public void setHistoryConstraint() {
        IPasswordEnforcementPolicyPersistence mockPolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPolicy = PasswordEnforcementPolicy.getInstance(mockPolicyPersistence);
        pwdPolicy.setHistoryConstraint(1);
        assertEquals(1, pwdPolicy.getHistoryConstraint());

    }

}
