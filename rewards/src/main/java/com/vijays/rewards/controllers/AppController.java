package com.vijays.rewards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vijays.rewards.entities.IpMonthlyRewards;
import com.vijays.rewards.entities.IpTotalRewards;
import com.vijays.rewards.services.RewardsService;

@RestController
public class AppController {

	public AppController() {
		super();
	}

	@Autowired
	RewardsService rewardsService;

	@GetMapping("/")
	public String Home() {
		return "Reward points calculation app" ;
	}

	@GetMapping("/customer/{customerId}")
	public List<IpMonthlyRewards> MonthlyRewardsByCustomerId(@PathVariable int customerId) {
		return rewardsService.getMonthlyRewardsByCustomerId(customerId) ;
	}

	@GetMapping("customer/{customerId}/total")
	public List<IpTotalRewards> TotalRewardsByCustomerId(@PathVariable int customerId) {
		return rewardsService.getTotalRewardsByCustomerId(customerId) ;
	}

}
