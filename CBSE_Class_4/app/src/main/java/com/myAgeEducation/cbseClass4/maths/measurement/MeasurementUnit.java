package com.myAgeEducation.cbseClass4.maths.measurement;

public enum MeasurementUnit
{
    MILLIMETRE("mm"),
    CENTIMETRE("cm"),
    METRE("m"),
    KILOMETRE("km"),

    GRAM("g"),
    KILOGRAM("kg"),

    MILLILITRE("ml"),
    LITRE("l");

    private final String symbol;

    MeasurementUnit(String symbol)
    {
        this.symbol = symbol;
    }

    public String getSymbol()
    {
        return symbol;
    }
}