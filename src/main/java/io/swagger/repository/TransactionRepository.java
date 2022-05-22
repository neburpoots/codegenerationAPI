package io.swagger.repository;

import io.swagger.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository <Transaction, UUID> {
    //returns all transactions with to_accounts matching the given iban.
    List<Transaction> findByToAccount(String iban);

    //returns all transactions with from_accounts matching the given iban.
    List<Transaction> findByFromAccount(String iban);

    List<Transaction> findByToAccountAndFromAccountAndAmount(String toAccount, String fromAccount, BigDecimal amount);

    List<Transaction> findByTimestamp(LocalDateTime time);

    List <Transaction> findByAmount(BigDecimal amount);

    List <Transaction> findByAmountIsLessThan(BigDecimal amount);

    List <Transaction> findByAmountIsGreaterThan(BigDecimal amount);




}