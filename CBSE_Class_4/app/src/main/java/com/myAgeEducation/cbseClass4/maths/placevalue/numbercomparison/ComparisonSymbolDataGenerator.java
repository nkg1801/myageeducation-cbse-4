package com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison;

import static com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison.NumberComparisonDataGenerator.generateSimilarNumbers;

import java.util.Random;

public class ComparisonSymbolDataGenerator {
    private static final Random RANDOM = new Random();
    public static ComparisonSymbolQuestionData generate()
    {
        int[] numbers = generateSimilarNumbers();

        int first = numbers[RANDOM.nextInt(4)];

        int second;

        do
        {
            second =
                    numbers[RANDOM.nextInt(4)];
        }
        while (second == first);

        String answer =
                first < second
                        ? "<"
                        : ">";

        return new ComparisonSymbolQuestionData(
                first,
                second,
                answer);
    }
}
