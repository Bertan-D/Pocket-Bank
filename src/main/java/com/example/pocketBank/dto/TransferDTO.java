package com.example.pocketBank.dto;

import com.example.pocketBank.model.Account;
import com.example.pocketBank.model.Transfer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransferDTO(
        UUID id,
        Account sourceAccount,
        Account targetAccount,
        BigDecimal amount,
        String usage,
        Instant timestamp
) {
    public static TransferDTO from(Transfer transfer) {
        return new TransferDTO(
                transfer.getId(),
                transfer.getSourceAccount(),
                transfer.getTargetAccount(),
                transfer.getAmount(),
                transfer.getUsage(),
                transfer.getTimestamp()
        );
    }
}
