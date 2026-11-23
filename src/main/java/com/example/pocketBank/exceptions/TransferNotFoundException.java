package com.example.pocketBank.exceptions;

import java.util.UUID;

public class TransferNotFoundException extends NotFoundException {
    public TransferNotFoundException(UUID id) {
        super("Transfer with id " + id + " not found.");
    }
}
