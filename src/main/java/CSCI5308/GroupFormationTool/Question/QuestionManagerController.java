package CSCI5308.GroupFormationTool.Question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionManagerController {

	@GetMapping("/course/questionmanager")
	public String questionManager(Model model)
	{
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		User u = CurrentUser.instance().getCurrentAuthenticatedUser();
		Questions questions = new Questions();
		IQuestionPersistance questionPersistance = SystemConfig.instance().getQuestionPersistance();
		List<Questions> listOfQuestions = questions.getAllQuestionTitlesByInstructorID(questionPersistance, u.getID());
		model.addAttribute("displayQuestions",listOfQuestions);
		return "course/questionmanager";
	}

	@GetMapping("/course/sortbytitle")
	public String sortByTitle(Model model)
	{
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		User u = CurrentUser.instance().getCurrentAuthenticatedUser();
		Questions questions = new Questions();
		List<Questions> listOfQuestions = questions.sortByTile(questionDB, u);
		model.addAttribute("displayQuestions",listOfQuestions);
		return "course/questionmanager";
	}

	@GetMapping("/course/sortbydate")
	public String sortByDate(Model model)
	{
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		User u = CurrentUser.instance().getCurrentAuthenticatedUser();
		Questions questions = new Questions();
		List<Questions> listOfQuestions = questions.sortByDate(questionDB, u);
		model.addAttribute("displayQuestions",listOfQuestions);

		return "course/questionmanager";
	}

	@PostMapping("/deleteConfirmation/{questionId}")
	public String deleteConfirmation(Model model, @PathVariable("questionId") Integer questionId) {
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		Questions question = new Questions();
		question.setQuestionId(questionId);
		question.loadQuestion(questionDB);
		model.addAttribute("Question", question);
		return "course/delete_question";
	}

	@PostMapping("/deleteQuestion/{questionId}")
	public ModelAndView deleteQuestions(Model model, @PathVariable("questionId") Integer questionId) {
		IQuestionPersistance questionDB = SystemConfig.instance().getQuestionPersistance();
		Questions question = new Questions();
		question.setQuestionId(questionId);
		question.deleteQuestion(questionDB);
		ModelAndView mav = new ModelAndView("redirect:/course/questionmanager");
		return mav;
	}

}
