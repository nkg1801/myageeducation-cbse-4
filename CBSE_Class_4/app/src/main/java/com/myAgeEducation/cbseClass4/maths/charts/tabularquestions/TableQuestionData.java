package com.myAgeEducation.cbseClass4.maths.charts.tabularquestions;

public class TableQuestionData
{
    public final TableData tableData;
    public final TableQuestionType type;
    public final String questionText;
    public final String correctAnswer;

    public String[] options;

    public TableQuestionData(
            TableData tableData,
            TableQuestionType type,
            String questionText,
            String correctAnswer)
    {
        this.tableData = tableData;
        this.type = type;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}