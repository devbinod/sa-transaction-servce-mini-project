package edu.miu.cs590.transactionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {

    private String uuid;

    @NotNull(message = "Order id is required")
    private String orderId;
    @NotNull(message = "Amount is required")
    private long amount;
    @NotNull(message = "Payment method is required")
    private Long paymentMethod;
    @NotNull(message = "Transaction name is required")
    private String name;
}
