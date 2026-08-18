package com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison;

public class ComparisonStatement
{
    public final int left;

    public final int right;

    public final boolean isTrue;


    public ComparisonStatement(
            int left,
            int right,
            boolean isTrue)
    {
        this.left = left;
        this.right = right;
        this.isTrue = isTrue;
    }
}
