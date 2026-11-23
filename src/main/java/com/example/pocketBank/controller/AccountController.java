package com.example.pocketBank.controller;

import com.example.pocketBank.dto.AccountDTO;
import com.example.pocketBank.dto.CardDTO;
import com.example.pocketBank.dto.TransferDTO;
import com.example.pocketBank.service.AccountService;
import com.example.pocketBank.service.CardService;
import com.example.pocketBank.service.TransferService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final CardService cardService;
    private final TransferService transferService;

    public AccountController(AccountService accountService, CardService cardService, TransferService transferService) {
        this.accountService = accountService;
        this.cardService = cardService;
        this.transferService = transferService;
    }

    @GetMapping("/{id}")
    public AccountDTO getById(@PathVariable UUID id) {
        return accountService.getById(id);
    }

    @PatchMapping("/{id}/state")
    public AccountDTO updateState(@PathVariable UUID id,
                                  @RequestBody AccountDTO request) {
        return accountService.updateState(id, request);
    }

    @PostMapping("/{id}/cards")
    public ResponseEntity<CardDTO> issueCard(@PathVariable UUID id,
                                             @Valid @RequestBody CardDTO request) {
        CardDTO created = cardService.issueCard(id, request);
        return ResponseEntity.created(URI.create("/cards/" + created.id())).body(created);
    }

    @GetMapping("/{id}/transfers")
    public List<TransferDTO> getTransfers(@PathVariable UUID id,
                                                  @RequestParam(defaultValue = "0") @Min(0) int page,
                                                  @RequestParam(defaultValue = "20") @Min(1) @Max(100) int size) {
        return transferService.getForAccount(id, page, size);
    }
}
