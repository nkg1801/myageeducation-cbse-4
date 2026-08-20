package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.Random;

public final class NumberPairUtil
{
    private static final Random RANDOM = new Random();

    private NumberPairUtil()
    {
    }

    public static NumberPair randomPair(int firstMin, int firstMax, int secondMin, int secondMax)
    {
        int first = RANDOM.nextInt(firstMax - firstMin + 1) + firstMin;
        int second = RANDOM.nextInt(secondMax - secondMin + 1) + secondMin;
        return new NumberPair(first, second);
    }
}