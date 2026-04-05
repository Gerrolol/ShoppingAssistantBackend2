package com.example.ShoppingAssistant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ShoppingAssistant.client.wooliesClient;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.dto.itemsList;
import com.example.ShoppingAssistant.service.wooliesService;

@RestController
@RequestMapping("/api/woolies")
public class wooliesController {
    private final wooliesService wooliesService;
    
    wooliesController(wooliesService wooliesService, wooliesClient wooliesClient){
        this.wooliesService = wooliesService;
    }
    
    @PostMapping("/add")
    public void addItem(@RequestBody item item){
        wooliesService.create(item);
    }

    @PostMapping("/fetch")
    public void fetch(@RequestParam String productName){
        wooliesService.add(productName);
    }

    @GetMapping("/find/item")
    public List<item> findListItem(@RequestBody itemsList itemsList){
        return wooliesService.retrieve(itemsList);
    }


}
