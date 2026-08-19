package com.myAgeEducation.cbseClass4.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ImageCodeBuilder
{
    private final String prefix;

    private final Map<String, String> values =
            new LinkedHashMap<>();

    public ImageCodeBuilder(String prefix)
    {
        this.prefix = prefix;
    }

    public ImageCodeBuilder add(
            String key,
            Object value)
    {
        values.put(
                key,
                String.valueOf(value));

        return this;
    }

    public String build()
    {
        StringBuilder builder =
                new StringBuilder();

        if (prefix != null &&
                !prefix.isEmpty())
        {
            builder.append(prefix);
        }

        for (Map.Entry<String, String> entry : values.entrySet())
        {
            builder.append("_")
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue());
        }

        return builder.toString();
    }
}