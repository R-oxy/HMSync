package com.HMSync.transactions.controller;

import com.HMSync.transactions.controller.assembler.TransactionAssembler;
import com.HMSync.transactions.controller.dto.TransactionDto;
import com.HMSync.transactions.controller.dto.TransactionRequestDto;
import com.HMSync.transactions.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "transactions")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final TransactionAssembler transactionAssembler;
    private final TransactionService transactionService;

    @GetMapping("/{transactionId}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDto get(@PathVariable UUID transactionId) {
        return transactionAssembler.toTransactionDto(transactionService.get(transactionId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDto create(@RequestBody @Valid TransactionRequestDto request) {
        return transactionAssembler.toTransactionDto(transactionService.create(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TransactionDto> getAll(Pageable pageable) {
        return transactionService.getAll(pageable).map(transactionAssembler::toTransactionDto);
    }

    @PutMapping("/{transactionId}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDto update(@PathVariable("transactionId") UUID transactionId,
                                 @RequestBody @Valid TransactionRequestDto transactionRequestDto) {
        if (!transactionId.equals(transactionRequestDto.getTransactionId())) {
            throw new RuntimeException("Path ID does not match request body ID");
        }
        return transactionAssembler.toTransactionDto(transactionService.update(transactionRequestDto));
    }

    @DeleteMapping("/{transactionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID transactionId) {
        transactionService.delete(transactionId);
    }
}
