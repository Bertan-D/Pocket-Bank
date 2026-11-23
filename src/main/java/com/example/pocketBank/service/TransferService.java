package com.example.pocketBank.service;

import com.example.pocketBank.dto.TransferDTO;
import com.example.pocketBank.exceptions.TransferNotFoundException;
import com.example.pocketBank.repository.TransferRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AccountService accountService;

    public TransferService(TransferRepository transferRepository, AccountService accountService) {
        this.transferRepository = transferRepository;
        this.accountService = accountService;
    }

    @Transactional
    public TransferDTO create(TransferDTO request) {
        // TODO: Quell- und Zielkonto identisch -> InvalidRequestException (400)
        // TODO: Beide Konten laden, beide müssen ACTIVE sein -> sonst BusinessRuleException (409)
        // TODO: Guthaben prüfen (Giro darf bis -500 €), sonst BusinessRuleException
        // TODO: Tagesgeld nur auf eigenes Girokonto desselben Kunden
        // TODO: Abbuchen, gutschreiben, neue Transfer-Entity anlegen und speichern
        throw new UnsupportedOperationException("TODO: create transfer");
    }

    @Transactional(readOnly = true)
    public TransferDTO getById(UUID id) {
        return transferRepository.findById(id)
                .map(TransferDTO::from)
                .orElseThrow(() -> new TransferNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<TransferDTO> getForAccount(UUID accountId, int page, int size) {
        accountService.findOrThrow(accountId);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "timestamp"));
        return transferRepository.findBySourceAccountIdOrTargetAccountId(accountId, accountId, pageRequest)
                .map(TransferDTO::from)
                .getContent();
    }
}
