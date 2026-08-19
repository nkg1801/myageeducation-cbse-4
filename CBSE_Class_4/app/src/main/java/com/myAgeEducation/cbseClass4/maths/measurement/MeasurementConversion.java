package com.myAgeEducation.cbseClass4.maths.measurement;

public class MeasurementConversion
{
    public MeasurementUnit fromUnit;
    public int fromValue;

    public MeasurementUnit toUnit;
    public int toValue;


    public MeasurementConversion(
            MeasurementUnit fromUnit,
            int fromValue,
            MeasurementUnit toUnit,
            int toValue)
    {
        this.fromUnit = fromUnit;
        this.fromValue = fromValue;
        this.toUnit = toUnit;
        this.toValue = toValue;
    }
}