package com.HMSync.transactions.service;

import com.HMSync.transactions.controller.dto.TransactionRequestDto;
import com.HMSync.transactions.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TransactionService {
    Transaction create(TransactionRequestDto transactionRequestDto);
    Page<Transaction> getAll(Pageable pageable);
    Transaction update(TransactionRequestDto transactionRequestDto);
    Transaction get(UUID transactionId);
    void delete(UUID transactionId);
}
