package com.myAgeEducation.cbseClass4.maths.divisions.story;

public class DivisionStoryTemplate
{
    public final DivisionStoryType type;

    public final String questionTemplate;

    public final boolean requiresCharacter;

    public DivisionStoryTemplate(
            DivisionStoryType type,
            String questionTemplate,
            boolean requiresCharacter)
    {
        this.type = type;
        this.questionTemplate = questionTemplate;
        this.requiresCharacter = requiresCharacter;
    }
}