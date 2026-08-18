package com.myAgeEducation.cbseClass4.maths.placevalue.greatestsmallest;

public class GreatestSmallestQuestionData
{
    public final int[] numbers;
    public final GreatestSmallestQuestionType type;

    public GreatestSmallestQuestionData(
            int[] numbers,
            GreatestSmallestQuestionType type)
    {
        this.numbers = numbers;
        this.type = type;
    }
}