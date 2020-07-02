package CSCI5308.GroupFormationTool.AccessControl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IUserHistroyRelationship;
import CSCI5308.GroupFormationTool.Security.IUserHistroyRelationshipPersistence;
import CSCI5308.GroupFormationTool.Security.PasswordEnforcementPolicy;
import CSCI5308.GroupFormationTool.Security.UserHistoryRelationship;

public class User {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private long id;
    private String password;
    private String bannerID;
    private String firstName;
    private String lastName;
    private String email;
    private IUserHistroyRelationship userHistory;

    public User() {
        setDefaults();
    }

    public static boolean isPasswordValid(String password, PasswordEnforcementPolicy uniqueInstance) {
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

        if ((uniqueInstance.getMinLength() != -1) && (password.length() < uniqueInstance.getMinLength())) {

            System.out.println("minlength " + password.length());
            return false;

        }
        if ((uniqueInstance.getMaxLength() != -1) && (password.length() > uniqueInstance.getMaxLength())) {
            System.out.println("max length " + password.length());
            return false;
        }
        if ((uniqueInstance.getMinUpperCase() != -1) && (minUpperCaseCount > uniqueInstance.getMinUpperCase())) {

            System.out.println("upper case " + minUpperCaseCount);
            return false;
        }

        if ((uniqueInstance.getMinLowerCase() != -1) && (minLowerCaseCount < uniqueInstance.getMinLowerCase())) {
            System.out.println("lower case " + minUpperCaseCount);
            return false;
        }

        if ((uniqueInstance.getMinSpecialChar() != -1) && (minSpecialCharCount < uniqueInstance.getMinSpecialChar())) {
            System.out.println("special char " + minSpecialCharCount);
            return false;
        }
        for (int i = 0; i < passwordCount; i++) {
            char[] cmp = compare.toCharArray();
            char[] specialChar = uniqueInstance.getNotAllowedChar().toCharArray();

            if (cmp == specialChar) {

                System.out.println("not allowed char " + specialChar.toString());
                return false;
            }

        }

        return true;
    }

    public boolean insertPasswordtoHistory(IUserHistroyRelationshipPersistence userHistoryDB) {

        return userHistory.insertPasswordtoHistory(this, userHistoryDB);
    }

    public boolean isPrevPwd(User user, IUserHistroyRelationshipPersistence userHistoryDB, IPasswordEncryption encPwd) {
        List<String> listOfPrevPwd = new ArrayList<String>();
        listOfPrevPwd = userHistory.getPreviousPasswords(user,
                SystemConfig.instance().getPasswordEnforcementPolicy().getHistoryConstraint(), userHistoryDB);

        for (String cmpPwd : listOfPrevPwd) {
            if (encPwd.matches(this.password, cmpPwd)) {

                System.out.println("inside user isPrevPwd enc " + cmpPwd);
                System.out.println("inside user isPrevPwd " + this.password);
                return false;
            }
        }

        return true;
    }

    public User(long id, IUserPersistence persistence) {
        setDefaults();
        persistence.loadUserByID(id, this);
    }

    public User(String bannerID, IUserPersistence persistence) {
        setDefaults();
        persistence.loadUserByBannerID(bannerID, this);
    }

    public void setDefaults() {
        id = -1;
        password = "";
        bannerID = "";
        firstName = "";
        lastName = "";
        email = "";
        userHistory = new UserHistoryRelationship();
    }

    public void setID(long id) {
        this.id = id;
    }

    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    public String getBannerID() {
        return bannerID;
    }

    public String getBanner() {
        return bannerID;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean isValidUser() {
        return id != -1;
    }

    public boolean createUser(IUserPersistence userDB, IPasswordEncryption passwordEncryption,
                              IUserNotifications notification) {
        String rawPassword = password;
        this.password = passwordEncryption.encryptPassword(this.password);
        boolean success = userDB.createUser(this);
        if (success && (null != notification)) {
            notification.sendUserLoginCredentials(this, rawPassword);
        }
        return success;
    }

    public boolean updateUser(IUserPersistence userDB) {
        return userDB.updateUser(this);
    }

    private static boolean isStringNullOrEmpty(String s) {
        if (null == s) {
            return true;
        }
        return s.isEmpty();
    }

    public static boolean isBannerIDValid(String bannerID) {
        return !isStringNullOrEmpty(bannerID);
    }

    public static boolean isFirstNameValid(String name) {
        return !isStringNullOrEmpty(name);
    }

    public static boolean isLastNameValid(String name) {
        return !isStringNullOrEmpty(name);
    }

    public static boolean isEmailValid(String email) {
        if (isStringNullOrEmpty(email)) {
            return false;
        }

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}