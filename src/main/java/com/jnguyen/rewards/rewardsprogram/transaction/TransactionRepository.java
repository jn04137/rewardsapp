package com.jnguyen.rewards.rewardsprogram.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    public List<Transaction> findByCustomerId(Integer customerId);
}
