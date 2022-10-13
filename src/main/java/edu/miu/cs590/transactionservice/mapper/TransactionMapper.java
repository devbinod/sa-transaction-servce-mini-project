package edu.miu.cs590.transactionservice.mapper;

import edu.miu.cs590.transactionservice.dto.TransactionDto;
import edu.miu.cs590.transactionservice.dto.TransactionRequestDto;
import edu.miu.cs590.transactionservice.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper {


    TransactionDto toDto(Transaction transaction);

    Transaction toEntity(TransactionRequestDto transactionDto);

    List<TransactionDto> toDtoList(List<Transaction> transactions);

    List<Transaction> toEntityList(List<TransactionDto> transactionDtos);
}
