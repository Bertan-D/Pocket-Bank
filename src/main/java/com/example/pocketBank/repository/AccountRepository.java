package com.example.pocketBank.repository;

import com.example.pocketBank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    boolean existsByIban(String iban);
}
