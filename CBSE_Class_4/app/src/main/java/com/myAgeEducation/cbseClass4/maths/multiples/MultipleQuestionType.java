package com.myAgeEducation.cbseClass4.maths.multiples;

public enum MultipleQuestionType {
    MULTIPLE_TRUE_FALSE,          // e.g., 48 is a multiple of 3 (TRUE/FALSE)
    LIST_MULTIPLE_TRUE_FALSE,     // e.g., 2,4,6,8,12 are all multiples of 4 (TRUE/FALSE)
    PROPERTY_ONE_MULTIPLE,        // e.g., 1 is a multiple of every number (TRUE/FALSE)
    PROPERTY_SELF_MULTIPLE,       // e.g., A number is a multiple of itself (TRUE/FALSE)
    PROPERTY_MULTIPLE_OF_ONE,     // e.g., Every number is a multiple of 1 (TRUE/FALSE)
    COMMON_MULTIPLE               // e.g., Which of the following is a common multiple of 5 and 6
}
