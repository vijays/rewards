package com.vijays.rewards;

import com.vijays.rewards.entities.IpTotalRewards;

// Implementation of Interface Projection IpTotalRewards to Test using Mock data

public class IpTotalRewardsImpTest implements IpTotalRewards {

	int trp ;
	
	@Override
	public int getreward_points_total() {
 		return trp ;
	}

	@Override
	public void setreward_points_total(int trp) {
		this.trp = trp ;
	}

}
