package com.vijays.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.vijays.rewards.controllers.AppController;

// Rest Controller and GetMapping test

public class JUnitControllerTest {

	@Test
	public void testGetMapResponse() {
	    AppController appController = new AppController();
	    String result = appController.Home();
	    assertEquals(result, "Reward points calculation app");
    }

}
