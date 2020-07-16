package CSCI5308.GroupFormationTool.Question;
import CSCI5308.GroupFormationTool.Student.StudentSurveyHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleInputOptions implements IHandleInputOptions {
    private Logger log = Logger.getLogger(HandleInputOptions.class.getName());
    @Override
    public List<Option> handleOptions(HttpServletRequest request) {
        List<Option> options = new ArrayList<>();
        String displayText, storedAs;
        int i = 1;
        while (true) {
            displayText = request.getParameter("displayText-" + i + "");
            storedAs = request.getParameter("storedAs-" + i + "");
            System.out.println(displayText + " " + storedAs);
            if ((displayText == null) || (storedAs == null)) {
                break;
            }
            if (displayText.length() > 0) {
                Option option = new Option(displayText, Integer.parseInt(storedAs));
                options.add(option);
            }
            i++;
        }
        log.log(Level.INFO, "Returning the options to the view");
        return options;
    }
}
