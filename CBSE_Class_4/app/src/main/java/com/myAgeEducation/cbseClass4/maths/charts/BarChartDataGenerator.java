package com.myAgeEducation.cbseClass4.maths.charts;

import com.myAgeEducation.cbseClass4.maths.charts.tabularquestions.IplTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BarChartDataGenerator
{
    private static final Random RANDOM = new Random();

    private static final int MIN_VALUE = 50;
    private static final int MAX_VALUE = 400;
    private static final int VALUE_STEP = 50;

    private static final BarChartScenario[] SCENARIOS =
            {
                    // -------------------------------------------------
                    // 1. IPL TEAMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "IPL",
                            "The chart shows the number of IPL team followers in your school.",

                            new String[]
                                    {
                                            "Chennai Super Kings",
                                            "Kolkata Knight Riders",
                                            "Mumbai Indians",
                                            "Delhi Capitals"
                                    },

                            new String[]
                                    {
                                            "CSK",
                                            "KKR",
                                            "MI",
                                            "DC"
                                    },

                            "follower",
                            "followers",

                            "Which team is the most popular in your school?",
                            "Which team is the least popular in your school?",
                            "Which team is the second most popular in your school?",
                            "Which team is the second least popular in your school?",

                            "How many followers does %s have?",
                            "How many more followers does %s have than %s?",
                            "How many fewer followers does %s have than %s?",
                            "How many followers do %s and %s have altogether?",
                            "What is the total number of followers?"
                    ),

                    // -------------------------------------------------
                    // 2. FAVOURITE FRUITS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FRUITS",
                            "The chart shows the number of students who chose their favourite fruit.",

                            new String[]
                                    {
                                            "Mango",
                                            "Apple",
                                            "Banana",
                                            "Orange"
                                    },

                            new String[]
                                    {
                                            "Mango",
                                            "Apple",
                                            "Banana",
                                            "Orange"
                                    },

                            "student",
                            "students",

                            "Which fruit is the most popular?",
                            "Which fruit is the least popular?",
                            "Which fruit is the second most popular?",
                            "Which fruit is the second least popular?",

                            "How many students chose %s?",
                            "How many more students chose %s than %s?",
                            "How many fewer students chose %s than %s?",
                            "How many students chose %s and %s altogether?",
                            "How many students were surveyed in all?"
                    ),

                    // -------------------------------------------------
                    // 3. FAVOURITE SPORTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SPORTS",
                            "The chart shows the number of students who chose their favourite sport.",

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Badminton",
                                            "Basketball"
                                    },

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Badminton",
                                            "Basketball"
                                    },

                            "student",
                            "students",

                            "Which sport is the most popular?",
                            "Which sport is the least popular?",
                            "Which sport is the second most popular?",
                            "Which sport is the second least popular?",

                            "How many students chose %s?",
                            "How many more students chose %s than %s?",
                            "How many fewer students chose %s than %s?",
                            "How many students chose %s and %s altogether?",
                            "How many students chose a sport in all?"
                    ),

                    // -------------------------------------------------
                    // 4. BOOKS READ
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOOKS",
                            "The chart shows the number of books read by students in one month.",

                            new String[]
                                    {
                                            "Story Books",
                                            "Comics",
                                            "Science Books",
                                            "Poetry Books"
                                    },

                            new String[]
                                    {
                                            "Story",
                                            "Comics",
                                            "Science",
                                            "Poetry"
                                    },

                            "book",
                            "books",

                            "Which type of book was read the most?",
                            "Which type of book was read the least?",
                            "Which type of book was read the second most?",
                            "Which type of book was read the second least?",

                            "How many %s were read?",
                            "How many more %s were read than %s?",
                            "How many fewer %s were read than %s?",
                            "How many %s and %s were read altogether?",
                            "How many books were read in all?"
                    ),

                    // -------------------------------------------------
                    // 5. PETS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PETS",
                            "The chart shows the number of students who have different pets.",

                            new String[]
                                    {
                                            "Dogs",
                                            "Cats",
                                            "Fish",
                                            "Birds"
                                    },

                            new String[]
                                    {
                                            "Dogs",
                                            "Cats",
                                            "Fish",
                                            "Birds"
                                    },

                            "student",
                            "students",

                            "Which pet is owned by the most students?",
                            "Which pet is owned by the least students?",
                            "Which pet is owned by the second most students?",
                            "Which pet is owned by the second least students?",

                            "How many students have %s?",
                            "How many more students have %s than %s?",
                            "How many fewer students have %s than %s?",
                            "How many students have %s or %s altogether?",
                            "How many students have a pet in all?"
                    ),

                    // -------------------------------------------------
                    // 6. SCHOOL TRANSPORT
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TRANSPORT",
                            "The chart shows how students travel to school.",

                            new String[]
                                    {
                                            "School Bus",
                                            "Car",
                                            "Bicycle",
                                            "Walk"
                                    },

                            new String[]
                                    {
                                            "Bus",
                                            "Car",
                                            "Bicycle",
                                            "Walk"
                                    },

                            "student",
                            "students",

                            "Which way of travelling to school is used by the most students?",
                            "Which way of travelling to school is used by the least students?",
                            "Which way is used by the second most students?",
                            "Which way is used by the second least students?",

                            "How many students travel by %s?",
                            "How many more students travel by %s than %s?",
                            "How many fewer students travel by %s than %s?",
                            "How many students travel by %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 7. ICE CREAM FLAVOURS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ICECREAM",
                            "The chart shows the number of children who chose different ice cream flavours.",

                            new String[]
                                    {
                                            "Chocolate",
                                            "Vanilla",
                                            "Strawberry",
                                            "Mango"
                                    },

                            new String[]
                                    {
                                            "Choco",
                                            "Vanilla",
                                            "Strawberry",
                                            "Mango"
                                    },

                            "child",
                            "children",

                            "Which ice cream flavour was chosen by the most children?",
                            "Which ice cream flavour was chosen by the fewest children?",
                            "Which flavour was chosen by the second most children?",
                            "Which flavour was chosen by the second fewest children?",

                            "How many children chose %s ice cream?",
                            "How many more children chose %s than %s?",
                            "How many fewer children chose %s than %s?",
                            "How many children chose %s and %s altogether?",
                            "How many children are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 8. SCHOOL LUNCH
                    // -------------------------------------------------
                    new BarChartScenario(
                            "LUNCH",
                            "The chart shows the number of students who chose different lunch items.",

                            new String[]
                                    {
                                            "Sandwich",
                                            "Rice",
                                            "Noodles",
                                            "Idli"
                                    },

                            new String[]
                                    {
                                            "Sandwich",
                                            "Rice",
                                            "Noodles",
                                            "Idli"
                                    },

                            "student",
                            "students",

                            "Which lunch item was chosen by the most students?",
                            "Which lunch item was chosen by the fewest students?",
                            "Which lunch item was chosen by the second most students?",
                            "Which lunch item was chosen by the second fewest students?",

                            "How many students chose %s?",
                            "How many more students chose %s than %s?",
                            "How many fewer students chose %s than %s?",
                            "How many students chose %s and %s altogether?",
                            "How many students chose lunch in all?"
                    ),

                    // -------------------------------------------------
                    // 9. ANIMALS IN A ZOO
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ZOO",
                            "The chart shows the number of different animals in a zoo.",

                            new String[]
                                    {
                                            "Elephants",
                                            "Lions",
                                            "Monkeys",
                                            "Deer"
                                    },

                            new String[]
                                    {
                                            "Elephant",
                                            "Lion",
                                            "Monkey",
                                            "Deer"
                                    },

                            "animal",
                            "animals",

                            "Which animal has the greatest number?",
                            "Which animal has the smallest number?",
                            "Which animal has the second greatest number?",
                            "Which animal has the second smallest number?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many animals are there in all?"
                    ),

                    // -------------------------------------------------
                    // 10. VEGETABLES SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "VEGETABLES",
                            "The chart shows the number of kilograms of vegetables sold by a shop.",

                            new String[]
                                    {
                                            "Tomatoes",
                                            "Potatoes",
                                            "Carrots",
                                            "Onions"
                                    },

                            new String[]
                                    {
                                            "Tomatoes",
                                            "Potatoes",
                                            "Carrots",
                                            "Onions"
                                    },

                            "kilogram",
                            "kilograms",

                            "Which vegetable was sold the most?",
                            "Which vegetable was sold the least?",
                            "Which vegetable was sold the second most?",
                            "Which vegetable was sold the second least?",

                            "How many kilograms of %s were sold?",
                            "How many more kilograms of %s were sold than %s?",
                            "How many fewer kilograms of %s were sold than %s?",
                            "How many kilograms of %s and %s were sold altogether?",
                            "How many kilograms of vegetables were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 11. DAYS OF THE WEEK
                    // -------------------------------------------------
                    new BarChartScenario(
                            "DAYS",
                            "The chart shows the number of students who came to school on different days.",

                            new String[]
                                    {
                                            "Monday",
                                            "Tuesday",
                                            "Wednesday",
                                            "Thursday"
                                    },

                            new String[]
                                    {
                                            "Mon",
                                            "Tue",
                                            "Wed",
                                            "Thu"
                                    },

                            "student",
                            "students",

                            "On which day did the most students come to school?",
                            "On which day did the fewest students come to school?",
                            "On which day did the second most students come to school?",
                            "On which day did the second fewest students come to school?",

                            "How many students came to school on %s?",
                            "How many more students came to school on %s than %s?",
                            "How many fewer students came to school on %s than %s?",
                            "How many students came to school on %s and %s altogether?",
                            "How many students came to school in all?"
                    ),

                    // -------------------------------------------------
                    // 12. SCHOOL SUBJECTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SUBJECTS",
                            "The chart shows the number of students who like different school subjects.",

                            new String[]
                                    {
                                            "Mathematics",
                                            "Science",
                                            "English",
                                            "Social Studies"
                                    },

                            new String[]
                                    {
                                            "Math",
                                            "Science",
                                            "English",
                                            "Social"
                                    },

                            "student",
                            "students",

                            "Which subject do the most students like?",
                            "Which subject do the fewest students like?",
                            "Which subject is liked by the second most students?",
                            "Which subject is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students like these subjects in all?"
                    ),

                    // -------------------------------------------------
                    // 13. COLOURS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "COLOURS",
                            "The chart shows the number of children who chose different colours.",

                            new String[]
                                    {
                                            "Red",
                                            "Blue",
                                            "Green",
                                            "Yellow"
                                    },

                            new String[]
                                    {
                                            "Red",
                                            "Blue",
                                            "Green",
                                            "Yellow"
                                    },

                            "child",
                            "children",

                            "Which colour was chosen by the most children?",
                            "Which colour was chosen by the fewest children?",
                            "Which colour was chosen by the second most children?",
                            "Which colour was chosen by the second fewest children?",

                            "How many children chose %s?",
                            "How many more children chose %s than %s?",
                            "How many fewer children chose %s than %s?",
                            "How many children chose %s and %s altogether?",
                            "How many children chose these colours in all?"
                    ),

                    // -------------------------------------------------
                    // 14. TOYS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TOYS",
                            "The chart shows the number of children who chose different toys.",

                            new String[]
                                    {
                                            "Car",
                                            "Doll",
                                            "Ball",
                                            "Puzzle"
                                    },

                            new String[]
                                    {
                                            "Car",
                                            "Doll",
                                            "Ball",
                                            "Puzzle"
                                    },

                            "child",
                            "children",

                            "Which toy was chosen by the most children?",
                            "Which toy was chosen by the fewest children?",
                            "Which toy was chosen by the second most children?",
                            "Which toy was chosen by the second fewest children?",

                            "How many children chose a %s?",
                            "How many more children chose a %s than a %s?",
                            "How many fewer children chose a %s than a %s?",
                            "How many children chose a %s and a %s altogether?",
                            "How many children chose these toys in all?"
                    ),

                    // -------------------------------------------------
                    // 15. GAMES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GAMES",
                            "The chart shows the number of children who like different games.",

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Chess",
                                            "Carrom"
                                    },

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Chess",
                                            "Carrom"
                                    },

                            "child",
                            "children",

                            "Which game do the most children like?",
                            "Which game do the fewest children like?",
                            "Which game is liked by the second most children?",
                            "Which game is liked by the second fewest children?",

                            "How many children like %s?",
                            "How many more children like %s than %s?",
                            "How many fewer children like %s than %s?",
                            "How many children like %s and %s altogether?",
                            "How many children like these games in all?"
                    ),

                    // -------------------------------------------------
                    // 16. MONTHLY RAINFALL
                    // -------------------------------------------------
                    new BarChartScenario(
                            "RAINFALL",
                            "The chart shows the rainfall in a town during different months.",

                            new String[]
                                    {
                                            "June",
                                            "July",
                                            "August",
                                            "September"
                                    },

                            new String[]
                                    {
                                            "Jun",
                                            "Jul",
                                            "Aug",
                                            "Sep"
                                    },

                            "millimetre",
                            "millimetres",

                            "Which month had the most rainfall?",
                            "Which month had the least rainfall?",
                            "Which month had the second most rainfall?",
                            "Which month had the second least rainfall?",

                            "How many millimetres of rain fell in %s?",
                            "How many more millimetres of rain fell in %s than %s?",
                            "How many fewer millimetres of rain fell in %s than %s?",
                            "How many millimetres of rain fell in %s and %s altogether?",
                            "How many millimetres of rain fell in all?"
                    ),

                    // -------------------------------------------------
                    // 17. POCKET MONEY
                    // -------------------------------------------------
                    new BarChartScenario(
                            "POCKETMONEY",
                            "The chart shows the pocket money received by four children in a week.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Diya",
                                            "Rohan",
                                            "Meera"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Diya",
                                            "Rohan",
                                            "Meera"
                                    },

                            "rupee",
                            "rupees",

                            "Who received the most pocket money?",
                            "Who received the least pocket money?",
                            "Who received the second most pocket money?",
                            "Who received the second least pocket money?",

                            "How many rupees did %s receive?",
                            "How many more rupees did %s receive than %s?",
                            "How many fewer rupees did %s receive than %s?",
                            "How many rupees did %s and %s receive altogether?",
                            "How much pocket money did the children receive in all?"
                    ),

                    // -------------------------------------------------
                    // 18. FAVOURITE CARTOON CHARACTERS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CARTOONS",
                            "The chart shows the number of children who like different cartoon characters.",

                            new String[]
                                    {
                                            "Mickey Mouse",
                                            "Doraemon",
                                            "Tom",
                                            "Jerry"
                                    },

                            new String[]
                                    {
                                            "Mickey",
                                            "Doraemon",
                                            "Tom",
                                            "Jerry"
                                    },

                            "child",
                            "children",

                            "Which cartoon character is liked by the most children?",
                            "Which cartoon character is liked by the fewest children?",
                            "Which cartoon character is liked by the second most children?",
                            "Which cartoon character is liked by the second fewest children?",

                            "How many children like %s?",
                            "How many more children like %s than %s?",
                            "How many fewer children like %s than %s?",
                            "How many children like %s and %s altogether?",
                            "How many children like these cartoon characters in all?"
                    )
            };


    public static BarChartData generate()
    {
        // Select a random scenario
        BarChartScenario scenario = SCENARIOS[RANDOM.nextInt(SCENARIOS.length)];
        int categoryCount = scenario.labels.length;

        // Create possible values:
        // 100, 200, 300 ... 800
        List<Integer> availableValues = new ArrayList<>();

        for (int value = MIN_VALUE; value <= MAX_VALUE; value += VALUE_STEP)
        {
            availableValues.add(value);
        }

        // Shuffle so every category gets
        // a different random value
        Collections.shuffle(availableValues);

        int[] values = new int[categoryCount];

        for (int i = 0; i < categoryCount; i++)
        {
            values[i] = availableValues.get(i);
        }

        String[] labels;
        String[] displayLabels;

        labels = scenario.labels;
        displayLabels = scenario.displayLabels;

        if(scenario == SCENARIOS[0]) {
            // Special handling for First SCENARIO (IPL teams)
            IplTeam[] teams = getRandomIplTeams();
            for (int i = 0; i < teams.length; i++) {
                labels[i] = teams[i].name;
                displayLabels[i] = teams[i].shortName;
            }
        }

        return new BarChartData(scenario, labels, displayLabels, values);
    }

    private static IplTeam[] getRandomIplTeams()
    {
        List<IplTeam> teams = new ArrayList<>(Arrays.asList(IPL_TEAMS));
        Collections.shuffle(teams);
        return teams.subList(0, 4).toArray(new IplTeam[0]);
    }

    private static final IplTeam[] IPL_TEAMS =
            {
                    new IplTeam("Chennai Super Kings", "CSK"),
                    new IplTeam("Kolkata Knight Riders", "KKR"),
                    new IplTeam("Mumbai Indians", "MI"),
                    new IplTeam("Delhi Capitals", "DC"),
                    new IplTeam("Rajasthan Royals", "RR"),
                    new IplTeam("Royal Challengers Bangalore", "RCB"),
                    new IplTeam("Kings XI Punjab", "KXIP"),
                    new IplTeam("Sunrisers Hyderabad", "SRH")
            };
}
