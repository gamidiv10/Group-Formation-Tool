package CSCI5308.GroupFormationTool.Surveys;

public class Survey {
	private long surveyId;
	
	private String survey_name;
	private long courseid;
	private long createdById;
	private boolean publised;
	
	public long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurvey_name() {
		return survey_name;
	}
	public void setSurvey_name(String survey_name) {
		this.survey_name = survey_name;
	}
	public long getCourseid() {
		return courseid;
	}
	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	public long getCreatedById() {
		return createdById;
	}
	public void setCreatedById(long createdById) {
		this.createdById = createdById;
	}
	public boolean isPublised() {
		return publised;
	}
	public void setPublised(boolean publised) {
		this.publised = publised;
	}

	

}
