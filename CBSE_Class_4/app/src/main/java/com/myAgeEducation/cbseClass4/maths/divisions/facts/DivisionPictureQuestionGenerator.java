package com.myAgeEducation.cbseClass4.maths.divisions.facts;

import com.myAgeEducation.cbseClass4.utils.ImageCodeBuilder;
import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeType;
import com.myAgeEducation.cbseClass4.maths.utils.OptionUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

public class DivisionPictureQuestionGenerator
{
    private DivisionPictureQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        DivisionPictureQuestionData data = DivisionPictureDataGenerator.generate();
        Question question = new Question();
        question.setQuestion(data.template.questionTemplate);
        question.setImage(createImageCode(data));
        String[] options = generateOptions(data);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(String.valueOf(data.answer));
        return question;
    }

    private static String[] generateOptions(DivisionPictureQuestionData data)
    {
        switch (data.template.type)
        {
            case PICTURE_IDENTIFY_DIVIDEND:
            case PICTURE_IDENTIFY_DIVISOR:
            case PICTURE_IDENTIFY_QUOTIENT:
                return OptionUtil.createIdentifyPartOptions(
                        data.answer,
                        data.dividend,
                        data.divisor,
                        data.quotient);

            case PICTURE_MISSING_DIVIDEND:
            case PICTURE_MISSING_DIVISOR:
            case PICTURE_MISSING_QUOTIENT:
                return OptionUtil.createNearbyOptions(data.answer);

            default:
                throw new IllegalArgumentException("Unknown picture type");
        }
    }

    private static String createImageCode(DivisionPictureQuestionData data)
    {
        String hide;

        switch (data.template.type)
        {
            case PICTURE_MISSING_DIVIDEND:
                hide = "DIVIDEND";
                break;

            case PICTURE_MISSING_DIVISOR:
                hide = "DIVISOR";
                break;

            case PICTURE_MISSING_QUOTIENT:
                hide = "QUOTIENT";
                break;

            default:
                hide = "";
        }

        int product = data.divisor * data.quotient;
        int remainder = data.dividend - product;

        return new ImageCodeBuilder(ImageCodeType.DIVISION)
                .add("DIVIDEND", data.dividend)
                .add("DIVISOR", data.divisor)
                .add("QUOTIENT", data.quotient)
                .add("PRODUCT", product)
                .add("REMAINDER", remainder)
                .add("HIDE", hide)
                .build();
    }
}