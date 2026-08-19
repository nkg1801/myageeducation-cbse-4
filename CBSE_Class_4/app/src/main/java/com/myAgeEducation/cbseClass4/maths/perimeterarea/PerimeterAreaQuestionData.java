package com.myAgeEducation.cbseClass4.maths.perimeterarea;

public class PerimeterAreaQuestionData {
    private String question;
    private String answer;
    private String[] options;
    private PerimeterAreaQuestionType type;

    public PerimeterAreaQuestionData(String question, String answer, String[] options, PerimeterAreaQuestionType type) {
        this.question = question;
        this.answer = answer;
        this.options = options;
        this.type = type;
    }

    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String[] getOptions() { return options; }
    public PerimeterAreaQuestionType getType() { return type; }
}
