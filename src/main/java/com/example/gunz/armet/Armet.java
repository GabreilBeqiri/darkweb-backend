package com.example.gunz.armet;

import com.example.gunz.user.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Armet {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;
        @Column(nullable = false)
        private String gun_name;
        @Column(nullable = false)
        private String range_of_fire;
        @Column(nullable = false)
        private String guns_length;
        @Column(nullable = false)
        private String in_service;
        @Column(nullable = false)
        private String fire_rate;
        @Column(nullable = false)
        private String purpose;

    @Column(nullable = false)
    private String price;

    @Column(nullable = true)
    private String path;

    @ManyToMany
    Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Armet(){

        }
        public Armet(String gun_name,  String range_of_fire, String guns_length,String in_service ,String fire_rate,String purpose , String price) {
            this.gun_name = gun_name;
            this.range_of_fire = range_of_fire;
            this.guns_length = guns_length;
            this.in_service = in_service;
            this.fire_rate = fire_rate;
            this.purpose = purpose;
            this.price=price ;

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getGun_name() {
            return gun_name;
        }

        public void setGun_name(String gun_name) {
            this.gun_name = gun_name;
        }

        public String getRange_of_fire() {
            return range_of_fire;
        }

        public String getGuns_length() {
            return guns_length;
        }

        public String getIn_service() {
            return in_service;
        }

        public String getFire_rate() {
            return fire_rate;
        }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurpose() {
            return purpose;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPurpose(String purpose) {
            this.purpose = purpose;
        }
    }

