package com.myAgeEducation.cbseClass4.maths.divisions.story;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DivisionStoryQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private DivisionStoryQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        DivisionStoryQuestionData data = DivisionStoryDataGenerator.generate();
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(String.valueOf(data.answer));
        return question;
    }

    private static String[] generateOptions(DivisionStoryQuestionData data)
    {
        switch (data.template.type)
        {
            case BASIC_DIVISION:
            case HOW_MANY_GROUPS:
            case EQUAL_GROUPING:
            case REPEATED_SUBTRACTION:
            case EQUAL_SHARING:
                return createDivisionOptions(data);

            case DIFFERENCE_SHARING:
                return createDifferenceSharingOptions(data);

            default:
                throw new IllegalArgumentException("Unknown division type");
        }
    }

    private static String[] createDivisionOptions(DivisionStoryQuestionData data)
    {
        Set<String> options = new LinkedHashSet<>();
        int divisor = data.divisor;
        int answer = data.answer;
        options.add(String.valueOf(answer));
        addOption(options, answer - 1);
        addOption(options, answer + 1);
        addOption(options, answer - 2);
        addOption(options, answer + 2);

        addOption(options, data.dividend / (divisor + 1));

        if (divisor > 2)
        {
            addOption(options,data.dividend / (divisor - 1));
        }

        return finalizeOptions(options, String.valueOf(answer));
    }

    private static String[] finalizeOptions(Set<String> options, String correctAnswer)
    {
        List<String> list = new ArrayList<>(options);

        // Never remove the correct answer
        while (list.size() > 4)
        {
            int index = RANDOM.nextInt(list.size());

            if (!list.get(index).equals(correctAnswer))
            {
                list.remove(index);
            }
        }

        while (list.size() < 4)
        {
            String option = String.valueOf(RANDOM.nextInt(300) + 1);

            if (!list.contains(option))
            {
                list.add(option);
            }
        }

        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

    private static void addOption(Set<String> options, int value)
    {
        if (value > 0)
        {
            options.add(String.valueOf(value));
        }
    }

    private static String[] createDifferenceSharingOptions(DivisionStoryQuestionData data)
    {
        return createDivisionOptions(data);
    }
}
