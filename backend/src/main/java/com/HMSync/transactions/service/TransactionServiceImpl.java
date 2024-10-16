package com.HMSync.transactions.service;

import com.HMSync.transactions.controller.assembler.TransactionAssembler;
import com.HMSync.transactions.controller.dto.TransactionRequestDto;
import com.HMSync.transactions.entity.Transaction;
import com.HMSync.transactions.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;
    private final TransactionAssembler transactionAssembler;

    @Override
    public Transaction create(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = new Transaction();
        return Optional.of(transaction)
                .map(entity -> transactionAssembler.toTransaction(transactionRequestDto, entity))
                .map(transactionRepository::save)
                .orElseThrow(() -> new RuntimeException("Transaction was not saved"));
    }

    @Override
    public Page<Transaction> getAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Transaction update(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = get(transactionRequestDto.getTransactionId());
        try {
            return transactionRepository.save(transactionAssembler.toTransaction(transactionRequestDto, transaction));
        } catch (Exception e) {
            log.error("Error updating transaction: {}", e.getMessage(), e);
            throw new RuntimeException("Transaction was not updated due to an unexpected error");
        }
    }

    @Override
    public Transaction get(UUID transactionId) {
        return Optional.of(transactionId)
                .flatMap(transactionRepository::findById)
                .orElseThrow(() -> new RuntimeException("Transaction with ID: " + transactionId + " does not exist"));
    }

    @Override
    public void delete(UUID transactionId) {
        get(transactionId);
        transactionRepository.deleteById(transactionId);
    }
}
