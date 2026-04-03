package com.example.ShoppingAssistant.dto;

import java.util.List;

public record colesResponseDto(
    String query,
    List<colesProductDto> results
) {
    
}
