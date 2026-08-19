package com.myAgeEducation.cbseClass4.maths.factors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FactorOptionUtils
{
    private static final Random RANDOM =
            new Random();

    private static final int OPTION_COUNT = 4;
    private static final int MINIMUM_OPTION_COUNT = 2;

    private FactorOptionUtils()
    {
        // Prevent object creation
    }


    // =========================================================
    // FACTOR OPTIONS
    //
    // Exactly ONE option is a factor of number.
    // =========================================================

    public static String[] generateFactorOptions(
            int number)
    {
        List<Integer> factors =
                FactorQuestionGenerator
                        .getFactors(number);

        List<Integer> nonFactors =
                getNonFactors(
                        number,
                        factors);

        if (factors.isEmpty()
                || nonFactors.size() < 3)
        {
            throw new IllegalArgumentException(
                    "Unable to generate factor options for "
                            + number);
        }

        // Choose one correct factor.
        int correct =
                factors.get(
                        RANDOM.nextInt(
                                factors.size()));

        List<Integer> options =
                new ArrayList<>();

        options.add(correct);

        // Add 3 incorrect options.
        addRandomDistinctValues(
                options,
                nonFactors,
                OPTION_COUNT);

        Collections.shuffle(
                options,
                RANDOM);

        validateExactlyOneFactor(number,
                options);

        return toStringArray(options);
    }


    // =========================================================
    // NOT FACTOR OPTIONS
    //
    // Exactly ONE option is NOT a factor of number.
    // =========================================================

    public static String[] generateNotFactorOptions(int number)
    {
        List<Integer> factors = FactorQuestionGenerator.getFactors(number);
        List<Integer> nonFactors = getNonFactors(number, factors);

        if (factors.size() < 3 || nonFactors.isEmpty())
        {
            throw new IllegalArgumentException("Unable to generate NOT-factor options for " + number);
        }

        // Choose one correct NOT-factor.
        int correct = nonFactors.get(RANDOM.nextInt(nonFactors.size()));
        List<Integer> options = new ArrayList<>();
        options.add(correct);

        // Add 3 actual factors.
        addRandomDistinctValues(options, factors, OPTION_COUNT);
        Collections.shuffle(options, RANDOM);
        validateExactlyOneNonFactor(number,options);
        return toStringArray(options);
    }

    // =========================================================
    // COMMON FACTOR OPTIONS
    //
    // Exactly ONE option is a factor of BOTH numbers.
    // =========================================================

    public static String[] generateCommonFactorOptions(int number1, int number2)
    {
        List<Integer> commonFactors =
                FactorQuestionGenerator
                        .getCommonFactors(
                                number1,
                                number2);

        if (commonFactors.isEmpty())
        {
            throw new IllegalArgumentException(
                    "Numbers must have at least one "
                            + "common factor.");
        }

        List<Integer> factors1 =
                FactorQuestionGenerator
                        .getFactors(number1);

        List<Integer> factors2 =
                FactorQuestionGenerator
                        .getFactors(number2);

        // Find numbers which are factors of only
        // one of the two numbers.
        List<Integer> invalidFactors =
                new ArrayList<>();

        for (int i = 2;
             i <= Math.max(number1, number2);
             i++)
        {
            boolean factorOfFirst =
                    factors1.contains(i);

            boolean factorOfSecond =
                    factors2.contains(i);

            if (factorOfFirst
                    != factorOfSecond)
            {
                invalidFactors.add(i);
            }
        }

        if (invalidFactors.size() < 3)
        {
            // If not enough invalid factors, add some non-factors of both
            for (int i = 2; i <= Math.max(number1, number2) + 10; i++)
            {
                if (!factors1.contains(i) && !factors2.contains(i))
                {
                    invalidFactors.add(i);
                    if (invalidFactors.size() >= 3) break;
                }
            }
        }

        // ---------------------------------------------------------
        // Select the correct common factor.
        //
        // Prefer a factor greater than 1.
        // Use 1 only when 1 is the only common factor.
        // ---------------------------------------------------------

        List<Integer> preferredFactors =
                new ArrayList<>();

        for (Integer factor : commonFactors)
        {
            if (factor > 1)
            {
                preferredFactors.add(factor);
            }
        }

        int correct;

        if (!preferredFactors.isEmpty())
        {
            correct =
                    preferredFactors.get(
                            RANDOM.nextInt(
                                    preferredFactors.size()));
        }
        else
        {
            // 1 is the only common factor.
            correct = 1;
        }

        // ---------------------------------------------------------
        // Generate distractors.
        // ---------------------------------------------------------

        List<Integer> options =
                new ArrayList<>();

        options.add(correct);

        addRandomDistinctValues(
                options,
                invalidFactors,
                OPTION_COUNT);

        Collections.shuffle(
                options,
                RANDOM);

        // ---------------------------------------------------------
        // Validate exactly one common factor.
        // ---------------------------------------------------------

        validateExactlyOneCommonFactor(
                number1,
                number2,
                options);

        return toStringArray(options);
    }

    public static String[] generateFillMissingFactorOptions(int number, int missingFactor)
    {
        List<Integer> factors = FactorQuestionGenerator.getFactors(number);
        List<Integer> nonFactors = getNonFactors(number, factors);

        // If not enough non-factors, look beyond 'number'
        if (nonFactors.size() < 3)
        {
            for (int i = number + 1; nonFactors.size() < 3; i++)
            {
                nonFactors.add(i);
            }
        }

        List<Integer> options = new ArrayList<>();
        options.add(missingFactor);

        addRandomDistinctValues(options, nonFactors, OPTION_COUNT);

        Collections.shuffle(options, RANDOM);
        return toStringArray(options);
    }

    public static String[] generateCountOptions(int answer)
    {
        List<Integer> options = new ArrayList<>();
        options.add(answer);

        // Nearby numbers
        if (answer > 1) options.add(answer - 1);
        options.add(answer + 1);
        options.add(answer + 2);

        // Ensure we have 4 distinct options
        int candidate = answer + 3;
        while (options.size() < OPTION_COUNT)
        {
            if (!options.contains(candidate))
            {
                options.add(candidate);
            }
            candidate++;
        }

        // Sometimes if answer is small, we might have added negative or 0 if we weren't careful.
        // But here answer is count of factors, which is at least 1.
        // If answer is 1, options: 1, 2, 3, 4.
        
        // Remove duplicates if any (though logic above should handle it)
        List<Integer> distinctOptions = new ArrayList<>();
        for(int opt : options) {
            if(!distinctOptions.contains(opt)) distinctOptions.add(opt);
        }
        
        // Final check to make sure we have 4
        while(distinctOptions.size() < OPTION_COUNT) {
            int r = 1 + RANDOM.nextInt(10);
            if(!distinctOptions.contains(r)) distinctOptions.add(r);
        }

        Collections.shuffle(distinctOptions, RANDOM);
        return toStringArray(distinctOptions);
    }

    public static String[] generateTrueFalseOptions()
    {
        return new String[]{"TRUE", "FALSE"};
    }

    public static String[] generateGreatestFactorOptions(int number)
    {
        List<Integer> factors = FactorQuestionGenerator.getFactors(number);
        List<Integer> options = new ArrayList<>();
        options.add(number); // Correct answer

        // Distractors: other factors
        List<Integer> otherFactors = new ArrayList<>(factors);
        otherFactors.remove(Integer.valueOf(number));

        addRandomDistinctValues(options, otherFactors, OPTION_COUNT);

        // If not enough factors, add some other numbers
        int candidate = 1;
        while (options.size() < OPTION_COUNT)
        {
            if (!options.contains(candidate))
            {
                options.add(candidate);
            }
            candidate++;
        }

        Collections.shuffle(options, RANDOM);
        return toStringArray(options);
    }

    public static String[] generateListFactorsOptions(int number)
    {
        List<Integer> factors = FactorQuestionGenerator.getFactors(number);
        String correct = listToCommaString(factors);

        List<String> options = new ArrayList<>();
        options.add(correct);

        // Distractor 1: Missing one factor (if possible)
        if (factors.size() > 2)
        {
            List<Integer> missingOne = new ArrayList<>(factors);
            // Don't remove 1 or the number itself to make it a plausible distractor
            int indexToRemove = 1 + RANDOM.nextInt(factors.size() - 2);
            missingOne.remove(indexToRemove);
            options.add(listToCommaString(missingOne));
        }

        // Distractor 2: One extra non-factor
        List<Integer> nonFactors = getNonFactors(number, factors);
        if (!nonFactors.isEmpty())
        {
            List<Integer> extraOne = new ArrayList<>(factors);
            int nonFactor = nonFactors.get(RANDOM.nextInt(nonFactors.size()));
            extraOne.add(nonFactor);
            Collections.sort(extraOne);
            options.add(listToCommaString(extraOne));
        }

        // Distractor 3: Factors of a nearby number
        int nearby = number + (RANDOM.nextBoolean() ? 2 : -2);
        if (nearby < 2) nearby = number + 3;
        options.add(listToCommaString(FactorQuestionGenerator.getFactors(nearby)));

        // Ensure 4 distinct options
        while (options.size() < OPTION_COUNT)
        {
            int r = 5 + RANDOM.nextInt(40);
            String opt = listToCommaString(FactorQuestionGenerator.getFactors(r));
            if (!options.contains(opt))
            {
                options.add(opt);
            }
        }

        Collections.shuffle(options, RANDOM);
        return options.toArray(new String[0]);
    }

    private static String listToCommaString(List<Integer> list)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            if (i > 0)
            {
                sb.append(", ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }


    // =========================================================
    // GET NON-FACTORS
    // =========================================================

    private static List<Integer> getNonFactors(
            int number,
            List<Integer> factors)
    {
        List<Integer> nonFactors =
                new ArrayList<>();

        /*
         * We prefer choices between
         * 1 and number.
         *
         * This gives child-friendly distractors such as:
         *
         * Factors of 10:
         * 1, 2, 5, 10
         *
         * Non-factors:
         * 3, 4, 6, 7, 8, 9
         */
        for (int i = 1;
             i <= number;
             i++)
        {
            if (!factors.contains(i))
            {
                nonFactors.add(i);
            }
        }

        // If we don't have enough non-factors (need at least 3 for distractors),
        // look beyond the number itself.
        int candidate = number + 1;
        while (nonFactors.size() < OPTION_COUNT)
        {
            if (!factors.contains(candidate))
            {
                nonFactors.add(candidate);
            }
            candidate++;
        }

        return nonFactors;
    }


    // =========================================================
    // ADD DISTINCT RANDOM VALUES
    // =========================================================

    private static void addRandomDistinctValues(
            List<Integer> target,
            List<Integer> source,
            int count)
    {
        List<Integer> available =
                new ArrayList<>(source);

        Collections.shuffle(
                available,
                RANDOM);

        for (Integer value : available)
        {
            if (!target.contains(value))
            {
                target.add(value);
            }

            if (target.size() >= count)
            {
                break;
            }
        }
    }


    // =========================================================
    // VALIDATE FACTOR QUESTION
    // =========================================================

    private static void validateExactlyOneFactor(
            int number,
            List<Integer> options)
    {
        if (options.size() < MINIMUM_OPTION_COUNT)
        {
            throw new IllegalStateException(
                    "Expected at least 2 options. Got only " + options.size() + ".");
        }

        int factorCount = 0;

        for (Integer option : options)
        {
            if (FactorQuestionGenerator
                    .isFactor(option, number))
            {
                factorCount++;
            }
        }

        if (factorCount != 1)
        {
            throw new IllegalStateException(
                    "Factor question must have "
                            + "exactly one correct option.");
        }
    }


    // =========================================================
    // VALIDATE NOT-FACTOR QUESTION
    // =========================================================

    private static void validateExactlyOneNonFactor(
            int number,
            List<Integer> options)
    {
        if (options.size() < MINIMUM_OPTION_COUNT)
        {
            throw new IllegalStateException(
                    "Expected at least 2 options, got only " + options.size() + ".");
        }

        int nonFactorCount = 0;

        for (Integer option : options)
        {
            if (!FactorQuestionGenerator
                    .isFactor(option, number))
            {
                nonFactorCount++;
            }
        }

        if (nonFactorCount != 1)
        {
            throw new IllegalStateException(
                    "NOT-factor question must have "
                            + "exactly one correct option.");
        }
    }


    // =========================================================
    // VALIDATE COMMON FACTOR QUESTION
    // =========================================================

    private static void validateExactlyOneCommonFactor(
            int number1,
            int number2,
            List<Integer> options)
    {
        if (options.size() < MINIMUM_OPTION_COUNT)
        {
            throw new IllegalStateException(
                    "Expected at least 2 options, contains only " + options.size());
        }

        int commonFactorCount = 0;

        for (Integer option : options)
        {
            boolean factorOfFirst =
                    FactorQuestionGenerator
                            .isFactor(
                                    option,
                                    number1);

            boolean factorOfSecond =
                    FactorQuestionGenerator
                            .isFactor(
                                    option,
                                    number2);

            if (factorOfFirst
                    && factorOfSecond)
            {
                commonFactorCount++;
            }
        }

        if (commonFactorCount != 1)
        {
            throw new IllegalStateException(
                    "Common-factor question must have "
                            + "exactly one correct option.");
        }
    }


    // =========================================================
    // CONVERT TO STRING[]
    // =========================================================

    private static String[] toStringArray(
            List<Integer> options)
    {
        String[] result =
                new String[options.size()];

        for (int i = 0;
             i < options.size();
             i++)
        {
            result[i] =
                    String.valueOf(
                            options.get(i));
        }

        return result;
    }
}