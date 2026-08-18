package com.myAgeEducation.cbseClass4.maths.placevalue.greatestsmallest;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreatestSmallestQuestionGenerator
{
    private GreatestSmallestQuestionGenerator()
    {
        // Prevent object creation
    }

    public static Question generateQuestion()
    {
        GreatestSmallestQuestionData data = GreatestSmallestDataGenerator.generate();
        String questionText = buildQuestionText(data);
        //String correctAnswer =  String.valueOf(getCorrectAnswer(data));
        String correctAnswer =  NumberFormatUtil.formatIndianNumber(getCorrectAnswer(data));
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }

    private static String buildQuestionText(GreatestSmallestQuestionData data)
    {
        if (data.type == GreatestSmallestQuestionType.GREATEST)
        {
            return "Select the greatest number";
        }
        else
        {
            return "Select the smallest number";
        }
    }

    private static String[] generateOptions(GreatestSmallestQuestionData data)
    {
        List<String> options = new ArrayList<>();

        for (int number : data.numbers)
        {
            String numberWithComma = NumberFormatUtil.formatIndianNumber(number);
            //options.add(String.valueOf(number));
            options.add(numberWithComma);
        }

        Collections.shuffle(options);
        return options.toArray(new String[0]);
    }

    private static int getCorrectAnswer(GreatestSmallestQuestionData data)
    {
        int answer = data.numbers[0];

        for (int i = 1; i < data.numbers.length; i++)
        {
            if (data.type == GreatestSmallestQuestionType.GREATEST)
            {
                if (data.numbers[i] > answer)
                {
                    answer = data.numbers[i];
                }
            }
            else
            {
                if (data.numbers[i] < answer)
                {
                    answer = data.numbers[i];
                }
            }
        }

        return answer;
    }
}