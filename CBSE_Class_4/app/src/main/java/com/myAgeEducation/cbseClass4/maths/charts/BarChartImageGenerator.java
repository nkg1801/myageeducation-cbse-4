package com.myAgeEducation.cbseClass4.maths.charts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class BarChartImageGenerator
{
    public static Bitmap generate(
            String imageCode)
    {
        String[] parts =
                imageCode.split("_");

        // Example:
        // BARCHART_IPL_CSK_KKR_RR_SRH_200_350_100_250

        if (parts.length != 10
                || !parts[0].equals("BARCHART"))
        {
            throw new IllegalArgumentException(
                    "Invalid bar chart image code: "
                            + imageCode);
        }

        String scenarioCode =
                parts[1];

        String[] displayLabels =
                {
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5]
                };

        int[] values =
                {
                        Integer.parseInt(parts[6]),
                        Integer.parseInt(parts[7]),
                        Integer.parseInt(parts[8]),
                        Integer.parseInt(parts[9])
                };

        return generate(
                displayLabels,
                values);
    }


    private static Bitmap generate(
            String[] displayLabels,
            int[] values)
    {
        int width = 1000;
        int height = 700;

        Bitmap bitmap =
                Bitmap.createBitmap(
                        width,
                        height,
                        Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);

        Paint paint =
                new Paint(Paint.ANTI_ALIAS_FLAG);

        // ---------------------------------
        // CHART LAYOUT
        // ---------------------------------

        float left = 120;
        float top = 80;
        float right = 950;
        float bottom = 570;

        float chartHeight =
                bottom - top;

        // ---------------------------------
        // FIND MAXIMUM VALUE
        // ---------------------------------

        int maxValue = 0;

        for (int value : values)
        {
            maxValue =
                    Math.max(maxValue, value);
        }

        // Add some space above tallest bar
        int axisMaximum =
                getAxisMaximum(maxValue);

        int step = 50;

        // ---------------------------------
        // DRAW HORIZONTAL GRID LINES
        // ---------------------------------

        for (int value = 0;
             value <= axisMaximum;
             value += step)
        {
            float y =
                    bottom
                            - ((float) value
                            / axisMaximum)
                            * chartHeight;

            // Grid line
            paint.setColor(Color.LTGRAY);
            paint.setStrokeWidth(2);
            paint.setStyle(Paint.Style.STROKE);

            canvas.drawLine(
                    left,
                    y,
                    right,
                    y,
                    paint);

            // Y-axis value
            paint.setColor(Color.DKGRAY);
            paint.setTextSize(32);
            paint.setTextAlign(Paint.Align.RIGHT);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawText(
                    String.valueOf(value),
                    left - 18,
                    y + 9,
                    paint);
        }

        // ---------------------------------
        // DRAW AXES
        // ---------------------------------

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawLine(
                left,
                top,
                left,
                bottom,
                paint);

        canvas.drawLine(
                left,
                bottom,
                right,
                bottom,
                paint);

        // ---------------------------------
        // BAR COLOURS
        // ---------------------------------

        int[] barColors =
                {
                        Color.rgb(66, 133, 244),
                        Color.rgb(234, 67, 53),
                        Color.rgb(251, 188, 5),
                        Color.rgb(52, 168, 83),
                        Color.rgb(156, 39, 176),
                        Color.rgb(255, 112, 67)
                };

        // Randomize the starting colour
        int colorOffset =
                new Random().nextInt(
                        barColors.length);

        // ---------------------------------
        // DRAW BARS
        // ---------------------------------

        float chartWidth =
                right - left;

        float categoryWidth =
                chartWidth
                        / displayLabels.length;

        float barWidth =
                categoryWidth * 0.55f;

        for (int i = 0;
             i < displayLabels.length;
             i++)
        {
            float centerX =
                    left
                            + categoryWidth * i
                            + categoryWidth / 2;

            float barLeft =
                    centerX - barWidth / 2;

            float barRight =
                    centerX + barWidth / 2;

            float barTop =
                    bottom
                            - ((float) values[i]
                            / axisMaximum)
                            * chartHeight;

            // BAR

            paint.setColor(
                    barColors[
                            (i + colorOffset)
                                    % barColors.length]);

            paint.setStyle(Paint.Style.FILL);

            canvas.drawRect(
                    barLeft,
                    barTop,
                    barRight,
                    bottom,
                    paint);

            paint.setColor(Color.BLACK);
            paint.setTextSize(34);
            paint.setTextAlign(
                    Paint.Align.CENTER);

            canvas.drawText(
                    displayLabels[i],
                    centerX,
                    bottom + 45,
                    paint);
        }

        return bitmap;
    }

    private static int getAxisMaximum(int maxValue)
    {
        return ((maxValue + 49) / 50) * 50 + 50;
    }

    private static int roundUpToNiceNumber(int maxValue)
    {
        return ((maxValue + 49) / 50) * 50;
    }
}