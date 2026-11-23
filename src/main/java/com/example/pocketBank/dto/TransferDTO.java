package com.example.pocketBank.dto;

import com.example.pocketBank.model.Account;

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
) {}
