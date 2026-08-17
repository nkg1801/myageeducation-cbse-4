package com.myAgeEducation.cbseClass4.maths.charts;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BarChartQuestionGenerator
{
    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        BarChartQuestionData data = generate();
        Question question = new Question();
        question.setQuestion(data.questionText);
        OptionUtils.setQuestionOptions(question, data.options);
        question.setAnswer(data.correctAnswer);
        question.setImage(createImageCode(data.barChartData));
        return question;
    }

    private static String createImageCode(BarChartData data)
    {
        StringBuilder code = new StringBuilder("BARCHART");
        code.append("_").append(data.scenario.scenarioCode);

        // Store the randomly selected display labels
        for (String displayLabel : data.displayLabels)
        {
            code.append("_").append(displayLabel);
        }

        // Store the corresponding values
        for (int value : data.values)
        {
            code.append("_").append(value);
        }
        return code.toString();
    }

    public static BarChartQuestionData generate()
    {
        BarChartData data = BarChartDataGenerator.generate();
        BarChartQuestionType type = getRandomQuestionType();
        BarChartQuestionData questionData = generateQuestionData(data,type);
        questionData.options = generateOptions(questionData);
        return questionData;
    }

    private static String[] generateOptions(BarChartQuestionData questionData)
    {
        switch (questionData.questionType)
        {
            case MOST:
            case FEWEST:
            case SECOND_MOST:
            case SECOND_FEWEST:
                return generateCategoryOptions(questionData.barChartData);

            default:
                return generateNumberOptions(questionData.correctAnswer);
        }
    }

    private static String[] generateCategoryOptions(BarChartData data)
    {
        List<String> options = new ArrayList<>();
        Collections.addAll(options, data.labels);
        Collections.shuffle(options);
        return options.toArray(new String[0]);
    }

    private static String[] generateNumberOptions(String correctAnswer)
    {
        int correct = Integer.parseInt(correctAnswer);

        List<Integer> options = new ArrayList<>();

        options.add(correct);

        int[] offsets =
                {
                        -300,
                        -200,
                        -100,
                        100,
                        200,
                        300
                };

        List<Integer> shuffledOffsets = new ArrayList<>();

        for (int offset : offsets)
        {
            shuffledOffsets.add(offset);
        }

        Collections.shuffle(shuffledOffsets);

        for (int offset : shuffledOffsets)
        {
            int option = correct + offset;

            if (option >= 0 && !options.contains(option))
            {
                options.add(option);
            }

            if (options.size() == 4)
            {
                break;
            }
        }

        // Safety fallback
        int fallback = 100;

        while (options.size() < 4)
        {
            int option = correct + fallback;

            if (!options.contains(option))
            {
                options.add(option);
            }

            fallback += 100;
        }

        Collections.shuffle(options);

        String[] result = new String[4];

        for (int i = 0; i < 4; i++)
        {
            result[i] = String.valueOf(options.get(i));
        }

        return result;
    }


    private static BarChartQuestionType getRandomQuestionType()
    {
        BarChartQuestionType[] types = BarChartQuestionType.values();
        return types[RANDOM.nextInt(types.length)];
    }

    private static BarChartQuestionData generateQuestionData(BarChartData data, BarChartQuestionType type)
    {
        String questionText;
        String correctAnswer;

        switch (type)
        {
            case VALUE_OF_CATEGORY:
            {
                int index = randomCategoryIndex(data);
                questionText = data.scenario.introduction + " " + String.format(data.scenario.valueQuestion, data.getLabel(index));
                correctAnswer = String.valueOf(data.getValue(index));
                break;
            }

            case MOST:
            {
                int index = getHighestValueIndex(data);
                questionText = data.scenario.introduction + " " + data.scenario.mostQuestion;
                correctAnswer = data.getLabel(index);
                break;
            }

            case FEWEST:
            {
                int index = getLowestValueIndex(data);
                questionText = data.scenario.introduction + " " + data.scenario.fewestQuestion;
                correctAnswer = data.getLabel(index);
                break;
            }

            case SECOND_MOST:
            {
                int index = getSecondHighestValueIndex(data);
                questionText = data.scenario.introduction + " " + data.scenario.secondMostQuestion;
                correctAnswer = data.getLabel(index);
                break;
            }

            case SECOND_FEWEST:
            {
                int index = getSecondLowestValueIndex(data);
                questionText = data.scenario.introduction + " " + data.scenario.secondFewestQuestion;
                correctAnswer = data.getLabel(index);
                break;
            }

            case MORE_THAN:
            {
                int[] indices = getTwoDifferentCategories(data);
                int larger = indices[0];
                int smaller = indices[1];

                if (data.getValue(larger) < data.getValue(smaller))
                {
                    int temp = larger;
                    larger = smaller;
                    smaller = temp;
                }

                questionText = data.scenario.introduction + " " + String.format(data.scenario.moreThanQuestion, data.getLabel(larger), data.getLabel(smaller));
                correctAnswer = String.valueOf(data.getValue(larger) - data.getValue(smaller));
                break;
            }

            case FEWER_THAN:
            {
                int[] indices = getTwoDifferentCategories(data);

                int smaller = indices[0];
                int larger = indices[1];

                if (data.getValue(smaller) > data.getValue(larger))
                {
                    int temp = smaller;
                    smaller = larger;
                    larger = temp;
                }

                questionText = data.scenario.introduction + " " + String.format(data.scenario.fewerThanQuestion, data.getLabel(smaller), data.getLabel(larger));
                correctAnswer = String.valueOf(data.getValue(larger) - data.getValue(smaller));
                break;
            }

            case TOTAL_TWO_CATEGORIES:
            {
                int[] indices = getTwoDifferentCategories(data);
                int first = indices[0];
                int second = indices[1];
                questionText = data.scenario.introduction + " " + String.format(data.scenario.totalTwoQuestion, data.getLabel(first), data.getLabel(second));
                correctAnswer = String.valueOf(data.getValue(first) + data.getValue(second));
                break;
            }

            case TOTAL_ALL:
            {
                int total = 0;

                for (int value : data.values)
                {
                    total += value;
                }

                questionText = data.scenario.introduction + " " + data.scenario.totalAllQuestion;
                correctAnswer = String.valueOf(total);
                break;
            }

            default:
                throw new IllegalArgumentException("Unknown bar chart question type: " + type);
        }

        return new BarChartQuestionData(data, type, questionText, correctAnswer);
    }

    private static int randomCategoryIndex(BarChartData data)
    {
        return RANDOM.nextInt(data.getCategoryCount());
    }

    private static int[] getTwoDifferentCategories(BarChartData data)
    {
        int first = randomCategoryIndex(data);

        int second;

        do
        {
            second = randomCategoryIndex(data);
        }
        while (second == first);

        return new int[]
                {
                        first,
                        second
                };
    }

    private static int getHighestValueIndex(BarChartData data)
    {
        int index = 0;

        for (int i = 1; i < data.values.length; i++)
        {
            if (data.values[i] > data.values[index])
            {
                index = i;
            }
        }

        return index;
    }

    private static int getLowestValueIndex(BarChartData data)
    {
        int index = 0;

        for (int i = 1; i < data.values.length; i++)
        {
            if (data.values[i] < data.values[index])
            {
                index = i;
            }
        }

        return index;
    }


    private static int getSecondHighestValueIndex(BarChartData data)
    {
        int highest = -1;
        int secondHighest = -1;

        for (int i = 0; i < data.values.length;i++)
        {
            if (highest == -1
                    || data.values[i]
                    > data.values[highest])
            {
                secondHighest = highest;
                highest = i;
            }
            else if (secondHighest == -1
                    || data.values[i]
                    > data.values[secondHighest])
            {
                secondHighest = i;
            }
        }

        return secondHighest;
    }


    private static int getSecondLowestValueIndex(
            BarChartData data)
    {
        int lowest = -1;
        int secondLowest = -1;

        for (int i = 0;
             i < data.values.length;
             i++)
        {
            if (lowest == -1
                    || data.values[i]
                    < data.values[lowest])
            {
                secondLowest = lowest;
                lowest = i;
            }
            else if (secondLowest == -1
                    || data.values[i]
                    < data.values[secondLowest])
            {
                secondLowest = i;
            }
        }

        return secondLowest;
    }
}