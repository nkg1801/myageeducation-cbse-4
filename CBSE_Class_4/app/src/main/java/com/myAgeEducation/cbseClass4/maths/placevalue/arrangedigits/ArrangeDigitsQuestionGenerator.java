package com.myAgeEducation.cbseClass4.maths.placevalue.arrangedigits;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ArrangeDigitsQuestionGenerator
{
    public static Question generateQuestion()
    {
        ArrangeDigitsQuestionData data = generate();
        Question question = new Question();
        question.setQuestion(data.questionText);
        OptionUtils.setQuestionOptions(question, data.options);
        question.setAnswer(data.correctAnswer);
        return question;
    }

    private static ArrangeDigitsQuestionData generate()
    {
        ArrangeDigitsQuestionData data = generateQuestionData();
        data.options = generateOptions(data);
        return data;
    }

    private static String[] generateOptions(ArrangeDigitsQuestionData questionData)
    {
        Set<String> options = new LinkedHashSet<>();

        // Add correct answer
        options.add(questionData.correctAnswer);

        // Keep generating different arrangements
        // of the same digits until we have 4 options.

        while (options.size() < 4)
        {
            int[] shuffledDigits = questionData.digits.clone();

            shuffleDigits(shuffledDigits);

            // A number cannot start with 0
            if (shuffledDigits[0] == 0)
            {
                continue;
            }
            options.add(digitsToString(shuffledDigits));
        }

        // Shuffle option positions

        List<String> optionList = new ArrayList<>(options);
        Collections.shuffle(optionList);
        return optionList.toArray(new String[0]);
    }

    private static void shuffleDigits(int[] digits)
    {
        for (int i = digits.length - 1; i > 0; i--)
        {
            int j = RANDOM.nextInt(i + 1);
            int temp = digits[i];
            digits[i] = digits[j];
            digits[j] = temp;
        }
    }

    private static String digitsToString(int[] digits)
    {
        StringBuilder result = new StringBuilder();
        for (int digit : digits)
        {
            result.append(digit);
        }
        //return result.toString();
        return NumberFormatUtil.formatIndianNumber(Integer.parseInt(result.toString()));
    }

    private static ArrangeDigitsQuestionData generateQuestionData()
    {
        // Generate random unique digits
        int[] digits = generateDigits();

        // Randomly choose GREATEST or SMALLEST
        ArrangeDigitsQuestionType[] types = ArrangeDigitsQuestionType.values();
        ArrangeDigitsQuestionType type = types[RANDOM.nextInt(types.length)];

        // Convert digits to display text
        String digitsText = formatDigits(digits);
        String questionText;
        String correctAnswer;

        switch (type)
        {
            case GREATEST:
                questionText = "Write the greatest number by using: " + digitsText;
                correctAnswer = getGreatestNumber(digits);
                break;

            case SMALLEST:
                questionText = "Write the smallest number by using: " + digitsText;
                correctAnswer = getSmallestNumber(digits);
                break;

            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
        return new ArrangeDigitsQuestionData(type, digits, questionText, correctAnswer);
    }

    private static String formatDigits(int[] digits)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++)
        {
            if (i > 0)
            {
                result.append(", ");
            }
            result.append(digits[i]);
        }
        return result.toString();
        //return NumberFormatUtil.formatIndianNumber(Integer.parseInt(result.toString()));
    }

    private static String getGreatestNumber(int[] digits)
    {
        int[] sortedDigits = digits.clone();

        Arrays.sort(sortedDigits);

        StringBuilder result = new StringBuilder();

        for (int i = sortedDigits.length - 1; i >= 0; i--)
        {
            result.append(sortedDigits[i]);
        }

        return NumberFormatUtil.formatIndianNumber(Integer.parseInt(result.toString()));

        //return result.toString();
    }

    private static String getSmallestNumber(int[] digits)
    {
        int[] sortedDigits = digits.clone();

        Arrays.sort(sortedDigits);

        // If the first digit is 0,
        // swap it with the first non-zero digit.

        if (sortedDigits[0] == 0)
        {
            for (int i = 1; i < sortedDigits.length; i++)
            {
                if (sortedDigits[i] != 0)
                {
                    int temp = sortedDigits[0];
                    sortedDigits[0] = sortedDigits[i];
                    sortedDigits[i] = temp;
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int digit : sortedDigits)
        {
            result.append(digit);
        }

        return NumberFormatUtil.formatIndianNumber(Integer.parseInt(result.toString()));
        //return result.toString();
    }

    private static int[] generateDigits()
    {
        int digitCount = MIN_DIGITS + RANDOM.nextInt(MAX_DIGITS - MIN_DIGITS + 1);

        List<Integer> availableDigits = new ArrayList<>();

        for (int digit = 0; digit <= 9; digit++)
        {
            availableDigits.add(digit);
        }

        Collections.shuffle(availableDigits);
        int[] digits = new int[digitCount];

        for (int i = 0; i < digitCount; i++)
        {
            digits[i] = availableDigits.get(i);
        }

        return digits;
    }

    private static final Random RANDOM = new Random();

    private static final int MIN_DIGITS = 4;
    private static final int MAX_DIGITS = 7;


    private ArrangeDigitsQuestionGenerator()
    {
        // Prevent object creation
    }
}