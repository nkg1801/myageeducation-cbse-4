package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FractionAgeQuestionGenerator
{
    private static final Random RANDOM = new Random();
    public static Question generateQuestion()
    {
        // Generate the age data
        FractionAgeData data = FractionAgeGenerator.generateAgePair();
        String relationship = getRelationshipText(data.relationship);

        // Example:
        // My father is 40 years old. I am 10 years old.
        // I am ______ of my father's age.
        /*String questionText =
                "My " + relationship
                        + " is " + data.referenceAge
                        + " years old. I am "
                        + data.youngerAge
                        + " years old. I am ______ of my "
                        + relationship
                        + "'s age.";*/

        String questionText = generateQuestionText(data);

        // Correct answer
        String answer = fractionToWords(1, data.denominator);

        // Generate 4 options
        List<String> options = generateOptions(data.denominator);
        Question question = new Question();
        question.setQuestion(questionText);

        /*question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        if(options.size() > 2) {
            question.setOption3(options.get(2));
        }

        if(options.size() > 3) {
            question.setOption4(options.get(3));
        }*/

        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(answer);
        return question;
    }

    private static String getRelationshipText(FractionAgeData.AgeRelationship relationship)
    {
        switch (relationship)
        {
            case FATHER:
                return "father";

            case MOTHER:
                return "mother";

            case BROTHER:
                return "brother";

            case SISTER:
                return "sister";

            default:
                throw new IllegalArgumentException("Unknown relationship: " + relationship);
        }
    }


    private static List<String> generateOptions(int correctDenominator)
    {
        List<Integer> denominators = new ArrayList<>();

        // All possible answers
        denominators.add(2);
        denominators.add(3);
        denominators.add(4);
        denominators.add(5);
        denominators.add(6);

        // Remove the correct answer
        denominators.remove(Integer.valueOf(correctDenominator));

        // Shuffle the wrong answers
        Collections.shuffle(denominators);

        List<String> options = new ArrayList<>();

        // Add correct answer
        options.add(fractionToWords(1, correctDenominator));

        // Add three wrong answers
        for (int i = 0; i < 3; i++)
        {
            options.add(fractionToWords(1,denominators.get(i)));
        }

        // Shuffle all four options
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
            }
        }

        return numerator + "/" + denominator;
    }

    private static String generateQuestionText(FractionAgeData data)
    {
        String relationship = getRelationshipText(data.relationship);

        String[] templates =
                {
                        "My %s is %d years old. I am %d years old. I am ______ of my %s's age.",
                        "My %s is %d years old, while I am %d years old. My age is ______ of my %s's age.",
                        "I am %d years old and my %s is %d years old. My age is ______ of my %s's age.",
                        "The age of my %s is %d years. I am %d years old. I am ______ of my %s's age."
                };

        int index = RANDOM.nextInt(templates.length);

        switch (index)
        {
            case 0:
            case 1:
            case 3:
                return String.format(templates[index], relationship, data.referenceAge, data.youngerAge, relationship);

            case 2:
                return String.format(templates[index],data.youngerAge,relationship,data.referenceAge, relationship);

            default:
                throw new IllegalStateException();
        }
    }
}