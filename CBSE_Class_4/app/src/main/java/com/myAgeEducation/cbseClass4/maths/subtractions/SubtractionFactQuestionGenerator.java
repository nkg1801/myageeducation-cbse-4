package com.myAgeEducation.cbseClass4.maths.subtractions;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import com.myAgeEducation.cbseClass4.OptionUtil;

import java.util.LinkedHashSet;
import java.util.Set;

public class SubtractionFactQuestionGenerator
{
    private SubtractionFactQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        SubtractionFactQuestionData data = SubtractionFactDataGenerator.generate();
        String correctAnswer = NumberFormatUtil.formatIndianNumber(data.answer);
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }

    private static String[] generateOptions(SubtractionFactQuestionData data)
    {
        switch (data.template.type)
        {
            case SUCCESSOR:
            case PREDECESSOR:
            case PLACE_VALUE_DIFFERENCE:
                return generateFormattedOptions(data.answer);

            case LARGEST_4_DIGIT_SUCCESSOR:
                return createLargest4DigitOptions();

            default:
                throw new IllegalArgumentException("Unknown subtraction type");
        }
    }

    private static String[] generateFormattedOptions(int answer)
    {
        Set<String> distractors = new LinkedHashSet<>();
        distractors.add(NumberFormatUtil.formatIndianNumber(answer + 1));
        distractors.add(NumberFormatUtil.formatIndianNumber(answer - 1));
        distractors.add(NumberFormatUtil.formatIndianNumber(answer + 10));
        distractors.add(NumberFormatUtil.formatIndianNumber(answer - 10));
        distractors.add(NumberFormatUtil.formatIndianNumber(answer + 2));
        distractors.add(NumberFormatUtil.formatIndianNumber(answer - 2));

        return OptionUtil.createOptions(NumberFormatUtil.formatIndianNumber(answer), distractors, 4);
    }

    //------------------------------------------------------------

    private static String[] createLargest4DigitOptions()
    {
        return new String[]
                {
                        "9,999",
                        "9,998",
                        "10,000",
                        "9,000"
                };
    }
}
