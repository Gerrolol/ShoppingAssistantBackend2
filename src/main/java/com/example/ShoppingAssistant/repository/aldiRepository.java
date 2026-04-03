package com.example.ShoppingAssistant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ShoppingAssistant.model.Aldi;

public interface aldiRepository extends JpaRepository<Aldi, Long>{
    List<Aldi> findFirstByItemNameContainingIgnoreCase(String itemName);
}
