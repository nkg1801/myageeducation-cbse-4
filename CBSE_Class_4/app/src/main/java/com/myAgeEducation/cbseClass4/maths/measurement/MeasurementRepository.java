package com.myAgeEducation.cbseClass4.maths.measurement;

public class MeasurementRepository
{
    // =========================================
    // BASIC UNIT CONVERSIONS
    // =========================================

    public static final MeasurementConversion[] CONVERSIONS =
            {
                    // Length
                    new MeasurementConversion(
                            MeasurementUnit.CENTIMETRE,
                            100,
                            MeasurementUnit.METRE,
                            1),

                    new MeasurementConversion(
                            MeasurementUnit.METRE,
                            1000,
                            MeasurementUnit.KILOMETRE,
                            1),

                    // Weight
                    new MeasurementConversion(
                            MeasurementUnit.GRAM,
                            1000,
                            MeasurementUnit.KILOGRAM,
                            1),

                    // Capacity
                    new MeasurementConversion(
                            MeasurementUnit.MILLILITRE,
                            1000,
                            MeasurementUnit.LITRE,
                            1)
            };


    // =========================================
    // LENGTH EXAMPLES
    // Object → appropriate unit
    // =========================================

    public static final MeasurementExample[] LENGTH_EXAMPLES =
            {
                    new MeasurementExample("length of a pencil", MeasurementUnit.CENTIMETRE),

                    new MeasurementExample("length of a pair of scissors", MeasurementUnit.CENTIMETRE),

                    new MeasurementExample("length of an eraser", MeasurementUnit.CENTIMETRE),

                    new MeasurementExample("height of a building", MeasurementUnit.METRE),

                    new MeasurementExample(
                            "height of a door",
                            MeasurementUnit.METRE),

                    new MeasurementExample(
                            "length of a classroom",
                            MeasurementUnit.METRE),

                    new MeasurementExample(
                            "distance between two cities",
                            MeasurementUnit.KILOMETRE),

                    new MeasurementExample(
                            "distance between two towns",
                            MeasurementUnit.KILOMETRE),

                    new MeasurementExample(
                            "distance between Delhi and Bangalore",
                            MeasurementUnit.KILOMETRE),

                    new MeasurementExample(
                            "distance between Mumbai and Chennai",
                            MeasurementUnit.KILOMETRE),

                    new MeasurementExample(
                            "distance between Kolkata and Delhi",
                            MeasurementUnit.KILOMETRE),

                    new MeasurementExample(
                            "distance between two cities",
                            MeasurementUnit.KILOMETRE),

                    new MeasurementExample(
                            "distance travelled by a train from Delhi to Mumbai",
                            MeasurementUnit.KILOMETRE),

                    new MeasurementExample(
                            "distance between your home and another city",
                            MeasurementUnit.KILOMETRE)
            };


    // =========================================
    // WEIGHT EXAMPLES
    // =========================================

    public static final MeasurementExample[] WEIGHT_EXAMPLES =
            {
                    new MeasurementExample(
                            "weight of an eraser",
                            MeasurementUnit.GRAM),

                    new MeasurementExample(
                            "weight of a chocolate bar",
                            MeasurementUnit.GRAM),

                    new MeasurementExample(
                            "weight of an apple",
                            MeasurementUnit.GRAM),

                    new MeasurementExample(
                            "weight of a bag of rice",
                            MeasurementUnit.KILOGRAM),

                    new MeasurementExample(
                            "weight of a person",
                            MeasurementUnit.KILOGRAM),

                    new MeasurementExample(
                            "weight of a watermelon",
                            MeasurementUnit.KILOGRAM)
            };


    // =========================================
    // CAPACITY EXAMPLES
    // =========================================

    public static final MeasurementExample[] CAPACITY_EXAMPLES =
            {
                    new MeasurementExample(
                            "medicine in a spoon",
                            MeasurementUnit.MILLILITRE),

                    new MeasurementExample(
                            "water in a small medicine bottle",
                            MeasurementUnit.MILLILITRE),

                    new MeasurementExample(
                            "water in a bucket",
                            MeasurementUnit.LITRE),

                    new MeasurementExample(
                            "milk in a large container",
                            MeasurementUnit.LITRE),

                    new MeasurementExample(
                            "water in a water tank",
                            MeasurementUnit.LITRE)
            };


    private MeasurementRepository()
    {
        // Prevent object creation
    }
}