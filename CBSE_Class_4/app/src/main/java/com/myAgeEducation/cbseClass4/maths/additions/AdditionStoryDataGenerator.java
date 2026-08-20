package com.myAgeEducation.cbseClass4.maths.additions;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.maths.utils.NumberPair;
import com.myAgeEducation.cbseClass4.maths.utils.NumberPairUtil;
import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacter;
import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacterUtil;

import java.util.Random;

public class AdditionStoryDataGenerator
{
    private static final Random RANDOM = new Random();
    final static int SMALLER_FIRST_MIN = 100;
    final static int SMALLER_FIRST_MAX = 500;
    final static int SMALLER_SECOND_MIN = 100;
    final static int SMALLER_SECOND_MAX = 500;

    final static int HIGHER_FIRST_MIN = 100;
    final static int HIGHER_FIRST_MAX = 50000;
    final static int HIGHER_SECOND_MIN = 100;
    final static int HIGHER_SECOND_MAX = 50000;

    static int FIRST_MIN;
    static int FIRST_MAX;
    static int SECOND_MIN;
    static int SECOND_MAX;

    private AdditionStoryDataGenerator()
    {
    }

    public static AdditionStoryQuestionData generate()
    {
        AdditionStoryTemplate template;
        int random = RANDOM.nextInt(100);
        if(random < 75)
        {
            template = AdditionStoryTemplates.BIGGER_NUMBER_TEMPLATES[RANDOM.nextInt(AdditionStoryTemplates.BIGGER_NUMBER_TEMPLATES.length)];
            FIRST_MIN = HIGHER_FIRST_MIN;
            FIRST_MAX = HIGHER_FIRST_MAX;
            SECOND_MIN = HIGHER_SECOND_MIN;
            SECOND_MAX = HIGHER_SECOND_MAX;
        }
        else {
            template = AdditionStoryTemplates.SMALLER_NUMBER_TEMPLATES[RANDOM.nextInt(AdditionStoryTemplates.SMALLER_NUMBER_TEMPLATES.length)];
            FIRST_MIN = SMALLER_FIRST_MIN;
            FIRST_MAX = SMALLER_FIRST_MAX;
            SECOND_MIN = SMALLER_SECOND_MIN;
            SECOND_MAX = SMALLER_SECOND_MAX;
        }
        //AdditionStoryTemplate template = AdditionStoryTemplates.SMALLER_NUMBER_TEMPLATES[RANDOM.nextInt(AdditionStoryTemplates.SMALLER_NUMBER_TEMPLATES.length)];

        switch (template.type)
        {
            case HAS_MORE:
                return generateHasMore(template);

            case TWO_PEOPLE:
                return generateTwoPeople(template);

            case GROUP_GROWS:
                return generateGroupGrows(template);

            case TWO_PARTS:
                return generateTwoParts(template);

            case UNKNOWN_START:
                return generateUnknownStart(template);

            default:
                throw new IllegalArgumentException("Unknown story type");
        }
    }

    private static AdditionStoryQuestionData generateHasMore(AdditionStoryTemplate template)
    {
        StoryCharacter character = StoryCharacterUtil.getRandomCharacter();
        String secondPerson = StoryCharacterUtil.getAnotherPersonName(character);
        NumberPair numbers = NumberPairUtil.randomPair(
                FIRST_MIN,
                FIRST_MAX,
                SECOND_MIN,
                SECOND_MAX);

        return new AdditionStoryQuestionData(
                template,
                formatQuestion(
                        template,
                        character,
                        secondPerson,
                        numbers.getFirst(),
                        numbers.getSecond()),
                numbers.getFirst()
                        + numbers.getSecond());
    }

    private static AdditionStoryQuestionData generateTwoPeople(AdditionStoryTemplate template)
    {
        StoryCharacter character = StoryCharacterUtil.getRandomCharacter();

        String secondPerson =
                StoryCharacterUtil.getAnotherPersonName(
                        character);

        NumberPair numbers =
                NumberPairUtil.randomPair(
                        FIRST_MIN,
                        FIRST_MAX,
                        SECOND_MIN,
                        SECOND_MAX);

        return new AdditionStoryQuestionData(
                template,
                formatQuestion(
                        template,
                        character,
                        secondPerson,
                        numbers.getFirst(),
                        numbers.getSecond()),
                numbers.getFirst()
                        + numbers.getSecond());
    }

    private static AdditionStoryQuestionData generateGroupGrows(
            AdditionStoryTemplate template)
    {
        NumberPair numbers =
                NumberPairUtil.randomPair(
                        FIRST_MIN,
                        FIRST_MAX,
                        SECOND_MIN,
                        SECOND_MAX);

        return new AdditionStoryQuestionData(
                template,
                formatQuestion(
                        template,
                        null,
                        null,
                        numbers.getFirst(),
                        numbers.getSecond()),
                numbers.getFirst()
                        + numbers.getSecond());
    }

    private static AdditionStoryQuestionData generateTwoParts(
            AdditionStoryTemplate template)
    {
        StoryCharacter character =
                StoryCharacterUtil.getRandomCharacter();

        NumberPair numbers =
                NumberPairUtil.randomPair(
                        FIRST_MIN,
                        FIRST_MAX,
                        SECOND_MIN,
                        SECOND_MAX);

        return new AdditionStoryQuestionData(
                template,
                formatQuestion(
                        template,
                        character,
                        null,
                        numbers.getFirst(),
                        numbers.getSecond()),
                numbers.getFirst() + numbers.getSecond());
    }

    private static AdditionStoryQuestionData generateUnknownStart(AdditionStoryTemplate template)
    {
        StoryCharacter character = StoryCharacterUtil.getRandomCharacter();

        NumberPair numbers = NumberPairUtil.randomPair(5, 20, 5, 25);

        return new AdditionStoryQuestionData(
                template,
                formatQuestion(
                        template,
                        character,
                        null,
                        numbers.getFirst(),
                        numbers.getSecond()),
                numbers.getFirst() + numbers.getSecond());
    }

    private static String formatQuestion(AdditionStoryTemplate template, StoryCharacter character, String secondPerson, int firstNumber, int secondNumber)
    {
        return String.format(template.questionTemplate,
                character != null ? character.getName() : "",
                NumberFormatUtil.formatIndianNumber(firstNumber),
                secondPerson != null ? secondPerson : "",
                NumberFormatUtil.formatIndianNumber(secondNumber),
                character != null ? character.getPossessivePronoun() : "",
                character != null ? character.getObjectPronoun() : "");
    }
}