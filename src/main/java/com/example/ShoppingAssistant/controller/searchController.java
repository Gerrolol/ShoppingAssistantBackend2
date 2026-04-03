package com.example.ShoppingAssistant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ShoppingAssistant.dto.searchResultDto;
import com.example.ShoppingAssistant.service.searchService;

@RestController
@RequestMapping("/search")
public class searchController {
    private final searchService searchService;
    
    searchController(searchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/find/all")
    public List<searchResultDto> findItemAllshops(@RequestParam String productName){
        return searchService.search(productName);
    }
}
