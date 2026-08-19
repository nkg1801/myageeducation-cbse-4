package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class OptionUtil
{
    private static final Random RANDOM = new Random();

    private OptionUtil()
    {
    }

    public static String[] createNearbyOptions(int answer)
    {
        Set<String> options = new LinkedHashSet<>();

        options.add(String.valueOf(answer));

        if (RANDOM.nextBoolean())
        {
            addOption(options, answer - 1);
            addOption(options, answer + 1);
            addOption(options, answer - 2);
        }
        else
        {
            addOption(options, answer - 1);
            addOption(options, answer + 1);
            addOption(options, answer + 2);
        }

        return finalizeOptions(options);
    }

    public static String[] createIdentifyPartOptions(int correctAnswer, int value1, int value2, int value3)
    {
        Set<String> options = new LinkedHashSet<>();

        options.add(String.valueOf(correctAnswer));

        if (value1 != correctAnswer)
        {
            options.add(String.valueOf(value1));
        }

        if (value2 != correctAnswer)
        {
            options.add(String.valueOf(value2));
        }

        if (value3 != correctAnswer)
        {
            options.add(String.valueOf(value3));
        }

        return finalizeOptions(options);
    }

    public static String[] createIdentityOptions(int answer, int... distractors)
    {
        Set<String> options = new LinkedHashSet<>();
        options.add(String.valueOf(answer));

        for (int value : distractors)
        {
            options.add(String.valueOf(value));
        }

        return finalizeOptions(options);
    }

    public static String[] createTrueFalseOptions(boolean answer)
    {
        if (answer)
        {
            return new String[]{"True", "False"};
        }

        return new String[]{"False", "True"};
    }

    private static void addOption(Set<String> options, int value)
    {
        if (value >= 0)
        {
            options.add(String.valueOf(value));
        }
    }

    private static String[] finalizeOptions(Set<String> options)
    {
        while (options.size() < 4)
        {
            int value = RANDOM.nextInt(20) + 1;
            options.add(String.valueOf(value));
        }

        List<String> list = new ArrayList<>(options);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

    /*public static void setQuestionOptions(Question question, String[] options)
    {
        question.setOption1(options[0]);
        question.setOption2(options[1]);
        if(options.length > 2) {
            question.setOption3(options[2]);
        }
        if(options.length > 3) {
            question.setOption4(options[3]);
        }
    }*/
}