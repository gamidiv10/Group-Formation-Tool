package com.advsdc.group2.course.controller;

import com.advsdc.group2.course.services.ImportCsvServiceImpl;
import com.advsdc.group2.utility.JwtUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImportCsvController {
    @GetMapping("/importcsv")
    public String fileUpload() {
        return "importcsv";
    }

    @PostMapping("/importcsv")
    public String receiveFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/importcsv";
        }
        ImportCsvServiceImpl importCsvService = new ImportCsvServiceImpl();
        ArrayList<List<String>> arrayList = new ArrayList<>();
        try {
            arrayList = importCsvService.readFromCsv(new InputStreamReader(file.getInputStream()));
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println(e);
        }
        attributes.addFlashAttribute("message", "Students List Imported");
        return "redirect:/importcsv";
    }
}
