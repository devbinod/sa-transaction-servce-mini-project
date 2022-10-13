package edu.miu.cs590.transactionservice.serviceImpl;

import edu.miu.cs590.transactionservice.AppUtil;
import edu.miu.cs590.transactionservice.dto.TransactionDto;
import edu.miu.cs590.transactionservice.dto.TransactionRequestDto;
import edu.miu.cs590.transactionservice.dto.UpdateTransactionStatusDto;
import edu.miu.cs590.transactionservice.entity.Transaction;
import edu.miu.cs590.transactionservice.enums.TransactionStatus;
import edu.miu.cs590.transactionservice.exception.TransactionNotFound;
import edu.miu.cs590.transactionservice.mapper.TransactionMapper;
import edu.miu.cs590.transactionservice.repository.TransactionRepository;
import edu.miu.cs590.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public TransactionDto save(TransactionRequestDto transactionDto) {

        return transactionMapper.toDto(transactionRepository.save(getTransaction(transactionDto)));
    }

    @Override
    public TransactionDto update(TransactionRequestDto transactionDto) {
        findByIdAndUsername(transactionDto.getUuid());
        Transaction transaction = transactionRepository.save(getTransaction(transactionDto));
        return transactionMapper.toDto(transaction);
    }

    @Override
    public List<TransactionDto> findAllByUser() {
        return transactionMapper.toDtoList(transactionRepository.findAllByUsername(AppUtil.getCurrentUser()));
    }

    @Override
    public TransactionDto findById(String id) {
        return transactionMapper.toDto(findByIdAndUsername(id));
    }

    @Override
    public TransactionDto updateStatus(String id,
                                       TransactionStatus transactionStatus) {

        Transaction transaction = findByIdAndUsername(id);
        transaction.setStatus(transactionStatus);
        return transactionMapper.toDto(transactionRepository.save(transaction));
    }

    @Override
    public void deleteTransaction(String id) {
        transactionRepository.delete(findByIdAndUsername(id));
    }


    private Transaction findByIdAndUsername(String uuid) {
        Optional<Transaction> optionalTransaction = transactionRepository.findByUuidAndUsername(uuid, AppUtil.getCurrentUser());
        if (optionalTransaction.isEmpty()) throw new TransactionNotFound("Transaction not found");
        return optionalTransaction.get();
    }


    private Transaction getTransaction(TransactionRequestDto transactionDto) {
        Transaction transaction = transactionMapper.toEntity(transactionDto);
        transaction.setUsername(AppUtil.getCurrentUser());
        return transaction;
    }
}
