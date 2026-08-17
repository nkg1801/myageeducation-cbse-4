package com.myAgeEducation.cbseClass4.maths.charts.tabularquestions;

import com.myAgeEducation.cbseClass4.maths.utils.CountriesNameUtil;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TableQuestionGenerator {
    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        TableQuestionData data = generate();
        Question question = new Question();
        question.setQuestion(data.questionText);

        /*question.setOption1(data.options[0]);
        question.setOption2(data.options[1]);
        if(data.options.length > 2) {
            question.setOption3(data.options[2]);
        }
        if(data.options.length > 3) {
            question.setOption4(data.options[3]);
        }*/

        OptionUtils.setQuestionOptions(question, data.options);
        question.setAnswer(data.correctAnswer);
        question.setImage(createImageCode(data.tableData));
        return question;
    }

    private static String createImageCode(TableData data)
    {
        StringBuilder code = new StringBuilder("TABLE");
        code.append("_").append(data.scenario.scenarioCode);

        // Store the randomly selected display labels
        for (String displayLabel : data.labels)
        {
            code.append("_").append(displayLabel);
        }

        for (int value : data.values)
        {
            code.append("_").append(value);
        }

        return code.toString();
    }

    public static TableQuestionData generate()
    {
        // Select a random scenario
        TableScenario scenario = SCENARIOS[RANDOM.nextInt(SCENARIOS.length)];

        // Generate values for the table
        TableData tableData = TableDataGenerator.generate(scenario);

        // Select a random question type
        TableQuestionType type = getRandomQuestionType();

        // Generate question and correct answer
        TableQuestionData questionData = generateQuestionData(tableData, type);

        // Generate exactly four options
        questionData.options = generateOptions(questionData);

        return questionData;
    }

    private static TableQuestionType getRandomQuestionType()
    {
        TableQuestionType[] types = TableQuestionType.values();
        return types[RANDOM.nextInt(types.length)];
    }

    private static final TableScenario[] SCENARIOS =
            {
                    new TableScenario(
                            "ROADNETWORK",

                            "The table shows the length of road networks "
                                    + "in four different cities.",

                            "City",
                            "Road Network",

                            new String[]
                                    {
                                            "Bangalore",
                                            "Delhi",
                                            "Chennai",
                                            "Mumbai"
                                    },

                            "km",
                            "road network",
                            "road networks",
                            "length of road network",

                            5000,       // minValue
                            30000,      // maxValue
                            500,        // valueStep

                            "Which city has the largest network of roads?",
                            "Which city has the smallest network of roads?",
                            "Which city has the second largest network of roads?",
                            "Which city has the second smallest network of roads?"
                    ),

                    new TableScenario(
                            "AIRPORTS",
                            "The table shows the number of airports "
                                    + "in four different countries.",
                            "Country",
                            "Number of Airports",
                            CountriesNameUtil.getDifferentCountryNames(4),
                            "",
                            "airport",
                            "airports",
                            "number of airports",
                            50,         // minValue
                            500,        // maxValue
                            10,         // valueStep

                            "Which country has the most airports?",
                            "Which country has the fewest airports?",
                            "Which country has the second most airports?",
                            "Which country has the second fewest airports?"
                    ),
                    new TableScenario(
                            "LIBRARIES",

                            "The table shows the number of libraries "
                                    + "in four different cities.",

                            "City",
                            "Number of Libraries",

                            new String[]
                                    {
                                            "Delhi",
                                            "Mumbai",
                                            "Chennai",
                                            "Bangalore"
                                    },

                            "",

                            "library",
                            "libraries",
                            "number of libraries",

                            50,         // minValue
                            500,        // maxValue
                            10,         // valueStep

                            "Which city has the most libraries?",
                            "Which city has the fewest libraries?",
                            "Which city has the second most libraries?",
                            "Which city has the second fewest libraries?"
                    )
            };

    private static TableQuestionData generateQuestionData(TableData data, TableQuestionType type)
    {
        String questionText;
        String correctAnswer;

        switch (type)
        {
            case VALUE:
            {
                int index = RANDOM.nextInt(data.values.length);

                questionText =
                        data.scenario.introduction
                                + " What is the "
                                + data.scenario.valueDescription
                                + " for "
                                + data.getLabel(index)
                                + "?";

                correctAnswer = formatAnswer(data.values[index], data.scenario.unit);
                break;
            }

            case LARGEST:
            {
                int index = getIndexOfLargest(data);

                questionText = data.scenario.introduction
                                + " As per the table, "
                                + data.scenario.largestQuestion;

                correctAnswer = data.getLabel(index);
                break;
            }

            case SMALLEST:
            {
                int index = getIndexOfSmallest(data);

                questionText =
                        data.scenario.introduction
                                + " As per the table, "
                                + data.scenario.smallestQuestion;

                correctAnswer = data.getLabel(index);
                break;
            }

            case SECOND_LARGEST:
            {
                int index = getIndexOfSecondLargest(data);

                questionText =
                        data.scenario.introduction
                                + " As per the table, "
                                + data.scenario.secondLargestQuestion;

                correctAnswer = data.getLabel(index);
                break;
            }

            case SECOND_SMALLEST:
            {
                int index = getIndexOfSecondSmallest(data);

                questionText =
                        data.scenario.introduction
                                + " As per the table, "
                                + data.scenario.secondSmallestQuestion;

                correctAnswer = data.getLabel(index);
                break;
            }

            case MORE_THAN:
            {
                int[] indices = getTwoDifferentIndices(data);

                int larger = indices[0];
                int smaller = indices[1];

                if (data.values[larger] < data.values[smaller])
                {
                    int temp = larger;
                    larger = smaller;
                    smaller = temp;
                }

                questionText =
                        data.scenario.introduction
                                + " How many more "
                                + data.scenario.pluralItemName
                                + " does "
                                + data.getLabel(larger)
                                + " have than "
                                + data.getLabel(smaller)
                                + "?";

                correctAnswer =
                        formatAnswer(
                                data.values[larger]
                                        - data.values[smaller],
                                data.scenario.unit);

                break;
            }

            case FEWER_THAN:
            {
                int[] indices =
                        getTwoDifferentIndices(data);

                int smaller = indices[0];
                int larger = indices[1];

                if (data.values[smaller]
                        > data.values[larger])
                {
                    int temp = smaller;
                    smaller = larger;
                    larger = temp;
                }

                questionText =
                        data.scenario.introduction
                                + " How many fewer "
                                + data.scenario.pluralItemName
                                + " does "
                                + data.getLabel(smaller)
                                + " have than "
                                + data.getLabel(larger)
                                + "?";

                correctAnswer =
                        formatAnswer(
                                data.values[larger]
                                        - data.values[smaller],
                                data.scenario.unit);

                break;
            }

            case DIFFERENCE:
            {
                int[] indices =
                        getTwoDifferentIndices(data);

                int first = indices[0];
                int second = indices[1];

                int difference =
                        Math.abs(
                                data.values[first]
                                        - data.values[second]);

                questionText =
                        data.scenario.introduction
                                + " What is the difference between the number of "
                                + data.scenario.pluralItemName
                                + " for "
                                + data.getLabel(first)
                                + " and "
                                + data.getLabel(second)
                                + "?";

                correctAnswer =
                        formatAnswer(
                                difference,
                                data.scenario.unit);

                break;
            }

            case TOTAL_TWO:
            {
                int[] indices =
                        getTwoDifferentIndices(data);

                int first = indices[0];
                int second = indices[1];

                int total =
                        data.values[first]
                                + data.values[second];

                questionText =
                        data.scenario.introduction
                                + " What is the total number of "
                                + data.scenario.pluralItemName
                                + " for "
                                + data.getLabel(first)
                                + " and "
                                + data.getLabel(second)
                                + " altogether?";

                correctAnswer =
                        formatAnswer(
                                total,
                                data.scenario.unit);

                break;
            }

            case TOTAL_ALL:
            {
                int total = 0;

                for (int value : data.values)
                {
                    total += value;
                }

                questionText =
                        data.scenario.introduction
                                + " What is the total number of "
                                + data.scenario.pluralItemName
                                + " altogether?";

                correctAnswer =
                        formatAnswer(
                                total,
                                data.scenario.unit);

                break;
            }

            default:
                throw new IllegalArgumentException(
                        "Unknown table question type: "
                                + type);
        }

        return new TableQuestionData(
                data,
                type,
                questionText,
                correctAnswer);
    }

    private static int[] getTwoDifferentIndices(
            TableData data)
    {
        int firstIndex =
                RANDOM.nextInt(
                        data.values.length);

        int secondIndex;

        do
        {
            secondIndex =
                    RANDOM.nextInt(
                            data.values.length);
        }
        while (secondIndex == firstIndex);

        return new int[]
                {
                        firstIndex,
                        secondIndex
                };
    }

    private static String formatAnswer(
            int value,
            String unit)
    {
        if (unit == null
                || unit.trim().isEmpty())
        {
            return String.valueOf(value);
        }

        return value
                + " "
                + unit;
    }

    private static int[] getTwoDifferentIndexes(TableData data)
    {
        int first =
                RANDOM.nextInt(
                        data.values.length);

        int second;

        do
        {
            second =
                    RANDOM.nextInt(
                            data.values.length);
        }
        while (second == first);

        return new int[]
                {
                        first,
                        second
                };
    }

    private static int getIndexOfLargest(TableData data)
    {
        int index = 0;

        for (int i = 1;
             i < data.values.length;
             i++)
        {
            if (data.values[i]
                    > data.values[index])
            {
                index = i;
            }
        }

        return index;
    }

    private static int getIndexOfSmallest(
            TableData data)
    {
        int index = 0;

        for (int i = 1;
             i < data.values.length;
             i++)
        {
            if (data.values[i]
                    < data.values[index])
            {
                index = i;
            }
        }

        return index;
    }

    private static int getIndexOfSecondLargest(
            TableData data)
    {
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0;
             i < data.values.length;
             i++)
        {
            if (largest == -1
                    || data.values[i] > data.values[largest])
            {
                secondLargest = largest;
                largest = i;
            }
            else if (secondLargest == -1
                    || data.values[i] > data.values[secondLargest])
            {
                secondLargest = i;
            }
        }

        return secondLargest;
    }

    private static int getIndexOfSecondSmallest(
            TableData data)
    {
        int smallest = -1;
        int secondSmallest = -1;

        for (int i = 0;
             i < data.values.length;
             i++)
        {
            if (smallest == -1
                    || data.values[i] < data.values[smallest])
            {
                secondSmallest = smallest;
                smallest = i;
            }
            else if (secondSmallest == -1
                    || data.values[i] < data.values[secondSmallest])
            {
                secondSmallest = i;
            }
        }

        return secondSmallest;
    }

    private static String[] generateOptions(
            TableQuestionData questionData)
    {
        TableQuestionType type =
                questionData.type;

        switch (type)
        {
            // LABEL-BASED OPTIONS
            case LARGEST:
            case SMALLEST:
            case SECOND_LARGEST:
            case SECOND_SMALLEST:
                return generateLabelOptions(
                        questionData);

            // NUMERIC OPTIONS
            case VALUE:
            case MORE_THAN:
            case FEWER_THAN:
            case DIFFERENCE:
            case TOTAL_TWO:
            case TOTAL_ALL:
                return generateNumberOptions(
                        questionData);

            default:
                throw new IllegalArgumentException(
                        "Unknown table question type: "
                                + type);
        }
    }

    private static String[] generateLabelOptions(
            TableQuestionData questionData)
    {
        List<String> options =
                new ArrayList<>();

        Collections.addAll(
                options,
                questionData.tableData.labels);

        Collections.shuffle(options);

        return options.toArray(
                new String[0]);
    }

    private static String[] generateNumberOptions(
            TableQuestionData questionData)
    {
        TableScenario scenario =
                questionData.tableData.scenario;

        String unit =
                scenario.unit;

        int correctValue =
                Integer.parseInt(
                        questionData.correctAnswer
                                .replace(unit, "")
                                .trim());

        Set<Integer> values =
                new LinkedHashSet<>();

        values.add(correctValue);

        int step =
                scenario.valueStep;

        int[] offsets =
                {
                        -step,
                        step,
                        -2 * step,
                        2 * step,
                        -3 * step,
                        3 * step
                };

        List<Integer> offsetList =
                new ArrayList<>();

        for (int offset : offsets)
        {
            offsetList.add(offset);
        }

        Collections.shuffle(offsetList);

        for (int offset : offsetList)
        {
            int optionValue =
                    correctValue + offset;

            if (optionValue > 0)
            {
                values.add(optionValue);
            }

            if (values.size() == 4)
            {
                break;
            }
        }

        // Safety fallback
        while (values.size() < 4)
        {
            int optionValue =
                    correctValue
                            + (RANDOM.nextInt(10) + 1)
                            * step;

            values.add(optionValue);
        }

        List<String> options =
                new ArrayList<>();

        for (int value : values)
        {
            options.add(
                    formatAnswer(
                            value,
                            unit));
        }

        Collections.shuffle(options);

        return options.toArray(
                new String[0]);
    }
}
