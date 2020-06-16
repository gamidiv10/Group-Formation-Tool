package CSCI5308.GroupFormationTool.Courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class CreateQuestionController {
    public String qTitle;
    public String qText;
    public String qType;
    @GetMapping("/createquestion")
    public ModelAndView createQuestion(Model model)
    {
        ModelAndView modelAndView = new ModelAndView("course/createquestion");
        modelAndView.addObject("isInitialPage", true);
        modelAndView.addObject("isNext", true);
        return modelAndView;
    }

    @RequestMapping(value = "/createquestion", method = RequestMethod.POST)
    public ModelAndView createQuestion(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "question") String question,
            @RequestParam(name = "type") String type)
    {
        boolean isNumeric = false;
        boolean isMultipleOne = false;
        boolean isMultipleMany = false;
        boolean isFreeText = false;
        boolean isInitialPage = true;
        boolean isSaveScreen = true;
        boolean isNext = false;
        qText = question;
        qTitle = title;
        qType = type;
        System.out.println(title + question + type);
        if(type.equals("Numeric")){
            isNumeric = true;
            isInitialPage = false;
        }
        if(type.equals("Multiple choice - choose one")){
            isMultipleOne = true;
            isInitialPage = false;
        }
        if(type.equals("Multiple choice - choose multiple")){
            isMultipleMany = true;
            isInitialPage = false;
        }
        if(type.equals("Free Text")){
            isFreeText = true;
            isInitialPage = false;
        }
        ModelAndView m = new ModelAndView("course/createquestion");
        m.addObject("isNumeric", isNumeric);
        m.addObject("isMultipleOne", isMultipleOne);
        m.addObject("isMultipleMany", isMultipleMany);
        m.addObject("isFreeText", isFreeText);
        m.addObject("isInitialPage", isInitialPage);
        m.addObject("save", isSaveScreen);
        m.addObject("isNext", isNext);
        m.addObject("question", question);
        ArrayList<String> answers = new ArrayList<>();
        answers.add("option1");
        answers.add("option2");
        answers.add("option3");
        m.addObject("answers", answers);

        return m;

    }

    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public ModelAndView saveQuestion()
    {
        System.out.println("Save Screen" + qType + qTitle + qText);
        ModelAndView m = new ModelAndView("course/createquestion");
        return m;

    }

}
