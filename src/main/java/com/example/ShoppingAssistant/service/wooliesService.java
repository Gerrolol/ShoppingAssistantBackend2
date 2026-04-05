package com.example.ShoppingAssistant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.ShoppingAssistant.client.wooliesClient;
import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.dto.itemsList;
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

    public List<item> retrieve(itemsList itemsList){
        List<item>store = new ArrayList<>();
        for(String item : itemsList.items()){
            List<Woolies> wooliesItem = wooliesRepository.findByItemNameContainingIgnoreCase(item);
            Woolies actualItem = wooliesItem.get(0);
            if (wooliesItem == null || wooliesItem.isEmpty()) {
                continue; 
            }
            store.add(new item(actualItem.getPrice(), actualItem.getitemName()));
        }
        return store;
    }
}
