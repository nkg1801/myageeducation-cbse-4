package com.myAgeEducation.cbseClass4.maths.fractions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FractionSeriesGenerator
{
    private static final Random RANDOM = new Random();

    public enum FractionSeriesOrder
    {
        ASCENDING,
        DESCENDING,
        UNORDERED
    }

    public enum FractionSeriesQuestionType
    {
        IN_ASCENDING,
        NOT_IN_ASCENDING,
        IN_DESCENDING,
        NOT_IN_DESCENDING,
        //UNORDERED,
        //NOT_UNORDERED
    }

    public static FractionData[] generateAscendingSeries(int count)
    {
        // Choose a denominator suitable for Class 3
        int[] denominators = {4, 5, 6, 8};
        int denominator = denominators[RANDOM.nextInt(denominators.length)];

        // Create all possible numerators
        List<Integer> numerators = new ArrayList<>();

        for (int i = 1; i <= denominator; i++)
        {
            numerators.add(i);
        }

        // Shuffle and select the required count
        Collections.shuffle(numerators);

        numerators = numerators.subList(0, count);

        // Sort in ascending order
        Collections.sort(numerators);

        FractionData[] series = new FractionData[count];

        for (int i = 0; i < count; i++)
        {
            series[i] = FractionImageGenerator.createFraction(
                    numerators.get(i),
                    denominator);
        }

        return series;
    }

    public static FractionSeriesData generateSeriesQuestion(FractionSeriesOrder correctOrder, int correctSeriesCount)
    {
        FractionSeriesData data = new FractionSeriesData();

        data.series = new FractionData[4][];
        data.seriesOrder = new FractionSeriesOrder[4];

        // Create four ascending series
        for (int i = 0; i < 4; i++)
        {
            data.series[i] = generateAscendingSeries(4);
            if(correctOrder == FractionSeriesOrder.DESCENDING)
            {
                reverse(data.series[i]);
            }
            data.seriesOrder[i] = correctOrder;
        }

        // Randomly decide which series should be incorrect
        data.correctOptionIndex = RANDOM.nextInt(4);

        FractionData[] wrongSeries = data.series[data.correctOptionIndex];

        if(correctOrder == FractionSeriesOrder.ASCENDING || correctOrder == FractionSeriesOrder.DESCENDING) {
            // Swap two adjacent fractions
            int swapIndex = RANDOM.nextInt(wrongSeries.length - 1);

            FractionData temp = wrongSeries[swapIndex];

            wrongSeries[swapIndex] = wrongSeries[swapIndex + 1];

            wrongSeries[swapIndex + 1] = temp;
        }

        else
        {
            // NEITHER
            makeNeitherAscendingNorDescending(wrongSeries);
        }

        return data;
    }

    private static void makeNeitherAscendingNorDescending(
            FractionData[] series)
    {
        do
        {
            shuffle(series);

        } while (isAscending(series) ||
                isDescending(series));
    }

    private static boolean isAscending(FractionData[] series)
    {
        for (int i = 1; i < series.length; i++)
        {
            if (series[i - 1].numerator >
                    series[i].numerator)
            {
                return false;
            }
        }

        return true;
    }

    private static boolean isDescending(FractionData[] series)
    {
        for (int i = 1; i < series.length; i++)
        {
            if (series[i - 1].numerator <
                    series[i].numerator)
            {
                return false;
            }
        }

        return true;
    }

    private static void shuffle(FractionData[] series)
    {
        for (int i = series.length - 1; i > 0; i--)
        {
            int j = RANDOM.nextInt(i + 1);

            FractionData temp = series[i];
            series[i] = series[j];
            series[j] = temp;
        }
    }

    private static void reverse(FractionData[] series)
    {
        int left = 0;
        int right = series.length - 1;

        while (left < right)
        {
            FractionData temp = series[left];
            series[left] = series[right];
            series[right] = temp;

            left++;
            right--;
        }
    }

    private static FractionData[] createAscendingSeries()
    {
        return generateAscendingSeries(4);
    }

    private static FractionData[] createDescendingSeries()
    {
        FractionData[] series = generateAscendingSeries(4);
        reverse(series);
        return series;
    }

    private static FractionData[] createUnorderedSeries()
    {
        FractionData[] series = generateAscendingSeries(4);

        makeNeitherAscendingNorDescending(series);

        return series;
    }

    public static FractionSeriesData generateOneCorrectSeries(
            FractionSeriesOrder order)
    {
        FractionSeriesData data = new FractionSeriesData();

        data.series = new FractionData[4][];

        data.correctOptionIndex = RANDOM.nextInt(4);

        for (int i = 0; i < 4; i++)
        {
            if (i == data.correctOptionIndex)
            {
                if (order == FractionSeriesOrder.ASCENDING)
                {
                    data.series[i] = createAscendingSeries();
                }
                else
                {
                    data.series[i] = createDescendingSeries();
                }
            }
            else
            {
                data.series[i] = createUnorderedSeries();
            }
        }

        return data;
    }

    public static FractionSeriesData generateOneWrongSeries(
            FractionSeriesOrder order)
    {
        FractionSeriesData data = new FractionSeriesData();

        data.series = new FractionData[4][];

        data.correctOptionIndex = RANDOM.nextInt(4);

        for (int i = 0; i < 4; i++)
        {
            if (i == data.correctOptionIndex)
            {
                data.series[i] = createUnorderedSeries();
            }
            else
            {
                if (order == FractionSeriesOrder.ASCENDING)
                {
                    data.series[i] = createAscendingSeries();
                }
                else
                {
                    data.series[i] = createDescendingSeries();
                }
            }
        }

        return data;
    }

    public static FractionSeriesData generateInAscendingQuestion()
    {
        return generateQuestion(
                FractionSeriesOrder.ASCENDING,
                FractionSeriesOrder.UNORDERED);
    }

    public static FractionSeriesData generateNotInAscendingQuestion()
    {
        return generateQuestion(
                FractionSeriesOrder.UNORDERED,
                FractionSeriesOrder.ASCENDING);
    }

    public static FractionSeriesData generateInDescendingQuestion()
    {
        return generateQuestion(
                FractionSeriesOrder.DESCENDING,
                FractionSeriesOrder.UNORDERED);
    }

    public static FractionSeriesData generateNotInDescendingQuestion()
    {
        return generateQuestion(FractionSeriesOrder.UNORDERED, FractionSeriesOrder.DESCENDING);
    }

    private static FractionSeriesData generateQuestion(
            FractionSeriesOrder correctSeriesType,
            FractionSeriesOrder otherSeriesType)
    {
        FractionSeriesData data = new FractionSeriesData();

        data.series = new FractionData[4][];

        // Random position of the correct answer
        data.correctOptionIndex = RANDOM.nextInt(4);

        for (int i = 0; i < 4; i++)
        {
            FractionSeriesOrder order;

            if (i == data.correctOptionIndex)
            {
                order = correctSeriesType;
            }
            else
            {
                order = otherSeriesType;
            }

            switch (order)
            {
                case ASCENDING:

                    data.series[i] = createAscendingSeries();
                    break;

                case DESCENDING:

                    data.series[i] = createDescendingSeries();
                    break;

                case UNORDERED:

                    data.series[i] = createUnorderedSeries();
                    break;

                default:

                    throw new IllegalArgumentException(
                            "Unknown FractionSeriesOrder : " + order);
            }
        }

        return data;
    }

}