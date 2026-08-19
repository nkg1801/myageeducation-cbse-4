package com.myAgeEducation.cbseClass4.maths.fractions;

import java.util.Random;

public class FractionAgeGenerator
{
    private static final Random RANDOM = new Random();

    private static final int[] DENOMINATORS =
            {2, 3, 4, 5, 6};

    public static FractionAgeData generateAgePair()
    {
        FractionAgeData.AgeRelationship[] relationships =
                FractionAgeData.AgeRelationship.values();

        FractionAgeData.AgeRelationship relationship =
                relationships[RANDOM.nextInt(relationships.length)];

        return generateAgePair(relationship);
    }

    private static FractionAgeData generateAgePair(
            FractionAgeData.AgeRelationship relationship)
    {
        while (true)
        {
            int denominator =
                    DENOMINATORS[
                            RANDOM.nextInt(DENOMINATORS.length)];

            int youngerAge =
                    5 + RANDOM.nextInt(8); // 5 to 12

            int referenceAge =
                    youngerAge * denominator;

            if (isValidAge(
                    relationship,
                    referenceAge,
                    youngerAge))
            {
                return new FractionAgeData(
                        referenceAge,
                        youngerAge,
                        denominator,
                        relationship);
            }
        }
    }

    private static boolean isValidAge(
            FractionAgeData.AgeRelationship relationship,
            int referenceAge,
            int youngerAge)
    {
        switch (relationship)
        {
            case FATHER:
            case MOTHER:

                // Parent should have a realistic adult age
                return referenceAge >= 28
                        && referenceAge <= 60
                        && referenceAge - youngerAge >= 18;

            case BROTHER:
            case SISTER:

                // Sibling age
                return referenceAge >= 8
                        && referenceAge <= 25;

            default:
                return false;
        }
    }
}

