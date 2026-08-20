package com.myAgeEducation.cbseClass4.maths.additions;

public class AdditionStoryQuestionData
{
    public final AdditionStoryTemplate template;
    public final String question;
    public final int answer;

    public AdditionStoryQuestionData(AdditionStoryTemplate template, String question, int answer)
    {
        this.template = template;
        this.question = question;
        this.answer = answer;
    }
}
