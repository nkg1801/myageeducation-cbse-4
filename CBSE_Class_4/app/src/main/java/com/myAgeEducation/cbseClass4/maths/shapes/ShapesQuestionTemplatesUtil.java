package com.myAgeEducation.cbseClass4.maths.shapes;

public class ShapesQuestionTemplatesUtil {
    public static String getTemplate(ShapesQuestionType type) {
        switch (type) {
            case POLYGON_3_SIDES: return "A polygon with 3 line segments is called a ________";
            case POLYGON_4_SIDES: return "A polygon with 4 line segments is called a ________";
            case RECTANGLE_DEFINITION: return "A _______ is a special quadrilateral in which the opposite sides are of equal length";
            case SQUARE_DEFINITION: return "A _______ is a special rectangle in which all four sides are equal";
            case SQUARE_QUADRILATERAL_TF: return "All squares are quadrilaterals. TRUE or FALSE?";
            case TRIANGLE_POLYGON_TF: return "A triangle is a polygon. TRUE or FALSE?";
            case POLYGON_SEGMENTS_TF: return "A polygon is made up of line segments. TRUE or FALSE?";
            case QUADRILATERAL_RECTANGLE_TF: return "All quadrilaterals are rectangles. TRUE or FALSE?";
            case DIAMETER_RADIUS_RELATION: return "The _______ is twice the length of the radius";
            case RADII_EQUAL_TF: return "All the radii of a particular circle are of equal length. TRUE or FALSE?";
            case DIAMETER_HALF_RADIUS_TF: return "The diameter is half the radius. TRUE or FALSE?";
            case DIAMETER_CENTER_TF: return "The diameter goes through the center of the circle. TRUE or FALSE?";
            case CALCULATE_RADIUS: return "What is the radius of a circle whose diameter is %d cm?";
            case CALCULATE_DIAMETER: return "What is the diameter of a circle whose radius is %d cm?";
            case CLOSED_CURVES_POLYGON_TF: return "All closed curves form polygons. TRUE or FALSE?";
            case CIRCUMFERENCE_DEFINITION_TF: return "The circumference of a circle is its length. TRUE or FALSE?";
            case RADIUS_DIAMETER_CENTER_TF: return "The radius and diameter of a circle meet at the center of the circle. TRUE or FALSE?";
            case OTHER_RADII_LENGTH: return "If the length of a radius of a circle is %d cm, what is the length of the other radii of the same circle?";
            case RADIUS_HALF_DIAMETER_TF: return "The radius is half the length of a diameter of a circle. TRUE or FALSE?";
            case SUM_RADII_DIAMETER_TF: return "The sum of the length of 2 radii of a circle is equal to the length of its diameter. TRUE or FALSE?";
            default: return "";
        }
    }
}
