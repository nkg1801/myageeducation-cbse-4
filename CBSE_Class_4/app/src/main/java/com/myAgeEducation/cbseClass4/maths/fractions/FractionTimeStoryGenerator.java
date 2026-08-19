package com.myAgeEducation.cbseClass4.maths.fractions;

import java.util.Random;

public class FractionTimeStoryGenerator
{
    private static final Random RANDOM = new Random();

    private static final int[] DENOMINATORS =
            {2, 3, 4};


    public static FractionTimeStoryData generate()
    {
        FractionTimeScenario[] scenarios =
                FractionTimeScenario.values();

        FractionTimeScenario scenario =
                scenarios[RANDOM.nextInt(scenarios.length)];

        // Numerator always 1 for Class 3
        int numerator = 1;

        int denominator =
                DENOMINATORS[
                        RANDOM.nextInt(DENOMINATORS.length)];

        String timeUnit;
        int answerTime;

        switch (scenario)
        {
            case CITY_JOURNEY:

                timeUnit = "hours";

                // Answer between 1 and 3 hours
                answerTime =
                        1 + RANDOM.nextInt(3);

                break;


            case WALK_TO_SCHOOL:
            case CYCLING:

                timeUnit = "minutes";

                // 5, 10, 15 or 20 minutes
                answerTime =
                        (1 + RANDOM.nextInt(4)) * 5;

                break;


            case HOMEWORK:
            case READING:

                timeUnit = "minutes";

                // 10, 15, 20 or 25 minutes
                answerTime =
                        (2 + RANDOM.nextInt(4)) * 5;

                break;


            default:
                throw new IllegalArgumentException(
                        "Unknown scenario: " + scenario);
        }


        // Generate the original time from the answer.
        // This guarantees a whole-number answer.
        int originalTime =
                answerTime * denominator;


        return new FractionTimeStoryData(
                numerator,
                denominator,
                originalTime,
                answerTime,
                timeUnit,
                scenario);
    }


    public static String generateQuestionText(
            FractionTimeStoryData data)
    {
        String fraction =
                fractionToWords(
                        data.numerator,
                        data.denominator);


        switch (data.scenario)
        {
            case CITY_JOURNEY:

                return "A bus takes "
                        + data.originalTime
                        + " hours to complete a journey. "
                        + "A train takes "
                        + fraction
                        + " of that time. "
                        + "How many hours does the train take?";


            case WALK_TO_SCHOOL:

                return "Riya takes "
                        + data.originalTime
                        + " minutes to walk to school. "
                        + "Her brother takes "
                        + fraction
                        + " of that time. "
                        + "How many minutes does her brother take?";


            case CYCLING:

                return "Rohan takes "
                        + data.originalTime
                        + " minutes to cycle to the park. "
                        + "His friend takes "
                        + fraction
                        + " of that time. "
                        + "How many minutes does his friend take?";


            case HOMEWORK:

                return "Aman takes "
                        + data.originalTime
                        + " minutes to complete his homework. "
                        + "His sister takes "
                        + fraction
                        + " of that time. "
                        + "How many minutes does his sister take?";


            case READING:

                return "Meera takes "
                        + data.originalTime
                        + " minutes to read a story. "
                        + "Her brother takes "
                        + fraction
                        + " of that time. "
                        + "How many minutes does her brother take?";


            default:
                throw new IllegalArgumentException(
                        "Unknown scenario: "
                                + data.scenario);
        }
    }


    private static String fractionToWords(
            int numerator,
            int denominator)
    {
        if (numerator == 1)
        {
            switch (denominator)
            {
                case 2:
                    return "half";

                case 3:
                    return "one third";

                case 4:
                    return "one fourth";
            }
        }

        return numerator + "/" + denominator;
    }
}