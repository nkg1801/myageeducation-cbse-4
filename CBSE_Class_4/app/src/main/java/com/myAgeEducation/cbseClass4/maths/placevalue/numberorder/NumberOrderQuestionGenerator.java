package com.myAgeEducation.cbseClass4.maths.placevalue.numberorder;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberOrderQuestionGenerator
{
    public static Question generateQuestion()
    {
        NumberOrderData data = NumberOrderDataGenerator.generate();
        String questionText = buildQuestionText(data);
        String[] options = generateOptions();
        String correctAnswer = getCorrectAnswer(data.type, options);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }

    private static String getCorrectAnswer(NumberOrderQuestionType type, String[] options)
    {
        for (String option : options)
        {
            if (type == NumberOrderQuestionType.INCREASING && (option.equals("increasing order") || option.equals("ascending order")))
            {
                return option;
            }

            if (type == NumberOrderQuestionType.DECREASING && (option.equals("decreasing order") || option.equals("descending order")))
            {
                return option;
            }
        }

        throw new IllegalStateException("Correct option not found");
    }

    private static String[] generateOptions()
    {
        final Random RANDOM = new Random();
        List<String> options = new ArrayList<>();

        if (RANDOM.nextBoolean())
        {
            options.add("ascending order");
            options.add("descending order");
        }
        else
        {
            options.add("increasing order");
            options.add("decreasing order");
        }

        Collections.shuffle(options);
        return options.toArray(new String[0]);
    }

    private static String buildQuestionText(NumberOrderData data)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The series: ");

        for (int i = 0; i < data.numbers.length; i++)
        {
            if (i > 0)
            {
                builder.append("; ");
            }
            builder.append(NumberFormatUtil.formatIndianNumber(data.numbers[i]));
        }

        builder.append(" is in -");
        return builder.toString();
    }
}
