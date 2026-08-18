package com.myAgeEducation.cbseClass4.maths.placevalue.missingvalue;

public class MissingPlaceValueQuestionData
{
    public final int number;
    public final int lakhs;
    public final int thousands;
    public final int hundreds;
    public final int tens;
    public final int ones;

    // 0 = thousands
    // 1 = hundreds
    // 2 = tens
    // 3 = ones
    //public final int missingPlace;
    public final PlaceType missingPlace;
    public final String correctAnswer;

    public MissingPlaceValueQuestionData(
            int number,
            int lakhs,
            int thousands,
            int hundreds,
            int tens,
            int ones,
            PlaceType missingPlace,
            String correctAnswer)
    {
        this.number = number;
        this.lakhs = lakhs;
        this.thousands = thousands;
        this.hundreds = hundreds;
        this.tens = tens;
        this.ones = ones;
        this.missingPlace = missingPlace;
        this.correctAnswer = correctAnswer;
    }
}