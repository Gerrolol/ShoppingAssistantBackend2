package com.example.ShoppingAssistant.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.ShoppingAssistant.dto.AldiProductDto;
import com.example.ShoppingAssistant.dto.AldiResponseDto;

@Component
public class aldiClient {
    @Value("bcd7dc5300mshbce21f8f4d2a997p1ed686jsn207959b77328")
    private String apikey; 
    private final RestClient restClient;

    public aldiClient(RestClient.Builder builder){
        this.restClient = builder
            .baseUrl("https://aldi-australia-real-time-grocery-pricing-api.p.rapidapi.com")
            .build();
    }

    public AldiProductDto getProduct(String slug) {
        AldiResponseDto aldiResponseDto = restClient.get()
            .uri("/aldi/item?slug={slug}", slug)
            .header("x-rapidapi-key", this.apikey)
            .header("x-rapidapi-host", "aldi-australia-real-time-grocery-pricing-api.p.rapidapi.com")
            .retrieve()
            .body(AldiResponseDto.class);  // maps JSON → DTO automatically
    
        return aldiResponseDto.result();
    }
}
