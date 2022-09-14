package com.vijays.rewards.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/")
	public String Home() {
		return "Reward points calculation app" ;
	}

}
