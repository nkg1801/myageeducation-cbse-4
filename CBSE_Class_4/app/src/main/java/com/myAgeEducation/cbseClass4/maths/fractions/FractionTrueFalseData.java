package com.myAgeEducation.cbseClass4.maths.fractions;

public class FractionTrueFalseData
{
    public int numerator;
    public int denominator;

    public FractionTrueFalseStatementType statementType;

    public String statement;
    public boolean answer;


    public FractionTrueFalseData(int numerator,int denominator,FractionTrueFalseStatementType statementType,String statement,boolean answer)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        this.statementType = statementType;
        this.statement = statement;
        this.answer = answer;
    }
}