package com.myAgeEducation.cbseClass4.maths.subtractions;

import com.myAgeEducation.cbseClass4.maths.utils.NumberFormatUtil;
import com.myAgeEducation.cbseClass4.maths.utils.NumberPair;
import com.myAgeEducation.cbseClass4.maths.utils.NumberUtil;
import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacter;
import com.myAgeEducation.cbseClass4.maths.utils.StoryCharacterUtil;

import java.util.Random;

public class SubtractionStoryDataGenerator {
    private static final Random RANDOM = new Random();

    private SubtractionStoryDataGenerator() {
    }

    public static SubtractionStoryQuestionData generate() {
        int type = RANDOM.nextInt(6);

        switch (type) {
            case 0:
                return generateHasLess();

            case 1:
                return generateGroupShrinks();

            case 2:
                return generateMoneySpent();

            case 3:
                return generateUnknownStart();

            case 4:
                return generateUnknownChange();

            default:
                return generateComparison();
        }
    }

    private static SubtractionStoryTemplate getRandomTemplate(SubtractionStoryTemplate[] templates)
    {
        return templates[RANDOM.nextInt(templates.length)];
    }

    private static SubtractionStoryQuestionData createQuestion(
            SubtractionStoryTemplate template,
            String question,
            int firstNumber,
            int secondNumber,
            int answer)
    {
        return new SubtractionStoryQuestionData(
                template,
                question,
                firstNumber,
                secondNumber,
                answer);
    }

    private static int getLargerNumber()
    {
        return RANDOM.nextInt(5000) + 40;
    }

    private static int getSmallerNumber(int larger)
    {
        return RANDOM.nextInt(larger / 2) + 5;
    }

    private static SubtractionStoryQuestionData generateHasLess()
    {
        StoryCharacter character = StoryCharacterUtil.getRandomCharacter();

        String secondPerson = StoryCharacterUtil.getAnotherPersonName(character);

        SubtractionStoryTemplate template =
                getRandomTemplate(
                        SubtractionStoryTemplates.HAS_LESS);

        int total = getLargerNumber();

        int taken = getSmallerNumber(total);

        String question =
                String.format(
                        template.questionTemplate,
                        character.getName(),
                        NumberFormatUtil.formatIndianNumber(total),
                        secondPerson,
                        NumberFormatUtil.formatIndianNumber(taken));

        return createQuestion(
                template,
                question,
                total,
                taken,
                total - taken);
    }

    private static SubtractionStoryQuestionData generateGroupShrinks()
    {
        SubtractionStoryTemplate template =
                getRandomTemplate(
                        SubtractionStoryTemplates.GROUP_SHRINKS);

        int total = getLargerNumber();
        int left = getSmallerNumber(total);

        String question =
                String.format(
                        template.questionTemplate,
                        "",
                        NumberFormatUtil.formatIndianNumber(total),
                        "",
                        NumberFormatUtil.formatIndianNumber(left));

        return createQuestion(
                template,
                question,
                total,
                left,
                total - left);
    }

    private static SubtractionStoryQuestionData generateMoneySpent()
    {
        StoryCharacter character = StoryCharacterUtil.getRandomCharacter();

        SubtractionStoryTemplate template =
                getRandomTemplate(
                        SubtractionStoryTemplates.MONEY_SPENT);

        int money = getLargerNumber();

        int spent = getSmallerNumber(money);

        String question =
                String.format(
                        template.questionTemplate,
                        character.getName(),
                        NumberFormatUtil.formatIndianNumber(money),
                        "",
                        NumberFormatUtil.formatIndianNumber(spent));

        return createQuestion(
                template,
                question,
                money,
                spent,
                money - spent);
    }

    private static SubtractionStoryQuestionData generateUnknownStart()
    {
        StoryCharacter character =
                StoryCharacterUtil.getRandomCharacter();

        SubtractionStoryTemplate template =
                getRandomTemplate(
                        SubtractionStoryTemplates.UNKNOWN_START);

        NumberPair pair =
                NumberUtil.getUnknownStartNumbers();

        int remaining =
                pair.getFirst();

        int lost =
                pair.getSecond();

        String question =
                String.format(
                        template.questionTemplate,
                        character.getName(),
                        NumberFormatUtil.formatIndianNumber(remaining),
                        "",
                        NumberFormatUtil.formatIndianNumber(lost));

        return createQuestion(
                template,
                question,
                remaining,
                lost,
                remaining + lost);
    }

    private static SubtractionStoryQuestionData generateUnknownChange()
    {
        StoryCharacter character =
                StoryCharacterUtil.getRandomCharacter();

        SubtractionStoryTemplate template =
                getRandomTemplate(
                        SubtractionStoryTemplates.UNKNOWN_CHANGE);

        int start =
                getLargerNumber();

        int remaining =
                getSmallerNumber(start);

        String question =
                String.format(
                        template.questionTemplate,
                        character.getName(),
                        NumberFormatUtil.formatIndianNumber(start),
                        "",
                        NumberFormatUtil.formatIndianNumber(remaining));

        return createQuestion(
                template,
                question,
                start,
                remaining,
                start - remaining);
    }

    private static SubtractionStoryQuestionData generateComparison()
    {
        StoryCharacter first =
                StoryCharacterUtil.getRandomCharacter();

        String second =
                StoryCharacterUtil.getAnotherPersonName(first);

        SubtractionStoryTemplate template =
                getRandomTemplate(
                        SubtractionStoryTemplates.COMPARISON);

        NumberPair pair =
                NumberUtil.getSubtractionNumbers();
        int bigger =
                pair.getFirst();
        int smaller =
                pair.getSecond();


        String question =
                String.format(
                        template.questionTemplate,
                        first.getName(),
                        NumberFormatUtil.formatIndianNumber(bigger),
                        second,
                        NumberFormatUtil.formatIndianNumber(smaller));

        return createQuestion(
                template,
                question,
                bigger,
                smaller,
                bigger - smaller);
    }
}
