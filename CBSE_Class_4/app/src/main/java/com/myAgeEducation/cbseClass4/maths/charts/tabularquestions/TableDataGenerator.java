package com.myAgeEducation.cbseClass4.maths.charts.tabularquestions;

import com.myAgeEducation.cbseClass4.maths.utils.CitiesNameUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TableDataGenerator
{
    private static final Random RANDOM =
            new Random();

    private static final int MIN_VALUE = 5000;
    private static final int MAX_VALUE = 30000;
    private static final int VALUE_STEP = 500;


    public static TableData generate(TableScenario scenario)
    {
        List<Integer> availableValues = new ArrayList<>();

        // Generate all possible values for this scenario
        for (int value = scenario.minValue;
             value <= scenario.maxValue;
             value += scenario.valueStep)
        {
            availableValues.add(value);
        }

        // Shuffle so values are randomly selected
        Collections.shuffle(availableValues);

        int categoryCount = scenario.labels.length;

        if (availableValues.size() < categoryCount)
        {
            throw new IllegalArgumentException(
                    "Not enough unique values for scenario: "
                            + scenario.scenarioCode);
        }

        String[] selectedLabels = scenario.labels;

        switch (scenario.scenarioCode)
        {
            case "LIBRARIES":
            case "ROADNETWORK":
                selectedLabels = CitiesNameUtil.getDifferentIndianCities(categoryCount);
                break;

            /*case "AIRPORTS":
                selectedLabels = CountriesNameUtil.getDifferentCountryNames(categoryCount);
                break;*/

            /*default:
                selectedLabels = CitiesNameUtil.getDifferentCities(categoryCount);
                break;*/
        }

        int[] values =
                new int[categoryCount];

        for (int i = 0; i < categoryCount; i++)
        {
            values[i] = availableValues.get(i);
        }

        return new TableData(
                scenario,selectedLabels,
                values);
    }
}