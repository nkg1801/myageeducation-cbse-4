package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.Locale;
import java.text.NumberFormat;

public class NumberFormatUtil {
    public static String formatIndianNumber(int number) {
        return NumberFormat
                .getInstance(new Locale("en", "IN"))
                .format(number);
    }
}
