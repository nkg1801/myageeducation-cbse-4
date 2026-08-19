package com.myAgeEducation.cbseClass4.maths.fractions;

public class FractionTimeStoryData
{
    public int numerator;
    public int denominator;

    public int originalTime;
    public int answerTime;

    public String timeUnit;

    public FractionTimeScenario scenario;

    public FractionTimeStoryData(
            int numerator,
            int denominator,
            int originalTime,
            int answerTime,
            String timeUnit,
            FractionTimeScenario scenario)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        this.originalTime = originalTime;
        this.answerTime = answerTime;
        this.timeUnit = timeUnit;
        this.scenario = scenario;
    }
}