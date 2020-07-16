package CSCI5308.GroupFormationTool.GroupCreation;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Question.Questions;
import CSCI5308.GroupFormationTool.Surveys.ISurveyQuestionRelationshipPersistence;
import CSCI5308.GroupFormationTool.Surveys.Survey;

@Controller
public class GroupCreationController {
	
	@GetMapping("/survey/groupformation")
	public String createGroup() {
		Survey survey = new Survey();
		ISurveyQuestionRelationshipPersistence surveyQuestionDB = SystemConfig.instance().getSurveyQuestionRelationshipDB();
		
		List<Questions> questionList = surveyQuestionDB.loadQuestionByID(1);
		System.out.println("list Size "+questionList.size());
		
		for(Questions qlist :questionList ) {
			System.out.println("Question elements "+qlist.getQuestionText());
		}
		return "group_formation";
	}
	
	
	
	


}
