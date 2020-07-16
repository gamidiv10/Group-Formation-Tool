package CSCI5308.GroupFormationTool.Question;

import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;
import CSCI5308.GroupFormationTool.AccessControl.User;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveQuestion implements ISaveQuestion {
    private Logger log = Logger.getLogger(SaveQuestion.class.getName());
    IQuestionDB questionDB;

    public SaveQuestion(IQuestionDB questionDB) {
        this.questionDB = questionDB;
    }

    @Override
    public int saveQuestionModel(Question question) {
        int typeId;
        switch (question.getQuestionType()) {
            case "Numeric":
                typeId = 1;
                break;
            case "Multiple choice - choose one":
                typeId = 2;
                break;
            case "Multiple choice - choose multiple":
                typeId = 3;
                break;
            case "Free Text":
                typeId = 4;
                break;
            default:
                typeId = -1;
        }
        User user = CurrentUser.instance().getCurrentAuthenticatedUser();
        return questionDB.saveQuestion(question, user.getBannerID(), typeId);
    }

    @Override
    public boolean saveMcqOptions(List<Option> optionList, int questionId) {
        try {
            for (Option option : optionList) {
                questionDB.saveMcq(option, questionId);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Encountered Exception while saving options for question " + questionId);
            return false;
        }
        log.log(Level.INFO, "Options are saved for Question " + questionId);
        return true;
    }
}
