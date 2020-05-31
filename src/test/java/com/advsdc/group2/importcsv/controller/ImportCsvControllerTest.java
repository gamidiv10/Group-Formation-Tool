package com.advsdc.group2.importcsv.controller;

import com.advsdc.group2.course.controller.ImportCsvController;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImportCsvControllerTest {
    @Test
    public void fileUploadTest(){
        ImportCsvController importCsvController = new ImportCsvController();
        assertNotNull(importCsvController.fileUpload());
    }
    @Test
    public void readFileTest(){
        ImportCsvController importCsvController = new ImportCsvController();
        RedirectAttributes redirectAttributes = new RedirectAttributes() {
            @Override
            public RedirectAttributes addAttribute(String attributeName, Object attributeValue) {
                return null;
            }

            @Override
            public RedirectAttributes addAttribute(Object attributeValue) {
                return null;
            }

            @Override
            public RedirectAttributes addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public RedirectAttributes mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public RedirectAttributes addFlashAttribute(String attributeName, Object attributeValue) {
                return null;
            }

            @Override
            public RedirectAttributes addFlashAttribute(Object attributeValue) {
                return null;
            }

            @Override
            public Map<String, ?> getFlashAttributes() {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Object getAttribute(String attributeName) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        try {
            assertDoesNotThrow(() -> new MockMultipartFile("sample.csv", new FileInputStream(new File("./src/main/resources/csvfile/sample.csv"))));
            MultipartFile multipartFile = new MockMultipartFile("sample.csv", new FileInputStream(new File("./src/main/resources/csvfile/sample.csv")));
            assertNotNull(importCsvController.receiveFile(multipartFile, redirectAttributes));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

}
