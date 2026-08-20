package com.myAgeEducation.cbseClass4.maths.decimals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.Random;

public class DecimalImageGenerator
{
    private static final Random RANDOM = new Random();

    private static final int[] FRACTION_COLORS =
            {
                    Color.rgb(220, 20, 60),    // Crimson Red
                    Color.rgb(120, 50, 180),   // Purple
                    Color.rgb(30, 100, 200),   // Blue
                    Color.rgb(20, 140, 90),    // Green
            };

    /**
     * Generates a bitmap showing a fraction or a mixed number.
     * imageCode format: DECIMAL-IMAGE_WHOLE_NUMERATOR_DENOMINATOR
     */
    public static Bitmap generate(String imageCode)
    {
        String[] parts = imageCode.split("_");
        // DECIMAL-IMAGE_0_17_100
        int whole = Integer.parseInt(parts[1]);
        int numerator = Integer.parseInt(parts[2]);
        int denominator = Integer.parseInt(parts[3]);

        int width = 600;
        int height = 600;

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);

        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        int color = FRACTION_COLORS[RANDOM.nextInt(FRACTION_COLORS.length)];
        textPaint.setColor(color);
        textPaint.setTextSize(200);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(color);
        linePaint.setStrokeWidth(16);
        linePaint.setStrokeCap(Paint.Cap.ROUND);

        float centerX = width / 2f;
        float centerY = height / 2f;

        if (whole > 0)
        {
            // Mixed fraction: Whole number on the left
            String wholeStr = String.valueOf(whole);
            float wholeWidth = textPaint.measureText(wholeStr);
            
            // Adjust center for the fraction part
            float fractionCenterX = centerX + (wholeWidth / 2f) + 40;
            float wholeX = centerX - (width * 0.15f); // Rough adjustment

            // Draw Whole Number
            canvas.drawText(wholeStr, wholeX, centerY + 70, textPaint);

            // Draw Numerator
            textPaint.setTextSize(140);
            canvas.drawText(String.valueOf(numerator), fractionCenterX, centerY - 40, textPaint);

            // Draw Line
            float lineLen = Math.max(textPaint.measureText(String.valueOf(numerator)), textPaint.measureText(String.valueOf(denominator))) + 40;
            canvas.drawLine(fractionCenterX - lineLen/2, centerY + 10, fractionCenterX + lineLen/2, centerY + 10, linePaint);

            // Draw Denominator
            canvas.drawText(String.valueOf(denominator), fractionCenterX, centerY + 160, textPaint);
        }
        else
        {
            // Simple fraction
            textPaint.setTextSize(220);
            canvas.drawText(String.valueOf(numerator), centerX, centerY - 50, textPaint);
            
            float lineLen = Math.max(textPaint.measureText(String.valueOf(numerator)), textPaint.measureText(String.valueOf(denominator))) + 60;
            canvas.drawLine(centerX - lineLen/2, centerY + 20, centerX + lineLen/2, centerY + 20, linePaint);
            
            canvas.drawText(String.valueOf(denominator), centerX, centerY + 240, textPaint);
        }

        return bitmap;
    }
}
