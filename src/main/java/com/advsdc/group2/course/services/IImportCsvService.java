package com.advsdc.group2.course.services;

import com.advsdc.group2.signup.models.User;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public interface IImportCsvService {

    public ArrayList<List<String>> readFromCsv(InputStreamReader inputStreamReader);
    public void createUsersFromList(ArrayList<User> userArrayList);
    public void sendEmail(User user);

    }
