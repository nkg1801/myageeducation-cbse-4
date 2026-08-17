package com.myAgeEducation.cbseClass4.maths.utils;

import android.graphics.Color;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ColorUtils {

    private static final Random random = new Random();
    private static final String[] COLOR_NAMES = { "Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Pink", "Brown", "Gray", "Black", "White"};

    public static int getRandomColorForWhiteBackground() {
        float hue = random.nextFloat() * 360f;      // Any color
        float saturation = 0.7f + random.nextFloat() * 0.3f; // 70% - 100%
        float value = 0.3f + random.nextFloat() * 0.4f;      // 30% - 70%

        return Color.HSVToColor(new float[]{
                hue,
                saturation,
                value
        });
    }

    public static String[] getColorNames(int count)
    {
        String[] all_names = new String[COLOR_NAMES.length];
        System.arraycopy(COLOR_NAMES, 0, all_names, 0, COLOR_NAMES.length);
        List<String> list = Arrays.asList(all_names);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }
}