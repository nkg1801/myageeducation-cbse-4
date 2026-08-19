package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbseClass4.maths.utils.PersonNameUtil;

import java.util.Random;

public class StoryCharacterGenerator
{
    private static final Random RANDOM = new Random();

    public static StoryCharacter randomCharacter()
    {
        if (RANDOM.nextBoolean())
        {
            return new StoryCharacter(PersonNameUtil.getMaleName(), PersonNameUtil.getFemaleName(), "He", "him", "his");
        }
        else
        {
            return new StoryCharacter(
                    PersonNameUtil.getFemaleName(),
                    PersonNameUtil.getMaleName(),
                    "She",
                    "her",
                    "her");
        }
    }
}