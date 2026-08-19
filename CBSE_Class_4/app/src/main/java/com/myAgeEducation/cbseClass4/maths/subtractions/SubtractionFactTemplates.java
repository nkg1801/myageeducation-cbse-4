package com.myAgeEducation.cbseClass4.maths.subtractions;

public class SubtractionFactTemplates
{
    public static final SubtractionFactTemplate[] SUCCESSOR =
            {
                    new SubtractionFactTemplate(
                            SubtractionFactType.SUCCESSOR,
                            "Write the successor of %1$d."),

                    new SubtractionFactTemplate(
                            SubtractionFactType.SUCCESSOR,
                            "What comes immediately after %1$d?")
            };

    public static final SubtractionFactTemplate[] PREDECESSOR =
            {
                    new SubtractionFactTemplate(
                            SubtractionFactType.PREDECESSOR,
                            "Write the predecessor of %1$d."),

                    new SubtractionFactTemplate(
                            SubtractionFactType.PREDECESSOR,
                            "What comes immediately before %1$d?")
            };

    public static final SubtractionFactTemplate[] LARGEST_4_DIGIT_SUCCESSOR =
            {
                    new SubtractionFactTemplate(
                            SubtractionFactType.LARGEST_4_DIGIT_SUCCESSOR,
                            "The successor of the ______ largest 4-digit number is the smallest 5-digit number.")
            };

    public static final SubtractionFactTemplate[] PLACE_VALUE_DIFFERENCE =
            {
                    new SubtractionFactTemplate(
                            SubtractionFactType.PLACE_VALUE_DIFFERENCE,
                            "Find the difference between the place value of %1$d and the place value of %2$d in the numeral %3$d."),

                    new SubtractionFactTemplate(
                            SubtractionFactType.PLACE_VALUE_DIFFERENCE,
                            "Find the difference between the place values of two %1$ds in %2$d.")
            };
}