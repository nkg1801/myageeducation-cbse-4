package com.myAgeEducation.cbseClass4.maths.multiples;

public class MultipleQuestionTemplatesUtil {

    public static String[] getQuestionTemplates(MultipleQuestionType type) {
        switch (type) {
            case MULTIPLE_TRUE_FALSE:
                return templatesForMultipleTrueFalse;
            case LIST_MULTIPLE_TRUE_FALSE:
                return templatesForListMultipleTrueFalse;
            case PROPERTY_ONE_MULTIPLE:
                return templatesForPropertyOneMultiple;
            case PROPERTY_SELF_MULTIPLE:
                return templatesForPropertySelfMultiple;
            case PROPERTY_MULTIPLE_OF_ONE:
                return templatesForPropertyMultipleOfOne;
            case COMMON_MULTIPLE:
                return templatesForCommonMultiple;
            default:
                return new String[]{};
        }
    }

    private static final String[] templatesForMultipleTrueFalse = {
            "%d is a multiple of %d. TRUE or FALSE?",
            "Is it true that %d is a multiple of %d?",
            "TRUE or FALSE: %d is a multiple of %d."
    };

    private static final String[] templatesForListMultipleTrueFalse = {
            "%s are all multiples of %d. TRUE or FALSE?",
            "TRUE or FALSE: The numbers %s are all multiples of %d.",
            "Regarding the numbers %s, are they all multiples of %d?"
    };

    private static final String[] templatesForPropertyOneMultiple = {
            "1 is a multiple of every number. TRUE or FALSE?",
            "TRUE or FALSE: 1 is a multiple of all integers.",
            "Is 1 a multiple of every number?"
    };

    private static final String[] templatesForPropertySelfMultiple = {
            "A number is a multiple of itself. TRUE or FALSE?",
            "TRUE or FALSE: Every number is a multiple of itself.",
            "Is it true that a number is a multiple of itself?"
    };

    private static final String[] templatesForPropertyMultipleOfOne = {
            "Every number is a multiple of 1. TRUE or FALSE?",
            "TRUE or FALSE: 1 is a divisor of every number, so every number is a multiple of 1.",
            "Is every number a multiple of 1?"
    };

    private static final String[] templatesForCommonMultiple = {
            "Which of the following is a common multiple of %d and %d?",
            "Pick a common multiple of %d and %d.",
            "Find a number that is a multiple of both %d and %d.",
            "Select the common multiple of %d and %d from the options below."
    };
}
