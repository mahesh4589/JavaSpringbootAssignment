package com.application.Assginment.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

import com.application.Assginment.dto.RewardPointsDto;
import com.application.Assginment.model.RewardPoints;
import com.application.Assginment.model.User;

public interface RewardPointService {

	RewardPoints findByCustomer(User customer);



	Map<Long, Map<Month, Integer>> calculateRewards(Long customerId);

	List<RewardPoints> getAllRewardPoints();

	

	

}
