package com.myAgeEducation.cbseClass4.maths.utils;

public class StoryCharacter
{
    private final String name;

    private final String possessivePronoun;

    private final String objectPronoun;
    private final boolean male;

    public StoryCharacter(
            String name,
            boolean male,
            String possessivePronoun,
            String objectPronoun)
    {
        this.name = name;
        this.male = male;
        this.possessivePronoun = possessivePronoun;
        this.objectPronoun = objectPronoun;
    }

    public String getName()
    {
        return name;
    }

    public String getPossessivePronoun()
    {
        return possessivePronoun;
    }

    public String getObjectPronoun()
    {
        return objectPronoun;
    }

    public boolean isMale()
    {
        return male;
    }
}
