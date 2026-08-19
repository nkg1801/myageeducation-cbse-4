package com.myAgeEducation.cbseClass4.maths.fractions;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;

import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FractionChoiceGenerator {

    private static final Random RANDOM = new Random();

    public static ChoiceFractionData generate(int width, int height, FractionData correctFraction) {
        ChoiceFractionData data = new ChoiceFractionData();
        FractionData[] fractions = new FractionData[4];
        int correctIndex = RANDOM.nextInt(4);
        fractions[correctIndex] = correctFraction;
        Set<String> used = new HashSet<>();

        used.add(correctFraction.numerator + "/" + correctFraction.denominator);

        for (int i = 0; i < 4; i++) {
            if (i == correctIndex)
                continue;

            FractionData wrong;

            do {
                wrong = FractionImageGenerator.randomFraction();

            } while (used.contains(
                    wrong.numerator + "/" + wrong.denominator));

            used.add(wrong.numerator + "/" + wrong.denominator);

            fractions[i] = wrong;
        }

        //data.bitmap = createBitmap(width, height, fractions);

        data.answer = String.valueOf((char) ('A' + correctIndex));

        data.fractions = fractions;

        return data;
    }

    public static Bitmap generateCompositeBitmap(int width, int height, FractionData[] fractions)    {
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        int margin = 30;

        int cellWidth = (width - margin * 3) / 2;
        int cellHeight = (height - margin * 3) / 2;

        drawChoice(canvas,fractions[0],margin,margin,cellWidth,cellHeight,"A");
        drawChoice(canvas,fractions[1],margin * 2 + cellWidth,margin,cellWidth,cellHeight,"B");
        drawChoice(canvas,fractions[2],margin,margin * 2 + cellHeight,cellWidth,cellHeight,"C");
        drawChoice(canvas,fractions[3],margin * 2 + cellWidth,margin * 2 + cellHeight,cellWidth,cellHeight,"D");
        return bitmap;
    }

    private static void drawChoice(Canvas canvas,FractionData fraction,int x,int y,int width,int height,String label)
    {

        Paint border = new Paint(Paint.ANTI_ALIAS_FLAG);
        border.setColor(Color.LTGRAY);
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(4);
        canvas.drawRoundRect(new RectF(x, y, x + width, y + height),20,20,border);

        Paint text = new Paint(Paint.ANTI_ALIAS_FLAG);
        text.setColor(Color.BLACK);
        text.setTextSize(55);
        text.setTypeface(Typeface.DEFAULT_BOLD);
        //canvas.drawText(label,x + 20,y + 60,text);
        Paint.FontMetrics fm = text.getFontMetrics();

        float textX = x + 20;
        float textY = y + 20 - fm.top;

        canvas.drawText(label, textX, textY, text);
        int imageSize = (int)(Math.min(width, height) * 0.72);

        Log.d("NKG_LOG", "Drawing " + fraction.shape + " " + fraction.numerator + "/" + fraction.denominator);
        Bitmap option = FractionImageGenerator.generateFraction(
                imageSize,
                imageSize,
                fraction);

        int imageX = x + (width - imageSize) / 2;
        int imageY = y + 80;

        canvas.drawBitmap(option, imageX, imageY, null);
    }

    public static String createImageCode(FractionData[] fractions, int correctIndex)
    {
        StringBuilder sb = new StringBuilder("use_fraction_choice_generator_code;");

        for (FractionData f : fractions)
        {
            sb.append(f.denominator)
                    .append("_")
                    .append(f.numerator)
                    .append("_")
                    .append(f.shape.name())
                    .append("_")
                    .append(f.theme.name())
                    .append("_")
                    .append(f.variation)
                    .append(";");
        }

        sb.append(correctIndex);
        return sb.toString();
    }

    public static FractionData[] parseImageCode(String imageCode)
    {
        String[] parts = imageCode.split(";");
        FractionData[] fractions = new FractionData[4];

        for (int i = 0; i < 4; i++)
        {
            String[] p = parts[i + 1].split("_");

            int denominator = Integer.parseInt(p[0]);
            int numerator   = Integer.parseInt(p[1]);

            FractionImageGenerator.FractionShape shape = FractionImageGenerator.FractionShape.valueOf(p[2]);
            FractionImageGenerator.FractionTheme theme = FractionImageGenerator.FractionTheme.valueOf(p[3]);
            int variation = Integer.parseInt(p[4]);

            fractions[i] = new FractionData(numerator, denominator, shape, theme, variation);
        }

        return fractions;
    }

    public static ChoiceFractionData generateIdentifyFractionQuestionOld()
    {
        Log.d("NKG_LOG", "generateIdentifyFractionQuestion Start");
        ChoiceFractionData data = new ChoiceFractionData();
        Log.d("NKG_LOG", "1");
        FractionData correctFraction = FractionImageGenerator.randomFraction();
        Log.d("NKG_LOG", "2");
        int correctIndex = RANDOM.nextInt(4);

        FractionData[] fractions = new FractionData[4];
        fractions[correctIndex] = correctFraction;

        Set<String> used = new HashSet<>();
        used.add(correctFraction.numerator + "/" + correctFraction.denominator);
        Log.d("NKG_LOG", "3");

        for (int i = 0; i < 4; i++)
        {
            Log.d("NKG_LOG", "Loop " + i);
            if (i == correctIndex)
                continue;

            Log.d("NKG_LOG", "Before randomFraction");
            FractionData wrong;
            Log.d("NKG_LOG", "Used = " + used);
            do
            {
                wrong = FractionImageGenerator.randomFraction();
                /*Log.d("NKG_LOG",
                        "Generated "
                                + wrong.shape
                                + " "
                                + wrong.numerator
                                + "/"
                                + wrong.denominator);*/

                Log.d("NKG_LOG",
                        "Trying "
                                + wrong.numerator + "/"
                                + wrong.denominator);

            } while (used.contains(
                    wrong.numerator + "/" + wrong.denominator));

            //Log.d("NKG_LOG", "Accepted");

            Log.d("NKG_LOG",
                    "Accepted "
                            + wrong.numerator + "/"
                            + wrong.denominator);

            used.add(wrong.numerator + "/" + wrong.denominator);

            fractions[i] = wrong;
        }

        data.fractions = fractions;
        data.correctIndex = correctIndex;
        data.answer = String.valueOf((char)('A' + correctIndex));

        Log.d("NKG_LOG", "Before createImageCode");
        data.imageCode = createImageCode(fractions, correctIndex);

        Log.d("NKG_LOG", "After createImageCode");

        data.questionText = "Which picture shows "
                + fractionToWords(
                data.fractions[data.correctIndex].numerator,
                data.fractions[data.correctIndex].denominator)
                + "?";

        Log.d("NKG_LOG", "generateIdentifyFractionQuestion End");
        return data;
    }

    public static ChoiceFractionData generateIdentifyFractionQuestion()
    {
        ChoiceFractionData data = new ChoiceFractionData();

        // Create and shuffle all possible fractions
        List<FractionKey> pool = FractionPool.createPool();

        // Pick one as the correct fraction
        FractionKey correctKey = pool.remove(0);

        FractionData correctFraction =
                FractionImageGenerator.createFraction(
                        correctKey.numerator,
                        correctKey.denominator);

        // Random position for the correct answer
        int correctIndex = RANDOM.nextInt(4);

        FractionData[] fractions = new FractionData[4];
        fractions[correctIndex] = correctFraction;

        // Fill remaining three choices

        for (int i = 0; i < 4; i++)
        {
            if (i == correctIndex)
                continue;

            FractionKey key = pool.remove(0);

            fractions[i] =
                    FractionImageGenerator.createFraction(
                            key.numerator,
                            key.denominator);
        }

        data.fractions = fractions;
        data.correctIndex = correctIndex;
        data.answer = String.valueOf((char) ('A' + correctIndex));

        data.imageCode = createImageCode(
                fractions,
                correctIndex);

        data.questionText =
                "Which picture shows "
                        + fractionToWords(
                        correctFraction.numerator,
                        correctFraction.denominator)
                        + "?";

        return data;
    }

    public static ChoiceFractionData generateOddOneOutQuestion()
    {
        ChoiceFractionData data = new ChoiceFractionData();

        // Fraction that 3 pictures will represent
        FractionData correctFraction = FractionImageGenerator.randomFraction();

        // Position of the incorrect picture
        int correctIndex = RANDOM.nextInt(4);

        FractionData[] fractions = new FractionData[4];

        // Generate the three correct pictures
        for (int i = 0; i < 4; i++)
        {
            if (i == correctIndex)
                continue;

            FractionImageGenerator.FractionShape shape =
                    FractionImageGenerator.FractionShape.values()[
                            RANDOM.nextInt(FractionImageGenerator.FractionShape.values().length)];

            FractionImageGenerator.FractionTheme theme =
                    FractionImageGenerator.FractionTheme.values()[
                            RANDOM.nextInt(FractionImageGenerator.FractionTheme.values().length)];

            int variation = RANDOM.nextInt(100000);

            fractions[i] = new FractionData(
                    correctFraction.numerator,
                    correctFraction.denominator,
                    shape,
                    theme,
                    variation);
        }

        // Generate one wrong fraction
        FractionData wrong;

        do
        {
            wrong = FractionImageGenerator.randomFraction();

        } while (wrong.numerator == correctFraction.numerator &&
                wrong.denominator == correctFraction.denominator);

        FractionImageGenerator.FractionShape wrongShape =
                FractionImageGenerator.FractionShape.values()[
                        RANDOM.nextInt(FractionImageGenerator.FractionShape.values().length)];

        FractionImageGenerator.FractionTheme wrongTheme =
                FractionImageGenerator.FractionTheme.values()[
                        RANDOM.nextInt(FractionImageGenerator.FractionTheme.values().length)];

        fractions[correctIndex] = new FractionData(
                wrong.numerator,
                wrong.denominator,
                wrongShape,
                wrongTheme,
                RANDOM.nextInt(100000));

        data.fractions = fractions;
        data.correctIndex = correctIndex;
        data.answer = String.valueOf((char)('A' + correctIndex));

        String[] variants =
                {
                        "Which picture does NOT represent %s?",
                        "Find the picture that is NOT %s.",
                        "Three pictures represent %s. Which one does not?",
                        "Identify the picture that is different.",
                        "Which figure does not show %s?",
                        "Which picture is NOT equal to %s?"
                };

        data.questionText =
                String.format(
                        variants[RANDOM.nextInt(variants.length)],
                        fractionToWords(
                                correctFraction.numerator,
                                correctFraction.denominator));

        data.imageCode = createImageCode(fractions, correctIndex);

        return data;
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

    private static FractionData createEquivalentFraction(FractionData original)
    {
        return createFraction(original.numerator, original.denominator);
    }

    private static FractionData createFraction(int numerator, int denominator)
    {
        return new FractionData(
                numerator,
                denominator,
                randomShape(denominator),
                randomTheme(),
                randomVariation());
    }

    private Question generateOddOneOutFractionQuestion()
    {
        ChoiceFractionData data =
                FractionChoiceGenerator.generateOddOneOutQuestion();

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

    private static FractionData generateWrongFraction(FractionData correct)
    {
        int numerator = correct.numerator;
        int denominator = correct.denominator;

        switch(RANDOM.nextInt(4))
        {
            // Numerator - 1
            case 0:
                if(numerator > 1)
                    numerator--;
                else
                    numerator++;
                break;

            // Numerator + 1
            case 1:
                if(numerator < denominator)
                    numerator++;
                else
                    numerator--;
                break;

            // Denominator - 1
            case 2:
                if(denominator > 2 &&
                        numerator <= denominator-1)
                    denominator--;
                else
                    denominator++;
                break;

            // Denominator + 1
            case 3:
                denominator++;

                if(numerator > denominator)
                    numerator = denominator;
                break;
        }

        FractionImageGenerator.FractionShape shape =
                FractionImageGenerator.FractionShape.values()[
                        RANDOM.nextInt(
                                FractionImageGenerator.FractionShape.values().length)];

        FractionImageGenerator.FractionTheme theme =
                FractionImageGenerator.FractionTheme.values()[
                        RANDOM.nextInt(
                                FractionImageGenerator.FractionTheme.values().length)];

        return new FractionData(numerator,denominator,shape,theme,RANDOM.nextInt(100000));
    }

    /*private static FractionGenerator.FractionShape randomShape()
    {
        FractionGenerator.FractionShape[] shapes = FractionGenerator.FractionShape.values();

        return shapes[RANDOM.nextInt(shapes.length)];
    }*/

    static FractionImageGenerator.FractionShape randomShape(int denominator)
    {
        List<FractionImageGenerator.FractionShape> candidates = new ArrayList<>();

        for (FractionImageGenerator.FractionShape shape :
                FractionImageGenerator.FractionShape.values())
        {
            if (shape.supports(denominator))
            {
                candidates.add(shape);
            }
        }

        return candidates.get(RANDOM.nextInt(candidates.size()));
    }

    static FractionImageGenerator.FractionTheme randomTheme()
    {
        FractionImageGenerator.FractionTheme[] themes = FractionImageGenerator.FractionTheme.values();

        return themes[RANDOM.nextInt(themes.length)];
    }

    private static int randomVariation()
    {
        return RANDOM.nextInt(100000);
    }
}