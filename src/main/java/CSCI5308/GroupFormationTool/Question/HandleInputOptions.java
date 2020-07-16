package CSCI5308.GroupFormationTool.Question;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
public class HandleInputOptions implements IHandleInputOptions {

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
        return options;
    }
}
