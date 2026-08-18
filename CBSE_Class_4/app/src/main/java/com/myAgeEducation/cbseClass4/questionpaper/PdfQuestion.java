package com.myAgeEducation.cbseClass4.questionpaper;

public class PdfQuestion
{
    private String question;
    private String[] options;
    private String imageCode;
    private String answer;

    public PdfQuestion(String question, String[] options, String imageCode, String answer)
    {
        this.question = question;
        this.options = options;
        this.imageCode = imageCode;
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public String[] getOptions()
    {
        return options;
    }

    public String getImageCode()
    {
        return imageCode;
    }

    public String getAnswer()
    {
        return answer;
    }
}
