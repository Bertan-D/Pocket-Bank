package com.example.pocketBank.dto;

import com.example.pocketBank.enums.CardState;
import com.example.pocketBank.model.Card;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record CardDTO(
        UUID id,
        UUID accountId,
        String maskedCardNumber,
        CardState cardState,
        @NotNull @Positive @Digits(integer = 17, fraction = 2) BigDecimal dailyLimit
) {
    public static CardDTO from(Card card) {
        return new CardDTO(
                card.getId(),
                card.getAccount().getId(),
                card.getMaskedCardNumber(),
                card.getCardState(),
                card.getDailyLimit()
        );
    }
}
