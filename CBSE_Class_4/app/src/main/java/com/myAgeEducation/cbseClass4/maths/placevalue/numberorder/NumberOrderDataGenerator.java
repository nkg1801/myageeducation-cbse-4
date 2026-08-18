package com.myAgeEducation.cbseClass4.maths.placevalue.numberorder;

import java.util.Arrays;
import java.util.Random;

public class NumberOrderDataGenerator
{
    private static final Random RANDOM = new Random();

    private static final int NUMBER_COUNT = 4;

    private static final int MIN_VALUE = 1000;
    private static final int MAX_VALUE = 9999999;

    public static NumberOrderData generate()
    {
        NumberOrderQuestionType type =
                RANDOM.nextBoolean()
                        ? NumberOrderQuestionType.INCREASING
                        : NumberOrderQuestionType.DECREASING;

        int[] numbers =
                generateUniqueNumbers();

        Arrays.sort(numbers);

        if (type ==
                NumberOrderQuestionType.DECREASING)
        {
            reverse(numbers);
        }

        return new NumberOrderData(
                numbers,
                type);
    }

    private static int[] generateUniqueNumbers()
    {
        int[] numbers =
                new int[NUMBER_COUNT];

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

    private static void reverse(
            int[] numbers)
    {
        for (int i = 0;
             i < numbers.length / 2;
             i++)
        {
            int temp =
                    numbers[i];

            numbers[i] =
                    numbers[
                            numbers.length
                                    - 1
                                    - i];

            numbers[
                    numbers.length
                            - 1
                            - i] =
                    temp;
        }
    }
}