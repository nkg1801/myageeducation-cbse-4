package com.myAgeEducation.cbseClass4.maths.pictograph;
import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeType;
import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PictographQuestionGenerator
{
    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        PictographQuestionData data = generate();
        Question question = new Question();
        question.setQuestion(data.questionText);
        OptionUtils.setQuestionOptions(question, data.options);
        question.setAnswer(data.correctAnswer);
        question.setImage(createImageCode(data.pictographData));
        return question;
    }

    private static PictographQuestionData generate()
    {
        PictographData pictographData = PictographGenerator.generate();
        PictographQuestionType type = getRandomValidQuestionType(pictographData);
        PictographQuestionData questionData = generateQuestionData(pictographData, type);
        questionData.options = generateOptions(questionData);
        return questionData;
    }

    private static PictographQuestionData generateQuestionData(PictographData data, PictographQuestionType type)
    {
        String questionText;
        String correctAnswer;

        switch (type)
        {
            // TOTAL

            case TOTAL_IN_CATEGORY:
            {
                int categoryIndex = randomCategoryIndex(data);

                questionText = data.scenario.introduction
                                + " "
                                + String.format(
                                data.scenario.totalInCategoryTemplate,
                                data.getLabel(categoryIndex));

                correctAnswer =
                        String.valueOf(
                                data.getValueForCategory(categoryIndex));

                break;
            }

            // MORE THAN

            case MORE_THAN:
            {
                int[] categories = getTwoDifferentCategories(data);
                int larger = categories[0];
                int smaller = categories[1];

                if (data.iconCounts[larger] < data.iconCounts[smaller])
                {
                    int temp = larger;
                    larger = smaller;

                    smaller =
                            temp;
                }

                questionText =
                        data.scenario.introduction
                                + " "
                                + String.format(
                                data.scenario.moreThanTemplate,
                                data.getLabel(larger),
                                data.getLabel(smaller));


                int difference =
                        data.getValueForCategory(larger)
                                - data.getValueForCategory(smaller);


                correctAnswer =
                        String.valueOf(
                                difference);

                break;
            }

            // FEWER THAN

            case FEWER_THAN:
            {
                int[] categories = getTwoDifferentCategories(data);
                int smaller = categories[0];
                int larger = categories[1];


                if (data.iconCounts[smaller] > data.iconCounts[larger])
                {
                    int temp = smaller;
                    smaller = larger;
                    larger = temp;
                }

                questionText =
                        data.scenario.introduction
                                + " How many fewer "
                                + data.scenario.itemName
                                + " does "
                                + data.getLabel(smaller)
                                + " represent than "
                                + data.getLabel(larger)
                                + "?";


                int difference =
                        data.getValueForCategory(larger)
                                - data.getValueForCategory(smaller);


                correctAnswer =
                        String.valueOf(
                                difference);

                break;
            }

            // REQUIRED TO BECOME EQUAL

            case REQUIRED_TO_BECOME_EQUAL:
            {
                int[] categories =
                        getTwoDifferentCategories(data);


                int smaller =
                        categories[0];

                int larger =
                        categories[1];


                if (data.iconCounts[smaller]
                        > data.iconCounts[larger])
                {
                    int temp =
                            smaller;

                    smaller =
                            larger;

                    larger =
                            temp;
                }

                questionText =
                        data.scenario.introduction
                                + " How many more "
                                + data.scenario.itemName
                                + " are required for "
                                + data.getLabel(smaller)
                                + " to become equal to "
                                + data.getLabel(larger)
                                + "?";


                int required =
                        data.getValueForCategory(larger)
                                - data.getValueForCategory(smaller);


                correctAnswer =
                        String.valueOf(
                                required);

                break;
            }

            // MOST

            case MOST:
            {
                int categoryIndex = getCategoryWithMostIcons(data);
                questionText = data.scenario.introduction + " As per the pictograph, " + data.scenario.mostQuestion;
                correctAnswer = data.getLabel(categoryIndex);
                break;
            }

            // FEWEST

            case FEWEST:
            {
                int categoryIndex = getCategoryWithFewestIcons(data);
                questionText = data.scenario.introduction + " As per the pictograph, " + data.scenario.fewestQuestion;
                correctAnswer = data.getLabel(categoryIndex);
                break;
            }

            case TOTAL_TWO_CATEGORIES:
            {
                int[] categories = getTwoDifferentCategories(data);
                int firstIndex = categories[0];
                int secondIndex = categories[1];
                int firstValue = data.getValueForCategory(firstIndex);
                int secondValue = data.getValueForCategory(secondIndex);
                questionText = data.scenario.introduction + " " + String.format(data.scenario.totalTwoCategoriesTemplate, data.getLabel(firstIndex), data.getLabel(secondIndex));
                correctAnswer = String.valueOf(firstValue + secondValue);
                break;
            }

            case TOTAL_ALL:
            {
                int total = 0;
                for (int i = 0; i < data.iconCounts.length; i++)
                {
                    total += data.getValueForCategory(i);
                }
                questionText = data.scenario.introduction + " " + data.scenario.totalAllQuestion;
                correctAnswer = String.valueOf(total);
                break;
            }

            case SAME_VALUE:
            {
                int firstIndex = -1;
                int secondIndex = -1;

                // Find the two categories having the same icon count
                outerLoop:
                for (int i = 0; i < data.iconCounts.length; i++)
                {
                    for (int j = i + 1;j < data.iconCounts.length;j++)
                    {
                        if (data.iconCounts[i] == data.iconCounts[j])
                        {
                            firstIndex = i;
                            secondIndex = j;
                            break outerLoop;
                        }
                    }
                }

                if (firstIndex == -1 || secondIndex == -1)
                {
                    throw new IllegalStateException("SAME_VALUE selected but no matching categories found.");
                }

                questionText = data.scenario.introduction + " " + data.scenario.sameValueTemplate;
                correctAnswer = data.getLabel(firstIndex) + " and " + data.getLabel(secondIndex);
                break;
            }

            default: throw new IllegalArgumentException("Unknown question type: " + type);
        }
        return new PictographQuestionData(data, type, questionText, correctAnswer);
    }

    private static PictographQuestionType getRandomValidQuestionType(PictographData data)
    {
        List<PictographQuestionType> validTypes = new ArrayList<>();

        // Always valid
        validTypes.add(PictographQuestionType.TOTAL_IN_CATEGORY);
        //validTypes.add(PictographQuestionType.MORE_THAN);
        //validTypes.add(PictographQuestionType.FEWER_THAN);
        validTypes.add(PictographQuestionType.REQUIRED_TO_BECOME_EQUAL);
        validTypes.add(PictographQuestionType.TOTAL_TWO_CATEGORIES);
        validTypes.add(PictographQuestionType.TOTAL_ALL);

        // Only if maximum is unique
        if (hasUniqueMost(data))
        {
            validTypes.add(PictographQuestionType.MOST);
        }

        // Only if minimum is unique
        if (hasUniqueFewest(data))
        {
            validTypes.add(PictographQuestionType.FEWEST);
        }

        // Only if two categories have the same value
        if (hasMatchingPair(data))
        {
            validTypes.add(PictographQuestionType.SAME_VALUE);
        }

        return validTypes.get(RANDOM.nextInt(validTypes.size()));
    }

    // OPTIONS

    private static String[] generateOptions(PictographQuestionData questionData)
    {
        PictographQuestionType type = questionData.questionType;

        if (type == PictographQuestionType.SAME_VALUE)
        {
            return generateSameValueOptions(questionData);
        }

        // MOST / FEWEST
        if (type == PictographQuestionType.MOST || type == PictographQuestionType.FEWEST)
        {
            List<String> options = new ArrayList<>();

            // Always include the correct answer
            options.add(questionData.correctAnswer);

            List<String> labels = new ArrayList<>(Arrays.asList(questionData.pictographData.getLabels()));
            labels.remove(questionData.correctAnswer);
            Collections.shuffle(labels);

            while (options.size() < 4 && !labels.isEmpty())
            {
                options.add(labels.remove(0));
            }

            Collections.shuffle(options);
            return options.toArray(new String[0]);
        }

        // Numerical questions
        int correctAnswer = Integer.parseInt(questionData.correctAnswer);

        int step = questionData.pictographData.valuePerIcon;

        // Generate distractors only
        Set<Integer> distractors = new LinkedHashSet<>();

        if (correctAnswer - step > 0)
        {
            distractors.add(correctAnswer - step);
        }

        distractors.add(correctAnswer + step);

        if (correctAnswer - (2 * step) > 0)
        {
            distractors.add(correctAnswer - (2 * step));
        }

        distractors.add(correctAnswer + (2 * step));

        int nextValue = correctAnswer + (3 * step);

        while (distractors.size() < 3)
        {
            distractors.add(nextValue);
            nextValue += step;
        }

        // Select only 3 distractors
        List<Integer> distractorList = new ArrayList<>(distractors);

        Collections.shuffle(distractorList);

        // Correct answer + exactly 3 distractors
        List<String> options = new ArrayList<>();

        options.add(String.valueOf(correctAnswer));

        for (int i = 0; i < 3; i++)
        {
            options.add(String.valueOf(distractorList.get(i)));
        }

        Collections.shuffle(options);
        return options.toArray(new String[0]);
    }

    private static String[] generateSameValueOptions(PictographQuestionData questionData)
    {
        PictographData data = questionData.pictographData;

        Set<String> options = new LinkedHashSet<>();

        // Always add the correct answer first
        options.add(questionData.correctAnswer);

        // Generate every possible pair
        for (int i = 0; i < data.getLabelCount(); i++)
        {
            for (int j = i + 1; j < data.getLabelCount(); j++)
            {
                String option = data.getLabel(i) + " and " + data.getLabel(j);

                if (!option.equals(questionData.correctAnswer))
                {
                    options.add(option);
                }
            }
        }

        List<String> wrongOptions = new ArrayList<>(options);

        // Remove the correct answer from the wrong-option list
        wrongOptions.remove(questionData.correctAnswer);
        Collections.shuffle(wrongOptions);
        List<String> finalOptions = new ArrayList<>();

        // Add the correct answer first
        finalOptions.add(questionData.correctAnswer);

        // Add only 3 wrong answers
        for (int i = 0; i < 3 && i < wrongOptions.size(); i++)
        {
            finalOptions.add(wrongOptions.get(i));
        }

        Collections.shuffle(finalOptions);

        return finalOptions.toArray(new String[0]);
    }

    // HELPERS

    private static int randomCategoryIndex(PictographData data)
    {
        return RANDOM.nextInt(data.getCategoryCount());
    }

    private static int[] getTwoDifferentCategories(PictographData data)
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

    private static int getCategoryWithMostIcons(PictographData data)
    {
        int result = 0;

        for (int i = 1; i < data.iconCounts.length; i++)
        {
            if (data.iconCounts[i] > data.iconCounts[result])
            {
                result = i;
            }
        }
        return result;
    }

    private static int getCategoryWithFewestIcons(PictographData data)
    {
        int result = 0;

        for (int i = 1; i < data.iconCounts.length; i++)
        {
            if (data.iconCounts[i] < data.iconCounts[result])
            {
                result = i;
            }
        }
        return result;
    }

    // IMAGE CODE

    private static String createImageCode(PictographData data)
    {
        StringBuilder code = new StringBuilder(ImageCodeType.PICTOGRAPH);
        code.append("_").append(data.scenario.scenarioCode.replace("_", ""));
        code.append("_").append(data.iconType.getCode());
        code.append("_").append(data.valuePerIcon);

        // Number of categories
        code.append("_").append(data.getLabelCount());

        // Store actual labels
        for (String label : data.getLabels())
        {
            code.append("_").append(label);
        }

        // Store icon counts
        for (int iconCount : data.iconCounts)
        {
            code.append("_").append(iconCount);
        }
        return code.toString();
    }

    private static boolean hasMatchingPair(PictographData data)
    {
        for (int i = 0; i < data.iconCounts.length; i++)
        {
            for (int j = i + 1; j < data.iconCounts.length; j++)
            {
                if (data.iconCounts[i] == data.iconCounts[j])
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasUniqueMost(PictographData data)
    {
        int max = Arrays.stream(data.iconCounts).max().orElse(0);
        int count = 0;

        for (int value : data.iconCounts)
        {
            if (value == max)
            {
                count++;
            }
        }
        return count == 1;
    }

    private static boolean hasUniqueFewest(PictographData data)
    {
        int min = Arrays.stream(data.iconCounts).min().orElse(0);
        int count = 0;

        for (int value : data.iconCounts)
        {
            if (value == min)
            {
                count++;
            }
        }
        return count == 1;
    }
}