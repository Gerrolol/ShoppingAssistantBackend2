package com.example.ShoppingAssistant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Woolies {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String itemName;
    private int price;

    public Long getId(){
        return id;
    }
    public String getitemName(){
        return itemName;
    }
    public int getPrice(){
        return price;
    }
}
