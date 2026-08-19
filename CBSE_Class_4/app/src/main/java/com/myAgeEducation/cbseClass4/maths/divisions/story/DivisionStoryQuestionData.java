package com.myAgeEducation.cbseClass4.maths.divisions.story;

public class DivisionStoryQuestionData
{
    public final DivisionStoryTemplate template;

    public final String question;

    public final int dividend;

    public final int divisor;

    public final int answer;

    public DivisionStoryQuestionData(
            DivisionStoryTemplate template,
            String question,
            int dividend,
            int divisor,
            int answer)
    {
        this.template = template;
        this.question = question;
        this.dividend = dividend;
        this.divisor = divisor;
        this.answer = answer;
    }
}
