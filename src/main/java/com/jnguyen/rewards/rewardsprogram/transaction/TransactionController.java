package com.jnguyen.rewards.rewardsprogram.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepo;

    // Return a list of all Transactions
    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionRepo.findAll();
    }

    // Return list of transaction objects for the customerId passed
    @GetMapping("/transactions/{customerId}")
    public List<Transaction> getCustomerTransactions(@PathVariable("customerId") String customerId) {
        List<Transaction> transactions = transactionRepo.findByCustomerId(Integer.valueOf(customerId));
        return transactions;
    }
}
