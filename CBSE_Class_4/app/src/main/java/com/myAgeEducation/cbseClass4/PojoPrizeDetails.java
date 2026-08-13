package com.myAgeEducation.cbseClass4;

import com.shaded.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)

public class PojoPrizeDetails {
    private String image;
    private String description;
    private String price;
    private String productLink;

    public PojoPrizeDetails(){

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }
}
