package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FractionOfMeasurementQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private static final FractionOfMeasurementData[] MEASUREMENTS =
            {
                    // Time
                    new FractionOfMeasurementData(1, 2, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 3, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 4, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 5, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 6, "an hour", 60, "minutes"),

                    // Weight
                    new FractionOfMeasurementData(1, 2, "1 kg", 1000, "g"),
                    new FractionOfMeasurementData(1, 4, "1 kg", 1000, "g"),
                    new FractionOfMeasurementData(1, 5, "1 kg", 1000, "g"),

                    // Length
                    new FractionOfMeasurementData(1, 2, "1 metre", 100, "cm"),
                    new FractionOfMeasurementData(1, 4, "1 metre", 100, "cm"),
                    new FractionOfMeasurementData(1, 5, "1 metre", 100, "cm"),

                    // Length - kilometre to metre
                    new FractionOfMeasurementData(1, 2, "1 kilometre", 1000, "metres"),
                    new FractionOfMeasurementData(1, 4, "1 kilometre", 1000, "metres"),
                    new FractionOfMeasurementData(1, 5, "1 kilometre", 1000, "metres"),
                    new FractionOfMeasurementData(1, 10, "1 kilometre", 1000, "metres"),

                    // Capacity
                    new FractionOfMeasurementData(1, 2, "1 litre", 1000, "mL"),
                    new FractionOfMeasurementData(1, 4, "1 litre", 1000, "mL"),
                    new FractionOfMeasurementData(1, 5, "1 litre", 1000, "mL"),

                    // Time - Day
                    new FractionOfMeasurementData(1, 2, "a day", 24, "hours"),
                    new FractionOfMeasurementData(1, 3, "a day", 24, "hours"),
                    new FractionOfMeasurementData(1, 4, "a day", 24, "hours"),
                    new FractionOfMeasurementData(1, 6, "a day", 24, "hours"),
                    new FractionOfMeasurementData(1, 8, "a day", 24, "hours"),

                    // Time - Week to days
                    new FractionOfMeasurementData(1, 7, "a week", 7, "day"),

                    // Time - Year to months
                    new FractionOfMeasurementData(1, 2, "a year", 12, "months"),
                    new FractionOfMeasurementData(1, 3, "a year", 12, "months"),
                    new FractionOfMeasurementData(1, 4, "a year", 12, "months"),
                    new FractionOfMeasurementData(1, 6, "a year", 12, "months"),

                    //century
                    new FractionOfMeasurementData(1, 2, "a century", 100, "years"),
                    new FractionOfMeasurementData(1, 4, "a century", 100, "years"),
                    new FractionOfMeasurementData(1, 5, "a century", 100, "years"),
                    new FractionOfMeasurementData(1, 10, "a century", 100, "years"),

                    //Time - hours to minutes
                    new FractionOfMeasurementData(1, 2, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 3, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 4, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 5, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 6, "an hour", 60, "minutes"),
                    new FractionOfMeasurementData(1, 10, "an hour", 60, "minutes"),

                    //Time - minutes to seconds
                    new FractionOfMeasurementData(1, 2, "a minute", 60, "seconds"),
                    new FractionOfMeasurementData(1, 3, "a minute", 60, "seconds"),
                    new FractionOfMeasurementData(1, 4, "a minute", 60, "seconds"),
                    new FractionOfMeasurementData(1, 5, "a minute", 60, "seconds"),
                    new FractionOfMeasurementData(1, 6, "a minute", 60, "seconds"),
                    new FractionOfMeasurementData(1, 10, "a minute", 60, "seconds"),

                    // Time - Decade to years
                    new FractionOfMeasurementData(1, 2, "a decade", 10, "years"),
                    new FractionOfMeasurementData(1, 5, "a decade", 10, "years"),
                    new FractionOfMeasurementData(1, 10, "a decade", 10, "year"),

                    // Quantity - Dozen
                    new FractionOfMeasurementData(1, 2, "a dozen", 12, "items"),
                    new FractionOfMeasurementData(1, 3, "a dozen", 12, "items"),
                    new FractionOfMeasurementData(1, 4, "a dozen", 12, "items"),
                    new FractionOfMeasurementData(1, 6, "a dozen", 12, "items"),

                    // Money
                    new FractionOfMeasurementData(1, 2, "₹100", 100, "rupees"),
                    new FractionOfMeasurementData(1, 4, "₹100", 100, "rupees"),
                    new FractionOfMeasurementData(1, 5, "₹100", 100, "rupees"),
                    new FractionOfMeasurementData(1, 10, "₹100", 100, "rupees"),
            };

    public static Question generateQuestion()
    {
        // Pick a random valid measurement
        FractionOfMeasurementData data = MEASUREMENTS[RANDOM.nextInt(MEASUREMENTS.length)];

        int answerValue = data.getAnswer();

        String answer = answerValue + " " + data.answerUnit;

        String questionText = generateQuestionText(data);

        List<String> options = generateOptions(answerValue, data.baseValue, data.answerUnit);

        Question question = new Question();

        question.setQuestion(questionText);

        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));

        question.setAnswer(answer);

        return question;
    }

    private static String generateQuestionText(FractionOfMeasurementData data)
    {
        String fraction = fractionToWords(data.numerator, data.denominator);

        int variant = RANDOM.nextInt(4);

        switch (variant)
        {
            case 0:
                return capitalize(fraction) + " of " + data.quantityText + " is _____.";

            case 1:
                return "What is " + fraction + " of " + data.quantityText + "?";

            case 2:
                return "Find " + fraction + " of " + data.quantityText + ".";

            case 3:
                return capitalize(fraction) + " of " + data.quantityText + " is equal to _____.";

            default:
                throw new IllegalStateException();
        }
    }


    private static List<String> generateOptions(int correctAnswer,int baseValue,String unit)
    {
        Set<Integer> values = new LinkedHashSet<>();

        // Correct answer
        values.add(correctAnswer);

        // Generate meaningful possible values
        int[] divisors = {2, 3, 4, 5, 6, 10};

        for (int divisor : divisors)
        {
            if (baseValue % divisor == 0)
            {
                values.add(baseValue / divisor);
            }
        }

        // Safety fallback
        int step = Math.max(1, correctAnswer / 2);

        while (values.size() < 4)
        {
            int value = correctAnswer + step * values.size();
            values.add(value);
        }

        List<Integer> valueList = new ArrayList<>(values);

        // Shuffle before selecting three wrong answers
        Collections.shuffle(valueList);

        List<String> options = new ArrayList<>();

        options.add(correctAnswer + " " + unit);

        for (int value : valueList)
        {
            if (value != correctAnswer && options.size() < 4)
            {
                options.add(value + " " + unit);
            }
        }

        Collections.shuffle(options);

        return options;
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

                case 8:
                    return "one eighth";

                case 10:
                    return "one tenth";

                case 100:
                    return "one hundredth";
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
}