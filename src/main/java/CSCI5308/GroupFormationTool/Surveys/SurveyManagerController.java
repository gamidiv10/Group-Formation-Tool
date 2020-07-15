package CSCI5308.GroupFormationTool.Surveys;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Question.IQuestionPersistance;
import CSCI5308.GroupFormationTool.Question.Questions;

@Controller
public class SurveyManagerController {
	
	@GetMapping("/course/surveymanager")
	public String surveyManager(Model model, @RequestParam(name = "id") long courseID) {
        User u = CurrentUser.instance().getCurrentAuthenticatedUser();
        Survey survey = new Survey();
        ISurveyPersistence surveyDB = SystemConfig.instance().getSurveyPersistance();
        int surveyStatus = survey.getSurveyStatus(surveyDB, courseID);
        model.addAttribute("surveyStatus",surveyStatus);
        List<Questions> listOfQuestions = survey.getQuestionsForSurvey(surveyDB, u.getID());
        survey.setSurveyId(survey.getSurveyIdByCourseId(surveyDB, courseID));
        List<Questions> surveyQuestions = survey.getAllSurveyQuestions(surveyDB, survey.getSurveyId());
        model.addAttribute("displayQuestions", listOfQuestions);
        model.addAttribute("courseID",courseID);
        model.addAttribute("surveyQuestions",surveyQuestions);
        model.addAttribute("surveyId",survey.getSurveyId());
        return "course/surveymanager";
	}
	
	@PostMapping("/addQuestion/{questionId}")
    public ModelAndView addQuestions(ModelAndView mav, 
    		@PathVariable("questionId") Integer questionId,
    		@RequestParam(name = "questionTitle") String questionTitle,
    		@RequestParam(name = "questionText") String questionText,
    		@RequestParam(name = "courseID") long courseID) {
        IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		ISurveyPersistence surveyDB = SystemConfig.instance().getSurveyPersistance();
        Questions question = new Questions();
        question.setQuestionId(questionId);
        question.loadQuestion(questionDB);
        question.setQuestionText(questionText);
        question.setTitle(questionTitle);
        User u = CurrentUser.instance().getCurrentAuthenticatedUser();
        Survey survey = new Survey();
        survey.setSurvey_name("surveyforcourse"+courseID);
        survey.setPublised(0);
        survey.setCreatedById(u.getId());
        survey.setCourseid(courseID);
        long surveyId = survey.createSurvey(surveyDB, survey);
        survey.setSurveyId(surveyId);
        survey.addQuestionsToSurvey(surveyDB, surveyId, questionId, questionText);
        mav.addObject("id", courseID);
        mav.addObject(question);
        mav.setViewName("redirect:/course/surveymanager");
        return mav;
    }
	
	@PostMapping("/deleteQuestion")
	public ModelAndView deleteQuestions(ModelAndView mav,
			@RequestParam(name = "surveyId") long surveyID,
			@RequestParam(name = "questionId") int questionID) {
		ISurveyPersistence surveyDB = SystemConfig.instance().getSurveyPersistance();
		Survey survey = new Survey();
		survey.deleteQuestionFromSurvey(surveyDB,questionID,surveyID);
		mav.addObject("id", surveyID);
        mav.addObject(questionID);
		mav.setViewName("redirect:/course/surveymanager");
		return mav;
		
	}
	
}
