package com.example.week4assigmentconsumer.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class firstNameHelper {
    public static String generateFirstName(){
        ArrayList<String> first_name = new ArrayList<String>(Arrays.asList("Dennie", "Andromache", "Alicia", "Tomi", "Anna-maria", "Lewiss", "Bret", "Orelle", "Shelagh", "Willi", "Rad", "Shalne", "Buiron", "Shelden", "Ariana", "Lemmy", "Alwin", "Nicolette", "Haily", "Stu", "Dorolisa", "Ronica", "Wilhelm", "Sharon", "Linea", "Patricio", "Nickola", "Kellia", "Ethelin", "Camella", "Gabey", "Gunther", "Martin", "Celestina", "Jamill", "Waverly", "Kizzie", "Orion", "Ab", "Tomas", "Barnard", "Justin", "Dale", "Lisle", "Lee", "Garek", "Mari", "Ilise", "Rob", "Jackquelin"));
        Random random = new Random();
        int randomIndex = random.nextInt(first_name.size());
        return first_name.get(randomIndex);
    }
}
