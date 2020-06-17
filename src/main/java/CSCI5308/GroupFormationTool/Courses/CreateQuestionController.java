package CSCI5308.GroupFormationTool.Courses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateQuestionController {
    public String qTitle;
    public String qText;
    public String qType;

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
            @RequestParam(name = "question") String question,
            @RequestParam(name = "type") String type)
    {
        qText = question;
        qTitle = title;
        qType = type;
        boolean isNumeric = false;
        boolean isMultipleOne = false;
        boolean isFreeText = false;
        boolean isInitialPage = true;
        boolean isNext = false;
        System.out.println(title + question + type);
        if(type.equals("Numeric")){
            isNumeric = true;
            isInitialPage = false;
        }
        if(type.equals("Multiple choice - choose one")){
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
        m.addObject("question", question);
        m.addObject("save", true);
        return m;
    }

    @RequestMapping(value = "/createquestion", method = RequestMethod.POST, params = "action=save")
    public ModelAndView saveQuestion(HttpServletRequest request)
    {
        List<Option> options = new ArrayList<>();
        String displayText, storedAs;
        int i = 1;
        while(true){
            displayText = request.getParameter("displayText-" + i + "");
            storedAs = request.getParameter("storedAs-" + i + "");
            System.out.println(displayText + " " + storedAs);
            if ((displayText == null) || (storedAs == null)) {
                break;
            }
            if(displayText.length() > 0){
                Option option = new Option(displayText, Integer.parseInt(storedAs));
                options.add(option);
            }
            i++;
        }
        if(options.size() > 0){

        }
        else{

        }
        ModelAndView m = new ModelAndView("course/createquestion");
        return m;
    }

}
