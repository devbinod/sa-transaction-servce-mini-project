package edu.miu.cs590.transactionservice.controller;

import edu.miu.cs590.transactionservice.dto.TransactionDto;
import edu.miu.cs590.transactionservice.dto.TransactionRequestDto;
import edu.miu.cs590.transactionservice.dto.UpdateTransactionStatusDto;
import edu.miu.cs590.transactionservice.enums.TransactionStatus;
import edu.miu.cs590.transactionservice.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {


    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid TransactionRequestDto transactionDto) {
        try {
            return ResponseEntity.ok().body(transactionService.save(transactionDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }

    }


    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@PathVariable String uuid, @RequestBody @Valid TransactionRequestDto transactionDto) {

        try {
            transactionDto.setUuid(uuid);
            return ResponseEntity.ok().body(transactionService.update(transactionDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }


    }


    @GetMapping("/users")
    public ResponseEntity<?> findAllByUser() {

        try {
            return ResponseEntity.ok().body(transactionService.findAllByUser());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<?> findById(@PathVariable String uuid) {

        try {
            return ResponseEntity.ok().body(transactionService.findById(uuid));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());

        }
    }


    @PutMapping("/{id}/update-status")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody @Valid UpdateTransactionStatusDto transactionStatusDto) {
        try {
            return ResponseEntity.ok().body(transactionService.updateStatus(id, transactionStatusDto.getStatus()));

        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());

        }
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<? extends Object> deleteTransaction(@PathVariable String id) {
        try {
            transactionService.deleteTransaction(id);
            return ResponseEntity.ok().body("Successfully deleted");

        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());

        }
    }
}
