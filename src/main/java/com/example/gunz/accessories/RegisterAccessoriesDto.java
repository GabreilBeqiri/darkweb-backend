package com.example.gunz.accessories;

public class RegisterAccessoriesDto {
    public String acc_name;
    public String description;
    public String price;

    public RegisterAccessoriesDto(String acc_name, String description,  String price) {
        this.acc_name = acc_name;
        this.description = description;
        this.price=price;}

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
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
}
