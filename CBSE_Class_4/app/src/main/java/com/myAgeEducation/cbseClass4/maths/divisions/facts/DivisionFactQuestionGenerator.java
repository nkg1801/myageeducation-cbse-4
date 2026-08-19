package com.myAgeEducation.cbseClass4.maths.divisions.facts;

import com.myAgeEducation.cbseClass4.maths.utils.OptionUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DivisionFactQuestionGenerator {
    private static final Random RANDOM =
            new Random();

    private DivisionFactQuestionGenerator() {
    }

    public static Question generateQuestion() {
        DivisionFactQuestionData data = DivisionFactDataGenerator.generate();
        String[] options = generateOptions(data);
        Question question = new Question();
        question.setQuestion(data.question);
        OptionUtils.setQuestionOptions(question, options);
        question.setAnswer(String.valueOf(data.answer));
        return question;
    }

    private static String[] generateOptions(DivisionFactQuestionData data)
    {
        switch (data.template.type)
        {
            case BASIC_DIVISION:
            case MISSING_DIVISOR:
            case MISSING_QUOTIENT:
            case PAIRS:
            case FACT_FAMILY:
                return OptionUtil.createNearbyOptions(
                        data.answer);

            case DIVIDE_BY_ONE:
                return OptionUtil.createIdentityOptions(
                        data.answer,
                        0,
                        1,
                        data.answer - 1);

            case DIVIDE_BY_SELF:
                return createDivideBySelfOptions(
                        data);

            case IDENTIFY_DIVISOR:
            case IDENTIFY_DIVIDEND:
            case IDENTIFY_QUOTIENT:
                return OptionUtil.createIdentifyPartOptions(
                        data.answer,
                        data.dividend,
                        data.divisor,
                        data.quotient);

            default:
                throw new IllegalArgumentException("Unhandled DivisionFactType : " + data.template.type);
        }
    }

    private static String[] createBasicDivisionOptions(
            DivisionFactQuestionData data)
    {
        Set<String> options =
                new LinkedHashSet<>();

        int answer =
                data.answer;

        options.add(
                String.valueOf(answer));

        addOption(options, answer - 1);
        addOption(options, answer + 1);

        addOption(options, answer - 2);
        addOption(options, answer + 2);

        return finalizeOptions(options);
    }

    private static void addOption(
            Set<String> options,
            int value)
    {
        if (value >= 0)
        {
            options.add(String.valueOf(value));
        }
    }

    private static String[] createMissingDivisorOptions(
            DivisionFactQuestionData data)
    {
        return createBasicDivisionOptions(data);
    }

    private static String[] createPairsOptions(
            DivisionFactQuestionData data)
    {
        return createBasicDivisionOptions(data);
    }

    private static String[] createDivideBySelfOptions(
            DivisionFactQuestionData data)
    {
        Set<String> options =
                new LinkedHashSet<>();

        options.add("1");
        options.add("0");
        options.add("2");
        options.add(String.valueOf(data.answer * data.answer));

        return finalizeOptions(options);
    }




    private static String[] finalizeOptions(
            Set<String> options)
    {
        while (options.size() < 4)
        {
            int value =
                    RANDOM.nextInt(20) + 1;

            options.add(String.valueOf(value));
        }

        List<String> list =
                new ArrayList<>(options);

        Collections.shuffle(list);

        return new String[]
                {
                        list.get(0),
                        list.get(1),
                        list.get(2),
                        list.get(3)
                };
    }
}
