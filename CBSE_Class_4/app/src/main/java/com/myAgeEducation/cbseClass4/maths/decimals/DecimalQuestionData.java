package com.myAgeEducation.cbseClass4.maths.decimals;

public class DecimalQuestionData {
    private String question;
    private String answer;
    private String[] options;
    private DecimalQuestionType type;

    public DecimalQuestionData(String question, String answer, String[] options, DecimalQuestionType type) {
        this.question = question;
        this.answer = answer;
        this.options = options;
        this.type = type;
    }

    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String[] getOptions() { return options; }
    public DecimalQuestionType getType() { return type; }
}
