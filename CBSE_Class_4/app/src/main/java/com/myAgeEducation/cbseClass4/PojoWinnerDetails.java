package com.myAgeEducation.cbseClass4;

import com.shaded.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)

public class PojoWinnerDetails {
    private String winnerBase64Photo;
    private String contestName;
    private String winnerName;
    private String winnerCity;

    public PojoWinnerDetails(){

    }

    public String getWinnerBase64Photo() {
        return winnerBase64Photo;
    }

    public void setWinnerBase64Photo(String winnerBase64Photo) {
        this.winnerBase64Photo = winnerBase64Photo;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getWinnerCity() {
        return winnerCity;
    }

    public void setWinnerCity(String winnerCity) {
        this.winnerCity = winnerCity;
    }
}
