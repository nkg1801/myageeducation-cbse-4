package com.myAgeEducation.cbseClass4.maths.divisions.facts;

public class DivisionFactQuestionData
{
    public final DivisionFactTemplate template;

    public final String question;

    public final int dividend;

    public final int divisor;

    public final int quotient;

    public final int answer;

    public DivisionFactQuestionData(
            DivisionFactTemplate template,
            String question,
            int dividend,
            int divisor,
            int quotient,
            int answer)
    {
        this.template = template;
        this.question = question;

        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;

        this.answer = answer;
    }
}