package com.vijays.rewards.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijays.rewards.repositories.ITransactionRepo;

@Service
public class RewardsService implements IRewardsService {

	@Autowired
	ITransactionRepo transactionRepo ;	

	@Override
	public List<?> getMonthlyRewardsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getTotalRewardsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
