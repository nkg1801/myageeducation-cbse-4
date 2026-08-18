package com.myAgeEducation.cbseClass4.maths.placevalue.arrangedigits;

public class ArrangeDigitsQuestionData
{
    public final ArrangeDigitsQuestionType type;
    public final int[] digits;

    public final String questionText;
    public final String correctAnswer;

    public String[] options;


    public ArrangeDigitsQuestionData(
            ArrangeDigitsQuestionType type,
            int[] digits,
            String questionText,
            String correctAnswer)
    {
        this.type = type;
        this.digits = digits;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}
