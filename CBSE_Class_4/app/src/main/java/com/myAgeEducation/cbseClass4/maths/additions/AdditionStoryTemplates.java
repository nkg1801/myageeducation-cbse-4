package com.myAgeEducation.cbseClass4.maths.additions;

    public final class AdditionStoryTemplates {
        private AdditionStoryTemplates() {
        }

        public static final AdditionStoryTemplate[] TEMPLATES =
                {
                        /*
                        %1$s	Main person's name
                        %2$d	First number
                        %3$s	Second person's name (friend, giver, etc.)
                        %4$d	Second number
                        %5$s	Possessive pronoun ("His"/"Her")
                        %6$s	Object pronoun ("him"/"her")
                         */

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s has %2$d stamps. %3$s gives %1$s %4$d more stamps. How many stamps does %1$s have now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s has %2$d story books. %5$s mother buys %6$s %4$d more story books. How many story books does %1$s have now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.HAS_MORE,
                                "%1$s has %2$d marbles. %3$s gives %1$s %4$d more marbles. How many marbles does %1$s have now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "%1$s picked %2$d shells. %3$s picked %4$d shells. How many shells did they pick altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PEOPLE,
                                "%1$s collected %2$d leaves. %3$s collected %4$d leaves. How many leaves did they collect altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.GROUP_GROWS,
                                "There are %2$d children in a class. %4$d more children join. How many children are there altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.GROUP_GROWS,
                                "There are %2$d birds on a tree. %4$d more birds come. How many birds are there now?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PARTS,
                                "%1$s has %2$d balloons in one hand and %4$d balloons in the other. How many balloons does %1$s have altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.TWO_PARTS,
                                "%1$s has %2$d pencils in one box and %4$d pencils in another box. How many pencils does %1$s have altogether?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.UNKNOWN_START,
                                "%1$s sold %2$d cards. %1$s still has %4$d cards left. How many cards had %1$s made?"),

                        new AdditionStoryTemplate(
                                AdditionStoryType.UNKNOWN_START,
                                "%1$s ate %2$d chocolates. %1$s still has %4$d chocolates left. How many chocolates did %1$s have at first?")
                };
    }
