package com.myAgeEducation.cbseClass4.maths.divisions.facts;

public class DivisionFactTemplate
{
    public final DivisionFactType type;
    public final String questionTemplate;

    public DivisionFactTemplate(DivisionFactType type, String questionTemplate)
    {
        this.type = type;
        this.questionTemplate = questionTemplate;
    }
}