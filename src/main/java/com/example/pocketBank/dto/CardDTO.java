package com.example.pocketBank.dto;

import com.example.pocketBank.enums.CardState;
import com.example.pocketBank.model.Card;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.UUID;

public record CardDTO(
        UUID id,
        String maskedCardNumber,
        CardState cardState,
        BigDecimal dailyLimit
) {
    public static CardDTO from(Card card) {
        return new CardDTO(
                card.getId(),
                card.getMaskedCardNumber(),
                card.getCardState(),
                card.getDailyLimit()
        );
    }
}
