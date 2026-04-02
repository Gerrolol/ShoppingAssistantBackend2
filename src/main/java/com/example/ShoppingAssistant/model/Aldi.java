package com.example.ShoppingAssistant.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder //default constructor.
@Entity
public class Aldi {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private String itemName;
    private BigDecimal price;
    
    public Long getId(){
        return id;
    }
    public String getitemName(){
        return itemName;
    }
    
    @Column(precision = 10, scale =2)
    public BigDecimal getPrice(){
        return price;
    }
}
