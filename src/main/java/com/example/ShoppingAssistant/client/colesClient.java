package com.example.ShoppingAssistant.client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import com.example.ShoppingAssistant.dto.colesProductDto;
import com.example.ShoppingAssistant.dto.colesResponseDto;

@Component 
public class colesClient {
    private final RestClient restclient;
    private final String APIkey = "bcd7dc5300mshbce21f8f4d2a997p1ed686jsn207959b77328";

    colesClient(RestClient.Builder builder){
        this.restclient = builder
            .baseUrl("https://coles-product-price-api.p.rapidapi.com")
            .build();
    }

    public colesProductDto search(String productName){
        colesResponseDto colesResponse = restclient.get()
            .uri("/coles/product-search/?query={productName}", productName)
            .header("x-rapidapi-host", "coles-product-price-api.p.rapidapi.com")
            .header("Content-Type", "application/json")
            .header("x-rapidapi-key", APIkey)
            .retrieve()
            .body(colesResponseDto.class);
    
        return colesResponse.results().getFirst();
    }

    public List<colesProductDto> searchAll(String productName){
        colesResponseDto colesResponse = restclient.get()
            .uri("/coles/product-search/?query={productName}", productName)
            .header("x-rapidapi-host", "coles-product-price-api.p.rapidapi.com")
            .header("Content-Type", "application/json")
            .header("x-rapidapi-key", APIkey)
            .retrieve()
            .body(colesResponseDto.class);
    
        return colesResponse.results();
    }
    
}
