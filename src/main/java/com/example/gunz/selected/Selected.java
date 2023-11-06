package com.example.gunz.selected;

import jakarta.persistence.*;
@Entity
@Table(name = "Selected")

public class  Selected {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gun_name;
    @Column(nullable = false)
    private String price;
    public Selected( String name ,String gun_name, String price) {
       this.name = name;
        this.gun_name = gun_name;
        this.price = price;
    }

    public Selected() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGun_name() {
        return gun_name;
    }

    public void setGun_name(String gun_name) {
        this.gun_name = gun_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
