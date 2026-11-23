package com.example.pocketBank.dto;

import com.example.pocketBank.enums.AccountState;
import com.example.pocketBank.enums.AccountType;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public record AccountDTO(
        UUID id,
        String iban,
        AccountType accountType,
        BigDecimal balance,
        AccountState accountState,
        ZonedDateTime creationDate
) {}
