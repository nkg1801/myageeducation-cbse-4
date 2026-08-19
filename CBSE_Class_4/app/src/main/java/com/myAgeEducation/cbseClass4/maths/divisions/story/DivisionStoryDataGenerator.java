package com.myAgeEducation.cbseClass4.maths.divisions.story;
import com.myAgeEducation.cbseClass4.maths.utils.NumberPair;
import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacter;
import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacterUtil;

import java.util.Random;

public class DivisionStoryDataGenerator {
    private static final Random RANDOM =
            new Random();

    private DivisionStoryDataGenerator() {
    }

    public static DivisionStoryQuestionData generate() {
        DivisionStoryType type =
                DivisionStoryType.values()[
                        RANDOM.nextInt(
                                DivisionStoryType.values().length)];

        switch (type) {
            case BASIC_DIVISION:
                return generateBasicDivision();

            case HOW_MANY_GROUPS:
                return generateHowManyGroups();

            case EQUAL_GROUPING:
                return generateEqualGrouping();

            case REPEATED_SUBTRACTION:
                return generateRepeatedSubtraction();

            case EQUAL_SHARING:
                return generateEqualSharing();

            case DIFFERENCE_SHARING:
                return generateDifferenceSharing();

            default:
                throw new IllegalArgumentException(
                        "Unknown division story type");
        }
    }

    private static DivisionStoryQuestionData generateBasicDivision()
    {
        return generateSimpleDivisionQuestion(
                DivisionStoryTemplates.BASIC_DIVISION_TEMPLATES);
    }

    private static DivisionStoryQuestionData generateHowManyGroups()
    {
        return generateSimpleDivisionQuestion(
                DivisionStoryTemplates.HOW_MANY_GROUPS_TEMPLATES);
    }

    private static DivisionStoryQuestionData generateEqualGrouping()
    {
        return generateSimpleDivisionQuestion(
                DivisionStoryTemplates.EQUAL_GROUPING_TEMPLATES);
    }

    private static DivisionStoryQuestionData generateRepeatedSubtraction()
    {
        return generateSimpleDivisionQuestion(
                DivisionStoryTemplates.REPEATED_SUBTRACTION_TEMPLATES);
    }

    private static DivisionStoryQuestionData generateEqualSharing()
    {
        return generateSimpleDivisionQuestion(
                DivisionStoryTemplates.EQUAL_SHARING_TEMPLATES);
    }

    private static DivisionStoryQuestionData generateDifferenceSharing()
    {
        // TODO:
        // This question type requires a different algorithm
        // because the answer consists of two values.

        return generateEqualSharing();
    }

    private static DivisionStoryQuestionData generateSimpleDivisionQuestion(
            DivisionStoryTemplate[] templates)
    {
        DivisionStoryTemplate template =
                getRandomTemplate(templates);

        NumberPair pair =
                generateDivisionNumbers();

        int divisor =
                pair.getFirst();

        int quotient =
                pair.getSecond();

        int dividend =
                divisor * quotient;

        StoryCharacter character = null;

        if (template.requiresCharacter)
        {
            character =
                    StoryCharacterUtil.getRandomCharacter();
        }

        return createQuestion(
                template,
                character,
                dividend,
                divisor,
                quotient);
    }

    private static DivisionStoryTemplate getRandomTemplate(
            DivisionStoryTemplate[] templates)
    {
        return templates[
                RANDOM.nextInt(
                        templates.length)];
    }

    private static NumberPair generateDivisionNumbers()
    {
        int divisor = RANDOM.nextInt(9) + 2;      // 2–10
        int quotient = RANDOM.nextInt(9) + 2;      // 2–10
        return new NumberPair(divisor, quotient);
    }

    private static DivisionStoryQuestionData createQuestion(
            DivisionStoryTemplate template,
            StoryCharacter character,
            int dividend,
            int divisor,
            int answer)
    {
        return new DivisionStoryQuestionData(
                template,
                formatQuestion(
                        template,
                        character,
                        dividend,
                        divisor),
                dividend,
                divisor,
                answer);
    }

    private static String formatQuestion(
            DivisionStoryTemplate template,
            StoryCharacter character,
            int dividend,
            int divisor)
    {
        return String.format(
                template.questionTemplate,
                character == null ? "" : character.getName(),
                dividend,
                character == null ? "" : character.getPossessivePronoun(),
                divisor,
                character == null ? "" : character.getObjectPronoun());
    }

}
