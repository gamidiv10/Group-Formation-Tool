package com.advsdc.group2.course.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportCsvServiceImpl implements ImportCsvService{

    @Override
    public ArrayList<List<String>> readFromCsv(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<List<String>> arrayList = new ArrayList<>();
        String row;
        try {
            while ((row = bufferedReader.readLine()) != null) {
                arrayList.add(Arrays.asList(row.split(",")));
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println(arrayList);
        return arrayList;
    }
}
