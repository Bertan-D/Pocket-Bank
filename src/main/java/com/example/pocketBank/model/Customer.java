package com.example.pocketBank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Customer {

    @Id
    @Column(nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String eMail;

    @Column(nullable = false)
    private Instant dateOfBirth;

    @Column
    private Instant registerTimestamp = Instant.now();

}
