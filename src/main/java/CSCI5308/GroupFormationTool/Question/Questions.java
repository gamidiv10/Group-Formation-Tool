package CSCI5308.GroupFormationTool.Question;
import java.util.Collections;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import CSCI5308.GroupFormationTool.AccessControl.User;

public class Questions {

	private Integer questionId;
	private String title;
	private String questionText;
	private Date dateCreated;
	private int typeID;
    private int questionType;
	// For Thymeleaf Binding
	private String rule;
	private int numericValue;
	public Questions() {
		setDefaults();
	}

	public Questions(Integer questionId, String title, String questionText, Date dateCreated) {
		this.questionId = questionId;
		this.title = title;
		this.questionText = questionText;
		this.dateCreated = dateCreated;
	}

	public void setDefaults() {
		this.questionId = -1;
		this.title = "";
		this.questionText = "";
		setDateCreated(null);

	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionId() {
        return questionId;
    }
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<Questions> getAllQuestionTitlesByInstructorID(IQuestionPersistance questionDB, long instructorID) {
		return questionDB.loadAllQuestionTitlesByInstructorID(instructorID);
	}

	public boolean deleteQuestion(IQuestionPersistance questionDB) {
		return questionDB.deleteQuestion(this.questionId);
	}

	public void loadQuestion(IQuestionPersistance questionDB) {
		questionDB.loadQuestionById(this.questionId, this);
	}

	public List<Questions> sortByTile(IQuestionPersistance questionDB, User u) {
		List<Questions> questions = questionDB.loadAllQuestionTitlesByInstructorID(u.getID());
		Collections.sort(questions, Comparator.comparing(Questions::getTitle));
		return questions;
	}

	public List<Questions> sortByDate(IQuestionPersistance questionDB, User u) {
		List<Questions> questions = questionDB.loadAllQuestionTitlesByInstructorID(u.getID());
		Collections.sort(questions, Comparator.comparing(Questions::getDateCreated));
		return questions;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public int getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(int numericValue) {
		this.numericValue = numericValue;
	}
}
