package com.vijays.rewards;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vijays.rewards.entities.Transaction;
import com.vijays.rewards.repositories.ITransactionRepo;

@SpringBootApplication
public class RewardsApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}
	
	@Autowired
	ITransactionRepo transactionRepo ;	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Transaction> transactionList = new ArrayList<Transaction>() ;

		transactionList = transactionRepo.findAll() ;
		for (Transaction transaction:transactionList) {

			int rewardPoints = 0;
			int transactionAmount = transaction.getAmount_transaction();
			if (transactionAmount < 50) 
				rewardPoints = transactionAmount ;
			else
				rewardPoints = 50 + (transactionAmount - 50)*2 ;
			transaction.setReward_points_transaction(rewardPoints);
			
			transactionRepo.save(transaction) ;
		}		
		
	}

}
