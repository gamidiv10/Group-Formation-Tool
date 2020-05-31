package com.advsdc.group2.importcsv.services;

import com.advsdc.group2.course.services.ImportCsvServiceImpl;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
            assertNotNull(importCsvService.readFromCsv(inputStreamReader));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
