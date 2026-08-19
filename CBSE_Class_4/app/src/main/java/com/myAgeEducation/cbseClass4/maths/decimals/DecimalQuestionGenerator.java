package com.myAgeEducation.cbseClass4.maths.decimals;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import java.util.*;
import java.text.DecimalFormat;

public class DecimalQuestionGenerator {
    private static final Random RANDOM = new Random();
    private static final DecimalFormat DF1 = new DecimalFormat("0.0");
    private static final DecimalFormat DF2 = new DecimalFormat("0.00");

    public static Question generateQuestion() {
        int type = RANDOM.nextInt(7);
        DecimalQuestionData data;
        switch (type) {
            case 0: data = generateConceptQuestion(); break;
            case 1: data = generatePatternQuestion(); break;
            case 2: data = generateWordFormQuestion(); break;
            case 3: data = generateComparisonQuestion(); break;
            case 4: data = generateSequenceQuestion(); break;
            case 5: return DecimalImageQuestionGenerator.generateQuestion();
            case 6: return DecimalGridQuestionGenerator.generateQuestion();
            default: data = generateConceptQuestion();
        }
        return convertToQuestion(data);
    }

    private static DecimalQuestionData generateConceptQuestion() {
        String[][] concepts = {
            {"One-tenth is equal to _______", "0.1", "0.01", "1.0", "0.11"},
            {"Which one of the following represents one hundredth", "0.01", "0.1", "0.001", "1.0"},
            {"Which one of the following represents one tenth?", "0.1", "0.01", "1.0", "0.11"},
            {"The fraction 7/10 is written in decimal form as _______", "0.7", "0.07", "7.0", "7.7"},
            {"The fraction 5/100 is written in decimal form as _______", "0.05", "0.5", "5.0", "0.55"},
            {"In the decimal 4.5, the digit 5 is in the _______ place.", "tenths", "hundredths", "ones", "tens"},
            {"In the decimal 2.37, the digit 7 is in the _______ place.", "hundredths", "tenths", "ones", "hundreds"},
            {"The dot between the whole number part and the decimal part is called the _______ point.", "decimal", "fraction", "full", "comma"},
            {"What is the decimal form of 2 + 3/10?", "2.3", "2.03", "23.0", "0.23"},
            {"What is the decimal form of 5 + 9/100?", "5.09", "5.9", "0.59", "59.0"},
            {"Which is greater: 0.5 or 0.05?", "0.5", "0.05", "Both are equal", "Cannot say"},
            {"One whole is equal to _______ tenths.", "10", "1", "100", "0.1"},
            {"One whole is equal to _______ hundredths.", "100", "10", "1", "0.01"},
            {"0.6 is the same as _______ hundredths.", "60", "6", "600", "0.06"},
            {"Which decimal represents 15/10?", "1.5", "0.15", "15.0", "0.015"},
            {"In 12.34, the whole number part is _______.", "12", "34", "3", "4"}
        };
        int idx = RANDOM.nextInt(concepts.length);
        String[] item = concepts[idx];
        String[] options = Arrays.copyOfRange(item, 1, 5);
        List<String> optList = Arrays.asList(options);
        Collections.shuffle(optList);
        return new DecimalQuestionData(item[0], item[1], optList.toArray(new String[0]), DecimalQuestionType.DECIMAL_CONCEPT);
    }

    private static DecimalQuestionData generatePatternQuestion() {
        double start = RANDOM.nextInt(5) + (RANDOM.nextInt(10) / 10.0);
        String q = String.format("What is the next number in the following pattern: %s, %s, %s, ______",
                DF1.format(start), DF1.format(start + 0.1), DF1.format(start + 0.2));
        String ans = DF1.format(start + 0.3);
        String[] options = {ans, DF1.format(start + 0.4), DF1.format(start + 0.5), DF1.format(start + 0.25)};
        List<String> optList = Arrays.asList(options);
        Collections.shuffle(optList);
        return new DecimalQuestionData(q, ans, optList.toArray(new String[0]), DecimalQuestionType.DECIMAL_PATTERN);
    }

    private static DecimalQuestionData generateWordFormQuestion() {
        String[][] words = {
            {"What is the decimal form of: One hundredth", "0.01", "0.1", "1.0", "0.11"},
            {"What is the decimal form of: One and seven hundredths", "1.07", "1.7", "0.17", "17.0"},
            {"What is the decimal form of: One and twenty-seven hundredths", "1.27", "1.027", "12.7", "0.127"},
            {"What is the decimal form of: Five tenths", "0.5", "0.05", "5.0", "0.55"},
            {"What is the decimal form of: Nine hundredths", "0.09", "0.9", "9.0", "0.99"},
            {"What is the decimal form of: Two and three tenths", "2.3", "2.03", "23.0", "0.23"},
            {"What is the decimal form of: Fifteen and six hundredths", "15.06", "15.6", "1.56", "156.0"},
            {"What is the decimal form of: Forty-five hundredths", "0.45", "4.5", "0.045", "45.0"},
            {"What is the decimal form of: Seven and eighty-two hundredths", "7.82", "7.082", "78.2", "0.782"},
            {"What is the decimal form of: Twelve and five tenths", "12.5", "12.05", "1.25", "125.0"},
            {"What is the decimal form of: Six tenths", "0.6", "0.06", "6.0", "6.6"}
        };
        int idx = RANDOM.nextInt(words.length);
        String[] item = words[idx];
        String[] options = Arrays.copyOfRange(item, 1, 5);
        List<String> optList = Arrays.asList(options);
        Collections.shuffle(optList);
        return new DecimalQuestionData(item[0], item[1], optList.toArray(new String[0]), DecimalQuestionType.DECIMAL_WORD_FORM);
    }

    private static DecimalQuestionData generateComparisonQuestion() {
        boolean smallest = RANDOM.nextBoolean();
        double base = RANDOM.nextInt(10);
        List<Double> nums = new ArrayList<>();
        while (nums.size() < 4) {
            double val = base + (RANDOM.nextInt(10) / 10.0);
            if (!nums.contains(val)) nums.add(val);
        }
        
        List<String> sNums = new ArrayList<>();
        for (Double d : nums) sNums.add(DF1.format(d));
        
        String q;
        String ans;
        if (smallest) {
            q = "Which is the smallest number among the following: " + String.join(", ", sNums);
            Collections.sort(nums);
            ans = DF1.format(nums.get(0));
        } else {
            q = "Which is the second biggest number among the following: " + String.join(", ", sNums);
            Collections.sort(nums, Collections.reverseOrder());
            ans = DF1.format(nums.get(1));
        }
        
        String[] options = sNums.toArray(new String[0]);
        return new DecimalQuestionData(q, ans, options, DecimalQuestionType.DECIMAL_COMPARISON);
    }

    private static DecimalQuestionData generateSequenceQuestion() {
        double start = 1.35 + (RANDOM.nextInt(10) / 100.0);
        String q = String.format("What is the next number in the following pattern: %s, %s, _____ , %s, %s",
                DF2.format(start), DF2.format(start + 0.01), DF2.format(start + 0.03), DF2.format(start + 0.04));
        String ans = DF2.format(start + 0.02);
        String[] options = {ans, DF2.format(start + 0.025), DF2.format(start + 0.05), DF2.format(start + 0.015)};
        List<String> optList = Arrays.asList(options);
        Collections.shuffle(optList);
        return new DecimalQuestionData(q, ans, optList.toArray(new String[0]), DecimalQuestionType.DECIMAL_SEQUENCE);
    }

    private static Question convertToQuestion(DecimalQuestionData data) {
        Question question = new Question();
        question.setQuestion(data.getQuestion());
        question.setAnswer(data.getAnswer());
        OptionUtils.setQuestionOptions(question, data.getOptions());
        return question;
    }
}
