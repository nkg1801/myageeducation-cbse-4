package com.myAgeEducation.cbseClass4.maths.additions;

    public final class AdditionStoryTemplates {
        private AdditionStoryTemplates() {
        }

        public static final AdditionStoryTemplate[] SMALLER_NUMBER_TEMPLATES =
                {
                        /*
                        %1$s	Main person's name
                        %2$s	First number
                        %3$s	Second person's name (friend, giver, etc.)
                        %4$s	Second number
                        %5$s	Possessive pronoun ("His"/"Her")
                        %6$s	Object pronoun ("him"/"her")
                         */

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s has %2$s stamps. %3$s gives %1$s %4$s more stamps. How many stamps does %1$s have now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s has %2$s story books. %5$s mother buys %6$s %4$s more story books. How many story books does %1$s have now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s has %2$s marbles. %3$s gives %1$s %4$s more marbles. How many marbles does %1$s have now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "%1$s picked %2$s shells. %3$s picked %4$s shells. How many shells did they pick altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "%1$s collected %2$s leaves. %3$s collected %4$s leaves. How many leaves did they collect altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.GROUP_GROWS,
                                "There are %2$s children in a class. %4$s more children join. How many children are there altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.GROUP_GROWS,
                                "There are %2$s birds on a tree. %4$s more birds come. How many birds are there now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PARTS,
                                "%1$s has %2$s balloons in one hand and %4$s balloons in the other. How many balloons does %1$s have altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PARTS,
                                "%1$s has %2$s pencils in one box and %4$s pencils in another box. How many pencils does %1$s have altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.UNKNOWN_START,
                                "%1$s sold %2$s cards. %1$s still has %4$s cards left. How many cards had %1$s made?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.UNKNOWN_START,
                                "%1$s ate %2$s chocolates. %1$s still has %4$s chocolates left. How many chocolates did %1$s have at first?")
                };

        public static final AdditionStoryTemplate[] BIGGER_NUMBER_TEMPLATES =
                {
                        /*
                        %1$s	Main person's name / Entity 1
                        %2$s	First number
                        %3$s	Second person's name / Entity 2
                        %4$s	Second number
                        %5$s	Possessive pronoun ("His"/"Her")
                        %6$s	Object pronoun ("him"/"her")
                         */

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A factory produced %2$s bulbs on Monday and %4$s bulbs on Tuesday. How many bulbs did it produce in two days?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "In a town, there are %2$s men and %4$s women. What is the total population of the town?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A farmer produced %2$s kg of wheat and %4$s kg of rice. What is the total production of grains?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s bought a laptop for ₹%2$s and a mobile phone for ₹%4$s. How much did %1$s spend in all?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PARTS,
                                "There are %2$s bags of sugar in one godown and %4$s bags in another. How many bags are there in both godowns?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.GROUP_GROWS,
                                "A library has %2$s English books. It bought %4$s more new books. How many books does the library have now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "In an examination, %2$s students passed and %4$s students failed. How many students appeared for the exam?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A milk booth sold %2$s litres of milk in the morning and %4$s litres in the evening. How much milk was sold that day?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "In a forest, there are %2$s teak trees and %4$s neem trees. How many trees are there in the forest altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.UNKNOWN_START,
                                "A shopkeeper sold %2$s notebooks and still has %4$s notebooks left. How many notebooks did he have at first?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A truck carried %2$s bricks in the first trip and %4$s bricks in the second trip. How many bricks did it carry in total?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "The %1$s family car has done %2$s km this year and %4$s km last year. How many kilometers has it done in all?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A post office delivered %2$s letters in January and %4$s letters in February. How many letters were delivered in two months?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s had ₹%2$s in a bank account. %5$s father deposited ₹%4$s more. How much money is there now in the account?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A stadium has a seating capacity of %2$s in the East stand and %4$s in the West stand. What is the total seating capacity?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A school uniform set costs ₹%2$s and a set of books costs ₹%4$s. How much will a parent spend on both items?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PARTS,
                                "An aeroplane flew %2$s km in the first leg of its journey and %4$s km in the second leg. How many kilometers did it fly in total?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "In a primary school, there are %2$s boys and %4$s girls. How many students are there in the school?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "A wholesale merchant bought %2$s kg of apples and %4$s kg of oranges. What is the total weight of the fruits?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A city has %2$s private cars and %4$s commercial vehicles. How many vehicles are there in the city altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "In an election, candidate A got %2$s votes and candidate B got %4$s votes. How many votes were polled in all?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "The distance between two cities by train is %2$s km and by bus is %4$s km. What is the total distance covered by a traveler using both?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "A businessman earned ₹%2$s last month and ₹%4$s this month. What is his total earning for the two months?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.GROUP_GROWS,
                                "A state government planted %2$s trees in one year and %4$s trees in the next year. How many trees were planted in two years?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PARTS,
                                "A godown has %2$s bags of rice and %4$s bags of wheat. How many bags of grains are there in the godown?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "For a charity event, one school collected ₹%2$s and another school collected ₹%4$s. How much money was collected in total?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A printing press printed %2$s newspapers in the morning and %4$s newspapers in the evening. How many newspapers were printed that day?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "In a book fair, %2$s books were sold on Saturday and %4$s books were sold on Sunday. How many books were sold in the weekend?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "A water tank had %2$s litres of water. A pump added %4$s more litres to it. What is the total capacity of the water in the tank now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A dairy farm produced %2$s litres of milk in one week and %4$s litres in the second week. What is the total milk production?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A construction company used %2$s bags of cement in January and %4$s bags in February. How many bags of cement were used in all?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "Last month, %2$s tourists visited a museum. This month, %4$s more tourists visited it. What is the total number of tourists?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "An e-commerce company delivered %2$s packages in Delhi and %4$s packages in Mumbai. How many packages were delivered in both cities?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A textile mill produced %2$s metres of cotton cloth and %4$s metres of silk cloth. What is the total length of cloth produced?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A hospital treated %2$s patients in the general ward and %4$s patients in the special ward. How many patients were treated in total?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "Two cargo ships carried %2$s tonnes and %4$s tonnes of goods respectively. What is the total weight carried by both ships?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "In a vaccination drive, %2$s people were vaccinated in the first week and %4$s people in the second week. How many were vaccinated?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A family spent ₹%2$s on groceries and ₹%4$s on clothing last month. What was their total expenditure on these items?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A soft drink company produced %2$s bottles of orange juice and %4$s bottles of apple juice. How many bottles were produced?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "There are %2$s employees in the Bangalore office of a company and %4$s in the Hyderabad office. How many employees are there in both?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A government project built %2$s houses for the poor in one district and %4$s houses in another district. How many houses were built?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A solar plant generated %2$s units of electricity on Monday and %4$s units on Tuesday. How much electricity was generated?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A farmer spent ₹%2$s on seeds and ₹%4$s on fertilizers. How much did he spend in total?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A charity foundation served %2$s meals to homeless people last year and %4$s meals this year. How many meals have they served?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "A publishing house printed %2$s copies of a math book and %4$s copies of a science book. How many books were printed in all?")
                };
    }
