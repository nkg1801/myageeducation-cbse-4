package com.myAgeEducation.cbseClass4.maths.pictograph;
import android.text.TextUtils;
import java.util.Random;

public class PictographScenario
{
    public String scenarioCode;
    public String introduction;
    public String labels;
    private transient String[] parsedLabels;
    public String itemName;
    public String pluralItemName;
    public String mostQuestion;
    public String fewestQuestion;
    public String totalInCategoryTemplate;
    public String moreThanTemplate;
    public String totalTwoCategoriesTemplate;
    public String sameValueTemplate;
    public String totalAllQuestion;
    public String allowedIconTypes;

    private transient PictographIconType[] parsedAllowedIconTypes;

    public PictographScenario()
    {

    }

    public PictographScenario(
            String scenarioCode,
            String introduction,
            String labels,
            String itemName,
            String pluralItemName,
            String mostQuestion,
            String fewestQuestion,
            String totalInCategoryTemplate,
            String moreThanTemplate,
            String totalTwoCategoriesTemplate,
            String sameValueTemplate,
            String totalAllQuestion,
            String allowedIconTypes)
    {
        this.scenarioCode = scenarioCode;
        this.introduction = introduction;
        this.labels = labels;
        this.itemName = itemName;
        this.pluralItemName = pluralItemName;
        this.mostQuestion = mostQuestion;
        this.fewestQuestion = fewestQuestion;

        this.totalInCategoryTemplate = totalInCategoryTemplate;
        this.moreThanTemplate = moreThanTemplate;
        this.totalTwoCategoriesTemplate = totalTwoCategoriesTemplate;
        this.sameValueTemplate = sameValueTemplate;
        this.totalAllQuestion = totalAllQuestion;

        this.allowedIconTypes = allowedIconTypes;
    }

    public String[] getParsedLabels()
    {
        if (parsedLabels == null)
        {
            if (labels == null)
            {
                return new String[0];
            }

            parsedLabels = labels.split("\\s*,\\s*");
        }

        return parsedLabels;
    }

    public void setLabelsForPictograph(String[] labels)
    {
        this.labels = TextUtils.join(",", labels);

        // VERY IMPORTANT
        this.parsedLabels = null;
    }

    public String getLabel(int index)
    {
        return getParsedLabels()[index];
    }

    public int getLabelCount()
    {
        return getParsedLabels().length;
    }

    public PictographIconType[] getParsedAllowedIconTypes()
    {
        if (parsedAllowedIconTypes == null)
        {
            String[] values = allowedIconTypes.split("\\s*,\\s*");
            parsedAllowedIconTypes = new PictographIconType[values.length];

            for (int i = 0; i < values.length; i++)
            {
                parsedAllowedIconTypes[i] = PictographIconType.valueOf(values[i]);
            }
        }

        return parsedAllowedIconTypes;
    }

    public PictographIconType getRandomAllowedIconType()
    {
        PictographIconType[] types = getParsedAllowedIconTypes();
        return types[new Random().nextInt(types.length)];
    }
}