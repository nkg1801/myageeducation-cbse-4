package com.myAgeEducation.cbseClass4.maths.pictograph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.myAgeEducation.cbseClass4.R;
import com.myAgeEducation.cbseClass4.maths.utils.ColorUtils;

import java.util.Random;

public class PictographImageGenerator
{
    private enum TreeType
    {
        ROUND,
        PINE,
        WIDE,
        THREE_TOP
    }
    private static final Random RANDOM = new Random();

    public static Bitmap generate(Context context, String imageCode)
    {
        String[] parts = imageCode.split("_");

        if (parts.length < 6 || !parts[0].equals("PICTOGRAPH"))
        {
            throw new IllegalArgumentException("Invalid pictograph image code: " + imageCode);
        }

        int index = 2;

        // Icon type
        String iconCode = parts[index++];
        //index++;
        // Value represented by one icon
        int valuePerIcon = Integer.parseInt(parts[index++]);

        // Number of categories
        int categoryCount = Integer.parseInt(parts[index++]);

        // Validate expected number of parts:
        // 5 fixed parts + labels + icon counts
        int expectedLength = 5 + (categoryCount * 2);

        if (parts.length != expectedLength)
        {
            throw new IllegalArgumentException("Invalid pictograph image code. " + "Expected " + expectedLength
                            + " parts but got " + parts.length + ": " + imageCode);
        }

        // Read labels
        String[] labels = new String[categoryCount];

        for (int i = 0; i < categoryCount; i++)
        {
            labels[i] = parts[index++];
        }

        // Read icon counts
        int[] iconCounts = new int[categoryCount];

        for (int i = 0; i < categoryCount; i++)
        {
            iconCounts[i] = Integer.parseInt(parts[index++]);
        }

        PictographIconType iconType = getIconType(iconCode);

        return generate(context, labels, valuePerIcon, iconCounts, iconType);
    }

    private static Bitmap generate(Context context, String[] labels, int valuePerIcon, int[] iconCounts, PictographIconType iconType)
    {
        int width = 1000;
        int height = 800; //old value 650

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        Bitmap pngBitmap = loadPngBitmap(context, iconType);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);

        // Select tree style ONCE for this pictograph
        TreeType treeType = TreeType.values()[RANDOM.nextInt(TreeType.values().length)];

        float leftMargin = 60;
        float topMargin = 50;
        float labelColumnWidth = 250;
        float rowHeight = 110;
        float iconStartX = leftMargin + labelColumnWidth + 40;
        float iconSpacing = 75;
        float iconScale = 1.0f;

        int color = ColorUtils.getRandomColorForWhiteBackground();

        for (int row = 0; row < labels.length; row++)
        {
            float centerY = topMargin + (row * rowHeight) + (rowHeight / 2);

            // DRAW LABEL
            paint.setColor(Color.BLACK);
            paint.setTextSize(38);
            paint.setTextAlign(Paint.Align.LEFT);

            canvas.drawText(labels[row], leftMargin, centerY + 12, paint);

            // DRAW ICONS
            paint.setColor(color);

            for (int iconIndex = 0; iconIndex < iconCounts[row]; iconIndex++)
            {
                float centerX = iconStartX + (iconIndex * iconSpacing);

                drawIcon(
                        context,
                        canvas,
                        centerX,
                        centerY,
                        iconScale,
                        paint,
                        iconType,
                        pngBitmap,
                        treeType);
            }
        }

        // DRAW KEY
        float keyY = topMargin + (labels.length * rowHeight) + 60;

        paint.setColor(Color.BLACK);
        paint.setTextSize(34);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Key:", leftMargin, keyY, paint);
        paint.setColor(color);
        float keyIconX = leftMargin + 150;

        // Use the SAME tree style in the key
        drawIcon(
                context,
                canvas,
                keyIconX,
                keyY - 10,
                0.8f,
                paint,
                iconType,
                pngBitmap,
                treeType);

        paint.setColor(Color.BLACK);
        paint.setTextSize(34);
        canvas.drawText("= " + valuePerIcon, keyIconX + 60, keyY, paint);
        return bitmap;
    }

    private static Bitmap loadPngBitmap(Context context, PictographIconType iconType)
    {
        int resourceId;

        switch (iconType)
        {
            case PNGAPPLES: {
                int[] iconResources =
                        {
                                R.drawable.apple,
                                R.drawable.apple_1,
                                R.drawable.apple_2,
                                R.drawable.apple_3
                        };
                resourceId = iconResources[RANDOM.nextInt(iconResources.length)];
                break;
            }

            case PNGTEDDYBEAR: {
                int[] teddyResources =
                        {
                                R.drawable.teddybear_1,
                                R.drawable.teddybear_2,
                                R.drawable.teddybear_3,
                                R.drawable.teddybear_4
                        };
                resourceId = teddyResources[RANDOM.nextInt(teddyResources.length)];
                break;
            }

            case PNG_BICYCLE: {
                int[] birdResources =
                        {
                                R.drawable.bicycle_1,
                                R.drawable.bicycle_2,
                                R.drawable.bicycle_3,
                                R.drawable.bicycle_4,
                                R.drawable.bicycle_5
                        };
                resourceId = birdResources[RANDOM.nextInt(birdResources.length)];
                break;
            }

            case PNG_BIRD: {
                int[] birdResources =
                        {
                                R.drawable.bird_1,
                                R.drawable.bird_2,
                                R.drawable.bird_3,
                                R.drawable.bird_4,
                                R.drawable.bird_5,
                                R.drawable.bird_6,
                                R.drawable.bird_7,
                                R.drawable.bird_8,
                                R.drawable.bird_9,
                                R.drawable.bird_10
                        };
                resourceId = birdResources[RANDOM.nextInt(birdResources.length)];
                break;
            }

            case PNG_BAG: {
                int[] bagResources =
                        {
                                R.drawable.bag_1,
                                R.drawable.bag_2,
                                R.drawable.bag_3,
                                R.drawable.bag_4,
                                R.drawable.bag_5,
                                R.drawable.bag_6,
                                R.drawable.bag_7,
                                R.drawable.bag_8,
                                R.drawable.bag_9,
                                R.drawable.bag_10
                        };
                resourceId = bagResources[RANDOM.nextInt(bagResources.length)];
                break;
            }
            case PNG_BOOK:
            {
                int[] bookResources =
                        {
                                R.drawable.open_book,
                                R.drawable.book,
                                R.drawable.books_cover,
                                R.drawable.bookshelf,
                                R.drawable.book_yellow,
                                R.drawable.book_2,
                                R.drawable.book_purple,
                                R.drawable.book_green,
                        };

                resourceId = bookResources[RANDOM.nextInt(bookResources.length)];
                break;
            }

            case PNG_FRUIT:
                int[] fruitResources =
                        {
                                R.drawable.orange,
                                R.drawable.apple,
                                R.drawable.apple_1,
                                R.drawable.apple_2,
                                R.drawable.apple_3,
                                R.drawable.strawberry,
                                R.drawable.strawberry_1,
                                R.drawable.strawberry_2,
                                R.drawable.strawberry_3,
                                R.drawable.dragon_fruit,
                                R.drawable.fruit,
                                R.drawable.grapes_1,
                                R.drawable.grapes_2,
                                R.drawable.lemon,
                                R.drawable.mango,
                                R.drawable.pear,
                                R.drawable.pineapple,
                                R.drawable.watermelon
                        };

                resourceId = fruitResources[RANDOM.nextInt(fruitResources.length)];
                break;

            case PNG_BALL:
                int[] ballResources =
                        {
                                R.drawable.soccer_ball,
                                R.drawable.tennis_1,
                                R.drawable.tennis_2,
                                R.drawable.tennis_3,
                                R.drawable.tennis_4,
                                R.drawable.basketball,
                                R.drawable.baseball,
                                R.drawable.football,
                                R.drawable.table_tennis
                        };

                resourceId = ballResources[RANDOM.nextInt(ballResources.length)];
                break;

            case PNG_FLOWER:
                resourceId = R.drawable.flower;
                break;

            case PNG_ICE_CREAM:
                int[] icecreamResources =
                        {
                                R.drawable.ice_cream,
                                R.drawable.ice_cream_2,
                                R.drawable.ice_cream_3,
                                R.drawable.ice_cream_4,
                                R.drawable.ice_cream_5,
                                R.drawable.ice_cream_6,
                                R.drawable.ice_cream_7,
                                R.drawable.ice_cream_8,
                                R.drawable.ice_cream_9,
                                R.drawable.ice_cream_10,
                                R.drawable.ice_cream_11,
                        };

                resourceId = icecreamResources[RANDOM.nextInt(icecreamResources.length)];
                break;

            case PNG_PERSON:
                int[] personResources =
                        {
                                R.drawable.person_1,
                                R.drawable.person_2,
                                R.drawable.person_3,
                                R.drawable.person_4,
                                R.drawable.person_5,
                                R.drawable.person_6,
                                R.drawable.person_7,
                                R.drawable.person_8,
                                R.drawable.person_9,
                                R.drawable.person_10,
                                R.drawable.person_11,
                                R.drawable.person_12,
                                R.drawable.person_13,
                                R.drawable.person_14
                        };

                resourceId = personResources[RANDOM.nextInt(personResources.length)];
                break;

            case PNG_PETS:
                int[] petResources =
                        {
                                R.drawable.pet_1,
                                R.drawable.pet_2,
                                R.drawable.pet_3,
                                R.drawable.pet_4,
                                R.drawable.pet_5,
                                R.drawable.pet_6,
                                R.drawable.pet_7,
                                R.drawable.pet_8,
                                R.drawable.pet_9,
                                R.drawable.pet_10
                        };

                resourceId = petResources[RANDOM.nextInt(petResources.length)];
                break;

            case PNG_VEHICLE:
                int[] vehicleResources =
                        {
                                R.drawable.vehicle_1,
                                R.drawable.vehicle_2,
                                R.drawable.vehicle_3,
                                R.drawable.vehicle_4,
                                R.drawable.vehicle_5,
                                R.drawable.vehicle_6,
                                R.drawable.vehicle_7,
                                R.drawable.vehicle_8,
                                R.drawable.vehicle_9,
                                R.drawable.vehicle_10
                        };

                resourceId = vehicleResources[RANDOM.nextInt(vehicleResources.length)];
                break;

            default:
                return null;
        }

        return BitmapFactory.decodeResource(context.getResources(), resourceId);
    }

    private static void drawIcon(Context context, Canvas canvas, float centerX, float centerY, float scale, Paint paint,
                                 PictographIconType iconType, Bitmap pngBitmap, TreeType treeType)
    {
        switch (iconType)
        {
            case FILLED_PERSON:
                drawFilledPerson(canvas, centerX, centerY, scale, paint);
                break;

            case STICK_PERSON:
                drawStickPerson(canvas, centerX, centerY, scale, paint);
                break;

            case SQUARE:
                float size = 42 * scale;
                canvas.drawRect(centerX - size / 2, centerY - size / 2, centerX + size / 2, centerY + size / 2,paint);
                break;

            case STAR:
                drawStar(canvas, centerX, centerY, 25 * scale, paint);
                break;

            case ICE_CREAM:
                drawIceCream(canvas,centerX,centerY, scale,paint);
                break;

            case BOOK:
                drawBook(canvas, centerX, centerY, scale, paint);
                break;

            case FRUIT:
                drawFruit(canvas, centerX, centerY, scale, paint);
                break;

            case BALL:
                drawBall(canvas, centerX, centerY, scale, paint);
                break;

            case FLOWER:
                drawFlower(canvas, centerX, centerY, scale, paint);
                break;

            case HEART:
                drawHeart(canvas, centerX, centerY, scale, paint);
                break;

            case DIAMOND:
                drawDiamond(canvas, centerX, centerY, scale, paint);
                break;

            case TRIANGLE:
                drawTriangle(canvas, centerX, centerY, scale, paint);
                break;

            case COLOR_BOOK:
                drawColorBook(canvas, centerX, centerY, scale);
                break;

            case COLOR_APPLE:
                drawColorApple(canvas, centerX, centerY, scale);
                break;

            case COLOR_BALL:
                drawColorBall(canvas, centerX, centerY, scale);
                break;

            case COLOR_FLOWER:
                drawColorFlower(canvas, centerX, centerY, scale);
                break;

            case COLOR_ICE_CREAM:
                drawColorIceCream(canvas, centerX, centerY, scale);
                break;

            case TREE:
                drawTree(canvas, centerX, centerY, scale, treeType);
                break;

            case PNG_BOOK:
            case PNG_FRUIT:
            case PNG_BALL:
            case PNG_FLOWER:
            case PNG_ICE_CREAM:
            case PNG_PERSON:
            case PNG_PETS:
            case PNG_BAG:
            case PNG_BIRD:
            case PNG_VEHICLE:
            case PNG_BICYCLE:
            case PNGTEDDYBEAR:
            case PNGAPPLES:
                drawPngIcon(canvas,pngBitmap,centerX,centerY,scale);
                break;

            default:
                canvas.drawCircle(centerX, centerY, 22 * scale, paint);
                break;
        }
    }

    private static void drawIceCream(Canvas canvas, float centerX, float centerY, float scale, Paint paint)
    {
        // Ice-cream scoop
        canvas.drawCircle(centerX,centerY - (12 * scale),14 * scale, paint);

        // Cone
        Path cone = new Path();
        cone.moveTo(centerX - (12 * scale), centerY);
        cone.lineTo(centerX + (12 * scale),centerY);
        cone.lineTo(centerX,centerY + (30 * scale));
        cone.close();
        canvas.drawPath(cone,paint);
    }

    // FILLED PERSON
    private static void drawFilledPerson(Canvas canvas, float centerX, float centerY, float scale, Paint paint)
    {
        // Head
        canvas.drawCircle(centerX, centerY - (20 * scale), 8 * scale, paint);

        // Body
        Path body = new Path();

        body.moveTo(centerX - (8 * scale), centerY - (10 * scale));
        body.lineTo(centerX + (8 * scale), centerY - (10 * scale));
        body.lineTo(centerX + (10 * scale), centerY + (10 * scale));
        body.lineTo(centerX + (5 * scale), centerY + (10 * scale));
        body.lineTo(centerX + (9 * scale), centerY + (30 * scale));
        body.lineTo(centerX + (2 * scale), centerY + (30 * scale));
        body.lineTo(centerX, centerY + (13 * scale));
        body.lineTo(centerX - (5 * scale), centerY + (30 * scale));
        body.lineTo(centerX - (12 * scale), centerY + (30 * scale));
        body.lineTo(centerX - (5 * scale), centerY + (10 * scale));
        body.lineTo(centerX - (10 * scale), centerY + (10 * scale));
        body.close();

        canvas.drawPath(body, paint);

        // Arms
        float oldStrokeWidth = paint.getStrokeWidth();
        paint.setStrokeWidth( 7 * scale);

        canvas.drawLine(centerX - (7 * scale), centerY - (5 * scale), centerX - (18 * scale), centerY + (10 * scale), paint);
        canvas.drawLine(centerX + (7 * scale), centerY - (5 * scale), centerX + (18 * scale), centerY + (10 * scale),paint);

        paint.setStrokeWidth(oldStrokeWidth);
    }

    // STICK PERSON

    private static void drawStickPerson(Canvas canvas,float centerX, float centerY, float scale, Paint paint)
    {
        float oldStrokeWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(6 * scale);

        // Head
        canvas.drawCircle(centerX, centerY - (18 * scale), 8 * scale, paint);

        // Body
        canvas.drawLine(centerX, centerY - (10 * scale), centerX, centerY + (12 * scale), paint);

        // Arms
        canvas.drawLine(
                centerX,
                centerY - (3 * scale),
                centerX - (12 * scale),
                centerY + (5 * scale),
                paint);


        canvas.drawLine(
                centerX,
                centerY - (3 * scale),
                centerX + (12 * scale),
                centerY + (5 * scale),
                paint);


        // Legs
        canvas.drawLine(
                centerX,
                centerY + (12 * scale),
                centerX - (10 * scale),
                centerY + (28 * scale),
                paint);

        canvas.drawLine(
                centerX,
                centerY + (12 * scale),
                centerX + (10 * scale),
                centerY + (28 * scale),
                paint);

        paint.setStrokeWidth(oldStrokeWidth);
    }

    // STAR

    private static void drawStar(Canvas canvas, float centerX, float centerY, float outerRadius, Paint paint)
    {
        Path path = new Path();
        float innerRadius = outerRadius * 0.45f;

        for (int i = 0; i < 10; i++)
        {
            double angle = -Math.PI / 2 + i * Math.PI / 5;
            float radius = (i % 2 == 0) ? outerRadius : innerRadius;


            float x =
                    centerX
                            + (float) Math.cos(angle)
                            * radius;


            float y =
                    centerY
                            + (float) Math.sin(angle)
                            * radius;


            if (i == 0)
            {
                path.moveTo(x, y);
            }
            else
            {
                path.lineTo(x, y);
            }
        }

        path.close();
        canvas.drawPath(path, paint);
    }

    private static void drawBook(Canvas canvas, float x, float y, float scale, Paint paint)
    {
        float w = 42 * scale;
        float h = 34 * scale;

        Path path = new Path();

        path.moveTo(x, y - h / 2);
        path.lineTo(x - w / 2, y - h / 2 - 4 * scale);
        path.lineTo(x - w / 2, y + h / 2);
        path.lineTo(x, y + h / 2 + 4 * scale);
        path.close();

        canvas.drawPath(path, paint);

        path.reset();

        path.moveTo(x, y - h / 2);
        path.lineTo(x + w / 2, y - h / 2 - 4 * scale);
        path.lineTo(x + w / 2, y + h / 2);
        path.lineTo(x, y + h / 2 + 4 * scale);
        path.close();

        canvas.drawPath(path, paint);
    }

    private static void drawFruit(Canvas canvas, float x, float y, float scale,Paint paint)
    {
        canvas.drawCircle(x - 8 * scale, y + 3 * scale, 15 * scale, paint);
        canvas.drawCircle(x + 8 * scale, y + 3 * scale, 15 * scale, paint);

        // Stem
        float oldWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(5 * scale);
        canvas.drawLine(x, y - 10 * scale, x + 4 * scale, y - 25 * scale, paint);
        paint.setStrokeWidth(oldWidth);

        // Leaf
        canvas.drawOval(x + 2 * scale, y - 25 * scale, x + 20 * scale, y - 13 * scale, paint);
    }

    private static void drawBall(Canvas canvas, float x, float y, float scale, Paint paint)
    {
        float radius = 23 * scale;
        canvas.drawCircle(x, y, radius, paint);
    }

    private static void drawFlower(Canvas canvas, float x, float y, float scale, Paint paint)
    {
        float petalDistance = 13 * scale;
        float petalRadius = 10 * scale;

        for (int i = 0; i < 6; i++)
        {
            double angle = (Math.PI * 2 * i) / 6;
            float petalX = x + (float) Math.cos(angle) * petalDistance;
            float petalY = y + (float) Math.sin(angle) * petalDistance;
            canvas.drawCircle(petalX,petalY, petalRadius, paint);
        }

        canvas.drawCircle(x, y, 9 * scale, paint);
    }

    private static void drawHeart(Canvas canvas, float x, float y, float scale, Paint paint)
    {
        Path path = new Path();
        path.moveTo(x, y + 25 * scale);
        path.cubicTo(x - 35 * scale, y + 5 * scale, x - 25 * scale, y - 25 * scale, x, y - 8 * scale);
        path.cubicTo(
                x + 25 * scale,
                y - 25 * scale,
                x + 35 * scale,
                y + 5 * scale,
                x,
                y + 25 * scale);

        path.close();

        canvas.drawPath(path, paint);
    }

    private static void drawDiamond(Canvas canvas, float x, float y, float scale, Paint paint)
    {
        Path path = new Path();
        path.moveTo(x, y - 25 * scale);
        path.lineTo(x + 22 * scale, y);
        path.lineTo(x, y + 25 * scale);
        path.lineTo(x - 22 * scale, y);
        path.close();
        canvas.drawPath(path, paint);
    }

    private static void drawTriangle(Canvas canvas, float x, float y, float scale, Paint paint)
    {
        Path path = new Path();
        path.moveTo(x, y - 25 * scale);
        path.lineTo(x + 24 * scale, y + 20 * scale);
        path.lineTo(x - 24 * scale, y + 20 * scale);
        path.close();
        canvas.drawPath(path, paint);
    }

    private static void drawColorApple(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Apple
        paint.setColor(Color.rgb(220, 50, 50));
        canvas.drawCircle(x - 7 * scale, y + 3 * scale, 15 * scale, paint);
        canvas.drawCircle(x + 7 * scale, y + 3 * scale, 15 * scale, paint);

        // Stem
        paint.setColor(Color.rgb(100, 65, 35));
        paint.setStrokeWidth(5 * scale);
        canvas.drawLine(x, y - 10 * scale, x + 3 * scale, y - 25 * scale, paint);

        // Leaf
        paint.setColor(Color.rgb(50, 160, 70));
        canvas.drawOval(x + 2 * scale, y - 25 * scale, x + 20 * scale, y - 13 * scale, paint);
    }

    private static void drawColorBook(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        float w = 44 * scale;
        float h = 34 * scale;

        // Left page
        paint.setColor(Color.rgb(66, 133, 244));

        Path leftPage = new Path();

        leftPage.moveTo(x, y - h / 2);
        leftPage.lineTo(x - w / 2, y - h / 2 - 4 * scale);
        leftPage.lineTo(x - w / 2, y + h / 2);
        leftPage.lineTo(x, y + h / 2 + 4 * scale);
        leftPage.close();

        canvas.drawPath(leftPage, paint);

        // Right page
        paint.setColor(Color.rgb(255, 193, 7));

        Path rightPage = new Path();

        rightPage.moveTo(x, y - h / 2);
        rightPage.lineTo(x + w / 2, y - h / 2 - 4 * scale);
        rightPage.lineTo(x + w / 2, y + h / 2);
        rightPage.lineTo(x, y + h / 2 + 4 * scale);
        rightPage.close();

        canvas.drawPath(rightPage, paint);

        // Centre line
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(2 * scale);

        canvas.drawLine(x, y - h / 2, x, y + h / 2 + 4 * scale, paint);
    }

    private static void drawColorBall(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        float radius = 23 * scale;

        // baseball
        paint.setColor(Color.rgb(244, 67, 54));
        canvas.drawCircle(x, y, radius, paint);

        // Yellow section
        paint.setColor(Color.rgb(255, 193, 7));
        RectF oval = new RectF(x - radius, y - radius, x + radius, y + radius);
        canvas.drawArc(oval, -70, 100, true, paint);

        // Blue section
        paint.setColor(Color.rgb(33, 150, 243));
        canvas.drawArc(oval, 80, 100, true, paint);

        // Centre
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, 6 * scale, paint);
    }

    private static void drawColorFlower(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        float petalDistance = 13 * scale;
        float petalRadius = 10 * scale;

        int[] petalColors =
                {
                        Color.rgb(244, 67, 54),
                        Color.rgb(255, 152, 0),
                        Color.rgb(156, 39, 176),
                        Color.rgb(33, 150, 243),
                        Color.rgb(76, 175, 80),
                        Color.rgb(233, 30, 99)
                };

        for (int i = 0; i < 6; i++)
        {
            double angle = (Math.PI * 2 * i) / 6;
            float petalX = x + (float) Math.cos(angle) * petalDistance;
            float petalY = y + (float) Math.sin(angle) * petalDistance;
            paint.setColor(petalColors[i]);
            canvas.drawCircle(petalX, petalY, petalRadius, paint);
        }

        // Yellow centre
        paint.setColor(Color.rgb(255, 193, 7));
        canvas.drawCircle(x, y,9 * scale, paint);
    }

    private static void drawColorIceCream(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // Cone
        paint.setColor(Color.rgb(210, 150, 75));
        Path cone = new Path();
        cone.moveTo(x - 14 * scale, y);
        cone.lineTo(x + 14 * scale, y);
        cone.lineTo(x, y + 32 * scale);
        cone.close();
        canvas.drawPath(cone, paint);

        // Main scoop
        paint.setColor(Color.rgb(244, 143, 177));
        canvas.drawCircle(x, y - 12 * scale, 16 * scale, paint);

        // Highlight
        paint.setColor(Color.rgb(255, 205, 220));
        canvas.drawCircle(x - 6 * scale, y - 18 * scale, 5 * scale, paint);

        // Cherry
        paint.setColor(Color.rgb(200, 30, 45));
        canvas.drawCircle(x + 5 * scale, y - 31 * scale, 5 * scale, paint);
    }

    private static void drawTree(Canvas canvas, float x, float y, float scale, TreeType treeType)
    {
        switch (treeType)
        {
            case ROUND:
                drawRoundTree(canvas, x, y, scale);
                break;

            case PINE:
                drawPineTree(canvas, x, y, scale);
                break;

            case WIDE :
                drawWideTree(canvas, x, y, scale);
                break;

            default:
                drawThreeTopTree(canvas, x, y, scale);
                break;
        }
    }

    private static void drawRoundTree(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Trunk
        paint.setColor(Color.rgb(130, 85, 45));
        //paint.setColor(Color.GREEN);

        canvas.drawRect(x - 6 * scale, y, x + 6 * scale, y + 30 * scale, paint);

        // Canopy
        paint.setColor(Color.rgb(65, 160, 75));
        canvas.drawCircle(x, y - 15 * scale, 25 * scale,paint);
    }

    private static void drawPineTree(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Trunk
        paint.setColor(Color.rgb(130, 85, 45));

        canvas.drawRect(x - 5 * scale, y + 5 * scale,
                x + 5 * scale,
                y + 32 * scale,
                paint);

        // Tree top
        paint.setColor(Color.rgb(45, 140, 70));
        Path path = new Path();
        path.moveTo(x, y - 40 * scale);
        path.lineTo(x - 25 * scale, y + 12 * scale);
        path.lineTo(x + 25 * scale, y + 12 * scale);
        path.close();
        canvas.drawPath(path, paint);
    }

    private static void drawWideTree(
            Canvas canvas,
            float x,
            float y,
            float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Trunk
        paint.setColor(Color.rgb(130, 85, 45));

        canvas.drawRect(
                x - 6 * scale,
                y,
                x + 6 * scale,
                y + 30 * scale,
                paint);

        // Wide canopy
        paint.setColor(Color.rgb(75, 165, 80));

        canvas.drawOval(
                x - 32 * scale,
                y - 35 * scale,
                x + 32 * scale,
                y + 5 * scale,
                paint);
    }

    private static void drawThreeTopTree(Canvas canvas, float x, float y, float scale)
    {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Trunk
        paint.setColor(Color.rgb(130, 85, 45));

        canvas.drawRect(
                x - 6 * scale,
                y,
                x + 6 * scale,
                y + 30 * scale,
                paint);

        // Canopy
        paint.setColor(Color.rgb(60, 155, 70));

        canvas.drawCircle(
                x,
                y - 25 * scale,
                20 * scale,
                paint);

        canvas.drawCircle(
                x - 18 * scale,
                y - 10 * scale,
                18 * scale,
                paint);

        canvas.drawCircle(
                x + 18 * scale,
                y - 10 * scale,
                18 * scale,
                paint);
    }

    private static void drawPngIcon(Canvas canvas,Bitmap bitmap, float centerX, float centerY, float scale)
    {
        if (bitmap == null)
        {
            return;
        }

        float size = 50 * scale;
        RectF destination =
                new RectF(
                        centerX - size / 2,
                        centerY - size / 2,
                        centerX + size / 2,
                        centerY + size / 2);

        Paint bitmapPaint = new Paint(
                        Paint.ANTI_ALIAS_FLAG
                                | Paint.FILTER_BITMAP_FLAG);

        canvas.drawBitmap(bitmap, null, destination, bitmapPaint);
    }

    // SCENARIO LABELS

    private static String[] getLabels(String scenarioCode)
    {
        switch (scenarioCode)
        {
            case "ICECREAM":
                return new String[]
                        {
                                "Vanilla",
                                "Chocolate",
                                "Strawberry",
                                "Mango"
                        };

            case "BOOKS":
                return new String[]
                        {
                                "Aarav",
                                "Riya",
                                "Kabir",
                                "Meera"
                        };

            case "CLASSES":
                return new String[]
                        {
                                "Class-1",
                                "Class-2",
                                "Class-3",
                                "Class-4"
                        };

            case "FRUITS":
                return new String[]
                        {
                                "Apples",
                                "Oranges",
                                "Mangoes",
                                "Bananas"
                        };

            case "SPORTS":
                return new String[]
                        {
                                "Cricket",
                                "Football",
                                "Tennis",
                                "Badminton"
                        };

            case "PETS":
                return new String[]
                        {
                                "Dog",
                                "Cat",
                                "Fish",
                                "Rabbit"
                        };

            default:
                throw new IllegalArgumentException("Unknown pictograph scenario: " + scenarioCode);
        }
    }


    // =========================================
    // ICON TYPE
    // =========================================

    public static PictographIconType getIconType(String iconCode)
    {
        switch (iconCode)
        {
            // Person icons
            case "FILLED":
                return PictographIconType.FILLED_PERSON;

            case "STICK":
                return PictographIconType.STICK_PERSON;

            // Basic shapes
            case "CIRCLE":
                return PictographIconType.CIRCLE;

            case "SQUARE":
                return PictographIconType.SQUARE;

            case "STAR":
                return PictographIconType.STAR;

            case "HEART":
                return PictographIconType.HEART;

            case "DIAMOND":
                return PictographIconType.DIAMOND;

            case "TRIANGLE":
                return PictographIconType.TRIANGLE;

            // Solid object icons
            case "ICECREAM":
                return PictographIconType.ICE_CREAM;

            case "BOOK":
                return PictographIconType.BOOK;

            case "FRUIT":
                return PictographIconType.FRUIT;

            case "BALL":
                return PictographIconType.BALL;

            case "FLOWER":
                return PictographIconType.FLOWER;

            // Coloured object icons
            case "COLORBOOK":
                return PictographIconType.COLOR_BOOK;

            case "COLORAPPLE":
                return PictographIconType.COLOR_APPLE;

            case "COLORBALL":
                return PictographIconType.COLOR_BALL;

            case "COLORFLOWER":
                return PictographIconType.COLOR_FLOWER;

            case "COLORICECREAM":
                return PictographIconType.COLOR_ICE_CREAM;

            case "PNGBOOK":
                return PictographIconType.PNG_BOOK;

            case "PNGFRUIT":
                return PictographIconType.PNG_FRUIT;

            case "PNGBALL":
                return PictographIconType.PNG_BALL;

            case "PNGFLOWER":
                return PictographIconType.PNG_FLOWER;

            case "PNGICECREAM":
                return PictographIconType.PNG_ICE_CREAM;

            case "PNGPERSON":
                return PictographIconType.PNG_PERSON;

            case "PNGPETS":
                return PictographIconType.PNG_PETS;

            case "TREE":
                return PictographIconType.TREE;

            case "PNGBAG":
                return PictographIconType.PNG_BAG;

            case "PNGBIRD":
                return PictographIconType.PNG_BIRD;

            case "PNGBICYCLE":
                return PictographIconType.PNG_BICYCLE;

            case "PNGVEHICLE":
                return PictographIconType.PNG_VEHICLE;

            default:
                return PictographIconType.TRIANGLE;
        }
    }
}