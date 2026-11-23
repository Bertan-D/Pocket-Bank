package com.example.pocketBank.model;

import com.example.pocketBank.enums.AccountState;
import com.example.pocketBank.enums.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Account {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private String iban;

    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal balance;

    @Column(nullable = false)
    private AccountState accountState;

    @Column(nullable = false)
    private Instant creationDate = Instant.now();

    @OneToMany
    private ArrayList<Card> cards;
}
