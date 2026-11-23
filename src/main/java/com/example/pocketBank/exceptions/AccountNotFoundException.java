package com.example.pocketBank.exceptions;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(UUID id) {
        super("Account with id " + id + " not found.");
    }
}
