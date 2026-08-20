package com.myAgeEducation.cbseClass4.maths.fractions;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.Random;

public class NumericFractionImageGenerator
{
    public static Bitmap generate(String imageCode)
    {
        String[] parts = imageCode.split("_");
        int numerator = Integer.parseInt(parts[1]);
        int denominator = Integer.parseInt(parts[2]);

        int width = 400;
        int height = 500;

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        // Transparent background
        canvas.drawColor(Color.TRANSPARENT);
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int fractionColor = FRACTION_COLORS[RANDOM.nextInt(FRACTION_COLORS.length)];
        textPaint.setColor(fractionColor);

        //textPaint.setColor(Color.rgb(120, 50, 180));
        textPaint.setTextSize(180);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        linePaint.setColor(fractionColor);
        linePaint.setStrokeWidth(14);
        linePaint.setStrokeCap(Paint.Cap.ROUND);

        float centerX = width / 2f;

        // Numerator
        canvas.drawText(String.valueOf(numerator), centerX, 190, textPaint);

        // Fraction line
        canvas.drawLine(
                80,
                245,
                width - 80,
                245,
                linePaint);

        // Denominator
        canvas.drawText(
                String.valueOf(denominator),
                centerX,
                440,
                textPaint);

        return bitmap;
    }

    private static final Random RANDOM = new Random();

    private static final int[] FRACTION_COLORS =
            {
                    Color.rgb(120, 50, 180),   // Purple
                    Color.rgb(30, 100, 200),   // Blue
                    Color.rgb(20, 140, 90),    // Green
                    Color.rgb(210, 80, 40),    // Orange
                    Color.rgb(190, 50, 90)     // Pink
            };
}