package com.example.gunz.accessories;

import jakarta.persistence.*;

@Entity
public class Accessories {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String acc_name;
    @Column(nullable = false)
    private String  description ;
    @Column(nullable = false)
    private String price;
    @Column(nullable = true)
    private String path;

    public Accessories(){

    }
    public Accessories(String acc_name,  String description,  String price) {
        this.acc_name = acc_name;
       this.description= description;
        this.price=price ;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
