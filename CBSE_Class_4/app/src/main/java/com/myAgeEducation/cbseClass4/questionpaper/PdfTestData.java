package com.myAgeEducation.cbseClass4.questionpaper;

import java.util.List;

public class PdfTestData
{
    public String subject;
    public String className;
    public String title;
    public int totalMarks;
    public String time;
    public List<PdfQuestion> questions;

    public PdfTestData(
            String subject,
            String className,
            String title,
            int totalMarks,
            String time,
            List<PdfQuestion> questions)
    {
        this.subject = subject;
        this.className = className;
        this.title = title;
        this.totalMarks = totalMarks;
        this.time = time;
        this.questions = questions;
    }
}
