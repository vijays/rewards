package com.vijays.rewards;

import com.vijays.rewards.entities.IpTotalRewards;

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
