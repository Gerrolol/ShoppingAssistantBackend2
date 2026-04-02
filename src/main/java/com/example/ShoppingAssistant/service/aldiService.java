package com.example.ShoppingAssistant.service;

import org.springframework.stereotype.Service;

import com.example.ShoppingAssistant.client.aldiClient;
import com.example.ShoppingAssistant.dto.AldiProductDto;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.repository.aldiRepository;
import com.example.ShoppingAssistant.model.*;

@Service
public class aldiService {
    private aldiRepository aldiRepository;
    private final aldiClient aldiClient; 

    aldiService(aldiRepository aldiRepository, aldiClient aldiClient){
        this.aldiRepository = aldiRepository;
        this.aldiClient = aldiClient;
    }

    public void create(item item){
        Aldi aldi = Aldi.builder()
            .itemName(item.name())
            .price(item.cost())
            .build();
        aldiRepository.save(aldi);
    }

    public void fetchAdd(String productCode){
        AldiProductDto aldiProductDto = aldiClient.getProduct(productCode);
        item Item = new item(aldiProductDto.price(), aldiProductDto.name());
        create(Item);
    }
}
