package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.Random;

public final class StoryCharacterUtil
{
    private static final Random RANDOM = new Random();

    private StoryCharacterUtil()
    {
    }

    public static StoryCharacter getRandomCharacter()
    {
        boolean male = RANDOM.nextBoolean();

        if (male)
        {
            return new StoryCharacter(PersonNameUtil.getMaleName(), true, "His", "him");
        }

        return new StoryCharacter( PersonNameUtil.getFemaleName(), false, "Her", "her");
    }

    public static String getAnotherPersonName(StoryCharacter character)
    {
        String name;

        do
        {
            if (character.isMale())
            {
                name = PersonNameUtil.getFemaleName();
            }
            else
            {
                name = PersonNameUtil.getMaleName();
            }
        }
        while (name.equals(character.getName()));
        return name;
    }
}