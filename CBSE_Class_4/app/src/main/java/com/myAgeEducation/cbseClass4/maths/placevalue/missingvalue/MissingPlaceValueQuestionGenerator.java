package com.myAgeEducation.cbseClass4.maths.placevalue.missingvalue;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.maths.utils.QuestionTextUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MissingPlaceValueQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private MissingPlaceValueQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        MissingPlaceValueQuestionData data = MissingPlaceValueDataGenerator.generate();
        String questionText = buildQuestionText(data);
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(questionText);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(data.correctAnswer);
        return question;
    }

    private static String[] generateOptions(MissingPlaceValueQuestionData data)
    {
        List<String> options = new ArrayList<>();

        int correct = Integer.parseInt(data.correctAnswer);

        options.add(data.correctAnswer);

        while (options.size() < 4)
        {
            int value = RANDOM.nextInt(10);

            String option =
                    String.valueOf(value);

            if (!options.contains(option))
            {
                options.add(option);
            }
        }

        Collections.shuffle(options);

        return options.toArray(
                new String[0]);
    }

    private static String buildQuestionText(MissingPlaceValueQuestionData data)
    {
        String expression = buildExpression(data);

        switch (RANDOM.nextInt(4))
        {
            case 0:
                return QuestionTextUtil.random(
                        "Fill the missing place number.",
                        "Complete the place value expression.",
                        "Find the missing digit.",
                        "Fill in the blank.")
                        + "\n\n"
                        + expression;

            case 1:
                return QuestionTextUtil.random(
                        "Write the expanded form.",
                        "Complete the expanded form.",
                        "Fill the missing place number.")
                        + "\n\n"
                        + NumberFormatUtil.formatIndianNumber(data.number)
                        + " = "
                        + buildLeftSide(data);

            case 2:
                return QuestionTextUtil.random(
                        "Expanded form of "
                                + NumberFormatUtil.formatIndianNumber(data.number)
                                + " is",
                        "Complete the expanded form of "
                                + NumberFormatUtil.formatIndianNumber(data.number),
                        "Write the expanded form of "
                                + NumberFormatUtil.formatIndianNumber(data.number))
                        + "\n\n"
                        + buildLeftSide(data);

            default:
                return QuestionTextUtil.random(
                        "Complete the expanded form.",
                        "Fill in the missing place number.")
                        + "\n\n"
                        + buildLeftSide(data)
                        + "\n\nNumber : "
                        + NumberFormatUtil.formatIndianNumber(data.number);
        }
    }

    private static String buildLeftSide(MissingPlaceValueQuestionData data)
    {
        StringBuilder builder = new StringBuilder();

        appendPlace(
                builder,
                data.lakhs,
                PlaceType.LAKHS,
                data.missingPlace);

        appendPlace(
                builder,
                data.thousands,
                PlaceType.THOUSANDS,
                data.missingPlace);

        appendPlace(
                builder,
                data.thousands,
                PlaceType.THOUSANDS,
                data.missingPlace);

        appendPlace(
                builder,
                data.hundreds,
                PlaceType.HUNDREDS,
                data.missingPlace);

        appendPlace(
                builder,
                data.tens,
                PlaceType.TENS,
                data.missingPlace);

        appendPlace(
                builder,
                data.ones,
                PlaceType.ONES,
                data.missingPlace);

        return builder.toString();
    }

    private static String buildExpression(MissingPlaceValueQuestionData data)
    {
        return buildLeftSide(data)
                + " = "
                + NumberFormatUtil.formatIndianNumber(data.number);
    }

    private static void appendPlace(StringBuilder builder, int value, PlaceType currentPlace, PlaceType missingPlace)
    {
        // Skip zero places unless this is the missing place
        if (value == 0 && currentPlace != missingPlace)
        {
            return;
        }

        if (builder.length() > 0)
        {
            builder.append(" + ");
        }

        if (currentPlace == missingPlace)
        {
            builder.append("_____ ");
        }
        else
        {
            builder.append(value)
                    .append(" ");
        }

        switch (currentPlace)
        {
            case LAKHS:
                builder.append("lakhs");
                break;

            case THOUSANDS:
                builder.append("thousands");
                break;

            case HUNDREDS:
                builder.append("hundreds");
                break;

            case TENS:
                builder.append("tens");
                break;

            case ONES:
                builder.append("ones");
                break;
        }
    }
}