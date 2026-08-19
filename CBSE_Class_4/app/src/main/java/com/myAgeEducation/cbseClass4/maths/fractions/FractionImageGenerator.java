package com.myAgeEducation.cbseClass4.maths.fractions;

import static com.myAgeEducation.cbseClass4.maths.fractions.FractionChoiceGenerator.randomTheme;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FractionImageGenerator {

    private static final Random RANDOM = new Random();

    /*public enum FractionShape {
        CIRCLE,
        SQUARE,
        RECTANGLE,
        HORIZONTALBAR,
        VERTICALBAR,
        SQUAREGRID,
        CHOCOLATEBAR,
        FRACTIONBAR,
        PIZZA,
        DONUT,
        FLOWER,
        HEXAGON,
        PENTAGON,
        EQUILATERALTRIANGLE
    }*/

    public enum FractionShape
    {
        CIRCLE(2,3,4,5,6,8),
        SQUARE(2,4),
        RECTANGLE(2,4,6,8),

        HORIZONTALBAR(2,3,4,5,6,8),
        VERTICALBAR(2,3,4,5,6,8),

        SQUAREGRID(2,3,4,5,6,8),
        CHOCOLATEBAR(2,3,4,5,6,8),
        FRACTIONBAR(2,3,4,5,6,8),

        PIZZA(2,3,4,5,6,8),
        DONUT(2,3,4,5,6,8),
        FLOWER(4,5,6,8),

        PENTAGON(5),
        HEXAGON(2,3,6),
        EQUILATERALTRIANGLE(2,3,4,6);

        private final int[] supportedDenominators;

        FractionShape(int... supportedDenominators)
        {
            this.supportedDenominators = supportedDenominators;
        }

        public boolean supports(int denominator)
        {
            for (int d : supportedDenominators)
            {
                if (d == denominator)
                    return true;
            }

            return false;
        }
    }

    public enum FractionTheme {

        GREEN(
                Color.rgb(34, 139, 34),
                Color.WHITE,
                Color.rgb(90,90,90)),

        BLUE(
                Color.rgb(33,150,243),
                Color.WHITE,
                Color.DKGRAY),

        ORANGE(
                Color.rgb(255,140,0),
                Color.WHITE,
                Color.DKGRAY),

        PURPLE(
                Color.rgb(123,31,162),
                Color.WHITE,
                Color.DKGRAY),

        RED(
                Color.rgb(220,20,60),
                Color.WHITE,
                Color.DKGRAY);

        public final int fillColor;
        public final int emptyColor;
        public final int borderColor;

        FractionTheme(int fill,
                      int empty,
                      int border) {

            fillColor = fill;
            emptyColor = empty;
            borderColor = border;
        }
    }

    public static FractionData randomFraction()
    {
        int[] denominators = {2,3,4,5,6,8};
        int denominator = denominators[RANDOM.nextInt(denominators.length)];
        //int denominator = denominators[1]; //todo: only for testing, to simulate a particular testing

        int numerator = RANDOM.nextInt(denominator - 1) + 1;
        FractionShape shape = randomShape(denominator);
        FractionTheme theme = FractionTheme.values()[RANDOM.nextInt(FractionTheme.values().length)];
        int variation = RANDOM.nextInt(100000);
        return new FractionData(numerator, denominator, shape, theme, variation);
    }

    private static FractionShape randomShape(int denominator)
    {
        List<FractionShape> candidates = new ArrayList<>();

        for (FractionShape shape : FractionShape.values())
        {
            if (shape.supports(denominator))
            {
                candidates.add(shape);
            }
        }

        return candidates.get(
                RANDOM.nextInt(candidates.size()));
    }

    public static Bitmap generateFraction(int width, int height, FractionShape shape, int denominator, int coloured, int variation,FractionTheme theme) {
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setColor(theme.fillColor);
        fillPaint.setStyle(Paint.Style.FILL);
        Paint emptyPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        emptyPaint.setColor(theme.emptyColor);
        emptyPaint.setStyle( Paint.Style.FILL);
        Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setColor(theme.borderColor);
        borderPaint.setStrokeWidth(8);
        borderPaint.setStyle(Paint.Style.STROKE);
        float padding = width*0.08f;
        RectF bounds = new RectF(padding,padding,width-padding,height-padding);

        switch(shape) {

            case SQUARE:
                drawSquare(canvas,bounds,denominator,coloured,fillPaint,emptyPaint,borderPaint);
                break;

            case RECTANGLE:
                drawRectangle(canvas,bounds,denominator,coloured,fillPaint,emptyPaint,borderPaint);
                break;

            case HORIZONTALBAR:
                drawHorizontalBar(canvas,bounds,denominator,coloured,fillPaint,emptyPaint,borderPaint);
                break;

            case VERTICALBAR:
                drawVerticalBar(canvas,bounds,denominator,coloured,fillPaint,emptyPaint,borderPaint);
                break;

            case SQUAREGRID:
                drawSquareGrid(canvas,bounds,denominator,coloured,variation,fillPaint,emptyPaint,borderPaint);
                break;

            case CHOCOLATEBAR:
                drawChocolateBar(canvas,bounds,denominator,coloured,variation,fillPaint,emptyPaint,borderPaint);
                break;

            case FRACTIONBAR:
                drawFractionBar(canvas,bounds,denominator,coloured,fillPaint,emptyPaint,borderPaint);
                break;

            case PIZZA:
                drawPizza(canvas,bounds,denominator,coloured,variation,fillPaint,emptyPaint,borderPaint);
                break;

            case DONUT:
                drawDonut(canvas, bounds, denominator, coloured, variation, fillPaint, emptyPaint, borderPaint);
                break;

            case FLOWER:
                drawFlower(canvas, bounds, denominator, coloured, variation, fillPaint, emptyPaint, borderPaint);
                break;

            case PENTAGON:
                 drawPentagon(canvas, bounds, denominator, coloured, variation, fillPaint, emptyPaint, borderPaint);
                 break;

            case HEXAGON:
                drawHexagon(canvas, bounds, denominator, coloured, variation, fillPaint, emptyPaint, borderPaint);
                break;

            case EQUILATERALTRIANGLE:
                drawEquilateralTriangle(canvas, bounds, denominator, coloured, variation, fillPaint, emptyPaint, borderPaint);
                break;

            default:
                //This covers CIRCLE and DEFAULT
                drawCircle(canvas,bounds,denominator,coloured,fillPaint,emptyPaint,borderPaint);
        }
        return bitmap;
    }

    public static Bitmap generateFraction(int width,int height,FractionData fraction)
    {
        return generateFraction(width, height, fraction.shape, fraction.denominator, fraction.numerator, fraction.variation, fraction.theme);
    }

    public static Bitmap generateFractionImage(String imageCode)
    {
        String[] parts = imageCode.split("_");
        int denominator = Integer.parseInt(parts[1]);
        int numerator = Integer.parseInt(parts[2]);
        FractionShape fractionShape = FractionShape.valueOf(parts[3]);
        FractionTheme fractionTheme = FractionTheme.valueOf(parts[4]);
        int variation = Integer.parseInt(parts[5]);
        FractionData fraction = new FractionData(numerator, denominator, fractionShape, fractionTheme, variation);
        return generateFraction(600,600,fraction);
    }

    //-------------------------------------------------------
    // Drawing methods
    // (implemented in Part-2)
    //-------------------------------------------------------

    private static void drawCircle(Canvas canvas,RectF bounds,int denominator,int coloured,Paint fillPaint,Paint emptyPaint,Paint borderPaint) {

        float sweep = 360f / denominator;

        // Draw coloured and uncoloured sectors
        for (int i = 0; i < denominator; i++) {

            Paint p = (i < coloured) ? fillPaint : emptyPaint;

            canvas.drawArc(bounds,-90 + i * sweep,sweep,true,p);
        }

        // Draw divider lines
        float cx = bounds.centerX();
        float cy = bounds.centerY();

        float radius = bounds.width() / 2f;

        for (int i = 0; i < denominator; i++) {
            double angle = Math.toRadians(-90 + i * sweep);
            float x = (float) (cx + radius * Math.cos(angle));
            float y = (float) (cy + radius * Math.sin(angle));
            canvas.drawLine(cx, cy, x, y, borderPaint);
        }

        // Draw outer circle
        canvas.drawOval(bounds, borderPaint);
    }

    private static void drawSquare(Canvas canvas,RectF bounds,int denominator,int coloured,Paint fillPaint,Paint emptyPaint,Paint borderPaint) {

        float size = Math.min(bounds.width(), bounds.height());

        float left = bounds.centerX() - size / 2;
        float top = bounds.centerY() - size / 2;

        float partWidth = size / denominator;

        for (int i = 0; i < denominator; i++) {

            Paint p = (i < coloured) ? fillPaint : emptyPaint;

            RectF rect = new RectF(
                    left + i * partWidth,
                    top,
                    left + (i + 1) * partWidth,
                    top + size);

            canvas.drawRect(rect, p);
            canvas.drawRect(rect, borderPaint);
        }

        canvas.drawRect(
                left,
                top,
                left + size,
                top + size,
                borderPaint);
    }

    private static void drawRectangle(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint) {

        float partWidth = bounds.width() / denominator;

        for (int i = 0; i < denominator; i++) {

            Paint p = (i < coloured) ? fillPaint : emptyPaint;

            RectF rect = new RectF(
                    bounds.left + i * partWidth,
                    bounds.top,
                    bounds.left + (i + 1) * partWidth,
                    bounds.bottom);

            canvas.drawRect(rect, p);
            canvas.drawRect(rect, borderPaint);
        }

        canvas.drawRect(bounds, borderPaint);
    }

    private static void drawHorizontalBar(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint) {

        float partHeight = bounds.height() / denominator;

        for (int i = 0; i < denominator; i++) {

            Paint p = (i < coloured) ? fillPaint : emptyPaint;

            RectF rect = new RectF(
                    bounds.left,
                    bounds.top + i * partHeight,
                    bounds.right,
                    bounds.top + (i + 1) * partHeight);

            canvas.drawRect(rect, p);
            canvas.drawRect(rect, borderPaint);
        }

        canvas.drawRect(bounds, borderPaint);
    }

    private static void drawVerticalBar(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint) {

        float partWidth = bounds.width() / denominator;

        for (int i = 0; i < denominator; i++) {

            Paint p = (i < coloured) ? fillPaint : emptyPaint;

            RectF rect = new RectF(
                    bounds.left + i * partWidth,
                    bounds.top,
                    bounds.left + (i + 1) * partWidth,
                    bounds.bottom);

            canvas.drawRect(rect, p);
            canvas.drawRect(rect, borderPaint);
        }

        canvas.drawRect(bounds, borderPaint);
    }

    private static void drawSquareGrid(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        int rows;
        int cols;

        switch (denominator)
        {
            case 4:
                rows = 2;
                cols = 2;
                break;

            case 6:
                rows = 2;
                cols = 3;
                break;

            case 8:
                rows = 2;
                cols = 4;
                break;

            case 9:
                rows = 3;
                cols = 3;
                break;

            case 10:
                rows = 2;
                cols = 5;
                break;

            case 12:
                rows = 3;
                cols = 4;
                break;

            default:
                rows = 1;
                cols = denominator;
        }

        drawGrid(
                canvas,
                bounds,
                rows,
                cols,
                coloured,
                variation,
                fillPaint,
                emptyPaint,
                borderPaint);
    }

    private static void drawGrid(
            Canvas canvas,
            RectF bounds,
            int rows,
            int cols,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        float cellWidth = bounds.width() / cols;
        float cellHeight = bounds.height() / rows;

        List<Integer> cells = new ArrayList<>();

        for (int i = 0; i < rows * cols; i++)
        {
            cells.add(i);
        }

        // Gives a different coloured pattern every time
        Collections.shuffle(cells, RANDOM);
        Collections.shuffle(cells, new Random(variation));

        Set<Integer> colouredCells = new HashSet<>();

        for (int i = 0; i < coloured; i++)
        {
            colouredCells.add(cells.get(i));
        }

        int index = 0;

        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                RectF cell = new RectF(
                        bounds.left + c * cellWidth,
                        bounds.top + r * cellHeight,
                        bounds.left + (c + 1) * cellWidth,
                        bounds.top + (r + 1) * cellHeight);

                canvas.drawRoundRect(
                        cell,
                        10,10,
                        colouredCells.contains(index)
                                ? fillPaint
                                : emptyPaint);

                canvas.drawRoundRect(
                        cell,
                        10,10,
                        borderPaint);

                index++;
            }
        }

        canvas.drawRect(bounds, borderPaint);
    }

    private static void drawChocolateBar(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        int rows;
        int cols;

        fillPaint.setColor(Color.rgb(102,51,0));
        emptyPaint.setColor(Color.rgb(230,210,180));

        switch (denominator)
        {
            case 2:
                rows = 1;
                cols = 2;
                break;

            case 4:
                rows = 2;
                cols = 2;
                break;

            case 6:
                rows = 2;
                cols = 3;
                break;

            case 8:
                rows = 2;
                cols = 4;
                break;

            case 10:
                rows = 2;
                cols = 5;
                break;

            case 12:
                rows = 3;
                cols = 4;
                break;

            default:
                rows = 1;
                cols = denominator;
                break;
        }

        drawChocolateGrid(
                canvas,
                bounds,
                rows,
                cols,
                coloured,
                variation,
                fillPaint,
                emptyPaint,
                borderPaint);
    }

    private static void drawChocolateGrid(
            Canvas canvas,
            RectF bounds,
            int rows,
            int cols,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        float gap = 12f;

        float cellWidth =
                (bounds.width() - gap * (cols + 1)) / cols;

        float cellHeight =
                (bounds.height() - gap * (rows + 1)) / rows;

        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < rows * cols; i++)
            order.add(i);

        Collections.shuffle(order, new Random(variation));

        Set<Integer> colouredCells = new HashSet<>();

        for (int i = 0; i < coloured; i++)
            colouredCells.add(order.get(i));

        Paint highlight = new Paint(Paint.ANTI_ALIAS_FLAG);
        highlight.setColor(Color.argb(70,255,255,255));

        Paint shadow = new Paint(Paint.ANTI_ALIAS_FLAG);
        shadow.setColor(Color.argb(70,0,0,0));

        int index = 0;

        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                float left = bounds.left + gap + c*(cellWidth+gap);

                float top =
                        bounds.top +
                                gap +
                                r*(cellHeight+gap);

                RectF piece = new RectF(
                        left,
                        top,
                        left+cellWidth,
                        top+cellHeight);

                Paint p =
                        colouredCells.contains(index)
                                ? fillPaint
                                : emptyPaint;

                canvas.drawRoundRect(
                        piece,
                        18,
                        18,
                        p);

                canvas.drawRoundRect(
                        piece,
                        18,
                        18,
                        borderPaint);

                drawChocolateBevel(
                        canvas,
                        piece,
                        highlight,
                        shadow);

                index++;
            }
        }

        canvas.drawRoundRect(
                bounds,
                28,
                28,
                borderPaint);
    }

    private static void drawChocolateBevel(
            Canvas canvas,
            RectF piece,
            Paint highlight,
            Paint shadow)
    {
        float inset = piece.width()*0.15f;

        RectF inner = new RectF(
                piece.left+inset,
                piece.top+inset,
                piece.right-inset,
                piece.bottom-inset);

        canvas.drawRoundRect(inner,12,12,highlight);

        canvas.drawLine(
                piece.left,
                piece.bottom,
                piece.right,
                piece.bottom,
                shadow);

        canvas.drawLine(
                piece.right,
                piece.top,
                piece.right,
                piece.bottom,
                shadow);
    }

    private static void drawFractionBar(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        float gap = 4f;

        float barHeight = bounds.height() * 0.28f;
        float top = bounds.centerY() - barHeight / 2f;
        float bottom = bounds.centerY() + barHeight / 2f;

        float cellWidth = (bounds.width() - gap * (denominator - 1)) / denominator;

        float radius = barHeight * 0.15f;

        for (int i = 0; i < denominator; i++)
        {
            float left = bounds.left + i * (cellWidth + gap);
            RectF cell = new RectF(left, top, left + cellWidth, bottom);
            Paint paint = (i < coloured) ? fillPaint : emptyPaint;
            canvas.drawRoundRect(cell, radius, radius, paint);
            canvas.drawRoundRect(cell, radius, radius, borderPaint);
            drawFractionBarHighlight(canvas,cell);
        }
    }

    private static void drawFractionBarHighlight(Canvas canvas, RectF cell)
    {
        Paint highlight = new Paint(Paint.ANTI_ALIAS_FLAG);

        highlight.setColor(
                Color.argb(60,255,255,255));

        Paint shadow = new Paint(Paint.ANTI_ALIAS_FLAG);

        shadow.setColor(
                Color.argb(40,0,0,0));

        canvas.drawLine(cell.left,cell.top,cell.right,cell.top,
                highlight);

        canvas.drawLine(
                cell.left,
                cell.top,
                cell.left,
                cell.bottom,
                highlight);

        canvas.drawLine(
                cell.left,
                cell.bottom,
                cell.right,
                cell.bottom,
                shadow);

        canvas.drawLine(
                cell.right,
                cell.top,
                cell.right,
                cell.bottom,
                shadow);
    }

    private static void drawPizza(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        Paint crustPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        crustPaint.setColor(Color.rgb(210,160,90));

        Paint cheesePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cheesePaint.setColor(Color.rgb(255,240,140));

        Paint toppingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        toppingPaint.setColor(Color.rgb(220,60,60));

        float startAngle =
                new Random(variation).nextInt(360);

        float sweep =
                360f / denominator;

        // Outer crust
        canvas.drawOval(bounds, crustPaint);

        RectF cheese = new RectF(
                bounds.left + 18,
                bounds.top + 18,
                bounds.right - 18,
                bounds.bottom - 18);

        canvas.drawOval(cheese, cheesePaint);

        for (int i = 0; i < denominator; i++)
        {
            Paint paint =
                    (i < coloured)
                            ? fillPaint
                            : emptyPaint;

            float angle =
                    startAngle + i * sweep;

            canvas.drawArc(
                    cheese,
                    angle,
                    sweep,
                    true,
                    paint);

            drawPizzaToppings(
                    canvas,
                    cheese,
                    angle,
                    sweep,
                    toppingPaint);
        }

        // Slice borders
        for (int i = 0; i < denominator; i++)
        {
            double rad =
                    Math.toRadians(
                            startAngle + i * sweep);

            float cx = cheese.centerX();
            float cy = cheese.centerY();

            float x =
                    cx + (float)Math.cos(rad)
                            * cheese.width()/2;

            float y =
                    cy + (float)Math.sin(rad)
                            * cheese.height()/2;

            canvas.drawLine(
                    cx,
                    cy,
                    x,
                    y,
                    borderPaint);
        }

        canvas.drawCircle(
                cheese.centerX(),
                cheese.centerY(),
                5,
                borderPaint);

        canvas.drawOval(
                cheese,
                borderPaint);

        canvas.drawOval(
                bounds,
                borderPaint);
    }

    private static void drawPizzaToppings(
            Canvas canvas,
            RectF pizza,
            float startAngle,
            float sweep,
            Paint toppingPaint)
    {
        Random random =
                new Random(
                        (long)(startAngle * 1000));

        float cx = pizza.centerX();
        float cy = pizza.centerY();

        float radius = pizza.width()/2f;

        for(int i=0;i<3;i++)
        {
            float angle =
                    startAngle +
                            sweep*0.2f +
                            random.nextFloat()*sweep*0.6f;

            float distance =
                    radius*0.35f +
                            random.nextFloat()*radius*0.35f;

            double rad = Math.toRadians(angle);

            float x =
                    cx +
                            (float)Math.cos(rad)*distance;

            float y =
                    cy +
                            (float)Math.sin(rad)*distance;

            canvas.drawCircle(
                    x,
                    y,
                    radius*0.05f,
                    toppingPaint);
        }
    }

    private static void drawDonut(Canvas canvas,RectF bounds,int denominator,int coloured,int variation,Paint fillPaint,Paint emptyPaint,Paint borderPaint)
    {
        float strokeWidth = bounds.width() * 0.22f;

        Paint colouredPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        colouredPaint.setStyle(Paint.Style.STROKE);
        colouredPaint.setStrokeWidth(strokeWidth);
        colouredPaint.setStrokeCap(Paint.Cap.BUTT);
        colouredPaint.setColor(fillPaint.getColor());

        Paint remainingPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        remainingPaint.setStyle(Paint.Style.STROKE);
        remainingPaint.setStrokeWidth(strokeWidth);
        remainingPaint.setStrokeCap(Paint.Cap.BUTT);
        remainingPaint.setColor(emptyPaint.getColor());

        Paint separatorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        separatorPaint.setStyle(Paint.Style.STROKE);
        separatorPaint.setStrokeWidth(4);
        separatorPaint.setColor(borderPaint.getColor());

        float startAngle =
                new Random(variation).nextInt(360);

        float sweep = 360f / denominator;

        RectF ring = new RectF(
                bounds.left + strokeWidth / 2,
                bounds.top + strokeWidth / 2,
                bounds.right - strokeWidth / 2,
                bounds.bottom - strokeWidth / 2);

        // Draw coloured and uncoloured sectors
        for (int i = 0; i < denominator; i++)
        {
            Paint p = (i < coloured)
                    ? colouredPaint
                    : remainingPaint;

            canvas.drawArc(ring,startAngle + i * sweep,sweep,false,p);
        }

        // Draw separators
        float cx = ring.centerX();
        float cy = ring.centerY();

        float outerRadius = ring.width() / 2;
        float innerRadius = outerRadius - strokeWidth;

        for (int i = 0; i < denominator; i++)
        {
            double angle =
                    Math.toRadians(startAngle + i * sweep);

            float cos = (float) Math.cos(angle);
            float sin = (float) Math.sin(angle);

            float x1 = cx + innerRadius * cos;
            float y1 = cy + innerRadius * sin;

            float x2 = cx + outerRadius * cos;
            float y2 = cy + outerRadius * sin;

            canvas.drawLine(x1,y1,x2,y2,separatorPaint);
        }

        // Outer border
        Paint border = new Paint(Paint.ANTI_ALIAS_FLAG);
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(3);
        border.setColor(borderPaint.getColor());

        canvas.drawCircle(cx,cy,outerRadius,border);
        canvas.drawCircle(cx,cy,innerRadius,border);

        Paint glaze = new Paint(Paint.ANTI_ALIAS_FLAG);
        glaze.setStyle(Paint.Style.STROKE);
        glaze.setStrokeWidth(strokeWidth * 0.55f);
        glaze.setColor(Color.argb(70,255,255,255));

        canvas.drawArc(
                ring,
                startAngle,
                360,
                false,
                glaze);

        Random random = new Random(variation);

        for(int i=0;i<40;i++)
        {
            float angle = random.nextFloat()*360f;

            float radius =
                    innerRadius +
                            random.nextFloat()*(outerRadius-innerRadius);

            double rad = Math.toRadians(angle);

            float x = cx + (float)Math.cos(rad)*radius;
            float y = cy + (float)Math.sin(rad)*radius;

            Paint sprinkle = new Paint(Paint.ANTI_ALIAS_FLAG);

            switch(random.nextInt(5))
            {
                case 0: sprinkle.setColor(Color.RED); break;
                case 1: sprinkle.setColor(Color.BLUE); break;
                case 2: sprinkle.setColor(Color.GREEN); break;
                case 3: sprinkle.setColor(Color.YELLOW); break;
                default:sprinkle.setColor(Color.MAGENTA);
            }

            sprinkle.setStrokeWidth(4);

            canvas.drawLine(
                    x-4,
                    y-4,
                    x+4,
                    y+4,
                    sprinkle);
        }
    }

    private static void drawFlower(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        Random random = new Random(variation);

        float cx = bounds.centerX();
        float cy = bounds.centerY();

        float flowerRadius = Math.min(bounds.width(), bounds.height()) * 0.34f;

        float petalWidth = flowerRadius * 0.40f;
        float petalHeight = flowerRadius * 0.95f;

        float rotation = random.nextInt(360);

        List<Integer> petals = new ArrayList<>();

        for (int i = 0; i < denominator; i++)
            petals.add(i);

        Collections.shuffle(petals, new Random(variation));

        Set<Integer> colouredPetals = new HashSet<>();

        for (int i = 0; i < coloured; i++)
            colouredPetals.add(petals.get(i));

        float sweep = 360f / denominator;

        for (int i = 0; i < denominator; i++)
        {
            canvas.save();

            canvas.rotate(rotation + i * sweep, cx, cy);

            RectF petal = new RectF(
                    cx - petalWidth / 2f,
                    cy - flowerRadius,
                    cx + petalWidth / 2f,
                    cy - flowerRadius + petalHeight);

            Paint p =
                    colouredPetals.contains(i)
                            ? fillPaint
                            : emptyPaint;

            canvas.drawOval(petal, p);
            canvas.drawOval(petal, borderPaint);
            drawPetalHighlight(canvas, petal);
            canvas.restore();
        }

        drawFlowerCenter(
                canvas,
                cx,
                cy,
                flowerRadius * 0.32f,
                borderPaint);
    }

    private static void drawFlowerCenter(
            Canvas canvas,
            float cx,
            float cy,
            float radius,
            Paint borderPaint)
    {
        Paint centerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        centerPaint.setColor(Color.rgb(255, 215, 0));

        canvas.drawCircle(
                cx,
                cy,
                radius,
                centerPaint);

        canvas.drawCircle(
                cx,
                cy,
                radius,
                borderPaint);

        Paint dot = new Paint(Paint.ANTI_ALIAS_FLAG);

        dot.setColor(Color.rgb(180,120,0));

        for (int i = 0; i < 12; i++)
        {
            double angle = Math.toRadians(i * 30);
            float x = cx + (float)Math.cos(angle) * radius * 0.55f;
            float y = cy + (float)Math.sin(angle) * radius * 0.55f;
            canvas.drawCircle(x, y, radius * 0.08f, dot);
        }
    }

    private static void drawPetalHighlight(Canvas canvas, RectF petal)
    {
        Paint highlight = new Paint(Paint.ANTI_ALIAS_FLAG);

        highlight.setColor(
                Color.argb(60,255,255,255));

        RectF inner = new RectF(
                petal.left + petal.width()*0.18f,
                petal.top + petal.height()*0.12f,
                petal.right - petal.width()*0.18f,
                petal.bottom - petal.height()*0.18f);

        canvas.drawOval(
                inner,
                highlight);
    }

    private static void drawPentagon(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        if (denominator != 5)
        {
            drawCircle(canvas, bounds, denominator, coloured,
                    fillPaint, emptyPaint, borderPaint);
            return;
        }

        float cx = bounds.centerX();
        float cy = bounds.centerY();

        float radius = Math.min(bounds.width(), bounds.height()) * 0.42f;

        PointF[] vertices = new PointF[5];

        for (int i = 0; i < 5; i++)
        {
            double angle = Math.toRadians(-90 + i * 72);

            vertices[i] = new PointF(
                    cx + (float)(radius * Math.cos(angle)),
                    cy + (float)(radius * Math.sin(angle)));
        }

        List<Integer> order = Arrays.asList(0,1,2,3,4);

        Collections.shuffle(order, new Random(variation));

        for (int i = 0; i < 5; i++)
        {
            int part = order.get(i);
            Path path = new Path();
            path.moveTo(cx, cy);
            path.lineTo(vertices[part].x, vertices[part].y);

            path.lineTo(vertices[(part+1)%5].x, vertices[(part+1)%5].y);

            path.close();

            canvas.drawPath(path, i < coloured ? fillPaint : emptyPaint);

            canvas.drawPath(path, borderPaint);
        }

        Path outline = new Path();

        outline.moveTo(vertices[0].x, vertices[0].y);

        for (int i = 1; i < 5; i++)
            outline.lineTo(vertices[i].x, vertices[i].y);

        outline.close();

        canvas.drawPath(outline, borderPaint);
    }

    private static void drawHexagon(Canvas canvas,RectF bounds,int denominator,int coloured,int variation,Paint fillPaint,Paint emptyPaint,Paint borderPaint)
    {
        if (denominator != 6 &&
                denominator != 3 &&
                denominator != 2)
        {
            drawCircle(canvas,bounds,denominator,coloured,
                    fillPaint,emptyPaint,borderPaint);
            return;
        }

        float cx = bounds.centerX();
        float cy = bounds.centerY();

        float radius =
                Math.min(bounds.width(),
                        bounds.height()) * 0.42f;

        PointF[] vertices = new PointF[6];

        for(int i=0;i<6;i++)
        {
            double angle =
                    Math.toRadians(-90+i*60);

            vertices[i]=new PointF(
                    cx+(float)(radius*Math.cos(angle)),
                    cy+(float)(radius*Math.sin(angle)));
        }

        int sectors=6;

        boolean[] fill=new boolean[6];

        List<Integer> order=new ArrayList<>();

        for(int i=0;i<6;i++)
            order.add(i);

        Collections.shuffle(order,new Random(variation));

        if(denominator==6)
        {
            for(int i=0;i<coloured;i++)
                fill[order.get(i)]=true;
        }
        else if(denominator==3)
        {
            for(int i=0;i<coloured;i++)
            {
                fill[order.get(i*2)]=true;
                fill[order.get(i*2+1)]=true;
            }
        }
        else
        {
            for(int i=0;i<coloured;i++)
            {
                fill[order.get(i*3)]=true;
                fill[order.get(i*3+1)]=true;
                fill[order.get(i*3+2)]=true;
            }
        }

        for(int i=0;i<6;i++)
        {
            Path path=new Path();

            path.moveTo(cx,cy);

            path.lineTo(vertices[i].x,vertices[i].y);

            path.lineTo(
                    vertices[(i+1)%6].x,
                    vertices[(i+1)%6].y);

            path.close();

            canvas.drawPath(path,
                    fill[i]?fillPaint:emptyPaint);

            canvas.drawPath(path,borderPaint);
        }
    }

    private static void drawEquilateralTriangle(
            Canvas canvas,
            RectF bounds,
            int denominator,
            int coloured,
            int variation,
            Paint fillPaint,
            Paint emptyPaint,
            Paint borderPaint)
    {
        if (denominator != 2 && denominator != 3 && denominator != 4 && denominator != 6)
        {
            drawCircle(canvas,bounds,denominator,coloured, fillPaint,emptyPaint,borderPaint);
            return;
        }

        float cx = bounds.centerX();
        float cy = bounds.centerY();

        float radius = Math.min(bounds.width(), bounds.height()) * 0.46f;

        PointF top = new PointF(cx, cy-radius);
        PointF left = new PointF(cx-radius*0.866f, cy+radius*0.5f);
        PointF right = new PointF(cx+radius*0.866f,cy+radius*0.5f);
        ArrayList<Path> parts = new ArrayList<>();

        if(denominator == 2)
        {
            Log.d("NKG_LOG", denominator + "");
            PointF mid = midpoint(left,right);

            Path p1 = new Path();

            p1.moveTo(top.x,top.y);
            p1.lineTo(left.x,left.y);
            p1.lineTo(mid.x,mid.y);
            p1.close();

            Path p2 = new Path();

            p2.moveTo(top.x,top.y);
            p2.lineTo(mid.x,mid.y);
            p2.lineTo(right.x,right.y);
            p2.close();

            parts.add(p1);
            parts.add(p2);
            Log.d("NKG_LOG", denominator + ": after adding parts");
        }
        else if(denominator == 3)
        {
            PointF center = new PointF((top.x+left.x+right.x)/3f, (top.y+left.y+right.y)/3f);

            Path p1=new Path();
            p1.moveTo(center.x,center.y);
            p1.lineTo(top.x,top.y);
            p1.lineTo(left.x,left.y);
            p1.close();

            Path p2=new Path();
            p2.moveTo(center.x,center.y);
            p2.lineTo(left.x,left.y);
            p2.lineTo(right.x,right.y);
            p2.close();

            Path p3=new Path();
            p3.moveTo(center.x,center.y);
            p3.lineTo(right.x,right.y);
            p3.lineTo(top.x,top.y);
            p3.close();

            parts.add(p1);
            parts.add(p2);
            parts.add(p3);
        }
        else if(denominator == 4)
        {
            PointF m1=midpoint(top,left);
            PointF m2=midpoint(left,right);
            PointF m3=midpoint(right,top);

            Path p1=new Path();
            p1.moveTo(top.x,top.y);
            p1.lineTo(m1.x,m1.y);
            p1.lineTo(m3.x,m3.y);
            p1.close();

            Path p2=new Path();
            p2.moveTo(left.x,left.y);
            p2.lineTo(m2.x,m2.y);
            p2.lineTo(m1.x,m1.y);
            p2.close();

            Path p3=new Path();
            p3.moveTo(right.x,right.y);
            p3.lineTo(m3.x,m3.y);
            p3.lineTo(m2.x,m2.y);
            p3.close();

            Path p4=new Path();
            p4.moveTo(m1.x,m1.y);
            p4.lineTo(m2.x,m2.y);
            p4.lineTo(m3.x,m3.y);
            p4.close();

            parts.add(p1);
            parts.add(p2);
            parts.add(p3);
            parts.add(p4);
        }
        else
        {
            // denominator = 6

            // For now, reuse Pizza style inside triangle.
            // We can improve this later with a proper triangular lattice.

            drawCircle(canvas,bounds,6,coloured, fillPaint,emptyPaint,borderPaint);

            return;
        }

        List<Integer> order=new ArrayList<>();

        for(int i=0;i<parts.size();i++) {
            order.add(i);
        }

        Collections.shuffle(order,new Random(variation));

        for(int i = 0; i < parts.size(); i++)
        {
            canvas.drawPath(parts.get(order.get(i)),i<coloured?fillPaint:emptyPaint);
            canvas.drawPath(parts.get(order.get(i)),borderPaint);
        }

        Log.d("NKG_LOG", denominator + "End drawEquilateralTriangle");
    }

    private static PointF midpoint(PointF a, PointF b)
    {
        return new PointF(
                (a.x + b.x)/2f,
                (a.y + b.y)/2f);
    }

    public static FractionData createFraction(
            int numerator,
            int denominator)
    {
        return new FractionData(
                numerator,
                denominator,
                randomShape(denominator),
                randomTheme(),
                RANDOM.nextInt(100000));
    }
}
