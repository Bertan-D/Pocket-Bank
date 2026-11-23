package com.example.pocketBank.model;

import com.example.pocketBank.enums.CardState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Card {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(nullable = false)
    private String maskedCardNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardState cardState = CardState.ACTIVE;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal dailyLimit;
}
