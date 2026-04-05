package com.example.ShoppingAssistant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ShoppingAssistant.client.colesClient;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.dto.itemsList;
import com.example.ShoppingAssistant.dto.colesProductDto;
import com.example.ShoppingAssistant.model.Coles;
import com.example.ShoppingAssistant.repository.colesRepository;

@Service
public class colesService {
    private final colesRepository colesRepository;
    private final colesClient colesclient;

    colesService(colesRepository colesRepository, colesClient colesClient){
        this.colesRepository = colesRepository;
        this.colesclient = colesClient;
    }

    public void create(item item){
        Coles coles = Coles.builder()
            .price(item.cost())
            .itemName(item.name())
            .build();
        colesRepository.save(coles);
    } 

    public void add(String productName){
        colesProductDto colesProductDto = colesclient.search(productName);
        item item = new item(colesProductDto.current_price(), colesProductDto.product_name());
        create(item);
    }

    public List<item> retrieve(itemsList itemsList){
        List<item>store = new ArrayList<>();
        for(String item : itemsList.items()){
            List<Coles> colesItem = colesRepository.findByItemNameContainingIgnoreCase(item);
            if (colesItem == null || colesItem.isEmpty()) {
                continue; 
            }
            Coles actualItem = colesItem.get(0);
            store.add(new item(actualItem.getPrice(), actualItem.getitemName()));
        }
        return store;
    }
}