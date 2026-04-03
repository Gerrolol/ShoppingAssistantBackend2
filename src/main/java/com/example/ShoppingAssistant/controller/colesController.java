package com.example.ShoppingAssistant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ShoppingAssistant.client.colesClient;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.service.colesService;

@RestController
@RequestMapping("/api/coles")
public class colesController {
    private final colesService colesService;
    
    colesController(colesService colesService, colesClient colesClient){
        this.colesService = colesService;
    }
    
    @PostMapping("/add")
    public void addItem(@RequestBody item item){
        colesService.create(item);
    }

    @PostMapping("/fetch")
    public void fetch(@RequestParam String productName){
        colesService.add(productName);
    }
}
