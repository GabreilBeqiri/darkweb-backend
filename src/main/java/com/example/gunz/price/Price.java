package com.example.gunz.price;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "Price")
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;


    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(nullable = false)
    private Integer sales;
    public Price() {}
    public Price( Integer sales)
    {
        this.sales = sales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSales() {
        return sales;
    }
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) createdAt = new Date();
    }
}
