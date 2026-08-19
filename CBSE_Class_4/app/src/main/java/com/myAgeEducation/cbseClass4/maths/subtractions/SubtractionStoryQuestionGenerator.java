package com.myAgeEducation.cbseClass4.maths.subtractions;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbseClass4.maths.utils.OptionUtil;
import com.myAgeEducation.cbsecommon.Question;

public class SubtractionStoryQuestionGenerator
{
    private SubtractionStoryQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        SubtractionStoryQuestionData data = SubtractionStoryDataGenerator.generate();
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(String.valueOf(data.answer));
        return question;
    }

    private static String[] generateOptions(SubtractionStoryQuestionData data)
    {
        switch (data.template.type)
        {
            case HAS_LESS:
            case GROUP_SHRINKS:
            case MONEY_SPENT:
            case UNKNOWN_START:
            case UNKNOWN_CHANGE:
            case COMPARISON:
                return createSubtractionOptions(data);

            default:
                throw new IllegalArgumentException("Unknown subtraction story type");
        }
    }

    //------------------------------------------------------------

    private static String[] createSubtractionOptions(SubtractionStoryQuestionData data)
    {
        return OptionUtil.createNearbyOptions(data.answer);
    }
}