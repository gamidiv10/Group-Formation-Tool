package CSCI5308.GroupFormationTool.Question;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IHandleInputOptions {
    public List<Option> handleOptions(HttpServletRequest request);
}
