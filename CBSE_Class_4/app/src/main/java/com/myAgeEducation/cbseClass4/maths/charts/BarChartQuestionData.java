package com.myAgeEducation.cbseClass4.maths.charts;

public class BarChartQuestionData
{
    public final BarChartData barChartData;
    public final BarChartQuestionType questionType;
    public final String questionText;
    public final String correctAnswer;
    public String[] options;

    public BarChartQuestionData(BarChartData barChartData, BarChartQuestionType questionType, String questionText, String correctAnswer)
    {
        this.barChartData = barChartData;
        this.questionType = questionType;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}
