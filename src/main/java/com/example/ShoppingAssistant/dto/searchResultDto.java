package com.example.ShoppingAssistant.dto;

import java.math.BigDecimal;

public record searchResultDto(
    String store,
    String productName,
    BigDecimal price
) {

}
