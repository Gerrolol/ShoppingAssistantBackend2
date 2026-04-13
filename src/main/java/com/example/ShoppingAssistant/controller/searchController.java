package com.example.ShoppingAssistant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShoppingAssistant.dto.itemsList;
import com.example.ShoppingAssistant.dto.searchListResponseDto;
import com.example.ShoppingAssistant.dto.searchResultDto;
import com.example.ShoppingAssistant.service.searchService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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
    
    @GetMapping("/cheapest")
    public searchResultDto findCheapest(@RequestParam String productName){
        return searchService.cheapest(productName);
    }

    @PostMapping("/cheapest/list")
    public searchListResponseDto findAllCheapest(@RequestBody itemsList itemsList){
        return searchService.cheapestStore(itemsList);
    }
}
