package com.myAgeEducation.cbseClass4.maths.subtractions;

public class SubtractionStoryQuestionData
{
    public final SubtractionStoryTemplate template;

    public final String question;

    public final int firstNumber;

    public final int secondNumber;

    public final int answer;

    public SubtractionStoryQuestionData(
            SubtractionStoryTemplate template,
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