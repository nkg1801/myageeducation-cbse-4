package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountriesNameUtil {
    private static final String[] COUNTRIES = {
            "Australia", "New Zealand",
            "Brazil", "Belgium",
            "Canada",
            "France", "Italy", "Spain",
            "India", "USA", "United Kingdom", "Germany", "Singapore", "Japan", "Iran", "Israel",
            "Pakistan", "Nepal", "Sweden",  "China", "Russia"
    };

    public static String[] getDifferentCountryNames(int count)
    {
        List<String> list = Arrays.asList(COUNTRIES);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }
}
