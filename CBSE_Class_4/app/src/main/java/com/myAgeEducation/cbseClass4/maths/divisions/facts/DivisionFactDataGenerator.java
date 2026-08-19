package com.myAgeEducation.cbseClass4.maths.divisions.facts;
import java.util.Random;

public class DivisionFactDataGenerator
{
    private static final Random RANDOM = new Random();

    private DivisionFactDataGenerator()
    {
    }

    public static DivisionFactQuestionData generate()
    {
        DivisionFactType type = DivisionFactType.values()[RANDOM.nextInt(DivisionFactType.values().length)];

        //type = DivisionFactType.PAIRS; //todo: only for testing

        switch (type)
        {
            case BASIC_DIVISION:
                return generateBasicDivision();

            case DIVIDE_BY_ONE:
                return generateDivideByOne();

            case DIVIDE_BY_SELF:
                return generateDivideBySelf();

            case MISSING_DIVISOR:
                return generateMissingDivisor();

            case MISSING_QUOTIENT:
                return generateMissingQuotient();

            case IDENTIFY_DIVISOR:
                return generateIdentifyDivisor();

            case IDENTIFY_DIVIDEND:
                return generateIdentifyDividend();

            case IDENTIFY_QUOTIENT:
                return generateIdentifyQuotient();

            case PAIRS:
                return generatePairs();

            case FACT_FAMILY:
                return generateFactFamily();

            default:
                throw new IllegalArgumentException();
        }
    }

    private static DivisionFactQuestionData generateIdentifyDivisor()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.IDENTIFY_DIVISOR);
        int divisor = RANDOM.nextInt(9) + 2;
        int quotient = RANDOM.nextInt(9) + 2;
        int dividend = divisor * quotient;
        String question = String.format(template.questionTemplate, dividend, divisor, quotient);
        return createQuestion(template, question, dividend, divisor, quotient, divisor);
    }

    private static DivisionFactQuestionData generateIdentifyDividend()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.IDENTIFY_DIVIDEND);

        int divisor = RANDOM.nextInt(9) + 2;
        int quotient = RANDOM.nextInt(9) + 2;
        int dividend = divisor * quotient;

        String question = String.format(template.questionTemplate, dividend, divisor, quotient);
        return createQuestion(template, question, dividend, divisor, quotient, dividend);
    }

    private static DivisionFactQuestionData generateIdentifyQuotient()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.IDENTIFY_QUOTIENT);
        int divisor = RANDOM.nextInt(9) + 2;
        int quotient = RANDOM.nextInt(9) + 2;

        int dividend = divisor * quotient;

        String question =
                String.format(
                        template.questionTemplate,
                        dividend,
                        divisor,
                        quotient);

        return createQuestion(
                template,
                question,
                dividend,
                divisor,
                quotient,
                quotient);
    }

    private static DivisionFactQuestionData generatePairs()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.PAIRS);
        int pairs = RANDOM.nextInt(15) + 2;
        int total = pairs * 2;

        String question =
                String.format(
                        template.questionTemplate,
                        total);

        return createQuestion(
                template,
                question,
                total,      // dividend = 20
                2,               // divisor
                pairs,           // quotient = 10
                pairs);          // answer
    }

    private static DivisionFactQuestionData generateFactFamily()
    {

        DivisionFactTemplate template =
                getRandomTemplate(
                        DivisionFactTemplates.FACT_FAMILY);

        int divisor =
                RANDOM.nextInt(9) + 2;

        int quotient =
                RANDOM.nextInt(9) + 2;

        int dividend =
                divisor * quotient;

        String question =
                String.format(
                        template.questionTemplate,
                        divisor,
                        quotient,
                        dividend);

        return createQuestion(
                template,
                question,
                dividend,
                divisor,
                quotient,
                quotient);
    }

    private static DivisionFactTemplate getRandomTemplate(
            DivisionFactTemplate[] templates)
    {
        return templates[
                RANDOM.nextInt(
                        templates.length)];
    }

    private static DivisionFactQuestionData generateBasicDivision()
    {
        DivisionFactTemplate template =
                getRandomTemplate(
                        DivisionFactTemplates.BASIC_DIVISION);

        int divisor =
                RANDOM.nextInt(9) + 2;

        int quotient =
                RANDOM.nextInt(9) + 2;

        int dividend =
                divisor * quotient;

        String question =
                String.format(
                        template.questionTemplate,
                        dividend,
                        divisor);

        return createQuestion(
                template,
                question,
                dividend,
                divisor,
                quotient,
                quotient);
    }

    private static DivisionFactQuestionData generateDivideByOne()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.DIVIDE_BY_ONE);
        int number = RANDOM.nextInt(90000) + 1000;
        String question = String.format(template.questionTemplate, number);
        return createQuestion(
                template,
                question,
                number,
                1,
                number,
                number);
    }

    private static DivisionFactQuestionData generateDivideBySelf()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.DIVIDE_BY_SELF);
        int number = RANDOM.nextInt(90000) + 1000;
        String question = String.format(template.questionTemplate, number, number);
        return createQuestion(
                template,
                question,
                number,
                number,
                1,
                1);
    }

    private static DivisionFactQuestionData generateMissingDivisor()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.MISSING_DIVISOR);

        int divisor =
                RANDOM.nextInt(9) + 2;

        int quotient =
                RANDOM.nextInt(9) + 2;

        int dividend =
                divisor * quotient;

        String question =
                String.format(
                        template.questionTemplate,
                        dividend,
                        quotient);

        return createQuestion(
                template,
                question,
                dividend,
                divisor,
                quotient,
                divisor);
    }

    private static DivisionFactQuestionData generateMissingQuotient()
    {
        DivisionFactTemplate template = getRandomTemplate(DivisionFactTemplates.MISSING_QUOTIENT);
        int divisor =
                RANDOM.nextInt(9) + 2;

        int quotient =
                RANDOM.nextInt(9) + 2;

        int dividend =
                divisor * quotient;

        String question =
                String.format(
                        template.questionTemplate,
                        dividend,
                        divisor);

        return createQuestion(template, question, dividend, divisor, quotient, quotient);
    }

    private static DivisionFactQuestionData createQuestion(DivisionFactTemplate template, String question, int dividend, int divisor, int quotient, int answer)
    {
        return new DivisionFactQuestionData(template, question, dividend, divisor, quotient, answer);
    }
}
