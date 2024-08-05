package com.application.Assginment.Service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Assginment.JPA.RewardPointsRepository;
import com.application.Assginment.JPA.TransactionRepositoryJpa;
import com.application.Assginment.JPA.UserJapRepostitry;
import com.application.Assginment.Service.RewardPointService;
import com.application.Assginment.model.RewardPoints;
import com.application.Assginment.model.Transaction;
import com.application.Assginment.model.User;


@Service(value = "RewardPointService")
public class RewardPointServiceImpl implements RewardPointService{

    @Autowired
    private UserJapRepostitry customerRepository;

    @Autowired
    private TransactionRepositoryJpa customerTransactionRepository;

    @Autowired
    private RewardPointsRepository rewardPointsRepository;
    
    @Override
	public Map<Long, Map<Month, Integer>> calculateRewards(Long customerId) {
		 List<Transaction> transactions = customerTransactionRepository.findAll();
	        Map<Long, Map<Month, Integer>> rewards = new HashMap<>();

	        for (Transaction transaction : transactions) {
	           // Long customerId = transaction.getCustomer().getId();
	            Month month = transaction.getDate().getMonth();
	            int points = calculatePoints(transaction.getAmount());

	            rewards.putIfAbsent(customerId, new HashMap<>());
	            Map<Month, Integer> monthlyRewards = rewards.get(customerId);
	            monthlyRewards.put(month, monthlyRewards.getOrDefault(month, 0) + points);
	        }

	        for (Map.Entry<Long, Map<Month, Integer>> entry : rewards.entrySet()) {
	            Long customerId1 = entry.getKey();
	            User customer = customerRepository.findById(customerId1).orElse(null);
	            for (Map.Entry<Month, Integer> monthlyEntry : entry.getValue().entrySet()) {
	                RewardPoints rewardPoints = new RewardPoints();
	                rewardPoints.setCustomer(customer);
	                rewardPoints.setMonth(monthlyEntry.getKey().getValue());
	                rewardPoints.setYear(LocalDate.now().getYear());
	                rewardPoints.setPoints(monthlyEntry.getValue());
	                rewardPointsRepository.save(rewardPoints);
	            }
	        }

	        return rewards;
	}


    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }
        if (amount > 50) {
            points += (amount - 50);
        }
        return points;
    }

	@Override
	public RewardPoints findByCustomer(User customer) {
		RewardPoints getRecord =rewardPointsRepository.findByCustomer(customer);
		return getRecord;
	}

	@Override
	public List<RewardPoints> getAllRewardPoints() {
		List<RewardPoints> getAllRecord = rewardPointsRepository.findAll();
		return getAllRecord;
	}

	
	
}
