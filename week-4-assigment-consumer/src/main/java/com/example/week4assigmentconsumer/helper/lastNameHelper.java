package com.example.week4assigmentconsumer.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class lastNameHelper {
    public static String generateFirstName(){
        ArrayList<String> last_name = new ArrayList<String>(Arrays.asList("Kealy", "Jenks", "Ballingal", "Vaskov", "Stonbridge", "MacGiffin", "Howgill", "Castillo", "Geri", "Vickerman", "Ramos", "Spillett", "Kaygill", "Reap", "Corriea", "Gemmill", "Arrighi", "Cuskery", "Lindgren", "Philipard", "Babon", "Marquet", "Vost", "Terram", "Tipperton", "Zanotti", "Fiske", "Clelle", "Stanbridge", "Sonner", "Leftwich", "Wisdom", "Butt", "Jalland", "Slinger", "Turl", "Harries", "Etheredge", "Foxley", "MacGeaney", "Hambatch", "Guillet", "Ivantyev", "Arghent", "Durnall", "Jenteau", "Ennor", "Perotti", "Muggeridge", "Amburgy"));
        Random random = new Random();
        int randomIndex = random.nextInt(last_name.size());
        return last_name.get(randomIndex);
    }
}
