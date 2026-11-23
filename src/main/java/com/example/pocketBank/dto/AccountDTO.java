package com.example.pocketBank.dto;

import com.example.pocketBank.enums.AccountState;
import com.example.pocketBank.enums.AccountType;
import com.example.pocketBank.model.Account;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.UUID;

public record AccountDTO(
        UUID id,
        String iban,
        AccountType accountType,
        BigDecimal balance,
        AccountState accountState,
        Instant creationDate
) {
    public static AccountDTO from(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getIban(),
                account.getAccountType(),
                account.getBalance(),
                account.getAccountState(),
                account.getCreationDate()
        );
    }

}
