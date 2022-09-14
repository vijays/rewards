package com.vijays.rewards;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vijays.rewards.controllers.AppController;

// Smoke test to check AppController is called and instantiated properly

@SpringBootTest
class RewardsApplicationTests {

	@Autowired
	private AppController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
