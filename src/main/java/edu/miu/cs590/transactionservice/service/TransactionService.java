package edu.miu.cs590.transactionservice.service;

import edu.miu.cs590.transactionservice.dto.TransactionDto;
import edu.miu.cs590.transactionservice.dto.TransactionRequestDto;
import edu.miu.cs590.transactionservice.entity.Transaction;
import edu.miu.cs590.transactionservice.enums.TransactionStatus;

import java.util.List;

public interface TransactionService {

    TransactionDto save(TransactionRequestDto transactionDto);
    TransactionDto update(TransactionRequestDto transactionDto);
    List<TransactionDto> findAllByUser();
    TransactionDto findById(String id);
    TransactionDto updateStatus(String id, TransactionStatus transactionStatus);
    void deleteTransaction(String id);
}
