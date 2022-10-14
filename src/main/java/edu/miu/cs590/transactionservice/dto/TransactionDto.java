package edu.miu.cs590.transactionservice.dto;

import edu.miu.cs590.transactionservice.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private String uuid;

    @NotNull(message = "Order id is required")
    private String orderId;
    @NotNull(message = "Amount is required")
    private long amount;
    @NotNull(message = "Payment method is required")
    private Long paymentMethod;
    @NotNull(message = "Transaction name is required")
    private String name;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status = TransactionStatus.PROCESSED;
    private LocalDate createdDate;

}
