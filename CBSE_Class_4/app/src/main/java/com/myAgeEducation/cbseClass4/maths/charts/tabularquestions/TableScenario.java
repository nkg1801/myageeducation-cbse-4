package com.myAgeEducation.cbseClass4.maths.charts.tabularquestions;

public class TableScenario
{
    public final String scenarioCode;
    public final String introduction;

    public final String firstColumnTitle;
    public final String secondColumnTitle;

    public String[] labels;

    public final String unit;

    public final String largestQuestion;
    public final String smallestQuestion;
    public final String secondLargestQuestion;
    public final String secondSmallestQuestion;

    public final String itemName;
    public final String pluralItemName;

    public final int minValue;
    public final int maxValue;
    public final int valueStep;
    public final String valueDescription;

    public TableScenario(
            String scenarioCode,
            String introduction,
            String firstColumnTitle,
            String secondColumnTitle,
            String[] labels,
            String unit,
            String itemName,
            String pluralItemName,
            String valueDescription,
            int minValue,
            int maxValue,
            int valueStep,
            String largestQuestion,
            String smallestQuestion,
            String secondLargestQuestion,
            String secondSmallestQuestion
            )
    {
        this.scenarioCode = scenarioCode;
        this.introduction = introduction;
        this.firstColumnTitle = firstColumnTitle;
        this.secondColumnTitle = secondColumnTitle;
        this.labels = labels;
        this.unit = unit;

        this.itemName = itemName;
        this.pluralItemName = pluralItemName;

        this.minValue = minValue;
        this.maxValue = maxValue;
        this.valueStep = valueStep;

        this.largestQuestion = largestQuestion;
        this.smallestQuestion = smallestQuestion;
        this.secondLargestQuestion = secondLargestQuestion;
        this.secondSmallestQuestion = secondSmallestQuestion;
        this.valueDescription =
                valueDescription;
    }
}
