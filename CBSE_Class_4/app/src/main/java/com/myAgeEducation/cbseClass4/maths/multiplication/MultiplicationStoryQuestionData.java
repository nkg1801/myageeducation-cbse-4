package com.myAgeEducation.cbseClass4.maths.multiplication;

public class MultiplicationStoryQuestionData
{
    public final MultiplicationStoryTemplate template;

    public final String question;

    public final int firstNumber;

    public final int secondNumber;

    public final int answer;

    public MultiplicationStoryQuestionData(
            MultiplicationStoryTemplate template,
            String question,
            int firstNumber,
            int secondNumber,
            int answer)
    {
        this.template = template;
        this.question = question;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.answer = answer;
    }
}