package com.myAgeEducation.cbseClass4.maths.fractions;

import android.util.Log;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import java.util.List;
import java.util.Random;

public class FractionQuestionGenerator {
    public enum FractionQuestionType {

        COLOURED_FRACTION,
        UNCOLOURED_FRACTION,
        COLOURED_PARTS,
        UNCOLOURED_PARTS,
        TOTAL_PARTS,
        NUMERATOR,
        DENOMINATOR,
        IDENTIFY_FRACTION,
        ODD_ONE_OUT
    }
    private static final Random RANDOM = new Random();

    public static Question generateQuestion()
    {
        FractionQuestionType type =
                FractionQuestionType.values()[
                        RANDOM.nextInt(
                                FractionQuestionType.values().length)];

        FractionData fraction = FractionImageGenerator.randomFraction();
        //type = FractionQuestionType.NUMERATOR;

        Log.d("NKG_LOG", type.name());

        switch (type)
        {
            case COLOURED_FRACTION:
                return generateColouredFractionQuestion(fraction);

            case UNCOLOURED_FRACTION:
                return generateUncolouredFractionQuestion(fraction);

            case COLOURED_PARTS:
                return generateColouredPartsQuestion(fraction);

            case UNCOLOURED_PARTS:
                return generateUncolouredPartsQuestion(fraction);

            case TOTAL_PARTS:
                return generateTotalPartsQuestion(fraction);

            case NUMERATOR:
                return generateNumeratorQuestion(fraction);

            case DENOMINATOR:
                return generateDenominatorQuestion(fraction);

            case IDENTIFY_FRACTION:
                return generateIdentifyFractionQuestion();

            case ODD_ONE_OUT:
                return generateOddOneOutFractionQuestion();

            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }

    private static Question generateIdentifyFractionQuestion()
    {
        ChoiceFractionData data = FractionChoiceGenerator.generateIdentifyFractionQuestion();
        Question question = new Question();

        question.setQuestion(data.questionText);
        question.setImage(data.imageCode);

        question.setOption1("A");
        question.setOption2("B");
        question.setOption3("C");
        question.setOption4("D");

        question.setAnswer(data.answer);
        return question;
    }

    private static Question generateColouredFractionQuestion(FractionData fraction)
    {
        int numerator = fraction.numerator;
        int denominator = fraction.denominator;

        String[] questionVariants = {
                "What fraction of the figure is coloured?",
                "Which fraction represents the coloured part?",
                "Find the coloured fraction.",
                "Look at the picture below. What fraction is coloured?",
                "Identify the coloured fraction."
        };

        String questionText = questionVariants[RANDOM.nextInt(questionVariants.length)];

        String answer =	fractionToWords(numerator, denominator);

        List<String> options = OptionUtils.generateFractionOptions(numerator, denominator);

        Question question = new Question();

        question.setQuestion(questionText);

        /*question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));*/
        OptionUtils.setQuestionOptions(question, options);

        question.setAnswer(answer);
        question.setImage(fraction.getImageCode());
        return question;
    }

    public static Question generateUncolouredFractionQuestion(FractionData fraction)
    {
        int numerator = fraction.numerator;
        int denominator = fraction.denominator;

        int uncoloured = denominator - numerator;

        String[] questionVariants = {
                "What fraction of the figure is NOT coloured?",
                "Which fraction represents the uncoloured part?",
                "Find the fraction that is left uncoloured.",
                "What fraction of the figure is white?",
                "Identify the fraction that is not coloured."
        };

        String questionText = questionVariants[RANDOM.nextInt(questionVariants.length)];

        String answer =
                fractionToWords(
                        uncoloured,
                        denominator);

        List<String> options =
                OptionUtils.generateFractionOptions(
                        uncoloured,
                        denominator);

        Question question = new Question();

        question.setQuestion(questionText);

        /*question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));*/

        OptionUtils.setQuestionOptions(question, options);

        question.setAnswer(answer);

        question.setImage(fraction.getImageCode());

        return question;
    }

    public static Question generateColouredPartsQuestion(
            FractionData fraction)
    {
        int numerator = fraction.numerator;
        int denominator = fraction.denominator;

        String[] questionVariants = {
                "How many parts are coloured?",
                "Count the coloured parts.",
                "How many coloured pieces are there?",
                "How many sections are coloured?",
                "How many equal parts are shaded?",
                "Count the shaded parts.",
                "How many parts have been coloured?"
        };

        String questionText = questionVariants[RANDOM.nextInt(questionVariants.length)];

        String answer = String.valueOf(numerator);

        List<String> options = OptionUtils.generateNumberOptions(numerator, denominator);

        Question question = new Question();
        question.setQuestion(questionText);
        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));
        question.setAnswer(answer);
        question.setImage(fraction.getImageCode());
        return question;
    }

    public static Question generateUncolouredPartsQuestion(FractionData fraction)
    {
        int numerator = fraction.numerator;
        int denominator = fraction.denominator;

        int uncoloured = denominator - numerator;

        String[] questionVariants = {
                "How many parts are NOT coloured?",
                "Count the uncoloured parts.",
                "How many white pieces are there?",
                "How many sections are left uncoloured?",
                "How many equal parts are not shaded?",
                "Count the parts that are not coloured.",
                "How many parts remain uncoloured?"
        };

        String questionText = questionVariants[RANDOM.nextInt(questionVariants.length)];

        String answer = String.valueOf(uncoloured);

        List<String> options = OptionUtils.generateNumberOptions(uncoloured,denominator);

        Question question = new Question();

        question.setQuestion(questionText);

        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));

        question.setAnswer(answer);

        question.setImage(fraction.getImageCode());

        return question;
    }

    public static Question generateTotalPartsQuestion(FractionData fraction)
    {
        int denominator = fraction.denominator;

        String[] questionVariants = {
                "Into how many equal parts is the figure divided?",
                "How many equal parts are there in the figure?",
                "Count the total number of equal parts.",
                "How many pieces make the whole figure?",
                "How many sections are there altogether?",
                "How many equal pieces is the figure divided into?",
                "Find the total number of parts."
        };

        String questionText = questionVariants[RANDOM.nextInt(questionVariants.length)];

        String answer = String.valueOf(denominator);

        List<String> options =OptionUtils.generateDenominatorOptions(denominator);

        Question question = new Question();

        question.setQuestion(questionText);

        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));

        question.setAnswer(answer);

        question.setImage(fraction.getImageCode());

        return question;
    }

    public static Question generateNumeratorQuestion(FractionData fraction)
    {
        int numerator = fraction.numerator;
        int denominator = fraction.denominator;

        String[] questionVariants = {
                "What is the numerator of the coloured fraction?",
                "Find the numerator of the fraction represented by the coloured part.",
                "Which number is the numerator?",
                "Identify the numerator.",
                "What is the top number of the coloured fraction?",
                "The coloured part represents a fraction. What is its numerator?",
                "Find the numerator of the given fraction."
        };

        String questionText = questionVariants[RANDOM.nextInt(questionVariants.length)];
        String answer = String.valueOf(numerator);
        List<String> options = OptionUtils.generateNumberOptions(numerator,denominator);
        Question question = new Question();
        question.setQuestion(questionText);
        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));
        question.setAnswer(answer);
        question.setImage(fraction.getImageCode());
        return question;
    }

    public static Question generateDenominatorQuestion(FractionData fraction)
    {
        int numerator = fraction.numerator;
        int denominator = fraction.denominator;

        String[] questionVariants = {
                "What is the denominator of the coloured fraction?",
                "Find the denominator of the fraction represented by the coloured part.",
                "Which number is the denominator?",
                "Identify the denominator.",
                "What is the bottom number of the coloured fraction?",
                "The coloured part represents a fraction. What is its denominator?",
                "Find the denominator of the given fraction."
        };

        String questionText =
                questionVariants[
                        RANDOM.nextInt(questionVariants.length)];

        String answer = String.valueOf(denominator);

        List<String> options = OptionUtils.generateDenominatorQuestionOptions(numerator,denominator);

        Question question = new Question();

        question.setQuestion(questionText);

        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));

        question.setAnswer(answer);

        question.setImage(fraction.getImageCode());

        return question;
    }

    private static Question generateOddOneOutFractionQuestion()
    {
        ChoiceFractionData data = FractionChoiceGenerator.generateOddOneOutQuestion();

        Question question = new Question();
        question.setQuestion(data.questionText);
        question.setImage(data.imageCode);

        question.setOption1("A");
        question.setOption2("B");
        question.setOption3("C");
        question.setOption4("D");

        question.setAnswer(data.answer);

        return question;
    }

    private static String fractionToWords(int numerator, int denominator)
    {
        String[] numbers = {
                "Zero",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight"
        };

        String denominatorWord;

        switch (denominator)
        {
            case 2:
                denominatorWord = "Half";
                break;

            case 3:
                denominatorWord = "Third";
                break;

            case 4:
                denominatorWord = "Fourth";
                break;

            case 5:
                denominatorWord = "Fifth";
                break;

            case 6:
                denominatorWord = "Sixth";
                break;

            case 8:
                denominatorWord = "Eighth";
                break;

            default:
                denominatorWord = denominator + "th";
        }

        if (numerator > 1 &&
                !denominatorWord.endsWith("s"))
        {
            denominatorWord += "s";
        }

        return numbers[numerator]
                + " "
                + denominatorWord;
    }
}
