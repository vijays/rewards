package com.vijays.rewards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijays.rewards.entities.Transaction;

public interface ITransactionRepo extends JpaRepository<Transaction, Integer> {

}
