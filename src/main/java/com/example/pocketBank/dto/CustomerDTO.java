package com.example.pocketBank.dto;

import com.example.pocketBank.model.Account;
import com.example.pocketBank.model.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CustomerDTO(
        UUID id,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email,
        @NotNull @Past LocalDate dateOfBirth,
        Instant registerTimestamp,
        List<UUID> accountIds
) {
    public static CustomerDTO from(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getDateOfBirth(),
                customer.getRegisterTimestamp(),
                customer.getAccounts().stream().map(Account::getId).toList()
        );
    }
}
