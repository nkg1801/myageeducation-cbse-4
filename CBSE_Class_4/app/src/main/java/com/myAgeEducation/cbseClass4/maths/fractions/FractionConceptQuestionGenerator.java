package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FractionConceptQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private static class ConceptQuestion
    {
        String question;
        String correctAnswer;
        String[] wrongAnswers;

        ConceptQuestion(
                String question,
                String correctAnswer,
                String... wrongAnswers)
        {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.wrongAnswers = wrongAnswers;
        }
    }


    private static final ConceptQuestion[] FIXED_QUESTIONS =
            {
                    new ConceptQuestion(
                            "A _____ is made up of a numerator and a denominator.",
                            "fraction",
                            "whole number",
                            "product",
                            "sum"),

                    new ConceptQuestion(
                            "The number above the fraction bar is called the _____.",
                            "numerator",
                            "denominator",
                            "quotient",
                            "remainder"),

                    new ConceptQuestion(
                            "The number below the fraction bar is called the _____.",
                            "denominator",
                            "numerator",
                            "product",
                            "remainder"),

                    new ConceptQuestion(
                            "The numerator tells us how many equal parts are _____.",
                            "taken",
                            "made in total",
                            "multiplied",
                            "divided"),

                    new ConceptQuestion(
                            "The denominator tells us the total number of _____ parts.",
                            "equal",
                            "unequal",
                            "coloured",
                            "remaining"),

                    new ConceptQuestion(
                            "Fractions represent _____ parts of a whole.",
                            "equal",
                            "unequal",
                            "different-sized",
                            "random"),

                    new ConceptQuestion(
                            "Two halves make one _____.",
                            "whole",
                            "third",
                            "fourth",
                            "quarter"),

                    new ConceptQuestion(
                            "Another name for one-fourth is _____.",
                            "one-quarter",
                            "one-half",
                            "one-third",
                            "one-fifth"),

                    new ConceptQuestion(
                            "Fractions that have the same denominator are called ______ fractions.",
                            "Like",
                            "Unlike",
                            "Proper",
                            "Improper"),

                    new ConceptQuestion(
                            "Fractions that have different denominators are called LIKE fractions.",
                            "False",
                            "True"),

                    new ConceptQuestion(
                            "Fractions that have the same denominator are called UNLIKE fractions.",
                            "False",
                            "True")
            };


    public static Question generateQuestion()
    {
        // 50% fixed concept question
        // 50% dynamic numerator/denominator question

        if (RANDOM.nextBoolean())
        {
            return generateFixedQuestion();
        }
        else
        {
            return generateDynamicFractionQuestion();
        }
    }


    private static Question generateFixedQuestion()
    {
        ConceptQuestion data = FIXED_QUESTIONS[RANDOM.nextInt(FIXED_QUESTIONS.length)];

        List<String> options = new ArrayList<>();

        options.add(data.correctAnswer);

        Collections.addAll(
                options,
                data.wrongAnswers);

        Collections.shuffle(options);

        return createQuestion(
                data.question,
                data.correctAnswer,
                options);
    }


    private static Question generateDynamicFractionQuestion()
    {
        // Denominator from 2 to 10
        int denominator = 2 + RANDOM.nextInt(9);

        // Numerator from 1 to denominator - 1
        int numerator = 1 + RANDOM.nextInt(denominator - 1);

        boolean askNumerator = RANDOM.nextBoolean();

        String questionText;
        int correctAnswer;

        if (askNumerator)
        {
            questionText =
                    "In the fraction "
                            + numerator
                            + "/"
                            + denominator
                            + ", what is the numerator?";

            correctAnswer = numerator;
        }
        else
        {
            questionText =
                    "In the fraction "
                            + numerator
                            + "/"
                            + denominator
                            + ", what is the denominator?";

            correctAnswer = denominator;
        }

        List<String> options =
                generateNumberOptions(
                        correctAnswer,
                        numerator,
                        denominator);

        return createQuestion(
                questionText,
                String.valueOf(correctAnswer),
                options);
    }


    private static List<String> generateNumberOptions(
            int correctAnswer,
            int numerator,
            int denominator)
    {
        List<Integer> values =
                new ArrayList<>();

        // Correct answer
        values.add(correctAnswer);

        // The other number in the fraction is a useful distractor
        int otherValue =
                correctAnswer == numerator
                        ? denominator
                        : numerator;

        if (!values.contains(otherValue))
        {
            values.add(otherValue);
        }

        // Add random distinct distractors
        while (values.size() < 4)
        {
            int value =
                    1 + RANDOM.nextInt(10);

            if (!values.contains(value))
            {
                values.add(value);
            }
        }

        Collections.shuffle(values);

        List<String> options = new ArrayList<>();

        for (int value : values)
        {
            options.add(String.valueOf(value));
        }

        return options;
    }

    private static Question createQuestion(String questionText, String correctAnswer, List<String> options)
    {
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }
}