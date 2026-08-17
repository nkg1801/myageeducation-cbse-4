package com.myAgeEducation.cbseClass4.maths.pictograph;

import static com.myAgeEducation.cbseClass4.maths.utils.PersonNameUtil.getDifferentNames;
import com.myAgeEducation.cbseClass4.Util;
import com.myAgeEducation.cbseClass4.maths.utils.ColorUtils;
import com.myAgeEducation.cbseClass4.maths.utils.VehicleNameUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PictographGenerator
{
    private static final Random RANDOM = new Random();
    private static final int[] VALUE_PER_ICON = {2, 5, 10, 20, 50, 100 };
    private static final int MIN_ICONS = 2;
    private static final int MAX_ICONS = 8;

    private static final PictographScenario[] SCENARIOS =
            {
                    //One
                    new PictographScenario(
                            "TEDDYBEARSSOLD",
                            "A toy shop tracked the number of teddy bears sold over three days and the same is shown in the pictograph.",
                            "Friday,Saturday,Sunday",
                            "teddy bear",
                            "teddy bears",
                            "On which day were the maximum teddy bears sold?",
                            "On which day were the fewest teddy bears sold?",
                            "How many teddy bears sold on %s?",
                            "How many more teddy bears were sold on %s than on %s?",
                            "How many teddy bears were sold on %s and %s combined?",
                            "Which two days were the same number of teddy bears sold?",
                            "Find the total number of teddy bears sold during the three days.",
                            "PNGTEDDYBEAR,STAR,PNGTEDDYBEAR,DIAMOND,PNGTEDDYBEAR,TRIANGLE"
                    ),

                    //Two
                    new PictographScenario(
                            "BICYLESRENTAL",
                            "A park rental shop tracked how many bicycles were rented over four days and the same is shown in the pictograph.",
                            "Thursday,Friday,Saturday,Sunday",
                            "bicycle",
                            "bicycles",
                            "On which day were the maximum bicycles rented?",
                            "On which day were the fewest bicycles rented?",
                            "How many bicycles were rented on %s?",
                            "How many more bicycles were rented on %s than on %s?",
                            "How many total bicycles were rented on %s and %s combined?",
                            "Which two days were the same number of bicycles rented?",
                            "Find the total number of bicycles rented during the four days.",
                            "PNG_BICYCLE,STAR,DIAMOND,PNG_BICYCLE,HEART,TRIANGLE,PNG_BICYCLE"
                    ),

                    //Three
                    new PictographScenario(
                            "BICYLESPARKED",
                            "The pictograph shows the number of bicycles parked in a park day wise.",
                            "Monday,Tuesday,Wednesday,Thursday,Friday",
                            "bicycle",
                            "bicycles",
                            "On which day were the maximum bicycles parked?",
                            "On which day were the fewest bicycles parked?",
                            "How many bicycles were parked on %s?",
                            "How many more bicycles were parked on %s than %s",
                            "How many bicycles were parked on %s and %s together?",
                            "Which two days were the same number of bicycles parked?",
                            "Find the total number of bicycles parked during the week.",
                            "PNG_BICYCLE,STAR,DIAMOND,PNG_BICYCLE,HEART,TRIANGLE,PNG_BICYCLE"
                    ),

                    //Four
                    new PictographScenario(
                            "BUSROUTES",
                            "The pictograph shows the number of students travel on different routes.",
                            "Route A, Route B, Route C, Route D",
                            "student",
                            "students",
                            "Which route has the most students?",
                            "Which route has the least students?",
                            "How many students travel on %s?",
                            "How many more students travel on %s than %s?",
                            "How many students use %s and %s together?",
                            "Which two routes is used by the same number of students?",
                            "How many students travel on all routes together?",
                            "PNG_VEHICLE,STAR,DIAMOND,PNG_VEHICLE,TRIANGLE,PNG_VEHICLE,PNG_VEHICLE"
                    ),

                    //Five
                    new PictographScenario(
                            "BOOKSREAD",
                            "The pictograph shows the number of books read in a month by a group of students.",
                            "Riya,Maya,Piya,Priya",
                            "book",
                            "books",
                            "Who read the most books?",
                            "Who read the fewest books?",
                            "How many books did %s read?",
                            "How many more books did %s read than %s?",
                            "How many books were read by %s and %s altogether?",
                            "Which two students read the same number of books?",
                            "How many books were read by all four students together?",
                            "BOOK,COLOR_BOOK,PNG_BOOK,SQUARE,STAR,CIRCLE,DIAMOND"
                    ),

                    //Six
                    new PictographScenario(
                            "FAVORITEFRUITS",
                            "The pictograph shows the favourite fruits of a group of students.",
                            "Apple,Orange,Mango,Banana",
                            "fruit",
                            "fruits",
                            "Which fruit is liked by the most students?",
                            "Which fruit is liked by the fewest students?",
                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "Which two fruits are liked by the same number of students?",
                            "What is the total number of students represented in the pictograph?",
                            "FRUIT,COLOR_APPLE,SQUARE,STAR,CIRCLE,DIAMOND,PNG_FRUIT,HEART"
                    ),

                    //Seven
                    new PictographScenario(
                            "SCHOOLTRANSPORT",
                            "The pictograph shows how students travel to school.",
                            "Bus,Bicycle,Car,Walking",
                            "student",
                            "students",
                            "Which mode of transport is used by the most students?",
                            "Which mode of transport is used by the fewest students?",
                            "How many students travel to school by %s?",
                            "How many more students travel by %s than by %s?",
                            "How many students travel by %s and %s altogether?",
                            "Which two modes of transport are used by the same number of students?",
                            "How many students are represented in total?",
                            "PNG_VEHICLE,SQUARE,STAR,CIRCLE,DIAMOND,HEART"
                    ),

                    //Eight
                    new PictographScenario(
                            "LIBRARYBOOKS",
                            "The pictograph shows the number of different types of story books in a library.",
                            "Fairy Tales,Adventure, Animal Stories,Mystery",
                            "book",
                            "books",
                            "Which type has the most books?",
                            "Which type has the fewest books?",
                            "How many %s books are there?",
                            "How many more %s books are there than %s books?",
                            "How many %s and %s books are there altogether?",
                            "Which two types have the same number of books?",
                            "How many books are there altogether?",
                            "BOOK,COLOR_BOOK,PNG_BOOK,SQUARE,STAR,CIRCLE,PNG_BOOK,PNG_BOOK"
                    ),

                    //Nine
                    new PictographScenario(
                            "BIRDS",
                            "The pictograph shows the number of different birds seen in a park.",
                            "Sparrows,Parrots,Crows,Pigeons",
                            "bird",
                            "birds",
                            "Which bird was seen the most?",
                            "Which bird was seen the least?",
                            "How many %s were seen?",
                            "How many more %s were seen than %s?",
                            "How many %s and %s were seen altogether?",
                            "Which two types of birds were seen in equal numbers?",
                            "What is the total number of birds seen?",
                            "PNG_BIRD,PNG_BIRD,STAR,CIRCLE,TRIANGLE,PNG_BIRD"
                    ),

                    //Ten
                    new PictographScenario(
                            "BAGS",
                            "The pictograph shows the number of students having different coloured school bags.",
                            "Green,Red,Pink,Yellow",
                            "student",
                            "students",
                            "Which bag colour is the most popular?",
                            "Which bag colour is the least popular?",
                            "How many students have %s bags?",
                            "How many more students have %s bags than %s bags?",
                            "How many students have %s and %s bags altogether?",
                            "Which two bag colours are equally popular?",
                            "How many students are shown in total?",
                            "PNG_BAG,SQUARE,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //11
                    new PictographScenario(
                            "TREES",
                            "The pictograph shows the number of trees planted by four classes.",
                            "Class 1,Class 2,Class 3,Class 4",
                            "tree",
                            "trees",
                            "Which class planted the most trees?",
                            "Which class planted the fewest trees?",
                            "How many trees did %s plant?",
                            "How many more trees did %s plant than %s?",
                            "How many trees did %s and %s plant altogether?",
                            "Which two classes planted the same number of trees?",
                            "What is the total number of trees planted?",
                            "TREE,SQUARE,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //12
                    new PictographScenario(
                            "PETS",
                            "The pictograph shows the number of different pets.",
                            "Dog,Cat,Rabbit,Fish",
                            "pet",
                            "pets",
                            "Which pet is the most common?",
                            "Which pet is the least common?",
                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "Which two types of pets are equal in number?",
                            "What is the total number of pets?",
                            "PNG_PETS,SQUARE,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //13
                    new PictographScenario(
                            "ICECREAM",
                            "The pictograph shows the number of ice-creams sold during a recent fair at your school.",
                            "Vanilla,Chocolate,Strawberry,Mango",
                            "ice-cream",
                            "ice-creams",
                            "Which flavour of ice-cream was sold the most?",
                            "Which flavour of ice-cream was sold the least?",
                            "How many %s ice-creams were sold?",
                            "How many more %s ice-creams were sold than %s ice-creams?",
                            "How many %s and %s ice-creams were sold altogether?",
                            "Which two flavours of ice-cream were sold in equal numbers?",
                            "What is the total number of ice-creams sold?",
                            "ICE_CREAM,PNG_ICE_CREAM,SQUARE,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //14
                    new PictographScenario(
                            "BOOKS",
                            "The pictograph shows the number of books read by four students.",
                            "Manas,Parag,Jitin,Maya",
                            "book",
                            "books",
                            "Who read the most books?",
                            "Who read the fewest books?",
                            "How many books did %s read?",
                            "How many more books did %s read than %s?",
                            "How many books did %s and %s read altogether?",
                            "Which two students read the same number of books?",
                            "What is the total number of books read by all four students?",
                            "BOOK,COLOR_BOOK,PNG_BOOK,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //15
                    new PictographScenario(
                            "CLASSES",
                            "The pictograph shows the number of students in four classes.",
                            "Class-1,Class-2,Class-3,Class-4",
                            "student",
                            "students",
                            "Which class has the most students?",
                            "Which class has the fewest students?",
                            "How many students are there in %s?",
                            "How many more students are there in %s than in %s?",
                            "How many students are there in %s and %s altogether?",
                            "Which two classes have the same number of students?",
                            "What is the total number of students in all four classes?",
                            "FILLED_PERSON,STICK_PERSON,PNG_PERSON,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //16
                    new PictographScenario(
                            "FRUITS",
                            "The pictograph shows the number of fruits sold at a fruit shop.",
                            "Banana,Mango,Apple,Orange",
                            "fruit",
                            "fruits",
                            "Which fruit was sold the most?",
                            "Which fruit was sold the least?",
                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "Which two fruits were sold in equal numbers?",
                            "What is the total number of fruits sold?",
                            "FRUIT,COLOR_APPLE,PNG_FRUIT,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //17
                    new PictographScenario(
                            "SPORTS",
                            "The pictograph shows the favourite sports of a group of students.",
                            "Football,Cricket,Hockey,Tennis", //keeping some default values. it is required as the replacement logic may not execute because of non-existence switch case
                            "student",
                            "students",
                            "Which sport is liked by the most students?",
                            "Which sport is liked by the fewest students?",
                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "Which two sports are liked by the same number of students?",
                            "What is the total number of students represented in the pictograph?",
                            "BALL,PNG_BALL,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //18
                    new PictographScenario(
                            "APPLESEATEN",
                            "The pictograph below shows the number of apples eaten by three friends in a week.",
                            "Aarav, Bhavna, Chetan", //keeping some default values. it is required as the replacement logic may not execute because of non-existence switch case
                            "apple",
                            "apples",
                            "Who ate the most apples",
                            "Who ate the least apples",
                            "How many apples did %s eat?",
                            "How many more apples did %s ate than %s?",
                            "How many apples did %s and %s ate altogether?",
                            "Which two friends ate the same number of apples?",
                            "How many total apples did the three friends eat altogether?",
                            "BALL,PNG_BALL,STAR,CIRCLE,TRIANGLE,DIAMOND"
                    ),

                    //19
                    new PictographScenario(
                            "LIBRARYVISITORS",
                            "The pictograph shows the number of library visitors day wise..",
                            "Monday,Tuesday,Wednesday,Thursday,Friday", //keeping some default values. it is required as the replacement logic may not execute because of non-existence switch case
                            "visitor",
                            "visitors",
                            "Which day had the maximum visitors?",
                            "Which day had the fewest visitors?",
                            "How many visitors came on %s?",
                            "How many more visitors visited on %s than %s?",
                            "How many visitors came on %s and %s together?",
                            "Which two days had the same number of visitors?",
                            "How many visitors came during the week?",
                            "FILLED_PERSON,STICK_PERSON,PNG_PERSON"
                    )
            };

    private static final String[] SPORTS = { "Cricket", "Football", "Tennis", "Badminton", "Hockey", "Basketball", "Volleyball", "Pickleball" };
    private static final String[] CLASS_NAMES = {"Class-1", "Class-2", "Class-3", "Class-4", "Class-5", "Class-6", "Class-7", "Class-8", "Class-9", "Class-10"};
    private static final String[] BIRD_NAMES_IN_PARK = { "Sparrows", "Parrots", "Crows", "Pigeons", "Parakeet", "Myna", "Peacock"};
    private static final String[] FRUIT_NAMES = { "Apples", "Oranges", "Mangoes", "Bananas", "Guavas", "Watermelons", "Papayas", "Pineapples", "Kiwis", "Pomegranates", "Peaches"};
    private static final String[] PET_NAMES = {"Dog", "Cat", "Fish", "Rabbit", "Parrot"};

    private static String[] getPetNames(int count)
    {
        String[] all_names = new String[PET_NAMES.length];
        System.arraycopy(PET_NAMES, 0, all_names, 0, PET_NAMES.length);
        List<String> list = Arrays.asList(all_names);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }

    private static String[] getFruitNames(int count)
    {
        String[] all_names = new String[FRUIT_NAMES.length];
        System.arraycopy(FRUIT_NAMES, 0, all_names, 0, FRUIT_NAMES.length);
        List<String> list = Arrays.asList(all_names);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }

    private static String[] getSportsNames(int count)
    {
        String[] all_names = new String[SPORTS.length];
        System.arraycopy(SPORTS, 0, all_names, 0, SPORTS.length);
        List<String> list = Arrays.asList(all_names);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }

    private static String[] getBirdNames(int count)
    {
        String[] all_names = new String[BIRD_NAMES_IN_PARK.length];
        System.arraycopy(BIRD_NAMES_IN_PARK, 0, all_names, 0, BIRD_NAMES_IN_PARK.length);
        List<String> list = Arrays.asList(all_names);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }

    private static String[] getClassNames(int count)
    {
        String[] all_names = new String[CLASS_NAMES.length];
        System.arraycopy(CLASS_NAMES, 0, all_names, 0, CLASS_NAMES.length);
        List<String> list = Arrays.asList(all_names);
        Collections.shuffle(list);
        List<String> selectedClasses = list.subList(0, count);
        selectedClasses.sort(Comparator.comparingInt(s -> Integer.parseInt(s.substring(s.indexOf('-') + 1))));
        return selectedClasses.toArray(new String[count]);
    }

    private static ArrayList<PictographScenario> getAllScenarios()
    {
        ArrayList<PictographScenario> scenarios = new ArrayList<>();
        Collections.addAll(scenarios, SCENARIOS);
        //scenarios.addAll(Util.DownloadedPictographScenarios);
        return scenarios;
    }

    public static PictographData generate()
    {
        PictographScenario scenario = getAllScenarios().get(RANDOM.nextInt(getAllScenarios().size()));
        int valuePerIcon = VALUE_PER_ICON[RANDOM.nextInt(VALUE_PER_ICON.length)];
        PictographIconType iconType = scenario.getRandomAllowedIconType();

        // replace existing labels with random labels.
        String[] labels = generateLabels(scenario.scenarioCode, scenario.getParsedLabels());

        scenario.setLabelsForPictograph(labels);
        int categoryCount = labels.length;
        int[] iconCounts = new int[categoryCount];

        boolean generateMatchingPair = RANDOM.nextBoolean();

        List<Integer> availableCounts = new ArrayList<>();

        for (int i = MIN_ICONS; i <= MAX_ICONS; i++)
        {
            availableCounts.add(i);
        }

        Collections.shuffle(availableCounts);

        if (generateMatchingPair && categoryCount >= 2)
        {
            // Choose two different categories
            int firstIndex = RANDOM.nextInt(categoryCount);

            int secondIndex;

            do
            {
                secondIndex = RANDOM.nextInt(categoryCount);
            }
            while (secondIndex == firstIndex);

            // Give all categories unique values first
            for (int i = 0; i < categoryCount; i++)
            {
                iconCounts[i] = availableCounts.get(i);
            }

            // Make exactly two categories equal
            iconCounts[secondIndex] = iconCounts[firstIndex];
        }
        else
        {
            // All categories have different values
            for (int i = 0; i < categoryCount; i++)
            {
                iconCounts[i] = availableCounts.get(i);
            }
        }

        return new PictographData(valuePerIcon, iconCounts, scenario, iconType);
    }

    static String[] generateLabels(String scenarioCode, String[] existingLabels)
    {
        switch (scenarioCode)
        {
            case "BIRDS":
                return getBirdNames(existingLabels.length);

            case "BOOKS":
            case "BOOKSREAD":
            case "APPLESEATEN":
                return getDifferentNames(existingLabels.length);

            case "SPORTS":
                return getSportsNames(existingLabels.length);

            case "FRUITS":
            case "FAVORITEFRUITS":
                return getFruitNames(existingLabels.length);

            case "CLASSES":
            case "TREES":
                return getClassNames(existingLabels.length);

            case "PETS":
                return getPetNames(existingLabels.length);

            case "BAGS":
                return ColorUtils.getColorNames(existingLabels.length);

            case "SCHOOLTRANSPORT":
                return VehicleNameUtil.getDifferentVehicles(existingLabels.length);

            default:
                return existingLabels;
        }
    }
}