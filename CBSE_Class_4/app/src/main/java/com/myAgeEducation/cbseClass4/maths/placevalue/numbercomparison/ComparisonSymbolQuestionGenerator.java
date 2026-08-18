package com.myAgeEducation.cbseClass4.maths.placevalue.numbercomparison;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.maths.utils.QuestionTextUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparisonSymbolQuestionGenerator
{
    private ComparisonSymbolQuestionGenerator()
    {
        // Prevent object creation
    }

    public static Question generateQuestion()
    {
        ComparisonSymbolQuestionData data = ComparisonSymbolDataGenerator.generate();
        String[] options = generateOptions();
        Question question = new Question();
        question.setQuestion(buildQuestionText(data));
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(data.correctAnswer);
        return question;
    }

    private static String buildQuestionText(ComparisonSymbolQuestionData data)
    {
        String comparison = NumberFormatUtil.formatIndianNumber(data.left) + " ___ " + NumberFormatUtil.formatIndianNumber(data.right);

        return QuestionTextUtil.random(
                "Choose the correct sign.\n\n" + comparison,
                "Fill in the correct sign.\n\n" + comparison,
                "Which symbol makes the statement correct?\n\n" + comparison,
                "Select the correct comparison sign.\n\n" + comparison,
                "Complete the comparison using the correct sign.\n\n" + comparison
        );
    }


    private static String[] generateOptions()
    {
        List<String> options = new ArrayList<>();

        options.add("<");
        options.add(">");
        options.add("=");
        options.add("≠");

        Collections.shuffle(options);

        return options.toArray(new String[0]);
    }
}
