package com.myAgeEducation.cbseClass4.maths.circlegraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

public class CircleGraphOptionGenerator
{
    private static final Random RANDOM =
            new Random();

    public static String[] generateOptions(
            CircleGraphQuestionData data)
    {
        switch (data.type)
        {
            case IDENTIFY_FRACTION:
                return generateFractionOptions(data);

            case IDENTIFY_MOST:
            case IDENTIFY_LEAST:
                return generateCategoryOptions(data);

            case DIFFERENCE:
                return generateFractionOptions(data);

            case SAME_VALUE:
                return generateSameValueOptions(data);

            default:
                throw new IllegalArgumentException(
                        "Unsupported question type: "
                                + data.type);
        }
    }

    /*
     * -----------------------------------------
     * FRACTION OPTIONS
     * -----------------------------------------
     */
    private static String[] generateFractionOptions(
            CircleGraphQuestionData data)
    {
        Set<String> options =
                new LinkedHashSet<>();

        // ALWAYS add correct answer first.
        options.add(
                data.correctAnswer);

        String[] commonFractions =
                {
                        "one-eighth",
                        "one-fourth",
                        "three-eighths",
                        "half",
                        "five-eighths",
                        "three-fourths",
                        "seven-eighths"
                };

        List<String> distractors =
                new ArrayList<>();

        for (String fraction :
                commonFractions)
        {
            if (!fraction.equals(
                    data.correctAnswer))
            {
                distractors.add(fraction);
            }
        }

        Collections.shuffle(
                distractors,
                RANDOM);

        for (String option :
                distractors)
        {
            if (options.size() >= 4)
            {
                break;
            }

            options.add(option);
        }

        return shuffleAndConvert(options);
    }

    /*
     * -----------------------------------------
     * MOST / LEAST
     * -----------------------------------------
     */
    private static String[] generateCategoryOptions(
            CircleGraphQuestionData data)
    {
        Set<String> options =
                new LinkedHashSet<>();

        // ALWAYS include correct answer.
        options.add(
                data.correctAnswer);

        List<String> categories =
                new ArrayList<>();

        for (String label :
                data.graphData.labels)
        {
            if (!label.equals(
                    data.correctAnswer))
            {
                categories.add(label);
            }
        }

        Collections.shuffle(
                categories,
                RANDOM);

        for (String category :
                categories)
        {
            if (options.size() >= 4)
            {
                break;
            }

            options.add(category);
        }

        return shuffleAndConvert(options);
    }

    /*
     * -----------------------------------------
     * SAME VALUE
     * -----------------------------------------
     */
    private static String[] generateSameValueOptions(
            CircleGraphQuestionData data)
    {
        Set<String> options =
                new LinkedHashSet<>();

        // Correct answer MUST be present.
        options.add(
                data.correctAnswer);

        /*
         * Create all possible pairs.
         */
        List<String> pairs =
                new ArrayList<>();

        for (int i = 0;
             i < data.graphData.labels.length;
             i++)
        {
            for (int j = i + 1;
                 j < data.graphData.labels.length;
                 j++)
            {
                String pair =
                        data.graphData.labels[i]
                                + " and "
                                + data.graphData.labels[j];

                if (!pair.equals(
                        data.correctAnswer))
                {
                    pairs.add(pair);
                }
            }
        }

        Collections.shuffle(
                pairs,
                RANDOM);

        for (String pair :
                pairs)
        {
            if (options.size() >= 4)
            {
                break;
            }

            options.add(pair);
        }

        /*
         * Normally we will already have
         * four options. But if the graph
         * has fewer categories, create
         * additional safe options.
         */
        while (options.size() < 4)
        {
            String option =
                    "None of these";

            if (!options.contains(option))
            {
                options.add(option);
            }
            else
            {
                break;
            }
        }

        return shuffleAndConvert(options);
    }

    /*
     * -----------------------------------------
     * SHUFFLE + CONVERT
     * -----------------------------------------
     */
    private static String[] shuffleAndConvert(Set<String> options)
    {
        List<String> list = new ArrayList<>(options);
        Collections.shuffle(list, RANDOM);
        return list.toArray(new String[0]);
    }
}