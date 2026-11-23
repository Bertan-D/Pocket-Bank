package com.example.pocketBank.service;

import com.example.pocketBank.dto.CardDTO;
import com.example.pocketBank.exceptions.CardNotFoundException;
import com.example.pocketBank.model.Card;
import com.example.pocketBank.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final AccountService accountService;

    public CardService(CardRepository cardRepository, AccountService accountService) {
        this.cardRepository = cardRepository;
        this.accountService = accountService;
    }

    @Transactional
    public CardDTO issueCard(UUID accountId, CardDTO request) {
        // TODO: Konto laden, muss ACTIVE sein
        // TODO: Karte anlegen: Konto setzen, maskierte Kartennummer erzeugen (z. B. "**** **** **** 1234"), Tageslimit setzen
        // TODO: Speichern und als CardDTO zurückgeben
        throw new UnsupportedOperationException("TODO: issueCard");
    }

    @Transactional(readOnly = true)
    public CardDTO getById(UUID id) {
        return CardDTO.from(findOrThrow(id));
    }

    @Transactional
    public CardDTO block(UUID id) {
        // TODO: Karte sperren. Eine gesperrte Karte bleibt gesperrt (stattdessen neue Karte ausgeben)
        throw new UnsupportedOperationException("TODO: block");
    }

    public Card findOrThrow(UUID id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));
    }
}
