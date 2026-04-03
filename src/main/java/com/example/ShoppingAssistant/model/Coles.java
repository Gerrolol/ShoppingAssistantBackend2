package com.example.ShoppingAssistant.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coles {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String itemName;
    private BigDecimal price;

    public Long getId(){
        return id;
    }
    public String getitemName(){
        return itemName;
    }
    public BigDecimal getPrice(){
        return price;
    }
}
