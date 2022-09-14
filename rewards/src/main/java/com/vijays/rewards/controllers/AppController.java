package com.vijays.rewards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijays.rewards.services.RewardsService;

@RestController
public class AppController {

	@Autowired
	RewardsService rewardsService;

	@GetMapping("/")
	public String Home() {
		return "Reward points calculation app" ;
	}

	@GetMapping("/customer/{d}")
	public String MonthlyRewardsByCustomerId() {
		return "" ;
	}

	@GetMapping("customer/{id}/total")
	public String TotalRewardsByCustomerId() {
		return "" ;
	}

}
