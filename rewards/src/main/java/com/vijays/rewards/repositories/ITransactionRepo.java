package com.vijays.rewards.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vijays.rewards.entities.IpMonthlyRewards;
import com.vijays.rewards.entities.IpTotalRewards;
import com.vijays.rewards.entities.Transaction;

// Repo to work on Transaction data

@Repository
public interface ITransactionRepo extends JpaRepository<Transaction, Integer> {

	// Find month wise reward points for a specific customer id
	
	 @Query(value = "SELECT SUM(t.reward_points_transaction) reward_points, MONTH(t.date_transaction) reward_month FROM tbl_transaction t WHERE t.id_customer = :customerId GROUP BY reward_month",  nativeQuery=true)
	 List<IpMonthlyRewards> findMonthlyRewardsByCustomerId(@Param("customerId") int customerId);

	// Find total reward points for a specific customer id

	 @Query(value = "SELECT SUM(t.reward_points_transaction) reward_points_total FROM tbl_transaction AS t WHERE t.id_customer = :customerId",  nativeQuery=true)
	 List<IpTotalRewards> findTotalRewardsByCustomerId(@Param("customerId") int customerId);

}
