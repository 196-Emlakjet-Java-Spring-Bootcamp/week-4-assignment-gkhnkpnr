package com.example.week4assigmentconsumer.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class titleHelper {

    public static String generateTitle(){
        ArrayList<String> firstTitle = new ArrayList<String>(Arrays.asList("satilik","kiralik","temiz","doktordan","ihtiyactan"));
        ArrayList<String> secondTitle = new ArrayList<String>(Arrays.asList("ev","araba","villa","arsa"));
        Random random = new Random();
        int firstRandomIndex = random.nextInt(firstTitle.size());
        int secondRandomIndex = random.nextInt(secondTitle.size());
        String title = firstTitle.get(firstRandomIndex) +" "+ secondTitle.get(secondRandomIndex);
        return title;
    }
}
