package com.myAgeEducation.cbseClass4.maths.additions;

import com.myAgeEducation.cbseClass4.OptionUtil;
import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class AdditionQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private AdditionQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        int type = RANDOM.nextInt(2);
        if (type == 0)
        {
            return generateTwoNumbersAddition();
        }
        else
        {
            return generateThreeNumbersAddition();
        }
    }

    private static Question generateTwoNumbersAddition()
    {
        int num1 = getRandomNumber();
        int num2 = getRandomNumber();
        int answer = num1 + num2;

        String questionText = String.format("%s + %s = ______",
                NumberFormatUtil.formatIndianNumber(num1),
                NumberFormatUtil.formatIndianNumber(num2));

        return createQuestion(questionText, answer);
    }

    private static Question generateThreeNumbersAddition()
    {
        int num1 = getRandomNumber();
        int num2 = getRandomNumber();
        int num3 = getRandomNumber();
        int answer = num1 + num2 + num3;

        String questionText = String.format("%s + %s + %s = ______",
                NumberFormatUtil.formatIndianNumber(num1),
                NumberFormatUtil.formatIndianNumber(num2),
                NumberFormatUtil.formatIndianNumber(num3));

        return createQuestion(questionText, answer);
    }

    private static Question createQuestion(String questionText, int answer)
    {
        String correctAnswer = NumberFormatUtil.formatIndianNumber(answer);
        String[] options = generateOptions(answer);

        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }

    private static int getRandomNumber()
    {
        // Generating numbers up to 5-digits as per user examples (e.g., 36879)
        return RANDOM.nextInt(90000) + 10000;
    }

    private static String[] generateOptions(int correctAnswer)
    {
        Set<String> distractors = new LinkedHashSet<>();
        distractors.add(NumberFormatUtil.formatIndianNumber(correctAnswer + 1));
        distractors.add(NumberFormatUtil.formatIndianNumber(correctAnswer - 1));
        distractors.add(NumberFormatUtil.formatIndianNumber(correctAnswer + 10));
        distractors.add(NumberFormatUtil.formatIndianNumber(correctAnswer - 10));
        distractors.add(NumberFormatUtil.formatIndianNumber(correctAnswer + 100));
        distractors.add(NumberFormatUtil.formatIndianNumber(correctAnswer - 100));
        distractors.add(NumberFormatUtil.formatIndianNumber(correctAnswer + 2));

        return OptionUtil.createOptions(NumberFormatUtil.formatIndianNumber(correctAnswer), distractors, 4);
    }
}