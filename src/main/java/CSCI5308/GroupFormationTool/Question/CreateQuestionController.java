package CSCI5308.GroupFormationTool.Question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateQuestionController {

    @GetMapping("/createquestion")
    public ModelAndView createQuestion()
    {
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
            @RequestParam(name = "type") String type)
    {
        Question question = Question.getInstance();
        IQuestionDataHandler questionDataHandler = new QuestionDataHandler(question);
        questionDataHandler.setQuestionData(title, type, questionText);

        boolean isNumeric = false;
        boolean isMultipleOne = false;
        boolean isFreeText = false;
        boolean isInitialPage = true;
        boolean isNext = false;
        System.out.println(title + questionText + type);
        if(type.equals("Numeric")){
            isNumeric = true;
            isInitialPage = false;
        }
        if(type.equals("Multiple choice - choose one") || type.equals("Multiple choice - choose multiple")){
            isMultipleOne = true;
            isInitialPage = false;
        }
        if(type.equals("Free Text")){
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
    public ModelAndView saveQuestion(HttpServletRequest request)
    {
        IHandleInputOptions handleInputOptions = new HandleInputOptions();
        List<Option> optionList = handleInputOptions.handleOptions(request);
        IQuestionDB questionDB = new QuestionDB();
        ISaveQuestion saveQuestion = new SaveQuestion(questionDB);
        int questionId = saveQuestion.saveQuestionModel(Question.getInstance());
        if(optionList.size() > 0){
            saveQuestion.saveMcqOptions(optionList, questionId);
        }
        return new ModelAndView("course/createquestion");
    }
    @RequestMapping(value = "/createquestion", method = RequestMethod.POST, params = "action=cancel")
    public ModelAndView saveQuestion() {
        Question question = Question.getInstance();
        question.reset();
        ModelAndView modelAndView = new ModelAndView("/course/createquestion");
        modelAndView.addObject("isInitialPage", true);
        modelAndView.addObject("save", false);
        return modelAndView;

    }

}
