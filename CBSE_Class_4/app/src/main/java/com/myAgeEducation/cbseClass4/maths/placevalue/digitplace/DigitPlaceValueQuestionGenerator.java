package com.myAgeEducation.cbseClass4.maths.placevalue.digitplace;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DigitPlaceValueQuestionGenerator
{
    private DigitPlaceValueQuestionGenerator()
    {
        // Prevent object creation
    }

    public static Question generateQuestion()
    {
        DigitPlaceValueQuestionData data = DigitPlaceValueDataGenerator.generate();
        String questionText = buildQuestionText(data);
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(data.correctAnswer);
        return question;
    }

    private static String[] generateOptions(DigitPlaceValueQuestionData data)
    {
        List<Integer> positions = new ArrayList<>();

        // Add the correct position first
        positions.add(data.position);

        // Add all other possible positions
        for (int position = 0; position <= 4; position++)
        {
            if (position != data.position)
            {
                positions.add(position);
            }
        }

        // Keep correct position and randomly select
        // three other positions
        List<Integer> wrongPositions = new ArrayList<>(positions.subList(1, positions.size()));
        Collections.shuffle(wrongPositions);
        List<String> options = new ArrayList<>();
        options.add(DigitPlaceValueDataGenerator.getPlaceValueText(data.digit, data.position));

        for (int i = 0; i < 3; i++)
        {
            options.add(DigitPlaceValueDataGenerator.getPlaceValueText(data.digit, wrongPositions.get(i)));
        }

        Collections.shuffle(options);
        return options.toArray(new String[0]);
    }

    private static String buildQuestionText(DigitPlaceValueQuestionData data)
    {
        return "Find the place value of " + getDigitWord(data.digit) + " in " + NumberFormatUtil.formatIndianNumber(data.number);
    }

    private static String getDigitWord(int digit)
    {
        switch (digit)
        {
            case 1:
                return "one";

            case 2:
                return "two";

            case 3:
                return "three";

            case 4:
                return "four";

            case 5:
                return "five";

            case 6:
                return "six";

            case 7:
                return "seven";

            case 8:
                return "eight";

            case 9:
                return "nine";

            default:
                throw new IllegalArgumentException("Invalid digit: " + digit);
        }
    }

    private static String formatNumber(int number)
    {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }
}