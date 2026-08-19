package com.myAgeEducation.cbseClass4.maths.multiplication;

import com.myAgeEducation.cbseClass4.maths.utils.NumberPair;
import com.myAgeEducation.cbseClass4.maths.utils.NumberPairUtil;
import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacter;

import java.util.Random;

public class MultiplicationStoryDataGenerator
{
    private static final Random RANDOM = new Random();

    private MultiplicationStoryDataGenerator()
    {
    }

    public static MultiplicationStoryQuestionData generate() {
        MultiplicationStoryTemplate template =
                MultiplicationStoryTemplates.EQUAL_GROUP_TEMPLATES[
                        RANDOM.nextInt(
                                MultiplicationStoryTemplates.EQUAL_GROUP_TEMPLATES.length)];

        switch (template.type) {
            case EQUAL_GROUPS:
                return generateEqualGroups();

            case MULTIPLY_BY_10:
                return generateMultiplyBy10();

            case TIME_CONVERSION:
                return generateWeeks();

            case REPEATED_EVENT:
                return generateRepeatedEvent();

            case SCALING:
                return generateScaling();

            default:
                throw new IllegalArgumentException(
                        "Unknown multiplication story type");
        }

    }

    private static String formatQuestion(
            MultiplicationStoryTemplate template,
            StoryCharacter character,
            String secondPerson,
            int firstNumber,
            int secondNumber)
    {
        return String.format(
                template.questionTemplate,

                character != null
                        ? character.getName()
                        : "",

                firstNumber,

                secondPerson != null
                        ? secondPerson
                        : "",

                secondNumber,

                character != null
                        ? character.getPossessivePronoun()
                        : "",

                character != null
                        ? character.getObjectPronoun()
                        : "");
    }

    private static MultiplicationStoryQuestionData createQuestion(
            MultiplicationStoryTemplate template,
            StoryCharacter character,
            String secondPerson,
            int firstNumber,
            int secondNumber,
            int answer)
    {
        return new MultiplicationStoryQuestionData(
                template,
                formatQuestion(
                        template,
                        character,
                        secondPerson,
                        firstNumber,
                        secondNumber),
                firstNumber,
                secondNumber,
                answer);
    }

    private static MultiplicationStoryQuestionData generateEqualGroups()
    {
        MultiplicationStoryTemplate template =
                getRandomTemplate(
                        MultiplicationStoryTemplates.EQUAL_GROUP_TEMPLATES);

        NumberPair numbers =
                NumberPairUtil.randomPair(
                        20,
                        150,
                        20,
                        100);

        return createQuestion(
                template,
                null,
                null,
                numbers.getFirst(),
                numbers.getSecond(),
                numbers.getFirst() * numbers.getSecond());
    }

    private static MultiplicationStoryQuestionData generateMultiplyBy10()
    {
        MultiplicationStoryTemplate template =
                getRandomTemplate(
                        MultiplicationStoryTemplates.MULTIPLY_BY_10_TEMPLATES);

        int number = RANDOM.nextInt(98) + 2;

        return createQuestion(
                template,
                null,
                null,
                number,
                10,
                number * 10);
    }

    private static MultiplicationStoryQuestionData generateWeeks()
    {
        MultiplicationStoryTemplate template =
                getRandomTemplate(
                        MultiplicationStoryTemplates.TIME_CONVERSION_TEMPLATES);

        int weeks = RANDOM.nextInt(11) + 2;

        int factor = 7;

        return createQuestion(
                template,
                null,
                null,
                weeks,
                factor,
                weeks * factor);
    }

    private static MultiplicationStoryQuestionData generateRepeatedEvent()
    {
        MultiplicationStoryTemplate template =
                getRandomTemplate(
                        MultiplicationStoryTemplates.REPEATED_EVENT_TEMPLATES);

        NumberPair numbers =
                NumberPairUtil.randomPair(
                        20,
                        30,
                        2,
                        10);

        return createQuestion(
                template,
                null,
                null,
                numbers.getFirst(),
                numbers.getSecond(),
                numbers.getFirst() * numbers.getSecond());
    }

    private static MultiplicationStoryQuestionData generateScaling()
    {
        MultiplicationStoryTemplate template =
                getRandomTemplate(
                        MultiplicationStoryTemplates.SCALING_TEMPLATES);

        NumberPair numbers =
                NumberPairUtil.randomPair(
                        2,
                        12,
                        2,
                        10);

        return createQuestion(
                template,
                null,
                null,
                numbers.getFirst(),
                numbers.getSecond(),
                numbers.getFirst() * numbers.getSecond());
    }

    private static MultiplicationStoryTemplate getRandomTemplate(
            MultiplicationStoryTemplate[] templates)
    {
        return templates[
                RANDOM.nextInt(
                        templates.length)];
    }


    }