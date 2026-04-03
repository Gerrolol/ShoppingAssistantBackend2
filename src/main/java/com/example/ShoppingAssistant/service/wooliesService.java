package com.example.ShoppingAssistant.service;

import org.springframework.stereotype.Service;

import com.example.ShoppingAssistant.client.wooliesClient;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.dto.wooliesProductDto;
import com.example.ShoppingAssistant.model.Woolies;
import com.example.ShoppingAssistant.repository.wooliesRepository;

@Service
public class wooliesService {
    private final wooliesRepository wooliesRepository;
    private final wooliesClient wooliesclient;

    wooliesService(wooliesRepository wooliesRepository, wooliesClient wooliesClient){
        this.wooliesRepository = wooliesRepository;
        this.wooliesclient = wooliesClient;
    }

    public void create(item item){
        Woolies woolies = Woolies.builder()
            .price(item.cost())
            .itemName(item.name())
            .build();
        wooliesRepository.save(woolies);
    } 

    public void add(String productName){
        wooliesProductDto wooliesProductDto = wooliesclient.search(productName);
        item item = new item(wooliesProductDto.current_price(), wooliesProductDto.product_name());
        create(item);
    }
}
