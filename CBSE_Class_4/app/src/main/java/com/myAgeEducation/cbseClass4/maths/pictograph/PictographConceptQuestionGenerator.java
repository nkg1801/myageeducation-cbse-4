package com.myAgeEducation.cbseClass4.maths.pictograph;

import com.myAgeEducation.cbsecommon.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PictographConceptQuestionGenerator
{
    private static final Random RANDOM = new Random();

    private static class ConceptQuestion
    {
        String question;
        String correctAnswer;
        String[] wrongAnswers;

        ConceptQuestion(String question, String correctAnswer, String... wrongAnswers)
        {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.wrongAnswers = wrongAnswers;
        }
    }

    private static final ConceptQuestion[] QUESTIONS =
            {
                    new ConceptQuestion(
                            "A _______ uses pictures or symbols to represent information.",
                            "pictograph",
                            "bar graph",
                            "table",
                            "number line"),

                    new ConceptQuestion(
                            "In a pictograph, pictures or symbols are used to represent _______.",
                            "information",
                            "sentences",
                            "fractions",
                            "shapes"),

                    new ConceptQuestion(
                            "The meaning or value of each symbol in a pictograph is shown by the _______.",
                            "key",
                            "title",
                            "question",
                            "row"),

                    new ConceptQuestion(
                            "In a pictograph, one symbol may represent _______ item.",
                            "more than one",
                            "only one",
                            "no",
                            "less than zero"),

                    new ConceptQuestion(
                            "Which of the following uses pictures or symbols to show data?",
                            "Pictograph",
                            "Number line",
                            "Clock",
                            "Calendar"),

                    new ConceptQuestion(
                            "What helps us understand the value of each symbol in a pictograph?",
                            "Key",
                            "Heading",
                            "Border",
                            "Colour")
            };

    public static Question generateQuestion()
    {
        ConceptQuestion data = QUESTIONS[RANDOM.nextInt(QUESTIONS.length)];
        List<String> options = new ArrayList<>();
        options.add(data.correctAnswer);

        Collections.addAll(options, data.wrongAnswers);
        Collections.shuffle(options);
        Question question = new Question();

        question.setQuestion(data.question);
        question.setOption1(options.get(0));
        question.setOption2(options.get(1));
        question.setOption3(options.get(2));
        question.setOption4(options.get(3));
        question.setAnswer(data.correctAnswer);

        return question;
    }
}