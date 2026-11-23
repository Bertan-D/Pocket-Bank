package com.example.pocketBank.exceptions;

import java.util.UUID;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException(UUID id) {
        super("Customer with id " + id + " not found.");
    }
}
