package com.example.gunz.user;

import com.example.gunz.accessories.Accessories;
import com.example.gunz.armet.Armet;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String idNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String role;
    public Set<Armet> getSelectedGuns() {
        return selectedGuns;
    }

    public void setSelectedGuns(Set<Armet> selectedGuns) {
        this.selectedGuns = selectedGuns;
    }

    @ManyToMany
    Set<Armet> selectedGuns;
    @ManyToMany
    Set<Accessories> selectedAccess;
    public Set<Accessories> getSelectedAccess() {
        return selectedAccess;
    }
    public void setSelectedAccess(Set<Accessories> selectedAccess) {
        this.selectedAccess = selectedAccess;
    }




    public User(){

    }
    public User(String name,  String surname, String idNumber,String email, String password,String role) {
        this.name=name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.email=email;
        this.password = password;
        this.role = role;
    }
    public User(String idNumber, String password) {
        this.idNumber = idNumber;
        this.password = password;
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


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
