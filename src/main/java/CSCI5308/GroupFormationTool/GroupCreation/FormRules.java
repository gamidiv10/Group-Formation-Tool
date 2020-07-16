package CSCI5308.GroupFormationTool.GroupCreation;

import java.util.List;

import CSCI5308.GroupFormationTool.Question.Questions;

public class FormRules {
	
	List<Questions> allSurveyQuestions;
	private int groupSizeCount;

	public List<Questions> getAllSurveyQuestions() {
		return allSurveyQuestions;
	}

	public void setAllSurveyQuestions(List<Questions> allSurveyQuestions) {
		this.allSurveyQuestions = allSurveyQuestions;
	}

	public int getGroupSizeCount() {
		return groupSizeCount;
	}

	public void setGroupSizeCount(int groupSizeCount) {
		this.groupSizeCount = groupSizeCount;
	}

}
