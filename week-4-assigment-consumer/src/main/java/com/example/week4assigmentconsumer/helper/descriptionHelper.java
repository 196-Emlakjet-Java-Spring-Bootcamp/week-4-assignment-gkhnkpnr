package com.example.week4assigmentconsumer.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class descriptionHelper {
    public static String generateDescription(){
        ArrayList<String> description = new ArrayList<String>(Arrays.asList("Ihtiyactan Satilik", "Asansorlu", "Kombili", "Fiber Altyapisi Var", "Guven Emlak", "Aktas Emlak", "Kalite Guven Bizim Isimiz"));
        Random random = new Random();
        int randomIndex = random.nextInt(description.size());
        String descriptionText = description.get(randomIndex);
        return descriptionText;
    }
}
