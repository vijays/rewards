package com.vijays.rewards;

import com.vijays.rewards.entities.IpTotalRewards;

// Implementation of Interface Projection IpTotalRewards to Test using Mock data

public class IpTotalRewardsImpTest implements IpTotalRewards {

	Integer trp ;
	
	@Override
	public Integer getreward_points_total() {
 		return trp ;
	}

	@Override
	public void setreward_points_total(Integer trp) {
		this.trp = trp ;
	}

}
