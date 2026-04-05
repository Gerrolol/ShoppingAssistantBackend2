package com.example.ShoppingAssistant.dto;

import java.math.BigDecimal;

public record searchListResponseDto(
    String store,
    BigDecimal totalPrice,
    BigDecimal moneySaved
) {
    
}
