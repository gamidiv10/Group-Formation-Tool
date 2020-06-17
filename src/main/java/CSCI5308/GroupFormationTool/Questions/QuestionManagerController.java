package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;

@Controller
public class QuestionManagerController {
	
	@GetMapping("/course/questionmanager")
	public String questionManager(Model model)
	{
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		User u = CurrentUser.instance().getCurrentAuthenticatedUser();
		List<Questions> listOfQuestions = questionDB.loadAllQuestionTitlesByInstructorID(u.getID());
		model.addAttribute("displayQuestions",listOfQuestions);
		return "/course/questionmanager";
	}
	
	@GetMapping("/course/sortbytitle")
	public String sortByTitle(Model model)
	{
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		User u = CurrentUser.instance().getCurrentAuthenticatedUser();
		Questions questions = new Questions(); 
		List<Questions> listOfQuestions = questions.sortByTile(questionDB, u);
		model.addAttribute("displayQuestions",listOfQuestions);
		return "/course/questionmanager";
	}
	
	@GetMapping("/course/sortbydate")
	public String sortByDate(Model model)
	{
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		User u = CurrentUser.instance().getCurrentAuthenticatedUser();
		Questions questions = new Questions(); 
		List<Questions> listOfQuestions = questions.sortByDate(questionDB, u);
		model.addAttribute("displayQuestions",listOfQuestions);
		return "/course/questionmanager";
	}

}
