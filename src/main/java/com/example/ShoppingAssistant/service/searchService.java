package com.example.ShoppingAssistant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ShoppingAssistant.dto.searchResultDto;
// import com.example.ShoppingAssistant.model.Aldi;
import com.example.ShoppingAssistant.model.Coles;
import com.example.ShoppingAssistant.model.Woolies;
import com.example.ShoppingAssistant.repository.aldiRepository;
import com.example.ShoppingAssistant.repository.colesRepository;
import com.example.ShoppingAssistant.repository.wooliesRepository;

@Service
public class searchService {
    // private final aldiRepository aldiRepository;
    private final colesRepository colesRepository;
    private final wooliesRepository wooliesRepository;

    searchService(aldiRepository aldiRepository, colesRepository colesRepository, wooliesRepository wooliesRepository){
        // this.aldiRepository = aldiRepository;
        this.colesRepository = colesRepository;
        this.wooliesRepository = wooliesRepository;
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
}
