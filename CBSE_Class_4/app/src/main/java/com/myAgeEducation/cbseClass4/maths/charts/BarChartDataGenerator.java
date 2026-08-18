package com.myAgeEducation.cbseClass4.maths.charts;

import com.myAgeEducation.cbseClass4.maths.charts.tabularquestions.IplTeam;
import com.myAgeEducation.cbseClass4.maths.utils.PersonNameUtil;

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
                    ),
                    // -------------------------------------------------
                    // 19. SCHOOL & STUDENTS - CLASSROOM ACTIVITIES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ACTIVITIES",
                            "The chart shows the number of students who took part in different classroom activities.",

                            new String[]
                                    {
                                            "Drawing",
                                            "Reading",
                                            "Storytelling",
                                            "Craft"
                                    },

                            new String[]
                                    {
                                            "Drawing",
                                            "Reading",
                                            "Story",
                                            "Craft"
                                    },

                            "student",
                            "students",

                            "Which activity did the most students take part in?",
                            "Which activity did the fewest students take part in?",
                            "Which activity had the second most students?",
                            "Which activity had the second fewest students?",

                            "How many students took part in %s?",
                            "How many more students took part in %s than %s?",
                            "How many fewer students took part in %s than %s?",
                            "How many students took part in %s and %s altogether?",
                            "How many students took part in these activities in all?"
                    ),

                    // -------------------------------------------------
                    // 20. SCHOOL & STUDENTS - SCHOOL CLUBS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CLUBS",
                            "The chart shows the number of students in different school clubs.",

                            new String[]
                                    {
                                            "Science Club",
                                            "Art Club",
                                            "Music Club",
                                            "Sports Club"
                                    },

                            new String[]
                                    {
                                            "Science",
                                            "Art",
                                            "Music",
                                            "Sports"
                                    },

                            "student",
                            "students",

                            "Which club has the most students?",
                            "Which club has the fewest students?",
                            "Which club has the second most students?",
                            "Which club has the second fewest students?",

                            "How many students are in the %s?",
                            "How many more students are in the %s than the %s?",
                            "How many fewer students are in the %s than the %s?",
                            "How many students are in the %s and %s altogether?",
                            "How many students are in all the clubs?"
                    ),

                    // -------------------------------------------------
                    // 21. SCHOOL & STUDENTS - LIBRARY VISITS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "LIBRARY",
                            "The chart shows the number of students who visited the school library on different days.",

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

                            "On which day did the most students visit the library?",
                            "On which day did the fewest students visit the library?",
                            "On which day did the second most students visit the library?",
                            "On which day did the second fewest students visit the library?",

                            "How many students visited the library on %s?",
                            "How many more students visited the library on %s than %s?",
                            "How many fewer students visited the library on %s than %s?",
                            "How many students visited the library on %s and %s altogether?",
                            "How many students visited the library in all?"
                    ),

                    // -------------------------------------------------
                    // 22. SCHOOL & STUDENTS - SCHOOL HOUSES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOUSES",
                            "The chart shows the points scored by different school houses.",

                            new String[]
                                    {
                                            "Red House",
                                            "Blue House",
                                            "Green House",
                                            "Yellow House"
                                    },

                            new String[]
                                    {
                                            "Red",
                                            "Blue",
                                            "Green",
                                            "Yellow"
                                    },

                            "point",
                            "points",

                            "Which house scored the most points?",
                            "Which house scored the fewest points?",
                            "Which house scored the second most points?",
                            "Which house scored the second fewest points?",

                            "How many points did %s score?",
                            "How many more points did %s score than %s?",
                            "How many fewer points did %s score than %s?",
                            "How many points did %s and %s score altogether?",
                            "What was the total number of points scored?"
                    ),

                    // -------------------------------------------------
                    // 23. SCHOOL & STUDENTS - SCHOOL EVENTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "EVENTS",
                            "The chart shows the number of students who took part in different school events.",

                            new String[]
                                    {
                                            "Sports Day",
                                            "Science Fair",
                                            "Art Show",
                                            "Music Day"
                                    },

                            new String[]
                                    {
                                            "Sports",
                                            "Science",
                                            "Art",
                                            "Music"
                                    },

                            "student",
                            "students",

                            "Which event had the most students?",
                            "Which event had the fewest students?",
                            "Which event had the second most students?",
                            "Which event had the second fewest students?",

                            "How many students took part in %s?",
                            "How many more students took part in %s than %s?",
                            "How many fewer students took part in %s than %s?",
                            "How many students took part in %s and %s altogether?",
                            "How many students took part in the events in all?"
                    ),

                    // -------------------------------------------------
                    // 24. SCHOOL & STUDENTS - SCHOOL BAGS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SCHOOLBAGS",
                            "The chart shows the number of students using different types of school bags.",

                            new String[]
                                    {
                                            "Backpack",
                                            "Shoulder Bag",
                                            "Trolley Bag",
                                            "Sling Bag"
                                    },

                            new String[]
                                    {
                                            "Backpack",
                                            "Shoulder",
                                            "Trolley",
                                            "Sling"
                                    },

                            "student",
                            "students",

                            "Which type of bag is used by the most students?",
                            "Which type of bag is used by the fewest students?",
                            "Which type of bag is used by the second most students?",
                            "Which type of bag is used by the second fewest students?",

                            "How many students use a %s?",
                            "How many more students use a %s than a %s?",
                            "How many fewer students use a %s than a %s?",
                            "How many students use a %s and a %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 25. SCHOOL & STUDENTS - CLASSROOM PLANTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PLANTS",
                            "The chart shows the number of plants kept by different classes.",

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            "plant",
                            "plants",

                            "Which class has the most plants?",
                            "Which class has the fewest plants?",
                            "Which class has the second most plants?",
                            "Which class has the second fewest plants?",

                            "How many plants does %s have?",
                            "How many more plants does %s have than %s?",
                            "How many fewer plants does %s have than %s?",
                            "How many plants do %s and %s have altogether?",
                            "How many plants are there in all?"
                    ),

                    // -------------------------------------------------
                    // 26. SCHOOL & STUDENTS - NOTEBOOKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "NOTEBOOKS",
                            "The chart shows the number of notebooks collected by different classes.",

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            "notebook",
                            "notebooks",

                            "Which class collected the most notebooks?",
                            "Which class collected the fewest notebooks?",
                            "Which class collected the second most notebooks?",
                            "Which class collected the second fewest notebooks?",

                            "How many notebooks did %s collect?",
                            "How many more notebooks did %s collect than %s?",
                            "How many fewer notebooks did %s collect than %s?",
                            "How many notebooks did %s and %s collect altogether?",
                            "How many notebooks were collected in all?"
                    ),

                    // -------------------------------------------------
                    // 27. SCHOOL & STUDENTS - PENCILS COLLECTED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PENCILS",
                            "The chart shows the number of pencils collected by students in different classes.",

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            "pencil",
                            "pencils",

                            "Which class collected the most pencils?",
                            "Which class collected the fewest pencils?",
                            "Which class collected the second most pencils?",
                            "Which class collected the second fewest pencils?",

                            "How many pencils did %s collect?",
                            "How many more pencils did %s collect than %s?",
                            "How many fewer pencils did %s collect than %s?",
                            "How many pencils did %s and %s collect altogether?",
                            "How many pencils were collected in all?"
                    ),

                    // -------------------------------------------------
                    // 28. SCHOOL & STUDENTS - READING TIME
                    // -------------------------------------------------
                    new BarChartScenario(
                            "READINGTIME",
                            "The chart shows the number of minutes four students spent reading in a week.",

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

                            "minute",
                            "minutes",

                            "Who spent the most time reading?",
                            "Who spent the least time reading?",
                            "Who spent the second most time reading?",
                            "Who spent the second least time reading?",

                            "How many minutes did %s spend reading?",
                            "How many more minutes did %s spend reading than %s?",
                            "How many fewer minutes did %s spend reading than %s?",
                            "How many minutes did %s and %s spend reading altogether?",
                            "How many minutes did the students spend reading in all?"
                    ),

                    // -------------------------------------------------
                    // 29. SCHOOL & STUDENTS - HOMEWORK
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOMEWORK",
                            "The chart shows the number of homework tasks completed by four students.",

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

                            "task",
                            "tasks",

                            "Who completed the most homework tasks?",
                            "Who completed the fewest homework tasks?",
                            "Who completed the second most homework tasks?",
                            "Who completed the second fewest homework tasks?",

                            "How many homework tasks did %s complete?",
                            "How many more homework tasks did %s complete than %s?",
                            "How many fewer homework tasks did %s complete than %s?",
                            "How many homework tasks did %s and %s complete altogether?",
                            "How many homework tasks were completed in all?"
                    ),
                    // -------------------------------------------------
                    // 30. ATTENDANCE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ATTENDANCE",
                            "The chart shows the number of students present in a class on different days.",

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

                            "On which day were the most students present?",
                            "On which day were the fewest students present?",
                            "On which day were the second most students present?",
                            "On which day were the second fewest students present?",

                            "How many students were present on %s?",
                            "How many more students were present on %s than %s?",
                            "How many fewer students were present on %s than %s?",
                            "How many students were present on %s and %s altogether?",
                            "How many students were present in all?"
                    ),

                    // -------------------------------------------------
                    // 31. TEST SCORES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TESTSCORES",
                            "The chart shows the marks scored by four students in a test.",

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

                            "mark",
                            "marks",

                            "Who scored the most marks?",
                            "Who scored the fewest marks?",
                            "Who scored the second most marks?",
                            "Who scored the second fewest marks?",

                            "How many marks did %s score?",
                            "How many more marks did %s score than %s?",
                            "How many fewer marks did %s score than %s?",
                            "How many marks did %s and %s score altogether?",
                            "What is the total of all the marks?"
                    ),

                    // -------------------------------------------------
                    // 32. CLASS PROJECTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PROJECTS",
                            "The chart shows the number of class projects completed by different classes.",

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            "project",
                            "projects",

                            "Which class completed the most projects?",
                            "Which class completed the fewest projects?",
                            "Which class completed the second most projects?",
                            "Which class completed the second fewest projects?",

                            "How many projects did %s complete?",
                            "How many more projects did %s complete than %s?",
                            "How many fewer projects did %s complete than %s?",
                            "How many projects did %s and %s complete altogether?",
                            "How many projects were completed in all?"
                    ),

                    // -------------------------------------------------
                    // 33. SCHOOL CANTEEN SALES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CANTEEN",
                            "The chart shows the number of food items sold at the school canteen.",

                            new String[]
                                    {
                                            "Sandwiches",
                                            "Juice",
                                            "Samosas",
                                            "Idlis"
                                    },

                            new String[]
                                    {
                                            "Sandwich",
                                            "Juice",
                                            "Samosa",
                                            "Idli"
                                    },

                            "item",
                            "items",

                            "Which food item was sold the most?",
                            "Which food item was sold the least?",
                            "Which food item was sold the second most?",
                            "Which food item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many food items were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 34. CLASSROOM RESOURCES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "RESOURCES",
                            "The chart shows the number of different resources in a classroom.",

                            new String[]
                                    {
                                            "Books",
                                            "Charts",
                                            "Maps",
                                            "Models"
                                    },

                            new String[]
                                    {
                                            "Books",
                                            "Charts",
                                            "Maps",
                                            "Models"
                                    },

                            "resource",
                            "resources",

                            "Which resource is there the most?",
                            "Which resource is there the least?",
                            "Which resource is there the second most?",
                            "Which resource is there the second least?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many classroom resources are there in all?"
                    ),

                    // -------------------------------------------------
                    // 35. ART SUPPLIES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ARTSUPPLIES",
                            "The chart shows the number of art supplies used by a class.",

                            new String[]
                                    {
                                            "Crayons",
                                            "Pencils",
                                            "Paint Brushes",
                                            "Colour Papers"
                                    },

                            new String[]
                                    {
                                            "Crayons",
                                            "Pencils",
                                            "Brushes",
                                            "Paper"
                                    },

                            "item",
                            "items",

                            "Which art supply was used the most?",
                            "Which art supply was used the least?",
                            "Which art supply was used the second most?",
                            "Which art supply was used the second least?",

                            "How many %s were used?",
                            "How many more %s were used than %s?",
                            "How many fewer %s were used than %s?",
                            "How many %s and %s were used altogether?",
                            "How many art supplies were used in all?"
                    ),

                    // -------------------------------------------------
                    // 36. SCHOOL UNIFORMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "UNIFORMS",
                            "The chart shows the number of school uniforms of different sizes.",

                            new String[]
                                    {
                                            "Small",
                                            "Medium",
                                            "Large",
                                            "Extra Large"
                                    },

                            new String[]
                                    {
                                            "Small",
                                            "Medium",
                                            "Large",
                                            "XL"
                                    },

                            "uniform",
                            "uniforms",

                            "Which size has the most uniforms?",
                            "Which size has the fewest uniforms?",
                            "Which size has the second most uniforms?",
                            "Which size has the second fewest uniforms?",

                            "How many %s uniforms are there?",
                            "How many more %s uniforms are there than %s uniforms?",
                            "How many fewer %s uniforms are there than %s uniforms?",
                            "How many %s and %s uniforms are there altogether?",
                            "How many uniforms are there in all?"
                    ),

                    // -------------------------------------------------
                    // 37. SCHOOL ASSEMBLIES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ASSEMBLIES",
                            "The chart shows the number of students who took part in different school assemblies.",

                            new String[]
                                    {
                                            "Morning Prayer",
                                            "Storytelling",
                                            "Quiz",
                                            "Music"
                                    },

                            new String[]
                                    {
                                            "Prayer",
                                            "Story",
                                            "Quiz",
                                            "Music"
                                    },

                            "student",
                            "students",

                            "Which assembly had the most students?",
                            "Which assembly had the fewest students?",
                            "Which assembly had the second most students?",
                            "Which assembly had the second fewest students?",

                            "How many students took part in %s?",
                            "How many more students took part in %s than %s?",
                            "How many fewer students took part in %s than %s?",
                            "How many students took part in %s and %s altogether?",
                            "How many students took part in the assemblies in all?"
                    ),

                    // -------------------------------------------------
                    // 38. CLASS MONITORS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MONITORS",
                            "The chart shows the number of students who volunteered to be class monitors in different classes.",

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            "student",
                            "students",

                            "Which class had the most student volunteers?",
                            "Which class had the fewest student volunteers?",
                            "Which class had the second most student volunteers?",
                            "Which class had the second fewest student volunteers?",

                            "How many students volunteered in %s?",
                            "How many more students volunteered in %s than %s?",
                            "How many fewer students volunteered in %s than %s?",
                            "How many students volunteered in %s and %s altogether?",
                            "How many students volunteered in all?"
                    ),

                    // -------------------------------------------------
                    // 39. SCIENCE EXPERIMENTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "EXPERIMENTS",
                            "The chart shows the number of science experiments completed by different groups.",

                            new String[]
                                    {
                                            "Group 1",
                                            "Group 2",
                                            "Group 3",
                                            "Group 4"
                                    },

                            new String[]
                                    {
                                            "Group 1",
                                            "Group 2",
                                            "Group 3",
                                            "Group 4"
                                    },

                            "experiment",
                            "experiments",

                            "Which group completed the most experiments?",
                            "Which group completed the fewest experiments?",
                            "Which group completed the second most experiments?",
                            "Which group completed the second fewest experiments?",

                            "How many experiments did %s complete?",
                            "How many more experiments did %s complete than %s?",
                            "How many fewer experiments did %s complete than %s?",
                            "How many experiments did %s and %s complete altogether?",
                            "How many experiments were completed in all?"
                    ),
                    // -------------------------------------------------
                    // 40. FAVOURITE VEGETABLES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "VEGETABLES",
                            "The chart shows the favourite vegetables of students in a class.",

                            new String[]
                                    {
                                            "Carrot",
                                            "Potato",
                                            "Tomato",
                                            "Cabbage"
                                    },

                            new String[]
                                    {
                                            "Carrot",
                                            "Potato",
                                            "Tomato",
                                            "Cabbage"
                                    },

                            "student",
                            "students",

                            "Which vegetable is liked by the most students?",
                            "Which vegetable is liked by the fewest students?",
                            "Which vegetable is liked by the second most students?",
                            "Which vegetable is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 41. FAVOURITE SNACKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SNACKS",
                            "The chart shows the favourite snacks of students in a class.",

                            new String[]
                                    {
                                            "Samosa",
                                            "Sandwich",
                                            "Popcorn",
                                            "Biscuits"
                                    },

                            new String[]
                                    {
                                            "Samosa",
                                            "Sandwich",
                                            "Popcorn",
                                            "Biscuits"
                                    },

                            "student",
                            "students",

                            "Which snack is liked by the most students?",
                            "Which snack is liked by the fewest students?",
                            "Which snack is liked by the second most students?",
                            "Which snack is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 42. FAVOURITE DRINKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "DRINKS",
                            "The chart shows the favourite drinks of students in a class.",

                            new String[]
                                    {
                                            "Milk",
                                            "Juice",
                                            "Lemonade",
                                            "Coconut Water"
                                    },

                            new String[]
                                    {
                                            "Milk",
                                            "Juice",
                                            "Lemonade",
                                            "Coconut"
                                    },

                            "student",
                            "students",

                            "Which drink is liked by the most students?",
                            "Which drink is liked by the fewest students?",
                            "Which drink is liked by the second most students?",
                            "Which drink is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 43. FRUITS SOLD AT A SHOP
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FRUITS",
                            "The chart shows the number of fruits sold at a shop.",

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Oranges",
                                            "Mangoes"
                                    },

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Oranges",
                                            "Mangoes"
                                    },

                            "fruit",
                            "fruits",

                            "Which fruit was sold the most?",
                            "Which fruit was sold the least?",
                            "Which fruit was sold the second most?",
                            "Which fruit was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many fruits were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 44. ICE CREAMS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ICECREAM",
                            "The chart shows the number of ice creams of different flavours sold at a shop.",

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            "ice cream",
                            "ice creams",

                            "Which flavour of ice cream was sold the most?",
                            "Which flavour of ice cream was sold the least?",
                            "Which flavour of ice cream was sold the second most?",
                            "Which flavour of ice cream was sold the second least?",

                            "How many %s ice creams were sold?",
                            "How many more %s ice creams were sold than %s?",
                            "How many fewer %s ice creams were sold than %s?",
                            "How many %s and %s ice creams were sold altogether?",
                            "How many ice creams were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 45. BAKERY ITEMS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BAKERY",
                            "The chart shows the number of bakery items sold at a shop.",

                            new String[]
                                    {
                                            "Bread",
                                            "Buns",
                                            "Cakes",
                                            "Cookies"
                                    },

                            new String[]
                                    {
                                            "Bread",
                                            "Buns",
                                            "Cakes",
                                            "Cookies"
                                    },

                            "item",
                            "items",

                            "Which bakery item was sold the most?",
                            "Which bakery item was sold the least?",
                            "Which bakery item was sold the second most?",
                            "Which bakery item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many bakery items were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 46. BOOKS SOLD AT A SHOP
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOOKS",
                            "The chart shows the number of books of different types sold at a book shop.",

                            new String[]
                                    {
                                            "Story Books",
                                            "Comics",
                                            "Science Books",
                                            "Activity Books"
                                    },

                            new String[]
                                    {
                                            "Stories",
                                            "Comics",
                                            "Science",
                                            "Activity"
                                    },

                            "book",
                            "books",

                            "Which type of book was sold the most?",
                            "Which type of book was sold the least?",
                            "Which type of book was sold the second most?",
                            "Which type of book was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many books were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 47. SCHOOL CANTEEN SALES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CANTEEN",
                            "The chart shows the number of food items sold in the school canteen.",

                            new String[]
                                    {
                                            "Sandwiches",
                                            "Juice",
                                            "Samosas",
                                            "Idlis"
                                    },

                            new String[]
                                    {
                                            "Sandwiches",
                                            "Juice",
                                            "Samosas",
                                            "Idlis"
                                    },

                            "item",
                            "items",

                            "Which food item was sold the most?",
                            "Which food item was sold the least?",
                            "Which food item was sold the second most?",
                            "Which food item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many food items were sold in all?"
                    ),
                    // -------------------------------------------------
                    // 48. ICE CREAMS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ICECREAM",
                            "The chart shows the number of ice creams of different flavours sold at a shop.",

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            "ice cream",
                            "ice creams",

                            "Which ice cream flavour was sold the most?",
                            "Which ice cream flavour was sold the least?",
                            "Which ice cream flavour was sold the second most?",
                            "Which ice cream flavour was sold the second least?",

                            "How many %s ice creams were sold?",
                            "How many more %s ice creams were sold than %s ice creams?",
                            "How many fewer %s ice creams were sold than %s ice creams?",
                            "How many %s and %s ice creams were sold altogether?",
                            "How many ice creams were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 49. BOOKS SOLD AT A SHOP
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOOKS",
                            "The chart shows the number of books of different types sold at a book shop.",

                            new String[]
                                    {
                                            "Story Books",
                                            "Comics",
                                            "Science Books",
                                            "Activity Books"
                                    },

                            new String[]
                                    {
                                            "Story",
                                            "Comics",
                                            "Science",
                                            "Activity"
                                    },

                            "book",
                            "books",

                            "Which type of book was sold the most?",
                            "Which type of book was sold the least?",
                            "Which type of book was sold the second most?",
                            "Which type of book was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many books were sold in all?"
                    ),
                    // -------------------------------------------------
                    // 50. FAVOURITE SPORTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SPORTS",
                            "The chart shows the favourite sports of students in a class.",

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Badminton"
                                    },

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Badminton"
                                    },

                            "student",
                            "students",

                            "Which sport is liked by the most students?",
                            "Which sport is liked by the fewest students?",
                            "Which sport is liked by the second most students?",
                            "Which sport is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 51. GOALS SCORED BY TEAMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GOALS",
                            "The chart shows the number of goals scored by different teams.",

                            new String[]
                                    {
                                            "Tigers",
                                            "Lions",
                                            "Eagles",
                                            "Sharks"
                                    },

                            new String[]
                                    {
                                            "Tigers",
                                            "Lions",
                                            "Eagles",
                                            "Sharks"
                                    },

                            "goal",
                            "goals",

                            "Which team scored the most goals?",
                            "Which team scored the fewest goals?",
                            "Which team scored the second most goals?",
                            "Which team scored the second fewest goals?",

                            "How many goals did %s score?",
                            "How many more goals did %s score than %s?",
                            "How many fewer goals did %s score than %s?",
                            "How many goals did %s and %s score altogether?",
                            "How many goals were scored in all?"
                    ),

                    // -------------------------------------------------
                    // 52. RUNS SCORED IN MATCHES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "RUNS",
                            "The chart shows the runs scored by four players in a cricket match.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Rohan",
                                            "Kabir",
                                            "Vihaan"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Rohan",
                                            "Kabir",
                                            "Vihaan"
                                    },

                            "run",
                            "runs",

                            "Who scored the most runs?",
                            "Who scored the fewest runs?",
                            "Who scored the second most runs?",
                            "Who scored the second fewest runs?",

                            "How many runs did %s score?",
                            "How many more runs did %s score than %s?",
                            "How many fewer runs did %s score than %s?",
                            "How many runs did %s and %s score altogether?",
                            "How many runs were scored in all?"
                    ),

                    // -------------------------------------------------
                    // 53. MEDALS WON BY TEAMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MEDALS",
                            "The chart shows the number of medals won by different school teams.",

                            new String[]
                                    {
                                            "Red Team",
                                            "Blue Team",
                                            "Green Team",
                                            "Yellow Team"
                                    },

                            new String[]
                                    {
                                            "Red",
                                            "Blue",
                                            "Green",
                                            "Yellow"
                                    },

                            "medal",
                            "medals",

                            "Which team won the most medals?",
                            "Which team won the fewest medals?",
                            "Which team won the second most medals?",
                            "Which team won the second fewest medals?",

                            "How many medals did %s win?",
                            "How many more medals did %s win than %s?",
                            "How many fewer medals did %s win than %s?",
                            "How many medals did %s and %s win altogether?",
                            "How many medals were won in all?"
                    ),

                    // -------------------------------------------------
                    // 54. FAVOURITE INDOOR GAMES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "INDOORGAMES",
                            "The chart shows the favourite indoor games of students.",

                            new String[]
                                    {
                                            "Chess",
                                            "Carrom",
                                            "Ludo",
                                            "Table Tennis"
                                    },

                            new String[]
                                    {
                                            "Chess",
                                            "Carrom",
                                            "Ludo",
                                            "Table Tennis"
                                    },

                            "student",
                            "students",

                            "Which indoor game is liked by the most students?",
                            "Which indoor game is liked by the fewest students?",
                            "Which indoor game is liked by the second most students?",
                            "Which indoor game is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 55. FAVOURITE OUTDOOR GAMES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "OUTDOORGAMES",
                            "The chart shows the favourite outdoor games of students.",

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Hockey"
                                    },

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Hockey"
                                    },

                            "student",
                            "students",

                            "Which outdoor game is liked by the most students?",
                            "Which outdoor game is liked by the fewest students?",
                            "Which outdoor game is liked by the second most students?",
                            "Which outdoor game is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 56. SPORTS EQUIPMENT
                    // -------------------------------------------------
                    new BarChartScenario(
                            "EQUIPMENT",
                            "The chart shows the number of different sports items in a school.",

                            new String[]
                                    {
                                            "Cricket Bats",
                                            "Football",
                                            "Basketballs",
                                            "Badminton Rackets"
                                    },

                            new String[]
                                    {
                                            "Bats",
                                            "Football",
                                            "Basketballs",
                                            "Rackets"
                                    },

                            "item",
                            "items",

                            "Which sports item is there the most?",
                            "Which sports item is there the least?",
                            "Which sports item is there the second most?",
                            "Which sports item is there the second least?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many sports items are there in all?"
                    ),

                    // -------------------------------------------------
                    // 57. PLAYERS IN DIFFERENT TEAMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PLAYERS",
                            "The chart shows the number of players in different school teams.",

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Hockey"
                                    },

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Hockey"
                                    },

                            "player",
                            "players",

                            "Which team has the most players?",
                            "Which team has the fewest players?",
                            "Which team has the second most players?",
                            "Which team has the second fewest players?",

                            "How many players are in the %s team?",
                            "How many more players are in the %s team than the %s team?",
                            "How many fewer players are in the %s team than the %s team?",
                            "How many players are in the %s and %s teams altogether?",
                            "How many players are there in all?"
                    ),
                    // -------------------------------------------------
                    // 58. MONTHLY TEMPERATURE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TEMPERATURE",
                            "The chart shows the temperature in a town during different months.",

                            new String[]
                                    {
                                            "January",
                                            "April",
                                            "July",
                                            "October"
                                    },

                            new String[]
                                    {
                                            "Jan",
                                            "Apr",
                                            "Jul",
                                            "Oct"
                                    },

                            "degree",
                            "degrees",

                            "Which month had the highest temperature?",
                            "Which month had the lowest temperature?",
                            "Which month had the second highest temperature?",
                            "Which month had the second lowest temperature?",

                            "What was the temperature in %s?",
                            "How many degrees higher was the temperature in %s than in %s?",
                            "How many degrees lower was the temperature in %s than in %s?",
                            "What was the total temperature in %s and %s?",
                            "What was the total of the temperatures in all four months?"
                    ),

                    // -------------------------------------------------
                    // 59. MONTHLY RAINFALL
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
                            "How many more millimetres of rain fell in %s than in %s?",
                            "How many fewer millimetres of rain fell in %s than in %s?",
                            "How many millimetres of rain fell in %s and %s altogether?",
                            "How many millimetres of rain fell in all?"
                    ),

                    // -------------------------------------------------
                    // 60. TREES PLANTED BY CLASSES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TREES",
                            "The chart shows the number of trees planted by different classes.",

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            "tree",
                            "trees",

                            "Which class planted the most trees?",
                            "Which class planted the fewest trees?",
                            "Which class planted the second most trees?",
                            "Which class planted the second fewest trees?",

                            "How many trees did %s plant?",
                            "How many more trees did %s plant than %s?",
                            "How many fewer trees did %s plant than %s?",
                            "How many trees did %s and %s plant altogether?",
                            "How many trees were planted in all?"
                    ),

                    // -------------------------------------------------
                    // 61. FLOWERS IN A GARDEN
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FLOWERS",
                            "The chart shows the number of different flowers in a garden.",

                            new String[]
                                    {
                                            "Roses",
                                            "Sunflowers",
                                            "Tulips",
                                            "Lotus"
                                    },

                            new String[]
                                    {
                                            "Roses",
                                            "Sunflowers",
                                            "Tulips",
                                            "Lotus"
                                    },

                            "flower",
                            "flowers",

                            "Which type of flower is there the most?",
                            "Which type of flower is there the least?",
                            "Which type of flower is there the second most?",
                            "Which type of flower is there the second least?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many flowers are there in all?"
                    ),

                    // -------------------------------------------------
                    // 62. ANIMALS IN A ZOO
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ZOO",
                            "The chart shows the number of different animals in a zoo.",

                            new String[]
                                    {
                                            "Lions",
                                            "Elephants",
                                            "Monkeys",
                                            "Zebras"
                                    },

                            new String[]
                                    {
                                            "Lions",
                                            "Elephants",
                                            "Monkeys",
                                            "Zebras"
                                    },

                            "animal",
                            "animals",

                            "Which animal is there the most?",
                            "Which animal is there the least?",
                            "Which animal is there the second most?",
                            "Which animal is there the second least?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many animals are there in all?"
                    ),

                    // -------------------------------------------------
                    // 63. BIRDS SEEN IN A PARK
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BIRDS",
                            "The chart shows the number of different birds seen in a park.",

                            new String[]
                                    {
                                            "Parrots",
                                            "Sparrows",
                                            "Pigeons",
                                            "Peacocks"
                                    },

                            new String[]
                                    {
                                            "Parrots",
                                            "Sparrows",
                                            "Pigeons",
                                            "Peacocks"
                                    },

                            "bird",
                            "birds",

                            "Which bird was seen the most?",
                            "Which bird was seen the least?",
                            "Which bird was seen the second most?",
                            "Which bird was seen the second least?",

                            "How many %s were seen?",
                            "How many more %s were seen than %s?",
                            "How many fewer %s were seen than %s?",
                            "How many %s and %s were seen altogether?",
                            "How many birds were seen in all?"
                    ),

                    // -------------------------------------------------
                    // 64. RECYCLING COLLECTED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "RECYCLING",
                            "The chart shows the amount of different recyclable materials collected by a school.",

                            new String[]
                                    {
                                            "Paper",
                                            "Plastic",
                                            "Glass",
                                            "Metal"
                                    },

                            new String[]
                                    {
                                            "Paper",
                                            "Plastic",
                                            "Glass",
                                            "Metal"
                                    },

                            "kilogram",
                            "kilograms",

                            "Which material was collected the most?",
                            "Which material was collected the least?",
                            "Which material was collected the second most?",
                            "Which material was collected the second least?",

                            "How many kilograms of %s were collected?",
                            "How many more kilograms of %s were collected than %s?",
                            "How many fewer kilograms of %s were collected than %s?",
                            "How many kilograms of %s and %s were collected altogether?",
                            "How many kilograms of recyclable material were collected in all?"
                    ),

                    // -------------------------------------------------
                    // 65. WATER USED ON DIFFERENT DAYS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "WATER",
                            "The chart shows the amount of water used by a family on different days.",

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

                            "litre",
                            "litres",

                            "On which day was the most water used?",
                            "On which day was the least water used?",
                            "On which day was the second most water used?",
                            "On which day was the second least water used?",

                            "How many litres of water were used on %s?",
                            "How many more litres of water were used on %s than on %s?",
                            "How many fewer litres of water were used on %s than on %s?",
                            "How many litres of water were used on %s and %s altogether?",
                            "How many litres of water were used in all?"
                    ),
                    // -------------------------------------------------
                    // 66. POCKET MONEY
                    // -------------------------------------------------
                    new BarChartScenario(
                            "POCKETMONEY",
                            "The chart shows the pocket money received by four students in a week.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "rupee",
                            "rupees",

                            "Who received the most pocket money?",
                            "Who received the least pocket money?",
                            "Who received the second most pocket money?",
                            "Who received the second least pocket money?",

                            "How much pocket money did %s receive?",
                            "How many more rupees did %s receive than %s?",
                            "How many fewer rupees did %s receive than %s?",
                            "How much pocket money did %s and %s receive altogether?",
                            "How much pocket money did the four students receive in all?"
                    ),

                    // -------------------------------------------------
                    // 67. TIME SPENT READING
                    // -------------------------------------------------
                    new BarChartScenario(
                            "READINGTIME",
                            "The chart shows the time spent reading by students in a week.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "minute",
                            "minutes",

                            "Who spent the most time reading?",
                            "Who spent the least time reading?",
                            "Who spent the second most time reading?",
                            "Who spent the second least time reading?",

                            "How many minutes did %s spend reading?",
                            "How many more minutes did %s spend reading than %s?",
                            "How many fewer minutes did %s spend reading than %s?",
                            "How many minutes did %s and %s spend reading altogether?",
                            "How many minutes did the four students spend reading in all?"
                    ),

                    // -------------------------------------------------
                    // 68. TIME SPENT PLAYING
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PLAYINGTIME",
                            "The chart shows the time spent playing by students in a week.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "minute",
                            "minutes",

                            "Who spent the most time playing?",
                            "Who spent the least time playing?",
                            "Who spent the second most time playing?",
                            "Who spent the second least time playing?",

                            "How many minutes did %s spend playing?",
                            "How many more minutes did %s spend playing than %s?",
                            "How many fewer minutes did %s spend playing than %s?",
                            "How many minutes did %s and %s spend playing altogether?",
                            "How many minutes did the four students spend playing in all?"
                    ),

                    // -------------------------------------------------
                    // 69. STEPS WALKED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "STEPS",
                            "The chart shows the number of steps walked by four students in a day.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "step",
                            "steps",

                            "Who walked the most steps?",
                            "Who walked the fewest steps?",
                            "Who walked the second most steps?",
                            "Who walked the second fewest steps?",

                            "How many steps did %s walk?",
                            "How many more steps did %s walk than %s?",
                            "How many fewer steps did %s walk than %s?",
                            "How many steps did %s and %s walk altogether?",
                            "How many steps did the four students walk in all?"
                    ),

                    // -------------------------------------------------
                    // 70. TOYS OWNED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TOYS",
                            "The chart shows the number of toys owned by four children.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "toy",
                            "toys",

                            "Who owns the most toys?",
                            "Who owns the fewest toys?",
                            "Who owns the second most toys?",
                            "Who owns the second fewest toys?",

                            "How many toys does %s own?",
                            "How many more toys does %s have than %s?",
                            "How many fewer toys does %s have than %s?",
                            "How many toys do %s and %s have altogether?",
                            "How many toys do the four children have in all?"
                    ),

                    // -------------------------------------------------
                    // 71. STICKERS COLLECTED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "STICKERS",
                            "The chart shows the number of stickers collected by four children.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "sticker",
                            "stickers",

                            "Who collected the most stickers?",
                            "Who collected the fewest stickers?",
                            "Who collected the second most stickers?",
                            "Who collected the second fewest stickers?",

                            "How many stickers did %s collect?",
                            "How many more stickers did %s collect than %s?",
                            "How many fewer stickers did %s collect than %s?",
                            "How many stickers did %s and %s collect altogether?",
                            "How many stickers were collected in all?"
                    ),

                    // -------------------------------------------------
                    // 72. COINS COLLECTED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "COINS",
                            "The chart shows the number of coins collected by four children.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "coin",
                            "coins",

                            "Who collected the most coins?",
                            "Who collected the fewest coins?",
                            "Who collected the second most coins?",
                            "Who collected the second fewest coins?",

                            "How many coins did %s collect?",
                            "How many more coins did %s collect than %s?",
                            "How many fewer coins did %s collect than %s?",
                            "How many coins did %s and %s collect altogether?",
                            "How many coins were collected in all?"
                    ),

                    // -------------------------------------------------
                    // 73. CHORES COMPLETED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CHORES",
                            "The chart shows the number of chores completed by four children.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "chore",
                            "chores",

                            "Who completed the most chores?",
                            "Who completed the fewest chores?",
                            "Who completed the second most chores?",
                            "Who completed the second fewest chores?",

                            "How many chores did %s complete?",
                            "How many more chores did %s complete than %s?",
                            "How many fewer chores did %s complete than %s?",
                            "How many chores did %s and %s complete altogether?",
                            "How many chores were completed in all?"
                    ),

                    // -------------------------------------------------
                    // 74. FAVOURITE COLOURS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "COLOURS",
                            "The chart shows the favourite colours of students in a class.",

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

                            "student",
                            "students",

                            "Which colour is liked by the most students?",
                            "Which colour is liked by the fewest students?",
                            "Which colour is liked by the second most students?",
                            "Which colour is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 75. FAVOURITE CARTOON CHARACTERS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CARTOONS",
                            "The chart shows the favourite cartoon characters of students.",

                            new String[]
                                    {
                                            "Mickey Mouse",
                                            "Tom",
                                            "Doraemon",
                                            "Scooby-Doo"
                                    },

                            new String[]
                                    {
                                            "Mickey",
                                            "Tom",
                                            "Doraemon",
                                            "Scooby-Doo"
                                    },

                            "student",
                            "students",

                            "Which cartoon character is liked by the most students?",
                            "Which cartoon character is liked by the fewest students?",
                            "Which cartoon character is liked by the second most students?",
                            "Which cartoon character is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 76. FAVOURITE SUPERHEROES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SUPERHEROES",
                            "The chart shows the favourite superheroes of students.",

                            new String[]
                                    {
                                            "Superman",
                                            "Batman",
                                            "Spider-Man",
                                            "Hulk"
                                    },

                            new String[]
                                    {
                                            "Superman",
                                            "Batman",
                                            "Spider-Man",
                                            "Hulk"
                                    },

                            "student",
                            "students",

                            "Which superhero is liked by the most students?",
                            "Which superhero is liked by the fewest students?",
                            "Which superhero is liked by the second most students?",
                            "Which superhero is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 77. FAVOURITE BOOKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVBOOKS",
                            "The chart shows the favourite types of books of students.",

                            new String[]
                                    {
                                            "Story Books",
                                            "Comics",
                                            "Adventure Books",
                                            "Science Books"
                                    },

                            new String[]
                                    {
                                            "Story",
                                            "Comics",
                                            "Adventure",
                                            "Science"
                                    },

                            "student",
                            "students",

                            "Which type of book is liked by the most students?",
                            "Which type of book is liked by the fewest students?",
                            "Which type of book is liked by the second most students?",
                            "Which type of book is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 78. FAVOURITE MOVIES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MOVIES",
                            "The chart shows the favourite types of movies of students.",

                            new String[]
                                    {
                                            "Comedy",
                                            "Adventure",
                                            "Animation",
                                            "Fantasy"
                                    },

                            new String[]
                                    {
                                            "Comedy",
                                            "Adventure",
                                            "Animation",
                                            "Fantasy"
                                    },

                            "student",
                            "students",

                            "Which type of movie is liked by the most students?",
                            "Which type of movie is liked by the fewest students?",
                            "Which type of movie is liked by the second most students?",
                            "Which type of movie is liked by the second fewest students?",

                            "How many students like %s movies?",
                            "How many more students like %s movies than %s movies?",
                            "How many fewer students like %s movies than %s movies?",
                            "How many students like %s and %s movies altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 79. FAVOURITE ANIMALS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVANIMALS",
                            "The chart shows the favourite animals of students.",

                            new String[]
                                    {
                                            "Dog",
                                            "Cat",
                                            "Rabbit",
                                            "Elephant"
                                    },

                            new String[]
                                    {
                                            "Dog",
                                            "Cat",
                                            "Rabbit",
                                            "Elephant"
                                    },

                            "student",
                            "students",

                            "Which animal is liked by the most students?",
                            "Which animal is liked by the fewest students?",
                            "Which animal is liked by the second most students?",
                            "Which animal is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 80. FAVOURITE HOBBIES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOBBIES",
                            "The chart shows the favourite hobbies of students.",

                            new String[]
                                    {
                                            "Drawing",
                                            "Reading",
                                            "Dancing",
                                            "Gardening"
                                    },

                            new String[]
                                    {
                                            "Drawing",
                                            "Reading",
                                            "Dancing",
                                            "Gardening"
                                    },

                            "student",
                            "students",

                            "Which hobby is liked by the most students?",
                            "Which hobby is liked by the fewest students?",
                            "Which hobby is liked by the second most students?",
                            "Which hobby is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),

                    // -------------------------------------------------
                    // 81. FAVOURITE MUSICAL INSTRUMENTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "INSTRUMENTS",
                            "The chart shows the favourite musical instruments of students.",

                            new String[]
                                    {
                                            "Piano",
                                            "Guitar",
                                            "Drums",
                                            "Flute"
                                    },

                            new String[]
                                    {
                                            "Piano",
                                            "Guitar",
                                            "Drums",
                                            "Flute"
                                    },

                            "student",
                            "students",

                            "Which instrument is liked by the most students?",
                            "Which instrument is liked by the fewest students?",
                            "Which instrument is liked by the second most students?",
                            "Which instrument is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are shown in the chart?"
                    ),
                    // -------------------------------------------------
                    // 82. HOMEWORK COMPLETED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOMEWORK",
                            "The chart shows the number of homework assignments completed by students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "assignment",
                            "assignments",

                            "Who completed the most assignments?",
                            "Who completed the fewest assignments?",
                            "Who completed the second most assignments?",
                            "Who completed the second fewest assignments?",

                            "How many assignments did %s complete?",
                            "How many more assignments did %s complete than %s?",
                            "How many fewer assignments did %s complete than %s?",
                            "How many assignments did %s and %s complete altogether?",
                            "How many assignments were completed in all?"
                    ),

                    // -------------------------------------------------
                    // 83. BOOKS READ
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOOKSREAD",
                            "The chart shows the number of books read by students in a month.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "book",
                            "books",

                            "Who read the most books?",
                            "Who read the fewest books?",
                            "Who read the second most books?",
                            "Who read the second fewest books?",

                            "How many books did %s read?",
                            "How many more books did %s read than %s?",
                            "How many fewer books did %s read than %s?",
                            "How many books did %s and %s read altogether?",
                            "How many books were read in all?"
                    ),

                    // -------------------------------------------------
                    // 84. LIBRARY BOOKS BORROWED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "LIBRARYBOOKS",
                            "The chart shows the number of books borrowed from the school library by different classes.",

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            new String[]
                                    {
                                            "Class 1",
                                            "Class 2",
                                            "Class 3",
                                            "Class 4"
                                    },

                            "book",
                            "books",

                            "Which class borrowed the most books?",
                            "Which class borrowed the fewest books?",
                            "Which class borrowed the second most books?",
                            "Which class borrowed the second fewest books?",

                            "How many books did %s borrow?",
                            "How many more books did %s borrow than %s?",
                            "How many fewer books did %s borrow than %s?",
                            "How many books did %s and %s borrow altogether?",
                            "How many books were borrowed in all?"
                    ),

                    // -------------------------------------------------
                    // 85. QUESTIONS ANSWERED CORRECTLY
                    // -------------------------------------------------
                    new BarChartScenario(
                            "QUESTIONS",
                            "The chart shows the number of questions answered correctly by students in a test.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "question",
                            "questions",

                            "Who answered the most questions correctly?",
                            "Who answered the fewest questions correctly?",
                            "Who answered the second most questions correctly?",
                            "Who answered the second fewest questions correctly?",

                            "How many questions did %s answer correctly?",
                            "How many more questions did %s answer correctly than %s?",
                            "How many fewer questions did %s answer correctly than %s?",
                            "How many questions did %s and %s answer correctly altogether?",
                            "How many questions were answered correctly in all?"
                    ),

                    // -------------------------------------------------
                    // 86. NEW WORDS LEARNED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "NEWWORDS",
                            "The chart shows the number of new words learned by students in a week.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "word",
                            "words",

                            "Who learned the most new words?",
                            "Who learned the fewest new words?",
                            "Who learned the second most new words?",
                            "Who learned the second fewest new words?",

                            "How many new words did %s learn?",
                            "How many more new words did %s learn than %s?",
                            "How many fewer new words did %s learn than %s?",
                            "How many new words did %s and %s learn altogether?",
                            "How many new words were learned in all?"
                    ),

                    // -------------------------------------------------
                    // 87. SPELLING TEST SCORES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SPELLING",
                            "The chart shows the scores of students in a spelling test.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "mark",
                            "marks",

                            "Who scored the most marks?",
                            "Who scored the fewest marks?",
                            "Who scored the second most marks?",
                            "Who scored the second fewest marks?",

                            "How many marks did %s score?",
                            "How many more marks did %s score than %s?",
                            "How many fewer marks did %s score than %s?",
                            "How many marks did %s and %s score altogether?",
                            "What is the total of the four scores?"
                    ),

                    // -------------------------------------------------
                    // 88. MATH PROBLEMS SOLVED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MATHPROBLEMS",
                            "The chart shows the number of maths problems solved by students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "problem",
                            "problems",

                            "Who solved the most maths problems?",
                            "Who solved the fewest maths problems?",
                            "Who solved the second most maths problems?",
                            "Who solved the second fewest maths problems?",

                            "How many maths problems did %s solve?",
                            "How many more maths problems did %s solve than %s?",
                            "How many fewer maths problems did %s solve than %s?",
                            "How many maths problems did %s and %s solve altogether?",
                            "How many maths problems were solved in all?"
                    ),

                    // -------------------------------------------------
                    // 89. CERTIFICATES EARNED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CERTIFICATES",
                            "The chart shows the number of certificates earned by students during the school year.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "certificate",
                            "certificates",

                            "Who earned the most certificates?",
                            "Who earned the fewest certificates?",
                            "Who earned the second most certificates?",
                            "Who earned the second fewest certificates?",

                            "How many certificates did %s earn?",
                            "How many more certificates did %s earn than %s?",
                            "How many fewer certificates did %s earn than %s?",
                            "How many certificates did %s and %s earn altogether?",
                            "How many certificates were earned in all?"
                    ),

                    // -------------------------------------------------
                    // 90. LIBRARY VISITS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "LIBRARYVISITS",
                            "The chart shows the number of times students visited the school library.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "visit",
                            "visits",

                            "Who visited the library the most?",
                            "Who visited the library the fewest times?",
                            "Who visited the library the second most times?",
                            "Who visited the library the second fewest times?",

                            "How many times did %s visit the library?",
                            "How many more times did %s visit the library than %s?",
                            "How many fewer times did %s visit the library than %s?",
                            "How many library visits did %s and %s make altogether?",
                            "How many library visits were made in all?"
                    ),

                    // -------------------------------------------------
                    // 91. SCHOOL TRIPS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SCHOOLTRIPS",
                            "The chart shows the number of students who went on different school trips.",

                            new String[]
                                    {
                                            "Zoo",
                                            "Museum",
                                            "Science Park",
                                            "Farm"
                                    },

                            new String[]
                                    {
                                            "Zoo",
                                            "Museum",
                                            "Science Park",
                                            "Farm"
                                    },

                            "student",
                            "students",

                            "Which trip had the most students?",
                            "Which trip had the fewest students?",
                            "Which trip had the second most students?",
                            "Which trip had the second fewest students?",

                            "How many students went on the %s trip?",
                            "How many more students went on the %s trip than the %s trip?",
                            "How many fewer students went on the %s trip than the %s trip?",
                            "How many students went on the %s and %s trips altogether?",
                            "How many students went on the four trips in all?"
                    ),
                    // -------------------------------------------------
                    // 92. PENS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PENSSOLD",
                            "The chart shows the number of pens sold at a shop.",

                            new String[]
                                    {
                                            "Blue Pens",
                                            "Black Pens",
                                            "Red Pens",
                                            "Green Pens"
                                    },

                            new String[]
                                    {
                                            "Blue",
                                            "Black",
                                            "Red",
                                            "Green"
                                    },

                            "pen",
                            "pens",

                            "Which type of pen was sold the most?",
                            "Which type of pen was sold the least?",
                            "Which type of pen was sold the second most?",
                            "Which type of pen was sold the second least?",

                            "How many %s pens were sold?",
                            "How many more %s pens were sold than %s pens?",
                            "How many fewer %s pens were sold than %s pens?",
                            "How many %s and %s pens were sold altogether?",
                            "How many pens were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 93. NOTEBOOKS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "NOTEBOOKSSOLD",
                            "The chart shows the number of notebooks sold at a shop.",

                            new String[]
                                    {
                                            "Ruled Notebooks",
                                            "Plain Notebooks",
                                            "Maths Notebooks",
                                            "Drawing Notebooks"
                                    },

                            new String[]
                                    {
                                            "Ruled",
                                            "Plain",
                                            "Maths",
                                            "Drawing"
                                    },

                            "notebook",
                            "notebooks",

                            "Which type of notebook was sold the most?",
                            "Which type of notebook was sold the least?",
                            "Which type of notebook was sold the second most?",
                            "Which type of notebook was sold the second least?",

                            "How many %s notebooks were sold?",
                            "How many more %s notebooks were sold than %s notebooks?",
                            "How many fewer %s notebooks were sold than %s notebooks?",
                            "How many %s and %s notebooks were sold altogether?",
                            "How many notebooks were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 94. GREETING CARDS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CARDS",
                            "The chart shows the number of greeting cards sold at a shop.",

                            new String[]
                                    {
                                            "Birthday Cards",
                                            "Thank You Cards",
                                            "Festival Cards",
                                            "Friendship Cards"
                                    },

                            new String[]
                                    {
                                            "Birthday",
                                            "Thank You",
                                            "Festival",
                                            "Friendship"
                                    },

                            "card",
                            "cards",

                            "Which type of card was sold the most?",
                            "Which type of card was sold the least?",
                            "Which type of card was sold the second most?",
                            "Which type of card was sold the second least?",

                            "How many %s cards were sold?",
                            "How many more %s cards were sold than %s cards?",
                            "How many fewer %s cards were sold than %s cards?",
                            "How many %s and %s cards were sold altogether?",
                            "How many cards were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 95. T-SHIRTS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TSHIRTS",
                            "The chart shows the number of T-shirts sold in different colours.",

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

                            "T-shirt",
                            "T-shirts",

                            "Which colour of T-shirt was sold the most?",
                            "Which colour of T-shirt was sold the least?",
                            "Which colour of T-shirt was sold the second most?",
                            "Which colour of T-shirt was sold the second least?",

                            "How many %s T-shirts were sold?",
                            "How many more %s T-shirts were sold than %s T-shirts?",
                            "How many fewer %s T-shirts were sold than %s T-shirts?",
                            "How many %s and %s T-shirts were sold altogether?",
                            "How many T-shirts were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 96. SHOES SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SHOES",
                            "The chart shows the number of shoes sold in different sizes.",

                            new String[]
                                    {
                                            "Size 2",
                                            "Size 3",
                                            "Size 4",
                                            "Size 5"
                                    },

                            new String[]
                                    {
                                            "Size 2",
                                            "Size 3",
                                            "Size 4",
                                            "Size 5"
                                    },

                            "pair",
                            "pairs",

                            "Which size of shoes was sold the most?",
                            "Which size of shoes was sold the least?",
                            "Which size of shoes was sold the second most?",
                            "Which size of shoes was sold the second least?",

                            "How many pairs of %s shoes were sold?",
                            "How many more pairs of %s shoes were sold than %s shoes?",
                            "How many fewer pairs of %s shoes were sold than %s shoes?",
                            "How many pairs of %s and %s shoes were sold altogether?",
                            "How many pairs of shoes were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 97. MONEY SAVED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MONEYSAVED",
                            "The chart shows the money saved by four children.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "rupee",
                            "rupees",

                            "Who saved the most money?",
                            "Who saved the least money?",
                            "Who saved the second most money?",
                            "Who saved the second least money?",

                            "How many rupees did %s save?",
                            "How many more rupees did %s save than %s?",
                            "How many fewer rupees did %s save than %s?",
                            "How many rupees did %s and %s save altogether?",
                            "How many rupees were saved in all?"
                    ),

                    // -------------------------------------------------
                    // 98. MONEY SPENT
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MONEYSPENT",
                            "The chart shows the money spent by four children.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "rupee",
                            "rupees",

                            "Who spent the most money?",
                            "Who spent the least money?",
                            "Who spent the second most money?",
                            "Who spent the second least money?",

                            "How many rupees did %s spend?",
                            "How many more rupees did %s spend than %s?",
                            "How many fewer rupees did %s spend than %s?",
                            "How many rupees did %s and %s spend altogether?",
                            "How many rupees were spent in all?"
                    ),

                    // -------------------------------------------------
                    // 99. CUSTOMERS VISITING SHOPS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CUSTOMERS",
                            "The chart shows the number of customers visiting different shops.",

                            new String[]
                                    {
                                            "Book Shop",
                                            "Toy Shop",
                                            "Bakery",
                                            "Fruit Shop"
                                    },

                            new String[]
                                    {
                                            "Book",
                                            "Toy",
                                            "Bakery",
                                            "Fruit"
                                    },

                            "customer",
                            "customers",

                            "Which shop had the most customers?",
                            "Which shop had the fewest customers?",
                            "Which shop had the second most customers?",
                            "Which shop had the second fewest customers?",

                            "How many customers visited the %s shop?",
                            "How many more customers visited the %s shop than the %s shop?",
                            "How many fewer customers visited the %s shop than the %s shop?",
                            "How many customers visited the %s and %s shops altogether?",
                            "How many customers visited the shops in all?"
                    ),

                    // -------------------------------------------------
                    // 100. SHOPPING BAGS USED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SHOPPINGBAGS",
                            "The chart shows the number of shopping bags used at a store.",

                            new String[]
                                    {
                                            "Paper Bags",
                                            "Cloth Bags",
                                            "Jute Bags",
                                            "Reusable Bags"
                                    },

                            new String[]
                                    {
                                            "Paper",
                                            "Cloth",
                                            "Jute",
                                            "Reusable"
                                    },

                            "bag",
                            "bags",

                            "Which type of bag was used the most?",
                            "Which type of bag was used the least?",
                            "Which type of bag was used the second most?",
                            "Which type of bag was used the second least?",

                            "How many %s bags were used?",
                            "How many more %s bags were used than %s bags?",
                            "How many fewer %s bags were used than %s bags?",
                            "How many %s and %s bags were used altogether?",
                            "How many shopping bags were used in all?"
                    ),

                    // -------------------------------------------------
                    // 101. ITEMS SOLD IN A SHOP
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SHOPITEMS",
                            "The chart shows the number of different items sold at a shop.",

                            new String[]
                                    {
                                            "Pens",
                                            "Pencils",
                                            "Erasers",
                                            "Rulers"
                                    },

                            new String[]
                                    {
                                            "Pens",
                                            "Pencils",
                                            "Erasers",
                                            "Rulers"
                                    },

                            "item",
                            "items",

                            "Which item was sold the most?",
                            "Which item was sold the least?",
                            "Which item was sold the second most?",
                            "Which item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many items were sold in all?"
                    ),
                    // -------------------------------------------------
                    // 102. FRUITS EATEN
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FRUITSEATEN",
                            "The chart shows the number of fruits eaten by four children in a week.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "fruit",
                            "fruits",

                            "Who ate the most fruits?",
                            "Who ate the fewest fruits?",
                            "Who ate the second most fruits?",
                            "Who ate the second fewest fruits?",

                            "How many fruits did %s eat?",
                            "How many more fruits did %s eat than %s?",
                            "How many fewer fruits did %s eat than %s?",
                            "How many fruits did %s and %s eat altogether?",
                            "How many fruits were eaten in all?"
                    ),

                    // -------------------------------------------------
                    // 103. GLASSES OF MILK
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MILK",
                            "The chart shows the number of glasses of milk drunk by four children in a week.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "glass",
                            "glasses",

                            "Who drank the most glasses of milk?",
                            "Who drank the fewest glasses of milk?",
                            "Who drank the second most glasses of milk?",
                            "Who drank the second fewest glasses of milk?",

                            "How many glasses of milk did %s drink?",
                            "How many more glasses of milk did %s drink than %s?",
                            "How many fewer glasses of milk did %s drink than %s?",
                            "How many glasses of milk did %s and %s drink altogether?",
                            "How many glasses of milk were drunk in all?"
                    ),

                    // -------------------------------------------------
                    // 104. HEALTHY SNACKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HEALTHYSNACKS",
                            "The chart shows the number of healthy snacks chosen by students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "snack",
                            "snacks",

                            "Who chose the most healthy snacks?",
                            "Who chose the fewest healthy snacks?",
                            "Who chose the second most healthy snacks?",
                            "Who chose the second fewest healthy snacks?",

                            "How many healthy snacks did %s choose?",
                            "How many more healthy snacks did %s choose than %s?",
                            "How many fewer healthy snacks did %s choose than %s?",
                            "How many healthy snacks did %s and %s choose altogether?",
                            "How many healthy snacks were chosen in all?"
                    ),

                    // -------------------------------------------------
                    // 105. FRUITS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FRUITSSOLD",
                            "The chart shows the number of fruits sold at a fruit shop.",

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Oranges",
                                            "Mangoes"
                                    },

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Oranges",
                                            "Mangoes"
                                    },

                            "fruit",
                            "fruits",

                            "Which fruit was sold the most?",
                            "Which fruit was sold the least?",
                            "Which fruit was sold the second most?",
                            "Which fruit was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many fruits were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 106. VEGETABLES SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "VEGETABLESSOLD",
                            "The chart shows the number of vegetables sold at a vegetable shop.",

                            new String[]
                                    {
                                            "Potatoes",
                                            "Tomatoes",
                                            "Carrots",
                                            "Onions"
                                    },

                            new String[]
                                    {
                                            "Potatoes",
                                            "Tomatoes",
                                            "Carrots",
                                            "Onions"
                                    },

                            "vegetable",
                            "vegetables",

                            "Which vegetable was sold the most?",
                            "Which vegetable was sold the least?",
                            "Which vegetable was sold the second most?",
                            "Which vegetable was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many vegetables were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 107. LUNCH BOXES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "LUNCHBOXES",
                            "The chart shows the number of lunch boxes brought to school on different days.",

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

                            "lunch box",
                            "lunch boxes",

                            "On which day were the most lunch boxes brought?",
                            "On which day were the fewest lunch boxes brought?",
                            "On which day were the second most lunch boxes brought?",
                            "On which day were the second fewest lunch boxes brought?",

                            "How many lunch boxes were brought on %s?",
                            "How many more lunch boxes were brought on %s than %s?",
                            "How many fewer lunch boxes were brought on %s than %s?",
                            "How many lunch boxes were brought on %s and %s altogether?",
                            "How many lunch boxes were brought in all?"
                    ),

                    // -------------------------------------------------
                    // 108. JUICE CUPS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "JUICECUPS",
                            "The chart shows the number of cups of juice sold at a school canteen.",

                            new String[]
                                    {
                                            "Orange",
                                            "Apple",
                                            "Mango",
                                            "Lemon"
                                    },

                            new String[]
                                    {
                                            "Orange",
                                            "Apple",
                                            "Mango",
                                            "Lemon"
                                    },

                            "cup",
                            "cups",

                            "Which type of juice was sold the most?",
                            "Which type of juice was sold the least?",
                            "Which type of juice was sold the second most?",
                            "Which type of juice was sold the second least?",

                            "How many cups of %s juice were sold?",
                            "How many more cups of %s juice were sold than %s juice?",
                            "How many fewer cups of %s juice were sold than %s juice?",
                            "How many cups of %s and %s juice were sold altogether?",
                            "How many cups of juice were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 109. MEALS SERVED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MEALSSERVED",
                            "The chart shows the number of meals served at a school canteen on different days.",

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

                            "meal",
                            "meals",

                            "On which day were the most meals served?",
                            "On which day were the fewest meals served?",
                            "On which day were the second most meals served?",
                            "On which day were the second fewest meals served?",

                            "How many meals were served on %s?",
                            "How many more meals were served on %s than %s?",
                            "How many fewer meals were served on %s than %s?",
                            "How many meals were served on %s and %s altogether?",
                            "How many meals were served in all?"
                    ),

                    // -------------------------------------------------
                    // 110. WATER DRUNK
                    // -------------------------------------------------
                    new BarChartScenario(
                            "WATERDRUNK",
                            "The chart shows the number of glasses of water drunk by four children in a day.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "glass",
                            "glasses",

                            "Who drank the most glasses of water?",
                            "Who drank the fewest glasses of water?",
                            "Who drank the second most glasses of water?",
                            "Who drank the second fewest glasses of water?",

                            "How many glasses of water did %s drink?",
                            "How many more glasses of water did %s drink than %s?",
                            "How many fewer glasses of water did %s drink than %s?",
                            "How many glasses of water did %s and %s drink altogether?",
                            "How many glasses of water were drunk in all?"
                    ),

                    // -------------------------------------------------
                    // 111. HEALTHY FOOD CHOICES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HEALTHYFOOD",
                            "The chart shows the number of healthy food items chosen by students.",

                            new String[]
                                    {
                                            "Fruits",
                                            "Vegetables",
                                            "Milk",
                                            "Nuts"
                                    },

                            new String[]
                                    {
                                            "Fruits",
                                            "Vegetables",
                                            "Milk",
                                            "Nuts"
                                    },

                            "choice",
                            "choices",

                            "Which food was chosen the most?",
                            "Which food was chosen the least?",
                            "Which food was chosen the second most?",
                            "Which food was chosen the second least?",

                            "How many choices were made for %s?",
                            "How many more choices were made for %s than %s?",
                            "How many fewer choices were made for %s than %s?",
                            "How many choices were made for %s and %s altogether?",
                            "How many healthy food choices were made in all?"
                    ),
                    // -------------------------------------------------
                    // 112. VEHICLES PASSING A ROAD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ROADVEHICLES",
                            "The chart shows the number of vehicles passing a road in one hour.",

                            new String[]
                                    {
                                            "Cars",
                                            "Buses",
                                            "Bicycles",
                                            "Trucks"
                                    },

                            new String[]
                                    {
                                            "Cars",
                                            "Buses",
                                            "Bicycles",
                                            "Trucks"
                                    },

                            "vehicle",
                            "vehicles",

                            "Which type of vehicle passed the road the most?",
                            "Which type of vehicle passed the road the least?",
                            "Which type of vehicle passed the road the second most?",
                            "Which type of vehicle passed the road the second least?",

                            "How many %s passed the road?",
                            "How many more %s passed the road than %s?",
                            "How many fewer %s passed the road than %s?",
                            "How many %s and %s passed the road altogether?",
                            "How many vehicles passed the road in all?"
                    ),

                    // -------------------------------------------------
                    // 113. VEHICLES IN A PARKING AREA
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PARKING",
                            "The chart shows the number of vehicles parked in a parking area.",

                            new String[]
                                    {
                                            "Cars",
                                            "Scooters",
                                            "Bicycles",
                                            "Motorcycles"
                                    },

                            new String[]
                                    {
                                            "Cars",
                                            "Scooters",
                                            "Bicycles",
                                            "Motorcycles"
                                    },

                            "vehicle",
                            "vehicles",

                            "Which type of vehicle was parked the most?",
                            "Which type of vehicle was parked the least?",
                            "Which type of vehicle was parked the second most?",
                            "Which type of vehicle was parked the second least?",

                            "How many %s were parked?",
                            "How many more %s were parked than %s?",
                            "How many fewer %s were parked than %s?",
                            "How many %s and %s were parked altogether?",
                            "How many vehicles were parked in all?"
                    ),

                    // -------------------------------------------------
                    // 114. PASSENGERS ON BUSES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BUSPASSENGERS",
                            "The chart shows the number of passengers travelling on four buses.",

                            new String[]
                                    {
                                            "Bus A",
                                            "Bus B",
                                            "Bus C",
                                            "Bus D"
                                    },

                            new String[]
                                    {
                                            "Bus A",
                                            "Bus B",
                                            "Bus C",
                                            "Bus D"
                                    },

                            "passenger",
                            "passengers",

                            "Which bus had the most passengers?",
                            "Which bus had the fewest passengers?",
                            "Which bus had the second most passengers?",
                            "Which bus had the second fewest passengers?",

                            "How many passengers travelled on %s?",
                            "How many more passengers travelled on %s than %s?",
                            "How many fewer passengers travelled on %s than %s?",
                            "How many passengers travelled on %s and %s altogether?",
                            "How many passengers travelled on the four buses in all?"
                    ),

                    // -------------------------------------------------
                    // 115. TYPES OF TRANSPORT USED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TRANSPORTUSED",
                            "The chart shows the number of students using different types of transport to reach school.",

                            new String[]
                                    {
                                            "Bus",
                                            "Car",
                                            "Bicycle",
                                            "Walking"
                                    },

                            new String[]
                                    {
                                            "Bus",
                                            "Car",
                                            "Bicycle",
                                            "Walking"
                                    },

                            "student",
                            "students",

                            "Which type of transport was used by the most students?",
                            "Which type of transport was used by the fewest students?",
                            "Which type of transport was used by the second most students?",
                            "Which type of transport was used by the second fewest students?",

                            "How many students used %s?",
                            "How many more students used %s than %s?",
                            "How many fewer students used %s than %s?",
                            "How many students used %s and %s altogether?",
                            "How many students used these types of transport in all?"
                    ),

                    // -------------------------------------------------
                    // 116. TRIPS MADE IN A WEEK
                    // -------------------------------------------------
                    new BarChartScenario(
                            "WEEKLYTRIPS",
                            "The chart shows the number of trips made by a family on different days.",

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

                            "trip",
                            "trips",

                            "On which day were the most trips made?",
                            "On which day were the fewest trips made?",
                            "On which day were the second most trips made?",
                            "On which day were the second fewest trips made?",

                            "How many trips were made on %s?",
                            "How many more trips were made on %s than %s?",
                            "How many fewer trips were made on %s than %s?",
                            "How many trips were made on %s and %s altogether?",
                            "How many trips were made in all?"
                    ),

                    // -------------------------------------------------
                    // 117. DISTANCE TRAVELLED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "DISTANCETRAVELLED",
                            "The chart shows the distance travelled by a family on different days.",

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

                            "kilometre",
                            "kilometres",

                            "On which day was the greatest distance travelled?",
                            "On which day was the shortest distance travelled?",
                            "On which day was the second greatest distance travelled?",
                            "On which day was the second shortest distance travelled?",

                            "How many kilometres were travelled on %s?",
                            "How many more kilometres were travelled on %s than %s?",
                            "How many fewer kilometres were travelled on %s than %s?",
                            "How many kilometres were travelled on %s and %s altogether?",
                            "How many kilometres were travelled in all?"
                    ),

                    // -------------------------------------------------
                    // 118. VEHICLES PARKED AT SCHOOL
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SCHOOLPARKING",
                            "The chart shows the number of vehicles parked at school on different days.",

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

                            "vehicle",
                            "vehicles",

                            "On which day were the most vehicles parked?",
                            "On which day were the fewest vehicles parked?",
                            "On which day were the second most vehicles parked?",
                            "On which day were the second fewest vehicles parked?",

                            "How many vehicles were parked on %s?",
                            "How many more vehicles were parked on %s than %s?",
                            "How many fewer vehicles were parked on %s than %s?",
                            "How many vehicles were parked on %s and %s altogether?",
                            "How many vehicles were parked in all?"
                    ),

                    // -------------------------------------------------
                    // 119. BICYCLES USED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BICYCLES",
                            "The chart shows the number of bicycles used by students on different days.",

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

                            "bicycle",
                            "bicycles",

                            "On which day were the most bicycles used?",
                            "On which day were the fewest bicycles used?",
                            "On which day were the second most bicycles used?",
                            "On which day were the second fewest bicycles used?",

                            "How many bicycles were used on %s?",
                            "How many more bicycles were used on %s than %s?",
                            "How many fewer bicycles were used on %s than %s?",
                            "How many bicycles were used on %s and %s altogether?",
                            "How many bicycles were used in all?"
                    ),

                    // -------------------------------------------------
                    // 120. CARS PASSING SCHOOL
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CARSSCHOOL",
                            "The chart shows the number of cars passing a school on different days.",

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

                            "car",
                            "cars",

                            "On which day did the most cars pass the school?",
                            "On which day did the fewest cars pass the school?",
                            "On which day did the second most cars pass the school?",
                            "On which day did the second fewest cars pass the school?",

                            "How many cars passed the school on %s?",
                            "How many more cars passed the school on %s than %s?",
                            "How many fewer cars passed the school on %s than %s?",
                            "How many cars passed the school on %s and %s altogether?",
                            "How many cars passed the school in all?"
                    ),

                    // -------------------------------------------------
                    // 121. TRAIN PASSENGERS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TRAINPASSENGERS",
                            "The chart shows the number of passengers travelling on four trains.",

                            new String[]
                                    {
                                            "Train A",
                                            "Train B",
                                            "Train C",
                                            "Train D"
                                    },

                            new String[]
                                    {
                                            "Train A",
                                            "Train B",
                                            "Train C",
                                            "Train D"
                                    },

                            "passenger",
                            "passengers",

                            "Which train had the most passengers?",
                            "Which train had the fewest passengers?",
                            "Which train had the second most passengers?",
                            "Which train had the second fewest passengers?",

                            "How many passengers travelled on %s?",
                            "How many more passengers travelled on %s than %s?",
                            "How many fewer passengers travelled on %s than %s?",
                            "How many passengers travelled on %s and %s altogether?",
                            "How many passengers travelled on the four trains in all?"
                    ),
                    // -------------------------------------------------
                    // 122. DRAWINGS MADE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "DRAWINGS",
                            "The chart shows the number of drawings made by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "drawing",
                            "drawings",

                            "Who made the most drawings?",
                            "Who made the fewest drawings?",
                            "Who made the second most drawings?",
                            "Who made the second fewest drawings?",

                            "How many drawings did %s make?",
                            "How many more drawings did %s make than %s?",
                            "How many fewer drawings did %s make than %s?",
                            "How many drawings did %s and %s make altogether?",
                            "How many drawings were made in all?"
                    ),

                    // -------------------------------------------------
                    // 123. PAINTINGS COMPLETED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PAINTINGS",
                            "The chart shows the number of paintings completed by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "painting",
                            "paintings",

                            "Who completed the most paintings?",
                            "Who completed the fewest paintings?",
                            "Who completed the second most paintings?",
                            "Who completed the second fewest paintings?",

                            "How many paintings did %s complete?",
                            "How many more paintings did %s complete than %s?",
                            "How many fewer paintings did %s complete than %s?",
                            "How many paintings did %s and %s complete altogether?",
                            "How many paintings were completed in all?"
                    ),

                    // -------------------------------------------------
                    // 124. CRAFT ITEMS MADE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CRAFTITEMS",
                            "The chart shows the number of craft items made by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "craft item",
                            "craft items",

                            "Who made the most craft items?",
                            "Who made the fewest craft items?",
                            "Who made the second most craft items?",
                            "Who made the second fewest craft items?",

                            "How many craft items did %s make?",
                            "How many more craft items did %s make than %s?",
                            "How many fewer craft items did %s make than %s?",
                            "How many craft items did %s and %s make altogether?",
                            "How many craft items were made in all?"
                    ),

                    // -------------------------------------------------
                    // 125. SONGS LEARNED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SONGS",
                            "The chart shows the number of songs learned by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "song",
                            "songs",

                            "Who learned the most songs?",
                            "Who learned the fewest songs?",
                            "Who learned the second most songs?",
                            "Who learned the second fewest songs?",

                            "How many songs did %s learn?",
                            "How many more songs did %s learn than %s?",
                            "How many fewer songs did %s learn than %s?",
                            "How many songs did %s and %s learn altogether?",
                            "How many songs were learned in all?"
                    ),

                    // -------------------------------------------------
                    // 126. DANCE PRACTICES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "DANCEPRACTICE",
                            "The chart shows the number of dance practices attended by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "practice",
                            "practices",

                            "Who attended the most dance practices?",
                            "Who attended the fewest dance practices?",
                            "Who attended the second most dance practices?",
                            "Who attended the second fewest dance practices?",

                            "How many dance practices did %s attend?",
                            "How many more dance practices did %s attend than %s?",
                            "How many fewer dance practices did %s attend than %s?",
                            "How many dance practices did %s and %s attend altogether?",
                            "How many dance practices were attended in all?"
                    ),

                    // -------------------------------------------------
                    // 127. GAMES PLAYED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GAMESPLAYED",
                            "The chart shows the number of games played by four students during a holiday.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "game",
                            "games",

                            "Who played the most games?",
                            "Who played the fewest games?",
                            "Who played the second most games?",
                            "Who played the second fewest games?",

                            "How many games did %s play?",
                            "How many more games did %s play than %s?",
                            "How many fewer games did %s play than %s?",
                            "How many games did %s and %s play altogether?",
                            "How many games were played in all?"
                    ),

                    // -------------------------------------------------
                    // 128. MOVIES WATCHED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MOVIESWATCHED",
                            "The chart shows the number of movies watched by four students during a holiday.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "movie",
                            "movies",

                            "Who watched the most movies?",
                            "Who watched the fewest movies?",
                            "Who watched the second most movies?",
                            "Who watched the second fewest movies?",

                            "How many movies did %s watch?",
                            "How many more movies did %s watch than %s?",
                            "How many fewer movies did %s watch than %s?",
                            "How many movies did %s and %s watch altogether?",
                            "How many movies were watched in all?"
                    ),

                    // -------------------------------------------------
                    // 129. STORIES READ
                    // -------------------------------------------------
                    new BarChartScenario(
                            "STORIESREAD",
                            "The chart shows the number of stories read by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "story",
                            "stories",

                            "Who read the most stories?",
                            "Who read the fewest stories?",
                            "Who read the second most stories?",
                            "Who read the second fewest stories?",

                            "How many stories did %s read?",
                            "How many more stories did %s read than %s?",
                            "How many fewer stories did %s read than %s?",
                            "How many stories did %s and %s read altogether?",
                            "How many stories were read in all?"
                    ),

                    // -------------------------------------------------
                    // 130. HOBBY CLASSES ATTENDED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOBBYCLASSES",
                            "The chart shows the number of hobby classes attended by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "class",
                            "classes",

                            "Who attended the most hobby classes?",
                            "Who attended the fewest hobby classes?",
                            "Who attended the second most hobby classes?",
                            "Who attended the second fewest hobby classes?",

                            "How many hobby classes did %s attend?",
                            "How many more hobby classes did %s attend than %s?",
                            "How many fewer hobby classes did %s attend than %s?",
                            "How many hobby classes did %s and %s attend altogether?",
                            "How many hobby classes were attended in all?"
                    ),

                    // -------------------------------------------------
                    // 131. ART PROJECTS COMPLETED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ARTPROJECTS",
                            "The chart shows the number of art projects completed by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "art project",
                            "art projects",

                            "Who completed the most art projects?",
                            "Who completed the fewest art projects?",
                            "Who completed the second most art projects?",
                            "Who completed the second fewest art projects?",

                            "How many art projects did %s complete?",
                            "How many more art projects did %s complete than %s?",
                            "How many fewer art projects did %s complete than %s?",
                            "How many art projects did %s and %s complete altogether?",
                            "How many art projects were completed in all?"
                    ),
                    // -------------------------------------------------
                    // 132. FAVOURITE VEGETABLES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVVEGETABLES",
                            "The chart shows the favourite vegetables of four students.",

                            new String[]
                                    {
                                            "Carrots",
                                            "Potatoes",
                                            "Tomatoes",
                                            "Spinach"
                                    },

                            new String[]
                                    {
                                            "Carrots",
                                            "Potatoes",
                                            "Tomatoes",
                                            "Spinach"
                                    },

                            "student",
                            "students",

                            "Which vegetable is liked by the most students?",
                            "Which vegetable is liked by the fewest students?",
                            "Which vegetable is liked by the second most students?",
                            "Which vegetable is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 133. FAVOURITE SNACKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVSNACKS",
                            "The chart shows the favourite snacks of students in a class.",

                            new String[]
                                    {
                                            "Biscuits",
                                            "Popcorn",
                                            "Sandwiches",
                                            "Chips"
                                    },

                            new String[]
                                    {
                                            "Biscuits",
                                            "Popcorn",
                                            "Sandwiches",
                                            "Chips"
                                    },

                            "student",
                            "students",

                            "Which snack is liked by the most students?",
                            "Which snack is liked by the fewest students?",
                            "Which snack is liked by the second most students?",
                            "Which snack is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 134. FAVOURITE DRINKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVDRINKS",
                            "The chart shows the favourite drinks of students in a class.",

                            new String[]
                                    {
                                            "Milk",
                                            "Juice",
                                            "Lemonade",
                                            "Water"
                                    },

                            new String[]
                                    {
                                            "Milk",
                                            "Juice",
                                            "Lemonade",
                                            "Water"
                                    },

                            "student",
                            "students",

                            "Which drink is liked by the most students?",
                            "Which drink is liked by the fewest students?",
                            "Which drink is liked by the second most students?",
                            "Which drink is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 135. FRUITS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FRUITSSOLD",
                            "The chart shows the number of fruits sold at a fruit shop.",

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Oranges",
                                            "Mangoes"
                                    },

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Oranges",
                                            "Mangoes"
                                    },

                            "fruit",
                            "fruits",

                            "Which fruit was sold the most?",
                            "Which fruit was sold the least?",
                            "Which fruit was sold the second most?",
                            "Which fruit was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many fruits were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 136. ICE CREAMS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ICECREAMSOLD",
                            "The chart shows the number of ice creams sold at a shop.",

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            "ice cream",
                            "ice creams",

                            "Which flavour of ice cream was sold the most?",
                            "Which flavour of ice cream was sold the least?",
                            "Which flavour of ice cream was sold the second most?",
                            "Which flavour of ice cream was sold the second least?",

                            "How many %s ice creams were sold?",
                            "How many more %s ice creams were sold than %s ice creams?",
                            "How many fewer %s ice creams were sold than %s ice creams?",
                            "How many %s and %s ice creams were sold altogether?",
                            "How many ice creams were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 137. BAKERY ITEMS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BAKERYITEMS",
                            "The chart shows the number of bakery items sold at a bakery.",

                            new String[]
                                    {
                                            "Bread",
                                            "Buns",
                                            "Cakes",
                                            "Cookies"
                                    },

                            new String[]
                                    {
                                            "Bread",
                                            "Buns",
                                            "Cakes",
                                            "Cookies"
                                    },

                            "bakery item",
                            "bakery items",

                            "Which bakery item was sold the most?",
                            "Which bakery item was sold the least?",
                            "Which bakery item was sold the second most?",
                            "Which bakery item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many bakery items were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 138. CHOCOLATES SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CHOCOLATESSOLD",
                            "The chart shows the number of chocolates sold at a shop.",

                            new String[]
                                    {
                                            "Milk Chocolate",
                                            "Dark Chocolate",
                                            "White Chocolate",
                                            "Caramel Chocolate"
                                    },

                            new String[]
                                    {
                                            "Milk",
                                            "Dark",
                                            "White",
                                            "Caramel"
                                    },

                            "chocolate",
                            "chocolates",

                            "Which type of chocolate was sold the most?",
                            "Which type of chocolate was sold the least?",
                            "Which type of chocolate was sold the second most?",
                            "Which type of chocolate was sold the second least?",

                            "How many %s chocolates were sold?",
                            "How many more %s chocolates were sold than %s chocolates?",
                            "How many fewer %s chocolates were sold than %s chocolates?",
                            "How many %s and %s chocolates were sold altogether?",
                            "How many chocolates were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 139. GROCERIES SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GROCERIES",
                            "The chart shows the number of grocery items sold at a shop.",

                            new String[]
                                    {
                                            "Rice Bags",
                                            "Sugar Bags",
                                            "Flour Bags",
                                            "Dal Bags"
                                    },

                            new String[]
                                    {
                                            "Rice",
                                            "Sugar",
                                            "Flour",
                                            "Dal"
                                    },

                            "bag",
                            "bags",

                            "Which type of grocery bag was sold the most?",
                            "Which type of grocery bag was sold the least?",
                            "Which type of grocery bag was sold the second most?",
                            "Which type of grocery bag was sold the second least?",

                            "How many %s bags were sold?",
                            "How many more %s bags were sold than %s bags?",
                            "How many fewer %s bags were sold than %s bags?",
                            "How many %s and %s bags were sold altogether?",
                            "How many grocery bags were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 140. BOOKS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOOKSSOLD",
                            "The chart shows the number of books sold at a book shop.",

                            new String[]
                                    {
                                            "Story Books",
                                            "Science Books",
                                            "Picture Books",
                                            "Activity Books"
                                    },

                            new String[]
                                    {
                                            "Story",
                                            "Science",
                                            "Picture",
                                            "Activity"
                                    },

                            "book",
                            "books",

                            "Which type of book was sold the most?",
                            "Which type of book was sold the least?",
                            "Which type of book was sold the second most?",
                            "Which type of book was sold the second least?",

                            "How many %s books were sold?",
                            "How many more %s books were sold than %s books?",
                            "How many fewer %s books were sold than %s books?",
                            "How many %s and %s books were sold altogether?",
                            "How many books were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 141. SHOPPING ITEMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SHOPPINGITEMS",
                            "The chart shows the number of different items bought by customers at a shop.",

                            new String[]
                                    {
                                            "Pencils",
                                            "Notebooks",
                                            "Erasers",
                                            "Rulers"
                                    },

                            new String[]
                                    {
                                            "Pencils",
                                            "Notebooks",
                                            "Erasers",
                                            "Rulers"
                                    },

                            "item",
                            "items",

                            "Which item was bought the most?",
                            "Which item was bought the least?",
                            "Which item was bought the second most?",
                            "Which item was bought the second least?",

                            "How many %s were bought?",
                            "How many more %s were bought than %s?",
                            "How many fewer %s were bought than %s?",
                            "How many %s and %s were bought altogether?",
                            "How many items were bought in all?"
                    ),
                    // -------------------------------------------------
                    // 142. TREES PLANTED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TREESPLANTED",
                            "The chart shows the number of trees planted by four classes.",

                            new String[]
                                    {
                                            "Class 4A",
                                            "Class 4B",
                                            "Class 4C",
                                            "Class 4D"
                                    },

                            new String[]
                                    {
                                            "4A",
                                            "4B",
                                            "4C",
                                            "4D"
                                    },

                            "tree",
                            "trees",

                            "Which class planted the most trees?",
                            "Which class planted the fewest trees?",
                            "Which class planted the second most trees?",
                            "Which class planted the second fewest trees?",

                            "How many trees did %s plant?",
                            "How many more trees did %s plant than %s?",
                            "How many fewer trees did %s plant than %s?",
                            "How many trees did %s and %s plant altogether?",
                            "How many trees were planted in all?"
                    ),

                    // -------------------------------------------------
                    // 143. FLOWERS IN A GARDEN
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GARDENFLOWERS",
                            "The chart shows the number of different flowers in a garden.",

                            new String[]
                                    {
                                            "Roses",
                                            "Sunflowers",
                                            "Marigolds",
                                            "Lilies"
                                    },

                            new String[]
                                    {
                                            "Roses",
                                            "Sunflowers",
                                            "Marigolds",
                                            "Lilies"
                                    },

                            "flower",
                            "flowers",

                            "Which flower is there the most of?",
                            "Which flower is there the least of?",
                            "Which flower is there the second most of?",
                            "Which flower is there the second least of?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many flowers are there in all?"
                    ),

                    // -------------------------------------------------
                    // 144. ANIMALS IN A ZOO
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ZOOANIMALS",
                            "The chart shows the number of different animals in a zoo.",

                            new String[]
                                    {
                                            "Elephants",
                                            "Tigers",
                                            "Monkeys",
                                            "Zebras"
                                    },

                            new String[]
                                    {
                                            "Elephants",
                                            "Tigers",
                                            "Monkeys",
                                            "Zebras"
                                    },

                            "animal",
                            "animals",

                            "Which animal is there the most of?",
                            "Which animal is there the least of?",
                            "Which animal is there the second most of?",
                            "Which animal is there the second least of?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many animals are there in all?"
                    ),

                    // -------------------------------------------------
                    // 145. BIRDS SEEN IN A PARK
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PARKBIRDS",
                            "The chart shows the number of different birds seen in a park.",

                            new String[]
                                    {
                                            "Sparrows",
                                            "Pigeons",
                                            "Parrots",
                                            "Crows"
                                    },

                            new String[]
                                    {
                                            "Sparrows",
                                            "Pigeons",
                                            "Parrots",
                                            "Crows"
                                    },

                            "bird",
                            "birds",

                            "Which bird was seen the most?",
                            "Which bird was seen the least?",
                            "Which bird was seen the second most?",
                            "Which bird was seen the second least?",

                            "How many %s were seen?",
                            "How many more %s were seen than %s?",
                            "How many fewer %s were seen than %s?",
                            "How many %s and %s were seen altogether?",
                            "How many birds were seen in all?"
                    ),

                    // -------------------------------------------------
                    // 146. RECYCLING COLLECTED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "RECYCLING",
                            "The chart shows the number of bags of recyclable materials collected by four classes.",

                            new String[]
                                    {
                                            "Class 4A",
                                            "Class 4B",
                                            "Class 4C",
                                            "Class 4D"
                                    },

                            new String[]
                                    {
                                            "4A",
                                            "4B",
                                            "4C",
                                            "4D"
                                    },

                            "bag",
                            "bags",

                            "Which class collected the most bags?",
                            "Which class collected the fewest bags?",
                            "Which class collected the second most bags?",
                            "Which class collected the second fewest bags?",

                            "How many bags did %s collect?",
                            "How many more bags did %s collect than %s?",
                            "How many fewer bags did %s collect than %s?",
                            "How many bags did %s and %s collect altogether?",
                            "How many bags were collected in all?"
                    ),

                    // -------------------------------------------------
                    // 147. WATER USED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "WATERUSED",
                            "The chart shows the amount of water used on different days.",

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

                            "litre",
                            "litres",

                            "On which day was the most water used?",
                            "On which day was the least water used?",
                            "On which day was the second most water used?",
                            "On which day was the second least water used?",

                            "How many litres of water were used on %s?",
                            "How many more litres of water were used on %s than %s?",
                            "How many fewer litres of water were used on %s than %s?",
                            "How many litres of water were used on %s and %s altogether?",
                            "How many litres of water were used in all?"
                    ),

                    // -------------------------------------------------
                    // 148. RAINFALL
                    // -------------------------------------------------
                    new BarChartScenario(
                            "RAINFALL",
                            "The chart shows the amount of rainfall received in four months.",

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

                            "How many millimetres of rainfall were received in %s?",
                            "How many more millimetres of rainfall were received in %s than %s?",
                            "How many fewer millimetres of rainfall were received in %s than %s?",
                            "How many millimetres of rainfall were received in %s and %s altogether?",
                            "How many millimetres of rainfall were received in all?"
                    ),

                    // -------------------------------------------------
                    // 149. TEMPERATURE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TEMPERATURE",
                            "The chart shows the temperature recorded on four days.",

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

                            "degree",
                            "degrees",

                            "Which day had the highest temperature?",
                            "Which day had the lowest temperature?",
                            "Which day had the second highest temperature?",
                            "Which day had the second lowest temperature?",

                            "What was the temperature on %s?",
                            "How many degrees higher was the temperature on %s than %s?",
                            "How many degrees lower was the temperature on %s than %s?",
                            "What was the total of the temperatures on %s and %s?",
                            "What was the total of the four temperatures?"
                    ),

                    // -------------------------------------------------
                    // 150. CLOUDY DAYS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CLOUDYDAYS",
                            "The chart shows the number of cloudy days in four months.",

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

                            "day",
                            "days",

                            "Which month had the most cloudy days?",
                            "Which month had the fewest cloudy days?",
                            "Which month had the second most cloudy days?",
                            "Which month had the second fewest cloudy days?",

                            "How many cloudy days were there in %s?",
                            "How many more cloudy days were there in %s than %s?",
                            "How many fewer cloudy days were there in %s than %s?",
                            "How many cloudy days were there in %s and %s altogether?",
                            "How many cloudy days were there in all?"
                    ),

                    // -------------------------------------------------
                    // 151. NATURE PROJECTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "NATUREPROJECTS",
                            "The chart shows the number of nature projects completed by four classes.",

                            new String[]
                                    {
                                            "Class 4A",
                                            "Class 4B",
                                            "Class 4C",
                                            "Class 4D"
                                    },

                            new String[]
                                    {
                                            "4A",
                                            "4B",
                                            "4C",
                                            "4D"
                                    },

                            "project",
                            "projects",

                            "Which class completed the most nature projects?",
                            "Which class completed the fewest nature projects?",
                            "Which class completed the second most nature projects?",
                            "Which class completed the second fewest nature projects?",

                            "How many nature projects did %s complete?",
                            "How many more nature projects did %s complete than %s?",
                            "How many fewer nature projects did %s complete than %s?",
                            "How many nature projects did %s and %s complete altogether?",
                            "How many nature projects were completed in all?"
                    ),
                    // -------------------------------------------------
                    // 152. FAVOURITE SPORTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVSPORTS",
                            "The chart shows the favourite sports of students in a class.",

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Tennis"
                                    },

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Tennis"
                                    },

                            "student",
                            "students",

                            "Which sport is liked by the most students?",
                            "Which sport is liked by the fewest students?",
                            "Which sport is liked by the second most students?",
                            "Which sport is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 153. GOALS SCORED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GOALSSCORED",
                            "The chart shows the number of goals scored by four football teams.",

                            new String[]
                                    {
                                            "Tigers",
                                            "Lions",
                                            "Eagles",
                                            "Panthers"
                                    },

                            new String[]
                                    {
                                            "Tigers",
                                            "Lions",
                                            "Eagles",
                                            "Panthers"
                                    },

                            "goal",
                            "goals",

                            "Which team scored the most goals?",
                            "Which team scored the fewest goals?",
                            "Which team scored the second most goals?",
                            "Which team scored the second fewest goals?",

                            "How many goals did %s score?",
                            "How many more goals did %s score than %s?",
                            "How many fewer goals did %s score than %s?",
                            "How many goals did %s and %s score altogether?",
                            "How many goals were scored in all?"
                    ),

                    // -------------------------------------------------
                    // 154. RUNS SCORED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "RUNSSCORED",
                            "The chart shows the number of runs scored by four cricket teams.",

                            new String[]
                                    {
                                            "India",
                                            "Australia",
                                            "England",
                                            "South Africa"
                                    },

                            new String[]
                                    {
                                            "India",
                                            "Australia",
                                            "England",
                                            "South Africa"
                                    },

                            "run",
                            "runs",

                            "Which team scored the most runs?",
                            "Which team scored the fewest runs?",
                            "Which team scored the second most runs?",
                            "Which team scored the second fewest runs?",

                            "How many runs did %s score?",
                            "How many more runs did %s score than %s?",
                            "How many fewer runs did %s score than %s?",
                            "How many runs did %s and %s score altogether?",
                            "How many runs were scored in all?"
                    ),

                    // -------------------------------------------------
                    // 155. MEDALS WON
                    // -------------------------------------------------
                    new BarChartScenario(
                            "MEDALSWON",
                            "The chart shows the number of medals won by four school teams.",

                            new String[]
                                    {
                                            "Red Team",
                                            "Blue Team",
                                            "Green Team",
                                            "Yellow Team"
                                    },

                            new String[]
                                    {
                                            "Red",
                                            "Blue",
                                            "Green",
                                            "Yellow"
                                    },

                            "medal",
                            "medals",

                            "Which team won the most medals?",
                            "Which team won the fewest medals?",
                            "Which team won the second most medals?",
                            "Which team won the second fewest medals?",

                            "How many medals did %s win?",
                            "How many more medals did %s win than %s?",
                            "How many fewer medals did %s win than %s?",
                            "How many medals did %s and %s win altogether?",
                            "How many medals were won in all?"
                    ),

                    // -------------------------------------------------
                    // 156. INDOOR GAMES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "INDOORGAMES",
                            "The chart shows the favourite indoor games of students.",

                            new String[]
                                    {
                                            "Chess",
                                            "Carrom",
                                            "Ludo",
                                            "Table Tennis"
                                    },

                            new String[]
                                    {
                                            "Chess",
                                            "Carrom",
                                            "Ludo",
                                            "Table Tennis"
                                    },

                            "student",
                            "students",

                            "Which indoor game is liked by the most students?",
                            "Which indoor game is liked by the fewest students?",
                            "Which indoor game is liked by the second most students?",
                            "Which indoor game is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 157. OUTDOOR GAMES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "OUTDOORGAMES",
                            "The chart shows the favourite outdoor games of students.",

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

                            "Which outdoor game is liked by the most students?",
                            "Which outdoor game is liked by the fewest students?",
                            "Which outdoor game is liked by the second most students?",
                            "Which outdoor game is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 158. SPORTS EQUIPMENT
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SPORTEQUIPMENT",
                            "The chart shows the number of different sports items in a school store.",

                            new String[]
                                    {
                                            "Football",
                                            "Cricket Bat",
                                            "Basketball",
                                            "Tennis Racket"
                                    },

                            new String[]
                                    {
                                            "Football",
                                            "Cricket Bat",
                                            "Basketball",
                                            "Tennis"
                                    },

                            "item",
                            "items",

                            "Which sports item is there the most of?",
                            "Which sports item is there the least of?",
                            "Which sports item is there the second most of?",
                            "Which sports item is there the second least of?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many sports items are there in all?"
                    ),

                    // -------------------------------------------------
                    // 159. PLAYERS IN TEAMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TEAMPLAYERS",
                            "The chart shows the number of players in four school teams.",

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Hockey"
                                    },

                            new String[]
                                    {
                                            "Cricket",
                                            "Football",
                                            "Basketball",
                                            "Hockey"
                                    },

                            "player",
                            "players",

                            "Which team has the most players?",
                            "Which team has the fewest players?",
                            "Which team has the second most players?",
                            "Which team has the second fewest players?",

                            "How many players are in the %s team?",
                            "How many more players are in the %s team than the %s team?",
                            "How many fewer players are in the %s team than the %s team?",
                            "How many players are in the %s and %s teams altogether?",
                            "How many players are there in all?"
                    ),

                    // -------------------------------------------------
                    // 160. SPORTS PRACTICE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SPORTSPRACTICE",
                            "The chart shows the number of sports practice sessions attended by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "practice session",
                            "practice sessions",

                            "Who attended the most practice sessions?",
                            "Who attended the fewest practice sessions?",
                            "Who attended the second most practice sessions?",
                            "Who attended the second fewest practice sessions?",

                            "How many practice sessions did %s attend?",
                            "How many more practice sessions did %s attend than %s?",
                            "How many fewer practice sessions did %s attend than %s?",
                            "How many practice sessions did %s and %s attend altogether?",
                            "How many practice sessions were attended in all?"
                    ),

                    // -------------------------------------------------
                    // 161. SPORTS EVENTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SPORTSEVENTS",
                            "The chart shows the number of events completed by four students during a sports day.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "event",
                            "events",

                            "Who completed the most events?",
                            "Who completed the fewest events?",
                            "Who completed the second most events?",
                            "Who completed the second fewest events?",

                            "How many events did %s complete?",
                            "How many more events did %s complete than %s?",
                            "How many fewer events did %s complete than %s?",
                            "How many events did %s and %s complete altogether?",
                            "How many events were completed in all?"
                    ),

                    // -------------------------------------------------
                    // 162. BUS PASSENGERS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BUSPASSENGERS",
                            "The chart shows the number of passengers travelling on four buses.",

                            new String[]
                                    {
                                            "Bus A",
                                            "Bus B",
                                            "Bus C",
                                            "Bus D"
                                    },

                            new String[]
                                    {
                                            "Bus A",
                                            "Bus B",
                                            "Bus C",
                                            "Bus D"
                                    },

                            "passenger",
                            "passengers",

                            "Which bus had the most passengers?",
                            "Which bus had the fewest passengers?",
                            "Which bus had the second most passengers?",
                            "Which bus had the second fewest passengers?",

                            "How many passengers travelled on %s?",
                            "How many more passengers travelled on %s than %s?",
                            "How many fewer passengers travelled on %s than %s?",
                            "How many passengers travelled on %s and %s altogether?",
                            "How many passengers travelled on the four buses in all?"
                    ),

                    // -------------------------------------------------
                    // 163. VEHICLES ON A ROAD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ROADVEHICLES",
                            "The chart shows the number of vehicles passing a road in one hour.",

                            new String[]
                                    {
                                            "Cars",
                                            "Buses",
                                            "Bicycles",
                                            "Trucks"
                                    },

                            new String[]
                                    {
                                            "Cars",
                                            "Buses",
                                            "Bicycles",
                                            "Trucks"
                                    },

                            "vehicle",
                            "vehicles",

                            "Which type of vehicle passed the road the most?",
                            "Which type of vehicle passed the road the least?",
                            "Which type of vehicle passed the road the second most?",
                            "Which type of vehicle passed the road the second least?",

                            "How many %s passed the road?",
                            "How many more %s passed the road than %s?",
                            "How many fewer %s passed the road than %s?",
                            "How many %s and %s passed the road altogether?",
                            "How many vehicles passed the road in all?"
                    ),

                    // -------------------------------------------------
                    // 164. VEHICLES IN A PARKING AREA
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PARKINGVEHICLES",
                            "The chart shows the number of vehicles parked in a parking area.",

                            new String[]
                                    {
                                            "Cars",
                                            "Scooters",
                                            "Bicycles",
                                            "Motorcycles"
                                    },

                            new String[]
                                    {
                                            "Cars",
                                            "Scooters",
                                            "Bicycles",
                                            "Motorcycles"
                                    },

                            "vehicle",
                            "vehicles",

                            "Which type of vehicle was parked the most?",
                            "Which type of vehicle was parked the least?",
                            "Which type of vehicle was parked the second most?",
                            "Which type of vehicle was parked the second least?",

                            "How many %s were parked?",
                            "How many more %s were parked than %s?",
                            "How many fewer %s were parked than %s?",
                            "How many %s and %s were parked altogether?",
                            "How many vehicles were parked in all?"
                    ),

                    // -------------------------------------------------
                    // 165. TRANSPORT USED BY STUDENTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TRANSPORTUSED",
                            "The chart shows the number of students using different types of transport to reach school.",

                            new String[]
                                    {
                                            "Bus",
                                            "Car",
                                            "Bicycle",
                                            "Walking"
                                    },

                            new String[]
                                    {
                                            "Bus",
                                            "Car",
                                            "Bicycle",
                                            "Walking"
                                    },

                            "student",
                            "students",

                            "Which type of transport was used by the most students?",
                            "Which type of transport was used by the fewest students?",
                            "Which type of transport was used by the second most students?",
                            "Which type of transport was used by the second fewest students?",

                            "How many students used %s?",
                            "How many more students used %s than %s?",
                            "How many fewer students used %s than %s?",
                            "How many students used %s and %s altogether?",
                            "How many students used these types of transport in all?"
                    ),

                    // -------------------------------------------------
                    // 166. TRIPS MADE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TRIPSDAY",
                            "The chart shows the number of trips made by a family on different days.",

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

                            "trip",
                            "trips",

                            "On which day were the most trips made?",
                            "On which day were the fewest trips made?",
                            "On which day were the second most trips made?",
                            "On which day were the second fewest trips made?",

                            "How many trips were made on %s?",
                            "How many more trips were made on %s than %s?",
                            "How many fewer trips were made on %s than %s?",
                            "How many trips were made on %s and %s altogether?",
                            "How many trips were made in all?"
                    ),

                    // -------------------------------------------------
                    // 167. BICYCLES USED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BICYCLESDAYS",
                            "The chart shows the number of bicycles used by students on different days.",

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

                            "bicycle",
                            "bicycles",

                            "On which day were the most bicycles used?",
                            "On which day were the fewest bicycles used?",
                            "On which day were the second most bicycles used?",
                            "On which day were the second fewest bicycles used?",

                            "How many bicycles were used on %s?",
                            "How many more bicycles were used on %s than %s?",
                            "How many fewer bicycles were used on %s than %s?",
                            "How many bicycles were used on %s and %s altogether?",
                            "How many bicycles were used in all?"
                    ),

                    // -------------------------------------------------
                    // 168. CARS PASSING A SCHOOL
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SCHOOLCARS",
                            "The chart shows the number of cars passing a school on different days.",

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

                            "car",
                            "cars",

                            "On which day did the most cars pass the school?",
                            "On which day did the fewest cars pass the school?",
                            "On which day did the second most cars pass the school?",
                            "On which day did the second fewest cars pass the school?",

                            "How many cars passed the school on %s?",
                            "How many more cars passed the school on %s than %s?",
                            "How many fewer cars passed the school on %s than %s?",
                            "How many cars passed the school on %s and %s altogether?",
                            "How many cars passed the school in all?"
                    ),

                    // -------------------------------------------------
                    // 169. TRAINS AND PASSENGERS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TRAINPASSENGERS",
                            "The chart shows the number of passengers travelling on four trains.",

                            new String[]
                                    {
                                            "Train A",
                                            "Train B",
                                            "Train C",
                                            "Train D"
                                    },

                            new String[]
                                    {
                                            "Train A",
                                            "Train B",
                                            "Train C",
                                            "Train D"
                                    },

                            "passenger",
                            "passengers",

                            "Which train had the most passengers?",
                            "Which train had the fewest passengers?",
                            "Which train had the second most passengers?",
                            "Which train had the second fewest passengers?",

                            "How many passengers travelled on %s?",
                            "How many more passengers travelled on %s than %s?",
                            "How many fewer passengers travelled on %s than %s?",
                            "How many passengers travelled on %s and %s altogether?",
                            "How many passengers travelled on the four trains in all?"
                    ),

                    // -------------------------------------------------
                    // 170. DISTANCE TRAVELLED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "DISTANCE",
                            "The chart shows the distance travelled by a family on different days.",

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

                            "kilometre",
                            "kilometres",

                            "On which day was the greatest distance travelled?",
                            "On which day was the shortest distance travelled?",
                            "On which day was the second greatest distance travelled?",
                            "On which day was the second shortest distance travelled?",

                            "How many kilometres were travelled on %s?",
                            "How many more kilometres were travelled on %s than %s?",
                            "How many fewer kilometres were travelled on %s than %s?",
                            "How many kilometres were travelled on %s and %s altogether?",
                            "How many kilometres were travelled in all?"
                    ),

                    // -------------------------------------------------
                    // 171. TAXIS AT A STATION
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TAXISSTATION",
                            "The chart shows the number of taxis at a railway station at different times.",

                            new String[]
                                    {
                                            "Morning",
                                            "Afternoon",
                                            "Evening",
                                            "Night"
                                    },

                            new String[]
                                    {
                                            "Morning",
                                            "Afternoon",
                                            "Evening",
                                            "Night"
                                    },

                            "taxi",
                            "taxis",

                            "At which time were there the most taxis?",
                            "At which time were there the fewest taxis?",
                            "At which time were there the second most taxis?",
                            "At which time were there the second fewest taxis?",

                            "How many taxis were there in the %s?",
                            "How many more taxis were there in the %s than in the %s?",
                            "How many fewer taxis were there in the %s than in the %s?",
                            "How many taxis were there in the %s and %s altogether?",
                            "How many taxis were there in all?"
                    ),

                    // -------------------------------------------------
                    // 172. BOAT PASSENGERS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOATPASSENGERS",
                            "The chart shows the number of passengers travelling on four boats.",

                            new String[]
                                    {
                                            "Boat A",
                                            "Boat B",
                                            "Boat C",
                                            "Boat D"
                                    },

                            new String[]
                                    {
                                            "Boat A",
                                            "Boat B",
                                            "Boat C",
                                            "Boat D"
                                    },

                            "passenger",
                            "passengers",

                            "Which boat had the most passengers?",
                            "Which boat had the fewest passengers?",
                            "Which boat had the second most passengers?",
                            "Which boat had the second fewest passengers?",

                            "How many passengers travelled on %s?",
                            "How many more passengers travelled on %s than %s?",
                            "How many fewer passengers travelled on %s than %s?",
                            "How many passengers travelled on %s and %s altogether?",
                            "How many passengers travelled on the four boats in all?"
                    ),
                    // -------------------------------------------------
                    // 173. FAVOURITE FRUITS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVFRUITS",
                            "The chart shows the favourite fruits of students in a class.",

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Mangoes",
                                            "Oranges"
                                    },

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Mangoes",
                                            "Oranges"
                                    },

                            "student",
                            "students",

                            "Which fruit is liked by the most students?",
                            "Which fruit is liked by the fewest students?",
                            "Which fruit is liked by the second most students?",
                            "Which fruit is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 174. FAVOURITE SNACKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVSNACKS",
                            "The chart shows the favourite snacks of students in a class.",

                            new String[]
                                    {
                                            "Biscuits",
                                            "Popcorn",
                                            "Sandwiches",
                                            "Samosas"
                                    },

                            new String[]
                                    {
                                            "Biscuits",
                                            "Popcorn",
                                            "Sandwiches",
                                            "Samosas"
                                    },

                            "student",
                            "students",

                            "Which snack is liked by the most students?",
                            "Which snack is liked by the fewest students?",
                            "Which snack is liked by the second most students?",
                            "Which snack is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 175. FAVOURITE DRINKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVDRINKS",
                            "The chart shows the favourite drinks of students in a class.",

                            new String[]
                                    {
                                            "Milk",
                                            "Juice",
                                            "Lemonade",
                                            "Water"
                                    },

                            new String[]
                                    {
                                            "Milk",
                                            "Juice",
                                            "Lemonade",
                                            "Water"
                                    },

                            "student",
                            "students",

                            "Which drink is liked by the most students?",
                            "Which drink is liked by the fewest students?",
                            "Which drink is liked by the second most students?",
                            "Which drink is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 176. FRUITS SOLD AT A SHOP
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FRUITSSOLD",
                            "The chart shows the number of fruits sold at a shop.",

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Mangoes",
                                            "Oranges"
                                    },

                            new String[]
                                    {
                                            "Apples",
                                            "Bananas",
                                            "Mangoes",
                                            "Oranges"
                                    },

                            "fruit",
                            "fruits",

                            "Which fruit was sold the most?",
                            "Which fruit was sold the least?",
                            "Which fruit was sold the second most?",
                            "Which fruit was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many fruits were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 177. ICE CREAMS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ICECREAMSOLD",
                            "The chart shows the number of ice creams sold at a shop.",

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            new String[]
                                    {
                                            "Vanilla",
                                            "Chocolate",
                                            "Strawberry",
                                            "Mango"
                                    },

                            "ice cream",
                            "ice creams",

                            "Which flavour of ice cream was sold the most?",
                            "Which flavour of ice cream was sold the least?",
                            "Which flavour of ice cream was sold the second most?",
                            "Which flavour of ice cream was sold the second least?",

                            "How many %s ice creams were sold?",
                            "How many more %s ice creams were sold than %s ice creams?",
                            "How many fewer %s ice creams were sold than %s ice creams?",
                            "How many %s and %s ice creams were sold altogether?",
                            "How many ice creams were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 178. BAKERY ITEMS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BAKERYITEMS",
                            "The chart shows the number of bakery items sold at a bakery.",

                            new String[]
                                    {
                                            "Bread",
                                            "Buns",
                                            "Cakes",
                                            "Cookies"
                                    },

                            new String[]
                                    {
                                            "Bread",
                                            "Buns",
                                            "Cakes",
                                            "Cookies"
                                    },

                            "bakery item",
                            "bakery items",

                            "Which bakery item was sold the most?",
                            "Which bakery item was sold the least?",
                            "Which bakery item was sold the second most?",
                            "Which bakery item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many bakery items were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 179. FAVOURITE DESSERTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVDESSERTS",
                            "The chart shows the favourite desserts of students in a class.",

                            new String[]
                                    {
                                            "Ice Cream",
                                            "Cake",
                                            "Gulab Jamun",
                                            "Fruit Salad"
                                    },

                            new String[]
                                    {
                                            "Ice Cream",
                                            "Cake",
                                            "Gulab Jamun",
                                            "Fruit Salad"
                                    },

                            "student",
                            "students",

                            "Which dessert is liked by the most students?",
                            "Which dessert is liked by the fewest students?",
                            "Which dessert is liked by the second most students?",
                            "Which dessert is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 180. VEGETABLES SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "VEGETABLESSOLD",
                            "The chart shows the number of vegetables sold at a shop.",

                            new String[]
                                    {
                                            "Carrots",
                                            "Potatoes",
                                            "Tomatoes",
                                            "Spinach"
                                    },

                            new String[]
                                    {
                                            "Carrots",
                                            "Potatoes",
                                            "Tomatoes",
                                            "Spinach"
                                    },

                            "vegetable",
                            "vegetables",

                            "Which vegetable was sold the most?",
                            "Which vegetable was sold the least?",
                            "Which vegetable was sold the second most?",
                            "Which vegetable was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many vegetables were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 181. PIZZAS SOLD
                    // -------------------------------------------------
                    new BarChartScenario(
                            "PIZZASSOLD",
                            "The chart shows the number of pizzas sold at a restaurant.",

                            new String[]
                                    {
                                            "Cheese",
                                            "Corn",
                                            "Paneer",
                                            "Vegetable"
                                    },

                            new String[]
                                    {
                                            "Cheese",
                                            "Corn",
                                            "Paneer",
                                            "Vegetable"
                                    },

                            "pizza",
                            "pizzas",

                            "Which type of pizza was sold the most?",
                            "Which type of pizza was sold the least?",
                            "Which type of pizza was sold the second most?",
                            "Which type of pizza was sold the second least?",

                            "How many %s pizzas were sold?",
                            "How many more %s pizzas were sold than %s pizzas?",
                            "How many fewer %s pizzas were sold than %s pizzas?",
                            "How many %s and %s pizzas were sold altogether?",
                            "How many pizzas were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 182. LUNCH ITEMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "LUNCHITEMS",
                            "The chart shows the number of lunch items sold at a school canteen.",

                            new String[]
                                    {
                                            "Sandwiches",
                                            "Samosas",
                                            "Idlis",
                                            "Dosas"
                                    },

                            new String[]
                                    {
                                            "Sandwiches",
                                            "Samosas",
                                            "Idlis",
                                            "Dosas"
                                    },

                            "item",
                            "items",

                            "Which lunch item was sold the most?",
                            "Which lunch item was sold the least?",
                            "Which lunch item was sold the second most?",
                            "Which lunch item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many lunch items were sold in all?"
                    ),
                    // -------------------------------------------------
                    // 183. FAVOURITE HOUSE PLANTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOUSEPLANTS",
                            "The chart shows the favourite house plants of four families.",

                            new String[]
                                    {
                                            "Rose",
                                            "Money Plant",
                                            "Tulsi",
                                            "Aloe Vera"
                                    },

                            new String[]
                                    {
                                            "Rose",
                                            "Money Plant",
                                            "Tulsi",
                                            "Aloe Vera"
                                    },

                            "family",
                            "families",

                            "Which plant is liked by the most families?",
                            "Which plant is liked by the fewest families?",
                            "Which plant is liked by the second most families?",
                            "Which plant is liked by the second fewest families?",

                            "How many families like %s?",
                            "How many more families like %s than %s?",
                            "How many fewer families like %s than %s?",
                            "How many families like %s and %s altogether?",
                            "How many families are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 184. GARDEN TOOLS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GARDENTOOLS",
                            "The chart shows the number of different garden tools in a garden shed.",

                            new String[]
                                    {
                                            "Spades",
                                            "Rakes",
                                            "Buckets",
                                            "Hoes"
                                    },

                            new String[]
                                    {
                                            "Spades",
                                            "Rakes",
                                            "Buckets",
                                            "Hoes"
                                    },

                            "tool",
                            "tools",

                            "Which garden tool is there the most of?",
                            "Which garden tool is there the least of?",
                            "Which garden tool is there the second most of?",
                            "Which garden tool is there the second least of?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many garden tools are there in all?"
                    ),

                    // -------------------------------------------------
                    // 185. FLOWERS PLANTED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FLOWERSPLANTED",
                            "The chart shows the number of different flowers planted in a garden.",

                            new String[]
                                    {
                                            "Roses",
                                            "Marigolds",
                                            "Lilies",
                                            "Sunflowers"
                                    },

                            new String[]
                                    {
                                            "Roses",
                                            "Marigolds",
                                            "Lilies",
                                            "Sunflowers"
                                    },

                            "flower",
                            "flowers",

                            "Which flower was planted the most?",
                            "Which flower was planted the least?",
                            "Which flower was planted the second most?",
                            "Which flower was planted the second least?",

                            "How many %s were planted?",
                            "How many more %s were planted than %s?",
                            "How many fewer %s were planted than %s?",
                            "How many %s and %s were planted altogether?",
                            "How many flowers were planted in all?"
                    ),

                    // -------------------------------------------------
                    // 186. POTS IN A GARDEN
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GARDENPOTS",
                            "The chart shows the number of flower pots of different sizes in a garden.",

                            new String[]
                                    {
                                            "Small",
                                            "Medium",
                                            "Large",
                                            "Hanging"
                                    },

                            new String[]
                                    {
                                            "Small",
                                            "Medium",
                                            "Large",
                                            "Hanging"
                                    },

                            "pot",
                            "pots",

                            "Which type of pot is there the most of?",
                            "Which type of pot is there the least of?",
                            "Which type of pot is there the second most of?",
                            "Which type of pot is there the second least of?",

                            "How many %s pots are there?",
                            "How many more %s pots are there than %s pots?",
                            "How many fewer %s pots are there than %s pots?",
                            "How many %s and %s pots are there altogether?",
                            "How many pots are there in all?"
                    ),

                    // -------------------------------------------------
                    // 187. ROOMS IN HOMES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOMEROOMS",
                            "The chart shows the number of rooms in four homes.",

                            new String[]
                                    {
                                            "Home A",
                                            "Home B",
                                            "Home C",
                                            "Home D"
                                    },

                            new String[]
                                    {
                                            "Home A",
                                            "Home B",
                                            "Home C",
                                            "Home D"
                                    },

                            "room",
                            "rooms",

                            "Which home has the most rooms?",
                            "Which home has the fewest rooms?",
                            "Which home has the second most rooms?",
                            "Which home has the second fewest rooms?",

                            "How many rooms does %s have?",
                            "How many more rooms does %s have than %s?",
                            "How many fewer rooms does %s have than %s?",
                            "How many rooms do %s and %s have altogether?",
                            "How many rooms are there in all?"
                    ),

                    // -------------------------------------------------
                    // 188. BOOKSHELVES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOOKSHELVES",
                            "The chart shows the number of books on different shelves at home.",

                            new String[]
                                    {
                                            "Shelf A",
                                            "Shelf B",
                                            "Shelf C",
                                            "Shelf D"
                                    },

                            new String[]
                                    {
                                            "A",
                                            "B",
                                            "C",
                                            "D"
                                    },

                            "book",
                            "books",

                            "Which shelf has the most books?",
                            "Which shelf has the fewest books?",
                            "Which shelf has the second most books?",
                            "Which shelf has the second fewest books?",

                            "How many books are on %s?",
                            "How many more books are on %s than %s?",
                            "How many fewer books are on %s than %s?",
                            "How many books are on %s and %s altogether?",
                            "How many books are there in all?"
                    ),

                    // -------------------------------------------------
                    // 189. FURNITURE ITEMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FURNITURE",
                            "The chart shows the number of different furniture items in four homes.",

                            new String[]
                                    {
                                            "Chairs",
                                            "Tables",
                                            "Sofas",
                                            "Stools"
                                    },

                            new String[]
                                    {
                                            "Chairs",
                                            "Tables",
                                            "Sofas",
                                            "Stools"
                                    },

                            "item",
                            "items",

                            "Which furniture item is there the most of?",
                            "Which furniture item is there the least of?",
                            "Which furniture item is there the second most of?",
                            "Which furniture item is there the second least of?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many furniture items are there in all?"
                    ),

                    // -------------------------------------------------
                    // 190. HOUSEHOLD ITEMS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOUSEHOLDITEMS",
                            "The chart shows the number of different household items in a home.",

                            new String[]
                                    {
                                            "Lamps",
                                            "Clocks",
                                            "Fans",
                                            "Mirrors"
                                    },

                            new String[]
                                    {
                                            "Lamps",
                                            "Clocks",
                                            "Fans",
                                            "Mirrors"
                                    },

                            "item",
                            "items",

                            "Which household item is there the most of?",
                            "Which household item is there the least of?",
                            "Which household item is there the second most of?",
                            "Which household item is there the second least of?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many household items are there in all?"
                    ),

                    // -------------------------------------------------
                    // 191. VEGETABLE GARDEN
                    // -------------------------------------------------
                    new BarChartScenario(
                            "VEGGARDEN",
                            "The chart shows the number of vegetables growing in a home garden.",

                            new String[]
                                    {
                                            "Tomatoes",
                                            "Carrots",
                                            "Beans",
                                            "Spinach"
                                    },

                            new String[]
                                    {
                                            "Tomatoes",
                                            "Carrots",
                                            "Beans",
                                            "Spinach"
                                    },

                            "plant",
                            "plants",

                            "Which vegetable has the most plants?",
                            "Which vegetable has the fewest plants?",
                            "Which vegetable has the second most plants?",
                            "Which vegetable has the second fewest plants?",

                            "How many %s plants are there?",
                            "How many more %s plants are there than %s plants?",
                            "How many fewer %s plants are there than %s plants?",
                            "How many %s and %s plants are there altogether?",
                            "How many vegetable plants are there in all?"
                    ),

                    // -------------------------------------------------
                    // 192. GARDENING ACTIVITIES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "GARDENACTIVITIES",
                            "The chart shows the number of times a family did different gardening activities.",

                            new String[]
                                    {
                                            "Watering",
                                            "Planting",
                                            "Weeding",
                                            "Digging"
                                    },

                            new String[]
                                    {
                                            "Watering",
                                            "Planting",
                                            "Weeding",
                                            "Digging"
                                    },

                            "activity",
                            "activities",

                            "Which gardening activity was done the most?",
                            "Which gardening activity was done the least?",
                            "Which gardening activity was done the second most?",
                            "Which gardening activity was done the second least?",

                            "How many times was %s done?",
                            "How many more times was %s done than %s?",
                            "How many fewer times was %s done than %s?",
                            "How many times were %s and %s done altogether?",
                            "How many gardening activities were done in all?"
                    ),
                    // -------------------------------------------------
                    // 193. FAVOURITE SCHOOL SUBJECTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "FAVSUBJECTS",
                            "The chart shows the favourite school subjects of students in a class.",

                            new String[]
                                    {
                                            "Maths",
                                            "Science",
                                            "English",
                                            "Art"
                                    },

                            new String[]
                                    {
                                            "Maths",
                                            "Science",
                                            "English",
                                            "Art"
                                    },

                            "student",
                            "students",

                            "Which subject is liked by the most students?",
                            "Which subject is liked by the fewest students?",
                            "Which subject is liked by the second most students?",
                            "Which subject is liked by the second fewest students?",

                            "How many students like %s?",
                            "How many more students like %s than %s?",
                            "How many fewer students like %s than %s?",
                            "How many students like %s and %s altogether?",
                            "How many students are represented in all?"
                    ),

                    // -------------------------------------------------
                    // 194. BOOKS READ
                    // -------------------------------------------------
                    new BarChartScenario(
                            "BOOKSREAD",
                            "The chart shows the number of books read by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "book",
                            "books",

                            "Who read the most books?",
                            "Who read the fewest books?",
                            "Who read the second most books?",
                            "Who read the second fewest books?",

                            "How many books did %s read?",
                            "How many more books did %s read than %s?",
                            "How many fewer books did %s read than %s?",
                            "How many books did %s and %s read altogether?",
                            "How many books were read in all?"
                    ),

                    // -------------------------------------------------
                    // 195. TEST SCORES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "TESTSCORES",
                            "The chart shows the test scores of four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "mark",
                            "marks",

                            "Who scored the most marks?",
                            "Who scored the fewest marks?",
                            "Who scored the second most marks?",
                            "Who scored the second fewest marks?",

                            "How many marks did %s score?",
                            "How many more marks did %s score than %s?",
                            "How many fewer marks did %s score than %s?",
                            "How many marks did %s and %s score altogether?",
                            "How many marks were scored by the four students in all?"
                    ),

                    // -------------------------------------------------
                    // 196. HOMEWORK COMPLETED
                    // -------------------------------------------------
                    new BarChartScenario(
                            "HOMEWORK",
                            "The chart shows the number of homework assignments completed by four students.",

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            new String[]
                                    {
                                            "Aarav",
                                            "Riya",
                                            "Kabir",
                                            "Anaya"
                                    },

                            "assignment",
                            "assignments",

                            "Who completed the most assignments?",
                            "Who completed the fewest assignments?",
                            "Who completed the second most assignments?",
                            "Who completed the second fewest assignments?",

                            "How many assignments did %s complete?",
                            "How many more assignments did %s complete than %s?",
                            "How many fewer assignments did %s complete than %s?",
                            "How many assignments did %s and %s complete altogether?",
                            "How many assignments were completed in all?"
                    ),

                    // -------------------------------------------------
                    // 197. CLASS PROJECTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CLASSPROJECTS",
                            "The chart shows the number of class projects completed by four groups.",

                            new String[]
                                    {
                                            "Group A",
                                            "Group B",
                                            "Group C",
                                            "Group D"
                                    },

                            new String[]
                                    {
                                            "Group A",
                                            "Group B",
                                            "Group C",
                                            "Group D"
                                    },

                            "project",
                            "projects",

                            "Which group completed the most projects?",
                            "Which group completed the fewest projects?",
                            "Which group completed the second most projects?",
                            "Which group completed the second fewest projects?",

                            "How many projects did %s complete?",
                            "How many more projects did %s complete than %s?",
                            "How many fewer projects did %s complete than %s?",
                            "How many projects did %s and %s complete altogether?",
                            "How many projects were completed in all?"
                    ),

                    // -------------------------------------------------
                    // 198. SCHOOL LIBRARY BOOKS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "LIBRARYBOOKS",
                            "The chart shows the number of books borrowed by students from different sections of the school library.",

                            new String[]
                                    {
                                            "Story Books",
                                            "Science Books",
                                            "History Books",
                                            "Picture Books"
                                    },

                            new String[]
                                    {
                                            "Story",
                                            "Science",
                                            "History",
                                            "Picture"
                                    },

                            "book",
                            "books",

                            "Which section had the most books borrowed?",
                            "Which section had the fewest books borrowed?",
                            "Which section had the second most books borrowed?",
                            "Which section had the second fewest books borrowed?",

                            "How many books were borrowed from the %s section?",
                            "How many more books were borrowed from the %s section than the %s section?",
                            "How many fewer books were borrowed from the %s section than the %s section?",
                            "How many books were borrowed from the %s and %s sections altogether?",
                            "How many books were borrowed in all?"
                    ),

                    // -------------------------------------------------
                    // 199. SCHOOL ATTENDANCE
                    // -------------------------------------------------
                    new BarChartScenario(
                            "ATTENDANCE",
                            "The chart shows the number of students present on different days of a school week.",

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

                            "On which day were the most students present?",
                            "On which day were the fewest students present?",
                            "On which day were the second most students present?",
                            "On which day were the second fewest students present?",

                            "How many students were present on %s?",
                            "How many more students were present on %s than %s?",
                            "How many fewer students were present on %s than %s?",
                            "How many students were present on %s and %s altogether?",
                            "How many student attendances were recorded in all?"
                    ),

                    // -------------------------------------------------
                    // 200. SCHOOL CANTEEN SALES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "CANTEENSALES",
                            "The chart shows the number of different items sold at the school canteen.",

                            new String[]
                                    {
                                            "Sandwiches",
                                            "Samosas",
                                            "Juice",
                                            "Idlis"
                                    },

                            new String[]
                                    {
                                            "Sandwiches",
                                            "Samosas",
                                            "Juice",
                                            "Idlis"
                                    },

                            "item",
                            "items",

                            "Which item was sold the most?",
                            "Which item was sold the least?",
                            "Which item was sold the second most?",
                            "Which item was sold the second least?",

                            "How many %s were sold?",
                            "How many more %s were sold than %s?",
                            "How many fewer %s were sold than %s?",
                            "How many %s and %s were sold altogether?",
                            "How many canteen items were sold in all?"
                    ),

                    // -------------------------------------------------
                    // 201. SCHOOL SUPPLIES
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SCHOOLSUPPLIES",
                            "The chart shows the number of different school supplies collected by a class.",

                            new String[]
                                    {
                                            "Pencils",
                                            "Erasers",
                                            "Notebooks",
                                            "Crayons"
                                    },

                            new String[]
                                    {
                                            "Pencils",
                                            "Erasers",
                                            "Notebooks",
                                            "Crayons"
                                    },

                            "item",
                            "items",

                            "Which school supply is there the most of?",
                            "Which school supply is there the least of?",
                            "Which school supply is there the second most of?",
                            "Which school supply is there the second least of?",

                            "How many %s are there?",
                            "How many more %s are there than %s?",
                            "How many fewer %s are there than %s?",
                            "How many %s and %s are there altogether?",
                            "How many school supplies are there in all?"
                    ),

                    // -------------------------------------------------
                    // 202. SCIENCE EXPERIMENTS
                    // -------------------------------------------------
                    new BarChartScenario(
                            "SCIENCEEXPERIMENTS",
                            "The chart shows the number of science experiments completed by four groups.",

                            new String[]
                                    {
                                            "Group A",
                                            "Group B",
                                            "Group C",
                                            "Group D"
                                    },

                            new String[]
                                    {
                                            "Group A",
                                            "Group B",
                                            "Group C",
                                            "Group D"
                                    },

                            "experiment",
                            "experiments",

                            "Which group completed the most experiments?",
                            "Which group completed the fewest experiments?",
                            "Which group completed the second most experiments?",
                            "Which group completed the second fewest experiments?",

                            "How many experiments did %s complete?",
                            "How many more experiments did %s complete than %s?",
                            "How many fewer experiments did %s complete than %s?",
                            "How many experiments did %s and %s complete altogether?",
                            "How many experiments were completed in all?"
                    ),
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

        /*if(scenario.scenarioCode == "IPL") {
            // Special handling for First SCENARIO (IPL teams)
            IplTeam[] teams = getRandomIplTeams();
            for (int i = 0; i < teams.length; i++) {
                labels[i] = teams[i].name;
                displayLabels[i] = teams[i].shortName;
            }
        }*/

        switch(scenario.scenarioCode)
        {
            case "IPL":
                IplTeam[] teams = getRandomIplTeams();
                for (int i = 0; i < teams.length; i++) {
                    labels[i] = teams[i].name;
                    displayLabels[i] = teams[i].shortName;
                }

                break;

            case "ARTPROJECTS":
            case "BOOKSREAD":
            case "CERTIFICATES":
            case "CHORES":
            case "COINS":
            case "CRAFTITEMS":
            case "DANCEPRACTICE":
            case "DRAWINGS":
            case "GAMESPLAYED":
            case "HEALTHYSNACKS":
            case "HOBBYCLASSES":
            case "LIBRARYVISITS":
            case "MATHPROBLEMS":
            case "MILK":
            case "MONEYSAVED":
            case "MONEYSPENT":
            case "MOVIESWATCHED":
            case "PAINTINGS":
            case "POCKETMONEY":
            case "READINGTIME":
            case "PLAYINGTIME":
            case "HOMEWORK":
            case "NEWWORDS":
            case "QUESTIONS":
            case "SONGS":
            case "STEPS":
            case "SPELLING":
            case "SPORTSPRACTICE":
            case "SPORTSEVENTS":
            case "STICKERS":
            case "STORIESREAD":
            case "TESTSCORES":
            case "TOYS":
            case "WATERDRUNK":
                labels = PersonNameUtil.getDifferentNames(4);
                displayLabels = labels;
                break;

            case "RUNS":
                if(RANDOM.nextBoolean()) {
                    labels = PersonNameUtil.getDifferentMaleNames(4);
                }
                else {
                    labels = PersonNameUtil.getDifferentFemaleNames(4);
                }
                displayLabels = labels;
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
