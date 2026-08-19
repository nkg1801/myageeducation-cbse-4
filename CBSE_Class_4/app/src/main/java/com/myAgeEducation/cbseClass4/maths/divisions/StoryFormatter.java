package com.myAgeEducation.cbseClass4.maths.divisions;

import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacter;

public final class StoryFormatter
{
    private StoryFormatter()
    {
    }

    public static String format(
            String template,
            StoryCharacter character,
            int firstNumber,
            int secondNumber)
    {
        return String.format(
                template,
                character.getName(),               // %1$s
                firstNumber,                       // %2$d
                character.getPossessivePronoun(),  // %3$s
                secondNumber,                      // %4$d
                character.getObjectPronoun());     // %5$s
    }
}
