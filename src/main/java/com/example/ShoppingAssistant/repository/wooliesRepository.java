package com.example.ShoppingAssistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ShoppingAssistant.model.Woolies;

public interface wooliesRepository extends JpaRepository<Woolies, Long>{
    
}
