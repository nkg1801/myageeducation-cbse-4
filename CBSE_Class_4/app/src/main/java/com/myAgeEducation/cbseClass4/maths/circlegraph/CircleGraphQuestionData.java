package com.myAgeEducation.cbseClass4.maths.circlegraph;

public class CircleGraphQuestionData
{
    public CircleGraphData graphData;
    public CircleGraphQuestionType type;
    public String question;
    public String correctAnswer;

    public CircleGraphQuestionData(
            CircleGraphData graphData,
            CircleGraphQuestionType type,
            String question,
            String correctAnswer)
    {
        this.graphData = graphData;
        this.type = type;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }
}
