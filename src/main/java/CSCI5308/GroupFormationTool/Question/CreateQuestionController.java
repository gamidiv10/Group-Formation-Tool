package CSCI5308.GroupFormationTool.Question;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateQuestionController {

    @GetMapping("/createquestion")
    public ModelAndView createQuestion() {
        List<Option> options = new ArrayList<>();
        options.add(new Option("", 1));
        ModelAndView modelAndView = new ModelAndView("course/createquestion");
        modelAndView.addObject("isInitialPage", true);
        modelAndView.addObject("save", false);
        return modelAndView;
    }

    @RequestMapping(value = "/createquestion", method = RequestMethod.POST)
    public ModelAndView createQuestion(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "question") String questionText,
            @RequestParam(name = "type") String type) {
        Question question = Question.getInstance();
        IQuestionDataHandler questionDataHandler = new QuestionDataHandler(question);
        questionDataHandler.setQuestionData(title, type, questionText);
        boolean isNumeric = false;
        boolean isMultipleOne = false;
        boolean isFreeText = false;
        boolean isInitialPage = true;
        boolean isNext = false;
        System.out.println(title + questionText + type);
        if (type.equals("Numeric")) {
            isNumeric = true;
            isInitialPage = false;
        }
        if (type.equals("Multiple choice - choose one") || type.equals("Multiple choice - choose multiple")) {
            isMultipleOne = true;
            isInitialPage = false;
        }
        if (type.equals("Free Text")) {
            isFreeText = true;
            isInitialPage = false;
        }
        ModelAndView m = new ModelAndView("course/createquestion");
        m.addObject("isNumeric", isNumeric);
        m.addObject("isMultipleOne", isMultipleOne);
        m.addObject("isFreeText", isFreeText);
        m.addObject("isInitialPage", isInitialPage);
        m.addObject("isNext", isNext);
        m.addObject("question", questionText);
        m.addObject("save", true);
        return m;
    }

    @RequestMapping(value = "/createquestion", method = RequestMethod.POST, params = "action=save")
    public String saveQuestion(HttpServletRequest request, Model model) {
        IHandleInputOptions handleInputOptions = new HandleInputOptions();
        List<Option> optionList = handleInputOptions.handleOptions(request);
        IQuestionDB questionDB = new QuestionDao();
        ISaveQuestion saveQuestion = new SaveQuestion(questionDB);
        int questionId = saveQuestion.saveQuestionModel(Question.getInstance());
        if (optionList.size() > 0) {
            saveQuestion.saveMcqOptions(optionList, questionId);
        }
        User u = CurrentUser.instance().getCurrentAuthenticatedUser();
        Questions questions = new Questions();
        IQuestionPersistance questionPersistance = SystemConfig.instance().getQuestionPersistance();
        List<Questions> listOfQuestions = questions.getAllQuestionTitlesByInstructorID(questionPersistance, u.getID());
        model.addAttribute("displayQuestions", listOfQuestions);
        return "course/questionmanager";
    }

    @RequestMapping(value = "/createquestion", method = RequestMethod.POST, params = "action=cancel")
    public String saveQuestion(Model model) {
        Question question = Question.getInstance();
        question.reset();
        User u = CurrentUser.instance().getCurrentAuthenticatedUser();
        Questions questions = new Questions();
        IQuestionPersistance questionPersistance = SystemConfig.instance().getQuestionPersistance();
        List<Questions> listOfQuestions = questions.getAllQuestionTitlesByInstructorID(questionPersistance, u.getID());
        model.addAttribute("displayQuestions", listOfQuestions);
        return "course/questionmanager";
    }
}
