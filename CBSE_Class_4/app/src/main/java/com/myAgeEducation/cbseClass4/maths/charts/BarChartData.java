package com.myAgeEducation.cbseClass4.maths.charts;

public class BarChartData
{
    public final BarChartScenario scenario;

    // Final labels displayed on the chart
    public final String[] labels;
    public final String[] displayLabels;

    // Value represented by each bar
    public final int[] values;


    public BarChartData(
            BarChartScenario scenario,
            String[] labels,
            String[] displayLabels,
            int[] values)
    {
        this.scenario = scenario;
        this.labels = labels;
        this.displayLabels = displayLabels;
        this.values = values;
    }


    public String getLabel(int index)
    {
        return labels[index];
    }


    public int getValue(int index)
    {
        return values[index];
    }


    public int getCategoryCount()
    {
        return labels.length;
    }
}
