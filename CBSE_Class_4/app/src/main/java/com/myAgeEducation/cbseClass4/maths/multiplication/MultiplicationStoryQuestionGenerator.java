package com.myAgeEducation.cbseClass4.maths.multiplication;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MultiplicationStoryQuestionGenerator {
    private static final Random RANDOM = new Random();
    private MultiplicationStoryQuestionGenerator() {
    }

    public static Question generateQuestion() {
        MultiplicationStoryQuestionData data = MultiplicationStoryDataGenerator.generate();
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(String.valueOf(data.answer));
        return question;
    }

    private static String[] generateOptions(MultiplicationStoryQuestionData data)
    {
        switch (data.template.type)
        {
            case EQUAL_GROUPS:
                return createEqualGroupsOptions(data);

            case MULTIPLY_BY_10:
                return createMultiplyBy10Options(data);

            case TIME_CONVERSION:
                return createTimeConversionOptions(data);

            case REPEATED_EVENT:
                return createRepeatedEventOptions(data);

            case SCALING:
                return createScalingOptions(data);

            default:
                throw new IllegalArgumentException("Unknown multiplication story type");
        }
    }

    private static String[] createEqualGroupsOptions(MultiplicationStoryQuestionData data)
    {
        return createGeneralMultiplicationOptions(data.firstNumber, data.secondNumber);
    }

    private static String[] createMultiplyBy10Options(MultiplicationStoryQuestionData data)
    {
        Set<String> options = new LinkedHashSet<>();
        int number = data.firstNumber;
        int answer = number * 10;
        options.add(String.valueOf(answer));
        addOption(options, number);
        addOption(options, Integer.parseInt(number + "0") + 10);
        addOption(options, Integer.parseInt("2" + number));
        addOption(options, answer + 10);
        addOption(options, answer - 10);
        return finalizeOptions(options);
    }

    private static String[] createTimeConversionOptions(MultiplicationStoryQuestionData data)
    {
        Set<String> options = new LinkedHashSet<>();
        int weeks = data.firstNumber;
        options.add(String.valueOf(weeks * 7));
        addOption(options, weeks * 5);
        addOption(options, weeks * 6);
        addOption(options, weeks * 8);
        addOption(options, weeks * 9);
        return finalizeOptions(options);
    }

    private static String[] createRepeatedEventOptions(MultiplicationStoryQuestionData data)
    {
        return createGeneralMultiplicationOptions(data.firstNumber, data.secondNumber);
    }

    private static String[] createGeneralMultiplicationOptions(int firstNumber, int secondNumber)
    {
        Set<String> options = new LinkedHashSet<>();
        int answer = firstNumber * secondNumber;

        options.add(String.valueOf(answer));

        // Typical multiplication mistakes
        addOption(options, (firstNumber - 1) * secondNumber);
        addOption(options, (firstNumber + 1) * secondNumber);
        addOption(options, firstNumber * (secondNumber - 1));
        addOption(options, firstNumber * (secondNumber + 1));
        addOption(options, (firstNumber - 1) * (secondNumber - 1));
        addOption(options, (firstNumber + 1) * (secondNumber + 1));
        addOption(options, answer + firstNumber);
        addOption(options, answer - firstNumber);
        addOption(options, answer + secondNumber);
        addOption(options, answer - secondNumber);
        return finalizeOptions(options);
    }

    private static String[] createScalingOptions(MultiplicationStoryQuestionData data)
    {
        Set<String> options = new LinkedHashSet<>();
        int weight = data.firstNumber;
        int factor = data.secondNumber;
        int answer = weight * factor;
        options.add(String.valueOf(answer));
        addOption(options, weight + factor);
        addOption(options, weight * (factor - 1));
        addOption(options, weight * (factor + 1));
        addOption(options, answer + factor);
        return finalizeOptions(options);
    }

    /*private static String[] finalizeOptions(
            Set<String> options)
    {
        List<String> list =
                new ArrayList<>(options);

        Collections.shuffle(list);

        if (list.size() > 4)
        {
            list =
                    list.subList(
                            0,
                            4);
        }

        while (list.size() < 4)
        {
            int value =
                    RANDOM.nextInt(300) + 1;

            String option =
                    String.valueOf(value);

            if (!list.contains(option))
            {
                list.add(option);
            }
        }

        Collections.shuffle(list);

        return list.toArray(new String[0]);
    }*/

    private static String[] finalizeOptions(Set<String> options)
    {
        // First element in the LinkedHashSet is always the correct answer
        String correctAnswer = options.iterator().next();

        List<String> distractors = new ArrayList<>(options);
        distractors.remove(correctAnswer);

        Collections.shuffle(distractors);

        List<String> finalOptions = new ArrayList<>();
        finalOptions.add(correctAnswer);

        while (finalOptions.size() < 4 && !distractors.isEmpty())
        {
            finalOptions.add(distractors.remove(0));
        }

        while (finalOptions.size() < 4)
        {
            String option = String.valueOf(RANDOM.nextInt(300) + 1);

            if (!finalOptions.contains(option))
            {
                finalOptions.add(option);
            }
        }

        Collections.shuffle(finalOptions);
        return finalOptions.toArray(new String[0]);
    }

    private static void addOption(Set<String> options, int value)
    {
        if (value > 0)
        {
            options.add(String.valueOf(value));
        }
    }
}