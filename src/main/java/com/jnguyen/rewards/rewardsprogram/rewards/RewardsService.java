package com.jnguyen.rewards.rewardsprogram.rewards;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnguyen.rewards.rewardsprogram.transaction.Transaction;
import com.jnguyen.rewards.rewardsprogram.transaction.TransactionRepository;

@Service
public class RewardsService {

    @Autowired
    private TransactionRepository transactionRepo;

    public Map<Integer, UserRewardsDTO> getRewards() {
        List<Transaction> transactions = transactionRepo.findAll();
        LocalDate currentDate = LocalDate.now();
        HashSet<YearMonth> yearMonthSet = new HashSet<>();

        for(int monthOffset = 0; monthOffset < 3; monthOffset++) {
            yearMonthSet.add(YearMonth.from(currentDate.minusMonths(monthOffset)));
        }

        Map<Integer, UserRewardsDTO> userRewardsMap = new HashMap<>();

        for(Transaction tx : transactions){
            if(!yearMonthSet.contains(YearMonth.from(tx.getTransactionDate()))) {
                // Skip if transaction is outside of last three months
                continue;
            }

            Integer customerId = tx.getCustomer().getId();
            UserRewardsDTO userRewards = userRewardsMap.get(customerId);
            if(Objects.isNull(userRewards)) {
                userRewards = new UserRewardsDTO();
                userRewards.setCustomerId(tx.getId());
                userRewards.setCustomerName(tx.getCustomer().getCustomerName());
                userRewards.setTotalRewards(tx.calculateReward());
                userRewardsMap.put(customerId, userRewards);
            } else {
                userRewards.setTotalRewards(userRewards.getTotalRewards() + tx.calculateReward());
            }
        }

        return userRewardsMap;
    }

    public Rewards getCustomerRewards(String customerId) {
        List<Transaction> transactions = transactionRepo.findByCustomerId(Integer.valueOf(customerId));

        Rewards rewards = new Rewards();

        // Last three months
        LocalDate currentDate = LocalDate.now();
        for(int i = 0; i < 3; i++) {
            rewards.addToRewardsByMonthMap(YearMonth.from(currentDate.minusMonths(i)), new RewardsByMonth());
        }

        for(Transaction tx : transactions) {
            RewardsByMonth rewardsInMonth = rewards.getRewardsByMonthFromMap(YearMonth.from(tx.getTransactionDate()));
            if(rewardsInMonth == null) {
                continue;
            }

            rewardsInMonth.getTransactions().add(tx);
        }

        return rewards;
    }
}
