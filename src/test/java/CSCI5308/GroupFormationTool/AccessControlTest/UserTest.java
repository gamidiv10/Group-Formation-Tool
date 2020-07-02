package CSCI5308.GroupFormationTool.AccessControlTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Security.IPasswordEnforcementPolicyPersistence;
import CSCI5308.GroupFormationTool.Security.IUserHistroyRelationshipPersistence;
import CSCI5308.GroupFormationTool.Security.PasswordEnforcementPolicy;
import CSCI5308.GroupFormationTool.SecurityTest.PasswordEncryptionMock;
import CSCI5308.GroupFormationTool.SecurityTest.PasswordEnforcementPolicyDBMock;
import CSCI5308.GroupFormationTool.SecurityTest.UserHistoryRelationshipDBMock;

@SpringBootTest
@SuppressWarnings("deprecation")
public class UserTest {
    @Test
    public void ConstructorTests() {
        User u = new User();
        Assert.isTrue(u.getBannerID().isEmpty());
        Assert.isTrue(u.getFirstName().isEmpty());
        Assert.isTrue(u.getLastName().isEmpty());
        Assert.isTrue(u.getEmail().isEmpty());

        IUserPersistence userDBMock = new UserDBMock();
        u = new User(1, userDBMock);
        Assert.isTrue(u.getBannerID().equals("B00000000"));

        u = new User("B00000000", userDBMock);
        Assert.isTrue(u.getBannerID().equals("B00000000"));
    }

    @Test
    public void setIDTest() {
        User u = new User();
        u.setID(10);
        Assert.isTrue(10 == u.getID());
    }

    @Test
    public void getIDTest() {
        User u = new User();
        u.setID(10);
        Assert.isTrue(10 == u.getID());
    }

    @Test
    public void setBannerIDTest() {
        User u = new User();
        u.setBannerID("B00000000");
        Assert.isTrue(u.getBannerID().equals("B00000000"));
    }

    @Test
    public void getBannerIDTest() {
        User u = new User();
        u.setBannerID("B00000000");
        Assert.isTrue(u.getBannerID().equals("B00000000"));
    }

    @Test
    public void setFirstNameTest() {
        User u = new User();
        u.setFirstName("Rob");
        Assert.isTrue(u.getFirstName().equals("Rob"));
    }

    @Test
    public void getFirstNameTest() {
        User u = new User();
        u.setFirstName("Rob");
        Assert.isTrue(u.getFirstName().equals("Rob"));
    }

    @Test
    public void setLastNameTest() {
        User u = new User();
        u.setLastName("Hawkey");
        Assert.isTrue(u.getLastName().equals("Hawkey"));
    }

    @Test
    public void getLastNameTest() {
        User u = new User();
        u.setLastName("Hawkey");
        Assert.isTrue(u.getLastName().equals("Hawkey"));
    }

    @Test
    public void setEmailTest() {
        User u = new User();
        u.setEmail("rhawkey@dal.ca");
        Assert.isTrue(u.getEmail().equals("rhawkey@dal.ca"));
    }

    @Test
    public void getEmailTest() {
        User u = new User();
        u.setEmail("rhawkey@dal.ca");
        Assert.isTrue(u.getEmail().equals("rhawkey@dal.ca"));
    }

    @Test
    public void createUser() {
        IUserPersistence userDB = new UserDBMock();
        User user = new User();
        userDB.createUser(user);
        Assert.isTrue(user.getId() == 0);
        Assert.isTrue(user.getBannerID().equals("B00000000"));
    }

    @Test
    public void isBannerIDValidTest() {
        Assert.isTrue(User.isBannerIDValid("B000000000"));
        Assert.isTrue(!User.isBannerIDValid(null));
        Assert.isTrue(!User.isBannerIDValid(""));
    }

    @Test
    public void isFirstNameValidTest() {
        Assert.isTrue(User.isFirstNameValid("rob"));
        Assert.isTrue(!User.isFirstNameValid(null));
        Assert.isTrue(!User.isFirstNameValid(""));
    }

    @Test
    public void isLastNameValidTest() {
        Assert.isTrue(User.isLastNameValid("hawkey"));
        Assert.isTrue(!User.isLastNameValid(null));
        Assert.isTrue(!User.isLastNameValid(""));
    }

    @Test
    public void isEmailValidTest() {
        Assert.isTrue(User.isEmailValid("rhawkey@dal.ca"));
        Assert.isTrue(!User.isEmailValid(null));
        Assert.isTrue(!User.isEmailValid(""));
        Assert.isTrue(!User.isEmailValid("@dal.ca"));
        Assert.isTrue(!User.isEmailValid("rhawkey@"));
    }

    @Test
    public void isPasswordValid() {

        IPasswordEnforcementPolicyPersistence PolicyPersistence = new PasswordEnforcementPolicyDBMock();
        PasswordEnforcementPolicy pwdPlocy = PasswordEnforcementPolicy.getInstance(PolicyPersistence);

        String pwd = "test@12";
        assertTrue(User.isPasswordValid(pwd, pwdPlocy));

        pwd = "test%12677";
        assertFalse(User.isPasswordValid(pwd, pwdPlocy));

    }

    @Test
    public void insertPasswordtoHistory() {

        User u = new User();
        u.setBannerID("B-008321");
        IUserHistroyRelationshipPersistence userHistoryDB = new UserHistoryRelationshipDBMock();
        assertTrue(u.insertPasswordtoHistory(userHistoryDB));

    }

    @Test
    public void isPrevPwd() {
        User u = new User();
        u.setBannerID("B-008321");
        u.setPassword("encrypted");

        IUserHistroyRelationshipPersistence userHistoryDB = new UserHistoryRelationshipDBMock();

        assertFalse(u.isPrevPwd(u, userHistoryDB, new PasswordEncryptionMock()));
        u.setPassword("");

        assertTrue(u.isPrevPwd(u, userHistoryDB, new PasswordEncryptionMock()));

    }
}
