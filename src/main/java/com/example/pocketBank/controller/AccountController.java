package com.example.pocketBank.controller;

import com.example.pocketBank.dto.AccountDTO;
import com.example.pocketBank.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    AccountController (AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/{id}")
    @GetMapping
    public AccountDTO getAccount(@PathVariable UUID id) {
        return AccountDTO.from(accountService.getAccountById(id));
    }
}
