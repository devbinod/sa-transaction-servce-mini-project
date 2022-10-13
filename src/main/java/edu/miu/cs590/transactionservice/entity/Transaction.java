package edu.miu.cs590.transactionservice.entity;


import edu.miu.cs590.transactionservice.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Transaction extends BaseEntity {


    private Long orderId;
    @Column(name = "user_id")
    private String username;
    private long amount;
    private Long paymentMethod;
    private String name;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status = TransactionStatus.PROCESSED;






}
