package com.example.ShoppingAssistant.dto;

import java.util.List;

public record wooliesResponseDto(
    String query,
    List<wooliesProductDto> results
) {
    
}
