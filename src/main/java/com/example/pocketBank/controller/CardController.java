package com.example.pocketBank.controller;

import com.example.pocketBank.dto.CardDTO;
import com.example.pocketBank.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public CardDTO getById(@PathVariable UUID id) {
        return cardService.getById(id);
    }

    @PatchMapping("/{id}/block")
    public CardDTO block(@PathVariable UUID id) {
        return cardService.block(id);
    }
}
