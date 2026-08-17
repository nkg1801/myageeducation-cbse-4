package com.myAgeEducation.cbseClass4.maths.utils;


import java.util.HashMap;
import java.util.Map;

public class ImageCodeParser
{
    private ImageCodeParser()
    {
    }

    public static Map<String, String> parse(String imageCode)
    {
        Map<String, String> map = new HashMap<>();

        if (imageCode == null || imageCode.isEmpty())
        {
            return map;
        }

        String[] parts = imageCode.split("_");

        // First part is the image type
        map.put("TYPE", parts[0]);

        // Remaining parts are key=value pairs
        for (int i = 1; i < parts.length; i++)
        {
            String[] pair = parts[i].split("=", 2);
            if (pair.length == 2)
            {
                map.put(pair[0], pair[1]);
            }
        }

        return map;
    }
}