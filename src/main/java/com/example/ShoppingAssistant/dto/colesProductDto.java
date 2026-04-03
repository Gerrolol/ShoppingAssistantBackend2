package com.example.ShoppingAssistant.dto;

import java.math.BigDecimal;

public record colesProductDto(
    String product_name,
    BigDecimal current_price
) {
    
}
