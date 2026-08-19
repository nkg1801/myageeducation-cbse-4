package com.myAgeEducation.cbseClass4.maths.subtractions;

public class SubtractionStoryTemplate
{
    public final SubtractionStoryType type;

    public final String questionTemplate;

    public SubtractionStoryTemplate(
            SubtractionStoryType type,
            String questionTemplate)
    {
        this.type = type;
        this.questionTemplate = questionTemplate;
    }
}