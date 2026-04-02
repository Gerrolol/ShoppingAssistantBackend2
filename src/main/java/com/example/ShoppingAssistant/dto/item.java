package com.example.ShoppingAssistant.dto;

import java.math.BigDecimal;

public record item(
    BigDecimal cost, String name
) {
}
