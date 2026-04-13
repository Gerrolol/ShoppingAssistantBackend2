package com.example.ShoppingAssistant.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ShoppingAssistant.client.colesClient;
import com.example.ShoppingAssistant.dto.colesProductDto;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.dto.itemsList;
import com.example.ShoppingAssistant.service.colesService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping("/find/item")
    public List<item> findListItem(@RequestBody itemsList itemsList){
        return colesService.retrieve(itemsList);
    }

    @GetMapping("/get/List")
    public ResponseEntity<List<colesProductDto>>GetList(@RequestParam String item){
        List<colesProductDto> options = colesService.retrieveList(item);
        if(options == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(options);
    }

    @PostMapping("convert/add")
    public void convertAdd(@RequestBody colesProductDto colesProductDto){
        colesService.convert(colesProductDto);
    }

}
