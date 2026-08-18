package com.myAgeEducation.cbseClass4.maths.placevalue.greatestsmallest;

import java.util.Random;

public class GreatestSmallestDataGenerator
{
    private static final Random RANDOM = new Random();
    private static final int NUMBER_COUNT = 4;
    private static final int MIN_VALUE = 1000;
    private static final int MAX_VALUE = 999999;


    private GreatestSmallestDataGenerator()
    {
        // Prevent object creation
    }

    public static GreatestSmallestQuestionData generate()
    {
        int[] numbers = generateUniqueNumbers();

        GreatestSmallestQuestionType type =
                RANDOM.nextBoolean()
                        ? GreatestSmallestQuestionType.GREATEST
                        : GreatestSmallestQuestionType.SMALLEST;

        return new GreatestSmallestQuestionData(
                numbers,
                type);
    }


    private static int[] generateUniqueNumbers()
    {
        int[] numbers = new int[NUMBER_COUNT];

        for (int i = 0;
             i < NUMBER_COUNT;
             i++)
        {
            int number;

            do
            {
                number =
                        MIN_VALUE
                                + RANDOM.nextInt(
                                MAX_VALUE
                                        - MIN_VALUE
                                        + 1);
            }
            while (contains(
                    numbers,
                    i,
                    number));

            numbers[i] =
                    number;
        }

        return numbers;
    }


    private static boolean contains(
            int[] numbers,
            int count,
            int value)
    {
        for (int i = 0;
             i < count;
             i++)
        {
            if (numbers[i] == value)
            {
                return true;
            }
        }

        return false;
    }
}
