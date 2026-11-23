package com.example.pocketBank.dto;

import com.example.pocketBank.model.Account;
import com.example.pocketBank.model.Customer;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public record CustomerDTO(
        UUID id,
        String firstName,
        String lastName,
        String eMail,
        Instant dateOfBirth,
        Instant registerTimestamp,
        List<UUID> accounts
) {
    public static CustomerDTO from(Customer customer) {
        return new CustomerDTO(
            customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEMail(),
            customer.getDateOfBirth(),
            customer.getRegisterTimestamp(),
            customer.getAccounts().stream().map(Account::getId).toList()
        );
    }
}
