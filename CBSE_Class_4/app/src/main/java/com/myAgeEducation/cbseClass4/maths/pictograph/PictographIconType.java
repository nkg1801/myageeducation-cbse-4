package com.myAgeEducation.cbseClass4.maths.pictograph;

public enum PictographIconType
{
    FILLED_PERSON,
    STICK_PERSON,
    CIRCLE,
    SQUARE,
    STAR,
    ICE_CREAM,

    BOOK,
    FRUIT,
    BALL,
    FLOWER,

    HEART,
    DIAMOND,
    TRIANGLE,

    // New coloured icons
    COLOR_BOOK,
    COLOR_APPLE,
    COLOR_BALL,
    COLOR_FLOWER,
    COLOR_ICE_CREAM,
    TREE,

    PNG_BOOK,
    PNG_FRUIT,
    PNGAPPLES,
    PNG_BALL,
    PNG_FLOWER,
    PNG_ICE_CREAM,
    PNG_PERSON,
    PNG_PETS,
    PNG_BAG,
    PNG_BIRD,
    PNG_BICYCLE,
    PNG_VEHICLE,
    PNGTEDDYBEAR;

    public String getCode()
    {
        switch (this)
        {
            case FILLED_PERSON:
                return "FILLED";

            case STICK_PERSON:
                return "STICK";

            case ICE_CREAM:
                return "ICECREAM";

            case COLOR_BOOK:
                return "COLORBOOK";

            case COLOR_APPLE:
                return "COLORAPPLE";

            case COLOR_BALL:
                return "COLORBALL";

            case COLOR_FLOWER:
                return "COLORFLOWER";

            case COLOR_ICE_CREAM:
                return "COLORICECREAM";

            case PNG_BOOK:
                    return "PNGBOOK";

            case PNG_FRUIT:
                return "PNGFRUIT";

            case PNG_BALL:
                return "PNGBALL";

            case PNG_FLOWER:
                return "PNGFLOWER";

            case PNG_ICE_CREAM:
                return "PNGICECREAM";

            case PNG_PERSON:
                return "PNGPERSON";

            case PNG_PETS:
                return "PNGPETS";

            case PNG_BICYCLE:
                return "PNGBICYCLE";

            case TREE:
                return "TREE";

            case PNG_BAG:
                return "PNGBAG";

            case PNG_BIRD:
                return "PNGBIRD";

            case PNG_VEHICLE:
                return "PNGVEHICLE";

            default:
                return name();
        }
    }
}