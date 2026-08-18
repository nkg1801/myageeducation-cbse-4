package com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberComparisonDataGenerator
{
    private static final Random RANDOM = new Random();

    private static final int MIN_VALUE = 1000;
    private static final int MAX_VALUE = 9999999;


    private NumberComparisonDataGenerator()
    {
    }

    private static List<ComparisonStatement> generateComparisonStatements(int[] numbers)
    {
        List<ComparisonStatement> statements = new ArrayList<>();

        for (int i = 0; i < numbers.length - 1; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                int smaller =
                        Math.min(
                                numbers[i],
                                numbers[j]);

                int larger =
                        Math.max(
                                numbers[i],
                                numbers[j]);

                // TRUE <
                statements.add(
                        new ComparisonStatement(
                                smaller,
                                larger,
                                ComparisonOperator.LESS_THAN,
                                true));

                // FALSE >
                statements.add(
                        new ComparisonStatement(
                                smaller,
                                larger,
                                ComparisonOperator.GREATER_THAN,
                                false));

                // TRUE >
                statements.add(
                        new ComparisonStatement(
                                larger,
                                smaller,
                                ComparisonOperator.GREATER_THAN,
                                true));

                // FALSE <
                statements.add(
                        new ComparisonStatement(
                                larger,
                                smaller,
                                ComparisonOperator.LESS_THAN,
                                false));
            }
        }

        Collections.shuffle(statements);

        return statements;
    }

    private static String toStatement(ComparisonStatement statement)
    {
        String symbol =
                statement.operator ==
                        ComparisonOperator.LESS_THAN
                        ? "<"
                        : ">";

        return NumberFormatUtil.formatIndianNumber(statement.left)
                + " "
                + symbol
                + " "
                + NumberFormatUtil.formatIndianNumber(statement.right);
    }

    public static NumberComparisonQuestionData generate()
    {
        ComparisonQuestionType questionType =
                RANDOM.nextBoolean()
                        ? ComparisonQuestionType.WHICH_IS_TRUE
                        : ComparisonQuestionType.WHICH_IS_FALSE;

        int[] numbers = generateSimilarNumbers();

        List<ComparisonStatement> allStatements = generateComparisonStatements(numbers);
        List<ComparisonStatement> trueStatements = new ArrayList<>();
        List<ComparisonStatement> falseStatements = new ArrayList<>();

        for (ComparisonStatement statement : allStatements)
        {
            if (statement.isTrue)
            {
                trueStatements.add(statement);
            }
            else
            {
                falseStatements.add(statement);
            }
        }

        Collections.shuffle(trueStatements);
        Collections.shuffle(falseStatements);
        List<String> options = new ArrayList<>();
        String correctAnswer;

        if (questionType == ComparisonQuestionType.WHICH_IS_TRUE)
        {
            correctAnswer = toStatement(trueStatements.get(0));

            options.add(correctAnswer);

            for (int i = 0; i < 3; i++)
            {
                options.add(toStatement(falseStatements.get(i)));
            }
        }
        else
        {
            correctAnswer =toStatement(falseStatements.get(0));
            options.add(correctAnswer);

            for (int i = 0; i < 3; i++)
            {
                options.add(toStatement(trueStatements.get(i)));
            }
        }

        Collections.shuffle(options);

        return new NumberComparisonQuestionData(
                options.toArray(new String[0]),
                correctAnswer,
                questionType);
    }

    static int[] generateSimilarNumbers()
    {
        while (true)
        {
            int base =
                    randomNumber();

            int[] digits =
                    {
                            base / 1000,
                            (base / 100) % 10,
                            (base / 10) % 10,
                            base % 10
                    };

            int changingPosition =
                    RANDOM.nextInt(4);

            int originalDigit =
                    digits[changingPosition];

            List<Integer> possibleDigits =
                    new ArrayList<>();

            // Build consecutive digits around the original digit
            for (int d = originalDigit - 3;
                 d <= originalDigit + 3;
                 d++)
            {
                if (changingPosition == 0)
                {
                    if (d >= 1 && d <= 9)
                    {
                        possibleDigits.add(d);
                    }
                }
                else
                {
                    if (d >= 0 && d <= 9)
                    {
                        possibleDigits.add(d);
                    }
                }
            }

            if (possibleDigits.size() < 4)
            {
                continue;
            }

            Collections.shuffle(possibleDigits);

            possibleDigits =
                    possibleDigits.subList(0, 4);

            Collections.sort(possibleDigits);

            int[] result =
                    new int[4];

            for (int i = 0; i < 4; i++)
            {
                int[] newDigits =
                        digits.clone();

                newDigits[changingPosition] =
                        possibleDigits.get(i);

                result[i] =
                        newDigits[0] * 1000
                                + newDigits[1] * 100
                                + newDigits[2] * 10
                                + newDigits[3];
            }

            return result;
        }
    }


    private static String generateStatement(
            boolean shouldBeTrue,
            ComparisonOperator operator,
            int[] numbers)
    {
        // Pick two different numbers from the generated set
        int firstIndex =
                RANDOM.nextInt(numbers.length);

        int secondIndex;

        do
        {
            secondIndex =
                    RANDOM.nextInt(numbers.length);
        }
        while (secondIndex == firstIndex);

        int first =
                numbers[firstIndex];

        int second =
                numbers[secondIndex];

        if (operator == ComparisonOperator.LESS_THAN)
        {
            if (shouldBeTrue)
            {
                if (first > second)
                {
                    int temp = first;
                    first = second;
                    second = temp;
                }

                return first + " < " + second;
            }
            else
            {
                if (first < second)
                {
                    int temp = first;
                    first = second;
                    second = temp;
                }

                return first + " < " + second;
            }
        }
        else
        {
            if (shouldBeTrue)
            {
                if (first < second)
                {
                    int temp = first;
                    first = second;
                    second = temp;
                }

                return first + " > " + second;
            }
            else
            {
                if (first > second)
                {
                    int temp = first;
                    first = second;
                    second = temp;
                }

                return first + " > " + second;
            }
        }
    }


    private static int randomNumber()
    {
        return MIN_VALUE
                + RANDOM.nextInt(
                MAX_VALUE
                        - MIN_VALUE
                        + 1);
    }

    private static class ComparisonStatement
    {
        final int left;
        final int right;
        final ComparisonOperator operator;
        final boolean isTrue;

        ComparisonStatement(int left, int right, ComparisonOperator operator, boolean isTrue)
        {
            this.left = left;
            this.right = right;
            this.operator = operator;
            this.isTrue = isTrue;
        }
    }
}
