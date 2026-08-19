package com.myAgeEducation.cbseClass4.maths.divisions.facts;

public class DivisionFactTemplates
{
    public static final DivisionFactTemplate[] BASIC_DIVISION =
            {
                    new DivisionFactTemplate(DivisionFactType.BASIC_DIVISION,"%1$d ÷ %2$d = ____"),
                    new DivisionFactTemplate(
                            DivisionFactType.BASIC_DIVISION,
                            "Find %1$d ÷ %2$d")
            };

    public static final DivisionFactTemplate[] DIVIDE_BY_ONE =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.DIVIDE_BY_ONE,
                            "%1$d ÷ 1 = ____")
            };

    public static final DivisionFactTemplate[] DIVIDE_BY_SELF =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.DIVIDE_BY_SELF,
                            "%1$d ÷ %1$d = ____")
            };

    public static final DivisionFactTemplate[] MISSING_DIVISOR =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.MISSING_DIVISOR,
                            "%1$d ÷ ___ = %2$d"),

                    new DivisionFactTemplate(
                            DivisionFactType.MISSING_DIVISOR,
                            "%1$d ÷ ? = %2$d")
            };

    public static final DivisionFactTemplate[] MISSING_QUOTIENT =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.MISSING_QUOTIENT,
                            "%1$d ÷ %2$d = ____"),

                    new DivisionFactTemplate(
                            DivisionFactType.MISSING_QUOTIENT,
                            "%1$d divided by %2$d = ____")
            };

    public static final DivisionFactTemplate[] IDENTIFY_DIVISOR =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.IDENTIFY_DIVISOR,
                            "What is the divisor in \"%1$d ÷ %2$d = %3$d\"?")
            };

    public static final DivisionFactTemplate[] IDENTIFY_QUOTIENT =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.IDENTIFY_QUOTIENT,
                            "What is the quotient in \"%1$d ÷ %2$d = %3$d\"?")
            };

    public static final DivisionFactTemplate[] IDENTIFY_DIVIDEND =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.IDENTIFY_DIVIDEND,
                            "What is the dividend in \"%1$d ÷ %2$d = %3$d\"?")
            };

    public static final DivisionFactTemplate[] PAIRS =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.PAIRS,
                            "How many pairs are there in %1$d earrings?"),

                    new DivisionFactTemplate(
                            DivisionFactType.PAIRS,
                            "How many pairs are there in %1$d shoes?"),

                    new DivisionFactTemplate(
                            DivisionFactType.PAIRS,
                            "How many pairs are there in %1$d socks?")
            };

    public static final DivisionFactTemplate[] FACT_FAMILY =
            {
                    new DivisionFactTemplate(
                            DivisionFactType.FACT_FAMILY,
                            "%1$d × %2$d = %3$d\n%3$d ÷ %1$d = ____")
            };
}