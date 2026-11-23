package com.example.pocketBank.dto;

import com.example.pocketBank.model.Transfer;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransferDTO(
        UUID id,
        @NotNull UUID sourceAccountId,
        @NotNull UUID targetAccountId,
        @NotNull @Positive @Digits(integer = 17, fraction = 2) BigDecimal amount,
        @Size(max = 140) String usage,
        Instant timestamp
) {
    public static TransferDTO from(Transfer transfer) {
        return new TransferDTO(
                transfer.getId(),
                transfer.getSourceAccount().getId(),
                transfer.getTargetAccount().getId(),
                transfer.getAmount(),
                transfer.getUsage(),
                transfer.getTimestamp()
        );
    }
}
