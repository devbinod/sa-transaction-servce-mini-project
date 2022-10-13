package edu.miu.cs590.transactionservice.repository;

import edu.miu.cs590.transactionservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String > {

    Optional<Transaction> findByUuidAndUsername(String uuid,String username);
    List<Transaction> findAllByUsername(String username);

}
