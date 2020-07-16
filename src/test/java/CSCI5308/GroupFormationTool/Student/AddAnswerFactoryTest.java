package CSCI5308.GroupFormationTool.Student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AddAnswerFactoryTest {

    @Test
    public void getObject(){
        AddAnswerFactory addAnswerFactory = new AddAnswerFactory();
        IResponseHandler numericResponse = new NumericResponse();
        assertEquals(numericResponse.getClass().getSimpleName(), addAnswerFactory.getObject(1).getClass().getSimpleName());
        IResponseHandler mcqOneResponse = new McqOneResponse();
        assertEquals(mcqOneResponse.getClass().getSimpleName(), addAnswerFactory.getObject(2).getClass().getSimpleName());
        IResponseHandler freeTextResponse = new FreeTextResponse();
        assertEquals(freeTextResponse.getClass().getSimpleName(), addAnswerFactory.getObject(4).getClass().getSimpleName());
        assertNull(addAnswerFactory.getObject(0));
    }
}
