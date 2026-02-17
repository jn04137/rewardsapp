package com.jnguyen.rewards.rewardsprogram.transaction;

import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jnguyen.rewards.rewardsprogram.customer.Customer;
import com.jnguyen.rewards.rewardsprogram.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @ManyToMany
    @JoinTable(name="product_transaction")
    private List<Product> products;

    @ManyToOne
    private Customer customer;

    // This may not be the most optimal solution because the value is being generated
    // every time we need to get the total for a transaction. Storing total
    // of transaction total may be better in the future.
    @JsonProperty("total")
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for(Product product : this.products) {
            // BigDecimal is immutable and needs reassign after adding
            total = total.add(product.getProductPrice());
        }

        return total;
    }

    // Making assumption that we want to take the ceiling value of rewards when calculating
    @JsonProperty("reward")
    public int calculateReward() {
        // Again, this isn't the most optimal. Would be way better if total was a
        // retrievable value vs generated value.
        BigDecimal total = getTotal();
        int rewards = 0;

        if(total.compareTo(BigDecimal.valueOf(50.0)) == -1) {
            // If total is less than 50.0, return 0 for the transaction
            return rewards;

        } else if(total.compareTo(BigDecimal.valueOf(100.0)) >= 0) {

            // value is greater than 100
            // every dollar over 100 should be counted as two points
            double rawDoublePoints = total.subtract(BigDecimal.valueOf(100.00)).multiply(BigDecimal.TWO).doubleValue();
            double doublePointsCeil = Math.ceil(rawDoublePoints);

            // add 50 points for the dollar amount between 50 and 100
            rewards += doublePointsCeil + 50;
        } else if (total.compareTo(BigDecimal.valueOf(50.0)) > 0) {

            // if value is not 100 or greater, but greater than 50, then calculate the rewards from 50 to 100
            rewards += Math.ceil(total.subtract(BigDecimal.valueOf(50.0)).doubleValue());
        }

        return rewards;
    }
}
