package com.myAgeEducation.cbseClass4.maths.placevalue.digitplace;

public class DigitPlaceValueQuestionData
{
    public final int number;
    public final int digit;
    public final int position;
    public final String correctAnswer;


    public DigitPlaceValueQuestionData(
            int number,
            int digit,
            int position,
            String correctAnswer)
    {
        this.number = number;
        this.digit = digit;
        this.position = position;
        this.correctAnswer = correctAnswer;
    }
}
