package com.myAgeEducation.cbseClass4.maths.fractions;

public class FractionData {

    public final int numerator;       // Coloured parts
    public final int denominator;     // Total parts

    public final FractionImageGenerator.FractionShape shape;
    public final FractionImageGenerator.FractionTheme theme;
    public final int variation;

    public FractionData(int numerator, int denominator, FractionImageGenerator.FractionShape shape, FractionImageGenerator.FractionTheme theme, int variation)
    {

        this.numerator = numerator;
        this.denominator = denominator;
        this.shape = shape;
        this.theme = theme;
        this.variation = variation;
    }

    public int getUncolouredParts() {
        return denominator - numerator;
    }

    public String getImageCode() {

        return "SHAPE-PART-FRACTION_"
                + denominator + "_"
                + numerator + "_"
                + shape.name() + "_"
                + theme.name() + "_"
                + variation;
    }
}
