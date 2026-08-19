package com.myAgeEducation.cbseClass4.maths.divisions.story;

public class DivisionStoryTemplates {
    private DivisionStoryTemplates()
    {
    }

    public static final DivisionStoryTemplate[] BASIC_DIVISION_TEMPLATES =
            {
                    new DivisionStoryTemplate(
                            DivisionStoryType.BASIC_DIVISION,
                            "%2$d shared equally by %4$d is ______", false),

                    new DivisionStoryTemplate(
                            DivisionStoryType.BASIC_DIVISION,
                            "%2$d ÷ %4$d = ______", false),

                    new DivisionStoryTemplate(
                            DivisionStoryType.BASIC_DIVISION,
                            "Divide %2$d equally into %4$d groups.", false),
            };

    public static final DivisionStoryTemplate[] HOW_MANY_GROUPS_TEMPLATES = {
            new DivisionStoryTemplate(
                    DivisionStoryType.HOW_MANY_GROUPS,
                    "How many %4$ds are there in %2$d?", false),

            new DivisionStoryTemplate(
                    DivisionStoryType.HOW_MANY_GROUPS,
                    "How many groups of %4$d can be made from %2$d objects?", false),
    };

    public static final DivisionStoryTemplate[] EQUAL_GROUPING_TEMPLATES = {
            new DivisionStoryTemplate(
                    DivisionStoryType.EQUAL_GROUPING,
                    "There are %2$d pictures in all with %4$d pictures on each page. How many pages are needed?", false),

            new DivisionStoryTemplate(
                    DivisionStoryType.EQUAL_GROUPING,
                    "There are %2$d people with %4$d people in each row. How many rows are there?", false),

            new DivisionStoryTemplate(
                    DivisionStoryType.EQUAL_GROUPING,
                    "There are %2$d marbles with %4$d marbles in each bowl. How many bowls are needed?", false),

            new DivisionStoryTemplate(
                    DivisionStoryType.EQUAL_GROUPING,
                    "There are %2$d children with %4$d children in each team. How many teams can be formed?", false)
    };

    public static final DivisionStoryTemplate[] REPEATED_SUBTRACTION_TEMPLATES = {
            new DivisionStoryTemplate(
                    DivisionStoryType.REPEATED_SUBTRACTION,
                    "How many times can you take away %4$d from %2$d?", false),

            new DivisionStoryTemplate(
                    DivisionStoryType.REPEATED_SUBTRACTION,
                    "Subtract %4$d repeatedly from %2$d. How many times can you subtract?", false)
    };

    public static final DivisionStoryTemplate[] EQUAL_SHARING_TEMPLATES = {
            new DivisionStoryTemplate(
                    DivisionStoryType.EQUAL_SHARING,
                    "%4$d children bought a book costing Rs %2$d. How much should each child pay?", false),

            new DivisionStoryTemplate(
                    DivisionStoryType.EQUAL_SHARING,
                    "%2$d chocolates are shared equally among %4$d children. How many chocolates does each child get?", false),

            new DivisionStoryTemplate(
                    DivisionStoryType.EQUAL_SHARING,
                    "%2$d apples are shared equally among %4$d friends. How many apples does each friend get?", false)
    };

    public static final DivisionStoryTemplate[] DIFFERENCE_SHARING_TEMPLATES = {
            new DivisionStoryTemplate(
                    DivisionStoryType.DIFFERENCE_SHARING,
                    "Harsh had %2$d books. He put them into 2 piles. One pile had %4$d more books than the other. How many books were in each pile?", true),

            new DivisionStoryTemplate(
                    DivisionStoryType.DIFFERENCE_SHARING,
                    "There are %2$d sweets divided into two packets. One packet has %4$d more sweets than the other. How many sweets are in each packet?", false)
    };
}
