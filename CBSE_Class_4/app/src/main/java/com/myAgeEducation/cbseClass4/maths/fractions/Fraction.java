package com.myAgeEducation.cbseClass4.maths.fractions;

import androidx.annotation.NonNull;

public class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @NonNull
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
