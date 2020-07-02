package CSCI5308.GroupFormationTool.Question;

import java.util.List;

public interface IQuestionPersistance {

    public List<Questions> loadAllQuestionTitlesByInstructorID(long instructorID);

    public void loadQuestionById(Integer questionId, Questions question);

    public boolean deleteQuestion(Integer questionId);
}
