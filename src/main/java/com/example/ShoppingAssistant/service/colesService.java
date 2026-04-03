package com.example.ShoppingAssistant.service;

import org.springframework.stereotype.Service;

import com.example.ShoppingAssistant.client.colesClient;
import com.example.ShoppingAssistant.dto.item;
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
}