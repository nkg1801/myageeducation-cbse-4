package com.myAgeEducation.cbseClass4.questionpaper;

import android.content.Context;
import android.graphics.Bitmap;

import com.myAgeEducation.cbseClass4.maths.charts.BarChartImageGenerator;
import com.myAgeEducation.cbseClass4.maths.circlegraph.CircleGraphImageGenerator;
import com.myAgeEducation.cbseClass4.maths.pictograph.PictographImageGenerator;
// Add your other generators here

public class ImageGeneratorFactory
{
    public static Bitmap generate(Context context, String imageCode)
    {
        if (imageCode == null || imageCode.trim().isEmpty())
        {
            return null;
        }

        // -----------------------------------------
        // Bar Chart
        // -----------------------------------------

        if (imageCode.startsWith("BARCHART_"))
        {
            return BarChartImageGenerator.generate(imageCode);
        }

        // -----------------------------------------
        // Circle Graph
        // -----------------------------------------

        if (imageCode.startsWith("CIRCLEGRAPH_"))
        {
            return CircleGraphImageGenerator.generate(imageCode);
        }

        if(imageCode.startsWith("PICTOGRAPH_"))
        {
            return PictographImageGenerator.generate(context, imageCode);
        }

        // -----------------------------------------
        // Add other generators here
        // -----------------------------------------

        throw new IllegalArgumentException("Unknown image code: " + imageCode);
    }
}
