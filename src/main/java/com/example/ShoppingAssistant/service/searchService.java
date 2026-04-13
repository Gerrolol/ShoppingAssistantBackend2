package com.example.ShoppingAssistant.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ShoppingAssistant.dto.item;
import com.example.ShoppingAssistant.dto.itemsList;
import com.example.ShoppingAssistant.dto.searchListResponseDto;
import com.example.ShoppingAssistant.dto.searchResultDto;
import com.example.ShoppingAssistant.model.Coles;
import com.example.ShoppingAssistant.model.Woolies;
import com.example.ShoppingAssistant.repository.aldiRepository;
import com.example.ShoppingAssistant.repository.colesRepository;
import com.example.ShoppingAssistant.repository.wooliesRepository;

@Service
public class searchService {
    // private final aldiRepository aldiRepository;
    private final colesService colesService;
    private final wooliesService wooliesService;
    private final colesRepository colesRepository;
    private final wooliesRepository wooliesRepository;

    searchService(aldiRepository aldiRepository, colesRepository colesRepository, wooliesRepository wooliesRepository, colesService colesService, wooliesService wooliesService){
        // this.aldiRepository = aldiRepository;
        this.colesRepository = colesRepository;
        this.wooliesRepository = wooliesRepository;
        this.colesService = colesService;
        this.wooliesService = wooliesService;
    }
    
    public List<searchResultDto> search(String Name){
        // List<Aldi> item = aldiRepository.findFirstByItemNameContainingIgnoreCase(Name);
        List<Coles> item2 = colesRepository.findByItemNameContainingIgnoreCase(Name);
        List<Woolies>item3 = wooliesRepository.findByItemNameContainingIgnoreCase(Name);
        
        List<searchResultDto> ans = new ArrayList<>();
        // ans.add(new searchResultDto("Aldi",item.get(0).getitemName(),item.get(0).getPrice()));
        ans.add(new searchResultDto("coles",item2.get(0).getitemName(), item2.get(0).getPrice()));
        ans.add(new searchResultDto("Woolies",item3.get(0).getitemName(),item3.get(0).getPrice()));
        return ans;
    }

    public searchResultDto cheapest(String Name){
        List<searchResultDto> res = search(Name);
        res.sort((store1, store2) -> store1.price().compareTo(store2.price()));
        return res.get(0);
    }

    public BigDecimal Cheapest(List<item> storeItems){
        BigDecimal cost = new BigDecimal(0);
        for(int i=0; i<storeItems.size(); i++){
            cost=cost.add(storeItems.get(i).cost());
        }
        return cost;
    }
    //can improve by also making it so that it doesnt just find it for two stores but as many stores as someone wants to compare, making it refactorable.
    public searchListResponseDto cheapestStore(itemsList itemsList){
        List<item> wooliesItems = wooliesService.retrieve(itemsList);
        List<item> colesItems = colesService.retrieve(itemsList);
        BigDecimal wooliesTotalPrice = Cheapest(wooliesItems);
        BigDecimal colesTotalPrice = Cheapest(colesItems);
        if(wooliesTotalPrice.compareTo(colesTotalPrice) > 0){
            String cheaperStore = "coles";
            BigDecimal moneySaved = wooliesTotalPrice.subtract(colesTotalPrice);
            return new searchListResponseDto(cheaperStore, colesTotalPrice, moneySaved);
        }
        BigDecimal moneySaved = colesTotalPrice.subtract(wooliesTotalPrice);
        return new searchListResponseDto("woolies", wooliesTotalPrice, moneySaved);
    } 
}
