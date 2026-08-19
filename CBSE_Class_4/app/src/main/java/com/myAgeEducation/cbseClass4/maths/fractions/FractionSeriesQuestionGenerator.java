package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbsecommon.Question;
import java.util.Random;

public class FractionSeriesQuestionGenerator
{
    private static final String[] IMAGES = {
            "thinking_owl",
            "blue_bird",
            "kitten",
            "panda",
            "tortoise",
            "puppy"
    };

    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        FractionSeriesGenerator.FractionSeriesQuestionType[] types =
                FractionSeriesGenerator.FractionSeriesQuestionType.values();

        FractionSeriesGenerator.FractionSeriesQuestionType type =
                types[RANDOM.nextInt(types.length)];

        return generateQuestion(type);
    }

    private static Question generateQuestion(FractionSeriesGenerator.FractionSeriesQuestionType type)
    {
        FractionSeriesGenerator.FractionSeriesOrder order;
        FractionSeriesData data;

        switch(type)
        {
            case IN_ASCENDING:
                data = FractionSeriesGenerator.generateInAscendingQuestion();
                break;

            case NOT_IN_ASCENDING:
                data = FractionSeriesGenerator.generateNotInAscendingQuestion();
                break;

            case IN_DESCENDING:
                data = FractionSeriesGenerator.generateInDescendingQuestion();
                break;

            case NOT_IN_DESCENDING:
                data = FractionSeriesGenerator.generateNotInDescendingQuestion();
                break;

            default:
                throw new IllegalArgumentException();
        }

        Question question = new Question();

        question.setQuestion(getQuestionText(type));

        question.setOption1("Fraction Series 1");
        question.setOption2("Fraction Series 2");
        question.setOption3("Fraction Series 3");
        question.setOption4("Fraction Series 4");

        question.setAnswer("Fraction Series " + (data.correctOptionIndex + 1));

        question.setSupportiveText(createSupportiveText(data));

        return question;
    }

    private static String getQuestionText(FractionSeriesGenerator.FractionSeriesQuestionType type)
    {
        switch (type)
        {
            case IN_ASCENDING:
                return "Which one of the fraction series given below is in ascending order?";

            case NOT_IN_ASCENDING:
                return "Which one of the fraction series given below is NOT in ascending order?";

            case IN_DESCENDING:
                return "Which one of the fraction series given below is in descending order?";

            case NOT_IN_DESCENDING:
                return "Which one of the fraction series given below is NOT in descending order?";

            default:
                return "";
        }
    }

    private static String createSupportiveText(FractionSeriesData data)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++)
        {
            sb.append("Fraction Series ")
                    .append(i + 1)
                    .append(":\n");

            sb.append("====================\n");

            FractionData[] series = data.series[i];

            for (int j = 0; j < series.length; j++)
            {
                sb.append(series[j].numerator)
                        .append("/")
                        .append(series[j].denominator);

                if (j != series.length - 1)
                {
                    sb.append("   ");
                }
            }

            sb.append("\n\n");
        }

        return sb.toString();
    }
}