package com.myAgeEducation.cbseClass4.maths.placevalue.numberword;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumberWordsQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private static final int MIN_NUMBER = 1000;
    private static final int MAX_NUMBER = 9999999;


    private NumberWordsQuestionGenerator()
    {
        // Prevent object creation
    }

    public static Question generateQuestion()
    {
        NumberWordsQuestionData data = generate();
        Question question = new Question();
        question.setQuestion(data.questionText);
        OptionUtils.setQuestionOptions(question, data.options);
        question.setAnswer(data.correctAnswer);
        return question;
    }

    private static NumberWordsQuestionData generate()
    {
        NumberWordsQuestionData data = generateQuestionData();
        data.options = generateOptions(data);
        return data;
    }

    private static String[] generateOptions(NumberWordsQuestionData questionData)
    {
        switch (questionData.type)
        {
            case WORDS_TO_NUMERAL:
                return generateNumeralOptions(questionData);

            case NUMERAL_TO_WORDS:
                return generateWordOptions(questionData);

            default:
                throw new IllegalArgumentException("Unknown question type: " + questionData.type);
        }
    }

    private static String[] generateNumeralOptions(NumberWordsQuestionData questionData)
    {
        int number = questionData.number;
        Set<Integer> options = new LinkedHashSet<>();
        options.add(number);
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;

        addIfValid(
                options,
                hundreds * 100 + ones * 10 + tens,
                number);

        addIfValid(
                options,
                tens * 100 + hundreds * 10 + ones,
                number);

        addIfValid(
                options,
                ones * 100 + tens * 10 + hundreds,
                number);

        while (options.size() < 4)
        {
            int difference = RANDOM.nextInt(90) + 1;
            int wrongNumber = RANDOM.nextBoolean() ? number + difference : number - difference;
            addIfValid(options, wrongNumber, number);
        }

        List<String> optionList = new ArrayList<>();

        for (int option : options)
        {
            //optionList.add(String.valueOf(option));
            optionList.add(NumberFormatUtil.formatIndianNumber(option));
        }

        Collections.shuffle(optionList);
        return optionList.toArray(new String[0]);
    }

    private static String[] generateWordOptions(NumberWordsQuestionData questionData)
    {
        int correctNumber = questionData.number;

        Set<String> options = new LinkedHashSet<>();

        // Correct answer
        options.add(numberToWords(correctNumber));

        while (options.size() < 4)
        {
            int difference =RANDOM.nextInt(90) + 1;

            int wrongNumber = RANDOM.nextBoolean() ? correctNumber + difference : correctNumber - difference;

            if (wrongNumber >= MIN_NUMBER
                    && wrongNumber <= MAX_NUMBER
                    && wrongNumber != correctNumber)
            {
                options.add(numberToWords(wrongNumber));
            }
        }

        List<String> optionList = new ArrayList<>(options);

        Collections.shuffle(optionList);

        return optionList.toArray(new String[0]);
    }

    private static void addIfValid(Set<Integer> options, int value, int correctAnswer)
    {
        if (value >= MIN_NUMBER && value <= MAX_NUMBER && value != correctAnswer)
        {
            options.add(value);
        }
    }

    private static NumberWordsQuestionData generateQuestionData()
    {
        int number = MIN_NUMBER + RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1);
        String numberInWords = numberToWords(number);
        NumberWordsQuestionType[] types = NumberWordsQuestionType.values();
        NumberWordsQuestionType type = types[RANDOM.nextInt(types.length)];

        String questionText;
        String correctAnswer;

        switch (type)
        {
            case WORDS_TO_NUMERAL:
            {
                questionText = "Write the numeral for: " + numberInWords;
                //correctAnswer = String.valueOf(number);
                correctAnswer = NumberFormatUtil.formatIndianNumber(number);
                break;
            }

            case NUMERAL_TO_WORDS:
            {
                questionText = "Write " + NumberFormatUtil.formatIndianNumber(number) + " in words.";
                correctAnswer = numberInWords;
                break;
            }

            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }

        return new NumberWordsQuestionData(type, number, numberInWords, questionText, correctAnswer);
    }

    private static String numberToWords(int number) {
        if (number < 0 || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Number must be between 0 and " + MAX_NUMBER);
        }

        if (number == 0) {
            return "zero";
        }

        if (number < 20) {
            return ONES[number];
        }

        if (number < 100) {
            return TENS[number / 10]
                    + (number % 10 != 0 ? "-" + ONES[number % 10] : "");
        }

        if (number < 1000) {
            return ONES[number / 100] + " hundred"
                    + (number % 100 != 0 ? " " + numberToWords(number % 100) : "");
        }

        if (number < 100000) { // Thousands
            return numberToWords(number / 1000) + " thousand"
                    + (number % 1000 != 0 ? " " + numberToWords(number % 1000) : "");
        }

        // Lakhs
        return numberToWords(number / 100000) + " lakh"
                + (number % 100000 != 0 ? " " + numberToWords(number % 100000) : "");
    }


    /*private static String numberToWords(int number)
    {
        if (number < 0 || number > MAX_NUMBER)
        {
            throw new IllegalArgumentException("Number must be between 0 and " + MAX_NUMBER);
        }

        if (number == 0)
        {
            return "zero";
        }

        StringBuilder result = new StringBuilder();

        // Hundreds

        if (number >= 100)
        {
            result.append(ONES[number / 100]);
            result.append(" hundred");
            number %= 100;

            if (number > 0)
            {
                result.append(" ");
            }
        }


        // 1 to 19

        if (number > 0 && number < 20)
        {
            result.append(
                    ONES[number]);
        }

        // 20 to 99

        else if (number >= 20)
        {
            result.append(
                    TENS[number / 10]);

            int onesDigit =
                    number % 10;

            if (onesDigit > 0)
            {
                result.append("-");

                result.append(
                        ONES[onesDigit]);
            }
        }


        return result.toString();
    }*/

    private static final String[] ONES =
            {
                    "",
                    "one",
                    "two",
                    "three",
                    "four",
                    "five",
                    "six",
                    "seven",
                    "eight",
                    "nine",
                    "ten",
                    "eleven",
                    "twelve",
                    "thirteen",
                    "fourteen",
                    "fifteen",
                    "sixteen",
                    "seventeen",
                    "eighteen",
                    "nineteen"
            };


    private static final String[] TENS =
            {
                    "",
                    "",
                    "twenty",
                    "thirty",
                    "forty",
                    "fifty",
                    "sixty",
                    "seventy",
                    "eighty",
                    "ninety"
            };
}
