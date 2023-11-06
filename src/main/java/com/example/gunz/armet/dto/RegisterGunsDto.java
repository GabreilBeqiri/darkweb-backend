package com.example.gunz.armet.dto;


import java.util.Date;

public class RegisterGunsDto {

    public String gun_name;
    public String range_of_fire;
    public String guns_length;
    public String in_service;
    public String  fire_rate;
    public String  purpose;
    public String  price;



    public RegisterGunsDto(String gun_name, String range_of_fire, String guns_length, String in_service , String fire_rate, String purpose , String price) {
        this.gun_name = gun_name;
        this.range_of_fire = range_of_fire;
        this.guns_length = guns_length;
        this.in_service = in_service;
        this.fire_rate= fire_rate;
        this.purpose = purpose;
        this.price=price;

    }
    public String getGun_name() {
        return gun_name ;
    }

    public String getRange_of_fire() {
        return range_of_fire;}

    public String getGuns_length() {
        return guns_length;
    }

    public String getIn_service() {
        return in_service;
    }

    public String getFire_rate() {
        return fire_rate;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getPrice() {
        return price;
    }

    public void setGun_name(String gun_name) {
        this.gun_name = gun_name;
    }

    public void setRange_of_fire(String range_of_fire) {
        this.range_of_fire = range_of_fire;
    }

    public void setGuns_length(String guns_length) {
        this.guns_length = guns_length;
    }

    public void setIn_service(String in_service) {
        this.in_service = in_service;
    }

    public void setFire_rate(String fire_rate) {
        this.fire_rate = fire_rate;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
