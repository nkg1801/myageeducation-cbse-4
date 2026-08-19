package com.myAgeEducation.cbseClass4.maths.fractions;

import com.myAgeEducation.cbseClass4.maths.fractions.FractionData;

public class ChoiceFractionData {
    public FractionData[] fractions = new FractionData[4];
    public int correctIndex;
    public String imageCode;
    public String questionText;
    public String answer;

    public String getCorrectOption()
    {
        return String.valueOf((char)('A' + correctIndex));
    }
}
