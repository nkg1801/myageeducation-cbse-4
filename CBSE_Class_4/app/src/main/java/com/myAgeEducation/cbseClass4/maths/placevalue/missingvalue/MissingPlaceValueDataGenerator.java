package com.myAgeEducation.cbseClass4.maths.placevalue.missingvalue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MissingPlaceValueDataGenerator
{
    private static final Random RANDOM = new Random();

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9999999;

    private MissingPlaceValueDataGenerator()
    {
    }

    public static MissingPlaceValueQuestionData generate()
    {
        int number = MIN_NUMBER + RANDOM.nextInt( MAX_NUMBER - MIN_NUMBER + 1);
        /*int lakhs = number / 100000;
        int thousands = (number / 1000) % 100;
        int hundreds = (number / 100) % 10;
        int tens = (number / 10) % 10;
        int ones = number % 10;*/

        /*int lakhValue = (number / 100000) * 100000;
        int thousandValue = ((number / 1000) % 100) * 1000;
        int hundredValue = ((number / 100) % 10) * 100;
        int tenValue = ((number / 10) % 10) * 10;
        int oneValue = number % 10;*/

        int lakhs = (number / 100000) * 100000;
        int thousands = ((number / 1000) % 100) * 1000;
        int hundreds =  ((number / 100) % 10) * 100;
        int tens = ((number / 10) % 10) * 10;
        int ones = number % 10;

        // Determine which places are available
        List<PlaceType> availablePlaces =
                getAvailablePlaces(
                        lakhs,
                        thousands,
                        hundreds,
                        tens,
                        ones);

        PlaceType missingPlace = availablePlaces.get(RANDOM.nextInt(availablePlaces.size()));

        String correctAnswer;

        switch (missingPlace)
        {
            case LAKHS:
                correctAnswer = String.valueOf(lakhs);
                break;

            case THOUSANDS:
                correctAnswer = String.valueOf(thousands);
                break;

            case HUNDREDS:
                correctAnswer = String.valueOf(hundreds);
                break;

            case TENS:
                correctAnswer = String.valueOf(tens);
                break;

            case ONES:
                correctAnswer = String.valueOf(ones);
                break;

            default:
                throw new IllegalStateException("Unexpected place type: " + missingPlace);
        }

        return new MissingPlaceValueQuestionData(
                number,
                lakhs,
                thousands,
                hundreds,
                tens,
                ones,
                missingPlace,
                correctAnswer);
    }

    private static List<PlaceType> getAvailablePlaces(int lakhs, int thousands, int hundreds, int tens, int ones)
    {
        List<PlaceType> places = new ArrayList<>();

        if(lakhs > 0)
        {
            places.add(PlaceType.LAKHS);
        }

        if (thousands > 0) {
            places.add(PlaceType.THOUSANDS);
        }

        if (hundreds > 0) {
            places.add(PlaceType.HUNDREDS);
        }

        if (tens > 0) {
            places.add(PlaceType.TENS);
        }

        if (ones > 0) {
            places.add(PlaceType.ONES);
        }

        return places;
    }
}
