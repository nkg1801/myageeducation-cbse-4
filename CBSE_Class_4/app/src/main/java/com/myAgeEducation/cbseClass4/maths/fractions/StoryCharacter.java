package com.myAgeEducation.cbseClass4.maths.fractions;

public class StoryCharacter
{
    public String giverName;
    public String recipientName;

    public String subjectPronoun;      // He / She
    public String objectPronoun;       // him / her
    public String possessivePronoun;   // his / her

    public StoryCharacter(
            String giverName,
            String recipientName,
            String subjectPronoun,
            String objectPronoun,
            String possessivePronoun)
    {
        this.giverName = giverName;
        this.recipientName = recipientName;
        this.subjectPronoun = subjectPronoun;
        this.objectPronoun = objectPronoun;
        this.possessivePronoun = possessivePronoun;
    }
}