package CSCI5308.GroupFormationTool.Question;

public enum QuestionType {
    NUMERIC("Numeric"),
    MULTIPLE_CHOICE_CHOOSE_ONE("Multiple choice - choose one"),
    MULTIPLE_CHOICE_CHOOSE_MANY("Multiple choice - choose multiple"),
    FREE_TEXT("Free Text");

    private final String type;
    QuestionType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
