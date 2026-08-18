package com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

public class NumberComparisonQuestionGenerator
{
    private NumberComparisonQuestionGenerator()
    {
        // Prevent object creation
    }

    private static String buildQuestionText(NumberComparisonQuestionData data)
    {
        if (data.questionType == ComparisonQuestionType.WHICH_IS_TRUE)
        {
            return "Which is true?";
        }

        return "Which is false?";
    }

    public static Question generateQuestion()
    {
        NumberComparisonQuestionData data = NumberComparisonDataGenerator.generate();
        Question question = new Question();
        question.setQuestion(buildQuestionText(data));
        OptionUtils.setQuestionOptions(question, data.statements);
        question.setAnswer(data.correctAnswer);
        return question;
    }
}
