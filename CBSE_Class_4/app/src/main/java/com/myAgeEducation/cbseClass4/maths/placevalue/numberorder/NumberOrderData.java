package com.myAgeEducation.cbseClass4.maths.placevalue.numberorder;

public class NumberOrderData
{
    public final int[] numbers;
    public final NumberOrderQuestionType type;

    public NumberOrderData(
            int[] numbers,
            NumberOrderQuestionType type)
    {
        this.numbers = numbers;
        this.type = type;
    }
}
