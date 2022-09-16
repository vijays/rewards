package com.vijays.rewards.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijays.rewards.entities.IpMonthlyRewards;
import com.vijays.rewards.entities.IpTotalRewards;
import com.vijays.rewards.exceptions.CustomerDataNotFoundException;
import com.vijays.rewards.services.RewardsService;

@RestController
@ResponseBody
public class AppController {

	public AppController() {
		super();
	}

	@Autowired
	RewardsService rewardsService;

	// Endpoints mapping and calls
	
	@GetMapping("/")
	public String Home() {
		return "Reward points calculation app" ;
	}

	// Get month wise rewards for a specific customer
	
	@GetMapping("/customer/{customerId}")
	public List<IpMonthlyRewards> MonthlyRewardsByCustomerId(@PathVariable int customerId) {
		
		List<IpMonthlyRewards> monthlyRewards = new ArrayList<IpMonthlyRewards>() ;
		
		monthlyRewards = rewardsService.getMonthlyRewardsByCustomerId(customerId) ;

		if (monthlyRewards.isEmpty()) {
			throw new CustomerDataNotFoundException("Customer data not found") ;
		}
		else {
			return monthlyRewards ;
		}
	}
	
	// Get total rewards for a specific customer

	@GetMapping("/customer/{customerId}/total")
	public List<IpTotalRewards> TotalRewardsByCustomerId(@PathVariable int customerId) {

		List<IpTotalRewards> totalRewards = new ArrayList<IpTotalRewards>() ;

		totalRewards = rewardsService.getTotalRewardsByCustomerId(customerId) ;
		
		
		if (totalRewards.get(0) == null) {
			throw new CustomerDataNotFoundException("Customer data not found") ;
		}
		else {
			return totalRewards ;
		}

	}
	
}
