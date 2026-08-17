package com.myAgeEducation.cbseClass4.maths.charts.tabularquestions;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class TableImageGenerator
{
    public static Bitmap generate(String imageCode)
    {
        String[] parts = imageCode.split("_");

        // TABLE_ROADNETWORK_10500_28000_19500_24000
        if (parts.length != 10 || !parts[0].equals("TABLE"))
        {
            throw new IllegalArgumentException("Invalid table image code: " + imageCode);
        }

        String scenarioCode = parts[1];

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

        TableDisplayData displayData = getDisplayData(scenarioCode, displayLabels);
        return generate(displayData, values);
    }


    private static Bitmap generate(
            TableDisplayData data,
            int[] values)
    {
        int width = 1000;
        int height = 650;

        Bitmap bitmap =
                Bitmap.createBitmap(
                        width,
                        height,
                        Bitmap.Config.ARGB_8888);

        Canvas canvas =
                new Canvas(bitmap);

        canvas.drawColor(Color.WHITE);

        Paint paint =
                new Paint(Paint.ANTI_ALIAS_FLAG);

        // TABLE DIMENSIONS

        float left = 100;
        float top = 70;
        float right = 900;

        float rowHeight = 95;

        int rowCount =
                data.labels.length + 1; // + header

        float bottom =
                top + rowCount * rowHeight;

        float firstColumnWidth = 400;

        float columnDivider =
                left + firstColumnWidth;


        // HEADER BACKGROUND

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(
                Color.rgb(230, 230, 230));

        canvas.drawRect(
                left,
                top,
                right,
                top + rowHeight,
                paint);


        // TABLE BORDER AND GRID

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);

        canvas.drawRect(
                new RectF(
                        left,
                        top,
                        right,
                        bottom),
                paint);

        // Vertical divider

        canvas.drawLine(
                columnDivider,
                top,
                columnDivider,
                bottom,
                paint);

        // Horizontal lines

        for (int i = 1;
             i < rowCount;
             i++)
        {
            float y =
                    top + i * rowHeight;

            canvas.drawLine(
                    left,
                    y,
                    right,
                    y,
                    paint);
        }


        // HEADER TEXT

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setTextSize(38);
        paint.setFakeBoldText(true);
        paint.setTextAlign(Paint.Align.CENTER);

        float headerY =
                top
                        + rowHeight / 2
                        - (paint.ascent()
                        + paint.descent()) / 2;

        canvas.drawText(
                data.firstColumnTitle,
                left + firstColumnWidth / 2,
                headerY,
                paint);

        canvas.drawText(
                data.secondColumnTitle,
                columnDivider
                        + (right - columnDivider) / 2,
                headerY,
                paint);


        // DATA ROWS

        paint.setFakeBoldText(false);
        paint.setTextSize(36);

        for (int i = 0;
             i < data.labels.length;
             i++)
        {
            float rowTop =
                    top + (i + 1) * rowHeight;

            float centerY =
                    rowTop
                            + rowHeight / 2
                            - (paint.ascent()
                            + paint.descent()) / 2;

            // First column

            canvas.drawText(
                    data.labels[i],
                    left + firstColumnWidth / 2,
                    centerY,
                    paint);

            // Second column

            String valueText =
                    formatNumber(values[i]);

            if (data.unit != null
                    && !data.unit.trim().isEmpty())
            {
                valueText +=
                        " " + data.unit;
            }

            canvas.drawText(
                    valueText,
                    columnDivider
                            + (right - columnDivider) / 2,
                    centerY,
                    paint);
        }

        return bitmap;
    }


    private static String formatNumber(int value)
    {
        return String.format(
                java.util.Locale.US,
                "%,d",
                value);
    }


    private static TableDisplayData getDisplayData(String scenarioCode, String[] displayLabels)
    {
        switch (scenarioCode)
        {
            case "ROADNETWORK":
                return new TableDisplayData(
                        "City",
                        "Road Network",
                        displayLabels,
                        "km"
                );


            case "AIRPORTS":
                return new TableDisplayData(
                        "Country",
                        "Number of Airports",
                        displayLabels,
                        ""
                );

            case "LIBRARIES":
                return new TableDisplayData(
                        "City",
                        "Number of Libraries",
                        displayLabels,
                        ""
                );

            default:
                throw new IllegalArgumentException(
                        "Unknown table scenario: "
                                + scenarioCode);
        }
    }


    private static class TableDisplayData
    {
        final String firstColumnTitle;
        final String secondColumnTitle;
        final String[] labels;
        final String unit;

        TableDisplayData(
                String firstColumnTitle,
                String secondColumnTitle,
                String[] labels,
                String unit)
        {
            this.firstColumnTitle =
                    firstColumnTitle;

            this.secondColumnTitle =
                    secondColumnTitle;

            this.labels =
                    labels;

            this.unit =
                    unit;
        }
    }
}