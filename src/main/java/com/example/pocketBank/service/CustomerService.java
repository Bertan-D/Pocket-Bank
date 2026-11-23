package com.example.pocketBank.service;

import com.example.pocketBank.dto.CustomerDTO;
import com.example.pocketBank.exceptions.AccountNotFoundException;
import com.example.pocketBank.model.Customer;
import com.example.pocketBank.repository.AccountRepository;
import com.example.pocketBank.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    CustomerService(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public Customer create(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.firstName());
        customer.setLastName(customerDTO.lastName());
        customer.setEMail(customerDTO.eMail());
        customer.setDateOfBirth(customerDTO.dateOfBirth());
        customer.setAccounts(customerDTO.accounts().stream().map(
                id -> accountRepository.findById(id).orElseThrow(
                        () -> new AccountNotFoundException(id)))
                .toList());
        return customerRepository.save(customer);
    }

    public Customer getById(UUID id) {
        return customerRepository.findById(id).orElseThrow();
    }

}
