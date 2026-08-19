package com.myAgeEducation.cbseClass4.maths.fractions;

//import static com.myAgeEducation.cbseClass3.maths.Fractions.FractionSeriesGenerator.generateAscendingSeries;
//import static com.myAgeEducation.cbseClass3.maths.Fractions.FractionSeriesGenerator.generateNonAscendingSeries;

import com.myAgeEducation.cbsecommon.Question;

import java.util.Random;

public class FractionSeriesQuestion {

    private final Fraction[][] series;
    private final int correctAnswerIndex;

    public FractionSeriesQuestion(Fraction[][] series, int correctAnswerIndex) {
        this.series = series;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public Fraction[][] getSeries() {
        return series;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }


    public static FractionSeriesQuestion generateQuestion() {
        Random random = new Random();
        Fraction[][] allSeries = new Fraction[4][];

        // Randomly decide which series will be incorrect
        int wrongSeriesIndex = random.nextInt(4);

        /*for (int i = 0; i < 4; i++) {

            if (i == wrongSeriesIndex) {
                allSeries[i] = generateNonAscendingSeries();
            } else {
                allSeries[i] = generateAscendingSeries();
            }
        }*/

        Question question = new Question();
        question.setQuestion("Which of the following series is not in ascending order");
        question.setAnswer("Series No:" + allSeries[wrongSeriesIndex] + 1);
        //question.setOption1();

        return new FractionSeriesQuestion(allSeries, wrongSeriesIndex);
    }
}
