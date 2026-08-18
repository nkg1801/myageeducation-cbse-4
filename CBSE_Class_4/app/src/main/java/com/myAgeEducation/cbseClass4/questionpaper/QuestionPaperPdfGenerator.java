package com.myAgeEducation.cbseClass4.questionpaper;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;

import com.myAgeEducation.cbseClass4.questionpaper.ImageGeneratorFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QuestionPaperPdfGenerator
{
    private static final String TAG = "PDF";

    // -------------------------------------------------
    // A4 page size
    // -------------------------------------------------

    private static final int PAGE_WIDTH = 595;
    private static final int PAGE_HEIGHT = 842;

    private static final float MARGIN = 40;

    // -------------------------------------------------
    // Text sizes
    // -------------------------------------------------

    private static final float QUESTION_FONT_SIZE = 13;
    private static final float OPTION_FONT_SIZE = 12;
    private static final float SECTION_FONT_SIZE = 15;

    // -------------------------------------------------
    // Spacing
    // -------------------------------------------------

    private static final float QUESTION_GAP = 18;
    private static final float OPTION_GAP = 5;

    private static final float IMAGE_GAP = 10;

    private static final float HEADER_BOTTOM = 150;
    private static final float HEADER_QUESTION_GAP = 30;
    private static final float FOOTER_HEIGHT = 30;

    // -------------------------------------------------
    // Maximum image dimensions
    // -------------------------------------------------

    private static final float IMAGE_MAX_WIDTH = 480;
    private static final float IMAGE_MAX_HEIGHT = 220;


    // =================================================
    // PAGE CONTEXT
    // =================================================

    private static class PdfPageContext
    {
        PdfDocumentHolder holder;

        Canvas canvas;
        Paint paint;

        PdfTestData testData;

        float y;

        int pageNumber;

        PdfPageContext(
                PdfDocumentHolder holder,
                Paint paint,
                PdfTestData testData)
        {
            this.holder = holder;
            this.paint = paint;
            this.testData = testData;

            startNewPage();
        }

        void startNewPage()
        {
            if (holder.page != null)
            {
                holder.document.finishPage(
                        holder.page);

                holder.page = null;
            }

            pageNumber++;

            android.graphics.pdf.PdfDocument.PageInfo pageInfo =
                    new android.graphics.pdf.PdfDocument.PageInfo.Builder(
                            PAGE_WIDTH,
                            PAGE_HEIGHT,
                            pageNumber)
                            .create();

            holder.page =
                    holder.document.startPage(
                            pageInfo);

            canvas = holder.page.getCanvas();
            drawHeader(canvas, paint, testData);
            drawPageNumber(canvas, paint, pageNumber);
            y = HEADER_BOTTOM + HEADER_QUESTION_GAP;
        }

        void finish()
        {
            if (holder.page != null)
            {
                holder.document.finishPage(holder.page);

                holder.page = null;
            }
        }
    }

    // =================================================
    // PDF HOLDER
    // =================================================

    private static class PdfDocumentHolder
    {
        android.graphics.pdf.PdfDocument document;
        android.graphics.pdf.PdfDocument.Page page;

        PdfDocumentHolder(android.graphics.pdf.PdfDocument document)
        {
            this.document = document;
        }
    }

    // =================================================
    // GENERATE PDF
    // =================================================
    static Context _context;
    public static File generate(Context context, PdfTestData testData) throws IOException
    {
        _context = context;
        android.graphics.pdf.PdfDocument document = new android.graphics.pdf.PdfDocument();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        PdfDocumentHolder holder = new PdfDocumentHolder(document);

        PdfPageContext pageContext =
                new PdfPageContext(
                        holder,
                        paint,
                        testData);

        int questionCount =
                Math.min(
                        20,
                        testData.questions.size());

        // -------------------------------------------------
        // Questions 1 - 10 : MCQ
        // -------------------------------------------------

        pageContext.y =
                drawSectionHeadingIfNeeded(
                        pageContext,
                        "Section A - Choose the correct answer");

        for (int i = 0;
             i < Math.min(10, questionCount);
             i++)
        {
            PdfQuestion question =
                    testData.questions.get(i);

            Bitmap bitmap =
                    generateBitmap(question);

            float requiredHeight =
                    getMultipleChoiceQuestionHeight(
                            question,
                            bitmap,
                            paint);

            if (!canFit(
                    pageContext,
                    requiredHeight))
            {
                pageContext.startNewPage();
            }

            drawMultipleChoiceQuestion(
                    pageContext,
                    question,
                    bitmap,
                    i + 1);

            if (bitmap != null)
            {
                bitmap.recycle();
            }
        }

        // -------------------------------------------------
        // Questions 11 - 20 : Written
        // -------------------------------------------------

        if (questionCount > 10)
        {
            float headingHeight =
                    getSectionHeadingHeight();

            if (!canFit(
                    pageContext,
                    headingHeight))
            {
                pageContext.startNewPage();
            }

            pageContext.y =
                    drawSectionHeading(
                            pageContext.canvas,
                            pageContext.paint,
                            "Section B - Write the correct answer",
                            pageContext.y);
        }

        for (int i = 10;
             i < questionCount;
             i++)
        {
            PdfQuestion question =
                    testData.questions.get(i);

            Bitmap bitmap =
                    generateBitmap(question);

            float requiredHeight =
                    getWrittenQuestionHeight(
                            question,
                            bitmap,
                            paint);

            if (!canFit(
                    pageContext,
                    requiredHeight))
            {
                pageContext.startNewPage();
            }

            drawWrittenQuestion(
                    pageContext,
                    question,
                    bitmap,
                    i + 1);

            if (bitmap != null)
            {
                bitmap.recycle();
            }
        }

        pageContext.finish();

        // -------------------------------------------------
        // Save PDF
        // -------------------------------------------------

        File directory =
                context.getExternalFilesDir(
                        "QuestionPapers");

        if (directory == null)
        {
            document.close();

            throw new IOException(
                    "Unable to access QuestionPapers directory");
        }

        if (!directory.exists())
        {
            if (!directory.mkdirs())
            {
                document.close();

                throw new IOException(
                        "Unable to create QuestionPapers directory");
            }
        }

        File pdfFile =
                new File(
                        directory,
                        "QuestionPaper.pdf");

        try (FileOutputStream outputStream =
                     new FileOutputStream(pdfFile))
        {
            document.writeTo(
                    outputStream);
        }

        document.close();

        Log.d(
                TAG,
                "PDF created: "
                        + pdfFile.getAbsolutePath());

        return pdfFile;
    }


    // =================================================
    // GENERATE IMAGE
    // =================================================

    private static Bitmap generateBitmap(PdfQuestion question)
    {
        String imageCode = question.getImageCode();

        if (imageCode == null || imageCode.trim().isEmpty())
        {
            return null;
        }

        try
        {
            return ImageGeneratorFactory.generate(_context, imageCode);
        }
        catch (Exception e)
        {
            Log.e(
                    TAG,
                    "Unable to generate image: "
                            + imageCode,
                    e);

            return null;
        }
    }


    // =================================================
    // PAGE FIT
    // =================================================

    private static boolean canFit(
            PdfPageContext context,
            float requiredHeight)
    {
        float bottomLimit =
                PAGE_HEIGHT - FOOTER_HEIGHT;

        return context.y
                + requiredHeight
                <= bottomLimit;
    }


    // =================================================
    // SECTION HEADING
    // =================================================

    private static float drawSectionHeadingIfNeeded(
            PdfPageContext context,
            String text)
    {
        float height =
                getSectionHeadingHeight();

        if (!canFit(
                context,
                height))
        {
            context.startNewPage();
        }

        return drawSectionHeading(
                context.canvas,
                context.paint,
                text,
                context.y);
    }


    private static float drawSectionHeading(
            Canvas canvas,
            Paint paint,
            String text,
            float y)
    {
        paint.setTypeface(
                Typeface.create(
                        Typeface.DEFAULT,
                        Typeface.BOLD));

        paint.setTextSize(
                SECTION_FONT_SIZE);

        paint.setTextAlign(
                Paint.Align.LEFT);

        canvas.drawText(
                text,
                MARGIN,
                y,
                paint);

        paint.setTypeface(
                Typeface.DEFAULT);

        return y + 25;
    }


    private static float getSectionHeadingHeight()
    {
        return 30;
    }


    // =================================================
    // MCQ HEIGHT
    // =================================================

    private static float getMultipleChoiceQuestionHeight(
            PdfQuestion question,
            Bitmap bitmap,
            Paint paint)
    {
        float height = 0;

        // Question text
        paint.setTextSize(
                QUESTION_FONT_SIZE);

        height +=
                getWrappedTextHeight(
                        question.getQuestion(),
                        paint,
                        PAGE_WIDTH
                                - 2 * MARGIN);

        height += 8;

        // Image
        if (bitmap != null)
        {
            RectF destination =
                    fitBitmap(
                            bitmap,
                            0,
                            0,
                            IMAGE_MAX_WIDTH,
                            IMAGE_MAX_HEIGHT);

            height +=
                    destination.height()
                            + IMAGE_GAP;
        }

        // Options
        String[] options =
                question.getOptions();

        if (options != null)
        {
            paint.setTextSize(
                    OPTION_FONT_SIZE);

            for (int i = 0;
                 i < Math.min(
                         4,
                         options.length);
                 i++)
            {
                String option =
                        getOptionText(
                                i,
                                options[i]);

                height +=
                        getWrappedTextHeight(
                                option,
                                paint,
                                PAGE_WIDTH
                                        - 2 * MARGIN
                                        - 15);

                height += OPTION_GAP;
            }
        }

        return height + QUESTION_GAP;
    }


    // =================================================
    // WRITTEN QUESTION HEIGHT
    // =================================================

    private static float getWrittenQuestionHeight(
            PdfQuestion question,
            Bitmap bitmap,
            Paint paint)
    {
        float height = 0;

        // Question
        paint.setTextSize(
                QUESTION_FONT_SIZE);

        height +=
                getWrappedTextHeight(
                        question.getQuestion(),
                        paint,
                        PAGE_WIDTH
                                - 2 * MARGIN);

        height += 8;

        // Image
        if (bitmap != null)
        {
            RectF destination =
                    fitBitmap(
                            bitmap,
                            0,
                            0,
                            IMAGE_MAX_WIDTH,
                            IMAGE_MAX_HEIGHT);

            height +=
                    destination.height()
                            + IMAGE_GAP;
        }

        // Answer line
        height += 25;

        return height + QUESTION_GAP;
    }


    // =================================================
    // DRAW MCQ QUESTION
    // =================================================

    private static void drawMultipleChoiceQuestion(
            PdfPageContext context,
            PdfQuestion question,
            Bitmap bitmap,
            int questionNumber)
    {
        Canvas canvas =
                context.canvas;

        Paint paint =
                context.paint;

        float x =
                MARGIN;

        float y =
                context.y;

        // -------------------------------------------------
        // Question
        // -------------------------------------------------

        paint.setTypeface(
                Typeface.DEFAULT);

        paint.setTextSize(
                QUESTION_FONT_SIZE);

        paint.setTextAlign(
                Paint.Align.LEFT);

        String questionText =
                questionNumber
                        + ". "
                        + question.getQuestion();

        y =
                drawWrappedText(
                        canvas,
                        paint,
                        questionText,
                        x,
                        y,
                        PAGE_WIDTH
                                - 2 * MARGIN);

        y += 8;

        // -------------------------------------------------
        // Image
        // -------------------------------------------------

        if (bitmap != null)
        {
            RectF destination =
                    fitBitmap(
                            bitmap,
                            x,
                            y,
                            IMAGE_MAX_WIDTH,
                            IMAGE_MAX_HEIGHT);

            canvas.drawBitmap(
                    bitmap,
                    null,
                    destination,
                    paint);

            y =
                    destination.bottom
                            + IMAGE_GAP;
        }

        // -------------------------------------------------
        // Options
        // -------------------------------------------------

        String[] options =
                question.getOptions();

        if (options != null)
        {
            paint.setTextSize(
                    OPTION_FONT_SIZE);

            for (int i = 0;
                 i < Math.min(
                         4,
                         options.length);
                 i++)
            {
                String option =
                        getOptionText(
                                i,
                                options[i]);

                y =
                        drawWrappedText(
                                canvas,
                                paint,
                                option,
                                x + 15,
                                y,
                                PAGE_WIDTH
                                        - 2 * MARGIN
                                        - 15);

                y += OPTION_GAP;
            }
        }

        context.y =
                y + QUESTION_GAP;
    }


    // =================================================
    // DRAW WRITTEN QUESTION
    // =================================================

    private static void drawWrittenQuestion(
            PdfPageContext context,
            PdfQuestion question,
            Bitmap bitmap,
            int questionNumber)
    {
        Canvas canvas =
                context.canvas;

        Paint paint =
                context.paint;

        float x =
                MARGIN;

        float y =
                context.y;

        // -------------------------------------------------
        // Question
        // -------------------------------------------------

        paint.setTypeface(
                Typeface.DEFAULT);

        paint.setTextSize(
                QUESTION_FONT_SIZE);

        paint.setTextAlign(
                Paint.Align.LEFT);

        String questionText =
                questionNumber
                        + ". "
                        + question.getQuestion();

        y =
                drawWrappedText(
                        canvas,
                        paint,
                        questionText,
                        x,
                        y,
                        PAGE_WIDTH
                                - 2 * MARGIN);

        y += 8;

        // -------------------------------------------------
        // Image
        // -------------------------------------------------

        if (bitmap != null)
        {
            RectF destination =
                    fitBitmap(
                            bitmap,
                            x,
                            y,
                            IMAGE_MAX_WIDTH,
                            IMAGE_MAX_HEIGHT);

            canvas.drawBitmap(
                    bitmap,
                    null,
                    destination,
                    paint);

            y =
                    destination.bottom
                            + IMAGE_GAP;
        }

        // -------------------------------------------------
        // Answer line
        // -------------------------------------------------

        paint.setTextSize(
                OPTION_FONT_SIZE);

        canvas.drawText(
                "Answer: ______________________________",
                x,
                y,
                paint);

        y += 25;

        context.y =
                y + QUESTION_GAP;
    }


    // =================================================
    // OPTION TEXT
    // =================================================

    private static String getOptionText(
            int index,
            String option)
    {
        String[] letters =
                {
                        "A. ",
                        "B. ",
                        "C. ",
                        "D. "
                };

        return letters[index]
                + option;
    }


    // =================================================
    // WRAPPED TEXT DRAWING
    // =================================================

    private static float drawWrappedText(
            Canvas canvas,
            Paint paint,
            String text,
            float x,
            float y,
            float maxWidth)
    {
        if (text == null
                || text.trim().isEmpty())
        {
            return y;
        }

        String[] words =
                text.split("\\s+");

        StringBuilder line =
                new StringBuilder();

        float lineHeight =
                paint.getTextSize()
                        + 5;

        for (String word : words)
        {
            String testLine;

            if (line.length() == 0)
            {
                testLine = word;
            }
            else
            {
                testLine =
                        line.toString()
                                + " "
                                + word;
            }

            if (paint.measureText(testLine)
                    > maxWidth)
            {
                if (line.length() > 0)
                {
                    canvas.drawText(
                            line.toString(),
                            x,
                            y,
                            paint);

                    y += lineHeight;
                }

                line =
                        new StringBuilder(word);
            }
            else
            {
                line =
                        new StringBuilder(testLine);
            }
        }

        if (line.length() > 0)
        {
            canvas.drawText(
                    line.toString(),
                    x,
                    y,
                    paint);

            y += lineHeight;
        }

        return y;
    }


    // =================================================
    // WRAPPED TEXT HEIGHT
    // =================================================

    private static float getWrappedTextHeight(
            String text,
            Paint paint,
            float maxWidth)
    {
        if (text == null
                || text.trim().isEmpty())
        {
            return 0;
        }

        String[] words =
                text.split("\\s+");

        StringBuilder line =
                new StringBuilder();

        int lineCount = 0;

        for (String word : words)
        {
            String testLine;

            if (line.length() == 0)
            {
                testLine = word;
            }
            else
            {
                testLine =
                        line.toString()
                                + " "
                                + word;
            }

            if (paint.measureText(testLine)
                    > maxWidth)
            {
                if (line.length() > 0)
                {
                    lineCount++;
                }

                line =
                        new StringBuilder(word);
            }
            else
            {
                line =
                        new StringBuilder(testLine);
            }
        }

        if (line.length() > 0)
        {
            lineCount++;
        }

        float lineHeight =
                paint.getTextSize()
                        + 5;

        return lineCount * lineHeight;
    }


    // =================================================
    // IMAGE FIT
    // =================================================

    private static RectF fitBitmap(
            Bitmap bitmap,
            float left,
            float top,
            float maxWidth,
            float maxHeight)
    {
        float scale =
                Math.min(
                        maxWidth / bitmap.getWidth(),
                        maxHeight / bitmap.getHeight());

        // Reduce all images by 20%
        scale *= 0.80f;

        float width =
                bitmap.getWidth() * scale;

        float height =
                bitmap.getHeight() * scale;

        return new RectF(
                left,
                top,
                left + width,
                top + height);
    }


    // =================================================
    // HEADER
    // =================================================

    private static void drawHeader(
            Canvas canvas,
            Paint paint,
            PdfTestData testData)
    {
        float y =
                MARGIN;

        // -------------------------------------------------
        // Subject
        // -------------------------------------------------

        paint.setTypeface(
                Typeface.create(
                        Typeface.DEFAULT,
                        Typeface.BOLD));

        paint.setTextSize(22);

        paint.setTextAlign(
                Paint.Align.CENTER);

        canvas.drawText(
                testData.subject,
                PAGE_WIDTH / 2f,
                y,
                paint);

        y += 28;

        // -------------------------------------------------
        // Optional title
        // -------------------------------------------------

        if (testData.title != null
                && !testData.title.trim().isEmpty())
        {
            paint.setTextSize(16);

            canvas.drawText(
                    testData.title,
                    PAGE_WIDTH / 2f,
                    y,
                    paint);

            y += 24;
        }

        // -------------------------------------------------
        // Class
        // -------------------------------------------------

        paint.setTextAlign(
                Paint.Align.LEFT);

        paint.setTextSize(12);

        paint.setTypeface(
                Typeface.DEFAULT);

        canvas.drawText(
                "Class: "
                        + testData.className,
                MARGIN,
                y,
                paint);

        // -------------------------------------------------
        // Total marks
        // -------------------------------------------------

        paint.setTextAlign(
                Paint.Align.RIGHT);

        canvas.drawText(
                "Total Marks: "
                        + testData.totalMarks,
                PAGE_WIDTH - MARGIN,
                y,
                paint);

        y += 22;

        // -------------------------------------------------
        // Time
        // -------------------------------------------------

        paint.setTextAlign(
                Paint.Align.LEFT);

        canvas.drawText(
                "Time: "
                        + testData.time,
                MARGIN,
                y,
                paint);

        y += 25;

        // -------------------------------------------------
        // Name
        // -------------------------------------------------

        canvas.drawText(
                "Name: ______________________________",
                MARGIN,
                y,
                paint);

        // -------------------------------------------------
        // Date
        // -------------------------------------------------

        paint.setTextAlign(
                Paint.Align.RIGHT);

        canvas.drawText(
                "Date: ______________",
                PAGE_WIDTH - MARGIN,
                y,
                paint);

        y += 15;

        // -------------------------------------------------
        // Separator
        // -------------------------------------------------

        paint.setStrokeWidth(1);

        canvas.drawLine(
                MARGIN,
                y,
                PAGE_WIDTH - MARGIN,
                y,
                paint);
    }


    // =================================================
    // PAGE NUMBER
    // =================================================

    private static void drawPageNumber(
            Canvas canvas,
            Paint paint,
            int pageNumber)
    {
        paint.setTypeface(
                Typeface.DEFAULT);

        paint.setTextSize(9);

        paint.setTextAlign(
                Paint.Align.CENTER);

        canvas.drawText(
                "Page "
                        + pageNumber,
                PAGE_WIDTH / 2f,
                PAGE_HEIGHT - 20,
                paint);
    }
}