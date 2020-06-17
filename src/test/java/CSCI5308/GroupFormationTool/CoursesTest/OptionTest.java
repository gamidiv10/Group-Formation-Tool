package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionTest {
    public String displayText = "display text";
    public int storedAs = 1;
    @Test
    public void getDisplayText(){
        Option option = new Option(displayText, 1);
        assertEquals(displayText, option.getDisplayText());
    }
    @Test
    public void setDisplayText(){
        Option option = new Option();
        option.setDisplayText(displayText);
        assertEquals(displayText, option.getDisplayText());
    }
    @Test
    public void getStoredAs(){
        Option option = new Option("display text", 1);
        assertEquals(storedAs, option.getStoredAs());
    }
    @Test
    public void setStoredAs(){
        Option option = new Option();
        option.setStoredAs(storedAs);
        assertEquals(storedAs, option.getStoredAs());
    }

}
