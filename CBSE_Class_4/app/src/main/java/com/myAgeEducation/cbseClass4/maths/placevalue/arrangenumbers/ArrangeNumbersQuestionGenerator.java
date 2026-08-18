package com.myAgeEducation.cbseClass4.maths.placevalue.arrangenumbers;

import com.myAgeEducation.cbseClass4.OptionUtil;
import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.maths.utils.QuestionTextUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class ArrangeNumbersQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private ArrangeNumbersQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        ArrangeNumbersQuestionData data = ArrangeNumbersDataGenerator.generate();
        String questionText = buildQuestionText(data);
        String correctAnswer = toOptionString(data.arrangedNumbers);
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }

    private static String buildQuestionText(ArrangeNumbersQuestionData data)
    {
        String instruction;

        if (data.ascending)
        {
            instruction =
                    QuestionTextUtil.random(
                            "Arrange in ascending order.",
                            "Write the numbers from smallest to largest.",
                            "Arrange the following numbers in ascending order.");
        }
        else
        {
            instruction =
                    QuestionTextUtil.random(
                            "Arrange in descending order.",
                            "Write the numbers from largest to smallest.",
                            "Arrange the following numbers in descending order.");
        }

        return instruction + "\n\n" + toOptionString(data.originalNumbers);
    }

    private static String toOptionString(int[] numbers)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++)
        {
            if (i > 0)
            {
                builder.append("; ");
            }

            builder.append(NumberFormatUtil.formatIndianNumber(numbers[i]));
        }

        return builder.toString();
    }

    private static String[] generateOptions(ArrangeNumbersQuestionData data)
    {
        String correctAnswer = toOptionString(data.arrangedNumbers);
        Set<String> distractors = new LinkedHashSet<>();

        addAdjacentSwap(distractors, data.arrangedNumbers, 0);

        addAdjacentSwap(
                distractors,
                data.arrangedNumbers,
                1);

        addAdjacentSwap(
                distractors,
                data.arrangedNumbers,
                2);

        // Safety fallback
        while (distractors.size() < 3)
        {
            distractors.add(randomPermutation(data.arrangedNumbers));
        }

        return OptionUtil.createOptions(correctAnswer, distractors,4);
    }

    private static void addAdjacentSwap(Set<String> distractors, int[] numbers, int index)
    {
        int[] copy = numbers.clone();
        int temp = copy[index];
        copy[index] = copy[index + 1];
        copy[index + 1] = temp;
        distractors.add(toOptionString(copy));
    }

    private static String randomPermutation(int[] numbers)
    {
        int[] copy = numbers.clone();

        for (int i = copy.length - 1; i > 0; i--)
        {
            int j = RANDOM.nextInt(i + 1);
            int temp = copy[i];
            copy[i] = copy[j];
            copy[j] = temp;
        }

        return toOptionString(copy);
    }
}
