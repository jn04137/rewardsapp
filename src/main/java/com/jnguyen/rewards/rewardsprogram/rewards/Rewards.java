package com.jnguyen.rewards.rewardsprogram.rewards;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

// This class was created to help organize the output of objects when
// json encoding
public class Rewards {

    // Using YearMonth to remove edge case of: same month/different year
    @Getter
    private Map<YearMonth, RewardsByMonth> rewardsByMonthMap;

    public Rewards() {
        this.rewardsByMonthMap = new HashMap<>();
    }

    public void addToRewardsByMonthMap(YearMonth yearMonth, RewardsByMonth rewardsByMonth) {
        this.rewardsByMonthMap.put(yearMonth, rewardsByMonth);
    }

    public RewardsByMonth getRewardsByMonthFromMap(YearMonth yearMonth) {
        return this.rewardsByMonthMap.get(yearMonth);
    }

    @JsonProperty("rewards")
    public Integer getRewards() {
        int totalRewards = 0;
        for(Map.Entry<YearMonth, RewardsByMonth> entry : rewardsByMonthMap.entrySet()) {
            totalRewards += entry.getValue().getRewardsOverMonth();
        }

        return totalRewards;
    }
}
