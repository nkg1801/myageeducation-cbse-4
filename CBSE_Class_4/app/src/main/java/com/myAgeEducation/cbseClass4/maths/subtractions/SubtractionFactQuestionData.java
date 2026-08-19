package com.myAgeEducation.cbseClass4.maths.subtractions;

public class SubtractionFactQuestionData
{
    public final SubtractionFactTemplate template;

    public final String question;

    public final int answer;

    public final int number;

    public final int value1;

    public final int value2;

    public SubtractionFactQuestionData(
            SubtractionFactTemplate template,
            String question,
            int answer,
            int number,
            int value1,
            int value2)
    {
        this.template = template;
        this.question = question;

        this.answer = answer;

        this.number = number;
        this.value1 = value1;
        this.value2 = value2;
    }
}