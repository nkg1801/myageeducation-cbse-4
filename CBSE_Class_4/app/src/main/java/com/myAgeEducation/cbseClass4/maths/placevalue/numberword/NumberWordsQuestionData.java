package com.myAgeEducation.cbseClass4.maths.placevalue.numberword;

public class NumberWordsQuestionData
{
    public final NumberWordsQuestionType type;
    public final int number;
    public final String numberInWords;
    public final String questionText;
    public final String correctAnswer;
    public String[] options;

    public NumberWordsQuestionData(
            NumberWordsQuestionType type,
            int number,
            String numberInWords,
            String questionText,
            String correctAnswer)
    {
        this.type = type;
        this.number = number;
        this.numberInWords = numberInWords;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}