package com.myAgeEducation.cbseClass4.maths.divisions.facts;


public class DivisionPictureQuestionData
{
    public final DivisionPictureTemplate template;
    public final int dividend;
    public final int divisor;
    public final int quotient;
    public final int answer;

    public DivisionPictureQuestionData(DivisionPictureTemplate template, int dividend, int divisor, int quotient, int answer)
    {
        this.template = template;
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.answer = answer;
    }
}