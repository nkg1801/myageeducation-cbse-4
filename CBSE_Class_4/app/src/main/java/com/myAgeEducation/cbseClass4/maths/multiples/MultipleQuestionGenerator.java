package com.myAgeEducation.cbseClass4.maths.multiples;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MultipleQuestionGenerator {
    private static final Random RANDOM = new Random();

    public static Question generateQuestion() {
        MultipleQuestionType[] types = MultipleQuestionType.values();
        MultipleQuestionType type = types[RANDOM.nextInt(types.length)];
        MultipleQuestionData data = generateQuestion(type);
        return convertToQuestion(data);
    }

    public static MultipleQuestionData generateQuestion(MultipleQuestionType type) {
        switch (type) {
            case MULTIPLE_TRUE_FALSE:
                return generateMultipleTrueFalse();
            case LIST_MULTIPLE_TRUE_FALSE:
                return generateListMultipleTrueFalse();
            case PROPERTY_ONE_MULTIPLE:
                return generatePropertyQuestion(MultipleQuestionType.PROPERTY_ONE_MULTIPLE);
            case PROPERTY_SELF_MULTIPLE:
                return generatePropertyQuestion(MultipleQuestionType.PROPERTY_SELF_MULTIPLE);
            case PROPERTY_MULTIPLE_OF_ONE:
                return generatePropertyQuestion(MultipleQuestionType.PROPERTY_MULTIPLE_OF_ONE);
            case COMMON_MULTIPLE:
                return generateCommonMultiple();
            default:
                return generateMultipleTrueFalse();
        }
    }

    private static MultipleQuestionData generateMultipleTrueFalse() {
        int base = 2 + RANDOM.nextInt(11); // 2-12
        boolean isTrue = RANDOM.nextBoolean();
        int multiple;
        if (isTrue) {
            multiple = base * (2 + RANDOM.nextInt(10));
        } else {
            multiple = base * (2 + RANDOM.nextInt(10)) + 1;
        }
        
        String[] templates = MultipleQuestionTemplatesUtil.getQuestionTemplates(MultipleQuestionType.MULTIPLE_TRUE_FALSE);
        String question = String.format(templates[RANDOM.nextInt(templates.length)], multiple, base);
        String answer = isTrue ? "TRUE" : "FALSE";
        
        return new MultipleQuestionData(multiple, base, 0, question, answer, MultipleOptionUtils.generateTrueFalseOptions(), MultipleQuestionType.MULTIPLE_TRUE_FALSE);
    }

    private static MultipleQuestionData generateListMultipleTrueFalse() {
        int base = 2 + RANDOM.nextInt(8); // 2-9
        boolean isTrue = RANDOM.nextBoolean();
        List<Integer> multiples = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            multiples.add(base * i);
        }
        
        if (!isTrue) {
            // Change one to be not a multiple
            int index = RANDOM.nextInt(multiples.size());
            multiples.set(index, multiples.get(index) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multiples.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(multiples.get(i));
        }
        
        String[] templates = MultipleQuestionTemplatesUtil.getQuestionTemplates(MultipleQuestionType.LIST_MULTIPLE_TRUE_FALSE);
        String question = String.format(templates[RANDOM.nextInt(templates.length)], sb.toString(), base);
        String answer = isTrue ? "TRUE" : "FALSE";
        
        return new MultipleQuestionData(base, 0, 0, question, answer, MultipleOptionUtils.generateTrueFalseOptions(), MultipleQuestionType.LIST_MULTIPLE_TRUE_FALSE);
    }

    private static MultipleQuestionData generatePropertyQuestion(MultipleQuestionType type) {
        String[] templates = MultipleQuestionTemplatesUtil.getQuestionTemplates(type);
        String question = templates[RANDOM.nextInt(templates.length)];
        
        // 1 is a multiple of every number -> FALSE (1 is a factor of every number, but a multiple only of 1)
        // A number is a multiple of itself -> TRUE
        // Every number is a multiple of 1 -> TRUE
        
        String answer;
        if (type == MultipleQuestionType.PROPERTY_ONE_MULTIPLE) {
            answer = "FALSE";
        } else {
            answer = "TRUE";
        }
        
        return new MultipleQuestionData(0, 0, 0, question, answer, MultipleOptionUtils.generateTrueFalseOptions(), type);
    }

    private static MultipleQuestionData generateCommonMultiple() {
        int n1 = 2 + RANDOM.nextInt(5); // 2-6
        int n2 = 2 + RANDOM.nextInt(5); // 2-6
        while (n1 == n2) n2 = 2 + RANDOM.nextInt(5);
        
        String[] options = MultipleOptionUtils.generateCommonMultipleOptions(n1, n2);
        String answer = "";
        for (String opt : options) {
            int val = Integer.parseInt(opt);
            if (val % n1 == 0 && val % n2 == 0) {
                answer = opt;
                break;
            }
        }
        
        String[] templates = MultipleQuestionTemplatesUtil.getQuestionTemplates(MultipleQuestionType.COMMON_MULTIPLE);
        String question = String.format(templates[RANDOM.nextInt(templates.length)], n1, n2);
        
        return new MultipleQuestionData(n1, n2, 0, question, answer, options, MultipleQuestionType.COMMON_MULTIPLE);
    }

    private static Question convertToQuestion(MultipleQuestionData data) {
        Question q = new Question();
        q.setQuestion(data.question);
        q.setAnswer(data.answer);
        OptionUtils.setQuestionOptions(q, data.options);
        return q;
    }
}
