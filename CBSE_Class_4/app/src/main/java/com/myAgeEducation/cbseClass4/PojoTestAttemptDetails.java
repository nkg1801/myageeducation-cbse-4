package com.myAgeEducation.cbseClass4;

import com.shaded.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)

public class PojoTestAttemptDetails {
    private String attempt1Score;
    private String attempt2Score;
    private String attempt3Score;
    private String attempt4Score;
    private String attempt5Score;
    private String attempt6Score;
    private String attempt7Score;
    private String attempt8Score;
    private String attempt9Score;
    private String attempt10Score;
    private int attempts;
    private int lastAttemptScore;

    public PojoTestAttemptDetails()
    {
        attempt1Score = "";
        attempt2Score = "";
        attempt3Score = "";
        attempt4Score = "";
        attempt5Score = "";
        attempt6Score = "";
        attempt7Score = "";
        attempt8Score = "";
        attempt9Score = "";
        attempt10Score = "";
        attempts = 0;
        lastAttemptScore = -1;
    }

    public String getAttempt1Score() {
        return attempt1Score;
    }

    public void setAttempt1Score(String attempt1Score) {
        this.attempt1Score = attempt1Score;
    }

    public String getAttempt2Score() {
        return attempt2Score;
    }

    public void setAttempt2Score(String attempt2Score) {
        this.attempt2Score = attempt2Score;
    }

    public String getAttempt3Score() {
        return attempt3Score;
    }

    public void setAttempt3Score(String attempt3Score) {
        this.attempt3Score = attempt3Score;
    }

    public String getAttempt4Score() {
        return attempt4Score;
    }

    public void setAttempt4Score(String attempt4Score) {
        this.attempt4Score = attempt4Score;
    }

    public String getAttempt5Score() {
        return attempt5Score;
    }

    public void setAttempt5Score(String attempt5Score) {
        this.attempt5Score = attempt5Score;
    }

    public String getAttempt6Score() {
        return attempt6Score;
    }

    public void setAttempt6Score(String attempt6Score) {
        this.attempt6Score = attempt6Score;
    }

    public String getAttempt7Score() {
        return attempt7Score;
    }

    public void setAttempt7Score(String attempt7Score) {
        this.attempt7Score = attempt7Score;
    }

    public String getAttempt8Score() {
        return attempt8Score;
    }

    public void setAttempt8Score(String attempt8Score) {
        this.attempt8Score = attempt8Score;
    }

    public String getAttempt9Score() {
        return attempt9Score;
    }

    public void setAttempt9Score(String attempt9Score) {
        this.attempt9Score = attempt9Score;
    }

    public String getAttempt10Score() {
        return attempt10Score;
    }

    public void setAttempt10Score(String attempt10Score) {
        this.attempt10Score = attempt10Score;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }


    public int getLastAttemptScore() {
        return lastAttemptScore;
    }

    public void setLastAttemptScore(int lastAttemptScore) {
        this.lastAttemptScore = lastAttemptScore;
    }
}
