package com.myAgeEducation.cbseClass4.maths.decimals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class DecimalGridImageGenerator {
    public static Bitmap generate(String imageCode) {
        // format: DECIMAL-GRID_WHOLE_NUMERATOR_DENOMINATOR_COLOR
        String[] parts = imageCode.split("_");
        int whole = Integer.parseInt(parts[1]);
        int numerator = Integer.parseInt(parts[2]);
        int denominator = Integer.parseInt(parts[3]);
        int color = Color.parseColor(parts[4]);

        int totalSquares = whole + 1;
        int squareSize = 350;
        int padding = 30;

        int width;
        int height;

        if (totalSquares == 3) {
            // 2 in top row, 1 in bottom row
            width = 2 * squareSize + 3 * padding;
            height = 2 * squareSize + 3 * padding;
        } else {
            // Single row layout for 1 or 2 squares
            width = totalSquares * squareSize + (totalSquares + 1) * padding;
            height = squareSize + 2 * padding;
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);

        Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setColor(color);
        fillPaint.setStyle(Paint.Style.FILL);

        Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(2);

        for (int i = 0; i < totalSquares; i++) {
            float left;
            float top;

            if (totalSquares == 3) {
                if (i < 2) {
                    // Top row
                    left = padding + i * (squareSize + padding);
                    top = padding;
                } else {
                    // Bottom row, left aligned
                    left = padding;
                    top = padding + (squareSize + padding);
                }
            } else {
                left = padding + i * (squareSize + padding);
                top = padding;
            }

            RectF rect = new RectF(left, top, left + squareSize, top + squareSize);

            if (i < whole) {
                // Fully shaded
                canvas.drawRect(rect, fillPaint);
                canvas.drawRect(rect, borderPaint);
            } else {
                // Partially shaded
                drawPartialGrid(canvas, rect, numerator, denominator, fillPaint, borderPaint);
            }
        }

        return bitmap;
    }

    private static void drawPartialGrid(Canvas canvas, RectF rect, int numerator, int denominator, Paint fillPaint, Paint borderPaint) {
        if (denominator == 10) {
            float stripWidth = rect.width() / 10f;
            for (int i = 0; i < 10; i++) {
                RectF strip = new RectF(rect.left + i * stripWidth, rect.top, rect.left + (i + 1) * stripWidth, rect.bottom);
                if (i < numerator) {
                    canvas.drawRect(strip, fillPaint);
                }
                canvas.drawRect(strip, borderPaint);
            }
        } else if (denominator == 100) {
            float cellSize = rect.width() / 10f;
            for (int c = 0; c < 10; c++) {
                for (int r = 0; r < 10; r++) {
                    int index = c * 10 + r;
                    RectF cell = new RectF(rect.left + c * cellSize, rect.top + r * cellSize, rect.left + (c + 1) * cellSize, rect.top + (r + 1) * cellSize);
                    if (index < numerator) {
                        canvas.drawRect(cell, fillPaint);
                    }
                    canvas.drawRect(cell, borderPaint);
                }
            }
        }
        canvas.drawRect(rect, borderPaint);
    }
}
