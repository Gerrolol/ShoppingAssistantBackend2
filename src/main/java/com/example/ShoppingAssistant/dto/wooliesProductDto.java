package com.example.ShoppingAssistant.dto;

import java.math.BigDecimal;

public record wooliesProductDto(
    String product_name,
    BigDecimal current_price
) {
    
}
