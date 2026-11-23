package com.example.pocketBank.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

public record CustomerDTO(
        UUID id,
        String firstName,
        String lastName,
        String eMail,
        ZonedDateTime dateOfBirth,
        ZonedDateTime registerTimestamp
) {}
