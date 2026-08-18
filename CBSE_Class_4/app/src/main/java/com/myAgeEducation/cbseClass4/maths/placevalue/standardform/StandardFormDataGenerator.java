package com.myAgeEducation.cbseClass4.maths.placevalue.standardform;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StandardFormDataGenerator
{
    private static final Random RANDOM =
            new Random();

    private static final int MIN_VALUE = 1000;
    private static final int MAX_VALUE = 9999999;


    private StandardFormDataGenerator()
    {
        // Prevent object creation
    }

    public static StandardFormQuestionData generate()
    {
        int number =
                MIN_VALUE
                        + RANDOM.nextInt(
                        MAX_VALUE
                                - MIN_VALUE
                                + 1);

        String expandedForm =
                getExpandedForm(number);

        StandardFormQuestionType type = RANDOM.nextBoolean() ? StandardFormQuestionType.EXPANDED_TO_STANDARD : StandardFormQuestionType.STANDARD_TO_EXPANDED;

        //type = StandardFormQuestionType.EXPANDED_TO_STANDARD; //todo: remove it from production.. used here only for testing

        return new StandardFormQuestionData(
                number,
                expandedForm,
                type);
    }


    /*public static String getExpandedForm(int number)
    {
        List<String> parts =new ArrayList<>();
        int thousands = (number / 1000) * 1000;
        int hundreds = ((number / 100) % 10) * 100;
        int tens = ((number / 10) % 10) * 10;
        int ones = number % 10;

        if (thousands > 0)
        {
            parts.add(String.valueOf(thousands));
        }

        if (hundreds > 0)
        {
            parts.add(String.valueOf(hundreds));
        }

        if (tens > 0)
        {
            parts.add(String.valueOf(tens));
        }

        if (ones > 0)
        {
            parts.add(String.valueOf(ones));
        }

        return String.join(" + ", parts);
    }*/

    public static String getExpandedForm(int number) {
        List<String> parts = new ArrayList<>();

        int place = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;

            if (digit != 0) {
                parts.add(0, NumberFormatUtil.formatIndianNumber(digit * place));
            }

            temp /= 10;
            place *= 10;
        }

        return String.join(" + ", parts);
    }
}
