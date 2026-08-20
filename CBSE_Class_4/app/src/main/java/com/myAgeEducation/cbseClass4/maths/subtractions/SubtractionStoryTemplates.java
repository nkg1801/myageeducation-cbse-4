package com.myAgeEducation.cbseClass4.maths.subtractions;

public class SubtractionStoryTemplates
{
    //----------------------------------------------------------
    // HAS_LESS
    //----------------------------------------------------------

    public static final SubtractionStoryTemplate[] HAS_LESS =
            {
                    new SubtractionStoryTemplate(
                            SubtractionStoryType.HAS_LESS,
                            "%1$s has %2$s marbles. %1$s gives away %4$s marbles. How many marbles does %1$s have left?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.HAS_LESS,
                            "%1$s has %2$s balloons. %1$s gives %4$s balloons to %3$s. How many balloons does %1$s have now?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.HAS_LESS,
                            "%1$s has %2$s chocolates. %1$s eats %4$s chocolates. How many chocolates are left?")
            };

    //----------------------------------------------------------
    // GROUP_SHRINKS
    //----------------------------------------------------------

    public static final SubtractionStoryTemplate[] GROUP_SHRINKS =
            {
                    new SubtractionStoryTemplate(
                            SubtractionStoryType.GROUP_SHRINKS,
                            "There are %2$s birds on a tree. %4$s birds fly away. How many birds remain?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.GROUP_SHRINKS,
                            "There are %2$s children in a playground. %4$s children go home. How many children are left?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.GROUP_SHRINKS,
                            "There are %2$s books on a shelf. %4$s books are taken away. How many books remain?")
            };

    //----------------------------------------------------------
    // MONEY_SPENT
    //----------------------------------------------------------

    public static final SubtractionStoryTemplate[] MONEY_SPENT =
            {
                    new SubtractionStoryTemplate(
                            SubtractionStoryType.MONEY_SPENT,
                            "%1$s has ₹%2$s. %1$s spends ₹%4$s. How much money is left?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.MONEY_SPENT,
                            "%1$s has ₹%2$s in a wallet. %1$s buys a toy for ₹%4$s. How much money remains?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.MONEY_SPENT,
                            "%1$s saves ₹%2$s. %1$s spends ₹%4$s on books. How much money is left?")
            };

    //----------------------------------------------------------
    // UNKNOWN_START
    //----------------------------------------------------------

    public static final SubtractionStoryTemplate[] UNKNOWN_START =
            {
                    new SubtractionStoryTemplate(
                            SubtractionStoryType.UNKNOWN_START,
                            "%1$s sold %4$s balloons. %1$s still has %2$s balloons left. How many balloons did %1$s have at first?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.UNKNOWN_START,
                            "%1$s gave away %4$s chocolates. %1$s has %2$s chocolates left. How many chocolates did %1$s have?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.UNKNOWN_START,
                            "%1$s lost %4$s marbles. %1$s still has %2$s marbles. How many marbles did %1$s have originally?")
            };

    //----------------------------------------------------------
    // UNKNOWN_CHANGE
    //----------------------------------------------------------

    public static final SubtractionStoryTemplate[] UNKNOWN_CHANGE =
            {
                    new SubtractionStoryTemplate(
                            SubtractionStoryType.UNKNOWN_CHANGE,
                            "%1$s had %2$s pencils. Now %1$s has %4$s pencils. How many pencils were lost?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.UNKNOWN_CHANGE,
                            "There were %2$s birds on a tree. Now there are %4$s birds. How many birds flew away?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.UNKNOWN_CHANGE,
                            "%1$s had %2$s stickers. Now %1$s has %4$s stickers. How many stickers were used?")
            };

    //----------------------------------------------------------
    // COMPARISON
    //----------------------------------------------------------

    public static final SubtractionStoryTemplate[] COMPARISON =
            {
                    new SubtractionStoryTemplate(
                            SubtractionStoryType.COMPARISON,
                            "%1$s has %2$s pencils. %3$s has %4$s pencils. How many more pencils does %1$s have?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.COMPARISON,
                            "%1$s collected %2$s shells. %3$s collected %4$s shells. How many more shells did %1$s collect?"),

                    new SubtractionStoryTemplate(
                            SubtractionStoryType.COMPARISON,
                            "%1$s scored %2$s runs. %3$s scored %4$s runs. By how many runs did %1$s score more?")
            };
}