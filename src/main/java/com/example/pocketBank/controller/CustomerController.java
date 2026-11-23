package com.example.pocketBank.controller;

import com.example.pocketBank.dto.AccountDTO;
import com.example.pocketBank.dto.CustomerDTO;
import com.example.pocketBank.service.AccountService;
import com.example.pocketBank.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final AccountService accountService;

    public CustomerController(CustomerService customerService, AccountService accountService) {
        this.customerService = customerService;
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO request) {
        CustomerDTO created = customerService.create(request);
        return ResponseEntity.created(URI.create("/customers/" + created.id())).body(created);
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable UUID id) {
        return customerService.getById(id);
    }

    @PostMapping("/{id}/accounts")
    public ResponseEntity<AccountDTO> openAccount(@PathVariable UUID id,
                                                  @RequestBody AccountDTO request) {
        AccountDTO created = accountService.openAccount(id, request);
        return ResponseEntity.created(URI.create("/accounts/" + created.id())).body(created);
    }
}
