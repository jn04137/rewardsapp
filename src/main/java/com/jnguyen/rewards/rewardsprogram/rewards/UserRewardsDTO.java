package com.jnguyen.rewards.rewardsprogram.rewards;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRewardsDTO {

    private Integer customerId;
    private String customerName;
    private Integer totalRewards;
}
