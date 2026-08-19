package com.myAgeEducation.cbseClass4.maths.circlegraph;

import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeType;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import java.util.Random;

public class CircleGraphQuestionGenerator
{
    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        CircleGraphQuestionData data = CircleGraphQuestionGenerator.generate();
        String[] options = CircleGraphOptionGenerator.generateOptions(data);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(data.correctAnswer);
        question.setImage(createImageCode(data.graphData));
        return question;
    }

    private static CircleGraphQuestionData generate()
    {
        int type = RANDOM.nextInt(4);

        switch (type)
        {
            case 0:
                return generateFractionQuestion();
            case 1:
                return generateMostQuestion();
            case 2:
                return generateLeastQuestion();
            /*case 3:
                return generateDifferenceQuestion();*/
            default:
                return generateSameValueQuestion();
        }
    }

    private static CircleGraphQuestionData generateFractionQuestion()
    {
        CircleGraphData data = CircleGraphDataGenerator.generateForFractionQuestion();
        int index = RANDOM.nextInt(data.labels.length);
        String question = "What fraction of the circle represents " + data.labels[index] + "?";
        String answer = data.fractionNames[index];
        return new CircleGraphQuestionData(data, CircleGraphQuestionType.IDENTIFY_FRACTION, question, answer);
    }

    private static CircleGraphQuestionData generateMostQuestion()
    {
        CircleGraphData data = CircleGraphDataGenerator.generateForMostQuestion();
        int index = getMostIndex(data);
        String question = "Which category represents the greatest part of the circle?";
        String answer = data.labels[index];
        return new CircleGraphQuestionData(data, CircleGraphQuestionType.IDENTIFY_MOST, question, answer);
    }

    private static CircleGraphQuestionData generateLeastQuestion()
    {
        CircleGraphData data = CircleGraphDataGenerator.generateForLeastQuestion();
        int index = getLeastIndex(data);
        String question = "Which category represents the smallest part of the circle?";
        String answer = data.labels[index];
        return new CircleGraphQuestionData(data, CircleGraphQuestionType.IDENTIFY_LEAST, question, answer);
    }

    /*private static CircleGraphQuestionData generateDifferenceQuestion()
    {
        CircleGraphData data = CircleGraphDataGenerator.generateForComparisonQuestion();
        int first = RANDOM.nextInt(data.labels.length);
        int second;

        do
        {
            second = RANDOM.nextInt(data.labels.length);
        }
        while (second == first);

        int difference = Math.abs(data.values[first] - data.values[second]);
        String answer = getFractionName(difference,data.total);

        String question =
                "What fraction of the circle is the difference between "
                        + data.labels[first]
                        + " and "
                        + data.labels[second]
                        + "?";

        return new CircleGraphQuestionData(data, CircleGraphQuestionType.DIFFERENCE, question, answer);
    }*/

    private static CircleGraphQuestionData generateSameValueQuestion()
    {
        CircleGraphData data = CircleGraphDataGenerator.generateForSameValueQuestion();

        int first = -1;
        int second = -1;

        for (int i = 0; i < data.values.length; i++)
        {
            for (int j = i + 1; j < data.values.length; j++)
            {
                if (data.values[i] == data.values[j])
                {
                    first = i;
                    second = j;
                    break;
                }
            }

            if (first != -1)
            {
                break;
            }
        }

        if (first == -1)
        {
            throw new IllegalStateException("SAME_VALUE generator produced no matching pair");
        }

        String question = "Which two categories represent the same fraction?";
        String answer = data.labels[first] + " and " + data.labels[second];
        return new CircleGraphQuestionData(data, CircleGraphQuestionType.SAME_VALUE, question, answer);
    }

    private static int getMostIndex( CircleGraphData data)
    {
        int index = 0;

        for (int i = 1; i < data.values.length; i++)
        {
            if (data.values[i] > data.values[index])
            {
                index = i;
            }
        }

        return index;
    }

    private static int getLeastIndex(CircleGraphData data)
    {
        int index = 0;

        for (int i = 1; i < data.values.length; i++)
        {
            if (data.values[i] < data.values[index])
            {
                index = i;
            }
        }

        return index;
    }

    private static String getFractionName(int numerator, int denominator)
    {
        if (numerator == 0)
        {
            return "zero";
        }

        int gcd = gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        if (numerator == 1 && denominator == 2)
        {
            return "half";
        }

        if (numerator == 1 && denominator == 4)
        {
            return "one-fourth";
        }

        if (numerator == 3 && denominator == 4)
        {
            return "three-fourths";
        }

        if (numerator == 1 && denominator == 8)
        {
            return "one-eighth";
        }

        if (numerator == 3 && denominator == 8)
        {
            return "three-eighths";
        }

        if (numerator == 5 && denominator == 8)
        {
            return "five-eighths";
        }

        if (numerator == 7 && denominator == 8)
        {
            return "seven-eighths";
        }

        return numerator + "/" + denominator;
    }

    private static int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private static String createImageCode(CircleGraphData data)
    {
        StringBuilder code = new StringBuilder(ImageCodeType.CIRCLE_GRAPH);

        // Labels
        for (String label : data.labels)
        {
            code.append("_").append(label);
        }

        // Values
        for (int value : data.values)
        {
            code.append("_").append(value);
        }

        return code.toString();
    }
}