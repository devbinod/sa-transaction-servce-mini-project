package edu.miu.cs590.transactionservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyUserTokenDto {
    String email;
}
