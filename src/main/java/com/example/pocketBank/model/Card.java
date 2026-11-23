package com.example.pocketBank.model;

import com.example.pocketBank.enums.CardState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Card {

    @Id
    @Column(nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String maskedCardNumber;

    @Column(nullable = false)
    private CardState cardState;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal dailyLimit;

}
