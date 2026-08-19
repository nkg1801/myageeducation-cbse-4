package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FractionTimeStoryQuestionGenerator
{
    public static Question generateQuestion()
    {
        // Generate question data

        FractionTimeStoryData data =
                FractionTimeStoryGenerator.generate();

        // Generate question text
        String questionText =
                FractionTimeStoryGenerator.generateQuestionText(data);

        // Generate four options
        List<String> options =
                generateOptions(
                        data.answerTime,
                        data.timeUnit);

        // Correct answer
        String answer =
                formatTime(
                        data.answerTime,
                        data.timeUnit);

        // Create Question
        Question question = new Question();

        question.setQuestion(questionText);

        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));

        question.setAnswer(answer);

        return question;
    }


    private static List<String> generateOptions(
            int correctAnswer,
            String timeUnit)
    {
        Set<Integer> values =
                new LinkedHashSet<>();

        // Add correct answer
        values.add(correctAnswer);

        int step;

        if (timeUnit.equals("hours"))
        {
            step = 1;
        }
        else
        {
            // Minutes: options differ by 5 minutes
            step = 5;
        }

        // Add nearby values
        if (correctAnswer - step > 0)
        {
            values.add(correctAnswer - step);
        }

        values.add(correctAnswer + step);
        values.add(correctAnswer + (2 * step));

        // Safety fallback
        int value = correctAnswer + (3 * step);

        while (values.size() < 4)
        {
            values.add(value);
            value += step;
        }

        List<String> options =
                new ArrayList<>();

        for (int optionValue : values)
        {
            options.add(
                    formatTime(
                            optionValue,
                            timeUnit));
        }

        Collections.shuffle(options);

        return options;
    }


    private static String formatTime(
            int value,
            String timeUnit)
    {
        if (timeUnit.equals("hours"))
        {
            return value == 1
                    ? "1 hour"
                    : value + " hours";
        }

        return value == 1
                ? "1 minute"
                : value + " minutes";
    }
}