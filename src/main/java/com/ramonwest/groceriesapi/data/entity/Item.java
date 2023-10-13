package com.ramonwest.groceriesapi.data.entity;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name="grocery_items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grocery_item_id")
    private Long itemId;

    @Column(name = "name")
    private String name;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "item_duration")
    private int duration;

    public Long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
