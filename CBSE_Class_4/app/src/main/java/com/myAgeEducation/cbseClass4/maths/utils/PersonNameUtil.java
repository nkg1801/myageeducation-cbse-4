package com.myAgeEducation.cbseClass4.maths.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PersonNameUtil
{
    private static final Random RANDOM = new Random();

    private static final String[] MALE_NAMES =
            {
                    "Aarav", "Aayush", "Ajay", "Akash", "Amar", "Amit", "Amol", "Animesh", "Ankur", "Anthony", "Arjun", "Arnab",
                    "Abhay",  "Aditya", "Aman", "Amar", "Amrit", "Ananth", "Anil", "Anirudh", "Ankit",
                    "Arjun", "Arun", "Ashish", "Atul", "Ayan",
                    "Benny", "Bijo", "Biman", "Binay",
                    "Dev", "Deb", "Dheeraj", "Dinesh",
                    "Ganesh", "Gaurav", "Gautam", "Giridhar", "Girish", "Gopal", "Gyanesh",
                    "Hari", "Harish", "Hitesh", "Hrithik",
                    "James", "Johny", "Jitender", "Jitin",
                    "Ishana", "Iswar",
                    "Kabir", "Kapil", "Karan", "Kartik", "Kiran", "Kishan", "Kripa", "Krishna",
                    "Madhav", "Manish", "Manjunath", "Manoj", "Mohan", "Mohit",
                    "Nagaraj", "Nand", "Nataraj", "Nilay", "Nitin",
                    "Om", "Omprakash", "Omkar",
                    "Pavan", "Peter", "Pradeep", "Prabhu", "Prasanth", "Praveen", "Pronit",
                    "Raghupathi", "Rahul", "Rajat", "Rajeev", "Rajnish", "Ram", "Raman", "Ramesh",   "Ranjeet", "Ravi", "Rohan", "Rupam",
                    "Sachin", "Sai", "Sandeep", "Sanjay", "Sanjeev", "Satya", "Shashi", "Srihari", "Suresh", "Sohan", "Sridhar", "Srikanth", "Sunil",  "Sudeep", "Sumit",
                    "Vasu", "Vijay", "Vikram", "Vinay", "Vinod", "Virat", "Vivaan"
            };

    private static final String[] FEMALE_NAMES =
            {
                    "Aditi", "Anika", "Anita", "Anjali", "Anu", "Arushi", "Asha",
                    "Gauri", "Gita", "Geeta",
                    "Karishma", "Karuna", "Kavya", "Karina", "Kavitha",
                    "Lakshmi",
                    "Manju", "Meena", "Meenu", "Meera", "Megha", "Mihika",
                    "Nandita", "Neha", "Nisha", "Nita", "Neeta",
                    "Pooja", "Poonam", "Preeti", "Priya", "Priyanka",
                    "Rita", "Ritu", "Riya",
                    "Sanjana", "Sanju", "Saniya", "Shruti", "Simran", "Sita", "Sneha", "Sunita", "Sushma",
                    "Veena"
            };


    public static String getOneName()
    {
        if (RANDOM.nextBoolean())
        {
            return getMaleName();
        }

        return getFemaleName();
    }

    public static String getMaleName()
    {
        return MALE_NAMES[RANDOM.nextInt(MALE_NAMES.length)];
    }

    public static String getFemaleName()
    {
        return FEMALE_NAMES[RANDOM.nextInt(FEMALE_NAMES.length)];
    }

    public static String[] getOneMaleAndOneFemaleName()
    {
        return new String[]
                {
                        getMaleName(),
                        getFemaleName()
                };
    }


    public static String[] getOneFemaleAndOneMaleName()
    {
        return new String[]
                {
                        getFemaleName(),
                        getMaleName()
                };
    }

    public static String[] getDifferentNames(int count)
    {
        String[] all_names = new String[MALE_NAMES.length + FEMALE_NAMES.length];
        System.arraycopy(MALE_NAMES, 0, all_names, 0, MALE_NAMES.length);
        System.arraycopy(FEMALE_NAMES, 0, all_names, MALE_NAMES.length, FEMALE_NAMES.length);
        List<String> list = Arrays.asList(all_names);
        Collections.shuffle(list);
        return list.subList(0, count).toArray(new String[count]);
    }

    private PersonNameUtil()
    {
        // Prevent object creation
    }
}
