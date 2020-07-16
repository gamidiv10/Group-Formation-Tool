package CSCI5308.GroupFormationTool.Student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class FreeTextResponseTest {
    @Test
    public void addAnswer() {
        FreeTextResponse freeTextResponse = new FreeTextResponse();
        assertDoesNotThrow(() -> freeTextResponse.addAnswer(1, "Test"));
    }
}
