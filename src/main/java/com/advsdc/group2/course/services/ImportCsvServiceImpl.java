package com.advsdc.group2.course.services;

import com.advsdc.group2.signup.models.User;
import com.advsdc.group2.signup.services.SignupServiceImpl;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ImportCsvServiceImpl implements IImportCsvService {
    @Override
    public ArrayList<List<String>> readFromCsv(InputStreamReader inputStreamReader) {
        ArrayList<User> userArrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<List<String>> arrayList = new ArrayList<>();
        String row;
        try {
            while ((row = bufferedReader.readLine()) != null) {
                arrayList.add(Arrays.asList(row.split(",")));
            }

            for(int i = 0; i < arrayList.size(); i++){
                User user = new User();
                user.setFirstName(arrayList.get(i).get(0));
                user.setLastName(arrayList.get(i).get(1));
                user.setUserId(arrayList.get(i).get(2));
                user.setEmail(arrayList.get(i).get(3));
                user.setPassword("Password");
                user.setMatchingPassword("Password");
                userArrayList.add(user);
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println(arrayList);
        createUsersFromList(userArrayList);
        return arrayList;
    }

    @Override
    public void createUsersFromList(ArrayList<User> userArrayList){
        SignupServiceImpl signupService  = new SignupServiceImpl();
        for(int i = 0; i < userArrayList.size(); i++){
            if(signupService.isUserInDb(userArrayList.get(i).getUserId())){
                continue;
            }
            signupService.createUser(userArrayList.get(i));
            sendEmail(userArrayList.get(i));
        }
    }

    @Override
    public void sendEmail(User user){

        String toAddress = user.getEmail();
        String fromAddress = "advsdcgrp2.catme@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromAddress, "msdcpkaidutytdxs");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            message.setContent(
                    "User ID:  <b>" + user.getUserId()
                            + "</b> <br> Password: <b>" + user.getPassword() + "</b>",
                    "text/html; charset=utf-8");

            message.setSubject("CatMe account created");
            Transport.send(message);
            System.out.println("Email sent successfully..");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
