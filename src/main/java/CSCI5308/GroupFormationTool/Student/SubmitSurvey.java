package CSCI5308.GroupFormationTool.Student;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubmitSurvey implements ISubmitSurvey{
    ISubmitSurveyDB submitSurveyDB;
    public SubmitSurvey(ISubmitSurveyDB submitSurveyDB){
        this.submitSurveyDB = submitSurveyDB;
    }
    @Override
    public void submitSurvey(HttpServletRequest httpServletRequest, HashMap<Questions, List<Option>> questions, long courseID) {
        Answer answer = Answer.getInstance();
//        User user = CurrentUser.instance().getCurrentAuthenticatedUser();
        for(Questions key: questions.keySet()){
            int questionType = key.getQuestionType();
            int questionID = key.getQuestionId();
            if (questions.get(key) == null){
                String parameter = "result"+questionID;
                if(questionType == 1){
                    answer.addNumericAnswer(questionID, httpServletRequest.getParameter(parameter));
                    System.out.println(httpServletRequest.getParameter(parameter));
                }
                else{
                    answer.addFreeTextAnswer(questionID, httpServletRequest.getParameter(parameter));
                    System.out.println(httpServletRequest.getParameter(parameter));
                }
                submitSurveyDB.submitSurvey(questionID, httpServletRequest.getParameter(parameter), courseID);
            } else {
                if(questionType == 2){
                    answer.addMcOneAnswer(questionID, httpServletRequest.getParameter("mcqOne"));
                    System.out.println(httpServletRequest.getParameter("mcqOne"));
                    submitSurveyDB.submitSurvey(questionID, httpServletRequest.getParameter("mcqOne"), courseID);
                } else {
                    List<String> mcqAnswers = new ArrayList<>();
                    for(Option option: questions.get(key)){
                        String parameter = "result"+questionID+"option"+option.getStoredAs();
                        mcqAnswers.add(httpServletRequest.getParameter(parameter));
                        System.out.println(httpServletRequest.getParameter(parameter));
                        if(httpServletRequest.getParameter(parameter) != null) {
                            submitSurveyDB.submitSurvey(questionID, httpServletRequest.getParameter(parameter), courseID);
                        }
                    }
                    answer.addMcMultipleAnswer(questionID, mcqAnswers);
                }
            }
        }
    }
}
