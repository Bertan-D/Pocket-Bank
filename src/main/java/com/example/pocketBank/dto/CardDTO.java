package com.example.pocketBank.dto;

import com.example.pocketBank.enums.CardState;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.UUID;

public record CardDTO(
        UUID id,
        String maskedCardNumber,
        CardState cardState,
        BigDecimal dailyLimit
) {}
