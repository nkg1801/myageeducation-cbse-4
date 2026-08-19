package com.myAgeEducation.cbseClass4.maths.subtractions;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import com.myAgeEducation.cbseClass4.maths.utils.OptionUtil;

public class SubtractionFactQuestionGenerator
{
    private SubtractionFactQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        SubtractionFactQuestionData data = SubtractionFactDataGenerator.generate();
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(String.valueOf(data.answer));
        return question;
    }

    private static String[] generateOptions(SubtractionFactQuestionData data)
    {
        switch (data.template.type)
        {
            case SUCCESSOR:
            case PREDECESSOR:
            case PLACE_VALUE_DIFFERENCE:
                return OptionUtil.createNearbyOptions(data.answer);

            case LARGEST_4_DIGIT_SUCCESSOR:
                return createLargest4DigitOptions();

            default:
                throw new IllegalArgumentException("Unknown subtraction type");
        }
    }

    //------------------------------------------------------------

    private static String[] createLargest4DigitOptions()
    {
        return new String[]
                {
                        "9999",
                        "9998",
                        "10000",
                        "9000"
                };
    }
}