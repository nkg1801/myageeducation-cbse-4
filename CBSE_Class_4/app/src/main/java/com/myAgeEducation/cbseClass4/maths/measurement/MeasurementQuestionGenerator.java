package com.myAgeEducation.cbseClass4.maths.measurement;

import com.myAgeEducation.cbseClass4.maths.utils.PersonNameUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MeasurementQuestionGenerator
{
    private static final Random RANDOM =
            new Random();

    public static Question generateQuestion()
    {
        MeasurementQuestionData questionData =
                generate();

        if (questionData.options.length != 4)
        {
            throw new IllegalStateException(
                    "Expected 4 options but got "
                            + questionData.options.length
                            + " for type "
                            + questionData.questionType);
        }

        Question question = new Question();
        question.setQuestion(questionData.questionText);
        OptionUtils.setQuestionOptions(question, questionData.options);
        question.setAnswer(questionData.correctAnswer);
        return question;
    }

    public static MeasurementQuestionData generate()
    {
        MeasurementQuestionType[] types = MeasurementQuestionType.values();
        MeasurementQuestionType type = types[RANDOM.nextInt(types.length)];
        MeasurementQuestionData questionData = generateQuestionData(type);
        questionData.options = generateOptions(questionData);
        return questionData;
    }

    private static String[] generateOptions(MeasurementQuestionData questionData)
    {
        switch (questionData.questionType)
        {
            // Unit-based questions
            case CHOOSE_LENGTH_UNIT:
                return generateUnitOptions(questionData.correctAnswer, new String[]{"cm", "m", "km", "mm"});

            case CHOOSE_WEIGHT_UNIT:
                return generateUnitOptions(questionData.correctAnswer, new String[]{"g", "kg", "mg", "tonne"});

            case CHOOSE_CAPACITY_UNIT:
                return generateUnitOptions(questionData.correctAnswer, new String[]{"ml", "l", "g", "kg"});

            // Numerical questions
            case KG_G_TO_G:
                return generateMixedUnitConversionOptions(Integer.parseInt(questionData.correctAnswer),                        1000);

            case M_CM_TO_CM:
                return generateMixedUnitConversionOptions(Integer.parseInt(questionData.correctAnswer),100);

            case BASIC_UNIT_CONVERSION:
                return generateBasicConversionOptions(Integer.parseInt(questionData.correctAnswer));

            case COMPARE_DISTANCE:
                return generateUnitOptions(questionData.correctAnswer,
                        new String[]{
                                questionData.names[0],
                                questionData.names[1],
                                "Both walked the same distance",
                                "Cannot be determined"
                        });

            case FRACTION_OF_CAPACITY:
                return generateNumberOptions(Integer.parseInt(questionData.correctAnswer));

            case MULTIPLE_UNIT_CONVERSION:
                return generateMultipleConversionOptions(Integer.parseInt(questionData.correctAnswer));

            default:
                throw new IllegalArgumentException("Unknown measurement question type: " + questionData.questionType);
        }
    }

    private static String[] generateMultipleConversionOptions(int correctAnswer)
    {
        Set<Integer> values = new LinkedHashSet<>();
        values.add(correctAnswer);

        // Common conversion mistakes
        if (correctAnswer / 10 > 0)
        {
            values.add(correctAnswer / 10);
        }

        values.add(correctAnswer * 10);

        if (correctAnswer / 100 > 0)
        {
            values.add(correctAnswer / 100);
        }

        int fallback = correctAnswer + 100;

        while (values.size() < 4)
        {
            values.add(fallback);
            fallback += 100;
        }

        return shuffleNumberOptions(values);
    }

    private static String[] generateBasicConversionOptions(int correctAnswer)
    {
        Set<Integer> values = new LinkedHashSet<>();

        values.add(correctAnswer);
        values.add(correctAnswer + 1);
        values.add(correctAnswer + 9);
        values.add(correctAnswer + 99);

        return shuffleNumberOptions(values);
    }

    private static String[] shuffleNumberOptions(
            Set<Integer> values)
    {
        List<Integer> valueList =
                new ArrayList<>(values);

        Collections.shuffle(valueList);

        List<String> options =
                new ArrayList<>();

        for (int i = 0;
             i < Math.min(4, valueList.size());
             i++)
        {
            options.add(
                    String.valueOf(valueList.get(i)));
        }

        return options.toArray(
                new String[0]);
    }

    private static String[] generateMixedUnitConversionOptions(
            int correctAnswer,
            int majorUnitValue)
    {
        Set<Integer> values =
                new LinkedHashSet<>();

        values.add(correctAnswer);

        int smallStep =
                majorUnitValue == 1000
                        ? 100
                        : 10;

        int[] candidates =
                {
                        correctAnswer - majorUnitValue,
                        correctAnswer + majorUnitValue,
                        correctAnswer - smallStep,
                        correctAnswer + smallStep,
                        correctAnswer + (2 * majorUnitValue)
                };

        for (int candidate : candidates)
        {
            if (candidate > 0)
            {
                values.add(candidate);
            }

            if (values.size() == 4)
            {
                break;
            }
        }

        // Defensive fallback
        int fallback =
                correctAnswer + 1;

        while (values.size() < 4)
        {
            values.add(fallback++);
        }

        return shuffleNumberOptions(values);
    }

    private static String[] generateUnitOptions(String correctAnswer, String[] possibleOptions)
    {
        List<String> options = new ArrayList<>();

        options.add(correctAnswer);

        List<String> candidates = new ArrayList<>();

        Collections.addAll(candidates, possibleOptions);
        Collections.shuffle(candidates);

        for (String candidate : candidates)
        {
            if (!options.contains(candidate))
            {
                options.add(candidate);
            }

            if (options.size() == 4)
            {
                break;
            }
        }

        Collections.shuffle(options);

        return options.toArray(new String[0]);
    }

    private static String[] generateNumberOptions(
            int correctAnswer)
    {
        Set<Integer> values =
                new LinkedHashSet<>();

        // Correct answer must always be present
        values.add(correctAnswer);

        int[] offsets =
                {
                        -1000,
                        1000,
                        -100,
                        100,
                        -10,
                        10,
                        -1,
                        1
                };

        List<Integer> offsetList = new ArrayList<>();

        for (int offset : offsets)
        {
            offsetList.add(offset);
        }

        Collections.shuffle(offsetList);

        for (int offset : offsetList)
        {
            int value = correctAnswer + offset;

            if (value > 0)
            {
                values.add(value);
            }

            if (values.size() == 4)
            {
                break;
            }
        }

        // Defensive fallback
        int nextValue = correctAnswer + 1;

        while (values.size() < 4)
        {
            values.add(nextValue++);
        }

        List<String> options = new ArrayList<>();

        for (int value : values)
        {
            options.add(String.valueOf(value));
        }

        Collections.shuffle(options);
        return options.toArray(new String[0]);
    }

    private static MeasurementQuestionData generateQuestionData(MeasurementQuestionType type)
    {
        String questionText;
        String correctAnswer;
        String[] names = null;

        switch (type)
        {
            // 7 kg 60 g = _____ g
            case KG_G_TO_G:
            {
                int kg =
                        RANDOM.nextInt(9) + 1;

                int grams =
                        (RANDOM.nextInt(99) + 1) * 10;

                int totalGrams =
                        (kg * 1000) + grams;

                questionText =
                        kg + " kg "
                                + grams
                                + " g = _____ g";

                correctAnswer =
                        String.valueOf(totalGrams);

                break;
            }

            // 7 m 60 cm = _____ cm

            case M_CM_TO_CM:
            {
                int metres = RANDOM.nextInt(9) + 1;
                int centimetres = (RANDOM.nextInt(9) + 1) * 10;
                int totalCentimetres = (metres * 100) + centimetres;
                questionText = metres + " m " + centimetres + " cm = _____ cm";
                correctAnswer = String.valueOf(totalCentimetres);
                break;
            }

            // CHOOSE LENGTH UNIT

            case CHOOSE_LENGTH_UNIT:
            {
                MeasurementExample example = randomExample(MeasurementRepository.LENGTH_EXAMPLES);
                questionText = "We use _____ to measure the " + example.description + ".";
                correctAnswer = example.correctUnit.getSymbol();
                break;
            }

            // CHOOSE WEIGHT UNIT

            case CHOOSE_WEIGHT_UNIT:
            {
                MeasurementExample example = randomExample(MeasurementRepository.WEIGHT_EXAMPLES);
                questionText = "We use _____ to measure the " + example.description + ".";
                correctAnswer = example.correctUnit.getSymbol();
                break;
            }

            // CHOOSE CAPACITY UNIT

            case CHOOSE_CAPACITY_UNIT:
            {
                MeasurementExample example = randomExample(MeasurementRepository.CAPACITY_EXAMPLES);
                questionText = "We use _____ to measure the " + example.description + ".";
                correctAnswer = example.correctUnit.getSymbol();
                break;
            }

            // 1000 m = _____ km

            case BASIC_UNIT_CONVERSION:
            {
                MeasurementConversion conversion =
                        MeasurementRepository.CONVERSIONS[
                                RANDOM.nextInt(
                                        MeasurementRepository
                                                .CONVERSIONS.length)];

                questionText = conversion.fromValue + " "
                                + conversion.fromUnit.getSymbol()
                                + " = _____ "
                                + conversion.toUnit.getSymbol();

                correctAnswer =
                        String.valueOf(
                                conversion.toValue);

                break;
            }

            case COMPARE_DISTANCE:
            {
                names = PersonNameUtil.getDifferentNames(2);

                String firstName =
                        names[0];

                String secondName =
                        names[1];

                int firstKm =
                        RANDOM.nextInt(4) + 1;

                int secondKm =
                        RANDOM.nextInt(4) + 1;

                int firstMetres =
                        RANDOM.nextInt(4) * 250;

                int secondMetres =
                        RANDOM.nextInt(4) * 250;

                int firstTotal =
                        (firstKm * 1000) + firstMetres;

                int secondTotal =
                        (secondKm * 1000) + secondMetres;

                // Ensure the distances are different
                while (firstTotal == secondTotal)
                {
                    secondMetres =
                            RANDOM.nextInt(4) * 250;

                    secondTotal =
                            (secondKm * 1000) + secondMetres;
                }

                questionText =
                        firstName
                                + " walked a distance of "
                                + formatDistance(firstKm, firstMetres)
                                + " and "
                                + secondName
                                + " walked a distance of "
                                + formatDistance(secondKm, secondMetres)
                                + ". Who walked the longer distance?";

                correctAnswer =
                        firstTotal > secondTotal
                                ? firstName
                                : secondName;

                break;
            }

            case FRACTION_OF_CAPACITY:
            {
                int[] capacities =
                        {
                                200,
                                400,
                                500,
                                600,
                                800,
                                1000
                        };

                int capacity =
                        capacities[
                                RANDOM.nextInt(capacities.length)];

                int answer =
                        capacity / 2;

                questionText =
                        "A bottle has a capacity of "
                                + capacity
                                + " ml. How much milk is needed to fill half the bottle?";

                correctAnswer =
                        String.valueOf(answer);

                break;
            }

            case MULTIPLE_UNIT_CONVERSION:
            {
                int value =
                        RANDOM.nextInt(10) + 1;

                int conversionType =
                        RANDOM.nextInt(4);

                int convertedValue;
                String fromUnit;
                String toUnit;

                switch (conversionType)
                {
                    case 0:
                        // metre → centimetre
                        fromUnit = "metres";
                        toUnit = "centimetres";
                        convertedValue = value * 100;
                        break;

                    case 1:
                        // kilometre → metre
                        fromUnit = "kilometres";
                        toUnit = "metres";
                        convertedValue = value * 1000;
                        break;

                    case 2:
                        // kilogram → gram
                        fromUnit = "kilograms";
                        toUnit = "grams";
                        convertedValue = value * 1000;
                        break;

                    case 3:
                        // litre → millilitre
                        fromUnit = "litres";
                        toUnit = "millilitres";
                        convertedValue = value * 1000;
                        break;

                    default:
                        throw new IllegalStateException(
                                "Unknown conversion type");
                }

                questionText =
                        "How many "
                                + toUnit
                                + " are there in "
                                + value
                                + " "
                                + fromUnit
                                + "?";

                correctAnswer =
                        String.valueOf(convertedValue);

                break;
            }

            default:
                throw new IllegalArgumentException(
                        "Unknown measurement question type: "
                                + type);
        }


        /*return new MeasurementQuestionData(
                type,
                questionText,
                correctAnswer);*/

        MeasurementQuestionData questionData =
                new MeasurementQuestionData(
                        type,
                        questionText,
                        correctAnswer);

        questionData.names =
                names;

        return questionData;
    }

    private static String formatDistance(
            int km,
            int metres)
    {
        if (metres == 0)
        {
            return km + " km";
        }

        return km + " km " + metres + " m";
    }

    private static MeasurementExample randomExample(
            MeasurementExample[] examples)
    {
        return examples[
                RANDOM.nextInt(
                        examples.length)];
    }
}