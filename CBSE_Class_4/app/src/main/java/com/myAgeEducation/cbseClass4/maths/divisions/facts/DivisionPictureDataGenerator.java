package com.myAgeEducation.cbseClass4.maths.divisions.facts;
import com.myAgeEducation.cbseClass4.maths.utils.NumberPair;

import java.util.Random;

public class DivisionPictureDataGenerator
{
    private static final Random RANDOM = new Random();

    private static final DivisionPictureType[] PICTURE_TYPES =
            {
                    DivisionPictureType.PICTURE_IDENTIFY_DIVIDEND,
                    DivisionPictureType.PICTURE_IDENTIFY_DIVISOR,
                    DivisionPictureType.PICTURE_IDENTIFY_QUOTIENT,

                    DivisionPictureType.PICTURE_MISSING_DIVIDEND,
                    DivisionPictureType.PICTURE_MISSING_DIVISOR,
                    DivisionPictureType.PICTURE_MISSING_QUOTIENT

                    // Uncomment later as you implement them

                    // DivisionFactType.PICTURE_MATCH_EQUATION,
                    // DivisionFactType.PICTURE_FIND_MISTAKE,
                    // DivisionFactType.PICTURE_COMPLETE_LONG_DIVISION
            };

    private DivisionPictureDataGenerator()
    {
    }

    public static DivisionPictureQuestionData generate()
    {
        DivisionPictureType type = PICTURE_TYPES[RANDOM.nextInt(PICTURE_TYPES.length)];

        switch (type)
        {
            case PICTURE_IDENTIFY_DIVIDEND:
                return generateIdentifyDividend();

            case PICTURE_IDENTIFY_DIVISOR:
                return generateIdentifyDivisor();

            case PICTURE_IDENTIFY_QUOTIENT:
                return generateIdentifyQuotient();

            case PICTURE_MISSING_DIVIDEND:
                return generateMissingDividend();

            case PICTURE_MISSING_DIVISOR:
                return generateMissingDivisor();

            case PICTURE_MISSING_QUOTIENT:
                return generateMissingQuotient();

            default:
                throw new IllegalArgumentException("Unknown picture type : " + type);
        }
    }

    private static DivisionPictureQuestionData generateIdentifyDividend()
    {
        NumberPair pair = generateDivisionNumbers();
        int divisor = pair.getFirst();
        int quotient = pair.getSecond();
        int dividend = divisor * quotient;

        return createQuestion(
                DivisionPictureTemplates.PICTURE_IDENTIFY_DIVIDEND[0],
                dividend,
                divisor,
                quotient,
                dividend);
    }

    private static DivisionPictureQuestionData generateIdentifyDivisor()
    {
        NumberPair pair =
                generateDivisionNumbers();

        int divisor =
                pair.getFirst();

        int quotient =
                pair.getSecond();

        int dividend =
                divisor * quotient;

        return createQuestion(
                DivisionPictureTemplates.PICTURE_IDENTIFY_DIVISOR[0],
                dividend,
                divisor,
                quotient,
                divisor);
    }

    private static DivisionPictureQuestionData generateIdentifyQuotient()
    {
        NumberPair pair = generateDivisionNumbers();
        int divisor = pair.getFirst();
        int quotient = pair.getSecond();
        int dividend = divisor * quotient;

        return createQuestion(
                DivisionPictureTemplates.PICTURE_IDENTIFY_QUOTIENT[0],
                dividend,
                divisor,
                quotient,
                quotient);
    }

    private static DivisionPictureQuestionData generateMissingDividend()
    {
        NumberPair pair = generateDivisionNumbers();
        int divisor = pair.getFirst();
        int quotient = pair.getSecond();
        int dividend = divisor * quotient;

        return createQuestion(
                DivisionPictureTemplates.PICTURE_MISSING_DIVIDEND[0],
                dividend,
                divisor,
                quotient,
                dividend);
    }

    private static DivisionPictureQuestionData generateMissingDivisor()
    {
        NumberPair pair = generateDivisionNumbers();
        int divisor = pair.getFirst();
        int quotient = pair.getSecond();
        int dividend = divisor * quotient;
        return createQuestion(DivisionPictureTemplates.PICTURE_MISSING_DIVISOR[0], dividend, divisor, quotient, divisor);
    }

    private static DivisionPictureQuestionData generateMissingQuotient()
    {
        NumberPair pair = generateDivisionNumbers();
        int divisor = pair.getFirst();
        int quotient = pair.getSecond();
        int dividend = divisor * quotient;

        return createQuestion(
                DivisionPictureTemplates.PICTURE_MISSING_QUOTIENT[0],
                dividend,
                divisor,
                quotient,
                quotient);
    }

    private static DivisionPictureQuestionData createQuestion(
            DivisionPictureTemplate template,
            int dividend,
            int divisor,
            int quotient,
            int answer)
    {
        return new DivisionPictureQuestionData(
                template,
                dividend,
                divisor,
                quotient,
                answer);
    }

    /**
     * Divisor : 2 to 9
     * Quotient : 2 to 12
     */
    private static NumberPair generateDivisionNumbers()
    {
        int divisor = RANDOM.nextInt(8) + 2;
        int quotient = RANDOM.nextInt(11) + 2;
        return new NumberPair(divisor,quotient);
    }
}