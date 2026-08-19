package com.myAgeEducation.cbseClass4.maths.additions;

import com.myAgeEducation.cbseClass4.OptionUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.LinkedHashSet;
import java.util.Set;

public class AdditionStoryQuestionGenerator
{
    private AdditionStoryQuestionGenerator()
    {
    }

    public static Question generateQuestion()
    {
        AdditionStoryQuestionData data =AdditionStoryDataGenerator.generate();
        String correctAnswer = String.valueOf(data.answer);
        String[] options = generateOptions(data.answer);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(correctAnswer);
        return question;
    }

    private static String[] generateOptions(int correctAnswer)
    {
        Set<String> distractors = new LinkedHashSet<>();
        distractors.add(String.valueOf(correctAnswer + 1));
        distractors.add(String.valueOf(correctAnswer - 1));
        distractors.add(String.valueOf(correctAnswer + 10));
        distractors.add(String.valueOf(correctAnswer - 10));
        distractors.add(String.valueOf(correctAnswer + 2));
        distractors.add(String.valueOf(correctAnswer - 2));
        return OptionUtil.createOptions(String.valueOf(correctAnswer), distractors, 4);
    }
}