package edu.miu.cs590.transactionservice.dto;

import edu.miu.cs590.transactionservice.enums.TransactionStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTransactionStatusDto {


    @NotNull(message = "Status is required")
    TransactionStatus status;
}
