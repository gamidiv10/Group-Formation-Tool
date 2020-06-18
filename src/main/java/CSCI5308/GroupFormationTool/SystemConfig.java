package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.Security.*;
import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.Database.*;
import CSCI5308.GroupFormationTool.Question.IQuestionPersistance;
import CSCI5308.GroupFormationTool.Question.QuestionDB;
import CSCI5308.GroupFormationTool.Courses.*;

/*
 * This is a singleton, we will learn about these when we learn design patterns.
 * 
 * The single responsibility of this singleton is to store concrete classes
 * selected by the system for use in the rest of the system. This will allow
 * a form of dependency injection in places where we cannot use normal
 * dependency injection (for example classes that override or extend existing
 * library classes in the framework).
 */
public class SystemConfig {

	private static SystemConfig uniqueInstance = null;

	private IPasswordEncryption passwordEncryption;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IQuestionPersistance questionPersistance;
	
	private IPasswordEnforcementPolicyPersistence passwordEnforcementPolicyDB;
	private IUserHistroyRelationshipPersistence userHistoryRelationshipDB;

	// This private constructor ensures that no class other than System can allocate
	// the System object. The compiler would prevent it.
	private SystemConfig() {
		// The default instantiations are the choices that would be used in the
		// production application. These choices can all be overridden by test
		// setup logic when necessary.
		passwordEncryption = new BCryptPasswordEncryption();
		userDB = new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		setQuestionPersistance(new QuestionDB());
		passwordEnforcementPolicyDB = new PasswordEnforcementPolicyDB();
		userHistoryRelationshipDB = new UserHistoryRelationshipDB();

	}

	// This is the way the rest of the application gets access to the System object.
	public static SystemConfig instance() {
		// Using lazy initialization, this is the one and only place that the System
		// object will be instantiated.
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
}
