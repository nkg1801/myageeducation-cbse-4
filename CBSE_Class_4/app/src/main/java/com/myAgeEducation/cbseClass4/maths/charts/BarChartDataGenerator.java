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

            case "CHORES":
            case "POCKETMONEY":
            case "READINGTIME":
            case "PLAYINGTIME":
            case "HOMEWORK":
            case "TESTSCORES":
            case "STEPS":
            case "TOYS":
            case "STICKERS":
            case "COINS":
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
