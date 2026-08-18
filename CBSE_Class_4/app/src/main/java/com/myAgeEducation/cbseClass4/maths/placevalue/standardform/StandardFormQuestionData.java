package com.myAgeEducation.cbseClass4.maths.placevalue.standardform;

public class StandardFormQuestionData
{
    public final int number;
    public final String expandedForm;
    public final StandardFormQuestionType type;


    public StandardFormQuestionData(
            int number,
            String expandedForm,
            StandardFormQuestionType type)
    {
        this.number = number;
        this.expandedForm = expandedForm;
        this.type = type;
    }
}
