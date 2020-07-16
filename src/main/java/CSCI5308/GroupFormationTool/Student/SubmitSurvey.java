package CSCI5308.GroupFormationTool.Student;

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
    public boolean submitSurvey(HttpServletRequest httpServletRequest, HashMap<Questions, List<Option>> questions, long courseID) {
        boolean success = true;
        Answer answer = Answer.getInstance();
        for(Questions key: questions.keySet()){
            int questionType = key.getQuestionType();
            AddAnswerFactory addAnswerFactory = new AddAnswerFactory();
            IResponseHandler responseHandler = addAnswerFactory.getObject(questionType);
            int questionID = key.getQuestionId();
            if (questions.get(key) == null){
                String parameter = "result"+questionID;
                responseHandler.addAnswer(questionID, httpServletRequest.getParameter(parameter));
                System.out.println(httpServletRequest.getParameter(parameter));
                success = submitSurveyDB.submitSurvey(questionID, httpServletRequest.getParameter(parameter), courseID);
                if(success == false){
                    return false;
                }
            } else {
                if(questionType == 2){
                    responseHandler.addAnswer(questionID, httpServletRequest.getParameter("mcqOne"));
                    System.out.println(httpServletRequest.getParameter("mcqOne"));
                    success = submitSurveyDB.submitSurvey(questionID, httpServletRequest.getParameter("mcqOne"), courseID);
                    if(success == false){
                        return false;
                    }
                } else {
                    List<String> mcqAnswers = new ArrayList<>();
                    for(Option option: questions.get(key)){
                        String parameter = "result"+questionID+"option"+option.getStoredAs();
                        mcqAnswers.add(httpServletRequest.getParameter(parameter));
                        System.out.println(httpServletRequest.getParameter(parameter));
                        if(httpServletRequest.getParameter(parameter) != null) {
                            submitSurveyDB.submitSurvey(questionID, httpServletRequest.getParameter(parameter), courseID);
                            if(success == false){
                                return false;
                            }
                        }
                    }
                    answer.addMcMultipleAnswer(questionID, mcqAnswers);
                }
            }
        }
        return true;
    }
}
