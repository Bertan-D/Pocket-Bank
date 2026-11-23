package com.example.pocketBank.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
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

    @OneToMany
    private ArrayList<Account> accounts;

}
