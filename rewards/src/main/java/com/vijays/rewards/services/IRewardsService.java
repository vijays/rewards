package com.vijays.rewards.services;

import java.util.List;

import com.vijays.rewards.entities.IpMonthlyRewards;
import com.vijays.rewards.entities.IpTotalRewards;

// Rewards service Interface to implement loose coupling

public interface IRewardsService {

	List<IpMonthlyRewards> getMonthlyRewardsByCustomerId(int customerId) ;
	List<IpTotalRewards> getTotalRewardsByCustomerId(int customerId) ;
}
