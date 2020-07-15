package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Security.*;
import CSCI5308.GroupFormationTool.Surveys.ISurveyPersistence;
import CSCI5308.GroupFormationTool.Surveys.ISurveyQuestionRelationship;
import CSCI5308.GroupFormationTool.Surveys.ISurveyQuestionRelationshipPersistence;
import CSCI5308.GroupFormationTool.Surveys.SurveyDB;
import CSCI5308.GroupFormationTool.Surveys.SurveyQuestionRelationshipDB;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Database.*;
import CSCI5308.GroupFormationTool.Question.IQuestionPersistance;
import CSCI5308.GroupFormationTool.Question.QuestionDB;
import CSCI5308.GroupFormationTool.Courses.*;

public class SystemConfig {

    private static SystemConfig uniqueInstance = null;

    private IPasswordEncryption passwordEncryption;
    private IUserPersistence userDB;
    private IDatabaseConfiguration databaseConfiguration;
    private ICoursePersistence courseDB;
    private ICourseUserRelationshipPersistence courseUserRelationshipDB;
    private IQuestionPersistance questionPersistance;
    private ISurveyPersistence surveyDB;

    private IPasswordEnforcementPolicyPersistence passwordEnforcementPolicyDB;
    private IUserHistroyRelationshipPersistence userHistoryRelationshipDB;
	private ISurveyQuestionRelationshipPersistence surveyQuestionRelationshipDB;

    public ISurveyQuestionRelationshipPersistence getSurveyQuestionRelationshipDB() {
		return surveyQuestionRelationshipDB;
	}

	public void setSurveyQuestionRelationshipDB(ISurveyQuestionRelationshipPersistence surveyQuestionRelationshipDB) {
		this.surveyQuestionRelationshipDB = surveyQuestionRelationshipDB;
	}

	private SystemConfig() {

        passwordEncryption = new BCryptPasswordEncryption();
        userDB = new UserDB();
        databaseConfiguration = new DefaultDatabaseConfiguration();
        courseDB = new CourseDB();
        courseUserRelationshipDB = new CourseUserRelationshipDB();
        setQuestionPersistance(new QuestionDB());
        passwordEnforcementPolicyDB = new PasswordEnforcementPolicyDB();
        userHistoryRelationshipDB = new UserHistoryRelationshipDB();
        surveyQuestionRelationshipDB = new SurveyQuestionRelationshipDB();
        surveyDB = new SurveyDB();

    }

    public static SystemConfig instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new SystemConfig();
        }
        return uniqueInstance;
    }

    public IUserHistroyRelationshipPersistence getUserHistoryRelationshipDB() {
        return userHistoryRelationshipDB;
    }

    public void setUserHistoryRelationshipDB(IUserHistroyRelationshipPersistence userHistoryRelationshipDB) {
        this.userHistoryRelationshipDB = userHistoryRelationshipDB;
    }

    public PasswordEnforcementPolicy getPasswordEnforcementPolicy() {
        return PasswordEnforcementPolicy.getInstance(passwordEnforcementPolicyDB);

    }

    public IPasswordEncryption getPasswordEncryption() {
        return passwordEncryption;
    }

    public void setPasswordEncryption(IPasswordEncryption passwordEncryption) {
        this.passwordEncryption = passwordEncryption;
    }

    public IUserPersistence getUserDB() {
        return userDB;
    }

    public void setUserDB(IUserPersistence userDB) {
        this.userDB = userDB;
    }

    public IDatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    public void setCourseDB(ICoursePersistence courseDB) {
        this.courseDB = courseDB;
    }

    public ICoursePersistence getCourseDB() {
        return courseDB;
    }

    public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
        this.courseUserRelationshipDB = courseUserRelationshipDB;
    }

    public ICourseUserRelationshipPersistence getCourseUserRelationshipDB() {
        return courseUserRelationshipDB;
    }

    public IQuestionPersistance getQuestionPersistance() {
        return questionPersistance;
    }

    public void setQuestionPersistance(IQuestionPersistance questionPersistance) {
        this.questionPersistance = questionPersistance;
    }

    public IPasswordEnforcementPolicyPersistence getPasswordEnforcementPolicyDB(
            IPasswordEnforcementPolicyPersistence passwordEnforcementPolicyDB) {
        return passwordEnforcementPolicyDB;
    }

    public void setPasswordEnforcementPolicyDB(IPasswordEnforcementPolicyPersistence passwordEnforcementPolicyDB) {
        this.passwordEnforcementPolicyDB = passwordEnforcementPolicyDB;
    }

	public ISurveyPersistence getSurveyPersistance() {
		return surveyDB;
	}
}
