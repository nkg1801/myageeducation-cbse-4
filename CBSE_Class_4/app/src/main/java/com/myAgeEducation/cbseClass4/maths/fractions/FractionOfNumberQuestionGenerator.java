package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.List;
import java.util.Random;

public class FractionOfNumberQuestionGenerator
{
    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        FractionOfNumberData data = FractionOfNumberGenerator.generate();

        String questionText = generateQuestionText(data);

        List<String> options =
                OptionUtils.generateNumberOptions(
                        data.answer,
                        data.total);

        Question question = new Question();

        question.setQuestion(questionText);

        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));

        question.setAnswer(
                String.valueOf(data.answer));

        return question;
    }

    private static String fractionToWords(int numerator, int denominator)
    {
        if (numerator == 1)
        {
            switch (denominator)
            {
                case 2:
                    return "half";

                case 3:
                    return "one third";

                case 4:
                    return "one fourth";

                case 5:
                    return "one fifth";

                case 6:
                    return "one sixth";
            }
        }

        return numerator + "/" + denominator;
    }

    private static String capitalize(String text)
    {
        if (text == null || text.isEmpty()) {
            return text;
        }

        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    private static String generateQuestionText(FractionOfNumberData data)
    {
        String fraction = fractionToWords(data.numerator, data.denominator);
        int variant = RANDOM.nextInt(6);

        switch (variant)
        {
            case 0:
                return capitalize(fraction) + " of " + data.total + " is _____.";

            case 1:
                return "Find " + fraction + " of " + data.total + ".";

            case 2:
                return "What is " + fraction + " of " + data.total + "?";

            case 3:
                return capitalize(fraction) + " of the number " + data.total + " is _____.";

            case 4:
                return "Calculate " + fraction + " of " + data.total + ".";

            case 5:
                return "How much is " + fraction + " of " + data.total + "?";

            default:
                throw new IllegalStateException();
        }
    }
}