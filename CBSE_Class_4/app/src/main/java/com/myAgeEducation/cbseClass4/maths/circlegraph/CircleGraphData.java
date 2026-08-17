package com.myAgeEducation.cbseClass4.maths.circlegraph;

public class CircleGraphData
{
    public String[] labels;
    public int[] values;
    public String[] fractionNames;
    public int total;

    public CircleGraphData(String[] labels, int[] values, String[] fractionNames, int total)
    {
        this.labels = labels;
        this.values = values;
        this.fractionNames = fractionNames;
        this.total = total;
    }
}