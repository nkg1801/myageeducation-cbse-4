package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CitiesNameUtil {
    private static final String[] INDIAN_CITIES = {
            "Mumbai", "Delhi", "Bengaluru", "Hyderabad", "Ahmedabad", "Chennai", "Kolkata", "Surat",
            "Pune", "Jaipur", "Lucknow", "Kanpur", "Nagpur", "Patna", "Indore", "Thane", "Bhopal",
            "Agra","Varanasi",
            "Srinagar",
            "Madurai", "Guwahati",
            "Amravati", "Noida",
            "Kochi",
            "Gaya",
            "Mysore",
    };

    private static final String[] INTERNATIONAL_CITIES = {
        "New Delhi", "Bengaluru", "Chennai", "Kolkata", "Mumbai", "Hyderabad",
            "San Francisco", "New York", "London", "Paris", "Tokyo", "Sydney", "Rio de Janeiro",
            "Berlin", "Stockholm", "Hiroshima", "Nagasaki", "Singapore", "Beijing", "Shanghai",
            "Calgary"
    };

    public static String[] getDifferentIndianCities(int count)
    {
        List<String> list = Arrays.asList(INDIAN_CITIES);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }

    public static String[] getDifferentInternationalCities(int count)
    {
        List<String> list = Arrays.asList(INTERNATIONAL_CITIES);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }

    public static String[] getDifferentCities(int count)
    {
        String[] all_cities = new String[INDIAN_CITIES.length + INTERNATIONAL_CITIES.length];
        System.arraycopy(INDIAN_CITIES, 0, all_cities, 0, INDIAN_CITIES.length);
        System.arraycopy(INTERNATIONAL_CITIES, 0, all_cities, INDIAN_CITIES.length, INTERNATIONAL_CITIES.length);
        List<String> list = Arrays.asList(all_cities);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }
}
