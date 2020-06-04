package com.advsdc.group2.importcsv.services;

import com.advsdc.group2.course.services.ImportCsvServiceImpl;
import com.advsdc.group2.signup.models.User;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.*;

public class ImportCsvServiceImplTest {
    @Test
    public void readFromCsvTest()
    {
        ImportCsvServiceImpl importCsvService = new ImportCsvServiceImpl();
        String csvFile = "./src/main/resources/csvfile/sample.csv";
        try {
            assertDoesNotThrow(() -> new FileInputStream(csvFile));
            FileInputStream fileInputStream = new FileInputStream(csvFile);
            assertDoesNotThrow(() -> new InputStreamReader(fileInputStream));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            assertDoesNotThrow(() -> bufferedReader.read());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void createUsersFromListTest(){
        SignupServiceMock signupServiceMock = new SignupServiceMock();
        User user = new User();
        user = signupServiceMock.createUser();
        assertEquals("vamsig10", user.getUserId());
        assertEquals("Pass@1", user.getPassword());
        assertEquals("Pass@1", user.getMatchingPassword());
        assertEquals("vamsi.gamidi01@gmail.com", user.getEmail());
        assertEquals("Gamidi", user.getLastName());
        assertEquals("Vamsi", user.getFirstName());

    }
    @Test
    public void sendEmailTest(){
        User user = new User();
        user.setEmail("vamsi.gamidi01@gmail.com");
        user.setUserId("vamsig10");
        user.setPassword("Pass@1");
        user.setMatchingPassword("Pass@1");
        user.setLastName("Gamidi");
        user.setFirstName("Vamsi");
        ImportCsvServiceImpl importCsvService = new ImportCsvServiceImpl();
        assertDoesNotThrow(() -> importCsvService.sendEmail(user));

    }
    @Test
    public void enrollInCourseTest(){
        ImportCsvDaoMock importCsvDaoMock = new ImportCsvDaoMock();
        assertDoesNotThrow(() -> importCsvDaoMock.enrollInCourse("userId", "courseId"));
    }

}
