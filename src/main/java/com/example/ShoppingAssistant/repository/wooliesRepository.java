package com.example.ShoppingAssistant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ShoppingAssistant.model.Woolies;

public interface wooliesRepository extends JpaRepository<Woolies, Long>{
    List<Woolies> findByItemNameContainingIgnoreCase(String itemName);
}
