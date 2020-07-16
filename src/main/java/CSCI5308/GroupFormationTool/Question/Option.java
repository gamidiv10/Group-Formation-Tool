package CSCI5308.GroupFormationTool.Question;

public class Option {
    private String displayText;
    private int storedAs;

    public int getOptionID() {
        return optionID;
    }

    public void setOptionID(int optionID) {
        this.optionID = optionID;
    }

    private int optionID;

    public Option(String displayText, int storedAs) {
        this.displayText = displayText;
        this.storedAs = storedAs;
    }

    public Option() {
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
