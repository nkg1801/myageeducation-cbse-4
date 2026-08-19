package com.myAgeEducation.cbseClass4.maths.fractions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionPool
{
    public static List<FractionKey> createPool()
    {
        List<FractionKey> pool = new ArrayList<>();

        int[] denominators = {2,3,4,5,6,8};

        for (int denominator : denominators)
        {
            for (int numerator = 1;
                 numerator < denominator;
                 numerator++)
            {
                pool.add(new FractionKey(
                        numerator,
                        denominator));
            }
        }

        Collections.shuffle(pool);

        return pool;
    }
}