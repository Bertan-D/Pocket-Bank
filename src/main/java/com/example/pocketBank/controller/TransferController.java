package com.example.pocketBank.controller;

import com.example.pocketBank.dto.TransferDTO;
import com.example.pocketBank.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<TransferDTO> create(@Valid @RequestBody TransferDTO request) {
        TransferDTO created = transferService.create(request);
        return ResponseEntity.created(URI.create("/transfers/" + created.id())).body(created);
    }

    @GetMapping("/{id}")
    public TransferDTO getById(@PathVariable UUID id) {
        return transferService.getById(id);
    }
}
