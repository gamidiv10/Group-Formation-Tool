package com.advsdc.group2.course.services;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public interface ImportCsvService {

    public ArrayList<List<String>> readFromCsv(InputStreamReader inputStreamReader);
}
