package com.jnguyen.rewards.rewardsprogram.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jnguyen.rewards.rewardsprogram.customer.Customer;
import com.jnguyen.rewards.rewardsprogram.product.Product;
import com.jnguyen.rewards.rewardsprogram.transaction.Transaction;
import com.jnguyen.rewards.rewardsprogram.transaction.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class RewardsServiceTest {

    @InjectMocks
    RewardsService underTest;

    @Mock
    TransactionRepository mockTransactionRepo;


    @Test
    public void getRewardsTest() {
        // Assign
        Transaction tx = createTestTransaction();
        tx.setProducts(createTestListOfProducts());
        List<Transaction> mockTransactions = Collections.singletonList(tx);
        when(mockTransactionRepo.findAll()).thenReturn(mockTransactions);

        // Act
        Map<Integer, UserRewardsDTO> userRewardsMap = underTest.getRewards();

        // Assert
        UserRewardsDTO userRewardsDTO = userRewardsMap.get(1);
        assertEquals(3370, userRewardsDTO.getTotalRewards());
    }

    @Test
    public void getCustomerRewards() {
        Transaction tx = createTestTransaction();
        tx.setProducts(createTestListOfProducts());
        when(mockTransactionRepo.findByCustomerId(any(Integer.class))).thenReturn(Collections.singletonList(tx));

        Rewards rewards = underTest.getCustomerRewards("1");

        assertEquals(3370, rewards.getRewards());
    }

    @Test
    public void getCustomerRewardsTxLessThan50() {
        Transaction tx = createTestTransaction();
        tx.setProducts(createTestListOfProducts2());
        when(mockTransactionRepo.findByCustomerId(any(Integer.class))).thenReturn(Collections.singletonList(tx));

        Rewards rewards = underTest.getCustomerRewards("1");

        assertEquals(0, rewards.getRewards());
    }

    @Test
    public void getCustomerRewardsTxBetween50And100() {
        Transaction tx = createTestTransaction();
        tx.setProducts(createTestListOfProducts3());
        when(mockTransactionRepo.findByCustomerId(any(Integer.class))).thenReturn(Collections.singletonList(tx));

        Rewards rewards = underTest.getCustomerRewards("1");

        assertEquals(10, rewards.getRewards());
    }

    @Test
    public void getCustomerRewardsTxAt100() {
        Transaction tx = createTestTransaction();
        tx.setProducts(createTestListOfProducts4());
        when(mockTransactionRepo.findByCustomerId(any(Integer.class))).thenReturn(Collections.singletonList(tx));

        Rewards rewards = underTest.getCustomerRewards("1");

        assertEquals(50, rewards.getRewards());
    }

    public Customer createTestCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setCustomerName("Jonathan Nguyen");
        return customer;
    }

    public Transaction createTestTransaction() {
        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setTransactionDate(LocalDate.now());
        transaction.setCustomer(createTestCustomer());

        return transaction;
    }

    public List<Product> createTestListOfProducts() {
        List<Product> testListOfProducts = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setProductName("PS5");
        p1.setProductPrice(BigDecimal.valueOf(599.99));

        Product p2 = new Product();
        p2.setId(2);
        p2.setProductName("LG C1 OLED TV");
        p2.setProductPrice(BigDecimal.valueOf(1099.99));

        Product p3 = new Product();
        p3.setId(3);
        p3.setProductName("Controllers");
        p3.setProductPrice(BigDecimal.valueOf(59.99));

        testListOfProducts.add(p1);
        testListOfProducts.add(p2);
        testListOfProducts.add(p3);

        return testListOfProducts;
    }

    public List<Product> createTestListOfProducts2() {
        List<Product> testListOfProducts = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setProductName("Fan");
        p1.setProductPrice(BigDecimal.valueOf(14.99));

        testListOfProducts.add(p1);

        return testListOfProducts;
    }

    // Represents transaction equaling
    public List<Product> createTestListOfProducts3() {
        List<Product> testListOfProducts = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setProductName("Fan");
        p1.setProductPrice(BigDecimal.valueOf(14.99));

        Product p2 = new Product();
        p2.setId(2);
        p2.setProductName("Fan");
        p2.setProductPrice(BigDecimal.valueOf(14.99));

        Product p3 = new Product();
        p3.setId(3);
        p3.setProductName("Fan");
        p3.setProductPrice(BigDecimal.valueOf(14.99));

        Product p4 = new Product();
        p4.setId(4);
        p4.setProductName("Fan");
        p4.setProductPrice(BigDecimal.valueOf(14.99));

        testListOfProducts.add(p1);
        testListOfProducts.add(p2);
        testListOfProducts.add(p3);
        testListOfProducts.add(p4);

        return testListOfProducts;
    }

    public List<Product> createTestListOfProducts4() {
        List<Product> testListOfProducts = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setProductName("NZXT H100");
        p1.setProductPrice(BigDecimal.valueOf(100));

        testListOfProducts.add(p1);

        return testListOfProducts;
    }
}
