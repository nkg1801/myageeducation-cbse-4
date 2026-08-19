package com.myAgeEducation.cbseClass4.maths.factors;

public class FactorQuestionData
{
    public int number;
    public int secondNumber;

    public int factor;

    public String question;
    public String answer;

    public String[] options;

    public FactorQuestionType type;

    public FactorQuestionData(
            int number,
            int secondNumber,
            int factor,
            String question,
            String answer,
            String[] options,
            FactorQuestionType type)
    {
        this.number = number;
        this.secondNumber = secondNumber;
        this.factor = factor;

        this.question = question;
        this.answer = answer;

        this.options = options;

        this.type = type;
    }
}