package com.jnguyen.rewards.rewardsprogram.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @InjectMocks
    TransactionController underTest;

    @Mock
    TransactionRepository mockTxRepo;

    @Test
    public void testGetTransactions() {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDate.MIN);
        when(mockTxRepo.findByCustomerId(any(Integer.class))).thenReturn(Collections.singletonList(transaction));

        List<Transaction> transactions = underTest.getCustomerTransactions("1");

        assertEquals(LocalDate.MIN, transactions.get(0).getTransactionDate());
    }
}
