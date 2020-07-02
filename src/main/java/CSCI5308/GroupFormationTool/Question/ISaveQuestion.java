package CSCI5308.GroupFormationTool.Question;

import java.util.List;

public interface ISaveQuestion {
    public int saveQuestionModel(Question question);

    public boolean saveMcqOptions(List<Option> optionList, int questionId);
}
