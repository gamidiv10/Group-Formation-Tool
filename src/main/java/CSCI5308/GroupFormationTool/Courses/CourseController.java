package CSCI5308.GroupFormationTool.Courses;

import java.util.HashMap;
import java.util.List;
import CSCI5308.GroupFormationTool.Student.Answer;
import CSCI5308.GroupFormationTool.Question.Option;
import CSCI5308.GroupFormationTool.Question.Questions;
import CSCI5308.GroupFormationTool.Student.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CourseController {
    private static final String ID = "id";
    private long courseID;
    @GetMapping("/course/course")
    public String course(Model model, @RequestParam(name = ID) long courseID) {
        this.courseID = courseID;
        ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
        Course course = new Course();
        courseDB.loadCourseByID(courseID, course);
        model.addAttribute("course", course);
        List<Role> userRoles = course.getAllRolesForCurrentUserInCourse();
        if (null == userRoles) {
            model.addAttribute("instructor", false);
            model.addAttribute("ta", false);
            model.addAttribute("student", false);
            model.addAttribute("guest", true);
        } else {
            model.addAttribute("instructor", userRoles.contains(Role.INSTRUCTOR));
            model.addAttribute("ta", userRoles.contains(Role.TA));
            model.addAttribute("student", userRoles.contains(Role.STUDENT));
            model.addAttribute("guest", userRoles.isEmpty());
        }
        Answer answer = Answer.getInstance();
        HashMap<Questions, List<Option>> questionsList;
        IStudentSurveyDB studentSurveyDB = new StudentSurveyDB();
        StudentSurveyHandler studentSurveyHandler = new StudentSurveyHandler(studentSurveyDB);
        questionsList = studentSurveyHandler.retrieveQuestions(courseID);
        if(questionsList.size() == 0){
            model.addAttribute("notPublished", true);
            return "course/course";
        }
        answer.setQuestions(questionsList);
        model.addAttribute("answer", answer);
        model.addAttribute("questionList", questionsList);
        return "course/course";
    }
    @PostMapping("/submitsurvey")
    public ModelAndView submitSurvey(HttpServletRequest request) {
        boolean success;
        ISubmitSurveyDB submitSurveyDB = new SubmitSurveyDB();
        Answer answer = Answer.getInstance();
        ISubmitSurvey submitSurveyHandler = new SubmitSurvey(submitSurveyDB);
        success = submitSurveyHandler.submitSurvey(request, answer.getQuestions(), this.courseID);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        if(success == false){
            modelAndView.addObject("hasAnError", true);
        }
        return modelAndView;
    }
}
