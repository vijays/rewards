package com.vijays.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vijays.rewards.controllers.AppController;
import com.vijays.rewards.entities.IpTotalRewards;
import com.vijays.rewards.services.RewardsService;

public class MockitoControllerServiceTest {

	// Dependency Injection lets Spring create Controller
	@InjectMocks
    private AppController appController ;

	// Mocking Rewards service which mocked controller calls
	@Mock
	private RewardsService rewardsService ;
	
	// Initializing before test run
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testControllerAndService() {

    	// Create object of interface projection
    	IpTotalRewards trp = new IpTotalRewardsImpTest() ;
    	
    	// Add data to object
    	trp.setreward_points_total(100);
  
    	// Create list of interface projection
    	List<IpTotalRewards> trpList = new ArrayList<>() ;
    	
    	// Add object with data to the list
    	trpList.add(trp) ;
    	
    	// When service is called return above mock data
    	when(rewardsService.getTotalRewardsByCustomerId(1)).thenReturn(trpList);

    	// Call service from AppController
    	List<IpTotalRewards> trList = appController.TotalRewardsByCustomerId(1);

    	// Verify service call was made
    	verify(rewardsService).getTotalRewardsByCustomerId(1) ;
 
		// Assert if returned value was of mock data
    	assertEquals(100, trList.get(0).getreward_points_total()) ;
    }
}
