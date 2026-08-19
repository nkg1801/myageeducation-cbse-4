package com.myAgeEducation.cbseClass4.maths.fractions;

public class FractionOfMeasurementData
{
    public int numerator;
    public int denominator;

    public String quantityText;   // "an hour", "1 kg"
    public int baseValue;         // 60, 1000
    public String answerUnit;     // "minutes", "g"

    public FractionOfMeasurementData(
            int numerator,
            int denominator,
            String quantityText,
            int baseValue,
            String answerUnit)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        this.quantityText = quantityText;
        this.baseValue = baseValue;
        this.answerUnit = answerUnit;
    }

    public int getAnswer()
    {
        return baseValue / denominator;
    }
}