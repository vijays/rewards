package com.vijays.rewards.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijays.rewards.repositories.ITransactionRepo;
import com.vijays.rewards.entities.IpMonthlyRewards;
import com.vijays.rewards.entities.IpTotalRewards;

// Services to return data to API calls

@Service
public class RewardsService implements IRewardsService {

	@Autowired
	ITransactionRepo transactionRepo ;	

	@Override
	public List<IpMonthlyRewards> getMonthlyRewardsByCustomerId(int customerId) {
		return transactionRepo.findMonthlyRewardsByCustomerId(customerId) ;
	}

	@Override
	public List<IpTotalRewards> getTotalRewardsByCustomerId(int customerId) {
		return transactionRepo.findTotalRewardsByCustomerId(customerId) ;
	}
}
