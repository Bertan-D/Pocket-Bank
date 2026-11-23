package com.example.pocketBank.service;

import com.example.pocketBank.dto.CustomerDTO;
import com.example.pocketBank.exceptions.CustomerNotFoundException;
import com.example.pocketBank.model.Customer;
import com.example.pocketBank.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDTO create(CustomerDTO request) {
        // TODO: Kunde muss mindestens 18 Jahre alt sein -> sonst BusinessRuleException
        // TODO: E-Mail darf noch nicht vergeben sein (customerRepository.existsByEmail) -> sonst BusinessRuleException

        Customer customer = new Customer();
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setDateOfBirth(request.dateOfBirth());

        return CustomerDTO.from(customerRepository.save(customer));
    }

    @Transactional(readOnly = true)
    public CustomerDTO getById(UUID id) {
        return CustomerDTO.from(findOrThrow(id));
    }

    public Customer findOrThrow(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
