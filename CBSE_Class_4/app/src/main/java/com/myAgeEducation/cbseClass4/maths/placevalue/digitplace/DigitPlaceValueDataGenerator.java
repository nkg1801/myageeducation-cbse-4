package com.myAgeEducation.cbseClass4.maths.placevalue.digitplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DigitPlaceValueDataGenerator
{
    private static final Random RANDOM =
            new Random();

    private static final int MIN_VALUE = 100000;
    private static final int MAX_VALUE = 999999;

    private DigitPlaceValueDataGenerator()
    {
        // Prevent object creation
    }

    public static DigitPlaceValueQuestionData generate()
    {
        int number;

        while (true)
        {
            number =
                    MIN_VALUE
                            + RANDOM.nextInt(
                            MAX_VALUE
                                    - MIN_VALUE
                                    + 1);

            // Find digits that are non-zero
            // and occur exactly once.
            List<Integer> validPositions =
                    new ArrayList<>();

            for (int position = 0;
                 position <= 6;
                 position++)
            {
                int digit =
                        getDigitAtPosition(
                                number,
                                position);

                if (digit == 0)
                {
                    continue;
                }

                int count = 0;

                for (int otherPosition = 0;
                     otherPosition <= 5;
                     otherPosition++)
                {
                    if (getDigitAtPosition(
                            number,
                            otherPosition) == digit)
                    {
                        count++;
                    }
                }

                if (count == 1)
                {
                    validPositions.add(position);
                }
            }

            // Make sure the number has at least
            // one non-zero digit occurring only once.
            if (!validPositions.isEmpty())
            {
                int position =
                        validPositions.get(
                                RANDOM.nextInt(
                                        validPositions.size()));

                int digit =
                        getDigitAtPosition(
                                number,
                                position);

                String correctAnswer =
                        getPlaceValueText(
                                digit,
                                position);

                return new DigitPlaceValueQuestionData(
                        number,
                        digit,
                        position,
                        correctAnswer);
            }
        }
    }

    private static int getDigitAtPosition(int number, int position)
    {
        int divisor = (int) Math.pow(10, position);
        return (number / divisor) % 10;
    }

    public static String getPlaceValueText(int digit, int position)
    {
        switch (position)
        {
            case 0:
                return digit + " ones";

            case 1:
                return digit + " tens";

            case 2:
                return digit + " hundreds";

            case 3:
                return digit + " thousands";

            case 4:
                return digit + " ten thousands";

            case 5:
                return digit + " lakhs";

            case 6:
                return digit + " ten lakhs";

            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }
    }
}