package com.myAgeEducation.cbseClass4.maths.pictograph;

public class PictographData
{
    public int valuePerIcon;
    public int[] iconCounts;
    public PictographIconType iconType;
    public PictographScenario scenario;

    public PictographData(int valuePerIcon, int[] iconCounts, PictographScenario scenario, PictographIconType iconType)
    {
        this.valuePerIcon = valuePerIcon;
        this.iconCounts = iconCounts;
        this.scenario = scenario;
        this.iconType = iconType;
    }

    public int getValueForCategory(int categoryIndex)
    {
        return iconCounts[categoryIndex] * valuePerIcon;
    }

    public int getCategoryCount()
    {
        return iconCounts.length;
    }

    public String getLabel(int index)
    {
        return scenario.getLabel(index);
    }

    public int getLabelCount()
    {
        return scenario.getLabelCount();
    }

    public String[] getLabels()
    {
        return scenario.getParsedLabels();
    }
}