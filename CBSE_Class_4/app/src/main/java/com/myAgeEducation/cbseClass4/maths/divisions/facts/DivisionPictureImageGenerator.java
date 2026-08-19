package com.myAgeEducation.cbseClass4.maths.divisions.facts;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.myAgeEducation.cbseClass4.maths.utils.ImageCodeParser;

import java.util.Map;

public class DivisionPictureImageGenerator
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;

    private static final int TEXT_SIZE = 88;

    public static Bitmap generate(String imageCode)
    {
        Map<String, String> values =
                ImageCodeParser.parse(imageCode);

        String dividend =
                values.get("DIVIDEND");

        String divisor =
                values.get("DIVISOR");

        String quotient =
                values.get("QUOTIENT");

        String product =
                values.get("PRODUCT");

        String remainder =
                values.get("REMAINDER");

        String hide =
                values.get("HIDE");

        if ("DIVIDEND".equals(hide))
        {
            dividend = "____";
        }

        if ("DIVISOR".equals(hide))
        {
            divisor = "____";
        }

        if ("QUOTIENT".equals(hide))
        {
            quotient = "____";
        }

        if ("PRODUCT".equals(hide))
        {
            product = "____";
        }

        if ("REMAINDER".equals(hide))
        {
            remainder = "____";
        }

        Bitmap bitmap =
                Bitmap.createBitmap(
                        WIDTH,
                        HEIGHT,
                        Bitmap.Config.ARGB_8888);

        Canvas canvas =
                new Canvas(bitmap);

        canvas.drawColor(Color.WHITE);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextSize(TEXT_SIZE);

        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        linePaint.setColor(Color.BLACK);
        linePaint.setStrokeWidth(8f);
        linePaint.setStyle(Paint.Style.STROKE);

        Paint.FontMetrics fm = paint.getFontMetrics();

        float marginLeft = 80;

        float divisorWidth =
                paint.measureText(divisor);

        float dividendWidth =
                paint.measureText(dividend);

        float quotientWidth =
                paint.measureText(quotient);

        float productWidth =
                paint.measureText(product);

        float remainderWidth =
                paint.measureText(remainder);

//----------------------------
// Calculate positions
//----------------------------

        float barX =
                marginLeft + divisorWidth + 25;

        float dividendX =
                barX + 20;

        float quotientX =
                dividendX + (dividendWidth - quotientWidth) / 2f;

        float productX =
                dividendX + (dividendWidth - productWidth);

        float remainderX =
                dividendX + (dividendWidth - remainderWidth);

        float lineRight =
                dividendX + Math.max(dividendWidth, productWidth);

        float quotientY = 120;

        float dividendY = 240;

        float productY = 350;

        float remainderY = 460;

        //----------------------------
// Divisor
//----------------------------

        canvas.drawText(
                divisor,
                marginLeft,
                dividendY,
                paint);

//----------------------------
// Quotient
//----------------------------

        canvas.drawText(
                quotient,
                quotientX,
                quotientY,
                paint);

//----------------------------
// Top horizontal line
//----------------------------

        canvas.drawLine(
                barX,
                60,
                barX,
                remainderY + 20,
                linePaint);

//----------------------------
// Vertical division line
//----------------------------

        canvas.drawLine(
                barX,
                quotientY + 20,
                lineRight,
                quotientY + 20,
                linePaint);

//----------------------------
// Divisor
//----------------------------

        canvas.drawLine(
                productX,
                productY + 16,
                lineRight,
                productY + 16,
                linePaint);

//----------------------------
// Dividend
//----------------------------

        canvas.drawText(
                dividend,
                dividendX,
                dividendY,
                paint);

//----------------------------
// Product
//----------------------------

        canvas.drawText(
                product,
                productX,
                productY,
                paint);

//----------------------------
// Subtraction line
//----------------------------

        canvas.drawLine(
                productX,
                productY + 8,
                lineRight,
                productY + 8,
                linePaint);

//----------------------------
// Remainder
//----------------------------

        canvas.drawText(
                remainder,
                remainderX,
                remainderY,
                paint);

        return bitmap;
    }
}
