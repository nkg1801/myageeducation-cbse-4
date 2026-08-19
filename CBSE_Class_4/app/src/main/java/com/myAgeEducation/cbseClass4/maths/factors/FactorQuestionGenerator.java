package com.myAgeEducation.cbseClass4.maths.factors;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FactorQuestionGenerator
{
    private static final Random RANDOM = new Random();
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 50;

    private FactorQuestionGenerator()
    {
        // Prevent object creation
    }

    public static Question generateQuestion()
    {
        FactorQuestionType[] questionTypes =
                {
                        FactorQuestionType.LIST_FACTORS,
                        FactorQuestionType.FACTOR_TRUE_FALSE,

                        FactorQuestionType.GREATEST_FACTOR,
                        FactorQuestionType.FACTOR_OF_TWO_NUMBERS,

                        FactorQuestionType.FIND_FACTOR,
                        FactorQuestionType.FIND_NOT_FACTOR,

                        FactorQuestionType.COMMON_FACTOR,
                        FactorQuestionType.COMMON_FACTOR_TRUE_FALSE,

                        FactorQuestionType.COUNT_COMMON_FACTORS,
                        FactorQuestionType.FILL_MISSING_FACTOR
                };

        FactorQuestionType type = questionTypes[RANDOM.nextInt(questionTypes.length)];
        FactorQuestionData data = generateQuestion(type);
        return convertFactorQuestion(data);
    }

    public static List<FactorQuestionData> generateMcqTestQuestions()
    {
        List<FactorQuestionType> types = new ArrayList<>();

        // Controlled distribution:
        //
        // LIST_FACTORS              = 2
        // GREATEST_FACTOR           = 2
        // FACTOR_OF_TWO_NUMBERS     = 3
        // FIND_FACTOR               = 3
        // FIND_NOT_FACTOR           = 3
        // COMMON_FACTOR             = 3
        // COUNT_COMMON_FACTORS      = 2
        // FILL_MISSING_FACTOR       = 2
        //
        // Total = 20

        addQuestionType(types, FactorQuestionType.LIST_FACTORS, 2);
        addQuestionType(types,FactorQuestionType.GREATEST_FACTOR,2);
        addQuestionType(types,FactorQuestionType.FACTOR_OF_TWO_NUMBERS,3);
        addQuestionType(types,FactorQuestionType.FIND_FACTOR,3);
        addQuestionType(types,FactorQuestionType.FIND_NOT_FACTOR,3);
        addQuestionType(types,FactorQuestionType.COMMON_FACTOR,3);
        addQuestionType(types,FactorQuestionType.COUNT_COMMON_FACTORS,2);
        addQuestionType(types,FactorQuestionType.FILL_MISSING_FACTOR,2);

        // Randomize the order so questions of the
        // same type don't always appear together.
        Collections.shuffle(types, RANDOM);
        List<FactorQuestionData> questions = new ArrayList<>();
        Set<String> usedQuestions = new HashSet<>();
        final int MAX_RETRIES = 50;

        for (FactorQuestionType type : types)
        {
            FactorQuestionData question = null;

            boolean uniqueQuestionFound =
                    false;


            for (int attempt = 0;
                 attempt < MAX_RETRIES;
                 attempt++)
            {
                FactorQuestionData candidate =
                        generateQuestion(type);


                // We only accept questions that
                // actually have four options.
                if (candidate.options == null
                        || candidate.options.length != 4)
                {
                    continue;
                }


                String normalizedQuestion =
                        normalizeQuestionText(
                                candidate.question);


                if (usedQuestions.add(normalizedQuestion))
                {
                    question = candidate;
                    uniqueQuestionFound = true;
                    break;
                }
            }

            if (!uniqueQuestionFound)
            {
                throw new IllegalStateException(
                        "Unable to generate a unique "
                                + "MCQ question for type "
                                + type
                                + " after "
                                + MAX_RETRIES
                                + " attempts.");
            }


            questions.add(question);
        }


        if (questions.size() != 20)
        {
            throw new IllegalStateException(
                    "Expected 20 MCQ questions but "
                            + "generated "
                            + questions.size());
        }


        return questions;
    }

    private static void addQuestionType(List<FactorQuestionType> types, FactorQuestionType type, int count)
    {
        for (int i = 0; i < count; i++)
        {
            types.add(type);
        }
    }

    private static Question convertFactorQuestion(FactorQuestionData data)
    {
        Question question = new Question();
        question.setQuestion(data.question);
        question.setAnswer(data.answer);

        // Factor questions don't currently use images.
        question.setImage(null);

        OptionUtils.setQuestionOptions(question, data.options);
        /*
         * MCQ questions have four options.
         *
         * Non-MCQ questions have options = null.
         */
       /* if (data.options != null)
        {
            question.setOption1(
                    data.options[0]);

            question.setOption2(
                    data.options[1]);

            question.setOption3(
                    data.options[2]);

            question.setOption4(
                    data.options[3]);
        }
        else
        {
            question.setOption1(null);
            question.setOption2(null);
            question.setOption3(null);
            question.setOption4(null);
        }*/

        return question;
    }



    public static FactorQuestionData generateQuestion(FactorQuestionType type)
    {
        switch (type)
        {
            case LIST_FACTORS:
                return generateListFactorsQuestion();

            case FACTOR_TRUE_FALSE:
                return generateFactorTrueFalseQuestion();

            case GREATEST_FACTOR:
                return generateGreatestFactorQuestion();

            case FACTOR_OF_TWO_NUMBERS:
                return generateFactorOfTwoNumbersQuestion();

            case FIND_FACTOR:
                return generateFindFactorQuestion();

            case FIND_NOT_FACTOR:
                return generateFindNotFactorQuestion();

            case COMMON_FACTOR:
                return generateCommonFactorQuestion();

            case COMMON_FACTOR_TRUE_FALSE:
                return generateCommonFactorTrueFalseQuestion();

            case COUNT_COMMON_FACTORS:
                return generateCountCommonFactorsQuestion();

            case FILL_MISSING_FACTOR:
                return generateFillMissingFactorQuestion();

            default:
                throw new IllegalArgumentException("Unsupported factor question type: " + type);
        }
    }

    public static List<FactorQuestionData> generateTestQuestions()
    {
        final int QUESTIONS_PER_TYPE = 2;
        final int TOTAL_QUESTIONS = FactorQuestionType.values().length * QUESTIONS_PER_TYPE;
        final int MAX_RETRIES = 50;

        List<FactorQuestionType> types = new ArrayList<>();

        // Add every question type twice.
        for (FactorQuestionType type : FactorQuestionType.values())
        {
            types.add(type);
            types.add(type);
        }

        // Randomize the order.
        Collections.shuffle(types, RANDOM);

        List<FactorQuestionData> questions = new ArrayList<>();

        // Store normalized question text.
        Set<String> usedQuestions = new HashSet<>();

        for (FactorQuestionType type : types)
        {
            FactorQuestionData question = null;

            boolean uniqueQuestionFound =
                    false;

            for (int attempt = 0;
                 attempt < MAX_RETRIES;
                 attempt++)
            {
                FactorQuestionData candidate =
                        generateQuestion(type);

                String normalizedQuestion =
                        normalizeQuestionText(
                                candidate.question);

                if (usedQuestions.add(
                        normalizedQuestion))
                {
                    question = candidate;

                    uniqueQuestionFound = true;

                    break;
                }
            }

            if (!uniqueQuestionFound)
            {
                throw new IllegalStateException(
                        "Unable to generate a unique "
                                + "question for type "
                                + type
                                + " after "
                                + MAX_RETRIES
                                + " attempts.");
            }

            questions.add(question);
        }

        // Final safety check.
        if (questions.size()
                != TOTAL_QUESTIONS)
        {
            throw new IllegalStateException(
                    "Expected "
                            + TOTAL_QUESTIONS
                            + " questions but generated "
                            + questions.size());
        }

        return questions;
    }

    private static String normalizeQuestionText(
            String question)
    {
        if (question == null)
        {
            return "";
        }

        return question
                .trim()
                .replaceAll("\\s+", " ")
                .toLowerCase();
    }

    private static FactorQuestionData generate()
    {
        switch (getRandomQuestionType())
        {
            case FIND_FACTOR:
                return generateFindFactorQuestion();

            case FIND_NOT_FACTOR:
                return generateFindNotFactorQuestion();

            case COMMON_FACTOR:
                return generateCommonFactorQuestion();

            case LIST_FACTORS:
                return generateListFactorsQuestion();

            case GREATEST_FACTOR:
                return generateGreatestFactorQuestion();

            case FACTOR_OF_TWO_NUMBERS:
                return generateFactorOfTwoNumbersQuestion();

            case FILL_MISSING_FACTOR:
                return generateFillMissingFactorQuestion();

            case COMMON_FACTOR_TRUE_FALSE:
                return generateCommonFactorTrueFalseQuestion();

            default:
                return generateFactorTrueFalseQuestion();
        }
    }

    private static FactorQuestionType getRandomQuestionType()
    {
        FactorQuestionType[] types = FactorQuestionType.values();
        return types[RANDOM.nextInt(types.length)];
    }

    public static FactorQuestionData generateFindFactorQuestion()
    {
        int number = generateNumber();

        String[] options =
                FactorOptionUtils
                        .generateFactorOptions(
                                number);

        // Find the correct answer.
        String answer = null;

        for (String option : options)
        {
            if (isFactor(
                    Integer.parseInt(option),
                    number))
            {
                answer = option;
                break;
            }
        }

        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.FIND_FACTOR);
        String question = String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)], number);

        return new FactorQuestionData(
                number,
                0,
                Integer.parseInt(answer),
                question,
                answer,
                options,
                FactorQuestionType.FIND_FACTOR);
    }

    public static FactorQuestionData generateFindNotFactorQuestion()
    {
        int number;
        List<Integer> factors;

        // We need at least 3 factors to serve as distractors.
        do
        {
            number = generateNumber();
            factors = getFactors(number);
        } while (factors.size() < 3);

        String[] options = FactorOptionUtils.generateNotFactorOptions(number);
        String answer = null;

        for (String option : options)
        {
            if (!isFactor(Integer.parseInt(option), number))
            {
                answer = option;
                break;
            }
        }

        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.FIND_NOT_FACTOR);
        String question = String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)], number);

        return new FactorQuestionData(
                number,
                0,
                Integer.parseInt(answer),
                question,
                answer,
                options,
                FactorQuestionType.FIND_NOT_FACTOR);
    }

    public static FactorQuestionData generateCommonFactorQuestion()
    {
        int number1 = generateNumber();
        int number2 = generateNumber();

        while (getCommonFactors(number1, number2).isEmpty())
        {
            number2 = generateNumber();
        }

        String[] options = FactorOptionUtils.generateCommonFactorOptions(number1, number2);

        String answer = null;

        for (String option : options)
        {
            int value = Integer.parseInt(option);

            if (isFactor(value, number1) && isFactor(value, number2))
            {
                answer = option;
                break;
            }
        }

        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.COMMON_FACTOR);
        String question = String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)],number1,number2);

        return new FactorQuestionData(
                number1,
                number2,
                Integer.parseInt(answer),
                question,
                answer,
                options,
                FactorQuestionType.COMMON_FACTOR);
    }


    // =================================================
    // GET ALL FACTORS
    // =================================================

    public static List<Integer> getFactors(int number)
    {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= number; i++)
        {
            if (number % i == 0)
            {
                factors.add(i);
            }
        }

        return factors;
    }


    // =================================================
    // GET COMMON FACTORS
    // =================================================

    public static List<Integer> getCommonFactors(int number1, int number2)
    {
        List<Integer> factors1 =
                getFactors(number1);

        List<Integer> factors2 =
                getFactors(number2);

        List<Integer> commonFactors =
                new ArrayList<>();

        for (Integer factor : factors1)
        {
            if (factors2.contains(factor))
            {
                commonFactors.add(factor);
            }
        }

        return commonFactors;
    }


    // =================================================
    // CHECK WHETHER A NUMBER IS A FACTOR
    // =================================================

    public static boolean isFactor(int factor, int number)
    {
        if (factor <= 0 || number <= 0)
        {
            return false;
        }

        return number % factor == 0;
    }


    // =================================================
    // RANDOM NUMBER
    // =================================================

    private static int generateNumber()
    {
        return MIN_NUMBER + RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1);
    }

    // =================================================
    // RANDOM FACTOR
    // =================================================

    private static int generateFactor(int number)
    {
        List<Integer> factors = getFactors(number);

        return factors.get(RANDOM.nextInt(factors.size()));
    }

    public static FactorQuestionData generateListFactorsQuestion()
    {
        int number = generateNumber();
        List<Integer> factors = getFactors(number);
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < factors.size(); i++)
        {
            if (i > 0)
            {
                answer.append(", ");
            }

            answer.append(factors.get(i));
        }

        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.LIST_FACTORS);
        String question = String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)], number);
        String[] options = FactorOptionUtils.generateListFactorsOptions(number);

        return new FactorQuestionData(
                number,
                0,
                0,
                question,
                answer.toString(),
                options,
                FactorQuestionType.LIST_FACTORS);
    }

    public static FactorQuestionData generateFactorTrueFalseQuestion()
    {
        int number = generateNumber();
        boolean shouldBeTrue = RANDOM.nextBoolean();

        int factor;

        if (shouldBeTrue)
        {
            // Choose an actual factor.
            factor = generateFactor(number);
        }
        else
        {
            // Choose a number that is NOT a factor.
            List<Integer> factors = getFactors(number);
            List<Integer> nonFactors = new ArrayList<>();

            for (int i = 1; i <= number + 10; i++)
            {
                if (!factors.contains(i))
                {
                    nonFactors.add(i);
                }
            }

            factor = nonFactors.get(RANDOM.nextInt(nonFactors.size()));
        }

        boolean isFactor = isFactor(factor, number);

        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.FACTOR_TRUE_FALSE);
        String question = String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)],factor, number);

        String answer = isFactor ? "TRUE" : "FALSE";
        String[] options = FactorOptionUtils.generateTrueFalseOptions();

        return new FactorQuestionData(
                number,
                0,
                factor,
                question,
                answer,
                options,
                FactorQuestionType.FACTOR_TRUE_FALSE);
    }

    public static FactorQuestionData generateGreatestFactorQuestion()
    {
        int number = generateNumber();
        List<Integer> factors = getFactors(number);
        int greatestFactor = factors.get(factors.size() - 1);
        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.GREATEST_FACTOR);
        String question = String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)], number);
        String[] options = FactorOptionUtils.generateGreatestFactorOptions(number);

        return new FactorQuestionData(
                number,
                0,
                0,
                question,
                String.valueOf(greatestFactor),
                options,
                FactorQuestionType.GREATEST_FACTOR);
    }

    public static FactorQuestionData generateFactorOfTwoNumbersQuestion()
    {
        int factor = 2 + RANDOM.nextInt(9);

        int correctNumber1 = factor * (2 + RANDOM.nextInt(4));
        int correctNumber2 = factor * (2 + RANDOM.nextInt(4));

        // Make sure the two correct numbers
        // are different.
        while (correctNumber2 == correctNumber1)
        {
            correctNumber2 = factor * (2 + RANDOM.nextInt(4));
        }

        String correctOption = correctNumber1 + " and " + correctNumber2;
        List<String> options = new ArrayList<>();
        options.add(correctOption);

        while (options.size() < 4)
        {
            int number1 = 2 + RANDOM.nextInt(30);
            int number2 = 2 + RANDOM.nextInt(30);

            // Both numbers must NOT be divisible
            // by the selected factor.
            if (isFactor(factor, number1) || isFactor(factor, number2))
            {
                continue;
            }

            String option = number1 + " and " + number2;

            if (!options.contains(option))
            {
                options.add(option);
            }
        }

        Collections.shuffle(options, RANDOM);

        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.FACTOR_OF_TWO_NUMBERS);
        String question = String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)], factor);

        return new FactorQuestionData(
                0,
                0,
                factor,
                question,
                correctOption,
                options.toArray(new String[0]),
                FactorQuestionType.FACTOR_OF_TWO_NUMBERS);
    }

    public static FactorQuestionData generateFillMissingFactorQuestion()
    {
        int number;
        List<Integer> factors;

        // We need at least 4 factors so that
        // the question is meaningful.
        do
        {
            number = generateNumber();
            factors = getFactors(number);
        } while (factors.size() < 4);


        // Select a factor to hide.
        //
        // Avoid hiding the first or last factor
        // because questions such as:
        //
        // "The factors of 20 are: ___, 2, 4..."
        //
        // are less useful for Class 4.
        int missingIndex = 1 + RANDOM.nextInt(factors.size() - 2);
        int missingFactor = factors.get(missingIndex);

        // Build the question.
        StringBuilder question = new StringBuilder();

        //question.append("The factors of ").append(number).append(" are: ");

        String[] questionTemplates = FactorQuestionTemplatesUtil.getQuestionTemplates(FactorQuestionType.FILL_MISSING_FACTOR);
        question.append(String.format(questionTemplates[RANDOM.nextInt(questionTemplates.length)], number));

        for (int i = 0; i < factors.size(); i++)
        {
            if (i > 0)
            {
                question.append(", ");
            }

            if (i == missingIndex)
            {
                question.append("______");
            }
            else
            {
                question.append(factors.get(i));
            }
        }

        String[] options = FactorOptionUtils.generateFillMissingFactorOptions(number, missingFactor);

        return new FactorQuestionData(
                number,
                0,
                missingFactor,
                question.toString(),
                String.valueOf(missingFactor),
                options,
                FactorQuestionType.FILL_MISSING_FACTOR);
    }

    public static FactorQuestionData generateCommonFactorTrueFalseQuestion()
    {
        int number1 = generateNumber();
        int number2 = generateNumber();

        // Make sure the numbers are different.
        while (number2 == number1)
        {
            number2 = generateNumber();
        }

        boolean shouldBeTrue = RANDOM.nextBoolean();

        int factor;

        if (shouldBeTrue)
        {
            // Select an actual common factor.
            List<Integer> commonFactors = getCommonFactors(number1, number2);
            List<Integer> preferredFactors = new ArrayList<>();

            for (Integer commonFactor : commonFactors)
            {
                if (commonFactor > 1)
                {
                    preferredFactors.add(commonFactor);
                }
            }

            if (!preferredFactors.isEmpty())
            {
                factor = preferredFactors.get(RANDOM.nextInt(preferredFactors.size()));
            }
            else
            {
                // 1 is the only common factor.
                factor = 1;
            }
        }
        else
        {
            // Select a number which is NOT a
            // common factor.
            List<Integer> nonCommonFactors = new ArrayList<>();

            int max = Math.max(number1, number2);

            for (int i = 2; i <= max;i++)
            {
                boolean factorOfFirst = isFactor(i, number1);
                boolean factorOfSecond = isFactor(i, number2);

                // It must NOT be a factor of both.
                if (!(factorOfFirst && factorOfSecond))
                {
                    nonCommonFactors.add(i);
                }
            }

            factor = nonCommonFactors.get(RANDOM.nextInt(nonCommonFactors.size()));
        }

        boolean isCommonFactor = isFactor(factor, number1) && isFactor(factor, number2);

        String question =
                factor
                        + " is a common factor of "
                        + number1
                        + " and "
                        + number2
                        + ". TRUE or FALSE";

        String answer =
                isCommonFactor
                        ? "TRUE"
                        : "FALSE";

        String[] options = FactorOptionUtils.generateTrueFalseOptions();

        return new FactorQuestionData(
                number1,
                number2,
                factor,
                question,
                answer,
                options,
                FactorQuestionType.COMMON_FACTOR_TRUE_FALSE);
    }

    public static FactorQuestionData generateCountCommonFactorsQuestion()
    {
        int number1 = generateNumber();

        int number2 = generateNumber();

        // Make sure the numbers are different.
        while (number2 == number1)
        {
            number2 = generateNumber();
        }

        List<Integer> commonFactors =
                getCommonFactors(
                        number1,
                        number2);

        int correctAnswer =
                commonFactors.size();

        String question =
                "How many common factors are there "
                        + "in "
                        + number1
                        + " and "
                        + number2
                        + "?";

        String[] options = FactorOptionUtils.generateCountOptions(correctAnswer);

        return new FactorQuestionData(
                number1,
                number2,
                0,
                question,
                String.valueOf(correctAnswer),
                options,
                FactorQuestionType.COUNT_COMMON_FACTORS);
    }

    public static boolean validateCountCommonFactorsAnswer(
            FactorQuestionData data)
    {
        if (data == null)
        {
            return false;
        }

        if (data.type
                != FactorQuestionType.COUNT_COMMON_FACTORS)
        {
            return false;
        }

        List<Integer> commonFactors =
                getCommonFactors(
                        data.number,
                        data.secondNumber);

        int expectedAnswer =
                commonFactors.size();

        try
        {
            int actualAnswer =
                    Integer.parseInt(
                            data.answer);

            return actualAnswer == expectedAnswer;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}