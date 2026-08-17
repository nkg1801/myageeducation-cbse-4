package com.myAgeEducation.cbseClass4.utils;

import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class OptionUtils {
    private static final Random RANDOM = new Random();

    public static List<String> generateNumberOptions(int answer, int maxValue)
    {
        Set<String> options = new LinkedHashSet<>();

        // Correct answer
        options.add(String.valueOf(answer));

        // Nearby numbers
        if (answer > 1)
            options.add(String.valueOf(answer - 1));

        if (answer < maxValue)
            options.add(String.valueOf(answer + 1));

        // Always have enough numbers to choose from
        int upperLimit = Math.max(maxValue, 6);

        List<Integer> remaining = new ArrayList<>();

        for (int i = 1; i <= upperLimit; i++)
        {
            if (!options.contains(String.valueOf(i)))
            {
                remaining.add(i);
            }
        }

        // Shuffle remaining numbers
        Collections.shuffle(remaining);

        // Fill until we have 4 options
        for (int value : remaining)
        {
            if (options.size() >= 4)
                break;

            options.add(String.valueOf(value));
        }

        // Convert to list
        List<String> list = new ArrayList<>(options);

        // Randomize option order
        Collections.shuffle(list);

        return list;
    }

    public static List<String> generateDenominatorOptions(int answer)
    {
        int[] denominators = {2, 3, 4, 5, 6, 8, 9, 10, 12};
        Set<String> options = new LinkedHashSet<>();
        options.add(String.valueOf(answer));
        List<Integer> available = new ArrayList<>();

        for (int d : denominators)
        {
            if (d != answer)
            {
                available.add(d);
            }
        }

        Collections.shuffle(available, RANDOM);

        for (int i = 0; i < available.size() && options.size() < 4; i++)
        {
            options.add(String.valueOf(available.get(i)));
        }

        List<String> list = new ArrayList<>(options);
        Collections.shuffle(list, RANDOM);
        return list;
    }

    public static List<String> generateDenominatorQuestionOptions(int numerator, int denominator)
    {
        int[] validDenominators = {2, 3, 4, 5, 6, 8, 9, 10, 12};
        Set<String> options = new LinkedHashSet<>();

        // Correct answer
        options.add(String.valueOf(denominator));

        // Common mistake: numerator
        options.add(String.valueOf(numerator));

        List<Integer> remaining = new ArrayList<>();

        for (int d : validDenominators)
        {
            if (d != denominator && d != numerator)
            {
                remaining.add(d);
            }
        }

        Collections.shuffle(remaining, RANDOM);

        for (int d : remaining)
        {
            if (options.size() == 4)
                break;

            options.add(String.valueOf(d));
        }

        List<String> list = new ArrayList<>(options);

        Collections.shuffle(list, RANDOM);

        return list;
    }

    public static List<String> generateFractionOptions(int numerator, int denominator) {

        Set<String> options = new LinkedHashSet<>();

        options.add(fractionToWords(numerator, denominator));

        // Numerator - 1
        if (numerator > 1) {
            options.add(fractionToWords(numerator - 1, denominator));
        }

        // Numerator + 1
        if (numerator < denominator) {
            options.add(fractionToWords(numerator + 1, denominator));
        }

        // Same numerator, different denominator
        int[] denominators = {2, 3, 4, 5, 6, 8};
        for (int d : denominators) {
            if (d != denominator && numerator <= d) {
                options.add(fractionToWords(numerator, d));
                break;
            }
        }

        // Fill remaining options if needed
        while (options.size() < 4) {
            int d = denominators[RANDOM.nextInt(denominators.length)];
            int n = RANDOM.nextInt(d) + 1;
            options.add(fractionToWords(n, d));
        }

        List<String> list = new ArrayList<>(options);
        Collections.shuffle(list, RANDOM);
        return list;
    }

    private static String fractionToWords(int numerator, int denominator)
    {
        String[] numbers = {
                "Zero",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight"
        };

        String denominatorWord;

        switch (denominator)
        {
            case 2:
                denominatorWord = "Half";
                break;

            case 3:
                denominatorWord = "Third";
                break;

            case 4:
                denominatorWord = "Fourth";
                break;

            case 5:
                denominatorWord = "Fifth";
                break;

            case 6:
                denominatorWord = "Sixth";
                break;

            case 8:
                denominatorWord = "Eighth";
                break;

            default:
                denominatorWord = denominator + "th";
        }

        if (numerator > 1 && !denominatorWord.endsWith("s"))
        {
            denominatorWord += "s";
        }

        return numbers[numerator] + " " + denominatorWord;
    }

    public static void setQuestionOptions(Question question, String[] options)
    {
        question.setOption1(options[0]);
        question.setOption2(options[1]);
        if(options.length > 2) {
            question.setOption3(options[2]);
        }
        if(options.length > 3) {
            question.setOption4(options[3]);
        }
    }

    public static void setQuestionOptions(Question question, List<String> options)
    {
        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        if(options.size() > 2) {
            question.setOption3(options.get(2));
        }

        if(options.size() > 3) {
            question.setOption4(options.get(3));
        }
    }
}
