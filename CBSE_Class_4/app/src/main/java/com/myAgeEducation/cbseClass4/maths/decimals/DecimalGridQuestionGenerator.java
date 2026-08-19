package com.myAgeEducation.cbseClass4.maths.decimals;

import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeType;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DecimalGridQuestionGenerator {
    private static final Random RANDOM = new Random();
    private static final String[] COLORS = {"#2196F3", "#FFEB3B", "#4CAF50", "#F44336"}; // Blue, Yellow, Green, Red

    public static Question generateQuestion() {
        int whole = RANDOM.nextInt(2) + 1; // 1 or 2 whole squares for simplicity
        int denominator = RANDOM.nextBoolean() ? 10 : 100;
        int numerator = RANDOM.nextInt(denominator - 1) + 1;
        String color = COLORS[RANDOM.nextInt(COLORS.length)];

        double value = whole + (double) numerator / denominator;
        String answer = String.format(denominator == 10 ? "%.1f" : "%.2f", value);

        Set<String> options = new HashSet<>();
        options.add(answer);

        // Distractors
        while (options.size() < 4) {
            double dist;
            int r = RANDOM.nextInt(3);
            if (r == 0) dist = (whole + 1) + (double) numerator / denominator;
            else if (r == 1) dist = whole + (double) numerator / (denominator == 10 ? 100 : 10);
            else dist = RANDOM.nextInt(5) + (double) RANDOM.nextInt(100) / 100;

            options.add(String.format(denominator == 10 ? "%.1f" : "%.2f", dist));
        }

        List<String> optList = new ArrayList<>(options);
        Collections.shuffle(optList);

        Question question = new Question();
        question.setQuestion("The decimal form for the shaded part given in the picture is:");
        question.setAnswer(answer);
        OptionUtils.setQuestionOptions(question, optList);
        question.setImage(ImageCodeType.DECIMAL_GRID + "_" + whole + "_" + numerator + "_" + denominator + "_" + color);
        return question;
    }
}
