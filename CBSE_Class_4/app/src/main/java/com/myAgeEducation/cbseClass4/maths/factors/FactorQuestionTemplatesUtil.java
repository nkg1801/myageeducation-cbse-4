package com.myAgeEducation.cbseClass4.maths.factors;

public class FactorQuestionTemplatesUtil {

    public static String[] getQuestionTemplates(FactorQuestionType factorQuestionType) {
        switch (factorQuestionType) {
            case LIST_FACTORS:
                return questionTemplatesForListFactors;

            case FACTOR_TRUE_FALSE:
                return questionTemplatesForFactorTrueFalse;

            case FIND_FACTOR:
                return questionTemplatesForFindFactor;

            case FIND_NOT_FACTOR:
                return questionTemplatesForFindNotFactor;

            case COMMON_FACTOR:
                return questionTemplatesForCommonFactor;

            case FACTOR_OF_TWO_NUMBERS:
                return questionTemplatesForFactorOfTwoNumbers;

            case FILL_MISSING_FACTOR:
                return questionTemplatesForFillMissingFactors;

            default: //GREATEST_FACTOR
                return questionTemplatesForGreatestFactors;
        }
    }
    private static final String[] questionTemplatesForFactorTrueFalse = {
            "%d is a factor of %d. TRUE or FALSE?",
            "%d divides %d exactly. TRUE or FALSE?",
            "%d is one of the factors of %d. TRUE or FALSE?",
            "%d can divide %d without leaving a remainder. TRUE or FALSE?",
            "%d is a divisor of %d. TRUE or FALSE?",
            //"%d goes evenly into %d. TRUE or FALSE?",
            //"%d is not a factor of %d. TRUE or FALSE?",
            //"%d does not divide %d exactly. TRUE or FALSE?",
            //"%d is among the positive factors of %d. TRUE or FALSE?",
            //"%d can be multiplied by an integer to get %d. TRUE or FALSE?",
            //"%d is evenly divisible into %d. TRUE or FALSE?",
            "Is it true that %d is a factor of %d?",
            "TRUE or FALSE: %d is a divisor of %d.",
            "TRUE or FALSE: %d divides %d without a remainder.",
            "TRUE or FALSE: %d is one of the factors of %d."
    };

    private static final String[] questionTemplatesForListFactors = {
            "What are the factors of %d?",
            "List the factors of %d.",
            "Can you identify the factors of %d?",
            "Which numbers are factors of %d?",
            "Find all factors of %d.",
            "Determine the factors of %d.",
            "What numbers divide %d exactly?",
            "Name all the factors of %d.",
            "Write down the factors of %d.",
            "What integers are factors of %d?",
            "Identify all numbers that are factors of %d.",
            "Give the complete list of factors of %d.",
    };

    private static final String[] questionTemplatesForGreatestFactors = {
            "The greatest factor of %d is ______.",
            "What is the greatest factor of %d?",
            "Write the greatest factor of %d.",
            "Fill in the blank: The greatest factor of %d is ______.",
            "Which is the greatest factor of %d?",
            "Name the greatest factor of %d.",
            "Find the greatest factor of %d.",
            "The biggest factor of %d is ______.",
            "What is the biggest factor of %d?",
            "Complete the sentence: The greatest factor of %d is ______."
    };

    private static final String[] questionTemplatesForFindFactor = {
            "Which of the following numbers is a factor of %d?",
            "Pick the factor of %d.",
            "Choose the factor of %d.",
            "Find the factor of %d from the numbers below.",
            "Which number is a factor of %d?",
            "Select the factor of %d.",
            "Can you find a factor of %d?",
            "Tick the number that is a factor of %d.",
            "Circle the factor of %d.",
            "From the given numbers, which is a factor of %d?"
    };

    private static final String[] questionTemplatesForFindNotFactor = {
            "Which of the following numbers is NOT a factor of %d?",
            "Pick the number that is NOT a factor of %d.",
            "Choose the number that is NOT a factor of %d.",
            "Find the number that is NOT a factor of %d.",
            "Which number is not a factor of %d?",
            "Select the number that is NOT a factor of %d.",
            "Can you find the number that is NOT a factor of %d?",
            "From the given numbers, which is NOT a factor of %d?"
    };

    private static final String[] questionTemplatesForCommonFactor = {
            "Which of the following numbers is a factor of both %d and %d?",
            "Pick the number that is a factor of both %d and %d.",
            "Choose the factor that is common to %d and %d.",
            "Find a number that is a factor of both %d and %d.",
            "Which number divides both %d and %d exactly?",
            "Select the number that is a factor of both %d and %d.",
            "Can you find a common factor of %d and %d?",
            "From the given numbers, which is a factor of both %d and %d?"
    };

    private static final String[] questionTemplatesForFactorOfTwoNumbers = {
            "%d is a factor of which of the following two numbers?",
            "Which of these two numbers has %d as a factor?",
            "Pick the two numbers that is divisible by %d.",
            "Choose the two numbers that has %d as a factor.",
            "Find the two numbers that %d divides exactly.",
            "Which of the following two numbers can be divided exactly by %d?",
            "Select the two numbers for which %d is a factor.",
            "From the two numbers given, which one has %d as a factor?"
    };

    private static final String[] questionTemplatesForFillMissingFactors = {
            "The factors of %d are: ",
            "Complete the factors of %d: ",
            "Fill in the missing factor of %d: ",
            "One factor of %d is missing. Complete the list: ",
            "Write the missing factor of %d: ",
            "Can you complete the factors of %d? ",
            "Find the missing factor of %d: ",
            "The list of factors of %d is incomplete. Fill in the blank: ",
            "Complete the factor list for %d: ",
            "Which factor is missing from the list of factors of %d? "
    };
}
