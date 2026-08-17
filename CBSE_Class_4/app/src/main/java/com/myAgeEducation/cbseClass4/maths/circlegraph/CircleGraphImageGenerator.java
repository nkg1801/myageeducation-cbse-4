package com.myAgeEducation.cbseClass4.maths.circlegraph;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class CircleGraphImageGenerator
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;

    private static final float CENTER_X = 350;
    private static final float CENTER_Y = 400;
    private static final float RADIUS = 280;

    private static final float LEGEND_X = 680;
    private static final float LEGEND_START_Y = 250;

    private static final float LEGEND_BOX_SIZE = 35;
    private static final float LEGEND_TEXT_GAP = 15;
    private static final float LEGEND_ROW_GAP = 25;

    public static Bitmap generate(String imageCode)
    {
        String[] parts =
                imageCode.split("_");

        if (parts.length < 7
                || !parts[0].equals("CIRCLEGRAPH"))
        {
            throw new IllegalArgumentException(
                    "Invalid circle graph image code: "
                            + imageCode);
        }

        int dataCount =
                (parts.length - 1) / 2;

        if (dataCount < 3
                || dataCount > 4
                || parts.length !=
                1 + dataCount + dataCount)
        {
            throw new IllegalArgumentException(
                    "Invalid circle graph data: "
                            + imageCode);
        }

        String[] labels =
                new String[dataCount];

        int[] values =
                new int[dataCount];

        /*
         * Read labels
         */
        for (int i = 0;
             i < dataCount;
             i++)
        {
            labels[i] =
                    parts[i + 1];
        }

        /*
         * Read values
         */
        for (int i = 0;
             i < dataCount;
             i++)
        {
            values[i] =
                    Integer.parseInt(
                            parts[
                                    1
                                            + dataCount
                                            + i]);
        }

        /*
         * Calculate total
         */
        int total = 0;

        for (int value : values)
        {
            total += value;
        }

        /*
         * Recreate CircleGraphData
         */
        String[] fractionNames =
                new String[dataCount];

        for (int i = 0;
             i < dataCount;
             i++)
        {
            fractionNames[i] =
                    getFractionName(
                            values[i],
                            total);
        }

        CircleGraphData data =
                new CircleGraphData(
                        labels,
                        values,
                        fractionNames,
                        total);

        return generate(data);
    }

    private static String getFractionName(
            int numerator,
            int denominator)
    {
        int gcd =
                gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        if (numerator == 1
                && denominator == 2)
        {
            return "half";
        }

        if (numerator == 1
                && denominator == 4)
        {
            return "one-fourth";
        }

        if (numerator == 3
                && denominator == 4)
        {
            return "three-fourths";
        }

        if (numerator == 1
                && denominator == 8)
        {
            return "one-eighth";
        }

        if (numerator == 3
                && denominator == 8)
        {
            return "three-eighths";
        }

        if (numerator == 5
                && denominator == 8)
        {
            return "five-eighths";
        }

        if (numerator == 7
                && denominator == 8)
        {
            return "seven-eighths";
        }

        return numerator + "/" + denominator;
    }

    private static int gcd(
            int a,
            int b)
    {
        while (b != 0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static Bitmap generate(
            CircleGraphData data)
    {
        Bitmap bitmap =
                Bitmap.createBitmap(
                        WIDTH,
                        HEIGHT,
                        Bitmap.Config.ARGB_8888);

        Canvas canvas =
                new Canvas(bitmap);

        canvas.drawColor(Color.WHITE);

        Paint fillPaint =
                new Paint(Paint.ANTI_ALIAS_FLAG);

        fillPaint.setStyle(
                Paint.Style.FILL);

        Paint borderPaint =
                new Paint(Paint.ANTI_ALIAS_FLAG);

        borderPaint.setStyle(
                Paint.Style.STROKE);

        borderPaint.setStrokeWidth(4);
        borderPaint.setColor(Color.BLACK);

        RectF oval =
                new RectF(
                        CENTER_X - RADIUS,
                        CENTER_Y - RADIUS,
                        CENTER_X + RADIUS,
                        CENTER_Y + RADIUS);

        float startAngle = -90;

        /*
         * Draw pie chart
         */
        for (int i = 0;
             i < data.values.length;
             i++)
        {
            float sweepAngle =
                    360f *
                            data.values[i] /
                            data.total;

            fillPaint.setColor(
                    getColor(i));

            canvas.drawArc(
                    oval,
                    startAngle,
                    sweepAngle,
                    true,
                    fillPaint);

            canvas.drawArc(
                    oval,
                    startAngle,
                    sweepAngle,
                    true,
                    borderPaint);

            startAngle += sweepAngle;
        }

        /*
         * Draw legend
         */
        drawLegend(
                canvas,
                data);

        return bitmap;
    }

    private static void drawLegend(
            Canvas canvas,
            CircleGraphData data)
    {
        Paint boxPaint =
                new Paint(Paint.ANTI_ALIAS_FLAG);

        boxPaint.setStyle(
                Paint.Style.FILL);

        Paint textPaint =
                new Paint(Paint.ANTI_ALIAS_FLAG);

        textPaint.setColor(
                Color.BLACK);

        textPaint.setTextSize(30);

        textPaint.setTypeface(
                android.graphics.Typeface.DEFAULT);

        float y =
                LEGEND_START_Y;

        for (int i = 0;
             i < data.labels.length;
             i++)
        {
            /*
             * Color box
             */
            boxPaint.setColor(
                    getColor(i));

            canvas.drawRect(
                    LEGEND_X,
                    y,
                    LEGEND_X + LEGEND_BOX_SIZE,
                    y + LEGEND_BOX_SIZE,
                    boxPaint);

            /*
             * Black border around box
             */
            Paint boxBorder =
                    new Paint(Paint.ANTI_ALIAS_FLAG);

            boxBorder.setStyle(
                    Paint.Style.STROKE);

            boxBorder.setStrokeWidth(2);
            boxBorder.setColor(Color.BLACK);

            canvas.drawRect(
                    LEGEND_X,
                    y,
                    LEGEND_X + LEGEND_BOX_SIZE,
                    y + LEGEND_BOX_SIZE,
                    boxBorder);

            /*
             * Label
             */
            canvas.drawText(
                    data.labels[i],
                    LEGEND_X
                            + LEGEND_BOX_SIZE
                            + LEGEND_TEXT_GAP,
                    y + 28,
                    textPaint);

            y +=
                    LEGEND_BOX_SIZE
                            + LEGEND_ROW_GAP;
        }
    }

    private static int getColor(
            int index)
    {
        switch (index % 6)
        {
            case 0:
                return Color.rgb(
                        255, 204, 102);

            case 1:
                return Color.rgb(
                        102, 178, 255);

            case 2:
                return Color.rgb(
                        153, 204, 153);

            case 3:
                return Color.rgb(
                        255, 153, 153);

            case 4:
                return Color.rgb(
                        204, 153, 255);

            default:
                return Color.rgb(
                        255, 204, 153);
        }
    }
}