package com.myAgeEducation.cbseClass4.maths.subtractions;

import java.util.Random;

public class SubtractionFactDataGenerator
{
    private static final Random RANDOM =
            new Random();

    private SubtractionFactDataGenerator()
    {
    }

    public static SubtractionFactQuestionData generate()
    {
        int type =
                RANDOM.nextInt(4);

        switch (type)
        {
            case 0:
                return generateSuccessor();

            case 1:
                return generatePredecessor();

            case 2:
                return generateLargest4DigitSuccessor();

            default:
                return generatePlaceValueDifference();
        }
    }

    //------------------------------------------------------------

    private static SubtractionFactQuestionData generateSuccessor()
    {
        SubtractionFactTemplate template =
                getRandomTemplate(
                        SubtractionFactTemplates.SUCCESSOR);

        int number =
                RANDOM.nextInt(9000) + 1000;

        String question =
                String.format(
                        template.questionTemplate,
                        number);

        return createQuestion(
                template,
                question,
                number + 1,
                number,
                0,
                0);
    }

    //------------------------------------------------------------

    private static SubtractionFactQuestionData generatePredecessor()
    {
        SubtractionFactTemplate template =
                getRandomTemplate(
                        SubtractionFactTemplates.PREDECESSOR);

        int number =
                RANDOM.nextInt(9000) + 1000;

        String question =
                String.format(
                        template.questionTemplate,
                        number);

        return createQuestion(
                template,
                question,
                number - 1,
                number,
                0,
                0);
    }

    //------------------------------------------------------------

    private static SubtractionFactQuestionData generateLargest4DigitSuccessor()
    {
        SubtractionFactTemplate template =
                getRandomTemplate(
                        SubtractionFactTemplates.LARGEST_4_DIGIT_SUCCESSOR);

        String question =
                template.questionTemplate;

        return createQuestion(
                template,
                question,
                9999,
                9999,
                0,
                0);
    }

    //------------------------------------------------------------

    private static SubtractionFactQuestionData generatePlaceValueDifference()
    {
        PlaceValueDifferenceData data =
                RANDOM.nextBoolean()
                        ? generateSameDigitQuestion()
                        : generateDifferentDigitQuestion();

        SubtractionFactTemplate template =
                data.sameDigit
                        ? getRandomTemplate(
                        SubtractionFactTemplates.PLACE_VALUE_DIFFERENCE,
                        1)
                        : getRandomTemplate(
                        SubtractionFactTemplates.PLACE_VALUE_DIFFERENCE,
                        0);

        String question;

        if (data.sameDigit)
        {
            question =
                    String.format(
                            template.questionTemplate,
                            data.digit1,
                            data.number);
        }
        else
        {
            question =
                    String.format(
                            template.questionTemplate,
                            data.digit1,
                            data.digit2,
                            data.number);
        }

        return createQuestion(
                template,
                question,
                data.answer,
                data.number,
                data.placeValue1,
                data.placeValue2);
    }

    //------------------------------------------------------------

    private static SubtractionFactTemplate getRandomTemplate(
            SubtractionFactTemplate[] templates)
    {
        return templates[
                RANDOM.nextInt(
                        templates.length)];
    }

    //------------------------------------------------------------

    private static SubtractionFactQuestionData createQuestion(
            SubtractionFactTemplate template,
            String question,
            int answer,
            int number,
            int value1,
            int value2)
    {
        return new SubtractionFactQuestionData(
                template,
                question,
                answer,
                number,
                value1,
                value2);
    }

    private static SubtractionFactTemplate getRandomTemplate(
            SubtractionFactTemplate[] templates,
            int index)
    {
        return templates[index];
    }

    private static PlaceValueDifferenceData generateSameDigitQuestion()
    {
        PlaceValueDifferenceData data =
                new PlaceValueDifferenceData();

        int[] digits =
                new int[4];

        digits[0] =
                RANDOM.nextInt(9) + 1;

        for (int i = 1; i < 4; i++)
        {
            digits[i] =
                    RANDOM.nextInt(10);
        }

        int firstPlace =
                RANDOM.nextInt(4);

        int secondPlace;

        do
        {
            secondPlace =
                    RANDOM.nextInt(4);
        }
        while (secondPlace == firstPlace);

        int digit =
                RANDOM.nextInt(8) + 1;

        digits[firstPlace] =
                digit;

        digits[secondPlace] =
                digit;

        data.number =
                buildNumber(digits);

        int[] placeValues =
                {1000,100,10,1};

        data.sameDigit = true;

        data.digit1 =
                digit;

        data.placeValue1 =
                digit * placeValues[firstPlace];

        data.placeValue2 =
                digit * placeValues[secondPlace];

        data.answer =
                Math.abs(
                        data.placeValue1 -
                                data.placeValue2);

        return data;
    }

    private static PlaceValueDifferenceData generateDifferentDigitQuestion()
    {
        PlaceValueDifferenceData data =
                new PlaceValueDifferenceData();

        int[] digits =
                new int[4];

        // Thousands digit cannot be zero
        digits[0] =
                RANDOM.nextInt(9) + 1;

        // Remaining digits
        for (int i = 1; i < 4; i++)
        {
            digits[i] =
                    RANDOM.nextInt(10);
        }

        int firstPlace =
                RANDOM.nextInt(4);

        int secondPlace;

        do
        {
            secondPlace =
                    RANDOM.nextInt(4);
        }
        while (secondPlace == firstPlace);

        int digit1 =
                RANDOM.nextInt(8) + 1;

        int digit2;

        do
        {
            digit2 =
                    RANDOM.nextInt(8) + 1;
        }
        while (digit2 == digit1);

        digits[firstPlace] =
                digit1;

        digits[secondPlace] =
                digit2;

        data.number =
                buildNumber(digits);

        int[] placeValues =
                {1000,100,10,1};

        data.sameDigit = false;

        data.digit1 =
                digit1;

        data.digit2 =
                digit2;

        data.placeValue1 =
                digit1 * placeValues[firstPlace];

        data.placeValue2 =
                digit2 * placeValues[secondPlace];

        data.answer =
                Math.abs(
                        data.placeValue1 -
                                data.placeValue2);

        return data;
    }

    private static int buildNumber(int[] digits)
    {
        return digits[0] * 1000
                + digits[1] * 100
                + digits[2] * 10
                + digits[3];
    }


}