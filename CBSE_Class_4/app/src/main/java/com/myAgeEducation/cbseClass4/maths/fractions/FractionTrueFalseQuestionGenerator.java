package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeType;
import com.myAgeEducation.cbsecommon.Question;

public class FractionTrueFalseQuestionGenerator
{
    public static Question generateQuestion()
    {
        FractionTrueFalseData data = FractionTrueFalseGenerator.generate();
        String questionText = "In the fraction shown below, " + data.statement + " True or False?";
        String answer = data.answer ? "TRUE" : "FALSE";
        Question question = new Question();
        question.setQuestion(questionText);
        question.setOption1("TRUE");
        question.setOption2("FALSE");
        question.setAnswer(answer);
        question.setImage(createImageCode(data.numerator, data.denominator));
        return question;
    }

    private static String createImageCode(int numerator, int denominator)
    {
        return ImageCodeType.NUMERIC_FRACTION + "_" + numerator + "_" + denominator;
    }
}