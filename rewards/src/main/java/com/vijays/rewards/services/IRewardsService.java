package com.vijays.rewards.services;

import java.util.List;

public interface IRewardsService {

	List<?> getMonthlyRewardsByCustomerId(int customerId) ;
	List<?> getTotalRewardsByCustomerId(int customerId) ;
}
