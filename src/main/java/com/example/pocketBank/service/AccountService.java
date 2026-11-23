package com.example.pocketBank.service;

import com.example.pocketBank.dto.AccountDTO;
import com.example.pocketBank.exceptions.AccountNotFoundException;
import com.example.pocketBank.model.Account;
import com.example.pocketBank.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    @Transactional
    public AccountDTO openAccount(UUID customerId, AccountDTO request) {
        // TODO: request.accountType() muss gesetzt sein -> sonst InvalidRequestException
        // TODO: Kunden laden (customerService.findOrThrow)
        // TODO: Neues Account anlegen: Kunde setzen, Typ setzen, eindeutige IBAN erzeugen
        // TODO: Speichern und als AccountDTO zurückgeben
        throw new UnsupportedOperationException("TODO: openAccount");
    }

    @Transactional(readOnly = true)
    public AccountDTO getById(UUID id) {
        return AccountDTO.from(findOrThrow(id));
    }

    @Transactional
    public AccountDTO updateState(UUID id, AccountDTO request) {
        // TODO: request.accountState() muss gesetzt sein -> sonst InvalidRequestException
        // TODO: CLOSED ist endgültig -> kein Wechsel mehr möglich
        // TODO: Schließen nur bei Kontostand 0 erlaubt
        // TODO: Status setzen (Dirty Checking, kein save() nötig)
        throw new UnsupportedOperationException("TODO: updateState");
    }

    public Account findOrThrow(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }
}
