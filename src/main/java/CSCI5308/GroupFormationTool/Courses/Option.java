package CSCI5308.GroupFormationTool.Courses;

public class Option {
    private String displayText;
    private int storedAs;

    public Option(String displayText, int storedAs){
        this.displayText = displayText;
        this.storedAs = storedAs;
    }
    public Option(){

    }
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public void setStoredAs(int storedAs) {
        this.storedAs = storedAs;
    }


    public String getDisplayText() {
        return displayText;
    }

    public int getStoredAs() {
        return storedAs;
    }

}
