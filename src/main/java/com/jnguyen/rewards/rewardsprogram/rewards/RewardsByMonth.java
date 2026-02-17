package com.jnguyen.rewards.rewardsprogram.rewards;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jnguyen.rewards.rewardsprogram.transaction.Transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardsByMonth {

    private List<Transaction> transactions;
    public RewardsByMonth() {
        this.transactions = new ArrayList<>();
    }

    @JsonProperty("rewardsOverMonth")
    public Integer getRewardsOverMonth() {
        Integer rewards = 0;
        for(Transaction tx : transactions) {
            rewards += tx.calculateReward();
        }
        return rewards;
    }
}
