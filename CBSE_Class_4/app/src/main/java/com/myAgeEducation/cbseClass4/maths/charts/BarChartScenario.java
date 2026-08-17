package com.myAgeEducation.cbseClass4.maths.charts;

public class BarChartScenario
{
    public final String scenarioCode;
    public final String introduction;

    public final String[] labels;
    public final String[] displayLabels;

    public final String itemName;
    public final String pluralItemName;

    public final String mostQuestion;
    public final String fewestQuestion;

    public final String secondMostQuestion;
    public final String secondFewestQuestion;

    public final String valueQuestion;
    public final String moreThanQuestion;
    public final String fewerThanQuestion;
    public final String totalTwoQuestion;
    public final String totalAllQuestion;



    public BarChartScenario(
            String scenarioCode,
            String introduction,
            String[] labels,
            String[] displayLabels,
            String itemName,
            String pluralItemName,
            String mostQuestion,
            String fewestQuestion,
            String secondMostQuestion,
            String secondFewestQuestion,
            String valueQuestion,
            String moreThanQuestion,
            String fewerThanQuestion,
            String totalTwoQuestion,
            String totalAllQuestion)
    {
        this.scenarioCode = scenarioCode;
        this.introduction = introduction;
        this.labels = labels;
        this.displayLabels = displayLabels;

        this.itemName = itemName;
        this.pluralItemName = pluralItemName;

        this.mostQuestion = mostQuestion;
        this.fewestQuestion = fewestQuestion;
        this.secondMostQuestion = secondMostQuestion;
        this.secondFewestQuestion = secondFewestQuestion;

        this.valueQuestion = valueQuestion;
        this.moreThanQuestion = moreThanQuestion;
        this.fewerThanQuestion = fewerThanQuestion;
        this.totalTwoQuestion = totalTwoQuestion;
        this.totalAllQuestion = totalAllQuestion;
    }
}
