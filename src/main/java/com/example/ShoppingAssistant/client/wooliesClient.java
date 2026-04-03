package com.example.ShoppingAssistant.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.ShoppingAssistant.dto.wooliesProductDto;
import com.example.ShoppingAssistant.dto.wooliesResponseDto;

@Component
public class wooliesClient {
    private RestClient client;
    private String apikey = "bcd7dc5300mshbce21f8f4d2a997p1ed686jsn207959b77328";
    
    wooliesClient(RestClient.Builder builder){
        this.client = builder
            .baseUrl("https://woolworths-products-api.p.rapidapi.com")
            .build();
    }

    public wooliesProductDto search(String productName){
        wooliesResponseDto wooliesResponse = client.get()
            .uri("/woolworths/product-search/?query={productName}", productName)
            .header("x-rapidapi-host", "woolworths-products-api.p.rapidapi.com")
            .header("Content-Type", "application/json")
            .header("x-rapidapi-key", apikey)
            .retrieve()
            .body(wooliesResponseDto.class);
        
        return wooliesResponse.results().getFirst();
    }

    // public void search(String productName){
    //     String raw = client.get()
    //         .uri("/woolworths/product-search/?query={productName}", productName)
    //         .header("x-rapidapi-host", "woolworths-products-api.p.rapidapi.com")
    //         .header("Content-Type", "application/json")
    //         .header("x-rapidapi-key", apikey)
    //         .retrieve()
    //         .body(String.class);
        
    //     System.out.println(raw);
    // }
} 

