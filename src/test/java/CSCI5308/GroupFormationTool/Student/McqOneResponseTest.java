package CSCI5308.GroupFormationTool.Student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class McqOneResponseTest {
    @Test
    public void getObjectTest() {
        McqOneResponse mcqOneResponse = new McqOneResponse();
        assertDoesNotThrow(() -> mcqOneResponse.addAnswer(1, "Test"));
    }
}
