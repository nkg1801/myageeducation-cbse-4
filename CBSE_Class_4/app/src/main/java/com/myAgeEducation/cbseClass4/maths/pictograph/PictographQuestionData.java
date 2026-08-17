package com.myAgeEducation.cbseClass4.maths.pictograph;

public class PictographQuestionData
{
    public PictographData pictographData;
    public PictographQuestionType questionType;
    public String questionText;
    public String correctAnswer;
    public String[] options;

    public PictographQuestionData(PictographData pictographData, PictographQuestionType questionType, String questionText, String correctAnswer)
    {
        this.pictographData = pictographData;
        this.questionType = questionType;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}