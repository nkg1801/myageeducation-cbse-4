package com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison;

public class NumberComparisonQuestionData
{
    public final String[] statements;

    public final String correctAnswer;

    public final ComparisonQuestionType questionType;

    public NumberComparisonQuestionData(
            String[] statements,
            String correctAnswer,
            ComparisonQuestionType questionType)
    {
        this.statements = statements;
        this.correctAnswer = correctAnswer;
        this.questionType = questionType;
    }
}