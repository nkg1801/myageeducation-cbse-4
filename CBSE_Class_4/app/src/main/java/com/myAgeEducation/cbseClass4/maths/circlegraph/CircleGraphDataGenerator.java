package com.myAgeEducation.cbseClass4.maths.circlegraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CircleGraphDataGenerator
{
    private static final Random RANDOM = new Random();

    private static final String[][] LABEL_SETS =
            {
                    {
                            "School bus",
                            "Walking",
                            "Others"
                    },

                    {
                            "Bus",
                            "Car",
                            "Walking",
                            "Bicycle"
                    },

                    {
                            "Cricket",
                            "Football",
                            "Basketball",
                            "Other"
                    },

                    {
                            "Apple",
                            "Banana",
                            "Orange",
                            "Mango"
                    },

                    {
                            "Red",
                            "Blue",
                            "Green",
                            "Yellow"
                    }
            };

    public static CircleGraphData generate()
    {
        int type = RANDOM.nextInt(5);

        switch (type)
        {
            case 0:
                return generateForFractionQuestion();

            case 1:
                return generateForMostQuestion();

            case 2:
                return generateForLeastQuestion();

            case 3:
                return generateForSameValueQuestion();

            default:
                return generateForComparisonQuestion();
        }
    }

    public static CircleGraphData generateForFractionQuestion()
    {
        int[][] patterns =
                {
                        {2, 1, 1},
                        {4, 2, 1, 1},
                        {6, 1, 1},
                        {3, 2, 2, 1},
                        {5, 1, 1, 1}
                };

        int[] values = patterns[RANDOM.nextInt(patterns.length)];
        return create(values);
    }

    public static CircleGraphData generateForMostQuestion()
    {
        int[][] patterns =
                {
                        {4, 2, 1, 1},
                        {5, 2, 1},
                        {5, 1, 1, 1},
                        {6, 1, 1},
                        {4, 3, 1}
                };

        int[] values = patterns[RANDOM.nextInt(patterns.length)];
        return create(values);
    }

    public static CircleGraphData generateForLeastQuestion()
    {
        int[][] patterns =
                {
                        {4, 3, 1},
                        {5, 2, 1},
                        {5, 3, 1},
                        {6, 3, 2, 1},
                        {5, 3, 2, 1},
                        {7, 4, 2, 1},
                        {6, 4, 3, 1},
                        {8, 5, 3, 1},
                        {7, 5, 2, 1}
                };

        int[] values =
                patterns[
                        RANDOM.nextInt(patterns.length)];

        return create(values);
    }

    public static CircleGraphData generateForSameValueQuestion()
    {
        int[][] patterns =
                {
                        {2, 2, 1, 3},
                        {1, 1, 2, 4},
                        {3, 3, 2, 4},
                        {4, 4, 1, 3},
                        {2, 2, 3, 5},
                        {1, 1, 4, 6},
                        {3, 3, 1, 5},
                        {4, 4, 2, 6}
                };

        int[] pattern =
                patterns[
                        RANDOM.nextInt(patterns.length)];

        // Make a copy so we don't accidentally modify
        // the original pattern.
        int[] values =
                pattern.clone();

        // Shuffle the values so the matching pair
        // is not always in the same categories.
        List<Integer> shuffledValues =
                new ArrayList<>();

        for (int value : values)
        {
            shuffledValues.add(value);
        }

        Collections.shuffle(shuffledValues);

        for (int i = 0;
             i < values.length;
             i++)
        {
            values[i] =
                    shuffledValues.get(i);
        }

        return create(values);
    }

    public static CircleGraphData generateForComparisonQuestion()
    {
        int[][] patterns =
                {
                        // 3 parts
                        {3, 2, 1},
                        {4, 3, 1},
                        {5, 3, 2},
                        {5, 4, 1},
                        {6, 4, 2},
                        {6, 5, 1},

                        // 4 parts
                        {4, 3, 2, 1},
                        {5, 3, 2, 1},
                        {6, 4, 2, 1},
                        {5, 4, 2, 1},

                        // 5 parts
                        {5, 4, 3, 2, 1},

                        // 6 parts
                        {6, 5, 4, 3, 2, 1}
                };

        int[] values =
                patterns[
                        RANDOM.nextInt(patterns.length)];

        return create(values);
    }

    /*
     * Creates CircleGraphData from the values.
     */
    private static CircleGraphData create(int[] values)
    {
        String[] labels =
                getRandomLabels(values.length);

        int total = 0;

        for (int value : values)
        {
            total += value;
        }

        String[] fractionNames =
                new String[values.length];

        for (int i = 0; i < values.length; i++)
        {
            fractionNames[i] = getFractionName(values[i], total);
        }

        return new CircleGraphData(
                labels,
                values,
                fractionNames,
                total);
    }

    /*
     * Get a label set having exactly the required
     * number of categories.
     */
    private static String[] getRandomLabels(int count)
    {
        String[][] possible = new String[0][];

        if (count == 3)
        {
            possible = new String[][]
                    {
                            {
                                    "School bus",
                                    "Walking",
                                    "Others"
                            },

                            {
                                    "Bus",
                                    "Car",
                                    "Walking"
                            },

                            {
                                    "Cricket",
                                    "Football",
                                    "Other"
                            }
                    };
        }
        else if (count == 4)
        {
            possible = new String[][]
                    {
                            {
                                    "Bus",
                                    "Car",
                                    "Walking",
                                    "Bicycle"
                            },

                            {
                                    "Cricket",
                                    "Football",
                                    "Basketball",
                                    "Other"
                            },

                            {
                                    "Apple",
                                    "Banana",
                                    "Orange",
                                    "Mango"
                            },

                            {
                                    "Red",
                                    "Blue",
                                    "Green",
                                    "Yellow"
                            }
                    };
        }

        return possible[RANDOM.nextInt(possible.length)];
    }

    /*
     * Converts a fraction into a child-friendly name.
     */
    private static String getFractionName(int numerator, int denominator)
    {
        int gcd = gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        if (numerator == 1 && denominator == 2)
        {
            return "half";
        }

        if (numerator == 1 && denominator == 4)
        {
            return "one-fourth";
        }

        if (numerator == 3 && denominator == 4)
        {
            return "three-fourths";
        }

        if (numerator == 1 && denominator == 8)
        {
            return "one-eighth";
        }

        if (numerator == 3 && denominator == 8)
        {
            return "three-eighths";
        }

        if (numerator == 5 && denominator == 8)
        {
            return "five-eighths";
        }

        if (numerator == 7 && denominator == 8)
        {
            return "seven-eighths";
        }

        return numerator + "/" + denominator;
    }

    private static int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}