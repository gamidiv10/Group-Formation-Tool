package com.advsdc.group2.course.services;

import com.advsdc.group2.signup.models.User;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public interface IImportCsvService {

    public ArrayList<List<String>> readFromCsv(InputStreamReader inputStreamReader, String courseId);
    public void createUsersFromList(ArrayList<User> userArrayList);
    public void sendEmail(User user);
    public void enrollInCourse(ArrayList<User> userArrayList, String courseId);

    }
