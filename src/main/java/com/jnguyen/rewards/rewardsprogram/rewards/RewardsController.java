package com.jnguyen.rewards.rewardsprogram.rewards;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @GetMapping("/rewards")
    public Map<Integer, UserRewardsDTO> getRewards() {
        return rewardsService.getRewards();
    }

    @GetMapping("/rewards/{customerId}")
    public Rewards getCustomerRewards(@PathVariable("customerId") String customerId) {
        return rewardsService.getCustomerRewards(customerId);
    }
}
