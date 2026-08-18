package com.myAgeEducation.cbseClass4.maths.placevalue.arrangenumbers;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class ArrangeNumbersDataGenerator {
    private static final Random RANDOM =
            new Random();

    private static final int MIN_NUMBER = 10000;
    private static final int MAX_NUMBER = 999999;

    private ArrangeNumbersDataGenerator() {
    }

    public static ArrangeNumbersQuestionData generate() {
        int[] originalNumbers = generateUniqueNumbers(4);
        int[] arrangedNumbers = originalNumbers.clone();
        boolean ascending = RANDOM.nextBoolean();
        Arrays.sort(arrangedNumbers);

        if (!ascending)
        {
            reverse(arrangedNumbers);
        }

        return new ArrangeNumbersQuestionData(
                originalNumbers,
                arrangedNumbers,
                ascending);
    }

    private static int[] generateUniqueNumbers(int count)
    {
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < count)
        {
            numbers.add(
                    MIN_NUMBER
                            + RANDOM.nextInt(
                            MAX_NUMBER
                                    - MIN_NUMBER
                                    + 1));
        }

        int[] result = new int[count];

        int index = 0;

        for (Integer value : numbers)
        {
            result[index++] = value;
        }

        return result;
    }

    private static void reverse(int[] array)
    {
        int left = 0;
        int right = array.length - 1;

        while (left < right)
        {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
}