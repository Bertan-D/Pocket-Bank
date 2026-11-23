package com.example.pocketBank.exceptions;

import java.util.UUID;

public class AccountNotFoundException extends NotFoundException {
    public AccountNotFoundException(UUID id) {
        super("Account with id " + id + " not found.");
    }
}
