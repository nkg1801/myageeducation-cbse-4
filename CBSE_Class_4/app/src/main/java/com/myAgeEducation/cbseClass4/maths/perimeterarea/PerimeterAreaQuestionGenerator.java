package com.myAgeEducation.cbseClass4.maths.perimeterarea;

import com.myAgeEducation.cbseClass4.utils.OptionUtils;
import com.myAgeEducation.cbsecommon.Question;
import java.util.*;

public class PerimeterAreaQuestionGenerator {
    private static final Random RANDOM = new Random();

    public static Question generateQuestion() {
        int type = RANDOM.nextInt(5);
        PerimeterAreaQuestionData data;
        switch (type) {
            case 0: data = generateConceptQuestion(); break;
            case 1: data = generatePerimeterSquareQuestion(); break;
            case 2: data = generatePerimeterRectangleQuestion(); break;
            case 3: data = generateAreaComparisonQuestion(); break;
            case 4: data = generatePerimeterComparisonQuestion(); break;
            default: data = generateConceptQuestion();
        }
        return convertToQuestion(data);
    }

    private static PerimeterAreaQuestionData generateConceptQuestion() {
        String[][] concepts = {
            {"The distance around the edge of a figure is its _________", "perimeter", "area", "volume", "length"},
            {"_______ is the amount of surface a figure covers", "area", "perimeter", "boundary", "edge"},
            {"Perimeter of a square = 4 x _________", "side", "area", "length", "width"},
            {"Perimeter of a rectangle = 2 x (length + _________)", "width", "side", "area", "height"},
            {"A _________ is a rectangle with all four sides equal.", "square", "triangle", "circle", "oval"},
            {"To find the perimeter of any figure, we _________ the lengths of all its sides.", "add", "subtract", "multiply", "divide"},
            {"A square has _________ equal sides.", "four", "three", "two", "five"},
            {"In a rectangle, the _________ sides are equal.", "opposite", "all", "adjacent", "no"},
            {"Area is measured in _________ units.", "square", "linear", "cubic", "circular"},
            {"Perimeter is measured in _________ units.", "linear", "square", "cubic", "circular"},
            {"The perimeter of a triangle with sides 3cm, 4cm, and 5cm is _________.", "12 cm", "7 cm", "9 cm", "60 cm"},
            {"If the perimeter of a square is 20 cm, the length of each side is _________.", "5 cm", "4 cm", "10 cm", "80 cm"},
            {"A closed figure made of three line segments is called a _________.", "triangle", "square", "rectangle", "circle"},
            {"Perimeter is a _________ dimensional measurement.", "one", "two", "three", "zero"},
            {"Area is a _________ dimensional measurement.", "two", "one", "three", "four"},
            {"The unit 'sq. cm' is used to measure _________.", "area", "perimeter", "length", "weight"},
            {"We need _________ measurements to find the area of a rectangle.", "two", "one", "three", "four"},
            {"If two figures have the same shape and size, they have _________ area.", "equal", "unequal", "double", "half"},
            {"A _________ does not have a perimeter made of line segments.", "circle", "square", "rectangle", "triangle"},
            {"To find the perimeter of a rectangle, we need its length and _________.", "width", "area", "side", "diagonal"},
            {"Area of a square with side 1 cm is _________.", "1 sq. cm", "1 cm", "4 cm", "4 sq. cm"},
            {"The perimeter of a regular pentagon with side 5 cm is _________.", "25 cm", "20 cm", "30 cm", "5 cm"},
            {"Area of a rectangle = length x _________.", "width", "perimeter", "side", "boundary"},
            {"Standard unit of area is _________.", "square units", "linear units", "meters", "litres"},
            {"A square of side 2 cm has an area of _________.", "4 sq. cm", "4 cm", "8 cm", "2 sq. cm"},
            {"Perimeter of a triangle is the _________ of its three sides.", "sum", "product", "difference", "quotient"},
            {"We use a _________ to measure the length of a small line segment.", "ruler", "weighing scale", "clock", "thermometer"},
            {"Area of a figure _________ if we change its position.", "remains same", "increases", "decreases", "doubles"},
            {"A _________ is a simple closed figure.", "polygon", "open curve", "line", "point"},
            {"Which of these has a larger area?", "A classroom", "A pencil box", "A notebook", "A sharpener"},
            {"Perimeter of a square with side 's' is _________.", "4s", "s x s", "2s", "s + 4"},
            {"To fence a park, we need to know its _________.", "perimeter", "area", "volume", "weight"},
            {"To carpet a room, we need to know its _________.", "area", "perimeter", "height", "length"}
        };
        int idx = RANDOM.nextInt(concepts.length);
        String[] item = concepts[idx];
        String[] options = Arrays.copyOfRange(item, 1, 5);
        List<String> optList = Arrays.asList(options);
        Collections.shuffle(optList);
        return new PerimeterAreaQuestionData(item[0], item[1], optList.toArray(new String[0]), PerimeterAreaQuestionType.CONCEPT);
    }

    private static PerimeterAreaQuestionData generatePerimeterSquareQuestion() {
        int side = RANDOM.nextInt(15) + 2;
        String q = String.format("The length of one side of a square is %d cm. What is the perimeter of the square?", side);
        int perimeter = 4 * side;
        String ans = perimeter + " cm";
        List<String> options = new ArrayList<>();
        options.add(ans);
        options.add((perimeter + 4) + " cm");
        options.add((side * side) + " cm");
        options.add((perimeter - 4) + " cm");
        Collections.shuffle(options);
        return new PerimeterAreaQuestionData(q, ans, options.toArray(new String[0]), PerimeterAreaQuestionType.PERIMETER_SQUARE);
    }

    private static PerimeterAreaQuestionData generatePerimeterRectangleQuestion() {
        int length = RANDOM.nextInt(15) + 5;
        int width = RANDOM.nextInt(length - 2) + 2;
        String unit = RANDOM.nextBoolean() ? "cm" : "inches";
        String q = String.format("A rectangle has a length of %d %s and a width of %d %s. What is the perimeter of the rectangle?", length, unit, width, unit);
        int perimeter = 2 * (length + width);
        String ans = perimeter + " " + unit;
        List<String> options = new ArrayList<>();
        options.add(ans);
        options.add((length + width) + " " + unit);
        options.add((length * width) + " " + unit);
        options.add((perimeter + 2) + " " + unit);
        Collections.shuffle(options);
        return new PerimeterAreaQuestionData(q, ans, options.toArray(new String[0]), PerimeterAreaQuestionType.PERIMETER_RECTANGLE);
    }

    private static PerimeterAreaQuestionData generateAreaComparisonQuestion() {
        String[][] items = {
                {"a football ground", "10000000"},
                {"a mobile phone", "50"},
                {"a 55 inch LED TV", "5000"},
                {"a study table", "10000"},
                {"a postage stamp", "5"},
                {"a classroom door", "20000"},
                {"a city park", "50000000"},
                {"a math textbook", "400"},
                {"a currency note", "100"},
                {"a cricket stadium", "15000000"},
                {"a handkerchief", "600"},
                {"a blackboard", "15000"},
                {"a credit card", "40"},
                {"a pillow", "1200"},
                {"a mouse pad", "300"},
                {"a coin", "4"},
                {"a laptop keyboard", "250"},
                {"a single bed sheet", "30000"},
                {"a swimming pool", "500000"},
                {"an airport", "200000000"},
                {"a fingernail", "1"},
                {"a wall calendar", "1500"},
                {"a computer monitor", "1000"},
                {"a standard brick", "150"},
                {"a large dining table", "30000"},
                {"a state", "5000000000000"},
                {"a country", "50000000000000"},
                {"a continent", "500000000000000"},
                {"a classroom floor", "600000"},
                {"a kitchen sponge", "60"},
                {"a door mat", "2400"},
                {"a towel", "8000"}
        };

        boolean findMax = RANDOM.nextBoolean();
        List<Integer> allIndices = new ArrayList<>();
        for (int i = 0; i < items.length; i++) allIndices.add(i);
        Collections.shuffle(allIndices);

        String[] options = new String[4];
        int targetIdx = -1;
        long targetArea = findMax ? -1 : Long.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int idx = allIndices.get(i);
            options[i] = items[idx][0];
            long area = Long.parseLong(items[idx][1]);
            
            if (findMax) {
                if (area > targetArea) {
                    targetArea = area;
                    targetIdx = i;
                }
            } else {
                if (area < targetArea) {
                    targetArea = area;
                    targetIdx = i;
                }
            }
        }

        String q = findMax ? 
                "Which one of the following occupies maximum area?" : 
                "Which one of the following occupies minimum area?";
        String ans = options[targetIdx];
        return new PerimeterAreaQuestionData(q, ans, options, PerimeterAreaQuestionType.AREA_COMPARISON);
    }

    private static PerimeterAreaQuestionData generatePerimeterComparisonQuestion() {
        boolean max = RANDOM.nextBoolean();
        String q = max ? "Which one of the following has maximum perimeter?" : "Which one of the following has minimum perimeter?";
        
        // Use rectangles with different perimeters
        int[][] rects = new int[4][2];
        Set<Integer> perimeters = new HashSet<>();
        while(perimeters.size() < 4) {
            int l = RANDOM.nextInt(20) + 5;
            int w = RANDOM.nextInt(20) + 5;
            int p = 2 * (l + w);
            if (!perimeters.contains(p)) {
                rects[perimeters.size()][0] = l;
                rects[perimeters.size()][1] = w;
                perimeters.add(p);
            }
        }
        
        String[] options = new String[4];
        int targetIdx = -1;
        int targetVal = max ? -1 : 10000;
        
        for (int i = 0; i < 4; i++) {
            int l = rects[i][0];
            int w = rects[i][1];
            int p = 2 * (l + w);
            options[i] = String.format("Rectangle (L:%d, W:%d)", l, w);
            if (max) {
                if (p > targetVal) {
                    targetVal = p;
                    targetIdx = i;
                }
            } else {
                if (p < targetVal) {
                    targetVal = p;
                    targetIdx = i;
                }
            }
        }
        
        return new PerimeterAreaQuestionData(q, options[targetIdx], options, PerimeterAreaQuestionType.PERIMETER_COMPARISON);
    }

    private static Question convertToQuestion(PerimeterAreaQuestionData data) {
        Question question = new Question();
        question.setQuestion(data.getQuestion());
        question.setAnswer(data.getAnswer());
        OptionUtils.setQuestionOptions(question, data.getOptions());
        return question;
    }
}
