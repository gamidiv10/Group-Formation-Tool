package CSCI5308.GroupFormationTool.Student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NumericResponseTest {
    @Test
    public void addAnswer() {
        NumericResponse numericResponse = new NumericResponse();
        assertDoesNotThrow(() -> numericResponse.addAnswer(1, "Test"));
    }
}
