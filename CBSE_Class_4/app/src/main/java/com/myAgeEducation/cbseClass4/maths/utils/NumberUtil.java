package com.myAgeEducation.cbseClass4.maths.utils;
import java.util.Random;

public final class NumberUtil
{
    private static final Random RANDOM = new Random();

    private NumberUtil()
    {
    }

    /**
     * Returns two numbers suitable for subtraction stories.
     * first > second
     */
    public static NumberPair getSubtractionNumbers()
    {
        int first = RANDOM.nextInt(41) + 40;      // 40-80
        int second = RANDOM.nextInt(first / 2) + 5;
        return new NumberPair(first, second);
    }

    /**
     * Returns two numbers suitable for comparison questions.
     */
    public static NumberPair getComparisonNumbers()
    {
        return getSubtractionNumbers();
    }

    /**
     * Returns remaining and removed values for
     * "Unknown Start" questions.
     */
    public static NumberPair getUnknownStartNumbers()
    {
        int remaining = RANDOM.nextInt(31) + 20;
        int removed = RANDOM.nextInt(16) + 5;
        return new NumberPair(remaining, removed);
    }
}