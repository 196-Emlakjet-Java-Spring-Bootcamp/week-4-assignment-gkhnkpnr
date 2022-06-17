package com.example.week4assigmentconsumer.helper;

public class emailGeneratorHelper {
    public static String generateEmail(String firstName, String lastName){
        String email = (firstName + "." + lastName + "@mail.com").toLowerCase();
        return email;
    }
}
