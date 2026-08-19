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

public class DecimalImageQuestionGenerator {
    private static final Random RANDOM = new Random();

    public static Question generateQuestion() {
        int type = RANDOM.nextInt(2);
        if (type == 0) {
            return generateDecimalFormQuestion();
        } else {
            return generateWordFormQuestion();
        }
    }

    private static Question generateDecimalFormQuestion() {
        int whole = RANDOM.nextInt(10);
        int denominator = RANDOM.nextBoolean() ? 10 : 100;
        int numerator = RANDOM.nextInt(denominator - 1) + 1;

        double value = whole + (double) numerator / denominator;
        String answer = String.format(denominator == 10 ? "%.1f" : "%.2f", value);

        Set<String> options = new HashSet<>();
        options.add(answer);

        // Distractors
        while (options.size() < 4) {
            double dist;
            int r = RANDOM.nextInt(4);
            if (r == 0) dist = whole + (double) numerator / (denominator == 10 ? 100 : 10);
            else if (r == 1) dist = numerator + (double) whole / denominator;
            else dist = RANDOM.nextInt(10) + (double) RANDOM.nextInt(100) / 100;
            
            options.add(String.format(denominator == 10 ? "%.1f" : "%.2f", dist));
        }

        List<String> optList = new ArrayList<>(options);
        Collections.shuffle(optList);

        Question question = new Question();
        question.setQuestion("What is the decimal form of the fraction given in the picture");
        question.setAnswer(answer);
        OptionUtils.setQuestionOptions(question, optList);
        question.setImage(getImageCode(whole, numerator, denominator));
        return question;
    }

    private static Question generateWordFormQuestion() {
        int whole = RANDOM.nextInt(10);
        int denominator = RANDOM.nextBoolean() ? 10 : 100;
        int numerator = RANDOM.nextInt(denominator - 1) + 1;

        String answer = decimalToWords(whole, numerator, denominator);

        Set<String> options = new HashSet<>();
        options.add(answer);

        // Distractors
        while (options.size() < 4) {
            int w = RANDOM.nextInt(10);
            int d = RANDOM.nextBoolean() ? 10 : 100;
            int n = RANDOM.nextInt(d - 1) + 1;
            options.add(decimalToWords(w, n, d));
        }

        List<String> optList = new ArrayList<>(options);
        Collections.shuffle(optList);

        Question question = new Question();
        question.setQuestion("The fraction given in the picture can be written in words as:");
        question.setAnswer(answer);
        OptionUtils.setQuestionOptions(question, optList);
        question.setImage(getImageCode(whole, numerator, denominator));
        return question;
    }

    private static String getImageCode(int whole, int numerator, int denominator) {
        return ImageCodeType.DECIMAL_IMAGE + "_" + whole + "_" + numerator + "_" + denominator;
    }

    private static String decimalToWords(int whole, int numerator, int denominator) {
        String[] numbers = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
        
        StringBuilder sb = new StringBuilder();
        if (whole > 0) {
            if (whole <= 20) sb.append(numbers[whole]);
            else sb.append(whole);
            sb.append(" and ");
        }

        if (numerator <= 20) sb.append(numbers[numerator]);
        else sb.append(numerator);

        sb.append(" ");
        if (denominator == 10) {
            sb.append("tenth");
        } else {
            sb.append("hundredth");
        }
        
        if (numerator > 1) {
            sb.append("s");
        }

        return sb.toString();
    }
}
