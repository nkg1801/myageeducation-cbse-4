package com.myAgeEducation.cbseClass4.maths.fractions;

import java.util.Random;

public class FractionTrueFalseGenerator
{
    private static final Random RANDOM = new Random();

    public static FractionTrueFalseData generate()
    {
        FractionTrueFalseStatementType[] types = FractionTrueFalseStatementType.values();

        FractionTrueFalseStatementType statementType = types[RANDOM.nextInt(types.length)];

        // Randomly decide whether this question should be true or false
        boolean expectedAnswer = RANDOM.nextBoolean();

        int numerator;
        int denominator;
        String statement;

        switch (statementType)
        {
            case NUMERATOR_GREATER_THAN_DENOMINATOR:

                if (expectedAnswer)
                {
                    denominator = randomNumber(1, 8);
                    numerator = randomNumber(denominator + 1, 9);
                }
                else
                {
                    numerator = randomNumber(1, 8);
                    denominator = randomNumber(numerator + 1, 9);
                }

                statement = "The numerator is greater than the denominator.";
                break;


            case NUMERATOR_LESS_THAN_DENOMINATOR:

                if (expectedAnswer)
                {
                    numerator = randomNumber(1, 8);
                    denominator = randomNumber(numerator + 1, 9);
                }
                else
                {
                    denominator = randomNumber(1, 8);
                    numerator = randomNumber(denominator + 1, 9);
                }

                statement = "The numerator is less than the denominator.";

                break;


            case NUMERATOR_EQUAL_TO_DENOMINATOR:

                if (expectedAnswer)
                {
                    numerator = randomNumber(1, 9);
                    denominator = numerator;
                }
                else
                {
                    numerator = randomNumber(1, 9);

                    do
                    {
                        denominator = randomNumber(1, 9);
                    }
                    while (denominator == numerator);
                }

                statement = "The numerator is equal to the denominator.";

                break;


            case DENOMINATOR_GREATER_THAN_NUMERATOR:

                if (expectedAnswer)
                {
                    numerator = randomNumber(1, 8);
                    denominator = randomNumber(numerator + 1, 9);
                }
                else
                {
                    denominator = randomNumber(1, 8);
                    numerator = randomNumber(denominator + 1, 9);
                }

                statement = "The denominator is greater than the numerator.";

                break;


            case DENOMINATOR_LESS_THAN_NUMERATOR:
                if (expectedAnswer)
                {
                    denominator = randomNumber(1, 8);
                    numerator = randomNumber(denominator + 1, 9);
                }
                else
                {
                    numerator = randomNumber(1, 8);
                    denominator = randomNumber(numerator + 1, 9);
                }

                statement = "The denominator is less than the numerator.";
                break;

            case NUMERATOR_IS_VALUE:
                numerator = randomNumber(1, 9);
                denominator = randomNumber(1, 9);

                int numeratorValue;
                if (expectedAnswer)
                {
                    numeratorValue = numerator;
                }
                else
                {
                    numeratorValue = randomDifferentNumber(numerator);
                }
                statement = "The numerator is " + numeratorValue + ".";
                break;

            case DENOMINATOR_IS_VALUE:
                numerator = randomNumber(1, 9);
                denominator = randomNumber(1, 9);
                int denominatorValue;
                if (expectedAnswer)
                {
                    denominatorValue = denominator;
                }
                else
                {
                    denominatorValue = randomDifferentNumber(denominator);
                }
                statement = "The denominator is " + denominatorValue + ".";
                break;

            default:
                throw new IllegalArgumentException("Unknown statement type: " + statementType);
        }

        return new FractionTrueFalseData(numerator,denominator,statementType,statement,expectedAnswer);
    }


    private static int randomNumber(int min,int max)
    {
        return min + RANDOM.nextInt(max - min + 1);
    }

    private static int randomDifferentNumber(            int value)
    {
        int result;

        do
        {
            result = randomNumber(1, 9);
        }
        while (result == value);

        return result;
    }
}