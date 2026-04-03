package com.example.ShoppingAssistant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ShoppingAssistant.model.Coles;

public interface colesRepository extends JpaRepository<Coles,Long>{
    List<Coles> findByItemNameContainingIgnoreCase(String itemName);
}
