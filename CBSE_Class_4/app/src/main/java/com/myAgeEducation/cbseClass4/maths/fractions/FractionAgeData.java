package com.myAgeEducation.cbseClass4.maths.fractions;

public class FractionAgeData
{
    public int referenceAge;
    public int youngerAge;
    public int denominator;
    public AgeRelationship relationship;

    public FractionAgeData(
            int referenceAge,
            int youngerAge,
            int denominator,
            AgeRelationship relationship)
    {
        this.referenceAge = referenceAge;
        this.youngerAge = youngerAge;
        this.denominator = denominator;
        this.relationship = relationship;
    }

    public enum AgeRelationship
    {
        FATHER,
        MOTHER,
        BROTHER,
        SISTER
    }
}
