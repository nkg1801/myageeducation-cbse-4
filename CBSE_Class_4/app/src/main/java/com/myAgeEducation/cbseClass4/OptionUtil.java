package com.myAgeEducation.cbseClass4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class OptionUtil
{
    private OptionUtil()
    {
    }

    public static String[] createOptions(String correctAnswer, Collection<String> distractors, int requiredOptions)
    {
        List<String> distractorList = new ArrayList<>(distractors);

        // Remove the correct answer if it accidentally exists
        distractorList.remove(correctAnswer);

        Collections.shuffle(distractorList);

        List<String> options = new ArrayList<>();

        options.add(correctAnswer);

        for (int i = 0; i < requiredOptions - 1 && i < distractorList.size(); i++)
        {
            options.add(distractorList.get(i));
        }

        if (options.size() != requiredOptions)
        {
            throw new IllegalStateException(
                    "Expected "
                            + requiredOptions
                            + " options but found "
                            + options.size());
        }

        Collections.shuffle(options);

        return options.toArray(new String[0]);
    }
}