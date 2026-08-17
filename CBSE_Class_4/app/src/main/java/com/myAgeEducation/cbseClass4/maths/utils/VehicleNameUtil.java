package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VehicleNameUtil {
    private static final String[] VEHICLE_NAMES_FOR_SCHOOL_TRANSPORT = {
            "Car", "Public Bus", "School Bus", "Auto", "Bicycle", "Walking"
    };

    public static String[] getDifferentVehicles(int count)
    {
        List<String> list = Arrays.asList(VEHICLE_NAMES_FOR_SCHOOL_TRANSPORT);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }
}
