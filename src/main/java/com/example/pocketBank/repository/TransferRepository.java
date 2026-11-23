package com.example.pocketBank.repository;

import com.example.pocketBank.model.Transfer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {

    Page<Transfer> findBySourceAccountIdOrTargetAccountId(UUID sourceAccountId, UUID targetAccountId, Pageable pageable);
}
