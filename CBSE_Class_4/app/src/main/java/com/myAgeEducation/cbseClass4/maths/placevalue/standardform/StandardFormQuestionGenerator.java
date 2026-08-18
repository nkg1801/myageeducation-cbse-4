package com.myAgeEducation.cbseClass4.maths.placevalue.standardform;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StandardFormQuestionGenerator
{
    private static final Random RANDOM = new Random();
    private StandardFormQuestionGenerator()
    {
        // Prevent object creation
    }

    public static Question generateQuestion()
    {
        StandardFormQuestionData data = StandardFormDataGenerator.generate();
        String questionText = buildQuestionText(data);
        String correctAnswer = getCorrectAnswer(data);
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }

    private static String buildQuestionText(StandardFormQuestionData data)
    {
        switch (data.type)
        {
            case EXPANDED_TO_STANDARD:
                return "What is the number in standard form: " + data.expandedForm;

            case STANDARD_TO_EXPANDED:
                return "Write the numeral in expanded form: " + NumberFormatUtil.formatIndianNumber(data.number);

            default:
                throw new IllegalArgumentException("Unknown question type: " + data.type);
        }
    }

    private static String[] generateOptions(StandardFormQuestionData data)
    {
        switch (data.type)
        {
            case EXPANDED_TO_STANDARD:
                return generateStandardFormOptions(data);

            case STANDARD_TO_EXPANDED:
                return generateExpandedFormOptions(data);

            default:
                throw new IllegalArgumentException("Unknown question type: " + data.type);
        }
    }

    private static String[] generateExpandedFormOptions(StandardFormQuestionData data)
    {
        Set<String> options = new LinkedHashSet<>();

        options.add(data.expandedForm);

        int[] placeChanges =
                {
                        -1000, 1000,
                        -100, 100,
                        -10, 10,
                        -1, 1
                };

        List<Integer> changes = new ArrayList<>();

        for (int change : placeChanges)
        {
            changes.add(change);
        }

        Collections.shuffle(changes);

        for (int change : changes)
        {
            int wrongNumber = data.number + change;

            if (wrongNumber >= 1000 && wrongNumber <= 9999 && wrongNumber != data.number)
            {
                String wrongExpandedForm = StandardFormDataGenerator.getExpandedForm(wrongNumber);
                options.add(wrongExpandedForm);
            }

            if (options.size() == 4)
            {
                break;
            }
        }

        // Safety fallback
        while (options.size() < 4)
        {
            int wrongNumber = 1000 + RANDOM.nextInt(9000);

            if (wrongNumber != data.number)
            {
                options.add(StandardFormDataGenerator.getExpandedForm(wrongNumber));
            }
        }

        List<String> optionList = new ArrayList<>(options);
        Collections.shuffle(optionList);
        return optionList.toArray(new String[0]);
    }

    private static String[] generateStandardFormOptions(StandardFormQuestionData data)
    {
        Set<Integer> values = new LinkedHashSet<>();
        int number = data.number;
        values.add(number);
        int thousands = number / 1000;
        int hundreds = (number / 100) % 10;
        int tens = (number / 10) % 10;
        int ones = number % 10;

        // Swap hundreds and tens
        addIfValid(values, thousands * 1000 + tens * 100 + hundreds * 10 + ones, number);

        // Swap tens and ones
        addIfValid(values, thousands * 1000 + hundreds * 100 + ones * 10 + tens, number);

        // Shift the number one place to the right
        addIfValid(values, number / 10, number);

        // Shift the number one place to the left
        addIfValid(values, number * 10, number);

        // Safety fallback
        // Safety fallback
        while (values.size() < 4)
        {
            int placeValue = (int) Math.pow(10, RANDOM.nextInt(4));
            int optionValue = RANDOM.nextBoolean() ? number + placeValue : number - placeValue;
            addIfValid(values, optionValue, number);
        }

        Set<String> distractors = new LinkedHashSet<>();

        for (Integer value : values)
        {
            distractors.add(NumberFormatUtil.formatIndianNumber(value));
        }
        //return createOptions(String.valueOf(number), distractors,4);
        return createOptions(NumberFormatUtil.formatIndianNumber(number), distractors,4);
    }

    /*private static String[] generateStandardFormOptions(StandardFormQuestionData data)
    {
        int number = data.number;

        int thousands = number / 1000;
        int hundreds = (number / 100) % 10;
        int tens = (number / 10) % 10;
        int ones = number % 10;

        Set<Integer> distractors =
                new LinkedHashSet<>();

        // Swap hundreds and tens
// Swap hundreds and tens
        addIfValid(
                distractors,
                thousands * 1000
                        + tens * 100
                        + hundreds * 10
                        + ones,
                number);

// Swap tens and ones
        addIfValid(
                distractors,
                thousands * 1000
                        + hundreds * 100
                        + ones * 10
                        + tens,
                number);

// Shift right
        addIfValid(
                distractors,
                number / 10,
                number);

// Shift left
        addIfValid(
                distractors,
                number * 10,
                number);

        // Safety fallback
        while (distractors.size() < 3)
        {
            int placeValue =
                    (int) Math.pow(
                            10,
                            RANDOM.nextInt(4));

            int optionValue =
                    RANDOM.nextBoolean()
                            ? number + placeValue
                            : number - placeValue;

            addIfValid(values, optionValue, number);
        }

        List<String> options =
                new ArrayList<>();

// Always add the correct answer first
        options.add(String.valueOf(number));

        List<Integer> distractorList =
                new ArrayList<>(distractors);

        Collections.shuffle(distractorList);

// Add only three distractors
        for (int i = 0; i < 3; i++)
        {
            options.add(
                    String.valueOf(
                            distractorList.get(i)));
        }

        Collections.shuffle(options);

        Log.d("NKG:", "Correct number = " + number);
        Log.d("NKG:", "Options = " + options);

        return options.toArray(new String[0]);
    }*/

    private static String[] createOptions(String correctAnswer, Collection<String> distractors, int requiredOptions)
    {
        List<String> distractorList = new ArrayList<>(distractors);

        // Remove the correct answer if it accidentally exists
        distractorList.remove(correctAnswer);

        Collections.shuffle(distractorList);

        List<String> options = new ArrayList<>();

        options.add(correctAnswer);

        for (int i = 0;
             i < requiredOptions - 1 && i < distractorList.size();
             i++)
        {
            options.add(distractorList.get(i));
        }

        if (options.size() != requiredOptions)
        {
            throw new IllegalStateException(
                    "Expected "
                            + requiredOptions
                            + " options but found "
                            + options.size());
        }

        Collections.shuffle(options);

        return options.toArray(new String[0]);
    }

    private static void addIfValid(
            Set<Integer> values,
            int optionValue,
            int correctAnswer)
    {
        if (optionValue > 0 && optionValue != correctAnswer)
        {
            values.add(optionValue);
        }
    }

    private static String getCorrectAnswer(StandardFormQuestionData data)
    {
        switch (data.type)
        {
            case EXPANDED_TO_STANDARD:
                //return String.valueOf(data.number);
                return NumberFormatUtil.formatIndianNumber(data.number);

            case STANDARD_TO_EXPANDED:
                return data.expandedForm;

            default:
                throw new IllegalArgumentException("Unknown question type: " + data.type);
        }
    }
}
