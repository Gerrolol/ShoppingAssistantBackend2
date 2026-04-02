package com.example.ShoppingAssistant.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.service.aldiService;

@RestController
@RequestMapping("/api/aldi")
public class aldiController {
    private final aldiService aldiService;

    public aldiController(aldiService aldiService){
        this.aldiService = aldiService;
    }

    @GetMapping("/fetch")
    public void fetchRealData(@RequestParam String productCode){
        aldiService.fetchAdd(productCode);
    }

    @PostMapping("/add/item")
    public void addItem(@RequestBody item item){
        aldiService.create(item);
    }
}
