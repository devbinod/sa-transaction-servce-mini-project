package edu.miu.cs590.transactionservice.exception;

public class TransactionNotFound extends RuntimeException{
    public TransactionNotFound(String message) {
        super(message);
    }
}
