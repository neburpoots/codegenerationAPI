package io.swagger.repository;

import io.swagger.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository <Transaction, UUID> {
    List<Transaction> findByToAccount(String iban);
}
