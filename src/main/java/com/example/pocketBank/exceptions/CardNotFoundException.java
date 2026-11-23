package com.example.pocketBank.exceptions;

import java.util.UUID;

public class CardNotFoundException extends NotFoundException {
    public CardNotFoundException(UUID id) {
        super("Card with id " + id + " not found.");
    }
}
