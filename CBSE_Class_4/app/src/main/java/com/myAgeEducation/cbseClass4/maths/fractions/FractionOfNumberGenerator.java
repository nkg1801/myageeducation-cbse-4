package com.myAgeEducation.cbseClass4.maths.fractions;

import java.util.Random;

public class FractionOfNumberGenerator
{
    private static final Random RANDOM = new Random();

    private static final int[] DENOMINATORS =
            {2, 3, 4, 5, 6};

    public static FractionOfNumberData generate()
    {
        // Numerator is always 1 for Class 3
        int numerator = 1;

        int denominator = DENOMINATORS[RANDOM.nextInt(DENOMINATORS.length)];

        // The answer will be between 2 and 10
        int answer = 2 + RANDOM.nextInt(9);

        // This guarantees that the fraction gives a whole number
        int total = answer * denominator;

        return new FractionOfNumberData(numerator,denominator,total,answer);
    }
}