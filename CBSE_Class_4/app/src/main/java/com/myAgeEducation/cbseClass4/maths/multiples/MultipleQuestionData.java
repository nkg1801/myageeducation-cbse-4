package com.myAgeEducation.cbseClass4.maths.multiples;

public class MultipleQuestionData {
    public int number1;
    public int number2;
    public int result;

    public String question;
    public String answer;
    public String[] options;

    public MultipleQuestionType type;

    public MultipleQuestionData(int number1, int number2, int result, String question, String answer, String[] options, MultipleQuestionType type) {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
        this.question = question;
        this.answer = answer;
        this.options = options;
        this.type = type;
    }
}
