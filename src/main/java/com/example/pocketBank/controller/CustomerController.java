package com.example.pocketBank.controller;

import com.example.pocketBank.dto.CustomerDTO;
import com.example.pocketBank.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO create(CustomerDTO customerDTO) {
        return CustomerDTO.from(customerService.create(customerDTO));
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable UUID id) {
        return CustomerDTO.from(customerService.getById(id));
    }
}
